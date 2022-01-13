package Praktikum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Medienverwaltung_NichtTypsicheren {

    private ArrayList medien;

    public Medienverwaltung_NichtTypsicheren() {
        medien = new ArrayList();

    }

    public void aufnahme(Medium m) {
        medien.add(m);

    }

    public void zeigeMedien() {
        if (medien.isEmpty()) {
            System.out.println("Es gibt keine Medien");
        } else {
            Iterator it = medien.iterator();
            while (it.hasNext()) {
                ((Medium) it.next()).druckeDaten();
            }

        }
    }

//Adon!!!!!!

    public void sucheNeuesMedium() {
        Medium neusteMedium = (Medium) medien.get(0);
        int neuErscheinungsjahr = neusteMedium.getJahr();

        for (Object obj : medien) {
            Medium tempMedium = (Medium) obj;
            if (tempMedium.getJahr() >= neuErscheinungsjahr) {
                neuErscheinungsjahr = tempMedium.getJahr();
                neusteMedium = tempMedium;
            }
        }
        neusteMedium.druckeDaten();
    }


    public double berechneErscheinungsjahr() {
        if (medien.isEmpty()) {
            return 0.0;
        } else {
            double summe = 0;

            Iterator it = medien.iterator();
            while (it.hasNext()) {
                summe += ((Medium) it.next()).getJahr();
            }
            return summe / medien.size();
        }
    }
}




