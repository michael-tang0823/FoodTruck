package com.foodtruck.foodtruck.util;

import com.foodtruck.foodtruck.domain.MobileFoodFacilityPermit;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MobileFoodFacilityPermitParserTest {

    @Resource
    MobileFoodFacilityPermitParser parser;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void readCsvSource() {
        List<MobileFoodFacilityPermit> mobileFoodFacilityPermits = parser.readCsvSource(Thread.currentThread().getContextClassLoader().getResourceAsStream("samples/Mobile_Food_Facility_Permit.csv"));
        assertThat(mobileFoodFacilityPermits.size()).isEqualTo(481);
    }
}