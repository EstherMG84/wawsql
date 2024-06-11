
package Componentes;
import java.util.ArrayList;
import java.util.Random;

/**
 * <p>Clase que representa un componente de un ejército.</p>
 *
 * @author Esther Manresa 
 * @version 1.0
 */
public abstract class Componente {
    
    private String nombre;
    private int ataque = 0;
    private int defensa = 0;
    private int salud = 0;
    private int peso = this.getPesoClase();
    private float multiplicador = this.getMultiplicadorClase();
    
    private static ArrayList<Integer> ids = new ArrayList<Integer>();
  
    public Componente(){
        this.generarAtributos();
        this.nombre = getRandomString();
    }    
    
    public String getNombre(){
        return nombre;
    }
    
    public int getAtaque(){
        return ataque;
    }
    
    public int getDefensa(){
        return defensa;
    }
    
    public int getSalud(){
        return salud;
    }
    
    public int getPeso(){
        return peso;
    }    
    
    public float getMultiplicador(){
        return multiplicador;
    }   
    
    public void setSalud(int salud){
        this.salud = salud;
    }    
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setAtaque(int ataque){
        this.ataque = ataque;
    }
    
    public void setDefensa(int defensa){
        this.defensa = defensa;
    }
    
    public void setPeso(int peso){
        this.peso = peso;
    }   
    
    public void setMultiplicador(float multiplicador){
        this.multiplicador = multiplicador;
    }      
    
    public int recibirDano(int dano) {
        salud -= dano;
        return salud;
    }
    
    public static String getRandomString(){
        Integer rID = 0;
        Random random = new Random();        
        while (1 == 1) {

        rID = random.nextInt(1000);
            if (ids.contains(rID)){
              continue; 
            }
            else {
                ids.add(rID);
                break;
            }
        }
        return Integer.toString(rID);
    }
    
    public void generarAtributos(){
        this.generarAtributos(this.getMinimoAtributoClase(), this.getMaximoAtributosTotalClase());
    }
    
    public void generarAtributos(int limiteInferior, int limiteSuperiorTotal){
        Random random = new Random();   
        
        this.setAtaque(random.nextInt(limiteInferior,  limiteSuperiorTotal - limiteInferior*2));
        this.setDefensa(random.nextInt(limiteInferior, limiteSuperiorTotal - limiteInferior - this.getAtaque()));
        this.setSalud(random.nextInt(limiteInferior, limiteSuperiorTotal - this.getAtaque() - this.getDefensa()));
        
        this.setAtaque((int) Math.floor(this.getAtaque() * this.getMultiplicadorClase()));
        this.setDefensa((int) Math.floor(this.getDefensa()* this.getMultiplicadorClase()));
        this.setSalud((int) Math.floor(this.getSalud()* this.getMultiplicadorClase()));
    }    
    
    @Override
    public String toString() {
        return "Componente{" +
                "Nombre='" + this.getNombre() + '\'' +
                ", Ataque='" + this.getAtaque() + '\'' +
                ", Defensa='" + this.getDefensa() + '\'' +
                ", Peso='" + this.getPeso() + '\'' +
                '}';
    }
    
    public String[] toStringArray(){
        return new String[]{
            this.getClass().getSimpleName(),
            this.nombre,
            String.valueOf(this.ataque),
            String.valueOf(this.defensa),
            String.valueOf(this.salud)
        };
    }
    
    protected abstract int getPesoClase();
    
    protected abstract int getMinimoAtributoClase();
    
    protected int getMaximoAtributosTotalClase(){
        return 100;
    }

    protected abstract float getMultiplicadorClase();
}
