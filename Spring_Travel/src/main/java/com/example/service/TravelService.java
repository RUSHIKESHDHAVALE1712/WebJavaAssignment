package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.TourPackage;
import com.example.repository.TravelRepos;

@Service
public class TravelService {


	    @Autowired
	    private TravelRepos travelRepo;
	    
	    

	    public TourPackage createTourPackage(TourPackage tourPackage) {
	        return travelRepo.save(tourPackage);
	    }
	    
	    public List<TourPackage> getAllTourPackages() {
	        return travelRepo.findAll();
	    }


	}



