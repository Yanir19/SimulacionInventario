/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacioninventario;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    
    DefaultTableModel modelotab; 
    public PanelSimulacion() {
        initComponents();
        
       layoutTablas();
    }

    public void capturar_informacion (){
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    

      /**llamamos el metodo que permite cargar la ventana*/
      JFileChooser file=new JFileChooser();
      file.showOpenDialog(this);
      /**abrimos el archivo seleccionado*/
      File abre=file.getSelectedFile();

      /**recorremos el archivo, lo leemos para plasmarlo
      *en el area de texto*/
      
      
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
                       CostInvTxtField.setText(linea.substring(linea.indexOf(' ')));
                       break;
                   case 1:
                       CostOrdTxtField.setText(linea.substring(linea.indexOf(' ')));
                       break;
                   case 2:
                       CostCEspTxtField.setText(linea.substring(linea.indexOf(' ')));
                       break;
                   case 3:
                       CostSEspTxtField.setText(linea.substring(linea.indexOf(' ')));
                       break;
                   case 4:
                       InvIncTxtField.setText(linea.substring(linea.indexOf(' ')));
                       break;
                       
                    case 5:
                        
                        DefaultTableModel modelotabDem = (DefaultTableModel) TablaDeman.getModel();
                        demanda = new Object[linea.indexOf(' ')];
                        
                        while (linea.indexOf(',')>0){
                            
                            if(count == linea.indexOf(' ')){
                                count = 0;
                                modelotabDem.addRow(demanda);
                            }
                            demanda [count] = Integer.parseInt(linea.substring(linea.indexOf(' '), linea.indexOf(',')));
                            linea  = "   " + linea.substring(linea.indexOf(',')+1);
                            System.out.println("nueva > " + linea);
                            count ++;
                        }   
                            demanda [count] = Integer.parseInt(linea.substring(linea.indexOf(' ')));
                            modelotabDem.addRow(demanda);
                       break;
                       
                    case 6:
                        DefaultTableModel modelotabTmEs = (DefaultTableModel) TablaTEn.getModel();
                        count = 0;
                        while (linea.indexOf(',')>0){
                            
                            if(count == linea.indexOf(' ')){
                                count = 0;
                                modelotabTmEs.addRow(TmEn);
                            }
                            TmEn [count] = Integer.parseInt(linea.substring(linea.indexOf(' '), linea.indexOf(',')));
                            linea  = "   " + linea.substring(linea.indexOf(',')+1);
                            System.out.println("nueva > " + linea);
                            count ++;
                        }   
                            TmEn [count] = Integer.parseInt(linea.substring(linea.indexOf(' ')));
                            modelotabTmEs.addRow(TmEn);
                       break;
                       
                    
                    case 7:
                        DefaultTableModel modelotabTmEn = (DefaultTableModel) TablaTEs.getModel();
                        count = 0;
                        while (linea.indexOf(',')>0){
                            
                            if(count == linea.indexOf(' ')){
                                count = 0;
                                modelotabTmEn.addRow(TmEs);
                            }
                            TmEs [count] = Integer.parseInt(linea.substring(linea.indexOf(' '), linea.indexOf(',')));
                            linea  = "   " + linea.substring(linea.indexOf(',')+1);
                            System.out.println("nueva > " + linea);
                            count ++;
                        }   
                            TmEs [count] = Integer.parseInt(linea.substring(linea.indexOf(' ')));
                            modelotabTmEn.addRow(TmEs);
                       break;
                       
                       case 8:
                           if(NumAleArc.isSelected()){
                               setAleatorio(linea, this.nrosAleatoriosDemanda);
                               setAleatorio(br.readLine(), this.nrosAleatoriosTiempoEntrega);
                               setAleatorio(br.readLine(), this.nrosAleatoriosTiempoEspera);
                           }
                                   
                       break;
               }
           }
              
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
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
        NumAleArc = new javax.swing.JRadioButton();
        NumAle = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaFinal = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        RunBtn = new javax.swing.JButton();
        CstFlteLbl = new javax.swing.JLabel();
        CstOrdLbl = new javax.swing.JLabel();
        CstInvLbl = new javax.swing.JLabel();
        CstTtlLbl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        QLbl = new javax.swing.JLabel();
        RLbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TmEjeLbl = new javax.swing.JLabel();
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1191, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelDemandaLayout.setVerticalGroup(
            PanelDemandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDemandaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1191, Short.MAX_VALUE)
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
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
                        .addGap(0, 800, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelTmEsLayout.setVerticalGroup(
            PanelTmEsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTmEsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
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

        buttonGroup2.add(NumAleArc);
        NumAleArc.setSelected(true);
        NumAleArc.setText("Utilizar números aleatorios del archivo");

        buttonGroup2.add(NumAle);
        NumAle.setText("Generar números aleatorios");

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
                    .addComponent(NumAle)
                    .addGroup(PanelCostoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InvIncTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCostoLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SimDiasTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(NumAleArc))
                .addContainerGap(702, Short.MAX_VALUE))
        );
        PanelCostoLayout.setVerticalGroup(
            PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCostoLayout.createSequentialGroup()
                .addContainerGap()
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
                .addGap(17, 17, 17)
                .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CostCEspTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumAleArc))
                .addGap(18, 18, 18)
                .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CostSEspTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumAle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel9.setText("Costo de faltante:");

        jLabel10.setText("Costo de orden:");

        jLabel11.setText("Costo de inventario:");

        jLabel12.setText("Costo total:");

        jLabel13.setText("Mensaje:");

        RunBtn.setText("Run");
        RunBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunBtnActionPerformed(evt);
            }
        });

        CstOrdLbl.setText(" ");

        CstInvLbl.setText(" ");

        CstTtlLbl.setText(" ");

        jLabel6.setText("Q*:");

        jLabel7.setText("R:");

        jLabel8.setText("Tiempo de ejecución:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CstInvLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(RLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(QLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
                    .addComponent(jLabel13)
                    .addComponent(RunBtn)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TmEjeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CstOrdLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CstFlteLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CstTtlLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(980, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CstFlteLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(CstOrdLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(CstInvLbl))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(CstTtlLbl))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(QLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(RLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TmEjeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(RunBtn)
                .addContainerGap(57, Short.MAX_VALUE))
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
        modelotabTmEs.addRow(new Object[]{TmEsSpin.getValue(),
                                         ProbTmEsSpin.getValue(),
                                         generarAcumulada(modelotabTmEs, TablaTEs, (int) ProbTmEsSpin.getValue()) });
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
        modelotabDem.addRow(new Object[]{DemSpin.getValue(),
                                         ProbDemSpin.getValue(),
                                         generarAcumulada(modelotabDem, TablaDeman, (int) ProbDemSpin.getValue()) });
        DemSpin.setValue(0);
        ProbDemSpin.setValue(0);
    }//GEN-LAST:event_AcepDemBtnActionPerformed

    private void DelTEnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelTEnBtnActionPerformed
        eliminarcolumna(TablaTEn);
    }//GEN-LAST:event_DelTEnBtnActionPerformed

    private void TmEnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TmEnBtnActionPerformed
        DefaultTableModel modelotabTmEn = (DefaultTableModel) TablaTEn.getModel();
        modelotabTmEn.addRow(new Object[]{TmEnSpin.getValue(),
            ProbTmEnSpin.getValue(),
            generarAcumulada(modelotabTmEn, TablaTEn, (int) ProbTmEnSpin.getValue()) });
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
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        Integer cantidadPedido = 100;
        Integer puntoReorden = 75;
<<<<<<< HEAD
=======
        int[] nrosAleatoriosDemanda = {69,37,75,60,54,47,79,96,42,98,15,59,37,25,14};
        int[] nrosAleatoriosTiempoEntrega = {22,43,15,29,76};
        int[] nrosAleatoriosTiempoEspera = {64,6};
//        int[] nrosAleatoriosDemanda = {40,60,80,20,10,11,15,25,99,98,63,59,22,25,19};
//        int[] nrosAleatoriosTiempoEntrega = {85,66,28,71,8,96,12,65,18,31,43,50,1,49,55};
//        int[] nrosAleatoriosTiempoEspera = {15,6,10,30,55,9,44,64,6,43,29,42,1,33,12};
>>>>>>> origin/master
        Caso caso = null;
        
        int cantidadPedidoMin = 0;
        int cantidadPedidoMax = 0;
        int puntoReordenMin = 0;
        int puntoReordenMax = 0;
        
        int contadorResultados = 0;
        
        ResultadoCaso resultado = null;
        ResultadoCasoSimplificado mejorResultadoSimplificado = null;
        int diasSimulacion = Integer.parseInt( this.SimDiasTxtField.getText());
        
        /*
        System.out.println("Min demanda: "+(int)this.TablaDeman.getValueAt(0, 0));
        System.out.println("Max demanda: "+(int)this.TablaDeman.getValueAt(this.TablaDeman.getRowCount()-1, 0));
        System.out.println("Min t entrega: "+(int)this.TablaTEn.getValueAt(1, 0));
        System.out.println("Max t entrega: "+(int)this.TablaTEn.getValueAt(this.TablaTEn.getRowCount()-1, 0));     
        */
        //return;
        
        if(this.NumAle.isSelected()){
            int minTEntrega = 1;
            int maxTEntrega = (int)this.TablaTEn.getValueAt(0, 0);
            int minDemanda = (int)this.TablaDeman.getValueAt(0, 0);
            int maxDemanda = (int)this.TablaDeman.getValueAt(0, 0);
            int totalIteraciones = 0;
            
            // Obtener tiempos y demandas mínimas y máximas
            for (int i = 0; i< this.TablaDeman.getRowCount(); i++){
                if (minDemanda > (int)this.TablaDeman.getValueAt(i, 0)){
                    minDemanda = (int)this.TablaDeman.getValueAt(i, 0);
                } 
            }
            for (int i = 0; i< this.TablaDeman.getRowCount(); i++){
                if (maxDemanda < (int)this.TablaDeman.getValueAt(i, 0)){
                    maxDemanda = (int)this.TablaDeman.getValueAt(i, 0);
                } 
            }
            for (int i = 0; i< this.TablaTEn.getRowCount(); i++){
                if ( (int)this.TablaTEn.getValueAt(i, 0) != 0  && minTEntrega > (int)this.TablaTEn.getValueAt(i, 0)){
                    minTEntrega = (int)this.TablaTEn.getValueAt(i, 0);
                }
            }
            for (int i = 0; i< this.TablaTEn.getRowCount(); i++){
                if (maxTEntrega < (int)this.TablaTEn.getValueAt(i, 0)){
                    maxTEntrega = (int)this.TablaTEn.getValueAt(i, 0);
                } 
            }
            
            /*System.out.println("minDemanda; " + minDemanda);
            System.out.println("maxDemanda; " + maxDemanda);
            System.out.println("minTEntrega; " + minTEntrega);
            System.out.println("maxTEntrega; " + maxTEntrega);
            return;*/
            
            // Obtener Q y PR mínimos y máximos
            cantidadPedidoMin = Caso.calcularQ(
                    new BigDecimal(this.CostOrdTxtField.getText()), 
                    minDemanda, 
                    new BigDecimal(this.CostInvTxtField.getText()),
                    new BigDecimal(this.CostSEspTxtField.getText()), 
                    diasSimulacion
            );
            cantidadPedidoMax = Caso.calcularQ(
                    new BigDecimal(this.CostOrdTxtField.getText()), 
                    maxDemanda, 
                    new BigDecimal(this.CostInvTxtField.getText()),
                    new BigDecimal(this.CostCEspTxtField.getText()), 
                    diasSimulacion
            );
            
            puntoReordenMin = Caso.calcularPuntoReorden(
                    minTEntrega,
                    minDemanda, 
                    diasSimulacion
            );
            
            puntoReordenMax = Caso.calcularPuntoReorden(
                    maxTEntrega,
                    maxDemanda, 
                    diasSimulacion
            );
            
            System.out.println("cantidadPedidoMin; " + cantidadPedidoMin);
            System.out.println("cantidadPedidoMax; " + cantidadPedidoMax);
            System.out.println("puntoReordenMin; " + puntoReordenMin);
            System.out.println("puntoReordenMax; " + puntoReordenMax);
            
            totalIteraciones = (puntoReordenMax-puntoReordenMin)*(cantidadPedidoMax-cantidadPedidoMin);
            
            ResultadoCasoSimplificado[] resultados = new ResultadoCasoSimplificado[totalIteraciones];
            System.out.println("Cantidad de casos a evaluar:" +resultados.length);
            
            
            // Simulacione sen paralelo
            /*
            List<ResultadoCasoSimplificado> casosSimplificados = new ArrayList<ResultadoCasoSimplificado>();
            List<ResultadoCasoSimplificado> r = new ArrayList<>();
            
            for(int i=cantidadPedidoMin; i< cantidadPedidoMax ; i++){
                for(int j=puntoReordenMin; j< puntoReordenMax ; j++){
                    casosSimplificados.add( new ResultadoCasoSimplificado(i,j,new BigDecimal(0)));
                }
            }
            
            r = casosSimplificados
                .parallelStream()
                .map(s -> {
                    Caso casoParalelo = new Caso(TablaDeman, TablaTEn, TablaTEs, new BigDecimal(CostInvTxtField.getText()), 
                        new BigDecimal(CostOrdTxtField.getText()), new BigDecimal(CostCEspTxtField.getText()), new BigDecimal(CostSEspTxtField.getText()), 
                        Integer.parseInt(InvIncTxtField.getText()), s.puntoReorden, s.cantidadPedido,diasSimulacion,
                        false
                    );
                    ResultadoCaso resultadoParalelo = casoParalelo.simular();
                    s.costoTotal = resultadoParalelo.costoTotal;
                    return s;
                }).collect(Collectors.toList());
            
            System.out.println("Caso: "+r.get(0).costoTotal);
            time_end = System.currentTimeMillis();
            System.out.println("Tiempo de simulación: "+ ( time_end - time_start ) +" milisegundos");
            return;
            */
            
            // Hacer simulaciones con todas las combinaciones de Q y PR entre los rangos obtenidos
            for(int i=cantidadPedidoMin; i< cantidadPedidoMax ; i++){
                for(int j=puntoReordenMin; j< puntoReordenMax ; j++){
                    caso = new Caso(TablaDeman, TablaTEn, TablaTEs, new BigDecimal(CostInvTxtField.getText()), 
                        new BigDecimal(CostOrdTxtField.getText()), new BigDecimal(CostCEspTxtField.getText()), new BigDecimal(CostSEspTxtField.getText()), 
                        Integer.parseInt(InvIncTxtField.getText()), j, i,diasSimulacion,
                        false
                    );

                    resultado = (ResultadoCaso) caso.simular();
                    
                    resultados[contadorResultados] = new ResultadoCasoSimplificado(i,j,resultado.costoTotal);
                    /*
                    resultados[contadorResultados].cantidadPedido = i;
                    resultados[contadorResultados].puntoReorden = j;
                    resultados[contadorResultados].costoTotal = resultado.costoTotal;
                    */
                    contadorResultados++;
                    //System.out.println(resultado.costoTotal);
                }
            }
            
            // Buscar mejor resultado
            mejorResultadoSimplificado = resultados[0];
            int mejorCaso = 0;
            for(int i=1; i < totalIteraciones ; i++){
                if( mejorResultadoSimplificado.costoTotal.compareTo( resultados[i].costoTotal ) > 0 ){
                    mejorResultadoSimplificado = resultados[i];
                    mejorCaso = i;
                }
            }
            
            System.out.println("Mejor caso: "+ mejorCaso);
            System.out.println("Q: "+ mejorResultadoSimplificado.cantidadPedido);
            System.out.println("R: "+ mejorResultadoSimplificado.puntoReorden);
            
            // Generar nuevamente el mejor resultado
            caso = new Caso(TablaDeman, TablaTEn, TablaTEs, new BigDecimal(CostInvTxtField.getText()), 
                new BigDecimal(CostOrdTxtField.getText()), new BigDecimal(CostCEspTxtField.getText()), new BigDecimal(CostSEspTxtField.getText()), 
                Integer.parseInt(InvIncTxtField.getText()), mejorResultadoSimplificado.puntoReorden, mejorResultadoSimplificado.cantidadPedido,
                diasSimulacion,false
            );
            
            resultado = (ResultadoCaso) caso.simular();
            QLbl.setText(String.valueOf(mejorResultadoSimplificado.cantidadPedido));
            RLbl.setText(String.valueOf(mejorResultadoSimplificado.puntoReorden));
 
        }else{
            caso = new Caso(TablaDeman, TablaTEn, TablaTEs, new BigDecimal(CostInvTxtField.getText()), 
                    new BigDecimal(CostOrdTxtField.getText()), new BigDecimal(CostCEspTxtField.getText()), new BigDecimal(CostSEspTxtField.getText()), 
                    Integer.parseInt(InvIncTxtField.getText()), puntoReorden, cantidadPedido, diasSimulacion,
                    nrosAleatoriosDemanda, nrosAleatoriosTiempoEntrega, nrosAleatoriosTiempoEspera
            );
            
            QLbl.setText(String.valueOf(cantidadPedido));
            RLbl.setText(String.valueOf(puntoReorden));
            resultado = (ResultadoCaso) caso.simular();
        }
        
        DefaultTableModel modelotabFinal = (DefaultTableModel) TablaFinal.getModel();
        Object fila [] = new Object[12];
        for(int i = 0 ; i< diasSimulacion; i++){
            fila [0] = resultado.tablaEventos[Caso.DIA][i];
            fila [1] = resultado.tablaEventos[Caso.INV_INICIAL][i];
            fila [2] = resultado.tablaEventos[Caso.NRO_ALT_DEMANDA][i];
            fila [3] = resultado.tablaEventos[Caso.DEMANDA][i];
            fila [4] = resultado.tablaEventos[Caso.INV_FINAL][i];
            fila [5] = resultado.tablaEventos[Caso.INV_PROMEDIO][i];
            fila [6] = resultado.tablaEventos[Caso.FALTANTE][i];
            fila [7] = resultado.tablaEventos[Caso.NRO_ORDEN][i];
            fila [8] = resultado.tablaEventos[Caso.NRO_ALT_T_ENTREGA][i];
            fila [9] = resultado.tablaEventos[Caso.T_ENTREGA][i];
            fila [10] = resultado.tablaEventos[Caso.NRO_ALT_T_ESPERA][i];
            fila [11] = resultado.tablaEventos[Caso.T_ESPERA][i];

            modelotabFinal.addRow(fila);
        }

        CstFlteLbl.setText( resultado.costoTotalConEspera.add(resultado.costoTotalSinEspera).toString());
        CstTtlLbl.setText(resultado.costoTotal.toString());
        CstInvLbl.setText(resultado.costoTotalInventario.toString());
        CstOrdLbl.setText(resultado.costoTotalOrden.toString());
        
        
        time_end = System.currentTimeMillis();
        TmEjeLbl.setText( String.valueOf((( time_end - time_start )/ 1000) % 60 ) + " segundos.");
        System.out.println("Tiempo de simulación: "+ ( time_end - time_start ) +" milisegundos");

        
        
        
        
    }//GEN-LAST:event_RunBtnActionPerformed

    private void SimDiasTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimDiasTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SimDiasTxtFieldActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        capturar_informacion();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
    
    public  void eliminarcolumna(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.removeRow(tabla.getRowCount()-1);
        
    }
    
    public int generarAcumulada(DefaultTableModel modelo, JTable tabla, int probablidad){
        
        if(tabla.getRowCount()>0){
            if( (int) tabla.getValueAt(tabla.getRowCount()-1, 1) + probablidad <= 100)
                return (int) tabla.getValueAt(tabla.getRowCount()-1, 2)+ probablidad;
            else{
                JOptionPane.showMessageDialog(null, "Con esta probabildiad, el acumulado supera el 100%", "Advetencia", JOptionPane.ERROR_MESSAGE );
                return 0;
            }
        }else{
            return probablidad;
        }
    }
    
    public static int getAltNumber (int aleatorio, JTable tabla){
        
        for(int i = 0; i < tabla.getRowCount();i++){
            
            if(i<tabla.getRowCount()-1){
                
                if (aleatorio == (int) tabla.getValueAt(i, 2) || aleatorio < (int) tabla.getValueAt(i, 2)) {
                    return (int) tabla.getValueAt(i, 0);
                }
                if(aleatorio > (int) tabla.getValueAt(i, 2) && aleatorio < (int) tabla.getValueAt(i+1, 2)){
                    return (int) tabla.getValueAt(i+1, 0);
                }
                
            }else{
                return (int) tabla.getValueAt(i, 0);
            }
        }
        
        return 0;        
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
    
    public void setAleatorio (String linea, int [] arreglo){
        
        ArrayList <Integer> lista = new ArrayList <Integer> ();
        
        while (linea.indexOf(',')>0){
            
            lista.add(Integer.parseInt(linea.substring(linea.indexOf(' '), linea.indexOf(','))));
            linea  = "   " + linea.substring(linea.indexOf(',')+1);
        }
        
        lista.add(Integer.parseInt(linea.substring(linea.indexOf(' '), linea.indexOf(','))));
        
        arreglo = new int [lista.size()];
        
        for(int i: lista){
            arreglo[i] = lista.get(i);
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
    private javax.swing.JTextField CostInvTxtField;
    private javax.swing.JTextField CostOrdTxtField;
    private javax.swing.JTextField CostSEspTxtField;
    private javax.swing.JLabel CstFlteLbl;
    private javax.swing.JLabel CstInvLbl;
    private javax.swing.JLabel CstOrdLbl;
    private javax.swing.JLabel CstTtlLbl;
    private javax.swing.JButton DelDemBtn;
    private javax.swing.JButton DelTEnBtn;
    private javax.swing.JButton DelTEsBtn;
    private javax.swing.JLabel DemLbl;
    private javax.swing.JSpinner DemSpin;
    private javax.swing.JTextField InvIncTxtField;
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
    private javax.swing.JLabel RLbl;
    private javax.swing.JButton RunBtn;
    private javax.swing.JPanel SetPanel;
    private javax.swing.JTextField SimDiasTxtField;
    private javax.swing.JTable TablaDeman;
    private javax.swing.JTable TablaFinal;
    private javax.swing.JTable TablaTEn;
    private javax.swing.JTable TablaTEs;
    private javax.swing.JLabel TmEjeLbl;
    private javax.swing.JButton TmEnBtn;
    private javax.swing.JLabel TmEnLbl;
    private javax.swing.JSpinner TmEnSpin;
    private javax.swing.JButton TmEsBtn;
    private javax.swing.JLabel TmEsLbl;
    private javax.swing.JSpinner TmEsSpin;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
