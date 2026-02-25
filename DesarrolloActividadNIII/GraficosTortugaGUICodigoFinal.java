import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class GraficosTortugaGUI extends JPanel {
    static char[][] t = new char[30][30];
    static int x = 0, y = 0, d = 2, l = 0;
    static char c = '*';
    static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public GraficosTortugaGUI() {
        setPreferredSize(new Dimension(600, 600));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 30; i++)
            for (int j = 0; j < 30; j++)
                if (t[i][j] != ' ') g.fillRect(j * 20, i * 20, 20, 20);
    }

    public static void mostrarVentana() {
        JFrame v = new JFrame("Tortuga Gráfica");
        v.add(new GraficosTortugaGUI());
        v.pack();
        v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inicializarTablero();
        int op;
        while ((op = mostrarMenu(scanner)) != 0) procesarOpcion(op, scanner);
        scanner.close();
    }

    private static void inicializarTablero() {
        for (int i = 0; i < 30; i++) for (int j = 0; j < 30; j++) t[i][j] = ' ';
    }

    private static int mostrarMenu(Scanner scanner) {
        System.out.println("1. Caracter 2. GI 3. GD 4. AV 5. BL 6. SL 7. BO 8. Mostrar 0. Salir");
        return scanner.nextInt();
    }

    private static void procesarOpcion(int op, Scanner scanner) {
        switch (op) {
            case 1: c = scanner.next().charAt(0); break;
            case 2:
                int ang = scanner.nextInt();
                if (ang % 45 == 0) {
                    d = (d - ang / 45 + 8) % 8;
                } else {
                   System.out.println("El ángulo debe ser múltiplo de 45");
                }
            break;
            case 3:
               int ang2 = scanner.nextInt();
               if (ang2 % 45 == 0) {
                   d = (d + ang2 / 45) % 8;
               } else {
                 System.out.println("El ángulo debe ser múltiplo de 45");
               }
            break;
            case 4: avanzar(scanner.nextInt()); break;
            case 5: t[x][y] = c; l = 1; break;
            case 6: l = 0; break;
            case 7: t[x][y] = ' '; l = 2; break;
            case 8: mostrarVentana(); break;
        }
    }

    private static void avanzar(int pasos) {
        for (int i = 0; i < pasos; i++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx >= 0 && nx < 30 && ny >= 0 && ny < 30) {
                x = nx; y = ny; if (l == 1) t[x][y] = c; if (l == 2) t[x][y] = ' ';
            }
        }
    }
} 
