/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import DAL.PessoaDAO;
import java.util.List;

public class Controle
{
    public String mensagem;
    
    public void CadastrarPessoa(List<String> listaDadosPessoa,
            List<List<String>> listaDadosEnderecos)
    {
        this.mensagem = "";
        Validar validacao = new Validar();
        validacao.ValidarDadosPessoa(listaDadosPessoa);
        
        if(validacao.mensagem.equals(""))
        {
            Pessoa pessoa = new Pessoa();
            pessoa.nome = listaDadosPessoa.get(0);
            pessoa.rg = listaDadosPessoa.get(1);
            pessoa.cpf = listaDadosPessoa.get(2);            
                        
            PessoaDAO pessoaDao = new PessoaDAO();
            pessoaDao.CadastrarPessoa(pessoa);
            this.mensagem = pessoaDao.mensagem;
        }
        else
            this.mensagem = validacao.mensagem;
    }
}
