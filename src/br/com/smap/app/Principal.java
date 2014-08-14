package br.com.smap.app;

import br.com.smap.persistencia.MantelDAO;
import br.com.smap.view.MenuPrincipal;

/**
 *
 * @author Ederson
 */

public class Principal {
    
    public static void main(String[] args) {
        MantelDAO dap = new MantelDAO();
        dap.remove();
        
        MenuPrincipal mp = new MenuPrincipal();mp.setVisible(true);
        
    }
}