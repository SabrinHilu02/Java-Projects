// Banner-Aufgabe: angegebene ganze Zahl wird aus #-Zeichen als Font ausgegeben
// Besprechung mit Dr. Ahrens

public class Banner {

    // Definition des Zeichensatzes für 0123456789-

    static String[][] fontChars = {{

            "  ###   ",
            " #   #  ",
            "#     # ",
            "#     # ",
            "#     # ",
            " #   #  ",
            "  ###   "}, {
            "   #    ",
            "  ##    ",
            " # #    ",
            "   #    ",
            "   #    ",
            "   #    ",
            " #####  "}, {
            " #####  ",
            "#     # ",
            "      # ",
            " #####  ",
            "#       ",
            "#       ",
            "####### "}, {
            " #####  ",
            "#     # ",
            "      # ",
            " #####  ",
            "      # ",
            "#     # ",
            " #####  "}, {
            "#       ",
            "#    #  ",
            "#    #  ",
            "#    #  ",
            "####### ",
            "     #  ",
            "     #  "}, {
            "####### ",
            "#       ",
            "#       ",
            "######  ",
            "      # ",
            "#     # ",
            " #####  "}, {
            " #####  ",
            "#     # ",
            "#       ",
            "######  ",
            "#     # ",
            "#     # ",
            " #####  "}, {
            "####### ",
            "#    #  ",
            "    #   ",
            "   #    ",
            "  #     ",
            "  #     ",
            "  #     "}, {
            " #####  ",
            "#     # ",
            "#     # ",
            " #####  ",
            "#     # ",
            "#     # ",
            " #####  "}, {
            " #####  ",
            "#     # ",
            "#     # ",
            " ###### ",
            "      # ",
            "#     # ",
            " #####  "}, {
            "        ",
            "        ",
            "        ",
            " #####  ",
            "        ",
            "        ",
            "        "}};

    public static void main(String[] args) {

        // fontChars[0][]

        // eine Zahl als einziges Argument

        String a = args[0];
        char[] b = a.toCharArray(); // String > char

        // Jede Zahl im Font nimmt 7 Reihen ein.

        for (int row = 0; row < 7; row++) {
            for (int i = 0; i < b.length; i++) {

                // Bei jeder Schleife speichern aktuelle Zeichen in b in c um.

                char c = b[i];

                // alternativ: ASCII-WERT

                int j;
                if (c < '0' || c > '9') {

                    // Wenn das Zeichen nicht zw. 0-9 liegt, wird j auf 10 (-) gesetzt.

                    j = 10;

                } else {

                    // Wenn das Zeichen eine Ziffer ist, wird die Zahl ausgegeben.

                    j = c - '0';
                }

                System.out.print(fontChars[j][row]);
            }

            System.out.println();
        }
    }
}
