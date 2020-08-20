package com.lsupoo.challenge.service;

import com.lsupoo.challenge.model.Exchange;
import com.lsupoo.challenge.model.ExchangeRequest;
import com.lsupoo.challenge.model.ExchangeResponse;
import com.lsupoo.challenge.model.UpdateRequest;
import com.lsupoo.challenge.repository.ExchangeRepository;
import io.reactivex.Completable;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("exchangeService")
public class ExchangeServiceImpl implements ExchangeService {

    private static Logger log = LoggerFactory.getLogger(ExchangeServiceImpl.class);

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Override
    public Single<ExchangeResponse> getData(ExchangeRequest exchangeRequest) {
        ExchangeResponse exchangeResponse = new ExchangeResponse();
        float cambioOrigen = 0f;
        float cambioDestino = 0f;

        Optional<Exchange> exchangeOrigen = exchangeRepository.findById(exchangeRequest.getMonedaOrigen());
        Optional<Exchange> exchangeDestino = exchangeRepository.findById(exchangeRequest.getMonedaDestino());

        if(exchangeOrigen.isPresent())
            cambioOrigen = exchangeOrigen.get().getChange();

        if(exchangeDestino.isPresent())
            cambioDestino = exchangeDestino.get().getChange();

        exchangeResponse.setMonedaOrigen(exchangeRequest.getMonedaOrigen());
        exchangeResponse.setMonedaDestino(exchangeRequest.getMonedaDestino());
        exchangeResponse.setMonto(exchangeRequest.getMonto());
        exchangeResponse.setCambio(cambioOrigen/cambioDestino);
        exchangeResponse.setMontoResultado(exchangeRequest.getMonto()*cambioOrigen/cambioDestino);

        return Single.just(exchangeResponse);
    }

    @Override
    public Completable updateExchange(UpdateRequest updateRequest) {
        return Completable
                .fromSingle(Single.just(exchangeRepository.save(parseToExchange(updateRequest))))
                .doOnComplete(() -> log.info("Actualizacion exitosa"));
    }

    public Single<List<String>> getSymbols() {
        return Single.just(exchangeRepository.findAllChange())
                .map(x -> parseToSymbol(x));
    }

    public Exchange parseToExchange(UpdateRequest updateRequest) {
        Exchange exchange = new Exchange();
        exchange.setChange(updateRequest.getChange());
        exchange.setSymbol(updateRequest.getSymbol());

        return exchange;
    }

    public List<String> parseToSymbol(List<Exchange> exchangeList) {
        return exchangeList.stream()
                .map(x -> x.getSymbol())
                .collect(Collectors.toList());
    }
}
