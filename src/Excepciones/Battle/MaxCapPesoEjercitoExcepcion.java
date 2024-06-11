

package Excepciones.Battle;


/**
 *
 * @author Esther Manresa
 */

public class MaxCapPesoEjercitoExcepcion extends Exception {

    public MaxCapPesoEjercitoExcepcion() {
        super("La capacidad del ejercito excede el limite");
    }

    public MaxCapPesoEjercitoExcepcion(String message) {
        super(message);
    }

}
