package com.example.Register.model;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class Form {
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must be only alph symb")
    private String ownerName;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Surname must be only alph symb")
    private String ownerSurname;
    @DecimalMin(value = "1", message = "owner number of rooms must be min 1")
    @NotNull(message = "orderNumberOfRooms must be fill")
    private Integer ownerNumberOfRooms;
    @DecimalMin(value = "10", message = "owner area must be min 10")
    @NotNull(message = "ownerArea must be fill")
    private Integer ownerArea;
    @Min(value = 1, message = "owner floor must be min 1")
    @NotNull(message = "ownerFloor must be fill")
    private Integer ownerFloor;
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must be only alph symb")
    private String ownerDistrict;
    @Min(value = 1, message = "order number of rooms must be min 1")
    @NotNull(message = "orderNumberOfRooms must be fill")
    private Integer orderNumberOfRooms;
    @DecimalMin(value = "1", message = "owner floor must be min 1")
    @NotNull(message = "orderArea must be fill")
    private Integer orderArea;
    @DecimalMin(value = "1", message = "owner floor must be min 1")
    @NotNull(message = "order floor must be fill")
    private Integer orderFloor;
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must be only alph symb")
    private String orderDistrict;
}
