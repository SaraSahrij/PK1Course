package Praktikum;


import java.io.OutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public  abstract class Medium implements Comparable<Medium> , Serializable {
    private int id;
    private String title;
    private int jahr;
    private static int anzahl;

    private static final long serialVersionUID = 1L;


    public Medium() {
        this.id = anzahl++;
    }


    public Medium(String title, int jahr) {
        this.id = anzahl++;
        this.title = title;
        this.jahr = jahr;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getJahr() {
        return jahr;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    public int alter( ){
        LocalDateTime time = LocalDateTime.now();
        return time.getYear() - jahr;
    }

    public abstract void druckeDaten();
    public abstract void druckeDaten(OutputStream stream);


    @Override
    public int hashCode(){
       return Objects.hash(title, jahr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medium medium = (Medium) o;
        return jahr == medium.jahr && title.equals(medium.title);
    }

    @Override
    public int compareTo(Medium o) {
        return this.getJahr()- o.getJahr() ;
    }
}

