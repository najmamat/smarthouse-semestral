package cz.cvut.fel.omo.beings.animal;

import cz.cvut.fel.omo.beings.PersonalInfo;

import java.util.Random;

/**
 * Class containing further information about an Animal
 */
public class AnimalInfo implements PersonalInfo {

    private String name;
    private int age;
    private AnimalType type;
    private String breed;
    private boolean alive;

    @Override
    public void age() {
        this.age++;

        if (this.age >= 10) {
            Random random = new Random();
            int chanceOfDeath = random.nextInt(age) - 7;
            if (chanceOfDeath > 0)
                this.die();
        }
    }

    @Override
    public void die() {
        this.alive = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "AnimalInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", type=" + type +
                ", breed='" + breed + '\'' +
                ", alive=" + alive +
                '}';
    }
}
