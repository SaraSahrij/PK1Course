package Praktikum;

public class Medienverwaltung_Array {

    private Medium[] medien;

    public Medienverwaltung_Array(int size) {

        medien = new Medium[size];
    }

    public void aufnahme(Medium m) {
        if (medien[medien.length-1] != null) {
            System.out.println("Das Medium ist voll");
        } else {
            for (int i = 0; i < medien.length; i++) {
                if (medien[i] == null) {
                    medien[i] = m;
                    break;
                }
            }
        }
    }

    public void zeigeMedien() {

        for (int i = 0; i < medien.length; i++) {
            if (medien[i] != null) {
                medien[i].druckeDaten();
            }
        }

    }

    public void sucheNeuesMedium() {

        int neuErscheinungsjahr = medien[0].getJahr();
        int index = 0 ;
        for (int i = 0; i < medien.length; i++) {
            if (medien[i] != null) {
                if (medien[i].getJahr() >= neuErscheinungsjahr){
                    neuErscheinungsjahr = medien[i].getJahr();
                    index = i ;
                }

            }
        }
        medien[index].druckeDaten();
    }

    public double berechneErscheinungsjahr() {
        if (medien[0] == null) {
            return 0.0;
        } else {
            double summe = 0;
            double count = 0;
            for (int i = 0; i < medien.length; i++) {
                if (medien[i] != null) {
                    count++;
                    summe +=medien[i].getJahr();

                }
            }
            return summe / count;
        }
    }
}



