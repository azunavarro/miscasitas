package miscasitas;

import java.util.ArrayList;
import java.util.Objects;

//package gestiondeinventarioycompra;
public  class Insumo {
   private ArrayList<InsumoComun>insumoComun=new ArrayList<InsumoComun>();

    public void agregarInsumo(InsumoComun insumoComun){
        this.insumoComun.add(insumoComun);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insumo insumo = (Insumo) o;
        return Objects.equals(insumoComun, insumo.insumoComun);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(insumoComun);
    }

    public ArrayList<InsumoComun> getInsumoComun() {
        return insumoComun;
    }

    public void setInsumoComun(ArrayList<InsumoComun> insumoComun) {
        this.insumoComun = insumoComun;


    }

}



