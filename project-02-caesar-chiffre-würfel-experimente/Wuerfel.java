public class wuerfel {
    public static void main(String[] args) {
        

        // Parameter erstellen
        int N = Integer.parseInt(args[0]); // Anzahl der Seiten des Würfels
        int K = Integer.parseInt(args[1]); // Gewinnfolge zum Gewinnen der Spiele
        int S = Integer.parseInt(args[2]); // Anzahl der Spiele

        
        double durchschnittlicheWuerfe = spielefuerDurchschnittlicheWuerfe(N, K, S);

        
        System.out.println(durchschnittlicheWuerfe);
    }

    // Methode erstellen und danach verwenden
    private static double spielefuerDurchschnittlicheWuerfe(int N, int K, int S) {
        int gesamtWuerfe = 0;

        
        for (int i = 0; i < S; i++) {
            int aufeinanderfolgendeWuerfe = 0;

            // Würfe, bis die Gewinnfolge erreicht ist
            while (aufeinanderfolgendeWuerfe < K) {
                int wurf = (int) (Math.random() * N) + 1; 
                if (wurf == N) {
                    aufeinanderfolgendeWuerfe++;
                } else {
                    aufeinanderfolgendeWuerfe = 0;
                }
                gesamtWuerfe++;
            }
        }

        
        return (double) gesamtWuerfe / S;
    }
}
