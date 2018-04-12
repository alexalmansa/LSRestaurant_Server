package Network;

import Model.Gestionador;
import Model.Reserva;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class ServidorEntrada extends Thread {

    private final Gestionador gestionador;
    private Socket sClient;
    private ObjectOutputStream ooStream;
    private DataOutputStream doStream;
    private ObjectInputStream diStream;
    //private Controlador controller;


    public ServidorEntrada(Socket sClient, Gestionador gestionador) {
        this.sClient = sClient;
        this.gestionador = gestionador;
        //this.controller = controller;
    }


    @Override

    public void run() {

        try {
            doStream = new DataOutputStream(sClient.getOutputStream());
            diStream = new ObjectInputStream(sClient.getInputStream());
            ooStream = new ObjectOutputStream(sClient.getOutputStream());

            Reserva reserva = (Reserva) diStream.readObject();

            String password = gestionador.generatePass();

            String estatReserva = gestionador.creaReserva(reserva, password);

            if (estatReserva.equals("true")) {
                doStream.writeUTF(password);
            } else {
                doStream.writeUTF(estatReserva);            //preparar networkReserva per rebre un string
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //Funcions

    public void enviaCarta() {
        try {
            ooStream.writeObject(gestionador.retornaCarta());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
