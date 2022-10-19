package cz.cvut.fel.omo.items.sportitem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import cz.cvut.fel.omo.beings.human.Human;
import cz.cvut.fel.omo.items.HouseItem;

/**
 * Abstract class representing sport equipment and it basic usage.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonIgnoreProperties({"isBroken, isUsed, currUser"})
@JsonSubTypes({
        @JsonSubTypes.Type(value = Bicycle.class, name = "Bicycle"),
        @JsonSubTypes.Type(value = Skis.class, name = "Ski")
})
public abstract class SportItem implements HouseItem {

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
    private final String name;
    private boolean isBroken;
    private boolean isUsed;
    private Human currUser;

    public SportItem(String name) {
        this.name = name;
    }

    public void use(){
        this.setUsed(true);
    }

    public void stopUsing(){
        this.setUsed(false);
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public Human getCurrUser() {
        return currUser;
    }

    public void setCurrUser(Human currUser) {
        this.currUser = currUser;
    }
}
