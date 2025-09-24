package org.example.models;

public class User {
    private String adresseMail;
    private String motDePasse;
    private String civilite;
    private String nom;
    private String prenom;
    private String paysResidence;
    private String paysNationalite;
    private Adresse adresse;
    private String telephone;
    private String statut;
    private String domaine;
    private String niveau;
    private String fonction;
    private String typeOrganisme;
    private String nomOrganisme;

    // Constructeur vide
    public User() {}

    // Getters et Setters
    public String getAdresseMail() { return adresseMail; }
    public void setAdresseMail(String adresseMail) { this.adresseMail = adresseMail; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    public String getCivilite() { return civilite; }
    public void setCivilite(String civilite) { this.civilite = civilite; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getPaysResidence() { return paysResidence; }
    public void setPaysResidence(String paysResidence) { this.paysResidence = paysResidence; }

    public String getPaysNationalite() { return paysNationalite; }
    public void setPaysNationalite(String paysNationalite) { this.paysNationalite = paysNationalite; }

    public Adresse getAdresse() { return adresse; }
    public void setAdresse(Adresse adresse) { this.adresse = adresse; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public String getDomaine() { return domaine; }
    public void setDomaine(String domaine) { this.domaine = domaine; }

    public String getNiveau() { return niveau; }
    public void setNiveau(String niveau) { this.niveau = niveau; }

    public String getFonction() { return fonction; }
    public void setFonction(String fonction) { this.fonction = fonction; }

    public String getTypeOrganisme() { return typeOrganisme; }
    public void setTypeOrganisme(String typeOrganisme) { this.typeOrganisme = typeOrganisme; }

    public String getNomOrganisme() { return nomOrganisme; }
    public void setNomOrganisme(String nomOrganisme) { this.nomOrganisme = nomOrganisme; }
}
