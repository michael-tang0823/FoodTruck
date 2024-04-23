package com.foodtruck.foodtruck.domain;


import lombok.Data;

@Data
public class MobileFoodFacilityPermit {

    private Integer locationId;

    private String applicant;

    private String facilityType;

    private String cnn;

    private String locationDescription;

    private String address;

    private String blockLot;

    private String block;

    private String lot;

    private String permit;

    private String Status;

    private String foodItems;

}
