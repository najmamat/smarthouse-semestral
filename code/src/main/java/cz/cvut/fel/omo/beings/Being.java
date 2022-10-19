package cz.cvut.fel.omo.beings;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import cz.cvut.fel.omo.action.Duty;
import cz.cvut.fel.omo.beings.animal.Animal;
import cz.cvut.fel.omo.beings.human.Human;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for all living beings inside the simulation
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Human.class, name = "Human"),
        @JsonSubTypes.Type(value = Animal.class, name = "Animal")
})
public abstract class Being {

    private List<Duty> duties = new ArrayList<>();

    /**
     * @return personal information of a being
     */
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
    public abstract PersonalInfo getPersonalInfo();

    protected abstract void createPersonalInfo();

    /**
     * method simulating aging for living beings
     */
    public void age() {
        this.getPersonalInfo().age();
    }

    /**
     * @return first duty from duties assigned to a being
     */
    public Duty getFirstDuty() {
        if (duties.isEmpty())
            return null;
        return duties.remove(0);
    }

    /**
     * @return all duties assigned to a being
     */
    public List<Duty> getDuties() {
        return duties;
    }

    /**
     * @return true, if a beings has some duties assigned to it
     */
    public boolean hasDuties() {
        return !duties.isEmpty();
    }
}
