package Vorlesungen.Aufgabe5Und6;

public class Vorstand extends Manager{

    private double abfindung;

    public Vorstand(String name, double monatsgehalt, double bonus, double abfindung) {
        super(name, monatsgehalt, bonus);
        this.abfindung = abfindung;
    }

    public double getAbfindung() {
        return abfindung;
    }

    public void setAbfindung(double abfindung) {
        this.abfindung = abfindung;
    }
    @Override
    public double berechneJahresgehalt() {
        return super.berechneJahresgehalt() + abfindung;
    }
}
