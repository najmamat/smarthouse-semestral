package cz.cvut.fel.omo.beings.human;

import cz.cvut.fel.omo.beings.PersonalInfo;

import java.util.Random;

/**
 * Class containing further information about a Human
 */
public class HumanInfo implements PersonalInfo {

    private String firstName;
    private String lastName;
    private int age = 0;
    private HumanType type;
    private boolean alive;

    @Override
    public void age() {
        this.age++;

        if (this.type == HumanType.ELDER) {
            Random random = new Random();
            int chanceOfDeath = random.nextInt(age) - 50;
            if (chanceOfDeath > 0)
                this.die();
        }
    }

    @Override
    public void die() {
        this.alive = false;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        for (int i = 0; i < age; i++) {
            this.age();
        }
    }

    public HumanType getType() {
        return type;
    }

    public void setType(HumanType type) {
        this.type = type;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "HumanInfo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", type=" + type +
                ", alive=" + alive +
                '}';
    }
}
