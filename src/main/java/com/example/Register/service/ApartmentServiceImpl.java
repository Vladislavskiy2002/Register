package com.example.Register.service;

import com.example.Register.model.Apartment;
import com.example.Register.model.Form;
import com.example.Register.model.Order;
import com.example.Register.repository.ApartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService{
    final private ApartmentRepository apartmentRepository;
    public ApartmentServiceImpl(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }
    @Override
    public void save(Apartment apartment) {
        apartmentRepository.save(apartment);
    }

    @Override
    public void delete(Apartment apartment) {
        apartmentRepository.delete(apartment);
    }

    @Override
    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }

    @Override
    public Apartment findFirstApartmentByOwnerAreaAndOwnerFloorAndOwnerDistrictAndOwnerNumberOfRooms(Integer area, Integer floor, String district, Integer orderNumberOfRooms) {
        return apartmentRepository.findFirstApartmentByOwnerAreaAndOwnerFloorAndOwnerDistrictAndOwnerNumberOfRooms(area,floor,district,orderNumberOfRooms);
    }

    public Boolean addApartments(Form form){
        Apartment apartment = findFirstApartmentByOwnerAreaAndOwnerFloorAndOwnerDistrictAndOwnerNumberOfRooms(form.getOrderArea(),
                form.getOrderFloor(),form.getOrderDistrict(),form.getOrderNumberOfRooms());
        if(apartment == null) {
            save(new Apartment(form.getOwnerName(), form.getOwnerSurname(),
                    form.getOwnerNumberOfRooms(), form.getOwnerArea(), form.getOwnerFloor(), form.getOwnerDistrict(),
                    new Order(form.getOrderNumberOfRooms(), form.getOrderArea(), form.getOrderFloor(), form.getOrderDistrict())));
            return true;
        }
        else {
            Order order = apartment.getOrder();
            if (order.getOrderNumberOfRooms().equals(form.getOwnerNumberOfRooms())
                    && order.getOrderArea().equals(form.getOwnerArea()) && order.getOrderFloor().equals(form.getOwnerFloor())
                    && order.getOrderDistrict().equals(form.getOwnerDistrict())) {
                System.out.println("КВАРТИРИ СПІВПАДАЮТЬ");
                System.out.println("ОБМІН ВІДБУВСЯ УСПІШНО");
                delete(apartment);
                return false;
            }
            else {
                save(new Apartment(form.getOwnerName(), form.getOwnerSurname(),
                        form.getOwnerNumberOfRooms(), form.getOwnerArea(), form.getOwnerFloor(), form.getOwnerDistrict(),
                        new Order(form.getOrderNumberOfRooms(), form.getOrderArea(), form.getOrderFloor(), form.getOrderDistrict())));
                return true;
            }
        }
    }
}
