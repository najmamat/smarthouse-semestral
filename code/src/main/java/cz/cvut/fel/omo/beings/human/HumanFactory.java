package cz.cvut.fel.omo.beings.human;

/**
 * Singleton factory
 */
public class HumanFactory {

    private static HumanFactory instance = null;

    private HumanFactory() {
    }

    public synchronized static HumanFactory getInstance() {
        if (instance == null) {
            synchronized (HumanFactory.class) {
                instance = new HumanFactory();
            }
        }
        return instance;
    }

    public Human createHuman(String firstName, String lastName, int age) {
        return new Human(firstName, lastName, age);
    }
}
