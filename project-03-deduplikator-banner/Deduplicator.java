// Deduplikator: kann Zahlen per Kommandozeilenargument als String übergeben. Es wandelt die Zahl in double um.
// Gleichwertige Zahlen werden nicht erneut ausgegeben.


// Hilfe von Dorian Weber (Praktikum)
// zuerst: als String in der Kommandozeile vorhandenen Zahlen zu double konvertieren
// da es eine endliche Anzahl von Zahlen gibt: array

public class Deduplikator {
    public static void main(String[] args) {
        double[] Zahlenwerte = new double[args.length];
        for (int i = 0; i < args.length; i++) {
            Zahlenwerte[i] = Double.parseDouble(args[i]);
        }

        Ausgabe(Zahlenwerte);
    }

// public ist nicht zwingend notwendig

    // Methode zu überprüfen, ob Zahlen im array evtl. übereinstimmen

    // Liste soll weitergehen, auch wenn die Zahl doppelt oder mehrfach auftritt (Vermutung: break und zwei for-Schleifen)

static void Ausgabe(double[] Zahlenwerte) {
    for (int i = 0; i < Zahlenwerte.length; i++) {

        // Mit der zweiten Schleife wird überprüft, ob die aktuelle Zahl bereits in den vorherigen Positionen war.

        int l;
        for (l = 0; l < i; l++) {
            if (Zahlenwerte[i] == Zahlenwerte[l]) {
                break;
            }
        }

        // Die Schleife soll nach dem break weitergehen.

        // "l" ist dabei immer auf i-1 verschoben.

        if (l == i) {
            System.out.println(Zahlenwerte[i]);
            }
        }
    }
}
