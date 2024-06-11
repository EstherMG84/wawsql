
package Batallas;

/**
 *
 * @author Esther Manresa
 */
public class Ronda {
    private int numRonda;
    private Ejercito atacante;
    private Ejercito defensor;
    private int resultado;
    
    public Ronda(int ronda, Ejercito atacante, Ejercito defensor){
        this.numRonda = ronda;
        this.atacante = atacante;
        this.defensor = defensor;
        this.resultado = luchar();
    }
    
    private int luchar(){
        return atacante.getAtaque() - defensor.getDefensa();
    }
    
    public int getResultado(){
        return resultado;
    }

    public String[] toStringArray() {
        
        return new String[]{
            String.valueOf(this.numRonda + 1),
            String.valueOf(this.atacante.getNombre()),
            String.valueOf(this.defensor.getNombre()),
            String.valueOf(this.resultado)
        };
    }
}
