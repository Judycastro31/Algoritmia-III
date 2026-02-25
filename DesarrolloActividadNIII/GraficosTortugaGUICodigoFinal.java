import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;

public class GraficosTortugaGUI extends JPanel {
    static char[][] t = new char[30][30];
    static int x = 0, y = 0, d = 2, l = 0;
    static char c = '*';
    static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static ArrayList<String> instrucciones = new ArrayList<>();

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
        JFrame v = new JFrame("Algoritmia Unidad 3");
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
        System.out.println("\n===== MENÚ Autores: Judy y Andres =====");
        System.out.println("1. Elegir Caracter");
        System.out.println("2. Girar Izquierda (GI)");
        System.out.println("3. Girar Derecha (GD)");
        System.out.println("4. Avanzar (AV)");
        System.out.println("5. Bajar Lapiz (BL)");
        System.out.println("6. Levantar Lapiz (SL)");
        System.out.println("7. Borrar (BO)");
        System.out.println("8. Mostrar Tablero");
        System.out.println("9. Ver Instrucciones");
        System.out.println("10. Guardar Instrucciones");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");

        return scanner.nextInt();
    }

   private static void procesarOpcion(int op, Scanner scanner) {

        switch (op) {

            case 1:
                System.out.print("Ingrese caracter: ");
                c = scanner.next().charAt(0);
                instrucciones.add("Caracter " + c);
                break;

            case 2:
                System.out.print("Ingrese ángulo (solo 45): ");
                int ai = scanner.nextInt();
                if (ai == 45) {
                    d = (d - 1 + 8) % 8;
                    instrucciones.add("GI 45");
                } else {
                    System.out.println("Solo se permite girar 45 grados.");
                }
                break;

            case 3:
                System.out.print("Ingrese ángulo (solo 45): ");
                int ad = scanner.nextInt();
                if (ad == 45) {
                    d = (d + 1) % 8;
                    instrucciones.add("GD 45");
                } else {
                    System.out.println("Solo se permite girar 45 grados.");
                }
                break;

            case 4:
                System.out.print("Pasos a avanzar: ");
                int p = scanner.nextInt();
                instrucciones.add("AV " + p);
                avanzar(p);
                break;

            case 5:
                l = 1;
                t[x][y] = c;
                instrucciones.add("BL");
                break;

            case 6:
                l = 0;
                instrucciones.add("SL");
                break;

            case 7:
                l = 2;
                instrucciones.add("BO");
                break;

            case 8:
                mostrarVentana();
                break;

            case 9:
                System.out.println("\n=== Instrucciones Ejecutadas ===");
                for (String ins : instrucciones)
                    System.out.println(ins);
                break;

            case 10:
                guardarInstrucciones();
                break;
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

    private static void guardarInstrucciones() {
        try {
            PrintWriter pw = new PrintWriter("instrucciones.txt");
            for (String ins : instrucciones)
                pw.println(ins);
            pw.close();
            System.out.println("Instrucciones guardadas correctamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo.");
        }
    }

    public static ArrayList<String> getInstrucciones() {
        return instrucciones;
    }

}
