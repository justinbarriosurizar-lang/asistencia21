public class FiltroContador implements Filtro {
    private final int prioridad = 99;
    private int contador = 0;
    private String textoOriginal;

    @Override
    public String getNombreFiltro() {
        return "Filtro Contador";
    }

    @Override
    public int getPrioridad() {
        return prioridad;
    }

    /**
     * Se puede aplicar cuando hay entrada (texto no nulo y no vacío).
     */
    @Override
    public boolean validarAplicacion(String texto) {
        return texto != null && !texto.isEmpty();
    }

    @Override
    public String aplicarFiltro(String textoOriginal) {
        this.textoOriginal = textoOriginal;
        contador++; // la primera aplicación debe resultar en [aplicado:1]
        return textoOriginal + "[aplicado:" + contador + "]";
    }

    @Override
    public String obtenerTextoOriginal(String textoFiltrado) {
        return this.textoOriginal;
    }

    @Override
    public String explicacionDeFiltro() {
        return "Anexa al texto el contador de aplicaciones en el formato [aplicado:N].";
    }

    @Override
    public void reiniciar() {
        contador = 0;
        textoOriginal = null;
    }

    @Override
    public int compare(Filtro o1, Filtro o2) {
        return Integer.compare(o1.getPrioridad(), o2.getPrioridad());
    }
}

