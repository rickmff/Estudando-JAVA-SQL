/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

public class Validar
{

    public String mensagem;

    public void ValidarDadosPessoa(List<String> listaDadosPessoa)
    {
        this.mensagem = "";

        if (listaDadosPessoa.get(0).length() < 3)
        {
            this.mensagem += "Nome deve conter mais de 3 caracteres. \n";
        }

        if (listaDadosPessoa.get(0).length() > 50)
        {
            this.mensagem += "Nome deve conter menos de 50 caracteres. \n";
        }

        if (listaDadosPessoa.get(1).length() > 15)
        {
            this.mensagem += "RG deve conter menos que 15 caracteres. \n";
        }

        if (listaDadosPessoa.get(2).length() > 15)
        {
            this.mensagem += "CPF deve conter menos que 15 caracteres. \n";
        }
    }
}

