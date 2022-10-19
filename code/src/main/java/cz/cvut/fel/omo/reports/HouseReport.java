package cz.cvut.fel.omo.reports;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cvut.fel.omo.house.House;

import java.io.File;
import java.io.IOException;

public class HouseReport {

    /**
     * Generates house configuration report
     * @param house from which the report is created
     * @param fileName specifies where to save the report
     * @throws IOException if writer can't write to EventReport
     */
    public static void generate(House house, String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(fileName), house);
    }
}
