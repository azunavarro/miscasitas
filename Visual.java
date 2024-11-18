package miscasitas;
import java.util.Scanner;

public class Visual {
    private static int seleccion;
    private static Scanner sc = new Scanner(System.in); // Declaración única de Scanner
    private static Inventario inventario = new Inventario();

    public static void main(String[] args) {
        int bandera = 0;
        do {
            do {
                System.out.println("-------------------------------------");
                System.out.println("SISTEMA DE GESTION DE INVENTARIO");
                System.out.println("Mis Casitas");
                System.out.println("1. Administrar Inventario");
                System.out.println("2. Ver Niveles de Stock");
                System.out.println("3. Realizar Orden de Compra ");
                System.out.println("4. Generar Reportes");
                System.out.println("5. Salir");
                System.out.println("-------------------------------------");
                System.out.print("Seleccione una opción (1-5): ");
                seleccion = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer

                if (seleccion >= 1 && seleccion <= 5)
                    bandera = 1;
                else {
                    System.out.println("Opción no disponible, vuelva a intentar por favor.");
                }
            } while (bandera == 0);

            switch (seleccion) {
                case 1:
                    System.out.println("Elegiste la opción 1) Administrar Inventario");
                    AdministrarInventario();
                    break;
                case 2:
                    System.out.println("2. Ver Niveles de Stock");
                    System.out.println("NO FUNCIONAL AUN");
                    break;
                case 3:
                    System.out.println("3. Realizar Orden de Compra");
                    System.out.println("NO FUNCIONAL AUN");
                    break;
                case 4:
                    System.out.println("4. Generar Reportes");
                    generarReporteEnBD();
                    break;
                case 5:
                    System.out.println("Gracias. ¡Vuelva pronto!");
                    bandera = 5;
                    break;
            }
        } while (bandera != 5);

        sc.close(); // Cerrar el Scanner al final
    }
    private static void AdministrarInventario() {
        int opcion;
        do {
            System.out.println("-------------------------------------");
            System.out.println("Administración de Inventario");
            System.out.println("1. Agregar Nuevo Insumo");
            System.out.println("2. Modificar Insumo");
            System.out.println("3. Eliminar Insumo");
            System.out.println("4. Mostrar Todos los Insumos");
            System.out.println("5. Volver al Menú Principal");
            System.out.println("-------------------------------------");
            System.out.print("Seleccione una opción (1-5): ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.println("Opción 1. Agregar Nuevo Insumo");
                    agregarNuevoInsumo();
                    break;
                case 2:
                    System.out.println("Opción 2. Modificar Insumo");
                    modificarInsumo();
                    break;
                case 3:
                    System.out.println("Opción 3. Eliminar Insumo");
                    eliminarInsumo();
                    break;
                case 4:
                    System.out.println("Opción 4. Mostrar todos Insumos");
                    mostrarTodosLosInsumos();
                    break;
                    case 5:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

            if (opcion != 5) {
                System.out.println("¿Desea volver al menú de Administración de Inventario? (s/n): ");
                String respuesta = sc.nextLine().toLowerCase();
                if (!respuesta.equals("s")) {
                    System.out.println("Volviendo al Menú Principal...");
                    opcion = 5; // Salir del bucle
                }
            }
        } while (opcion != 5);
    }

    private static void agregarNuevoInsumo() {
            System.out.println("Ingrese los datos del Nuevo Insumo");
            System.out.print("Ingrese el ID ----NO PPUEDE SER 0 NI NEGATIVO!!!--- del nuevo Insumo: ");
            int id = sc.nextInt();
            sc.nextLine();  // Limpiar el buffer
            System.out.print("INGRESE Nombre DEL insumo: ");
            String nombre = sc.nextLine();
            System.out.print("Tipo de Insumo (COMUN o DETERIORABLE): ");
            String tipoInsumo = sc.nextLine();
            System.out.print("Cantidad: ");
            int cantidad = sc.nextInt();
            sc.nextLine();  // Limpiar el buffer
            System.out.print("Unidad de Medida: ");
            String unidadMedida = sc.nextLine();
            System.out.print("Estado ('en uso','para reponer' etc.): ");
            String estado = sc.nextLine();
            Insumo nuevoInsumo = new Insumo(id,nombre,tipoInsumo,cantidad,unidadMedida,estado);
            inventario.agregarInsumoBD(nuevoInsumo);  // Agregar el insumo a la base de datos
            System.out.println("Insumo agregado exitosamente.");
            System.out.println("Datos del insumo agregado:");
            System.out.println(nuevoInsumo);
            System.out.println("Presione Enter para continuar...");
            sc.nextLine(); // Espera a que el usuario presione Enter para continuar
        }
    private static void modificarInsumo() {
        System.out.print("Ingrese el ID del insumo a modificar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        Insumo insumoActual = inventario.obtenerInsumoPorId(id);

        if (insumoActual == null) {
            System.out.println("El insumo con ID " + id + " no existe en la base de datos.");
            return;
        }

        System.out.println("Datos actuales del insumo:");
        System.out.println(insumoActual);

        System.out.println("Ingrese los nuevos datos (presione Enter para no modificar):");
        System.out.print("Nuevo Nombre (" + insumoActual.getNombre() + "): ");
        String nuevoNombre = sc.nextLine();
        if (!nuevoNombre.isEmpty()) insumoActual.setNombre(nuevoNombre);

        System.out.print("Nuevo Tipo de Insumo (" + insumoActual.getTipoInsumo() + "): ");
        String nuevoTipo = sc.nextLine();
        if (!nuevoTipo.isEmpty()) insumoActual.setTipoInsumo(nuevoTipo);

        System.out.print("Nueva Cantidad (" + insumoActual.getCantidad() + "): ");
        String nuevaCantidad = sc.nextLine();
        if (!nuevaCantidad.isEmpty()) insumoActual.setCantidad(Integer.parseInt(nuevaCantidad));

        System.out.print("Nueva Unidad de Medida (" + insumoActual.getUnidadMedida() + "): ");
        String nuevaUnidad = sc.nextLine();
        if (!nuevaUnidad.isEmpty()) insumoActual.setUnidadMedida(nuevaUnidad);

        System.out.print("Nuevo Estado (" + insumoActual.getEstado() + "): ");
        String nuevoEstado = sc.nextLine();
        if (!nuevoEstado.isEmpty()) insumoActual.setEstado(nuevoEstado);

        inventario.modificarInsumoBD(insumoActual);
        System.out.println("Insumo modificado correctamente.");
    }

    private static void eliminarInsumo() {
        System.out.print("Ingrese el ID del insumo a eliminar: ");
        int insumoId = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        inventario.eliminarInsumoBD(insumoId);
        System.out.println("INSUMO eliminado correctamente.");
        System.out.println("Presione Enter para continuar...");
        sc.nextLine(); // Espera a que el usuario presione Enter para continuar

    }
    private static void mostrarTodosLosInsumos() {
        System.out.println("Insumos en la base de datos:");
        for (Insumo insumo : inventario.listarInsumosBD()) {
            System.out.println(insumo);
            System.out.println("Presione Enter para continuar...");
            sc.nextLine(); // Espera a que el usuario presione Enter para continuar
        }
    }

    private static void generarReporteEnBD() {
                    System.out.println(" Opcion N° 4. Generar Reportes");
                    System.out.println("Presione Enter para ver el reporte");
                    sc.nextLine();
                    System.out.println("--------------------------------------------------------------");
                    inventario.generarReporteBD();
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Presione Enter para continuar...");
                    sc.nextLine(); // Espera a que el usuario presione Enter para continuar



    }

}








































