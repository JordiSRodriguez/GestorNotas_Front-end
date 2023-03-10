import java.io.*;
import java.util.Scanner;

public class GestorNotas {

    /**
     * La ruta del archivo.
     */
    private static String path;

    /**
     * El main donde se ejecuta el programa.
     * @param args Los argumentos.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scL = new Scanner(System.in);
        int opcion = 0;
        System.out.println("Introduce el nombre del fichero: ");
        path = scL.nextLine();
        do {
            System.out.println("1.Escribir una nota");
            System.out.println("2.Leer una nota");
            System.out.println("3.Modificar una nota");
            System.out.println("4.Eliminar una nota");
            System.out.println("5.Generar 100 ids y notas aleatorias");
            System.out.println("6.Leer todas las notas");
            System.out.println("0.Salir");
            System.out.println("Elige una opción: ");

            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    write(sc);
                }
                case 2 -> {
                    read(sc);
                }
                case 3 -> {
                    modify(sc);
                }
                case 4 -> {
                    delete(sc);
                }
                case 5 -> {
                    random100();
                }
                case 6 -> {
                    readAll();
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción incorrecta");
            }
        } while (opcion != 0);
    }

    /**
     * Escribir una nota de un estudiante concreto indicando su id y su nota.
     * @param sc El scanner.
     * @throws IOException                    Si no se puede acceder al fichero.
     * @throws NumberFormatException          Si el id no es un número.
     * @throws ArrayIndexOutOfBoundsException Si no se pasan los argumentos correctos.
     * @throws FileNotFoundException          Si no se encuentra el fichero.
     */
    private static void write(Scanner sc) {
        System.out.println("Introduce el id: ");
        int id = sc.nextInt();
        System.out.println("Introduce la nota: ");
        double nota = Double.parseDouble(sc.next());
        try {
            Process p = Runtime.getRuntime().exec("java -jar Gestor.jar w " + path + " " + id + " " + nota);
            flujoDatos(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee una nota de un estudiante concreto indicando su id.
     * @param sc El scanner.
     * @throws IOException                    Si no se puede acceder al fichero.
     * @throws NumberFormatException          Si el id no es un número.
     * @throws ArrayIndexOutOfBoundsException Si no se pasan los argumentos correctos.
     * @throws FileNotFoundException          Si no se encuentra el fichero.
     */
    private static void read(Scanner sc) {
        System.out.println("Introduce el id: ");
        int id = sc.nextInt();
        try {
            Process p = Runtime.getRuntime().exec("java -jar Gestor.jar r " + path + " " + id);
            flujoDatos(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Modifica una nota de un estudiante concreto indicando su id y su nota.
     * @param sc El scanner.
     * @throws IOException                    Si no se puede acceder al fichero.
     * @throws NumberFormatException          Si el id no es un número.
     * @throws ArrayIndexOutOfBoundsException Si no se pasan los argumentos correctos.
     * @throws FileNotFoundException          Si no se encuentra el fichero.
     */
    private static void modify(Scanner sc) {
        System.out.println("Introduce el id: ");
        int id = sc.nextInt();
        System.out.println("Introduce la nota: ");
        double nota = Double.parseDouble(sc.next());
        try {
            Process p = Runtime.getRuntime().exec("java -jar Gestor.jar m " + path + " " + id + " " + nota);
            flujoDatos(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina una nota de un estudiante concreto indicando su id.
     * @param sc El scanner.
     * @throws IOException                    Si no se puede acceder al fichero.
     * @throws NumberFormatException          Si el id no es un número.
     * @throws ArrayIndexOutOfBoundsException Si no se pasan los argumentos correctos.
     * @throws FileNotFoundException          Si no se encuentra el fichero.
     */
    private static void delete(Scanner sc) {
        System.out.println("Introduce el id: ");
        int id = sc.nextInt();
        try {
            Process p = Runtime.getRuntime().exec("java -jar Gestor.jar d " + path + " " + id);
            flujoDatos(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Genera 100 ids y notas aleatorias.
     * @throws IOException                    Si no se puede acceder al fichero.
     * @throws NumberFormatException          Si el id no es un número.
     * @throws ArrayIndexOutOfBoundsException Si no se pasan los argumentos correctos.
     * @throws FileNotFoundException          Si no se encuentra el fichero.
     */
    private static void random100() {
        for (int i = 0; i < 100; i++) {
            int id = (int) (Math.random() * 100 + 1);
            double nota = (double) Math.round(Math.random() * 1000) / 100;
            try {
                Process p = Runtime.getRuntime().exec("java -jar Gestor.jar w " + path + " " + id + " " + nota);
                flujoDatos(p);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Lee todas las notas.
     * @throws IOException                    Si no se puede acceder al fichero.
     * @throws NumberFormatException          Si el id no es un número.
     * @throws ArrayIndexOutOfBoundsException Si no se pasan los argumentos correctos.
     * @throws FileNotFoundException          Si no se encuentra el fichero.
     */
    private static void readAll() {
        try {
            Process p = Runtime.getRuntime().exec("java -jar Gestor.jar r " + path + " -1");
            flujoDatos(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee el flujo de datos del proceso con InputStream y BufferedReader.
     * @param p El proceso.
     * @throws IOException Si no se puede acceder al fichero.
     */
    private static void flujoDatos(Process p) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
