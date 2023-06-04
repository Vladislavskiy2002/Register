package com.example.Register.controller;

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
            Boolean isTheExchangeSuccessful = apartmentService.addApartments(form);
            if(!isTheExchangeSuccessful) {
                return "theExchangeSuccessful";
            } else {
                return "apartmentSuccessfullyAdded";
            }
        }

    }
    @GetMapping("/showAllApartments")
    private String showApartments(Model model) {
        model.addAttribute("apartments", apartmentService.getAllApartments());
        return "all-apartaments";
    }
}
