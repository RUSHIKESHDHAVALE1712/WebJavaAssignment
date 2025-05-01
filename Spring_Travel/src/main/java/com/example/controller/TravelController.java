package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.TourPackage;
import com.example.service.TravelService;

@RestController
@RequestMapping("/travel_agency")
public class TravelController {

	@Autowired
    private TravelService tService;

	//http://localhost:3306/travel_agency/add   -----POST
    @PostMapping
    public ResponseEntity<TourPackage> createTourPackage(@RequestBody TourPackage tourPackage) {
        TourPackage createdPackage = tService.createTourPackage(tourPackage);
        return new ResponseEntity<>(createdPackage, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<TourPackage>> getAllTourPackages() {
        List<TourPackage> packages = tService.getAllTourPackages();
        return new ResponseEntity<>(packages, HttpStatus.OK);
    }


}
