package com.example.Register.service;

import com.example.Register.model.Apartment;
import com.example.Register.model.Form;

import java.util.List;

public interface ApartmentService {
    Boolean addApartments(Form form);
    void save(Apartment apartment);
    void delete(Apartment apartment);
    List<Apartment> getAllApartments();
    Apartment findFirstApartmentByOwnerAreaAndOwnerFloorAndOwnerDistrictAndOwnerNumberOfRooms(Integer area, Integer floor, String district, Integer orderNumberOfRooms);
}
