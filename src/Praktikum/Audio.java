package Praktikum;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Objects;

public class Audio extends Medium {

    private String interpret;
    private int dauer;
    private static final long serialVersionUID = 2L;


    public Audio() {
        super();
    }

    public Audio( String title, int jahr, String interpret, int dauer) {
        super( title, jahr);
        this.interpret = interpret;
        this.dauer = dauer;
    }

    public String getInterpret() {
        return interpret;
    }

    public int getDauer() {
        return dauer;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    @Override
    public void druckeDaten() {
        System.out.println("ID = " + getId() + " \"" + getTitle() + "\" von " + getInterpret() +
                " aus " + getJahr() + " Spieldauer: " + getDauer() + " sek.") ;
    }
    @Override
    public void druckeDaten(OutputStream stream){
        PrintWriter pw = new PrintWriter(stream);
        pw.printf("ID = %d \" %s \" von %s aus %d Spieldauer: %d sek.\n" , getId(), getTitle(), getInterpret(),getJahr() ,getDauer());
        pw.flush();
    }

 @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), interpret, dauer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Audio audio = (Audio) o;
        return dauer == audio.dauer && interpret.equals(audio.interpret);
    }
}
