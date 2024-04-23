package com.foodtruck.foodtruck.util;

import com.foodtruck.foodtruck.domain.MobileFoodFacilityPermit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Slf4j
@Service
public class MobileFoodFacilityPermitParser {

    private static final String HEADER_LOCATION_ID = "locationid";
    private static final String HEADER_APPLICANT = "Applicant";
    private static final String HEADER_FACILITY_TYPE = "FacilityType";
    private static final String HEADER_CNN = "cnn";
    private static final String HEADER_LOCATION_DESC = "LocationDescription";
    private static final String HEADER_ADDRESS = "Address";
    private static final String HEADER_BLOCK_LOT = "blocklot";
    private static final String HEADER_BLOCK = "block";
    private static final String HEADER_LOT = "lot";
    private static final String HEADER_PERMIT = "permit";
    private static final String HEADER_STATUS = "Status";
    private static final String HEADER_FOOD_ITEMS = "FoodItems";

    private static final String[] CSV_HEADERS = {
            HEADER_LOCATION_ID, HEADER_APPLICANT, HEADER_FACILITY_TYPE, HEADER_CNN, HEADER_LOCATION_DESC,
            HEADER_ADDRESS, HEADER_BLOCK_LOT, HEADER_BLOCK, HEADER_LOT, HEADER_PERMIT,
            HEADER_STATUS, HEADER_FOOD_ITEMS
    };

    public List<MobileFoodFacilityPermit> readCsvSource(InputStream is) {



        List<MobileFoodFacilityPermit> permits = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader(CSV_HEADERS)
                    .setSkipHeaderRecord(true)
                    .build();

            Iterable<CSVRecord> records = csvFormat.parse(reader);

            for (CSVRecord csvRecord : records) {
                Integer locationId = Integer.parseInt(csvRecord.get(HEADER_LOCATION_ID));
                String applicant = csvRecord.get(HEADER_APPLICANT);
                String facilityType = csvRecord.get(HEADER_FACILITY_TYPE);
                String cnn = csvRecord.get(HEADER_CNN);
                String locationDesc = csvRecord.get(HEADER_LOCATION_DESC);
                String address = csvRecord.get(HEADER_ADDRESS);
                String blockLot = csvRecord.get(HEADER_BLOCK_LOT);
                String block = csvRecord.get(HEADER_BLOCK);
                String lot = csvRecord.get(HEADER_LOT);
                String permit = csvRecord.get(HEADER_PERMIT);
                String status = csvRecord.get(HEADER_STATUS);
                String foodItems = csvRecord.get(HEADER_FOOD_ITEMS);

                MobileFoodFacilityPermit mobileFoodFacilityPermit = new MobileFoodFacilityPermit();
                mobileFoodFacilityPermit.setLocationId(locationId);
                mobileFoodFacilityPermit.setApplicant(applicant);
                mobileFoodFacilityPermit.setFacilityType(facilityType);
                mobileFoodFacilityPermit.setCnn(cnn);
                mobileFoodFacilityPermit.setLocationDescription(locationDesc);
                mobileFoodFacilityPermit.setAddress(address);
                mobileFoodFacilityPermit.setBlockLot(blockLot);
                mobileFoodFacilityPermit.setBlock(block);
                mobileFoodFacilityPermit.setLot(lot);
                mobileFoodFacilityPermit.setPermit(permit);
                mobileFoodFacilityPermit.setStatus(status);
                mobileFoodFacilityPermit.setFoodItems(foodItems);

                permits.add(mobileFoodFacilityPermit);
            }

        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new IllegalStateException(e);
        }

        return permits;
    }

}
