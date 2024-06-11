
package Componentes.Animales;

/**
 *
 * @author Esther Manresa
 */
public class Elefante extends Animal{
public static final int PESO_ELEFANTE = 10;
public static final float MULTIPLICADOR_ELEFANTE = 2f;

    
    @Override
    public String toString() {
        return "Elefante {" +
                "Nombre='" + this.getNombre() + '\'' +
                ", Ataque='" + this.getAtaque() + '\'' +
                ", Defensa='" + this.getDefensa() + '\'' +
                ", Salud='" + this.getSalud() + '\'' +                
                ", Peso='" + this.getPeso() + '\'' +
                '}';
    }

    @Override
    protected int getPesoClase() {
      return PESO_ELEFANTE;
    } 

    @Override
    protected int getMinimoAtributoClase() {
      return 30;
    }

    @Override
    protected float getMultiplicadorClase() {
        return MULTIPLICADOR_ELEFANTE;
    }
}
