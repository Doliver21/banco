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
    
    
    public void EndidadBancariaDAO() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = null;
        connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","banco","banco");
            
      
       
    }
    
    

    EntidadBancaria read(int idEntidadBancaria) {
        return null;

    }

    void insert(EntidadBancaria entidadBancaria) {
    }

    void update(EntidadBancaria entidadBancaria) {
    }

     void delete(int idEntidadBancaria) {
    }

    List<EntidadBancaria> findAll() {
        return null;

    }

    List<EntidadBancaria> findByCodigo(String codigo) {
        return null;

    }
}
