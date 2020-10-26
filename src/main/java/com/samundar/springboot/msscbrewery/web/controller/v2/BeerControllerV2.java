package com.samundar.springboot.msscbrewery.web.controller.v2;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.samundar.springboot.msscbrewery.services.v2.BeerServiceV2;
import com.samundar.springboot.msscbrewery.web.model.BeerDto;
import com.samundar.springboot.msscbrewery.web.model.v2.BeerDtoV2;

@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {

	private final BeerServiceV2 beerService;

	public BeerControllerV2(BeerServiceV2 beerService) {
		this.beerService = beerService;
	}

	@GetMapping({ "/{beerId}" })
	public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
		return new ResponseEntity<>(beerService.getBeerBYId(beerId), HttpStatus.OK);
	}

	@PostMapping // POST - create new beer
	public ResponseEntity<BeerDto> handlePost(@RequestBody BeerDtoV2 beerDtoV2) {

		BeerDtoV2 savedDto = beerService.saveNewBeer(beerDtoV2);

		HttpHeaders headers = new HttpHeaders();
//		todo add hostname to url
		headers.add("Location", "/api/v2/beer/" + savedDto.getId().toString());

		return new ResponseEntity<BeerDto>(headers, HttpStatus.CREATED);
	}

	@PutMapping({ "/{beerId}" })
	public ResponseEntity<BeerDto> hangleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDtoV2) {

		beerService.updateBeer(beerId, beerDtoV2);

		return new ResponseEntity<BeerDto>(HttpStatus.NO_CONTENT);

	}

	@DeleteMapping({ "/{beerId}" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("beerId") UUID beerId) {

		beerService.deleteById(beerId);

	}

}
