/*
Gruppe 006: Tomi, Sabreen, Esther.
Zahlenrätsel: Feld der Länge 2n
Zahlen von 1 bis N.
Jede Zahl soll genau zweimal vorkommen
zwischen beiden Platzierungen sollen für jede Zahl n exakt n andere zahlen in dem Feld stehen.
Klasse Riddle erstellen
 */

public class Riddle{

    //Klassenvariable, um Anzahl der Lösungen zu zählen
    static int Zaehler = 0;
    //riddle Methode für das zahlenrätsel

    //Wenn alle Zahlen erfolgreich platziert werden, gibt gefundene Lösung aus
    static void riddle(int [] array, int n, boolean print) {
        //Abbruchbediengung: Wenn n=0 ist haben wir eine Lösung gefunden.
        if (n == 0) {
            if (print) {
                //Ausgabe der gefundenen Lösung, beachte dabei die Spiegelung
                if(array[0] <= array[array.length - 1]) {

                    for (int i = 0; i < array.length; i++) {
                        System.out.print(array[i]);
                    }

                } else {
                    for(int p = array.length - 1; p >= 0; p--) {
                        System.out.print(array[p]);
                    }
                }
                System.out.println();
            }
            Zaehler = Zaehler + 1; //Zählen der gefundenen Lösungen
        }
        //minimalen Index für aktuelle Zahl ausrechnen
        int min;
        if (array.length == 2*n) {
            min = array.length/2 - n/2 - 1;
        } else min = 0;
        //Iteriere über mögliche Positionen für die aktuelle Zahl
        for (int i = array.length - 1; i >= min; i--) {
            //Überprüfe, ob Position für Zahl und ihre Spiegelung frei sind
            if (array[i] == 0 && (i + n + 1) < array.length && array[i + n + 1] == 0) {
                array[i] = n;
                array[i + n + 1] = n;
                //Methode wird rekursiv für die nächste Zahl aufgerufen
                riddle(array, n - 1, print);
                array[i] = 0;
                array[i + n + 1] = 0;
            }
        }
    }
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        //Erstellen eines Arrays mit der doppelten Länge N.
        int [] array = new int [2 * n];
        //Überprüfe, ob Lösungen gedruckt werden sollen(n<10)
        boolean print = n<10;
        riddle(array,n,print);
        // Ausgabe entsprechend der gefundenen Lösungen.
        if (Zaehler == 0) {
            System.out.println("keine Loesungen");
        } else if (Zaehler == 1) {
            System.out.println("eine Loesung");
        } else System.out.println(Zaehler + " Loesungen");
    }
}
