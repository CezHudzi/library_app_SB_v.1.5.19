package com.application.library.mapperDTO.personmapper;

public class PersonCreateDTO {



    private String firstName;
    private String lastName;

    public PersonCreateDTO( String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public PersonCreateDTO( ) {
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
