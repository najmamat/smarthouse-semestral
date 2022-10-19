package cz.cvut.fel.omo.reports;

import cz.cvut.fel.omo.house.House;
import cz.cvut.fel.omo.items.device.Device;
import cz.cvut.fel.omo.items.device.DeviceAPI;
import cz.cvut.fel.omo.statsvisitor.PSVisitor;
import cz.cvut.fel.omo.statsvisitor.StatsVisitor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Class for creating consumption reports
 */
public class ConsumptionReport {

    /**
     * Generates consumption report
     *
     * @param house from which the report is created
     * @throws IOException if writer can't write to EventReport
     */
    public static void generate(House house) throws IOException {
        List<Device> devices = house.getDevices();
        BufferedWriter writer = new BufferedWriter(new FileWriter("consumption.txt", false));
        Integer totalConsumption = 0;
        StatsVisitor visitor = new PSVisitor();
        for (Device device : devices) {
            Integer consumption = visitor.visitDevice(device);
            totalConsumption += consumption;
            writer.append(device.getName()).append(": ").append(consumption.toString()).append("\n");
        }
        writer.append("TOTAL CONSUMPTION: ").append(totalConsumption.toString()).append("\n");
        writer.close();
    }
}
