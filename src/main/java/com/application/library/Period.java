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
import java.time.temporal.ChronoUnit;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;

@Configuration
@EnableScheduling
public class Period {



    private final BorrowService borrowService;
    private final ExchangeService exchangeService;
    public Period(BorrowService borrowService,ExchangeService exchangeService) {
        this.borrowService = borrowService;
        this.exchangeService = exchangeService;
    }


    @Scheduled(fixedRate=10000)
    public void work() throws IOException {




        List<Borrow> listBorrows = borrowService.gerBorrowPeriod();

        for (Borrow i : listBorrows) {


            LocalDate returnedAt = i.getReturnAt();
            LocalDate today = LocalDate.now();
            long days = DAYS.between(today, returnedAt);
            if (days < 0) {
                BigDecimal fine = BigDecimal.valueOf(days * -100);
                i.setFine(fine);
                i.setFineEuro(exchangeService.exchangeToEuro(fine));
                borrowService.updateBorrow(i);
            }

        }

    }
}
