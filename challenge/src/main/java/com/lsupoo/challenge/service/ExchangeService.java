package com.lsupoo.challenge.service;

//import io.reactivex.Single;

import com.lsupoo.challenge.model.ExchangeRequest;
import com.lsupoo.challenge.model.ExchangeResponse;
import com.lsupoo.challenge.model.UpdateRequest;
import io.reactivex.Completable;
import io.reactivex.Single;

import java.util.List;

public interface ExchangeService {
    Single<ExchangeResponse> getData(ExchangeRequest exchangeRequest);
    Single<List<String>> getSymbols();
    Completable updateExchange(UpdateRequest updateRequest);
}
