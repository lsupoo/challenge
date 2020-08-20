package com.lsupoo.challenge.repository;

import com.lsupoo.challenge.model.Exchange;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository("exchangeRepository")
public interface ExchangeRepository extends JpaRepository<Exchange, String> {
    @Query("SELECT new com.lsupoo.challenge.model.Exchange(t.symbol, t.change) FROM Exchange t")
    List<Exchange> findAllChange();

}
