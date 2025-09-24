package org.example.models;

public class Adresse {
    private String codePostale;
    private String ville;

    // Constructeurs
    public Adresse() {}

    public Adresse(String codePostale, String ville) {
        this.codePostale = codePostale;
        this.ville = ville;
    }

    // Getters et Setters
    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }


}
