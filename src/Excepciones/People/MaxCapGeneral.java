
package Excepciones.People;


/**
 *
 * @author Esther Manresa
 */

public class MaxCapGeneral extends Exception {
    
    
    public MaxCapGeneral() {
        super("Solo se permite un solo general");
    }

    public MaxCapGeneral(String message) {
        super(message);
    }
}