package miscasitas;

import java.util.ArrayList;
import java.util.Scanner;

public interface CargarInventario {

    default void agregarNuevoInsumo(ArrayList<InsumoComun> insumoComunList) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("Agregar Nuevo Insumo");

        System.out.print("Ingrese ID: ");
        int id = sc.nextInt();
        sc.nextLine();  // limpiar el buffer

        System.out.print("Ingrese NOMBRE: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese TIPO DE INSUMO: ");
        String tipoInsumo = sc.nextLine();

        System.out.print("Ingrese CANTIDAD: ");
        int cantidad = sc.nextInt();
        sc.nextLine();  // limpiar el buffer

        System.out.print("Ingrese UNIDAD DE MEDIDA: ");
        String unidadMedida = sc.nextLine();

        System.out.print("Ingrese TIPO DE ESTADO ('en uso'): ");
        String tipoEstado = sc.nextLine();
        System.out.print("Estado para 'Reponer' ): ");
        String estadoParaReponer = sc.nextLine();

        // Crear nuevo insumo y añadirlo a la lista
        InsumoComun nuevoInsumo = new InsumoComun(id, nombre, tipoInsumo, cantidad, unidadMedida, tipoEstado,estadoParaReponer);
        insumoComunList.add(nuevoInsumo);

        System.out.println("Insumo agregado exitosamente.");
        System.out.println("-------------------------------------");
    }
}
