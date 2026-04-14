public class Caesar {
    public static void main(String[] args) {
        // Parametereingabe
        int K = Integer.parseInt(args[0]);



        for (int i = 1; i < args.length; i++) {
            // Index beginnt bei 1, weil der erste Index schon für K schon benutzt wird
            char[] nachricht = args[i].toCharArray();
            //notwendig, damit wir auf jedes einzelelne Element zugreifen können.
            for (char e : nachricht) {
                //for- each Schleife
                if (e >= 'a' && e <= 'z') {
                    //ASCII - WERT
                    e = (char) ((((e - 'a') - K) + 26) % 26 + 'a');
                    System.out.print(e);
                } else if (e >= 'A' && e <= 'Z') {
                    e = (char) ((((e - 'A') -K) + 26) % 26 + 'A');
                    System.out.print(e);
                } else {
                    System.out.print(e);
                }
            }
        }
        System.out.println();
    }
}
