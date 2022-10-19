package cz.cvut.fel.omo.beings.human;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import cz.cvut.fel.omo.action.Duty;
import cz.cvut.fel.omo.beings.Being;
import cz.cvut.fel.omo.beings.PersonalInfo;
import cz.cvut.fel.omo.events.BrokenItemEvent;
import cz.cvut.fel.omo.events.Event;
import cz.cvut.fel.omo.items.HouseItem;
import cz.cvut.fel.omo.items.device.Device;
import cz.cvut.fel.omo.observer.Observer;
import lombok.NoArgsConstructor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Class representing a Human being inside the simulation
 */
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonIgnoreProperties({"duties"})
public class Human extends Being implements Observer {

    private HumanInfo personalInfo;
    private final Random random = new Random();

    public Human(String firstName, String lastName, int age) {
        this.createPersonalInfo();
        personalInfo.setFirstName(firstName);
        personalInfo.setLastName(lastName);
        personalInfo.setAge(age);
        personalInfo.setAlive(true);
        decideType();
    }

    /**
     * Decides Being's type based on its age
     */
    private void decideType() {
        if (personalInfo.getAge() <= 3)
            personalInfo.setType(HumanType.BABY);
        else if (personalInfo.getAge() <= 18)
            personalInfo.setType(HumanType.CHILD);
        else if (personalInfo.getAge() <= 65)
            personalInfo.setType(HumanType.ADULT);
        else
            personalInfo.setType(HumanType.ELDER);
    }

    @Override
    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    @Override
    protected void createPersonalInfo() {
        personalInfo = new HumanInfo();
    }

    /**
     * Fixes a broken device
     * @return how many iterations will it take to fix the device
     */
    public int fix(HouseItem item) {
        String manual;
        if (item instanceof Device)
            manual = ((Device) item).getManual();
        if (personalInfo.getType() == HumanType.CHILD)
            return 20 - personalInfo.getAge();
        if (personalInfo.getType() == HumanType.ADULT)
            return random.nextInt(10);
        if (personalInfo.getType() == HumanType.ELDER)
            return random.nextInt(20);
        else
            return 1000;
    }

    @Override
    public void update(Event event) throws IOException {
        process(event);
        log(event);
    }

    @Override
    public void process(Event event) {
        if (event instanceof BrokenItemEvent) {
            Device item = ((BrokenItemEvent) event).getItem();
            Duty duty = new Duty(this, item, fix(item));
            getDuties().add(duty);
        }
    }

    @Override
    public void log(Event event) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("EventReport.txt", true));
        writer.append(this.toString()).append(" got message ").append(event.getCause()).append(" from ").append(event.getSource()).append("\n");
        writer.close();
    }

    @Override
    public String toString() {
        return personalInfo.getFirstName() + " " + personalInfo.getLastName();
    }
}
