package com.pes.mob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pes.mob.model.Place;

@Service
public class Prova implements Runnable {
	List<Place> places;
	@Autowired
	PlaceService placeService;

	@Override
	public void run() {
		for (Place place: places) {
			if (!placeService.exists(place.getFour_id())) placeService.savePlace(place);
		}
	}
	
	public Prova () {}
	
	public void set(List<Place> places) {
		this.places = places;
	}
}
