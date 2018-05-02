package Vista;

import Model.InfoComandes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VistaComandes extends JPanel{

    private JTable jtTaula;
    private DefaultTableModel modelTaula;
    private JScrollPane scroll;
    private JButton jbServir;

    /**
     * Constructor de la vista del panel que mostra la taula de comandes
     */
    public VistaComandes() {

        this.setLayout(new BorderLayout(0, 0));

        //Creem taula
        modelTaula = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        modelTaula.addColumn("Reserva");
        modelTaula.addColumn("Plats Totals");
        modelTaula.addColumn("Plats Pendents");
        modelTaula.addColumn("Data/Hora");

        //Posem informacio
        Object rowData[] = {"Row1-Column1", "Row1-Column2", "Row1-Column3", "sdsad"};
        modelTaula.addRow(rowData);

        //Acabada
        jtTaula = new JTable(modelTaula);

        scroll = new JScrollPane(jtTaula);

        this.add(scroll, BorderLayout.CENTER);
        jbServir = new JButton("Mirar comandes");

        this.add(jbServir, BorderLayout.SOUTH);

    }



    /**
     * Funcio per registrar el controlador de aquest panel
     * @param controller
     */
    public void registraControlador(ActionListener controller) {                            //Registro el boto serve amb un action comand de send, declarat en una constant

        jbServir.addActionListener(controller);
        jbServir.setActionCommand("SERVIR TAULA");

    }

    public void setModelTaula(ArrayList<InfoComandes> modelTaulas){

        for (InfoComandes info : modelTaulas){
            Object rowData[] = {info.getUsuari(), info.getTotalPlats(), info.getPlatsPendents(), info.getHora()+"//"+info.getHora()};
            modelTaula.addRow(rowData);
        }


        scroll.repaint();
        scroll.revalidate();


    }

    public int filaSeleccionada(){
        return jtTaula.getSelectedRow();
    }



}
