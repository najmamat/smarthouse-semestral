package cz.cvut.fel.omo.items;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import cz.cvut.fel.omo.items.device.Device;
import cz.cvut.fel.omo.items.sportitem.SportItem;

@JsonSubTypes({
        @JsonSubTypes.Type(value = Device.class, name = "Device"),
        @JsonSubTypes.Type(value = SportItem.class, name = "SportItem")
})
public interface HouseItem {

    String getName();

    void getFixed();

    boolean isBroken();

}
