package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
    
public class Conexao {
    public static Connection con;
    public static String stringConexao = "jdbc:sqlserver://localhost\\DESKTOP-2S0P7G5\\SQLEXPRESS:1433;databaseName=ALPOO";
    public static String mensagem = "";
    
    public static Connection Conectar()
    {
        try
        {
            if(con == null || con.isClosed())            
                con = DriverManager.getConnection(stringConexao, "sa", "sa");
            System.out.println("Conexão bem sucedida");
            
        }
        catch (SQLException e)
        {
            mensagem = e.getMessage();
            System.out.println(e.getMessage());
        }    
        return con;
    }
    
    public static void Desconectar()
    {
        try
        {
            if(!con.isClosed())
                con.close();
        }
        catch (SQLException e)
        {
            mensagem = "Erro ao fechar conexão";
        }
    }
    
}
