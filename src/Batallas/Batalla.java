
package Batallas;

import DataBase.MySQLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * <p>Clase que representa una batalla entre dos ejércitos.</p>
 *
 * @author Esther Manresa
 * @version 1.0
 */
public class Batalla {
    
    private static final Batalla instance = new Batalla();
    private static final int MAX_Rondas = 5;

    public static Batalla getInstance() {
        return instance;
    }
    private final Ejercito ejercito1 = new Ejercito();
    private final Ejercito ejercito2 = new Ejercito();
    private final ArrayList<Ronda> rondas = new ArrayList<>();
    
    private Batalla() {
        
    }

    public void luchar() {
        
        this.rondas.clear();
        Random random = new Random();

        Ejercito atacante;
        Ejercito defensor;

        if (random.nextInt(1, 2) == 1) {
            atacante = ejercito1;
            defensor = ejercito2;
        } else {
            atacante = ejercito2;
            defensor = ejercito1;
        }

        if (ejercito1.getSalud() > 0 && ejercito2.getSalud() > 0) {
            for (int numRondas = 0; numRondas < MAX_Rondas; numRondas++) {
                rondas.add(new Ronda(numRondas, atacante, defensor));
                int resultado = rondas.get(rondas.size()-1).getResultado();
                if (resultado > 0) {
                    atacante.recibirDano(resultado);
                } else {
                    defensor.recibirDano(Math.abs(resultado));
                }

                if (this.getGanador() != null) {
                    MySQLConnection.getInstance().saveScore(new TopScore(
                            this.getGanador().getGeneral().getNombre(),
                            this.getGanador().getNombre(),
                            new Date()
                    ));
                    break;
                }

                if (atacante == ejercito1) {
                    atacante = ejercito2;
                    defensor = ejercito1;
                } else {
                    atacante = ejercito1;
                    defensor = ejercito2;
                }
            }
        }
    }

    public  Ejercito getGanador() {
        if (ejercito1.getSalud() <= 0) return this.ejercito2; 
        if (ejercito2.getSalud() <= 0) return this.ejercito1; 
        if (this.rondas.size() >= MAX_Rondas){
            if(this.ejercito1.getSalud() > this.ejercito2.getSalud()) return this.ejercito1;
            return this.ejercito2;
        }
        return null;
    }
    
    public final Ejercito getEjercito1(){
        return this.ejercito1;
    }
    
    public final Ejercito getEjercito2(){
        return this.ejercito2;
    }

    public List<Ronda> getRondas() {
        return this.rondas;
    }

}
