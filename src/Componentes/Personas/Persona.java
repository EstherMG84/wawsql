

package Componentes.Personas;
import Componentes.Componente;
/**
 *
 * @author Esther Manresa
 */
public abstract class Persona extends Componente {
    
    public static final int PESO_PERSONA = 1;
    
    public Persona(){
        super();
    }

    @Override
    protected int getPesoClase() {
        return PESO_PERSONA;
    }

    @Override
    protected int getMinimoAtributoClase() {
       return 20;
     }

    @Override
    protected int getMaximoAtributosTotalClase() {
        return 100;
    }
}


