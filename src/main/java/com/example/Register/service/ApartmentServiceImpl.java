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
    Integer minArea = (int) (form.getOrderArea() - form.getOrderArea().intValue() * 0.1);
    Integer maxArea =  (int) (form.getOrderArea() + form.getOrderArea().intValue() * 0.1);
    List<Apartment> apartments = apartmentRepository.findFirstApartment(minArea,maxArea, form.getOrderFloor(),form.getOrderDistrict(),form.getOrderNumberOfRooms());

    if (apartments.isEmpty())
        save(new Apartment(form.getOwnerName(), form.getOwnerSurname(),
                form.getOwnerNumberOfRooms(), form.getOwnerArea(), form.getOwnerFloor(), form.getOwnerDistrict(),
                new Order(form.getOrderNumberOfRooms(), form.getOrderArea(), form.getOrderFloor(), form.getOrderDistrict())));

    for (Apartment apartment : apartments) {
        Order order = apartment.getOrder();
        minArea = (int) (apartment.getOrder().getOrderArea() - (apartment.getOrder().getOrderArea() * 0.1));
        maxArea = (int) (apartment.getOrder().getOrderArea() + (apartment.getOrder().getOrderArea() * 0.1));

        if(form.getOwnerArea() > maxArea || form.getOwnerArea() < minArea)
            continue;

        if ((order.getOrderNumberOfRooms()).equals(form.getOwnerNumberOfRooms())
                && order.getOrderFloor().equals(form.getOwnerFloor())
                && order.getOrderDistrict().equals(form.getOwnerDistrict())) {
            delete(apartment);
            return false;
        }
    }
    save(new Apartment(form.getOwnerName(), form.getOwnerSurname(),
            form.getOwnerNumberOfRooms(),form.getOwnerArea(), form.getOwnerFloor(), form.getOwnerDistrict(),
            new Order(form.getOrderNumberOfRooms(), form.getOrderArea(), form.getOrderFloor(), form.getOrderDistrict())));
    return true;
}
}
