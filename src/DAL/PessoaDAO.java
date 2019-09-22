package DAL;

import Modelo.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PessoaDAO
{
    public String mensagem;
    Conexao conexao = new Conexao();
    
    public void CadastrarPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.Conectar();
            String instrucaoSQL = "insert into pessoa "
                    + "(nome, rg, cpf) "
                    + "values(?, ?, ?) "
                    + "declare @idPessoa int = @@identity "
                    + "select @idPessoa as idPessoa ";
            PreparedStatement stmt
                    = con.prepareStatement(instrucaoSQL, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, pessoa.nome);
            stmt.setString(2, pessoa.rg);
            stmt.setString(3, pessoa.cpf);
            stmt.execute();
            ResultSet resultSet = stmt.getGeneratedKeys();
            if (resultSet.next())
            {
                pessoa.id = resultSet.getInt(1);
            }            
            
            conexao.Desconectar();
            this.mensagem = "Pessoa cadastrada com o id: " + pessoa.id;
        }
        catch (SQLException e)
        {
            this.mensagem = e.getMessage();
        }
        
    }    
}
