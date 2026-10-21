public interface IFiltro {

    public String getNombreFiltro();

    public int getPrioridad();

     /**
        Validar si el filtro se puede aplicar al texto dado.
        @param texto El texto sobre el cual se aplicará el filtro.
        @return true si el filtro se puede aplicar, false en caso contrario.
    */
    public boolean validarAplicacion(String texto);

    /**
        Obtener el texto original a partir del texto filtrado.
        @param textoFiltrado El texto que ha sido filtrado.
        @return El texto original antes de aplicar el filtro.
    */
    public String obtenerTextoOriginal(String textoFiltrado);  
    
    /**
        Aplicar el filtro al texto original.
        @param textoOriginal El texto sobre el cual se aplicará el filtro.
        @return El texto filtrado.
    */
    public String aplicarFiltro(String textoOriginal);

    /**     
        Proporcionar una explicación del filtro.
        @return String Una cadena que describe el propósito y funcionamiento del filtro.
    */
    public String explicacionDeFiltro();

}