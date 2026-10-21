import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        System.out.println("Ingrese el texto para aplicar el filtro");

         Scanner scanner = new Scanner(System.in);
         
         String texto = scanner.nextLine();
         System.out.println("Texto ingresado: " + texto);

        //IFiltro[] filtros = new IFiltro[19];

        IFiltro filtroPalabrota = new FiltroPalabrota(texto);

        String textoFiltrado = filtroPalabrota.aplicarFiltro(texto);

        if (filtroPalabrota.validarAplicacion(texto)) {
        System.out.println("Texto filtrado: " + textoFiltrado);

    }

}
