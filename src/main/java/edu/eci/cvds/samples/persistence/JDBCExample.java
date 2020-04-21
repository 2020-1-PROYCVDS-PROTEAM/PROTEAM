package edu.eci.cvds.samples.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSetMetaData;


public class JDBCExample {
    
    public static void main(String args[]){
        try {
            String url="jdbc:postgresql://ec2-34-202-7-83.compute-1.amazonaws.com:5432/dbukmeid79k7bb?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
            String driver="org.postgresql.Driver";
            String user="adhwljpfstbbdr";
            String pwd="462b417cb85fe7eaf4463b346ef173662a73c0ee98a5c3cc9b98bc3108cdf5c5";
                        
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,user,pwd);
            con.setAutoCommit(false);
                 
            
            //System.out.println("Valor total pedido 2:"+valorTotalPedido(con, 2));
			System.out.println("Esta entrando muy bien!!!!!!!!");
            
            List<String> prodsPedido=nombres(con);
            
            
            //System.out.println("Productos del pedido 1:");
            //ystem.out.println("-----------------------");
            for (String nomprod:prodsPedido){
                System.out.println(nomprod);
            }
            System.out.println("-----------------------");
            

            int suCodigoECI=2137478;
            //registrarNuevoProducto(con, 213791, "EduardJ", 9971);
            //con.commit();
            con.close();


                                   
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBCExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    /**
     * Agregar un nuevo producto con los parámetros dados
     * @param con la conexión JDBC
     * @param codigo
     * @param nombre
     * @param precio
     * @throws SQLException 
     */
    public static void registrarNuevoProducto(Connection con, int codigo, String nombre,int precio) throws SQLException{
        //Crear preparedStatement
        //Asignar parámetros
        //usar 'execute'

        PreparedStatement insertProductos=null;
        String insertar = "INSERT INTO ORD_PRODUCTOS VALUES(?,?,?)";
        insertProductos = con.prepareStatement(insertar);

        insertProductos.setInt(1,codigo);
        insertProductos.setString(2,nombre);
        insertProductos.setInt(3,precio);
        insertProductos.execute();

        con.commit();
        
    }
	
	
	
	public static List<String> nombres(Connection con) throws SQLException{
		List<String> np=new LinkedList<>();
		
		PreparedStatement nombres=null;
		String consulta="SELECT * FROM USUARIOS";
		con.setAutoCommit(false);
		nombres = con.prepareStatement(consulta);
		ResultSet rs=nombres.executeQuery();
		while(rs.next()){
			np.add(rs.getString(1));
		}
		nombres.close();
		rs.close();
		
		return np;
	}
    /**
     * Consultar los nombres de los productos asociados a un pedido
     * @param con la conexión JDBC
     * @param codigoPedido el código del pedido
     * @return 
     */
    public static List<String> nombresProductosPedido(Connection con, int codigoPedido) throws SQLException{
        List<String> np=new LinkedList<>();
        
        //Crear prepared statement
        //asignar parámetros
        //usar executeQuery
        //Sacar resultados del ResultSet
        //Llenar la lista y retornarla

        PreparedStatement updateNames = null;

        String updateString = "SELECT nombre FROM ORD_PRODUCTOS JOIN ORD_DETALLE_PEDIDO  ON ORD_PRODUCTOS.codigo=ORD_DETALLE_PEDIDO.producto_fk WHERE ORD_PRODUCTOS.codigo=?";
        con.setAutoCommit(false);
        updateNames = con.prepareStatement(updateString);
        updateNames.setInt(1,codigoPedido);
        ResultSet rs = updateNames.executeQuery();
        while (rs.next()) {
            np.add(rs.getString(1));
        }
        updateNames.close();
        rs.close();



        return np;
    }

    
    /**
     * Calcular el costo total de un pedido
     * @param con
     * @param codigoPedido código del pedido cuyo total se calculará
     * @return el costo total del pedido (suma de: cantidades*precios)
     */
    public static int valorTotalPedido(Connection con, int codigoPedido)throws SQLException{

        PreparedStatement calculoStatement=null;

        String calcule = "SELECT SUM(precio*cantidad) FROM ORD_PEDIDOS JOIN ORD_DETALLE_PEDIDO ON ORD_PEDIDOS.codigo=ORD_DETALLE_PEDIDO.pedido_fk JOIN ORD_PRODUCTOS ON ORD_PRODUCTOS.codigo=producto_fk WHERE ORD_PEDIDOS.codigo=?";
        calculoStatement = con.prepareStatement(calcule);
        calculoStatement.setInt(1,codigoPedido);
        ResultSet rs = calculoStatement.executeQuery();
        int valor=0;
        while(rs.next()){
            valor = rs.getInt(1);
        }
        calculoStatement.close();
        rs.close();
        return valor;
    }
   
    
}