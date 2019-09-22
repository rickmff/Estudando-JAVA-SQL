/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpoo.bd;

import Apresentacao.frmMenu;
import DAL.Conexao;

/**
 *
 * @author SKIIW
 */
public class ALPOOBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexao.Conectar();
        frmMenu menu = new frmMenu(null, true);
        menu.setVisible(true);
    }
    
}
