// Gruppe 006: Tomi, Esther und Sabreen
// Weihnachtsplätzchen
//Sicherstellen von hohen Qualitaetsstandards
//einzelne Plätzchen sollen stichprobenartig ausgewählt und getestet werden.

public class PlaetzchenPruefer {
    public static void main(String[] args) {

        int anzahlPlaetzchen = Integer.parseInt(args[0]);
        int testcookies = pruefePlaetzchen(anzahlPlaetzchen);
        System.out.println("Anzahl der Plätzchen, die zu testen sind, beträgt: " + testcookies);
    }

    // Methode aufschreiben
    // rekursive Funktion zur Berechnung der zu testenden Plätzchen (NACH REIHENFOLGE)
    public static int pruefePlaetzchen(int anzahlPlaetzchen) {
        //Wenn keine Plätzchen vorliegen, dann kann auch keines probiert werden.
        if (anzahlPlaetzchen == 0) {
            System.out.println("Es kann leider keins getestet werden werden");
            return 0;
            //Wenn es nur ein Plätzchen gibt, soll auch nur eins getestet werden.
        } else if (anzahlPlaetzchen == 1) {
            return 1;
            //Wenn eine gerade Anzahl von Plätzchen vorliegt.
        } else if (anzahlPlaetzchen % 2 == 0) {
            //zwei werden getestet, deswegen müssen zwei auch abgezogen werden
            int half = (anzahlPlaetzchen-2) / 2;
            //Rekursion beginnt von Neuem mit der Hälfte der Plätzchen
            return 2 + pruefePlaetzchen(half);
            //Wenn eine ungerade Anzahl von Plätzchen vorliegt, genauso wie davor
        } else {
            int getestetePlaetzchen= 1;
            int cookiesleft = anzahlPlaetzchen - 1;
            //Anzahl der Cookies sind wieder Gerade.
            return getestetePlaetzchen + pruefePlaetzchen(cookiesleft);
        }
    }
}
