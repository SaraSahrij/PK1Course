package Vorlesungen.Aufgabe2Und3;

public class Auto {
    private String hersteller;
    private int baujahr;

    public Auto(String hersteller, int baujahr) {
        this.hersteller = hersteller;
        this.baujahr = baujahr;
    }

    public Auto(int baujahr) {
        this.baujahr = baujahr;
    }

    public int alter(){
        return 2020 - baujahr;
    }
}
