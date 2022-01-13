package Vorlesungen.Aufgabe5Und6;

public class Manager extends Angestellter {
    private double bonus;

    public Manager(String name, double monatsgehalt, double bonus) {
        super(name, monatsgehalt);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double berechneJahresgehalt() {
        return super.berechneJahresgehalt() + bonus;
    }
}
