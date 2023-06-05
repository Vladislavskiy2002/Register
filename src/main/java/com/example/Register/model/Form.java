package com.example.Register.model;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class Form {
    @Size(min = 3, message = "owner name must be min 3 symb")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must be only alph symb")
    private String ownerName;
    @Size(min = 3, message = "owner surname must be min 3 symb")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Surname must be only alph symb")
    private String ownerSurname;
    @DecimalMin(value = "1", message = "owner number of rooms must be min 1")
    private Integer ownerNumberOfRooms;
    @Min(value = 10, message = "owner area must be min 10")
    private Integer ownerArea;
    @Min(value = 1, message = "owner floor must be min 1")
    private Integer ownerFloor;
    @Size(min = 3, message = "owner district must have min 3 symb")
    private String ownerDistrict;
    @Min(value = 1, message = "order number of rooms must be min 1")
    private Integer orderNumberOfRooms;
    @Min(value = 10, message = "owner area must be min 10")
    private Integer orderArea;
    @Min(value = 1, message = "owner floor must be min 1")
    private Integer orderFloor;
    @Size(min = 3, message = "owner district must have min 3 symb")
    private String orderDistrict;
}
