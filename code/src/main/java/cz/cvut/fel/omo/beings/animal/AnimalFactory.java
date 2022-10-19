package cz.cvut.fel.omo.beings.animal;

/**
 * Singleton factory
 */
public class AnimalFactory {

    private static AnimalFactory instance = null;

    private AnimalFactory() {
    }

    public synchronized static AnimalFactory getInstance() {
        if (instance == null) {
            synchronized (AnimalFactory.class) {
                instance = new AnimalFactory();
            }
        }
        return instance;
    }

    public Animal createAnimal(String name, int age, AnimalType type, String breed) {
        return new Animal(name, age, type, breed);
    }
}
