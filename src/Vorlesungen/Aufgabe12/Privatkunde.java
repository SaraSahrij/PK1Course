package Vorlesungen.Aufgabe12;

import java.time.LocalDate;


public class Privatkunde {
    private String nachname;
    private LocalDate geb_datum;
    private Konto konto;

    public Privatkunde(String nachname, LocalDate geb_datum, Konto konto) {
        this.nachname = nachname;
        this.geb_datum = geb_datum;
        this.konto=konto;
    }
}
