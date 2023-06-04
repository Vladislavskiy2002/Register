package com.example.Register.service;

import com.example.Register.model.Apartment;
import com.example.Register.model.Form;

import java.util.List;

public interface ApartmentService {
    void save(Apartment apartment);
    void delete(Apartment apartment);
    List<Apartment> getAllApartments();
    Boolean findFirstApartment(Form form);
}
