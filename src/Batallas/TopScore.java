/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Batallas;

import java.util.Date;

/**
 *
 * @author dassk
 */
public class TopScore {
    
    private String nombreGeneral;
    private String nombreEjercito;
    private Date fechaBatalla;

    public TopScore(String nombreGeneral, String nombreEjercito, Date fechaBatalla) {
        this.nombreGeneral = nombreGeneral;
        this.nombreEjercito = nombreEjercito;
        this.fechaBatalla = fechaBatalla;
    }

    public String getNombreGeneral() {
        return nombreGeneral;
    }

    public void setNombreGeneral(String nombreGeneral) {
        this.nombreGeneral = nombreGeneral;
    }

    public String getNombreEjercito() {
        return nombreEjercito;
    }

    public void setNombreEjercito(String nombreEjercito) {
        this.nombreEjercito = nombreEjercito;
    }

    public Date getFechaBatalla() {
        return fechaBatalla;
    }

    public void setFechaBatalla(Date fechaBatalla) {
        this.fechaBatalla = fechaBatalla;
    }
    
    public String[] toStringArray(){
        return new String[]{
            this.getNombreGeneral(),
            this.getNombreEjercito(),
            this.getFechaBatalla().toString()
        };
    }
    
    
    
}
