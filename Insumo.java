package miscasitas;

public class Insumo implements Comparable<Insumo> {
    private Integer id;
    private String nombre;
    private String tipoInsumo;
    private Integer cantidad;
    private String unidadMedida;
    private String estado;

    public Insumo(Integer id, String nombre, String tipoInsumo, Integer cantidad, String unidadMedida, String estado) {
            if (id>0) {
                this.id=id;
                this.nombre = nombre;
                this.tipoInsumo = tipoInsumo;
            } if (cantidad < 0) {
            throw new IllegalArgumentException("El cantidad de la insumo no puede ser negativa ni cero");
            } else {
            this.cantidad = cantidad;
            this.unidadMedida = unidadMedida;
            this.estado = estado;

        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoInsumo() {
        return tipoInsumo;
    }

    public void setTipoInsumo(String tipoDeInsumo) {
        this.tipoInsumo = tipoDeInsumo;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return
                ", Nombre: " + nombre +
                ", Tipo de Insumo: " + tipoInsumo +
                ", Cantidad: " + cantidad +
                ", Unidad de Medida: " + unidadMedida +
                ", Estado: " + estado;
    }

    @Override
    public int compareTo(Insumo o) {
        return 0;
    }
}













