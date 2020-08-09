package com.nickperov.stud.quarkus.sample;


import java.util.List;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class ParticipantsService {

    @Inject
    EntityManager em;

    @PostConstruct
    public void initDefaultParticipants() {
        addNewParticipant("Tom", "Simonson");
        addNewParticipant("Nikia", "Kuta");
        addNewParticipant("Bob", "Casali");
        addNewParticipant("Lena", "Fleischman");
        addNewParticipant("Rob", "Mcnees");
        addNewParticipant("Bob", "Lee");
        addNewParticipant("Alex", "Hitchings");
        addNewParticipant("Nick", "Manalo");
        addNewParticipant("Alex", "Eicher");
    }

    @Transactional
    public void addNewParticipant(final String firstName, final String lastName) {
        this.em.persist(new ParticipantEntity(firstName, lastName));
        this.em.flush();
    }

    public ParticipantEntity getParticipantById(final long id) {
        return this.em.find(ParticipantEntity.class, id);
    }

    public List<ParticipantEntity> getAllParticipants() {
        return this.em.createQuery("SELECT p FROM PARTICIPANTS p", ParticipantEntity.class).getResultList();
    }

    public Stream<ParticipantEntity> findParticipantsByFirstName(final String firstName) {
        return this.em.createQuery("SELECT p FROM PARTICIPANTS p WHERE p.firstName = '" + firstName + "'", ParticipantEntity.class).getResultList().stream();
        //return this.em.createQuery("SELECT p FROM PARTICIPANTS p WHERE LOWER(p.firstName) = LOWER('" + firstName + "')", ParticipantEntity.class).getResultList().stream();
    }

    public Stream<ParticipantEntity> findParticipantsByLastName(final String lastName) {
        return this.em.createQuery("SELECT p FROM PARTICIPANTS p WHERE LOWER(p.lastName) = LOWER('" + lastName + "')", ParticipantEntity.class).getResultStream();
    }
}
