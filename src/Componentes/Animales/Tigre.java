

package Componentes.Animales;

/**
 *
 * @author Esther Manresa
 */
public class Tigre extends Animal{
    public static final int PESO_TIGRE =5;
    public static final float MULTIPLICADOR_TIGRE = 1.5f;
    
    @Override
    public String toString() {
        return "Tigre {" +
                "Nombre='" + this.getNombre() + '\'' +
                ", Ataque='" + this.getAtaque() + '\'' +
                ", Defensa='" + this.getDefensa() + '\'' +
                ", Salud='" + this.getSalud() + '\'' +                
                ", Peso='" + this.getPeso() + '\'' +
                '}';
    }

    @Override
    protected int getPesoClase() {
        return PESO_TIGRE;
    }

        @Override
    protected int getMinimoAtributoClase() {
      return 40;
    }

    @Override
    protected int getMaximoAtributosTotalClase() {
       return 150;
    }

    @Override
    protected float getMultiplicadorClase() {
        return MULTIPLICADOR_TIGRE;
    }
}
