import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static String textoOriginal = "";
    private static String textoResultado = "";
    private static final List<Filtro> filtros = new ArrayList<>();

    public static void main(String[] args) {
        // inicializar filtros
        filtros.add(new FiltroMayusculas());
        filtros.add(new FiltroContador());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--- Menú ---");
            System.out.println("1. Ingresar texto");
            System.out.println("2. Listar filtros y explicaciones");
            System.out.println("3. Aplicar filtro (selección)");
            System.out.println("4. Aplicar ambos filtros por prioridad");
            System.out.println("5. Mostrar texto original y resultante");
            System.out.println("6. Reiniciar filtros y texto");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    ingresarTexto(scanner);
                    break;
                case "2":
                    listarFiltros();
                    break;
                case "3":
                    aplicarFiltroSeleccion(scanner);
                    break;
                case "4":
                    aplicarAmbos();
                    break;
                case "5":
                    mostrarTextos();
                    break;
                case "6":
                    reiniciar();
                    break;
                case "7":
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void ingresarTexto(Scanner scanner) {
        System.out.print("Ingrese el texto: ");
        textoOriginal = scanner.nextLine();
        textoResultado = textoOriginal;
        reiniciarFiltros();
        System.out.println("Texto guardado y filtros reiniciados.");
    }

    private static void listarFiltros() {
        System.out.println("Filtros disponibles:");
        for (Filtro f : filtros) {
            System.out.println("- " + f.getNombreFiltro() + " (prioridad " + f.getPrioridad() + ") : " + f.explicacionDeFiltro());
        }
    }

    private static void aplicarFiltroSeleccion(Scanner scanner) {
        System.out.println("Seleccione filtro:");
        for (int i = 0; i < filtros.size(); i++) {
            Filtro f = filtros.get(i);
            System.out.println((i + 1) + ". " + f.getNombreFiltro());
        }
        System.out.print("Número: ");
        String numStr = scanner.nextLine();
        try {
            int idx = Integer.parseInt(numStr) - 1;
            if (idx < 0 || idx >= filtros.size()) {
                System.out.println("Número fuera de rango.");
                return;
            }
            Filtro filtro = filtros.get(idx);
            if (filtro.validarAplicacion(textoResultado)) {
                textoResultado = filtro.aplicarFiltro(textoResultado);
                System.out.println("Filtro aplicado. Resultado: " + textoResultado);
            } else {
                System.out.println("El filtro no es aplicable al texto actual.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada no numérica.");
        }
    }

    private static void aplicarAmbos() {
        // ordenar por prioridad ascendente (mayor precedencia = menor número)
        List<Filtro> ordenados = new ArrayList<>(filtros);
        Collections.sort(ordenados, (a, b) -> Integer.compare(a.getPrioridad(), b.getPrioridad()));
        for (Filtro f : ordenados) {
            if (f.validarAplicacion(textoResultado)) {
                textoResultado = f.aplicarFiltro(textoResultado);
                System.out.println("Aplicado " + f.getNombreFiltro() + ": " + textoResultado);
            } else {
                System.out.println("Filtro " + f.getNombreFiltro() + " no aplicable, se salta.");
            }
        }
    }

    private static void mostrarTextos() {
        System.out.println("Texto original: " + textoOriginal);
        System.out.println("Texto resultante: " + textoResultado);
    }

    private static void reiniciar() {
        reiniciarFiltros();
        textoResultado = textoOriginal;
        System.out.println("Filtros reiniciados y texto restaurado al original.");
    }

    private static void reiniciarFiltros() {
        for (Filtro f : filtros) {
            f.reiniciar();
        }
    }
}
