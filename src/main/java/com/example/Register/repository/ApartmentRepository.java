package com.example.Register.repository;

import com.example.Register.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {
    Apartment findFirstApartmentByOwnerAreaAndOwnerFloorAndOwnerDistrictAndOwnerNumberOfRooms(Integer area, Integer floor, String district, Integer orderNumberOfRooms);
}

