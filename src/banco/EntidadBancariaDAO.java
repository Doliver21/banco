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

    EntidadBancaria read(int idEntidadBancaria) throws SQLException {
        String selectSQL = "Select * from entidadbancaria WHERE idEntidadBancaria= ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);

        preparedStatement.setInt(1, idEntidadBancaria);
        ResultSet rs = preparedStatement.executeQuery();

        String idEntidad = rs.getString("idEntidadBancaria");
        String CodigoEntidad = rs.getString("codigoEntidad");
        String Nombre = rs.getString("nombre");
        String cif = rs.getString("cif");





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

    void update(EntidadBancaria entidadBancaria) throws SQLException {
        String updateSQL = "UPDATE entidadbancaria set nombre= ? where idEntidadBancaria=?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
        preparedStatement.setString(1, entidadBancaria.getNombre());
        preparedStatement.setInt(2, entidadBancaria.getIdEntidad());


        preparedStatement.executeQuery();


    }

    void delete(int idEntidadBancaria) throws SQLException {

        String deleteSQL = "DELETE from entidadbancaria where idEntidadBancaria=?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
        preparedStatement.setInt(1, idEntidadBancaria);
        
        preparedStatement.execute();
 
         
       






    }

    List<EntidadBancaria> findAll() {
        return null;

    }

    List<EntidadBancaria> findByCodigo(String codigo) {
        return null;

    }
}
