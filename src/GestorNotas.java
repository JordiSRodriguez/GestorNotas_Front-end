import java.io.*;
import java.util.Scanner;

public class GestorNotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
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
                    System.out.println("Introduce el id: ");
                    int id = sc.nextInt();
                    System.out.println("Introduce la nota: ");
                    double nota = Double.parseDouble(sc.next());
                    try {
                        Process p = Runtime.getRuntime().exec("java -jar Gestor.jar w notas.txt " + id + " " + nota);
                        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                        br.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 2 -> {
                    System.out.println("Introduce el id: ");
                    int id = sc.nextInt();
                    try {
                        Process p = Runtime.getRuntime().exec("java -jar Gestor.jar r notas.txt " + id);
                        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                        br.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 3 -> {
                    System.out.println("Introduce el id: ");
                    int id = sc.nextInt();
                    System.out.println("Introduce la nota: ");
                    double nota = Double.parseDouble(sc.next());
                    try {
                        Process p = Runtime.getRuntime().exec("java -jar Gestor.jar m notas.txt " + id + " " + nota);
                        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                        br.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 4 -> {
                    System.out.println("Introduce el id: ");
                    int id = sc.nextInt();
                    try {
                        Process p = Runtime.getRuntime().exec("java -jar Gestor.jar d notas.txt " + id);
                        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                        br.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 5 -> {
                    for (int i = 0; i < 100; i++) {
                        int id = (int) (Math.random() * 100 + 1);
                        double nota = (double) Math.round(Math.random() * 1000)/100;
                        try {
                            Process p = Runtime.getRuntime().exec("java -jar Gestor.jar w notas.txt " + id + " " + nota);
                            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                            String line;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                            br.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                case 6 -> {
                    try {
                        Process p = Runtime.getRuntime().exec("java -jar Gestor.jar r notas.txt -1");
                        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                        br.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción incorrecta");
            }
        } while (opcion != 0);
    }
}
