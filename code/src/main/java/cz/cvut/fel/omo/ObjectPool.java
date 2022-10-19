package cz.cvut.fel.omo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class implementing generic Object pool
 * @param <T> type of object
 */
public class ObjectPool<T> {

    private final List<T> locked = new ArrayList<>();
    private final List<T> unlocked = new ArrayList<>();

    public ObjectPool(List<T> list) {
        unlocked.addAll(list);
    }

    /**
     * Adds new object to object pool
     * @param item object to be added
     */
    public void add(T item) {
        unlocked.add(item);
    }

    /**
     * Removes object from object pool if not in use
     * @param item object to be removed
     */
    public void remove(T item) {
        unlocked.remove(item);
    }

    /**
     * @return true if object pool has unlocked objects
     */
    public boolean hasUnlocked() {
        return !unlocked.isEmpty();
    }

    /**
     * @param item to check, if it's used
     * @return true if object is locked
     */
    public boolean isUsed(T item) {
        return locked.contains(item);
    }

    /**
     * @return first unlocked object from object pool
     */
    public T lockFirst() {
        if (unlocked.isEmpty())
            return null;
        else {
            T tmp = unlocked.get(0);
            unlocked.remove(tmp);
            locked.add(tmp);
            return tmp;
        }
    }

    /**
     * Locks the given item
     * @param item to be locked
     */
    public void lockItem(T item) {
        if (unlocked.contains(item)) {
            unlocked.remove(item);
            locked.add(item);
        }
    }

    /**
     * @return random unlocked object from object pool
     */
    public T lockRandom() {
        if (unlocked.isEmpty())
            return null;
        else {
            Random random = new Random();
            T tmp = unlocked.get(random.nextInt(unlocked.size()));
            unlocked.remove(tmp);
            locked.add(tmp);
            return tmp;
        }
    }

    /**
     * Return object to object pool after use
     * @param item object to be unlocked
     */
    public void unlock(T item) {
        locked.remove(item);
        unlocked.add(item);
    }

    public int getUnlockedSize() {
        return unlocked.size();
    }

    /**
     * @return all items (locked or unlocked from object pool)
     */
    public List<T> getAllItems() {
        List<T> tmp = new ArrayList<>(locked);
        tmp.addAll(unlocked);
        return tmp;
    }
}
