package com.foodtruck.foodtruck.service;

import com.foodtruck.foodtruck.domain.MobileFoodFacilityPermit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MobileFoodFacilityPermitService {

    public List<MobileFoodFacilityPermit> filterByFacilityTypeAndFoodItems(List<MobileFoodFacilityPermit> source,
                                                                           String facilityType, String foodItems) {

        List<MobileFoodFacilityPermit> resultList = source.stream()
                .filter(item -> facilityType.equals(item.getFacilityType()))
                .filter(item -> item.getFoodItems().contains(foodItems))
                .toList();

        return resultList;
    }
}
