public class FiltroPalabrota implements IFiltro, Comparable<IFiltro>, Iterable<String> {

    String[] palabrotas = {"palabrota1", "palabrota2", "papapoi"};

    private String textoOriginal;
    private int prioridad = 15;

    public FiltroPalabrota(String textoOriginal) {
        this.textoOriginal = textoOriginal;
    }

    @Override
    public String getNombreFiltro() {
        return "Filtro de Palabrotas";
    }

    @Override
    public int getPrioridad() {
        return prioridad;
    }

    @Override
     /**
      *  Validar si el filtro se puede aplicar al texto dado.
      *  @param texto El texto sobre el cual se aplicará el filtro.
      *  @return true si el filtro se puede aplicar, false en caso contrario.
    **/
    public boolean validarAplicacion(String texto) {
        return texto != null && !texto.isEmpty() && palabrotas.length > 0 && containsPalabrota(texto);
    }

    @Override
    public String obtenerTextoOriginal(String textoFiltrado) {
        return this.textoOriginal;
    }

    @Override
    public String aplicarFiltro(String textoOriginal) {
        this.textoOriginal = textoOriginal;
        return textoOriginal.replaceAll("(?i)\\b(palabrota1|palabrota2|papapoi)\\b", "***");
    }
    
    private boolean containsPalabrota(String texto) {
        for (String palabrota : palabrotas) {
            if (texto.toLowerCase().contains(palabrota.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String explicacionDeFiltro() {
        return "Este filtro reemplaza las palabrotas de una lista por asteriscos.";
    }
}
