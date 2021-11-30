package com.ipiecoles.java.java220;
import org.joda.time.LocalDate;

import java.lang.Math;

public class Commercial extends Employe{
    private Double caAnnuel = 0d;

    private Integer performance;

    public Commercial() {

    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire,
                      Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire,
                      Double caAnnuel, Integer performance) {
        this(nom, prenom, matricule, dateEmbauche, salaire, caAnnuel);
        this.performance = performance;
    }

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    @Override
    public Double getPrimeAnnuelle() {
        return Math.max(Math.ceil(this.getCaAnnuel() * 0.05), 500);
    }
}
