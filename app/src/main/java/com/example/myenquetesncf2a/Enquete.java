package com.example.myenquetesncf2a;

import java.util.HashMap;

public class Enquete {
    private HashMap<String, Candidat> lesCandidats;

    public Enquete ()
    {
        this.lesCandidats = new HashMap<>();
    }

    public void ajouterCandidat(Candidat unCandidat)
    {
        this.lesCandidats.put(unCandidat.getEmail(), unCandidat);
    }
    public Candidat getCandidat(String email)
    {
        return this.lesCandidats.get(email);
    }
}