package com.nickperov.stud.quarkus.sample;


import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class PersistenceService {

    @Inject
    EntityManager em;

    @Transactional
    public void addNewParticipant(final String firstName, final String lastName) {
        this.em.persist(new Participant(firstName, lastName));
        this.em.flush();
    }

    public Participant getParticipantById(final long id) {
        return this.em.find(Participant.class, id);
    }

    public List<Participant> findParticipantsByFirstName(final String firstName) {
        return this.em.createQuery("SELECT p FROM PARTICIPANTS p WHERE LOWER(p.firstName) = LOWER(:firstName)", Participant.class).getResultList();
    }

    public List<Participant> findParticipantsByLastName(final String lastName) {
        return this.em.createQuery("SELECT p FROM PARTICIPANTS p WHERE LOWER(p.lastName) = LOWER(:lastName)", Participant.class).getResultList();
    }

}
