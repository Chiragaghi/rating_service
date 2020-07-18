package com.example.RatingSystem.enums;

public enum RatedBy {

    CUSTOMER("customer"), DRIVER("driver");

    String name;

    RatedBy(String value) {
        name = value;
    }

    String getName() {
        return name;
    }

}

