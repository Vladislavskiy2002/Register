package com.example.Register.controller;

import com.example.Register.model.Apartment;
import com.example.Register.model.Form;
import com.example.Register.service.ApartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController{
    private final ApartmentService apartmentService;
    public RegistrationController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }
    @GetMapping("/menu")
    private String mainMenu() {
        return "menu";
    }
    @GetMapping("/exchange")
    private String addApartments() {
        return "hello";
    }
    @PostMapping("/exchange")
    private String addApartments(@Valid @ModelAttribute Form form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "hello";
        } else {
            Apartment apartment = apartmentService.findFirstApartment(form);
            model.addAttribute("apartment", apartment);
            if(!apartment.getIsExchanged()) {
                return "theExchangeSuccessful";
            } else {
                return "apartmentSuccessfullyAdded";
            }
        }
    }
    @GetMapping("/deleteOrder")
    private String deleteApartment(Apartment apartment){
        apartmentService.delete(apartment);
        return "redirect:/showAllApartments";
    }
    @GetMapping("/showAllApartments")
    private String showApartments(Model model) {
        model.addAttribute("apartments", apartmentService.getAllApartments());
        return "all-apartaments";
    }
    @GetMapping("/findByArea")
    private String findApartmentByArea(){
        return "form-area";
    }
    @PostMapping("/findByArea")
    private String findApartmentByArea(@Valid @ModelAttribute Form form,  BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors("ownerArea")) {
            model.addAttribute("error", bindingResult.getFieldError("ownerArea"));
            return "form-area";
        }
        model.addAttribute("apartments", apartmentService.findApartmentsByArea(form.getOwnerArea()));
        return "all-apartaments";
    }

    @GetMapping("/findByFloor")
    private String findApartmentByFloor(){
        return "form-floor";
    }
    @PostMapping("/findByFloor")
    private String findApartmentByFloor(@Valid @ModelAttribute Form form,  BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors("ownerFloor")) {
            model.addAttribute("error", bindingResult.getFieldError("ownerFloor"));
            return "form-floor";
        }
        model.addAttribute("apartments", apartmentService.findApartmentsByFloor(form.getOwnerFloor()));
        return "all-apartaments";
    }
    @GetMapping("/findByRooms")
    private String findApartmentByRooms(){
        return "form-rooms";
    }
    @PostMapping("/findByRooms")
    private String findApartmentByRooms(@Valid @ModelAttribute Form form,  BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors("ownerNumberOfRooms")) {
            model.addAttribute("error", bindingResult.getFieldError("ownerNumberOfRooms"));
            return "form-rooms";
        }
        model.addAttribute("apartments", apartmentService.findApartmentsByRooms(form.getOwnerNumberOfRooms()));
        return "all-apartaments";
    }
    @GetMapping("/findByDistrict")
    private String findApartmentByDistrict(){
        return "form-district";
    }
    @PostMapping("/findByDistrict")
    private String findApartmentByDistrict(@Valid @ModelAttribute Form form,  BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors("ownerDistrict")) {
            model.addAttribute("error", bindingResult.getFieldError("ownerDistrict"));
            return "form-district";
        }
        model.addAttribute("apartments", apartmentService.findApartmentsByDistrict(form.getOwnerDistrict()));
        return "all-apartaments";
    }
}
