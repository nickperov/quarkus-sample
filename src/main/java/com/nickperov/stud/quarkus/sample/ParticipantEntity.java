package com.nickperov.stud.quarkus.sample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "PARTICIPANTS")
public class ParticipantEntity implements Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    public ParticipantEntity(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ParticipantEntity() {
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

    public void setId(final long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }
}
