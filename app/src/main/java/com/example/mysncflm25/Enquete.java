package com.example.mysncflm25;

import java.util.HashMap;

public class Enquete {

    private HashMap<String, Participant> lesParticipants;
    // clé : email du participant
    // value : le participant

    public Enquete() {
        this.lesParticipants = new HashMap<>();
    }
    public void ajouterParticipant(Participant unParticipant) {
        this.lesParticipants.put(unParticipant.getEmail(), unParticipant);
    }
    public Participant getParticipant(String email) {
        return this.lesParticipants.get(email);
    }

    public HashMap<String, Participant> getLesParticipants() {
        return lesParticipants;
    }

    public void setLesParticipants(HashMap<String, Participant> lesParticipants) {
        this.lesParticipants = lesParticipants;
    }
}
