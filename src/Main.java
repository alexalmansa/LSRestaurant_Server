import Model.BDD;

import java.sql.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

//import Controlador.Controlador;
//import Model.Comandador;
//import Network.Server;
import Vista.ServidorVista;

public class Main {

    public static void main(String[] args) {

        Serverbbdd();

       /* ServidorVista vista = new ServidorVista();          //Creo vista del server
        vista.setVisible(true);                             //La fem visible

        Comandador comandador = new Comandador();           //Creo el model del servidor

        Server servidor = new Server(comandador);           //Creo servidor que conte el model, per poder enviar i guardar dades

        Controlador controlador = new Controlador(vista, comandador, servidor);             //Creo controlador que conte el model, vista i servidor per poder controlarlos quan toqui

        vista.registraControlador(controlador);             //Registro els elements de la vista al controlador

        servidor.startServer();    */                         //Inicio servidor

    }


    public static void Serverbbdd(){
        try {
            BDD bdd = new BDD();

           // bdd.insereixPlat("c",3,10,0);
           // bdd.updatePlat("c", 1);
            bdd.createTable(2);
            String a = "SELECT * FROM Plat ";

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, 1006);
            cal.set(Calendar.MONTH, Calendar.JANUARY);
            cal.set(Calendar.DAY_OF_MONTH, 18);

           // bdd.creaReserva("P", "000",2,new java.sql.Date(cal.getTimeInMillis()), new Time(12,00,00),1 );
            bdd.reservaTaula(2,new  java.sql.Date(cal.getTimeInMillis()), new Time(12,00,00));
            bdd.queriePlat(a);
        }catch (Exception e){
            System.out.println("ERROOR");
            e.printStackTrace();
        }
    }

}






