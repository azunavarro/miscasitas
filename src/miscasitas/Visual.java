package miscasitas;

import java.util.Scanner;

public class Visual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario();

        int bandera = 0;
        int seleccion;

        do {
            do {
                System.out.println("-------------------------------------");
                System.out.println("Administración de Inventario");
                System.out.println("1. Agregar Nuevo Insumo");
                System.out.println("2. Modificar Insumo");
                System.out.println("3. Eliminar Insumo");
                System.out.println("4. Salir");
                System.out.println("-------------------------------------");
                System.out.print("Seleccione una opción (1-4): ");
                seleccion = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer

                if (seleccion >= 1 && seleccion <= 4)
                    bandera = 1;
                else {
                    System.out.println("Opción no disponible, vuelva a intentar por favor.");
                }
            } while (bandera == 0);

            if (seleccion == 1) {
                agregarNuevoInsumo(inventario, sc);
            } else if (seleccion == 2) {
                // Implementación de modificar insumo
            } else if (seleccion == 3) {
                // Implementación de eliminar insumo
            } else if (seleccion == 4) {
                System.out.println("¡Gracias! Vuelva pronto.");
                bandera = 2;
            }
        } while (bandera != 2);

        sc.close(); // Cerrar el Scanner al final
    }

    private static void agregarNuevoInsumo(Inventario inventario, Scanner sc) {
        System.out.println("Ingrese los datos del nuevo insumo:");

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();  // Limpiar el buffer

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Tipo de Insumo: ");
        String tipoInsumo = sc.nextLine();

        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        sc.nextLine();  // Limpiar el buffer

        System.out.print("Unidad de Medida: ");
        String unidadMedida = sc.nextLine();

        System.out.print("Tipo de Estado ('en uso', etc.): ");
        String tipoEstado = sc.nextLine();

        System.out.print("Estado para 'Reponer' ): ");
        String estadoParaReponer = sc.nextLine();


        // Crear y agregar el insumo al inventario
        InsumoComun nuevoInsumo = new InsumoComun(id, nombre, tipoInsumo, cantidad, unidadMedida, tipoEstado,estadoParaReponer);
        inventario.agregarInsumoComun(nuevoInsumo);

        System.out.println("Insumo agregado exitosamente.");
    }
}

