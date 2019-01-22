package com.application.library.controller;

import com.application.library.security.TestResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RequestMapping("/rest/hello")
@RestController
public class HelloResource {

    @GetMapping("/all")
    public TestResponse hello() {

        TestResponse response = new TestResponse("NIE SZYFROWANE");


        return response;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/all")
    public TestResponse securedHello() {

        TestResponse response = new TestResponse("SZYFROWANE");
        List myList = new ArrayList();
        myList.add(response);

        return response;
    }

    @GetMapping("/secured/alternate")
    public String alternate() {
        return "alternate";
    }
}