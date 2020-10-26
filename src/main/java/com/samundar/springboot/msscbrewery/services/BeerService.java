package com.samundar.springboot.msscbrewery.services;

import java.util.UUID;

import com.samundar.springboot.msscbrewery.web.model.BeerDto;

public interface BeerService {

	BeerDto getBeerBYId(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

	void updateBeer(UUID beerId, BeerDto beerDto);

	void deleteById(UUID beerId);

}
