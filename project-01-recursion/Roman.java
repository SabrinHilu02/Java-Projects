/*
Roemische Zahlen
Gruppe 006: Tomi, Sabreen, Esther
positive ganze Zahl in Bereich von 1 bis 5000 in römische Zahlschrift umwandeln
Quelltextfragment soll als Ausgangspunkt dienen.
 */

public class Roman {
    //Array für Zahlen erstellen (beliebig)
    static int[] values  = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    //Array für römische Zahlen erstellen.
    static String[] rom_values = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    static String roman(int n) {
        //Die Funktion greift auf die Funktion romanconverter zu.
        //Ausgangspunkt ist bei uns immer der Index 0
        return romanconverter(n, 0);
    }
//Rekursion bzw. Methode erstellen: Theoretisch kann man es auch iterativ machen.
    private static String romanconverter(int n, int index) {
        if (n == 0) return "";
        if (n >= values[index]) {
            //Die gleiche römische Ziffer wird nebeneinander hinzugefügt, wenn der Wert n nicht kleiner als values[index] ist.
            return rom_values[index] + romanconverter(n - values[index], index);
        }
        //Bewegt sich zur nächsten römischen Zahl, Rekursion beginnt von Neuem.
        else{
            return romanconverter(n, index + 1);}
    }

    public static void main(String[] args)
    {
        //Behandlung fehlender oder falscher Eingabeparameter
        if (args.length == 0)
        {
            System.out.println("Bitte eine Zahl als Parameter angeben.");
            System.exit(-1);
        }
        int N = Integer.parseInt(args[0]);
        if (N < 1 || N > 5000)
        {
            System.out.println("Die Zahl muss zwischen 1 und 5000 liegen.");
            System.exit(-1);
        }

        assert(1<=N && N<=5000);
        System.out.println(roman(N));
    }
}
