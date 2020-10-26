package com.samundar.springboot.msscbrewery.services.v2;

import java.util.UUID;

import com.samundar.springboot.msscbrewery.web.model.v2.BeerDtoV2;

public interface BeerServiceV2 {

	BeerDtoV2 getBeerBYId(UUID beerId);

	BeerDtoV2 saveNewBeer(BeerDtoV2 beerDtoV2);

	void updateBeer(UUID beerId, BeerDtoV2 beerDtoV2);

	void deleteById(UUID beerId);

}
