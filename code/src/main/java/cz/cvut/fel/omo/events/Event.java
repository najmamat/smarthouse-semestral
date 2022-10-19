package cz.cvut.fel.omo.events;

/**
 * Class representing an Event in the simulation, is keeping information about its source and cause
 */
public class Event {

    private String source;
    private String cause;

    /**
     * @param source is Room, where the Event happened
     * @param cause is a reason, why the Event occurred
     */
    public Event(String source, String cause) {
        this.source = source;
        this.cause = cause;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
