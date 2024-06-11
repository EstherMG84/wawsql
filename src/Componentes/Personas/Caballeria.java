

package Componentes.Personas;

/**
 *
 * @author Esther Manresa
 */
public class Caballeria extends Persona{
    public static final int PESO_CABALLERIA = 2;
    
    @Override
    public String toString() {
        return "Soldado de Caballeria {" +
                "Nombre='" + this.getNombre() + '\'' +
                ", Ataque='" + this.getAtaque() + '\'' +
                ", Defensa='" + this.getDefensa() + '\'' +
                ", Salud='" + this.getSalud() + '\'' +                
                ", Peso='" + this.getPeso() + '\'' +
                '}';
    }

    @Override
    protected int getPesoClase() {
        return PESO_CABALLERIA;
    }

    @Override
    protected float getMultiplicadorClase() {
        return 1.5f;
    }
}
