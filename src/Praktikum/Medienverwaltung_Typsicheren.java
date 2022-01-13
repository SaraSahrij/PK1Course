package Praktikum;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Medienverwaltung_Typsicheren {
    private ArrayList<Medium> medien;

    public Medienverwaltung_Typsicheren() {
        medien = new ArrayList<>();

    }

    public void aufnahme(Medium m) {
        medien.add(m);

    }

    public void zeigeMedien() {
        if (medien.isEmpty()) {
            System.out.println("Es gibt keine Medien");
        } else {
            Collections.sort(medien);
            Iterator<Medium> it = medien.iterator();
            while (it.hasNext()) {
                it.next().druckeDaten(System.out);
            }
        }
    }

    public void medienlisteInDateiSchreiben() throws EmptyFilenameException {
        if (medien.isEmpty()) {
            System.out.println("Es gibt keine Medien");
        } else {
            boolean dateiNameGueltig = false;
            do {
                String dateiName = JOptionPane.showInputDialog(null, "Datei Name");
                if (dateiName == null) {
                    return;
                }
                if (dateiName.length() == 0) {
                    throw new EmptyFilenameException("Datei name darf nicht leer sein!!");
                } else {
                    try {
                        FileOutputStream fos = new FileOutputStream(dateiName + ".txt");
                        Collections.sort(medien);
                        Iterator<Medium> it = medien.iterator();
                        while (it.hasNext()) {
                            it.next().druckeDaten(fos);
                        }
                        JOptionPane.showMessageDialog(null, "Medienliste wurde erfolgreich in Datei geschrieben :) ");
                        dateiNameGueltig = true;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } while (!dateiNameGueltig);

        }
    }


    public void sucheNeuesMedium() {
        int neuErscheinungsjahr = medien.get(0).getJahr();
        int index = 0;

        for (Medium m : medien) {
            Medium temp = m;
            if (temp.getJahr() >= neuErscheinungsjahr) {
                neuErscheinungsjahr = temp.getJahr();
                index = medien.indexOf(m);
            }
        }
        medien.get(index).druckeDaten();
    }

    public double berechneErscheinungsjahr() {
        if (medien.isEmpty()) {
            return 0.0;
        } else {
            double summe = 0;

            Iterator<Medium> it = medien.iterator();
            while (it.hasNext()) {

                summe += it.next().getJahr();
            }
            return summe / medien.size();
        }
    }
    //C:\Program Files\Java
    public void speichern() {
        try {
            FileOutputStream fos = new FileOutputStream("medienliste.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(medien);
            JOptionPane.showMessageDialog(null, "Dateiliste wurde erfolgreich serialisiert");
            fos.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void laden() {
        try {
            FileInputStream fis = new FileInputStream("medienliste.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            medien = (ArrayList<Medium>) ois.readObject();
            JOptionPane.showMessageDialog(null, "Dateiliste wurde erfolgreich deserialisiert");
            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
