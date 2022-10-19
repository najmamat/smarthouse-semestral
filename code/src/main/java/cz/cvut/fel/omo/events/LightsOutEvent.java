package cz.cvut.fel.omo.events;

public class LightsOutEvent extends Event {

    public LightsOutEvent(String source, String cause) {
        super(source, cause);
    }
}
