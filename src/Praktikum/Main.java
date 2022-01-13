package Praktikum;

public class Main {
    public static void main(String[] args) {
      //  Audio a1 = new Audio("It Means Nothing", 2007, "Stereophonics", 229);
        //Audio a2 = new Audio("Sara", 2021, "Sara", 500);

        //Bild b1 = new Bild("Gebaeude FB Informatik", 2019, "Dortmund");
        //Bild b2 = new Bild("Sara", 2022, "München");

        Medienverwaltung_Typsicheren mv = new Medienverwaltung_Typsicheren();




        //mv.zeigeMedien();

       Menu menu = new Menu(mv);
       menu.zeigeMenue();
    }
}
