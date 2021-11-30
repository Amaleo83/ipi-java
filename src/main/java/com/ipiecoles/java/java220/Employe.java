package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;
import org.joda.time.LocalDate;

import java.util.Objects;

public abstract class Employe {

    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire = Entreprise.SALAIRE_BASE;
    private Boolean tempsPartiel;
    private String sexe;

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Boolean tempsPartiel, String sexe) {
    }

    public Employe() {

    }

    public final Integer getNombreAnneeAnciennete() {
        return LocalDate.now().getYear() - dateEmbauche.getYear();
    }

    public Integer getNbConges() {
        return Entreprise.NB_CONGES_BASE;
    }

    public abstract Double getPrimeAnnuelle();

    public void augmenterSalaire(Double pourcentage) {
        this.salaire = this.getSalaire() * (1 + pourcentage);
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

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        if (dateEmbauche != null && dateEmbauche.isAfter(LocalDate.now())) {
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
        this.dateEmbauche = dateEmbauche;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public Boolean getTempsPartiel() {
        return tempsPartiel;
    }

    public void setTempsPartiel(Boolean tempsPartiel) {
        this.tempsPartiel = tempsPartiel;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", matricule='" + matricule + '\'' +
                ", dateEmbauche=" + dateEmbauche +
                ", salaire=" + salaire +
                ", tempsPartiel=" + tempsPartiel +
                ", sexe='" + sexe + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employe)) return false;
        Employe employe = (Employe) o;
        return Objects.equals(getNom(), employe.getNom()) && Objects.equals(getPrenom(), employe.getPrenom()) && Objects.equals(getMatricule(), employe.getMatricule()) && Objects.equals(getDateEmbauche(), employe.getDateEmbauche()) && Objects.equals(getSalaire(), employe.getSalaire()) && Objects.equals(getTempsPartiel(), employe.getTempsPartiel()) && Objects.equals(getSexe(), employe.getSexe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getPrenom(), getMatricule(), getDateEmbauche(), getSalaire(), getTempsPartiel(), getSexe());
    }
}
