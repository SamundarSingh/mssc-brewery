package com.samundar.springboot.msscbrewery.web.controller;

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

import com.samundar.springboot.msscbrewery.services.BeerService;
import com.samundar.springboot.msscbrewery.web.model.BeerDto;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

	private final BeerService beerService;

	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}

	@GetMapping({ "/{beerId}" })
	public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
		return new ResponseEntity<>(beerService.getBeerBYId(beerId), HttpStatus.OK);
	}

	@PostMapping // POST - create new beer
	public ResponseEntity<BeerDto> handlePost(@RequestBody BeerDto beerDto) {

		BeerDto savedDto = beerService.saveNewBeer(beerDto);

		HttpHeaders headers = new HttpHeaders();
//		todo add hostname to url
		headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());

		return new ResponseEntity<BeerDto>(headers, HttpStatus.CREATED);
	}

	@PutMapping({ "/{beerId}" })
	public ResponseEntity<BeerDto> hangleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {

		beerService.updateBeer(beerId, beerDto);

		return new ResponseEntity<BeerDto>(HttpStatus.NO_CONTENT);

	}

	@DeleteMapping({ "/{beerId}" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("beerId") UUID beerId) {

		beerService.deleteById(beerId);

	}

}
