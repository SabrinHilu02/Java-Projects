// Gruppe 006: Tomi, Esther und Sabreen
// rekursives Programm zur Berechnung und Darstellung einer Koch-Schneeflocke
/**
 Klasse KochSchneeflocke zeichnet eine fraktale Schneeflocke.
 Zum Kompilieren und ausfuehren wird die Klasse StdDraw der
 Bibliothek stdlib.jar genutzt.

 Dokumentation zur stdlib:
 https://introcs.cs.princeton.edu/java/stdlib/

 Download:
 https://introcs.cs.princeton.edu/java/stdlib/stdlib.jar

 Dokumentation der Klasse StdDraw:
 https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html

 Beispiel: kompilieren unter Linux/OSX und Windows:
 javac -cp stdlib.jar KochSchneeflocke.java

 Beispielaufruf Linux/OSX:
 java -cp .:stdlib.jar KochSchneeflocke 2 1.0

 Beispielaufruf Windows:
 java -cp ".;stdlib.jar" KochSchneeflocke 2 1.0

 */

public class KochSchneeflocke
{

    public static void main(String[] args)
    {
        // Parameter ist die gewuenschte Tiefe
        int depth = Integer.parseInt(args[0]);

        // Initialisiere Zeichenflaeche:
        // Setze die Aufloesung und die Groesse,
        // sodass die Schneeflocke gut sichtbar ist
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(-0.3, 1.3);
        StdDraw.setYscale(-0.5, 1.0);

        // Optional: schalte double-buffering ein um schnell zu zeichnen.
        // Das Zeichnen erfolgt dann im Hintegrund und wird erst
        // angezeigt, wenn StdDraw.show() aufgerufen wird (siehe unten)
        //StdDraw.enableDoubleBuffering();

        // Definiere die Punkte eines gleichschenkligen Dreiecks:
        //   a = (0,0), b = (0.5, sqrt(3)/2), c = (1, 0)
        double ax = 0.0;
        double ay = 0.0;

        double bx = 0.5;
        double by = Math.sqrt(3.0) / 2.0;

        double cx = 1.0;
        double cy = 0.0;

        // Rufe fuer jede Seite des Dreiecks die rekursive Funktion
        // zum Zeichnen der Kochkurve auf.
        zeichneKochKurve(depth, ax, ay, bx, by);
        zeichneKochKurve(depth, bx, by, cx, cy);
        zeichneKochKurve(depth, cx, cy, ax, ay);

        // Optional: zeige, dass was im Hintergund gezeichnet wurde
        // (wenn double-buffering eingeschaltet ist)
        //StdDraw.show();
    }

    /**
     * Zeichnet rekrusiv eine Kochkurve mit der uebergebenen Tiefe
     * im Linienabschnitt von (x1,y1) nach (x5, y5).
     *
     * Fuer tiefe=0 zeichnet die Funktion einfach eine Linie von (x1,y1) nach (x5,y5) (Rekursionsanker).
     * Fuer tiefe>0 ruft sich die Funktion viermal selbst mit tiefe-1 und den entsprechenden Koordinaten
     * fuer die 4 Teilstücke wieder auf (Rekursionsschritt).
     *
     * @param n     - Aktuelle Tiefe der Kochkurve
     * @param x1    - x-Koordinate des Beginns des akutellen Linienabschnitts
     * @param y1    - y-Koordinate des Beginns des aktuellen Linienabschnitts
     * @param x5    - x-Koordinate des Endes des aktuellen Linienabschnitts
     * @param y5    - y-Koordinate des Endes des aktuellen Linienabschnitts
     */
    private static void zeichneKochKurve(int n, double x1, double y1, double x5, double y5) {
        //Für n = 0 zeichnet zeichneKochKurve einfach eine Linie von (x1,y1) nach (x5,y5)
        if (n == 0) {
            StdDraw.line(x1, y1, x5, y5);
        } else {
            //Array erstellen für die x und y-Werte.
            double[] x = berechnePunkteX(x1, x5, y1, y5);
            double[] y = berechnePunkteY(x1, x5, y1, y5);
//Für n > 0 ruft sich die Funktion vier mal selbst mit n - 1 und den entsprechenden Koordinaten für die 4 Teilstücke wieder auf
            for (int i = 0; i < 4; i++) {
                zeichneKochKurve(n - 1, x[i], y[i], x[i + 1], y[i + 1]);
            }
        }
    }

    //Definition der x-Werte(Nach Aufgabenstellung+Reihenfolge)
    private static double[] berechnePunkteX(double x1, double x5, double y1, double y5) {
        double[] x = new double[5];
        x[0] = x1;
        x[1] = x1 + (1.0 / 3.0) * (x5 - x1);
        x[2] = (1.0 / 2.0) * (x1 + x5) + (Math.sqrt(3) / 6.0) * (y1 - y5);
        x[3] = x1 + (2.0 / 3.0) * (x5 - x1);
        x[4] = x5;
        return x;
    }
//Definition der y-Werte (Nach Aufgabenstellung)
    private static double[] berechnePunkteY(double x1, double x5, double y1, double y5) {
        double[] y = new double[5];
        y[0] = y1;
        y[1] = y1 + (1.0 / 3.0) * (y5 - y1);
        y[2] = (1.0 / 2.0) * (y1 + y5) + (Math.sqrt(3) / 6.0) * (x5 - x1);
        y[3] = y1 + (2.0 / 3.0) * (y5 - y1);
        y[4] = y5;
        return y;
    }
}


