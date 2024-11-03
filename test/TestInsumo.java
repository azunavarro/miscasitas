import miscasitas.InsumoComun;
import miscasitas.InsumoExisteException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestInsumo {

    @Test
    public void testQueSepuedaCrearUnInsumoComunYLoLLamePorSuId() throws InsumoExisteException {
        InsumoComun insumoComun = new InsumoComun(1, "COMUN", "DETERGENTE", 0, "LITROS", "en uso", "no aun");
        Integer actual = insumoComun.getInsumoId();
        Integer expected = 1;
        assertEquals(expected, actual);
    }
    @Test
public void QueSepuedaCrearUnInsumoComunConCantidad() throws InsumoExisteException {
        InsumoComun insumoComun = new InsumoComun(1, "COMUN", "DETERGENTE", 3, "LITROS", "en uso", "no aun");
        Integer actual = insumoComun.getCantidad();
        Integer expected = 3;
        assertEquals(expected, actual);

    }
}






