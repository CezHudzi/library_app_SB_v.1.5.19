package com.application.library.mapperDTO.autormapper;


import java.util.Set;

public class AutorCreateDTO {


    private String firstName;
    private String lastName;

    public AutorCreateDTO() {
    }

    public AutorCreateDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() { return lastName; }


}
