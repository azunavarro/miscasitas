package miscasitas;

import java.util.Objects;

public class InsumoComun implements Comparable<InsumoComun>{
    private Integer insumoId;
    private String nombre;
    private String tipoDeInsumo;
    private Integer cantidad;
    private String unidadMedida;
    private String estadoEnUso;
    private String estadoParaReponer;



    public InsumoComun(Integer insumoId, String nombre, String tipoDeInsumo, Integer cantidad, String unidadMedida, String estadoEnUso, String estadoParaReponer) {
        if (insumoId < 0) {
            throw new IllegalArgumentException("El insumo de la insumo no puede ser negativa");
        } else {
            this.insumoId = insumoId;
            this.nombre = nombre;
            this.tipoDeInsumo = tipoDeInsumo;
        }
        if (cantidad < 0) {
            throw new IllegalArgumentException("El cantidad de la insumo no puede ser negativa ni cero");
        } else {

            this.cantidad = cantidad;
            this.unidadMedida = unidadMedida;
            this.estadoEnUso = estadoEnUso;
            this.estadoParaReponer = estadoParaReponer;
        }

    }

    public Integer getInsumoId() {
        return insumoId;
    }

    public void setInsumoId(Integer insumoId) {
        this.insumoId = insumoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDeInsumo() {
        return tipoDeInsumo;
    }

    public void setTipoDeInsumo(String tipoDeInsumo) {
        this.tipoDeInsumo = tipoDeInsumo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getEstadoEnUso() {
        return estadoEnUso;
    }

    public void setEstadoEnUso(String estadoEnUso) {
        this.estadoEnUso = estadoEnUso;
    }

    public String getEstadoParaReponer() {
        return estadoParaReponer;
    }

    public void setEstadoParaReponer(String estadoParaReponer) {
        this.estadoParaReponer = estadoParaReponer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsumoComun that = (InsumoComun) o;
        return Objects.equals(insumoId, that.insumoId) && Objects.equals(nombre, that.nombre) && Objects.equals(tipoDeInsumo, that.tipoDeInsumo) && Objects.equals(cantidad, that.cantidad) && Objects.equals(unidadMedida, that.unidadMedida) && Objects.equals(estadoEnUso, that.estadoEnUso) && Objects.equals(estadoParaReponer, that.estadoParaReponer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(insumoId, nombre, tipoDeInsumo, cantidad, unidadMedida, estadoEnUso, estadoParaReponer

        );
    }

    @Override
    public int compareTo(InsumoComun o) {
        return 0;
    }


}






