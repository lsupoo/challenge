package com.lsupoo.challenge.controller;

import com.lsupoo.challenge.model.ExchangeRequest;
import com.lsupoo.challenge.model.ExchangeResponse;
import com.lsupoo.challenge.model.UpdateRequest;
import com.lsupoo.challenge.service.ExchangeService;
import io.reactivex.Completable;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ExchangeController
{
	private static Logger log = LoggerFactory.getLogger(ExchangeController.class);

	@Autowired
	@Qualifier("exchangeService")
	private ExchangeService exchangeService;

	@PostMapping(value= "/exchange",
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Single<ExchangeResponse> getExchange(@RequestBody ExchangeRequest exchangeRequest)
	{
		return exchangeService.getData(exchangeRequest);
	}

	@PostMapping(value= "/update-exchange",
				 consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
				 produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Completable updateExchange(@RequestBody UpdateRequest updateRequest)
	{
		return exchangeService.updateExchange(updateRequest);
	}

	@GetMapping(value= "/symbols",
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Single<List<String>> getSymbols()
	{
		return exchangeService.getSymbols();
	}
}
