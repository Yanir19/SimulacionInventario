/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Logica.ResultadoParcial;
import Logica.Resultado;
import Logica.Simulacion;
import Logica.Simulador;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yanir
 */
public class PanelSimulacion extends javax.swing.JFrame {

    /**
     * Creates new form PanelSimulacion
     */
    
    Object []  demanda = new Object [3] ;
    Object []  TmEn = new Object [3];
    Object [] TmEs = new Object [3];
    
    int[] nrosAleatoriosDemanda ;
    int[] nrosAleatoriosTiempoEntrega ;
    int[] nrosAleatoriosTiempoEspera;
    
    DefaultTableModel modelotab1; 
    DefaultTableModel modelotab2;
    DefaultTableModel modelotab3; 
    DefaultTableModel modelotab; 
    public PanelSimulacion() {
        initComponents();
       layoutTablas();
    }

    public void capturar_informacion (){
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    DefaultTableModel modelo;
    
   
    

    /**llamamos el metodo que permite cargar la ventana*/
    JFileChooser file=new JFileChooser();
    file.showOpenDialog(this);
    /**abrimos el archivo seleccionado*/
    File abre=file.getSelectedFile();

      
    modelo = (DefaultTableModel) TablaDeman.getModel();
    int rowCount = modelo.getRowCount();
    limpiar_tabla(modelo, rowCount);
    TablaDeman.repaint();
    modelo = (DefaultTableModel) TablaTEn.getModel();
    rowCount = modelo.getRowCount();
    limpiar_tabla(modelo, rowCount);

    modelo = (DefaultTableModel) TablaTEs.getModel();
    rowCount = modelo.getRowCount();
    limpiar_tabla(modelo, rowCount);
      
    if(abre!=null)
    {     
        
        try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
           fr = new FileReader (abre);
           br = new BufferedReader(fr);

           // Lectura del fichero
           String linea;
           int count= 0;
           for (int i = 0; (linea=br.readLine())!=null ; i++){
               
               switch (i){
                   case 0:
                       
                       try{
                            CostInvTxtField.setText(linea.substring(linea.indexOf(' ')+1 , linea.indexOf(" /")));
                        }
                       catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Error al introducir el costo de inventario." + "\n" + "Por favor revise el archivo." , "Error", JOptionPane.ERROR_MESSAGE );
                        }
                       break;
                       
                   case 1:
                       
                       try{
                            CostOrdTxtField.setText(linea.substring(linea.indexOf(' ')+1, linea.indexOf(" /")));
                       }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Error al introducir el costo de orden." + "\n" + "Por favor revise el archivo." , "Error", JOptionPane.ERROR_MESSAGE );
                        }
                       break;
                       
                   case 2:
                       
                       try{
                            CostCEspTxtField.setText(linea.substring(linea.indexOf(' ')+1, linea.indexOf(" /")));
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Error al introducir el costo con espera." + "\n" + "Por favor revise el archivo." , "Error", JOptionPane.ERROR_MESSAGE );
                        }
                        break;
                        
                   case 3:
                       
                        try{
                            CostSEspTxtField.setText(linea.substring(linea.indexOf(' ')+1, linea.indexOf(" /")));
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Error al introducir el costo sin espera." + "\n" + "Por favor revise el archivo." , "Error", JOptionPane.ERROR_MESSAGE );
                        }
                       break;
                       
                   case 4:
                       try{
                            InvIncTxtField.setText(linea.substring(linea.indexOf(' ')+1, linea.indexOf(" /")));
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Error al introducir el inbentario inicial." + "\n" + "Por favor revise el archivo." , "Error", JOptionPane.ERROR_MESSAGE );
                        }
                       break;
                       
                    case 5:
                        
                        DefaultTableModel modelotabDem = (DefaultTableModel) TablaDeman.getModel();
                        count = 0;
                        
                        try{
                            while (linea.indexOf(',')>0){

                                if(count == 3){
                                    count = 0;
                                    modelotabDem.addRow(demanda);
                                }

                                demanda [count] = Integer.parseInt(linea.substring(linea.indexOf(' ')+1, linea.indexOf(',')));
                                linea  = " " + linea.substring(linea.indexOf(',')+1);
                                count ++;

                            }   

                                demanda [count] = Integer.parseInt(linea.substring(linea.indexOf(' ')+1, linea.indexOf(" /")));
                                modelotabDem.addRow(demanda);
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Error al introducir las probabilidades de la demanda." + "\n" + "Por favor revise el archivo." , "Error", JOptionPane.ERROR_MESSAGE );
                        }
                       break;
                       
                    case 6:
                        DefaultTableModel modelotabTmEn = (DefaultTableModel) TablaTEn.getModel();
                        count = 0;
                        
                        try{
                            while (linea.indexOf(',')>0){

                                if(count == 3){
                                    count = 0;
                                    modelotabTmEn.addRow(TmEn);
                                }
                                TmEn [count] = Integer.parseInt(linea.substring(linea.indexOf(' ')+1, linea.indexOf(',')));
                                linea  = " " + linea.substring(linea.indexOf(',')+1);
                               // System.out.println("nueva > " + linea);
                                count ++;
                            }   

                                TmEn [count] = Integer.parseInt(linea.substring(linea.indexOf(' ')+1, linea.indexOf(" /")));
                                modelotabTmEn.addRow(TmEn);
                          
                           
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Error al introducir las probabilidades de los tiempos de entrega." + "\n" + "Por favor revise el archivo." , "Error", JOptionPane.ERROR_MESSAGE );
                        }
                         break;
                         
                         
                    case 7:
                        DefaultTableModel modelotabTmEs = (DefaultTableModel) TablaTEs.getModel();
                        count = 0;
                        
                        try{
                            
                        while (linea.indexOf(',')>0){
                            if(count == 3){
                                count = 0;
                                modelotabTmEs.addRow(TmEs);
                            }
                            TmEs [count] = Integer.parseInt(linea.substring(linea.indexOf(' ')+1, linea.indexOf(',')));
                            linea  = " " + linea.substring(linea.indexOf(',')+1);
                         //   System.out.println("nueva > " + linea);
                            count ++;
                        }   
                            TmEs [count] = Integer.parseInt(linea.substring(linea.indexOf(' ')+1, linea.indexOf(" /")));
                            modelotabTmEs.addRow(TmEs);
                            
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Error al introducir las probabilidades de los tiempos de espera." + "\n" + "Por favor revise el archivo." , "Error", JOptionPane.ERROR_MESSAGE );
                        }
                            
                       break;
                       
                       case 8:
                            try{
                                SimDiasTxtField.setText(linea.substring(linea.indexOf(' ')+1, linea.indexOf(" /")));
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, "Error al introducir los dias de simulación." + "\n" + "Por favor revise el archivo." , "Error", JOptionPane.ERROR_MESSAGE );
                            }    
                       break;
                       
                       case 9:
                            try{
                                QTxtField.setText(linea.substring(linea.indexOf(' ')+1, linea.indexOf(" /")));
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, "Error al introducir la Q*. " + "\n" + "Por favor revise el archivo." , "Error", JOptionPane.ERROR_MESSAGE );
                            }    
                       break;
                       
                       case 10:
                            try{
                                RTxtField.setText(linea.substring(linea.indexOf(' ')+1, linea.indexOf(" /")));
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, "Error al introducir la R." + "\n" + "Por favor revise el archivo." , "Error", JOptionPane.ERROR_MESSAGE );
                            }    
                       break;
                       
                       case 11:
                           
                           try{
                                if(NumAleArc.isSelected()){
                                    setAleatorio(linea, 1);
                                    setAleatorio(br.readLine(), 2);
                                    setAleatorio(br.readLine(), 3);
                                }
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, "Error al introducir los numeros aleatorios" + "\n" + "Por favor revise el archivo." , "Error", JOptionPane.ERROR_MESSAGE );
                            }
                           
                       break;
               }
           }
              
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al intentar abrir el archivo. " + "\n" + "Por favor revise el archivo." , "Error", JOptionPane.ERROR_MESSAGE );
                           
        }finally{
            
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
                e2.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al cerrar el archivo." , "Error", JOptionPane.ERROR_MESSAGE );           
           }
        }
    }
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        PanelSim = new javax.swing.JTabbedPane();
        SetPanel = new javax.swing.JPanel();
        PanelDemanda = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaDeman = new javax.swing.JTable();
        DemLbl = new javax.swing.JLabel();
        ProbDemLbl = new javax.swing.JLabel();
        AcepDemBtn = new javax.swing.JButton();
        DelDemBtn = new javax.swing.JButton();
        DemSpin = new javax.swing.JSpinner();
        ProbDemSpin = new javax.swing.JSpinner();
        PanelTmEn = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaTEn = new javax.swing.JTable();
        TmEnLbl = new javax.swing.JLabel();
        ProbTmEnLbl = new javax.swing.JLabel();
        TmEnBtn = new javax.swing.JButton();
        DelTEnBtn = new javax.swing.JButton();
        ProbTmEnSpin = new javax.swing.JSpinner();
        TmEnSpin = new javax.swing.JSpinner();
        PanelTmEs = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaTEs = new javax.swing.JTable();
        TmEsLbl = new javax.swing.JLabel();
        ProbTmEsLbl = new javax.swing.JLabel();
        TmEsBtn = new javax.swing.JButton();
        DelTEsBtn = new javax.swing.JButton();
        ProbTmEsSpin = new javax.swing.JSpinner();
        TmEsSpin = new javax.swing.JSpinner();
        PanelCosto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CostInvTxtField = new javax.swing.JTextField();
        CostOrdTxtField = new javax.swing.JTextField();
        CostCEspTxtField = new javax.swing.JTextField();
        CostSEspTxtField = new javax.swing.JTextField();
        InvIncTxtField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        SimDiasTxtField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        QTxtField = new javax.swing.JTextField();
        RTxtField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        NumAleArc = new javax.swing.JRadioButton();
        NumAle = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        MonoRBtn = new javax.swing.JRadioButton();
        MultiRBtn = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaFinal = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        CostFaltLbl = new javax.swing.JLabel();
        CostOrdLbl = new javax.swing.JLabel();
        CostInv = new javax.swing.JLabel();
        CostTtlLbl = new javax.swing.JLabel();
        RunBtn = new javax.swing.JButton();
        QLbl = new javax.swing.JLabel();
        RLbl = new javax.swing.JLabel();
        TmEjecLbl = new javax.swing.JLabel();
        QminLbl = new javax.swing.JLabel();
        QmaxLbl = new javax.swing.JLabel();
        RminLbl = new javax.swing.JLabel();
        RmaxLbl = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        SetPanel.setLayout(new java.awt.GridLayout(4, 3));

        PanelDemanda.setBorder(javax.swing.BorderFactory.createTitledBorder("Demanda"));

        TablaDeman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Demanda diaria (unidades)", "Probabilidad (%)", "Acumulada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TablaDeman);
        TablaDeman.getAccessibleContext().setAccessibleName("");

        DemLbl.setText("Demanda");

        ProbDemLbl.setText("Probabilidad");

        AcepDemBtn.setText("Aceptar");
        AcepDemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcepDemBtnActionPerformed(evt);
            }
        });

        DelDemBtn.setText("Eliminar");
        DelDemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelDemBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelDemandaLayout = new javax.swing.GroupLayout(PanelDemanda);
        PanelDemanda.setLayout(PanelDemandaLayout);
        PanelDemandaLayout.setHorizontalGroup(
            PanelDemandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDemandaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDemandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDemandaLayout.createSequentialGroup()
                        .addComponent(DelDemBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AcepDemBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DemLbl)
                        .addGap(6, 6, 6)
                        .addComponent(DemSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ProbDemLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProbDemSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1203, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelDemandaLayout.setVerticalGroup(
            PanelDemandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDemandaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelDemandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DemLbl)
                    .addComponent(ProbDemLbl)
                    .addComponent(AcepDemBtn)
                    .addComponent(DelDemBtn)
                    .addComponent(DemSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProbDemSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        SetPanel.add(PanelDemanda);

        PanelTmEn.setBorder(javax.swing.BorderFactory.createTitledBorder("Tiempo de entrega"));

        TablaTEn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tiempo de entrega (unidades)", "Probabilidad (%)", "Acumulada"
            }
        ));
        jScrollPane3.setViewportView(TablaTEn);

        TmEnLbl.setText("Tiempo de entrega");

        ProbTmEnLbl.setText("Probabilidad");

        TmEnBtn.setText("Aceptar");
        TmEnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TmEnBtnActionPerformed(evt);
            }
        });

        DelTEnBtn.setText("Eliminar");
        DelTEnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelTEnBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTmEnLayout = new javax.swing.GroupLayout(PanelTmEn);
        PanelTmEn.setLayout(PanelTmEnLayout);
        PanelTmEnLayout.setHorizontalGroup(
            PanelTmEnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTmEnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTmEnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1203, Short.MAX_VALUE)
                    .addGroup(PanelTmEnLayout.createSequentialGroup()
                        .addComponent(DelTEnBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TmEnBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TmEnLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TmEnSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(ProbTmEnLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProbTmEnSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelTmEnLayout.setVerticalGroup(
            PanelTmEnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTmEnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelTmEnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TmEnLbl)
                    .addComponent(ProbTmEnLbl)
                    .addComponent(TmEnBtn)
                    .addComponent(DelTEnBtn)
                    .addComponent(TmEnSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProbTmEnSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        SetPanel.add(PanelTmEn);

        PanelTmEs.setBorder(javax.swing.BorderFactory.createTitledBorder("Tiempo de espera"));

        TablaTEs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tiempo de espera cliente", "Probabilidad (%)", "Acumulada"
            }
        ));
        jScrollPane4.setViewportView(TablaTEs);

        TmEsLbl.setText("Tiempo de espera");

        ProbTmEsLbl.setText("Probabilidad");

        TmEsBtn.setText("Aceptar");
        TmEsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TmEsBtnActionPerformed(evt);
            }
        });

        DelTEsBtn.setText("Eliminar");
        DelTEsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelTEsBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTmEsLayout = new javax.swing.GroupLayout(PanelTmEs);
        PanelTmEs.setLayout(PanelTmEsLayout);
        PanelTmEsLayout.setHorizontalGroup(
            PanelTmEsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTmEsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTmEsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(PanelTmEsLayout.createSequentialGroup()
                        .addComponent(DelTEsBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TmEsBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TmEsLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TmEsSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ProbTmEsLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProbTmEsSpin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 812, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelTmEsLayout.setVerticalGroup(
            PanelTmEsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTmEsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelTmEsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TmEsLbl)
                    .addComponent(ProbTmEsLbl)
                    .addComponent(TmEsBtn)
                    .addComponent(DelTEsBtn)
                    .addComponent(TmEsSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProbTmEsSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        SetPanel.add(PanelTmEs);

        PanelCosto.setBorder(javax.swing.BorderFactory.createTitledBorder("Costos"));

        jLabel1.setText("Costo de inventario:");

        jLabel2.setText("Costo de ordenar:");

        jLabel3.setText("Costo de faltante con espera del cliente:");

        jLabel4.setText("Costo del faltante sin espera del cliente:");

        jLabel5.setText("Inventario inicial:");

        CostInvTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CostInvTxtFieldActionPerformed(evt);
            }
        });

        CostCEspTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CostCEspTxtFieldActionPerformed(evt);
            }
        });

        CostSEspTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CostSEspTxtFieldActionPerformed(evt);
            }
        });

        jLabel14.setText("Tiempo de simualacion (días) :");

        SimDiasTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimDiasTxtFieldActionPerformed(evt);
            }
        });

        jLabel6.setText("Q*:");

        jLabel7.setText("R:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Generación de números aleatorios"));

        buttonGroup2.add(NumAleArc);
        NumAleArc.setSelected(true);
        NumAleArc.setText("Utilizar números aleatorios del archivo");

        buttonGroup2.add(NumAle);
        NumAle.setText("Generar números aleatorios");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NumAleArc)
                    .addComponent(NumAle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NumAleArc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NumAle))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Modo de procesamiento"));

        buttonGroup1.add(MonoRBtn);
        MonoRBtn.setSelected(true);
        MonoRBtn.setText("Mono-hilo");

        buttonGroup1.add(MultiRBtn);
        MultiRBtn.setText("Multi-hilo");
        MultiRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MultiRBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MonoRBtn)
                    .addComponent(MultiRBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(MonoRBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MultiRBtn)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelCostoLayout = new javax.swing.GroupLayout(PanelCosto);
        PanelCosto.setLayout(PanelCostoLayout);
        PanelCostoLayout.setHorizontalGroup(
            PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCostoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCostoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CostCEspTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCostoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CostInvTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCostoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(CostOrdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCostoLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CostSEspTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCostoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InvIncTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCostoLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SimDiasTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(PanelCostoLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(RTxtField))
                        .addGroup(PanelCostoLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(QTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(465, Short.MAX_VALUE))
        );
        PanelCostoLayout.setVerticalGroup(
            PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCostoLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(InvIncTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(CostInvTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(SimDiasTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(CostOrdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CostCEspTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(QTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CostSEspTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(RTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(PanelCostoLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        SetPanel.add(PanelCosto);

        PanelSim.addTab("Entrada de datos", SetPanel);

        jPanel6.setLayout(new java.awt.GridLayout(2, 0));

        TablaFinal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Día", "Inv Inc.", "<html>Nro. aleatorio <br>para la demanda</html>", "Demanda", "<html>Inv. <br> Final </html>l", "<html> Inv. <br> Prom </html>", "Faltante", "<html> Nro. <br> Orden </html>", "<html> Nro. aletario para <br> tiempo de entrega </html>", "Tiempo de entrega", "<html> Nro. aletario para <br>tiempo de espera </html>", "Tiempo de espera"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaFinal);

        jPanel6.add(jScrollPane1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados finales"));

        CostFaltLbl.setText("Costo de faltante:");

        CostOrdLbl.setText("Costo de orden:");

        CostInv.setText("Costo de inventario:");

        CostTtlLbl.setText("Costo total:");

        RunBtn.setText("Run");
        RunBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunBtnActionPerformed(evt);
            }
        });

        QLbl.setText("Q*:");

        RLbl.setText("R:");

        TmEjecLbl.setText("Tiempo de ejecución:");

        QminLbl.setText("Q mínima:");

        QmaxLbl.setText("Q máxima: ");

        RminLbl.setText("R mínimo:");

        RmaxLbl.setText("R máximo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CostFaltLbl)
                            .addComponent(TmEjecLbl)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(QmaxLbl)
                                    .addComponent(QminLbl)
                                    .addComponent(QLbl))
                                .addGap(87, 87, 87)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RmaxLbl)
                                    .addComponent(RminLbl)
                                    .addComponent(RLbl)))
                            .addComponent(CostOrdLbl)
                            .addComponent(CostInv)
                            .addComponent(CostTtlLbl))
                        .addContainerGap(1022, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RunBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RunBtn)
                .addGap(18, 18, 18)
                .addComponent(CostFaltLbl)
                .addGap(18, 18, 18)
                .addComponent(CostOrdLbl)
                .addGap(18, 18, 18)
                .addComponent(CostInv)
                .addGap(18, 18, 18)
                .addComponent(CostTtlLbl)
                .addGap(18, 18, 18)
                .addComponent(TmEjecLbl)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(QminLbl)
                        .addGap(18, 18, 18)
                        .addComponent(QmaxLbl)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RminLbl)
                        .addGap(18, 18, 18)
                        .addComponent(RmaxLbl)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RLbl)
                            .addComponent(QLbl))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel1);

        PanelSim.addTab("Simulación", jPanel6);

        getContentPane().add(PanelSim, "card2");

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Cargar archivo de prueba");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DelTEsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelTEsBtnActionPerformed
        eliminarcolumna(TablaTEs);
    }//GEN-LAST:event_DelTEsBtnActionPerformed

    private void TmEsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TmEsBtnActionPerformed
        DefaultTableModel modelotabTmEs = (DefaultTableModel) TablaTEs.getModel();
        int acumulado = generarAcumulada(modelotabTmEs, TablaTEs, (int) ProbTmEsSpin.getValue());
        
        if (acumulado >0 ){
            modelotabTmEs.addRow(new Object[]{TmEsSpin.getValue(), ProbTmEsSpin.getValue(),acumulado });
        }
        
        TmEsSpin.setValue(0);
        ProbTmEsSpin.setValue(0);
    }//GEN-LAST:event_TmEsBtnActionPerformed

    private void DelDemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelDemBtnActionPerformed
        eliminarcolumna(TablaDeman);
        DefaultTableModel modelotabDem = (DefaultTableModel) TablaDeman.getModel();
        modelotabDem.fireTableStructureChanged();
    }//GEN-LAST:event_DelDemBtnActionPerformed

    private void AcepDemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcepDemBtnActionPerformed
        DefaultTableModel modelotabDem = (DefaultTableModel) TablaDeman.getModel();
        int acumulado =  generarAcumulada(modelotabDem, TablaDeman, (int) ProbDemSpin.getValue());
        
        if (acumulado >0 ){
            modelotabDem.addRow(new Object[]{DemSpin.getValue(), ProbDemSpin.getValue(), acumulado});
        }
        
        DemSpin.setValue(0);
        ProbDemSpin.setValue(0);
    }//GEN-LAST:event_AcepDemBtnActionPerformed

    private void DelTEnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelTEnBtnActionPerformed
        eliminarcolumna(TablaTEn);
    }//GEN-LAST:event_DelTEnBtnActionPerformed

    private void TmEnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TmEnBtnActionPerformed
        DefaultTableModel modelotabTmEn = (DefaultTableModel) TablaTEn.getModel();
        int acumulado = generarAcumulada(modelotabTmEn, TablaTEn, (int) ProbTmEnSpin.getValue());
        
        if (acumulado >0 ){        
            modelotabTmEn.addRow(new Object[]{TmEnSpin.getValue(), ProbTmEnSpin.getValue(), acumulado });
        }
        
    TmEnSpin.setValue(0);
    ProbTmEnSpin.setValue(0);
    }//GEN-LAST:event_TmEnBtnActionPerformed

    private void CostInvTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CostInvTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CostInvTxtFieldActionPerformed

    private void CostCEspTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CostCEspTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CostCEspTxtFieldActionPerformed

    private void CostSEspTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CostSEspTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CostSEspTxtFieldActionPerformed

    private void RunBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunBtnActionPerformed
        boolean ejecutarParalelo;
        int[][] arregloTablaDeman;
        int[][] arregloTablaTEn;
        int[][] arregloTablaTEs;
        int diasSimulacion;
        long time_start, time_end;
        Simulacion caso;
        Resultado resultado;
        
        // Iniciar contador de tiempo
        time_start = System.currentTimeMillis();
        
        // Determinar si la ejecución sera en paralelo o secuencial
        ejecutarParalelo = !MonoRBtn.isSelected();
        
        limpiar_tabla((DefaultTableModel) TablaFinal.getModel(), TablaFinal.getModel().getRowCount());
        Integer cantidadPedido = Integer.parseInt(QTxtField.getText());
        Integer puntoReorden = Integer.parseInt(RTxtField.getText());
        
        // Obtener arreglos de tablas de probabilidad TablaDeman, TablaTEn, TablaTEs
        arregloTablaDeman = new int[2][TablaDeman.getRowCount()];
        for (int i=0; i<TablaDeman.getRowCount(); i++){
            arregloTablaDeman[0][i] = (int)TablaDeman.getValueAt(i, 0);
            arregloTablaDeman[1][i] = (int)TablaDeman.getValueAt(i, 2);
            System.out.println("Demanda: "+arregloTablaDeman[0][i]+" "+arregloTablaDeman[1][i]);
        }

        arregloTablaTEn = new int[2][TablaTEn.getRowCount()];
        for (int i=0; i<TablaTEn.getRowCount(); i++){
            arregloTablaTEn[0][i] = (int)TablaTEn.getValueAt(i, 0);
            arregloTablaTEn[1][i] = (int)TablaTEn.getValueAt(i, 2);
            System.out.println("TEntrega: "+arregloTablaTEn[0][i]+" "+arregloTablaTEn[1][i]);
        }

        arregloTablaTEs = new int[2][TablaTEs.getRowCount()];
        for (int i=0; i<TablaTEs.getRowCount(); i++){
            arregloTablaTEs[0][i] = (int)TablaTEs.getValueAt(i, 0);
            arregloTablaTEs[1][i] = (int)TablaTEs.getValueAt(i, 2);
            System.out.println("TEspera: "+arregloTablaTEs[0][i]+" "+arregloTablaTEs[1][i]);
        }
        
        diasSimulacion = Integer.parseInt( this.SimDiasTxtField.getText());
        
        // Ejecutar simulación completa, sino, ejecutar simulación de prueba
        if(this.NumAle.isSelected()){
            Simulador simulador = new Simulador(
                    ejecutarParalelo, arregloTablaDeman, arregloTablaTEn,
                    arregloTablaTEs, diasSimulacion, Integer.parseInt(InvIncTxtField.getText()),
                    new BigDecimal(CostInvTxtField.getText()), new BigDecimal(CostOrdTxtField.getText()), 
                    new BigDecimal(CostCEspTxtField.getText()), new BigDecimal(CostSEspTxtField.getText())
            );
            
            //Correr simulaciones
            resultado = simulador.iterar();
            
            int totalIteraciones = simulador.getTotalSimulaciones();
            
            QminLbl.setText("Q mínima: " + simulador.getCantidadPedidoMin());
            QmaxLbl.setText("Q máxima: " + simulador.getCantidadPedidoMax());
            RminLbl.setText("R mínima: " + simulador.getPuntoReordenMin());
            RmaxLbl.setText("R máxima: " + simulador.getPuntoReordenMax());
            QLbl.setText("Q*: " + String.valueOf(resultado.cantidadPedido));
            RLbl.setText("R: " + String.valueOf(resultado.puntoReorden));
            
        }else{
            caso = new Simulacion(arregloTablaDeman, arregloTablaTEn, arregloTablaTEs, new BigDecimal(CostInvTxtField.getText()), 
                    new BigDecimal(CostOrdTxtField.getText()), new BigDecimal(CostCEspTxtField.getText()), new BigDecimal(CostSEspTxtField.getText()), 
                    Integer.parseInt(InvIncTxtField.getText()), puntoReorden, cantidadPedido, diasSimulacion,
                    nrosAleatoriosDemanda, nrosAleatoriosTiempoEntrega, nrosAleatoriosTiempoEspera, false
            );
            
            QLbl.setText("Q*: " + String.valueOf(cantidadPedido));
            RLbl.setText("R: " + String.valueOf(puntoReorden));
            
            resultado = (Resultado) caso.simular();
        }
        
        if(resultado!=null){
        
            DefaultTableModel modelotabFinal = (DefaultTableModel) TablaFinal.getModel();
            Object fila [] = new Object[12];
            for(int i = 0 ; i< diasSimulacion; i++){
                fila [0] = resultado.tablaEventos[Simulacion.DIA][i];
                fila [1] = resultado.tablaEventos[Simulacion.INV_INICIAL][i];
                fila [2] = resultado.tablaEventos[Simulacion.NRO_ALT_DEMANDA][i];
                fila [3] = resultado.tablaEventos[Simulacion.DEMANDA][i];
                fila [4] = resultado.tablaEventos[Simulacion.INV_FINAL][i];
                fila [5] = resultado.tablaEventos[Simulacion.INV_PROMEDIO][i];
                fila [6] = resultado.tablaEventos[Simulacion.FALTANTE][i];
                fila [7] = resultado.tablaEventos[Simulacion.NRO_ORDEN][i];
                fila [8] = resultado.tablaEventos[Simulacion.NRO_ALT_T_ENTREGA][i];
                fila [9] = resultado.tablaEventos[Simulacion.T_ENTREGA][i];
                fila [10] = resultado.tablaEventos[Simulacion.NRO_ALT_T_ESPERA][i];
                fila [11] = resultado.tablaEventos[Simulacion.T_ESPERA][i];

                modelotabFinal.addRow(fila);
            }

            CostFaltLbl.setText("Costo de faltante: " + resultado.costoTotalConEspera.add(resultado.costoTotalSinEspera).toString());
            CostTtlLbl.setText("Costo total: " + resultado.costoTotal.toString());
            CostInv.setText("Costo de inventario: " + resultado.costoTotalInventario.toString());
            CostOrdLbl.setText("Costo de orden: " + resultado.costoTotalOrden.toString());

            time_end = System.currentTimeMillis();
            TmEjecLbl.setText("Tiempo de ejecución: " + String.valueOf((( time_end - time_start )/ 1000) % 60 ) + " segundos.");
            System.out.println("Tiempo de simulación: "+ ( time_end - time_start ) +" milisegundos");

        }
        
        
        
    }//GEN-LAST:event_RunBtnActionPerformed

    private void SimDiasTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimDiasTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SimDiasTxtFieldActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        capturar_informacion();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void MultiRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MultiRBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MultiRBtnActionPerformed

    
    
    public  void eliminarcolumna(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.removeRow(tabla.getRowCount()-1);
        
    }
    
    public int generarAcumulada(DefaultTableModel modelo, JTable tabla, int probabilidad){
        
        System.out.println("probabilidad " + probabilidad);
        
        if(tabla.getRowCount()>0){
            if( (int) tabla.getValueAt(tabla.getRowCount()-1, 1) + probabilidad <= 100 &&  (int) (probabilidad *1) <=  100)
                return (int) tabla.getValueAt(tabla.getRowCount()-1, 2)+ probabilidad;
            else{
                JOptionPane.showMessageDialog(null, "Con esta probabildiad, el acumulado supera el 100%", "Advetencia", JOptionPane.ERROR_MESSAGE );
                return 0;
            }
        }else{
            return probabilidad;
        }
    }
    
    public void layoutTablas() {
        
        SetPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.75;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.BOTH;
        SetPanel.add(PanelDemanda, gbc);
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.75;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        SetPanel.add(PanelTmEn, gbc);
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.75;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.BOTH;
        SetPanel.add(PanelTmEs, gbc);
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.15;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        SetPanel.add(PanelCosto, gbc);
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
       
        
    }
    
    public void setAleatorio (String linea, int opc){
        
        ArrayList <Integer> lista = new ArrayList <Integer> ();
        
        while (linea.indexOf(',')>0){
            
            lista.add(Integer.parseInt(linea.substring(linea.indexOf(' ')+1, linea.indexOf(','))));
            linea  = " " + linea.substring(linea.indexOf(',')+1);
            System.out.println("linea >" + linea);
        }
        System.out.println("ultima linea >" + linea);
        lista.add(Integer.parseInt(linea.substring(linea.indexOf(' ')+1, linea.indexOf(" /"))));
        
        int [] arreglo = new int [lista.size()];
        
        for(int i= 0; i < lista.size() ; i++){
            arreglo[i] = (int) lista.get(i);
        }
        
        switch (opc){
            case 1:
                this.nrosAleatoriosDemanda = arreglo;
                System.out.println("demanda: " );
                for(int i= 0; i < lista.size() ; i++){
                    System.out.println(this.nrosAleatoriosDemanda [i]);
                }
                break;
            case 2 :
                this.nrosAleatoriosTiempoEntrega  = arreglo;
                System.out.println("entrega: " );
                for(int i= 0; i < lista.size() ; i++){
                    System.out.println(this.nrosAleatoriosTiempoEntrega [i]);
                }
                break;
            case 3:
                this.nrosAleatoriosTiempoEspera = arreglo;
                System.out.println("espera: " );
                for(int i= 0; i < lista.size() ; i++){
                    System.out.println(this.nrosAleatoriosTiempoEspera [i]);
                }
                break;
        }
    }
    
    
    private void limpiar_tabla (DefaultTableModel modelo , int count){
        for (int i = count - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanelSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelSimulacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcepDemBtn;
    private javax.swing.JTextField CostCEspTxtField;
    private javax.swing.JLabel CostFaltLbl;
    private javax.swing.JLabel CostInv;
    private javax.swing.JTextField CostInvTxtField;
    private javax.swing.JLabel CostOrdLbl;
    private javax.swing.JTextField CostOrdTxtField;
    private javax.swing.JTextField CostSEspTxtField;
    private javax.swing.JLabel CostTtlLbl;
    private javax.swing.JButton DelDemBtn;
    private javax.swing.JButton DelTEnBtn;
    private javax.swing.JButton DelTEsBtn;
    private javax.swing.JLabel DemLbl;
    private javax.swing.JSpinner DemSpin;
    private javax.swing.JTextField InvIncTxtField;
    private javax.swing.JRadioButton MonoRBtn;
    private javax.swing.JRadioButton MultiRBtn;
    private javax.swing.JRadioButton NumAle;
    private javax.swing.JRadioButton NumAleArc;
    private javax.swing.JPanel PanelCosto;
    private javax.swing.JPanel PanelDemanda;
    private javax.swing.JTabbedPane PanelSim;
    private javax.swing.JPanel PanelTmEn;
    private javax.swing.JPanel PanelTmEs;
    private javax.swing.JLabel ProbDemLbl;
    private javax.swing.JSpinner ProbDemSpin;
    private javax.swing.JLabel ProbTmEnLbl;
    private javax.swing.JSpinner ProbTmEnSpin;
    private javax.swing.JLabel ProbTmEsLbl;
    private javax.swing.JSpinner ProbTmEsSpin;
    private javax.swing.JLabel QLbl;
    private javax.swing.JTextField QTxtField;
    private javax.swing.JLabel QmaxLbl;
    private javax.swing.JLabel QminLbl;
    private javax.swing.JLabel RLbl;
    private javax.swing.JTextField RTxtField;
    private javax.swing.JLabel RmaxLbl;
    private javax.swing.JLabel RminLbl;
    private javax.swing.JButton RunBtn;
    private javax.swing.JPanel SetPanel;
    private javax.swing.JTextField SimDiasTxtField;
    private javax.swing.JTable TablaDeman;
    private javax.swing.JTable TablaFinal;
    private javax.swing.JTable TablaTEn;
    private javax.swing.JTable TablaTEs;
    private javax.swing.JLabel TmEjecLbl;
    private javax.swing.JButton TmEnBtn;
    private javax.swing.JLabel TmEnLbl;
    private javax.swing.JSpinner TmEnSpin;
    private javax.swing.JButton TmEsBtn;
    private javax.swing.JLabel TmEsLbl;
    private javax.swing.JSpinner TmEsSpin;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
