public interface Filtro extends java.util.Comparator<Filtro> {
    // Nombre del filtro
    String getNombreFiltro();

    // Prioridad: menor número → mayor precedencia
    int getPrioridad();

    // Determina si el filtro puede aplicarse al texto dado
    boolean validarAplicacion(String texto);

    // Aplica el filtro y devuelve el texto resultante
    String aplicarFiltro(String textoOriginal);

    // Explicación legible del filtro
    String explicacionDeFiltro();

    // Devuelve el texto original a partir del filtrado (no usado aquí pero requerido por el PDF)
    String obtenerTextoOriginal(String textoFiltrado);

    // Reinicia el estado interno del filtro (p.ej. contador)
    void reiniciar();

    // Comparator por prioridad ascendente
    @Override
    default int compare(Filtro o1, Filtro o2) {
        return Integer.compare(o1.getPrioridad(), o2.getPrioridad());
    }
}

