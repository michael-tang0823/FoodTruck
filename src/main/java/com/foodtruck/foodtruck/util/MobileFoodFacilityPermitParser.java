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

    public List<MobileFoodFacilityPermit> readCsvSource(InputStream is) {

        String[] HEADERS = {
                HEADER_LOCATION_ID, HEADER_APPLICANT, HEADER_FACILITY_TYPE, HEADER_CNN, HEADER_LOCATION_DESC,
                HEADER_ADDRESS, HEADER_BLOCK_LOT, HEADER_BLOCK, HEADER_LOT, HEADER_PERMIT,
                HEADER_STATUS, HEADER_FOOD_ITEMS
        };

        List<MobileFoodFacilityPermit> permits = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader(HEADERS)
                    .setSkipHeaderRecord(true)
                    .build();

            Iterable<CSVRecord> records = csvFormat.parse(reader);

            for (CSVRecord record : records) {
                Integer locationId = Integer.parseInt(record.get(HEADER_LOCATION_ID));
                String applicant = record.get(HEADER_APPLICANT);
                String facilityType = record.get(HEADER_FACILITY_TYPE);
                String cnn = record.get(HEADER_CNN);
                String locationDesc = record.get(HEADER_LOCATION_DESC);
                String address = record.get(HEADER_ADDRESS);
                String blockLot = record.get(HEADER_BLOCK_LOT);
                String block = record.get(HEADER_BLOCK);
                String lot = record.get(HEADER_LOT);
                String permit = record.get(HEADER_PERMIT);
                String status = record.get(HEADER_STATUS);
                String foodItems = record.get(HEADER_FOOD_ITEMS);

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
