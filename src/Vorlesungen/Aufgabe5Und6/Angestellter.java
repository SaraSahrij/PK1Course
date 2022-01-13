package Vorlesungen.Aufgabe5Und6;

public class Angestellter {
    private String name;
    private double monatsgehalt;

    public Angestellter(String name, double monatsgehalt) {
        this.name = name;
        this.monatsgehalt = monatsgehalt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMonatsgehalt() {
        return monatsgehalt;
    }

    public void setMonatsgehalt(double monatsgehalt) {
        this.monatsgehalt = monatsgehalt;
    }
    public double berechneJahresgehalt(){
        return monatsgehalt * 12.0;

    }
}
