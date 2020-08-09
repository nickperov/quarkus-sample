package com.nickperov.stud.quarkus.sample;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/participants")
public class ParticipantsController {

    @Inject
    ParticipantsService participantsService;

    @GetMapping()
    public ParticipantDTO getParticipant(@RequestParam final long id) {
        return new ParticipantDTO(this.participantsService.getParticipantById(id));
    }

    @GetMapping("/all")
    public List<ParticipantDTO> getAllParticipants() {
        return this.participantsService.getAllParticipants().stream().map(ParticipantDTO::new).collect(Collectors.toList());
    }

    @PostMapping(value = "/add")
    public void addParticipant(@RequestBody final ParticipantDTO participant) {
        this.participantsService.addNewParticipant(participant.getFirstName(), participant.getLastName());
    }

    @PostMapping(value = "/find")
    public List<ParticipantDTO> findParticipants(@RequestBody final ParticipantQuery participantQuery) {

        final String firstName = participantQuery.getFirstName();
        final String lastName = participantQuery.getLastName();

        final Stream<ParticipantEntity> byFirstName;
        if (firstName != null) {
            byFirstName = this.participantsService.findParticipantsByFirstName(firstName);
        } else {
            byFirstName = Stream.empty();
        }

        final Stream<ParticipantEntity> byLastName;
        if (lastName != null) {
            byLastName = this.participantsService.findParticipantsByLastName(lastName);
        } else {
            byLastName = Stream.empty();
        }

        return Stream.concat(byFirstName, byLastName).map(ParticipantDTO::new).collect(Collectors.toList());
    }
}
