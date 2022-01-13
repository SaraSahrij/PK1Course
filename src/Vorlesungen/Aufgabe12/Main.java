package Vorlesungen.Aufgabe12;

import java.time.LocalDate;

public class Main {
    public static  void  main(String[] args){
        Privatkunde pk = new Privatkunde("Tom Meier", LocalDate.of(1995, 10, 5), new Konto("40050040", "1234567"));

    }

}
