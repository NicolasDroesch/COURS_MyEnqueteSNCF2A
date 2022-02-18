package com.example.myenquetesncf2a;

import java.util.HashMap;

public class Candidat {
    private String email, prenom, nom, trancheAge, frequence;
    private HashMap<String, Integer> lesReponses;

    public Candidat(String email, String prenom, String nom, String trancheAge, String frequence) {
        this.email = email;
        this.prenom = prenom;
        this.nom = nom;
        this.trancheAge = trancheAge;
        this.frequence = frequence;
        this.lesReponses = new HashMap<>();
    }

    public void ajouterReponse(String question, int score)
    {
        this.lesReponses.put(question, score);
    }

    public float moyenneScore()
    {
        float moy = 0;
        for (Integer score : this.lesReponses.values())
        {
            moy += score;
        }
        moy /= this.lesReponses.size();
        return moy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTrancheAge() {
        return trancheAge;
    }

    public void setTrancheAge(String trancheAge) {
        this.trancheAge = trancheAge;
    }

    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public HashMap<String, Integer> getLesReponses() {
        return lesReponses;
    }

    public void setLesReponses(HashMap<String, Integer> lesReponses) {
        this.lesReponses = lesReponses;
    }
}
