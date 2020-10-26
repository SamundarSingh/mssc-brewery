package com.samundar.springboot.msscbrewery.services.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.samundar.springboot.msscbrewery.web.model.v2.BeerDtoV2;
import com.samundar.springboot.msscbrewery.web.model.v2.BeerStyleEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceImplV2 implements BeerServiceV2 {

	@Override
	public BeerDtoV2 getBeerBYId(UUID beerId) {

		return BeerDtoV2.builder().id(UUID.randomUUID()).beerName("Galaxy Cat").beerStyle(BeerStyleEnum.IPA).build();
	}

	@Override
	public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDtoV2) {

		return BeerDtoV2.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void updateBeer(UUID beerId, BeerDtoV2 beerDtoV2) {

	}

	@Override
	public void deleteById(UUID beerId) {
		log.debug("Deleting a beer...");
	}

}
