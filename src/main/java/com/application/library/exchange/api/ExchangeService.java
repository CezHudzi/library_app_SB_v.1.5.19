package com.application.library.exchange.api;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExchangeService {




    public BigDecimal exchangeToEuro(BigDecimal amount) {

        Map<String, ExternalCurrencyExchange> map = new HashMap<>();

        try {
        String url = "https://free.currencyconverterapi.com/api/v5/convert?q=PLN_EUR&compact=y";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        ObjectMapper objectMapper = new ObjectMapper();

            map = objectMapper.readValue(response.getBody(), new TypeReference<HashMap<String, ExternalCurrencyExchange>>() {
            });
        } catch (Exception e) {
            System.out.println("API DOWN. USE CONST VARIABLE");
            return amount.multiply(BigDecimal.valueOf(0.23));

        }

        return amount.multiply(map.get("PLN_EUR").getVal());
    }

}
