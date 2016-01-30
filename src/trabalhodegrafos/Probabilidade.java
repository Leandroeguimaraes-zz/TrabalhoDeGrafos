/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhodegrafos;

/**
 *
 * @author Leandro
 */
public final class Probabilidade {

    public static final boolean geraProbabilidade() {
        int prob = (int) (Math.random() * 2);
        if (prob == 1) 
            return true;
         else 
            return false;
        

    }
}
