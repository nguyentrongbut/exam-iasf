package com.example.examiasf.controller;

import com.example.examiasf.model.Vehicle;
import com.example.examiasf.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("/vehicles")
    public String listVehicles(Model model) {
        model.addAttribute("vehicles", vehicleRepository.findAll());
        return "admin/vehicles";
    }

    @GetMapping("/vehicle/add")
    public String showAddVehicleForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "admin/add-vehicle";
    }

    @PostMapping("/vehicle/add")
    public String addVehicle(@ModelAttribute Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return "redirect:/admin/vehicles";
    }

    @GetMapping("/vehicle/edit/{id}")
    public String showEditVehicleForm(@PathVariable int id, Model model) {
        model.addAttribute("vehicle", vehicleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid vehicle Id:" + id)));
        return "admin/edit-vehicle";
    }

    @PostMapping("/vehicle/edit/{id}")
    public String editVehicle(@PathVariable int id, @ModelAttribute Vehicle vehicle) {
        vehicle.setVehicleId(id);
        vehicleRepository.save(vehicle);
        return "redirect:/admin/vehicles";
    }

    @GetMapping("/vehicle/delete/{id}")
    public String deleteVehicle(@PathVariable int id) {
        vehicleRepository.deleteById(id);
        return "redirect:/admin/vehicles";
    }
}
