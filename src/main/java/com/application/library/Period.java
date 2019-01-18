package com.application.library;

import com.application.library.exchange.api.ExchangeService;

import com.application.library.model.Borrow;
import com.application.library.services.BorrowService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableScheduling
public class Period {



    private final BorrowService borrowService;
    private final ExchangeService exchangeService;
    public Period(BorrowService borrowService,ExchangeService exchangeService) {
        this.borrowService = borrowService;
        this.exchangeService = exchangeService;
    }


    @Scheduled(fixedRate=1000)
    public void work() throws IOException {






        Borrow borrow = borrowService.getBorrowById(1);
        BigDecimal fine= borrow.getFine();
        borrow.setFine(fine.add(BigDecimal.valueOf(100)));
        borrow.setFineEuro(exchangeService.exchangeToEuro(fine));

        borrowService.updateBorrow(borrow);

    }
}
