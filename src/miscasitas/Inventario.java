package miscasitas;

import java.util.HashSet;
import java.util.Set;

public class Inventario {
    private String nombre;
    private HashSet<InsumoComun> listaDeInsumoComun;
    private Set<InsumosDeteriorable> listaDeInsumoDeteriorable;

    public Inventario() {
    this.listaDeInsumoComun = new HashSet<>();
}
    public Inventario(String nombre) {
        this.nombre = nombre;

    }
    public boolean agregarInsumoComun(InsumoComun ic){
        return this.listaDeInsumoComun.add(ic);


    }


}