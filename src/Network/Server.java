package Network;


import Model.Gestionador;


public class Server {

    private static int portReserva = 4444;                                               //Declarem els atributs
    private static int portEntrada = 5555;
    private final Gestionador gestionador;
    //private LectorJSON lectorJSON;
    //private Controlador controller;


    public Server(Gestionador gestionador) {
        this.gestionador = gestionador;
        /*this.lectorJSON = new LectorJSON();
        portReserva = lectorJSON.lectorPortReserva;
        portEntrada = lectorJSON.lectorPortEntrada;*/
    }


    public void startServer() {
        ServerSocketReserva sReserva = new ServerSocketReserva(gestionador, portReserva);
        ServerSocketEntrada sEntrada = new ServerSocketEntrada(gestionador, portEntrada);
        Thread t1 = new Thread(sReserva);
        Thread t2 = new Thread(sEntrada);
        t1.start();
        t2.start();
    }



    /*public void setController(Controlador controller) {                                             //Serveix per donar el controlador al server, la usem al controlador
        this.controller = controller;
    }*/
}




