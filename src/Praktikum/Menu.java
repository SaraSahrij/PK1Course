package Praktikum;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Medienverwaltung_Typsicheren mt;
    private Scanner scan;

    public Menu(Medienverwaltung_Typsicheren mt) {
        this.mt = mt;
    }

    public void zeigeMenue() {
        int auswahl = 0;
        scan = new Scanner(System.in);
        do {
            try {
                System.out.println("\n\nMedienverwaltung\n" +
                        "1. Audio aufnehmen\n" +
                        "2. Bild aufnehmen\n" +
                        "3. Zeige alle Medien\n" +
                        "4. Medienliste in Datei schreiben\n" +
                        "5. Zeige neues Medium\n" +
                        "6. Berechne durchschnittliches Erscheinungsjahr\n" +
                        "7. Speichern\n" +
                        "8. Laden\n" +
                        "9. Beenden\n\n" +
                        "Bitte Menuepunkt waehlen: ");
                auswahl = scan.nextInt();
                switch (auswahl) {
                    case 1:
                        addAudio();
                        break;
                    case 2:
                        addNewBild();
                        break;
                    case 3:
                        mt.zeigeMedien();
                        break;
                    case 4:
                        boolean dateinameOkay = false;
                        do {
                            try {
                                mt.medienlisteInDateiSchreiben();
                                dateinameOkay = true;
                            } catch (EmptyFilenameException ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage());
                                int option = JOptionPane.showConfirmDialog(null, "Möchten Sie die Dateiname erneuert eingeben?",
                                        "Hinweis", JOptionPane.YES_NO_OPTION);
                                if (option == 1) {
                                    break;
                                }
                            }
                        } while (!dateinameOkay);
                        break;
                    case 5:
                        mt.sucheNeuesMedium();
                        break;
                    case 6:
                        System.out.println(mt.berechneErscheinungsjahr());
                        break;
                    case 7:
                        mt.speichern();
                        break;
                        case 8:
                        mt.laden();
                        break;
                    case 9:
                        System.out.println("Ciao");
                        break;
                    default:
                        System.out.println("Bitte zwischen 1 und 9 wählen");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Bitte ein gueltiges Zahl eingeben");
                scan.nextLine();
            }

        } while (auswahl != 9);

    }


    private void addAudio() {
        String titel;
        boolean isTitleValid = false;
        do {
            titel = JOptionPane.showInputDialog(null, "Title");
            if (titel == null) {
                return;
            }
            if (titel != null && titel.length() == 0) {
                JOptionPane.showMessageDialog(null, "Title darf nicht leer sein!\nBitte erneut eingeben");
            } else {
                isTitleValid = true;
            }

        } while (isTitleValid == false);


        boolean isJahrValid = false;
        int jahr = 0;
        do {
            try {
                jahr = Integer.parseInt(JOptionPane.showInputDialog(null, "Jahr"));
                isJahrValid = true;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Bitte gültiges Erscheinungsjahr eingeben");
            }
        } while (isJahrValid == false);


        String interpret;
        boolean isInterpretValid = false;
        do {
            interpret = JOptionPane.showInputDialog(null, "Interpret");
            if (interpret == null) {
                return;
            }
            if (interpret != null && interpret.length() == 0) {
                JOptionPane.showMessageDialog(null, "Interpret darf nicht leer sein!\nBitte erneut eingeben");
            } else {
                isInterpretValid = true;
            }

        } while (isInterpretValid == false);


        int dauer = 0;
        boolean isDauerValid = false;
        do {
            try {
                dauer = Integer.parseInt(JOptionPane.showInputDialog(null, "Dauer"));
                isDauerValid = true;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Bitte gültige Dauer eingeben");
            }
        } while (isDauerValid == false);

        Audio a = new Audio(titel, jahr, interpret, dauer);

        mt.aufnahme(a);
        JOptionPane.showMessageDialog(null, "Audio wurde erfolgreich hinzugefügt");
    }

    public void addNewBild() {
        String title = JOptionPane.showInputDialog(null, "Titel");
        int jahr = Integer.parseInt(JOptionPane.showInputDialog(null, "Jahr"));
        String ort = JOptionPane.showInputDialog(null, "Ort");


        Bild b1 = new Bild(title, jahr, ort);
        mt.aufnahme(b1);


    }


}