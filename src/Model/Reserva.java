package Model;

import java.sql.Date;
import java.sql.Time;


public class Reserva {

    private static final long serialVersionUID = 12345L;
    private String usuari;
    private int nComencals;
    private Date data;
    private Time hora;



    public Reserva(String nom, int nComencals, Date data, Time hora) {
        this.usuari = nom;
        this.nComencals = nComencals;
        this.data = data;
        this.hora = hora;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsuari() {
        return usuari;
    }

    public int getnComencals() {
        return nComencals;
    }

    public String getData() {
        return data.toString();
    }

    public Time getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return usuari + " - " + nComencals + " - " + data + " - " + hora;
    }


}
