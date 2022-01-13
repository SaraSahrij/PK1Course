package Vorlesungen.Aufgabe5Und6;

public class Main {
    public static  void  main(String[] args){
        Angestellter a = new Angestellter("James Gosling", 5000.00);
        Angestellter m = new Manager("Bill Gates", 6000.00, 50000.00);

        Object o = new Manager("Bill Gates", 6000.00, 50000.00);

       // System.out.println(a.getName() + " erhält " + a.berechneJahresgehalt());
        //System.out.println(m.getName() + " erhält " + m.berechneJahresgehalt());

        a = new Manager("Tom Meier", 6500.00, 20000.00);
       // System.out.println(a.getName() + " erhält " + a.berechneJahresgehalt());


    }
}

