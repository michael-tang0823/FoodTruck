package com.foodtruck.foodtruck.service;

import com.foodtruck.foodtruck.domain.MobileFoodFacilityPermit;
import com.foodtruck.foodtruck.util.MobileFoodFacilityPermitParser;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MobileFoodFacilityPermitServiceTest {
    @Resource
    MobileFoodFacilityPermitParser parser;

    @Resource
    MobileFoodFacilityPermitService permitService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void filterByFacilityType() {
        List<MobileFoodFacilityPermit> mobileFoodFacilityPermits = parser.readCsvSource(Thread.currentThread().getContextClassLoader().getResourceAsStream("samples/Mobile_Food_Facility_Permit.csv"));
        List<MobileFoodFacilityPermit> resultList = permitService.filterByFacilityTypeAndFoodItems(mobileFoodFacilityPermits, "Truck", "taco");
        assertThat(resultList).isNotEmpty();
        assertThat(resultList).allSatisfy(element -> assertThat(element.getFacilityType()).isEqualTo("Truck"));
        assertThat(resultList).allSatisfy(element -> assertThat(element.getFoodItems()).contains("taco"));

    }
}