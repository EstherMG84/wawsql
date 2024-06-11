

package Componentes.Personas;
/**
 *
 * @author Esther Manresa
 */
public class Infanteria extends Persona{

    @Override
    protected float getMultiplicadorClase() {
        return 1.0f;
    }
    
    @Override
    public String toString() {
        return "Soldado de Infanteria {" +
                "Nombre='" + this.getNombre() + '\'' +
                ", Ataque='" + this.getAtaque() + '\'' +
                ", Defensa='" + this.getDefensa() + '\'' +
                ", Salud='" + this.getSalud() + '\'' +
                ", Peso='" + this.getPeso() + '\'' +
                '}';
    }
    
}
