package com.example.Register.model;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class Form {
    @Pattern(regexp = "^[a-zA-Z]{3,}$", message = "Name must be only alph symb and be min 3 symb")
    private String ownerName;
    @Pattern(regexp = "^[a-zA-Z]{3,}$", message = "Surname must be only alph symb and be min 3 symb")
    private String ownerSurname;
    @Pattern(regexp = "^(?:[1-9][0-9]*|1)$", message = "owner number of rooms must be num and be minimum 1")
    private String ownerNumberOfRooms;
    @Pattern(regexp = "^(?:[1-9][0-9]+|10)$", message = "owner area must be num and be minimum 10")
    private String ownerArea;
    @Pattern(regexp = "^(?:[1-9][0-9]*|1)$", message = "owner floor must be num and be minimum 1")
    private String ownerFloor;
    @Pattern(regexp = "^[a-zA-Z]{3,}$", message = "owner district must be only alph symb and be min 3 symb")
    private String ownerDistrict;
    @Pattern(regexp = "^(?:[1-9][0-9]*|1)$", message = "order number of rooms must be num and be minimum 1")
    private String orderNumberOfRooms;
    @Pattern(regexp = "^(?:[1-9][0-9]+|10)$", message = "order area must be num and be minimum 10")
    private String orderArea;
    @Pattern(regexp = "^(?:[1-9][0-9]*|1)$", message = "order floor must be num and be minimum 1")
    private String orderFloor;
    @Pattern(regexp = "^[a-zA-Z]{3,}$", message = "order district must be only alph symb and be min 3 symb")
    private String orderDistrict;
}
