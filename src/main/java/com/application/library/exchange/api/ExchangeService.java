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

        String url = "https://free.currencyconverterapi.com/api/v5/convert?q=PLN_EUR&compact=y";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        Map<String, ExternalCurrencyExchange> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            map = objectMapper.readValue(response.getBody(), new TypeReference<HashMap<String, ExternalCurrencyExchange>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return amount.multiply(map.get("PLN_EUR").getVal());
    }

}
