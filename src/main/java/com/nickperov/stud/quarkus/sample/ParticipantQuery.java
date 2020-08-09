package com.nickperov.stud.quarkus.sample;

public class ParticipantQuery {

    public ParticipantQuery() {
    }

    private String firstName;

    private String lastName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
}
