
package Batallas;

import Componentes.Animales.Animal;
import Componentes.Componente;
import Componentes.Personas.General;
import Excepciones.Animals.MaxCapAnimalesException;
import Excepciones.Battle.MaxCapPesoEjercitoExcepcion;
import Excepciones.People.MaxCapGeneral;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>Clase que representa un ejército.</p>
 *
 * @author Esther Manresa
 * @version 1.0
 */
public class Ejercito {

    private final static int MAX_Peso = 50;
    private final static int MAX_Animales = 3;
    private final static int MAXMIN_General = 1;
    private final static int MIN_UNIDADES = 2;
    
    private final Map<String, Componente> unidades = new HashMap<>();
    private String nombre;

    public Ejercito() {
        //menu();
    }

    public int getAtaque() {
        int ataque = 0;
        for(Componente c :this.unidades.values().stream().filter(c -> c.getSalud() > 0).collect(Collectors.toList())){
            ataque += c.getAtaque();
        }
        return ataque;
    }

    public int getDefensa() {
        int defensa = 0;
        for(Componente c :this.unidades.values().stream().filter(c -> c.getSalud() > 0).collect(Collectors.toList())){
            defensa += c.getDefensa();
        }
        return defensa;
    }

    public int getSalud() {
        int salud = 0;
        for(Componente c :this.unidades.values().stream().filter(c -> c.getSalud() > 0).collect(Collectors.toList())){
            salud += c.getSalud();
        }
        return salud;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSaldoPeso() {
        int peso = 0;
        for(Componente c :this.unidades.values()){
            peso += c.getPeso();
        }
        return peso;
    }
    
    public boolean valido(){
        if (this.getNombre() == null || this.getNombre().isBlank()) return false;
        if (this.unidades.size() < MIN_UNIDADES) return false;
        if (this.getGeneral() == null)return false;
        
        return true;
    }
    
    public void agregarComponente(Componente c) throws MaxCapPesoEjercitoExcepcion, MaxCapGeneral, MaxCapAnimalesException{
        if(this.getSaldoPeso() + c.getPeso() > MAX_Peso) throw new MaxCapPesoEjercitoExcepcion();
        if(c instanceof General && this.getGeneral() != null) throw new MaxCapGeneral("");
        if(c instanceof Animal && this.getAnimales().size() >= MAX_Animales) throw new MaxCapAnimalesException();
        
        this.unidades.put(c.getNombre(), c);
    }

    private void imprimirInfo(Componente componente) {
        System.out.println(
                "Nuevo Componente Añadido al Ejército: " + System.lineSeparator() + componente);
        System.out.println(System.lineSeparator() + "Saldo actual del Ejército: " + getSaldoPeso()
        );
    }

    public void recibirDano(int dano) {
        Iterator<Componente> iterador = unidades.values().stream().filter(c -> c.getSalud() > 0).iterator();

        while (dano > 0 && iterador.hasNext()) {
            Componente componente = iterador.next();
            componente.recibirDano(dano);

            if (componente.getSalud() < 0) {

                dano = Math.abs(componente.getSalud());

                System.out.println("El componente " + componente.getNombre() + " ha sido eliminado del ejército " +
                        nombre + " por falta de salud");
            }
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public List<Componente> getComponentes(){
        return new ArrayList<>(this.unidades.values());
    }

    public General getGeneral() {
        for(Componente c : this.unidades.values()){
            if (c instanceof General) return (General)c;
        }
        return null;
    }

    private List<Animal> getAnimales() {
        List<Animal> listAnimales = new ArrayList<>();
        for(Componente c : this.unidades.values()){
            if (c instanceof Animal) listAnimales.add((Animal) c);
        }
        return listAnimales;
    }

    public void eliminarComponenteConNombre(String nombre) {
        if(this.unidades.containsKey(nombre)){
            this.unidades.remove(nombre);
        }
    }
}
