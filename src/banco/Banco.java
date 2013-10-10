/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.GregorianCalendar;

/**
 *
 * @author alumno
 */
public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAO();
        entidadBancariaDAO.read(1);
        
        
        
        
        
      
        /*
        //Entidades
        EntidadBancaria entidad1 = new EntidadBancaria(1,"0147","Sabadell","46451656P",TipoEntidadBancaria.BANCO);
        EntidadBancaria entidad2 = new EntidadBancaria(2,"0457","Caja Mediterraneo","8745211656P",TipoEntidadBancaria.CAJADEAHORRO);
        
        //Sucursales Bancarias
        SucursalBancaria sucursal1 = new SucursalBancaria(1,entidad1,"0145","sucursal1");
        SucursalBancaria sucursal2 = new SucursalBancaria(2,entidad2,"3124","sucursal2");
        
        //Cuentas Bancarias
       
        BigDecimal bd1 = new BigDecimal("152.89");
        BigDecimal bd2 = new BigDecimal("3025.00");
        
              
        CuentaBancaria cuenta1 = new CuentaBancaria(1,sucursal1,"00123456789",bd1,"85" ,"258963147P");
        CuentaBancaria cuenta2 = new CuentaBancaria(2,sucursal2,"01245687035",bd2,"54","789654123K");
        
        //Movimientos Bancarios
        
        BigDecimal STbdm1 = new BigDecimal("7859622.21");
        BigDecimal IMbd1 = new BigDecimal("1234.50");
        
         MovimientoBancario movimiento1 = new MovimientoBancario(1,TipoMovimientoBancario.DEBE,IMbd1,new GregorianCalendar(2012,9, 18).getTime(),STbdm1,"BARCENAS");
        // MovimientosBancarios movimiento2 = new MovimientosBancarios(2,TipoMovimientoBancario.HABER,);
        // TODO code application logic here
         
         
         
    }
    
    
    public static void imprimirCuentas(CuentaBancaria cuentaBancaria){
        System.out.println(cuentaBancaria.getSucursalBancaria().getEntidadBancaria()+ " "+ cuentaBancaria.getSucursalBancaria().getCodigoSucursal()+" "+cuentaBancaria.getDc()+" "+cuentaBancaria.getNumeroDeCuenta());
        System.out.println();
        System.out.println("");
        
        for(MovimientoBancario movimientoBancario : cuentaBancaria.getMovimientosBancarios()){
           
        }
      //  System.out.println(cuenta1.getNumeroDeCuenta()+ "" + cuenta1.getDc()"" +" " + cuenta1.getSucursalBancaria())
        
}*/
        
}
}