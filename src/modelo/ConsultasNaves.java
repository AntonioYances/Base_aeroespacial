package modelo;

import vista.Vista_formulario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Antonio Yances
 */
public class ConsultasNaves extends Conexion {
    
    private Vista_formulario formulario;
    
    public boolean registrar(Naves naves) { // Recibe de Naves y la variable se llama naves
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO naves (nombre,status,combustible,tipo,pais,velocidad,biografia) VALUES(?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, naves.getNombre());
            ps.setString(2, naves.getStatus());
            ps.setString(3, naves.getCombustible());
            ps.setString(4, naves.getTipo());
            ps.setString(5, naves.getPais());
            ps.setDouble(6, naves.getVelocidad());
            ps.setString(7, naves.getBiografia());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }

    }

    public boolean modificar(Naves naves) { // Recibe de Naves y la variable se llama naves
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE naves SET nombre=?,status=?,combustible=?,tipo=?,pais=?,velocidad=?,biografia=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, naves.getNombre());
            ps.setString(2, naves.getStatus());
            ps.setString(3, naves.getCombustible());
            ps.setString(4, naves.getTipo());
            ps.setString(5, naves.getPais());
            ps.setDouble(6, naves.getVelocidad());
            ps.setString(7, naves.getBiografia());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }

    }

    public boolean eliminar(Naves naves) { // Recibe de Naves y la variable se llama naves
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM estacion_espacial.naves WHERE nombre = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, naves.getNombre());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean buscar(Naves naves) { // Recibe de Naves y la variable se llama naves
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;

        String sql = "SELECT * FROM estacion_espacial.naves WHERE nombre = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, naves.getNombre());
            rs = ps.executeQuery();
            if (rs.next()) {
                naves.setNombre(rs.getString("nombre"));
                naves.setStatus(rs.getString("status"));
                naves.setCombustible(rs.getString("combustible"));
                naves.setTipo(rs.getString("tipo"));
                naves.setPais(rs.getString("pais"));
                naves.setVelocidad(Double.parseDouble(rs.getString("velocidad")) );
                naves.setBiografia(rs.getString("biografia"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
  
   
}
