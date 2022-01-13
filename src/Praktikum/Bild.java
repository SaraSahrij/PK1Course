package Praktikum;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Objects;

public class Bild extends Medium{

    private String ort;
    private static final long serialVersionUID = 3L;

    public Bild() {
        super();
    }

    public Bild(String title, int jahr, String ort) {
        super(title, jahr);
        this.ort = ort;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public void druckeDaten() {
        System.out.println("ID = " + getId() + " \"" + getTitle() + "\" aufgenommen im Jahr "+ getJahr() + " in " +  ort );
    }
    @Override
    public void druckeDaten(OutputStream stream){
        PrintWriter pw = new PrintWriter(stream);
        pw.printf("ID = %d \" %s \" aufgenommen im Jahr %d in %s \n" , getId(), getTitle(), getJahr() ,ort);
        pw.flush();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ort);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bild bild = (Bild) o;
        return ort.equals(bild.ort);
    }
}
