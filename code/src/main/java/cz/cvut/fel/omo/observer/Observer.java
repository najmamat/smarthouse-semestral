package cz.cvut.fel.omo.observer;

import cz.cvut.fel.omo.events.Event;

import java.io.IOException;

/**
 * Abstract class for observer
 */
public interface Observer {

    /**
     * Processes the event and logs it
     * @param event event to be processed
     * @throws IOException if writer can't write to EventReport
     */
    void update(Event event) throws IOException;

    /**
     * Processes event
     * @param event event to be processed
     */
    void process(Event event);

    /**
     * Logs event to event log
     * @param event event to be logged
     * @throws IOException if writer can't write to EventReport
     */
    void log(Event event) throws IOException;
}
