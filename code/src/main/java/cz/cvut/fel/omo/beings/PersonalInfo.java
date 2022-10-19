package cz.cvut.fel.omo.beings;

/**
 * Interface for living beings
 */
public interface PersonalInfo {

    /**
     * makes object older
     */
    void age();

    /**
     * sets object's attribute alive to false, making it dead to the simulation
     */
    void die();
}
