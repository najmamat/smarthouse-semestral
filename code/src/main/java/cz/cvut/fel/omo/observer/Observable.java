package cz.cvut.fel.omo.observer;

import cz.cvut.fel.omo.events.Event;

/**
 * Interface for observable objects
 */
public interface Observable {

    /**
     * Registers new observer
     * @param observer observer to be registered
     */
    void register(Observer observer);

    /**
     * Unregisters given observer
     * @param observer Observer to be removed
     */
    void unregister(Observer observer);

    /**
     * Updates all registered observers
     * @param event event to be notified with
     */
    void notifyAll(Event event);

}
