
package Componentes.Personas;

import java.util.Random;

/**
 *
 * @author ESther Manresa
 */
public class General extends Persona{
    
    private int id;
    
    public General(){
        super();
    }

    public General(String nombre, int salud, int ataque, int defensa) {
        super();
        this.setNombre(nombre);
        this.setSalud(salud);
        this.setAtaque(ataque);
        this.setDefensa(defensa);
    }
       
    @Override
    public String toString() {
        return "General {" +
                "Nombre='" + this.getNombre() + '\'' +
                ", Ataque='" + this.getAtaque() + '\'' +
                ", Defensa='" + this.getDefensa() + '\'' +
                ", Salud='" + this.getSalud() + '\'' +                
                ", Peso='" + this.getPeso() + '\'' +
                '}';
    }

    @Override
    protected float getMultiplicadorClase() {
        Random random = new Random(); 
        return random.nextFloat(2, 3);
    }

    public void setId(int id) {
        this.id = id;
    }
}
