### ALPOO-Aula-1
Aula 01 - Como conectar NetBeans ao SQL BD.

#### 1º Abrir o Netbeans
#### 2º Criar projeto 
#### 3º Aplicar driver SQL Server "sqljdbc4-2.0.jar" a biblioteca do plojeto
#### 4º Criar pacote de conexao "DAL" e dentro criar uma classe de conexão
#### 5º Pegue a string de conexão adquirida na camada de serviços após a criação de uma nova conexão
Exemplo.: "jdbc:sqlserver://localhost\\lab727:1433;databaseName=ALPOO"

#### 6º Dentro dela será criado as seguintes propriedades e metodos para conexao ao BD:
```
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
 
    public static Connection con;
    public static String mensagem;
    
  public static Connection getConexao() 
  {
      mensagem = "";
      try
      {
          if (con == null || con.isClosed())
          {
          con = DriverManager.getConnection("jdbc:sqlserver://localhost\\lab727:1433;databaseName=ALPOO", "sa", "unip");
          }
      } 
      catch (SQLException e) 
      {
          mensagem="Erro de conexão com o BD";
      }
      return con;
  }

  public static void desconectar(){
        try
        {
            if (con != null)
            {
                con.close();
            }
        }
        catch (Exception e)
        {

        }
    }
}
```
#### 6º Na classe Main, execute o teste chamando os metodos da classe conexão
```
package javaapplication1;

import DAL.Conexao;

public class ALPOO
{
    public static void main(String[] args)
    {
        Conexao cenectar = new Conexao();
        Conexao.getConexao();
        System.out.println(Conexao.mensagem);
        Conexao.desconectar();
    }
}
```
#### 7º Faça uma oração a sua divindade para que a conexão seja bem sucedida.

