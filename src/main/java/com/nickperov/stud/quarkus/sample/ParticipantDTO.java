package com.nickperov.stud.quarkus.sample;

public class ParticipantDTO implements Participant {

    private String firstName;

    private String lastName;

    public ParticipantDTO() {
    }

    public ParticipantDTO(final Participant participant) {
        this.firstName = participant.getFirstName();
        this.lastName = participant.getLastName();
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
}
