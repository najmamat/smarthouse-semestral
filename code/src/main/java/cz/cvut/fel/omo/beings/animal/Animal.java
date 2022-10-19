package cz.cvut.fel.omo.beings.animal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import cz.cvut.fel.omo.beings.Being;
import cz.cvut.fel.omo.beings.PersonalInfo;
import lombok.NoArgsConstructor;

/**
 * Class representing an Animal being inside the simulation
 */
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonIgnoreProperties({"duties, duty"})
public class Animal extends Being {

    private AnimalInfo personalInfo;

    public Animal(String name, int age, AnimalType type, String breed) {
        this.createPersonalInfo();
        personalInfo.setName(name);
        personalInfo.setAge(age);
        personalInfo.setType(type);
        personalInfo.setBreed(breed);
        personalInfo.setAlive(true);
    }

    @Override
    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    @Override
    protected void createPersonalInfo() {
        personalInfo = new AnimalInfo();
    }

    @Override
    public String toString() {
        return personalInfo.getName();
    }
}
