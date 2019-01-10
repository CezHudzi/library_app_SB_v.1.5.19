package com.application.library.mapperDTO.personmapper;

public class PersonResponse {

    private final Long idUser;
    private final String firstName;
    private final String lastName;

    PersonResponse(Long idUser, String firstName, String lastName) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


}
