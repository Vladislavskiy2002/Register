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

public Boolean findFirstApartment(Form form) {
    int minArea = (int) (Integer.getInteger(form.getOrderArea()) - (Integer.getInteger(form.getOrderArea()) * 0.1));
    int maxArea = (int) (Integer.getInteger(form.getOrderArea()) + (Integer.getInteger(form.getOrderArea()) * 0.1));
    List<Apartment> apartments = apartmentRepository.findFirstApartment(minArea,maxArea, Integer.getInteger(form.getOrderFloor()),form.getOrderDistrict(),Integer.getInteger(form.getOrderNumberOfRooms()));

    if (apartments == null)
        save(new Apartment(form.getOwnerName(), form.getOwnerSurname(),
                Integer.getInteger(form.getOwnerNumberOfRooms()), Integer.getInteger(form.getOwnerArea()), Integer.getInteger(form.getOwnerFloor()), form.getOwnerDistrict(),
                new Order(Integer.getInteger(form.getOrderNumberOfRooms()), Integer.getInteger(form.getOrderArea()), Integer.getInteger(form.getOrderFloor()), form.getOrderDistrict())));

    for (Apartment apartment : apartments) {
        Order order = apartment.getOrder();
        minArea = (int) (apartment.getOrder().getOrderArea() - (apartment.getOrder().getOrderArea() * 0.1));
        maxArea = (int) (apartment.getOrder().getOrderArea() + (apartment.getOrder().getOrderArea() * 0.1));

        if(Integer.getInteger(form.getOwnerArea()) > maxArea || Integer.getInteger(form.getOwnerArea()) < minArea)
            continue;

        if ((order.getOrderNumberOfRooms()).equals(Integer.getInteger(form.getOwnerNumberOfRooms()))
                && order.getOrderFloor().equals(Integer.getInteger(form.getOwnerFloor()))
                && order.getOrderDistrict().equals(form.getOwnerDistrict())) {
            System.out.println("КВАРТИРИ СПІВПАДАЮТЬ");
            System.out.println("ОБМІН ВІДБУВСЯ УСПІШНО");
            delete(apartment);
            return false;
        }
    }
    save(new Apartment(form.getOwnerName(), form.getOwnerSurname(),
            Integer.getInteger(form.getOwnerNumberOfRooms()), Integer.getInteger(form.getOwnerArea()), Integer.getInteger(form.getOwnerFloor()), form.getOwnerDistrict(),
            new Order(Integer.getInteger(form.getOrderNumberOfRooms()), Integer.getInteger(form.getOrderArea()), Integer.getInteger(form.getOrderFloor()), form.getOrderDistrict())));
    return true;
}
}
