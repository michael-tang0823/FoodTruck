package com.foodtruck.foodtruck;

import com.foodtruck.foodtruck.domain.MobileFoodFacilityPermit;
import com.foodtruck.foodtruck.service.MobileFoodFacilityPermitService;
import com.foodtruck.foodtruck.util.MobileFoodFacilityPermitParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;

@SpringBootApplication
@Slf4j
public class FoodTruckApplication implements CommandLineRunner, ApplicationContextAware {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(FoodTruckApplication.class, args);
    }

    @Override
    public void run(String... args) {

        MobileFoodFacilityPermitParser parser = applicationContext.getBean(MobileFoodFacilityPermitParser.class);
        MobileFoodFacilityPermitService permitService = applicationContext.getBean(MobileFoodFacilityPermitService.class);

        List<MobileFoodFacilityPermit> mobileFoodFacilityPermits = parser.readCsvSource(Thread.currentThread().getContextClassLoader().getResourceAsStream("samples/Mobile_Food_Facility_Permit.csv"));
        List<MobileFoodFacilityPermit> resultList = permitService.filterByFacilityTypeAndFoodItems(mobileFoodFacilityPermits, "Truck", "taco");

        for (MobileFoodFacilityPermit permit: resultList) {
            log.info(permit.getFacilityType() + " " + permit.getFoodItems());
        }


    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
