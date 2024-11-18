package miscasitas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/miscasitas";
        String user = "babul";
        String password = "Tolentino2020";
        return DriverManager.getConnection(url, user, password);
    }

    public void agregarInsumoBD(Insumo insumo) {
        String query = "INSERT INTO inventario (id, nombre, tipo_insumo, cantidad, unidad_medida, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, insumo.getId());
            ps.setString(2, insumo.getNombre());
            ps.setString(3, insumo.getTipoInsumo());
            ps.setInt(4, insumo.getCantidad());
            ps.setString(5, insumo.getUnidadMedida());
            ps.setString(6, insumo.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al agregar insumo: " + e.getMessage());
        }
    }

    public Insumo obtenerInsumoPorId(int id) {
        String query = "SELECT * FROM inventario WHERE id = ?";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Insumo(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("tipo_insumo"),
                        rs.getInt("cantidad"),
                        rs.getString("unidad_medida"),
                        rs.getString("estado")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener insumo: " + e.getMessage());
        }
        return null;
    }

    public void modificarInsumoBD(Insumo insumo) {
        String query = "UPDATE inventario SET nombre = ?, tipo_insumo = ?, cantidad = ?, unidad_medida = ?, estado = ? WHERE id = ?";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, insumo.getNombre());
            ps.setString(2, insumo.getTipoInsumo());
            ps.setInt(3, insumo.getCantidad());
            ps.setString(4, insumo.getUnidadMedida());
            ps.setString(5, insumo.getEstado());
            ps.setInt(6, insumo.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al modificar insumo: " + e.getMessage());
        }
    }

    public boolean eliminarInsumoBD(int id) {
        String query = "DELETE FROM inventario WHERE id = ?";
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar insumo: " + e.getMessage());
        }
        return false;
    }

    public List<Insumo> listarInsumosBD() {
        List<Insumo> insumos = new ArrayList<>();
        String query = "SELECT * FROM inventario";
        try (Connection conn = conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                insumos.add(new Insumo(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("tipo_insumo"),
                        rs.getInt("cantidad"),
                        rs.getString("unidad_medida"),
                        rs.getString("estado")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar insumos: " + e.getMessage());
        }
        return insumos;
    }

    public void generarReporteBD() {
        List<Insumo> insumos = listarInsumosBD();
        System.out.println("Reporte de Inventario:");
        int contador = 1;
        for (Insumo insumo : insumos) {
            System.out.printf("%d. %s: %d %s - estado %s%n",
                    contador++,
                    insumo.getNombre(),
                    insumo.getCantidad(),
                    insumo.getUnidadMedida(),
                    insumo.getEstado());
        }
    }
}















