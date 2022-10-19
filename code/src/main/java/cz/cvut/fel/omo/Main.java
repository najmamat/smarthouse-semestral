package cz.cvut.fel.omo;

import cz.cvut.fel.omo.action.Action;
import cz.cvut.fel.omo.beings.Being;
import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.house.Room;
import cz.cvut.fel.omo.items.HouseItem;
import cz.cvut.fel.omo.reports.ConsumptionReport;
import cz.cvut.fel.omo.reports.HouseReport;

/**
 * Main class of the whole project, has method for running the simulation
 * @author Matouš najman (najmama3), Jan Pivoňka (pivonja1)
 */
public class Main {

    private static final int ITERATIONS = 200;
    private static final String CONFIGURATION = "houseConfig.json";

    public static void main(String[] args) {
        House house = load();
        if (house == null) {
            System.out.println("Failed to load house configuration!");
        } else {
            simulate(house);
            generateHouseReport(house);
            generateActionsReport();
            generateConsumptionReport(house);
        }
    }

    private static House load() {
        try {
            return House.loadFromJson(Main.CONFIGURATION);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void simulate(House house) {
        Simulation simulation = new Simulation(house);
        for (int i = 0; i < ITERATIONS; i++) {
            System.out.println("___________________________[STEP " + i + "]___________________________");
            simulation.iterate();
            System.out.println();
            System.out.println();
        }
    }

    private static void generateHouseReport(House house) {
        try {
            HouseReport.generate(house, CONFIGURATION);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void generateActionsReport() {
        try {
            Action.export();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void generateConsumptionReport(House house) {
        try {
            ConsumptionReport.generate(house);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
