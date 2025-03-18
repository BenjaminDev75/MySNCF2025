package com.example.mysncflm25;

import java.util.HashMap;

public class Participant {
    private String nom, prenom, email, age, frequence, comment;
    private HashMap<String, Integer> lesReponses;

    public Participant(String nom, String prenom, String email, String age, String frequence) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.age = age;
        this.frequence = frequence;
        this.comment = "";
        this.lesReponses = new HashMap<>();
    }

    public void ajouterReponse(String question, int reponse) {
        this.lesReponses.put(question, reponse);
    }
    public float moyenne(){
        float m = 0;
        for(Integer score : this.lesReponses.values()){
            m += score;
        }
        m /= this.lesReponses.size();
        return m;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public HashMap<String, Integer> getLesReponses() {
        return lesReponses;
    }

    public void setLesReponses(HashMap<String, Integer> lesReponses) {
        this.lesReponses = lesReponses;
    }
}
