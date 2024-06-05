package com.example.examiasf.controller;

import com.example.examiasf.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalog")
public class SaleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping
    public String listVehicles(Model model) {
        model.addAttribute("vehicles", vehicleRepository.findAll());
        return "catalog";
    }
}
