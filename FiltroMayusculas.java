public class FiltroMayusculas implements Filtro {
    private final int prioridad = 20;
    private String textoOriginal; // guarda el texto antes de aplicar el filtro

    @Override
    public String getNombreFiltro() {
        return "Filtro Mayúsculas";
    }

    @Override
    public int getPrioridad() {
        return prioridad;
    }

    /**
     * El filtro se puede aplicar si el texto contiene al menos una letra.
     */
    @Override
    public boolean validarAplicacion(String texto) {
        return texto != null && texto.matches(".*[A-Za-zÁÉÍÓÚáéíóú].*");
    }

    @Override
    public String aplicarFiltro(String textoOriginal) {
        this.textoOriginal = textoOriginal;
        return textoOriginal != null ? textoOriginal.toUpperCase() : null;
    }

    @Override
    public String obtenerTextoOriginal(String textoFiltrado) {
        // devolvemos el texto que recibimos cuando se aplicó el filtro
        return this.textoOriginal;
    }

    @Override
    public String explicacionDeFiltro() {
        return "Convierte todo el texto a mayúsculas siempre que contenga alguna letra.";
    }

    @Override
    public void reiniciar() {
        // no hay estado interno que resetear
        this.textoOriginal = null;
    }

    // Comparator por prioridad (heredado de la interfaz, pero lo dejamos explícito)
    @Override
    public int compare(Filtro o1, Filtro o2) {
        return Integer.compare(o1.getPrioridad(), o2.getPrioridad());
    }
}

