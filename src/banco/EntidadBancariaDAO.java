/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAO {

    Connection connection;

    public EntidadBancariaDAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");




    }

    public EntidadBancaria read(int idEntidadBancaria) throws SQLException {
        String selectSQL = "Select * from entidadbancaria WHERE idEntidadBancaria= ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);

        preparedStatement.setInt(1, idEntidadBancaria);
        ResultSet rs = preparedStatement.executeQuery();


        while (rs.next()) {

            String idEntidad = rs.getString("idEntidadBancaria");
            String codigoEntidad = rs.getString("codigoEntidad");
            String nombre = rs.getString("nombre");
            String cif = rs.getString("cif");
            String tipoEntidadBancaria = rs.getString("tipoEntidadBancaria");
            System.out.println("ID  " + "      CodigoEntidad" + "      Nombre" + "       Cif" + "      TipoEntidadBancaria");
            System.out.println("" + idEntidad + "   " + codigoEntidad + "       " + nombre + "   " + cif + "         " + tipoEntidadBancaria);

        }

        System.out.println("Se ha conectado a la base de datos.");






        connection.close();

        return null;

    }

    void insert(EntidadBancaria entidadBancaria) throws SQLException {
        String insertSQL = "Insert into entidadbancaria (idEntidadBancaria,codigoEntidad,nombre,cif,tipoEntidadBancaria)values(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);

        preparedStatement.setInt(1, entidadBancaria.getIdEntidad());
        preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
        preparedStatement.setString(3, entidadBancaria.getNombre());
        preparedStatement.setString(4, entidadBancaria.getCif());
        preparedStatement.setString(5, entidadBancaria.getTipoEntidadBancaria().name());
        preparedStatement.executeUpdate();
    }

    void update(EntidadBancaria entidadBancaria) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banco", "root", "root");


        String updateTableSQL = "UPDATE entidadbancaria SET nombre = ? WHERE identidad = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateTableSQL);
        preparedStatement.setString(1, "Sabadell");
        preparedStatement.setInt(2, entidadBancaria.getIdEntidad());

        preparedStatement.executeUpdate();

        connection.close();
        System.out.println("Conexion creada con exito y datos actualizados.");
    }

    void delete(int idEntidadBancaria) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banco", "root", "root");

        String deleteSQL = "DELETE FROM entidadbancaria WHERE idEntidadBancaria = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
        preparedStatement.setInt(1, idEntidadBancaria);

        preparedStatement.executeUpdate();

        connection.close();
        System.out.println("Conexion creada con exito");









    }

    List< EntidadBancaria> findAll() throws ClassNotFoundException, SQLException {

        List< EntidadBancaria> entidadesBancarias = new ArrayList();


        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc: mysql ://127.0.0.1:3306 / banco", "root", "root");

        String selectSQL = "SELECT * FROM entidadbancaria";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int idEntidadBancaria = rs.getInt("idEntidad");
            String codigoEntidad = rs.getString("codigoEntidad");
            String nombre = rs.getString("nombre");
            String cif = rs.getString("cif");
            String tipoEntidadBancaria = rs.getString("tipoEntidadBancaria");

            EntidadBancaria entidadBancaria = new EntidadBancaria(idEntidadBancaria, codigoEntidad, nombre, cif, TipoEntidadBancaria.valueOf(tipoEntidadBancaria));
            entidadesBancarias.add(entidadBancaria);


            System.out.println("Conexion creada y Lista guardada.");
        }
        connection.close();

        return entidadesBancarias;
    }

    List< EntidadBancaria> findByCodigo(String codigo) throws ClassNotFoundException, SQLException {

        List< EntidadBancaria> listaEntidadesCodigo = new ArrayList();
        EntidadBancaria entidadBancaria;

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc: mysql :/ / 127.0.0.1:3306 / banco", "root", "root");

        String selectSQL = "SELECT * FROM entidadbancaria DONDE codigo =?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
        preparedStatement.setString(1, codigo);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int idEntidadBancaria = rs.getInt("idEntidad");
            String codigoEntidad = rs.getString("codigoEntidad");
            String nombre = rs.getString("nombre");
            String cif = rs.getString("cif");
            String tipoEntidadBancaria = rs.getString("tipoEntidadBancaria");

            entidadBancaria = new EntidadBancaria(idEntidadBancaria, codigoEntidad, nombre, cif, TipoEntidadBancaria.valueOf(tipoEntidadBancaria));
            listaEntidadesCodigo.add(entidadBancaria);
        }

        connection.close();
        System.out.println("Conexion creada con exito y Lista de codigo creada.");

        return listaEntidadesCodigo;
    }
}
