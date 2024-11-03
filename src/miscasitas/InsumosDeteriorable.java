package miscasitas;//package gestiondeinventarioycompra;

public class InsumosDeteriorable {
    private String estadoEnUso;
    private String estadoParaReponer;
    private String estadoParaLavar;
    private String estadoEnlavanderia;
    public InsumosDeteriorable(Integer insumoId, String nombre, String tipoDeInsumo, Integer cantidad, String unidadMedida, String estadoEnUso, String estadoParaReponer) {
        this.estadoEnUso=estadoEnUso;
        this.estadoParaReponer=estadoParaReponer;
        this.estadoParaLavar=estadoParaLavar;
        this.estadoEnlavanderia=estadoEnlavanderia;

    }

}
