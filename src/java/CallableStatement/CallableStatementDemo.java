
package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class CallableStatementDemo {
    
    //JDBC nombre y BD
    static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    
    //BD credenciales
    static final String USERNAME = "pof";
    static final String PASSWORD = "pof";

    public static void main(String[] args) {
        
        CallableStatementDemo jdbcCallableStatementDemo = new CallableStatementDemo();
        
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("Ingresa el ID de la publicidad o digita salir");
            String idPublicidad = scanner.nextLine();
            
            if(idPublicidad.equals("salir"))
            {
                break;
            }
            
            jdbcCallableStatementDemo.getIdPublicidad(idPublicidad);
        }
        scanner.close();
    }
    
    private void getIdPublicidad(String idPublicidad)
    {
        Connection con = null;
        CallableStatement callableStatement = null;
        try
        {
            Class.forName(JDBC_DRIVER);
            
            con = DriverManager
                    .getConnection(DB_URL, USERNAME, PASSWORD);
            
            String plSql = "{call ObtenerPubli(?,?)}";
            
            callableStatement = con.prepareCall(plSql);
            
            callableStatement.setString(1, idPublicidad);
            
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
            
            callableStatement.execute();
            
            String nombrePubli = callableStatement.getString(2);
            
            System.out.println("Nombre de la Publicidad: "+ nombrePubli+"\n");
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(callableStatement != null)
                {
                    callableStatement.close();
                }
            }
            catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
            try
            {
                if(con != null)
                {
                    con.close();
                }
            }
            catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
        }
        
    }
    
    
}
