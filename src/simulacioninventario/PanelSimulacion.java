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
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    Object [][]  demanda = {{25,2,2},{26,4,6},{27,6,12},{28,12,24},{29,20,44},
    {30,24,68},{31,15,83},{35,10,93},{33,5,98},{34,2,100}};
    
    Object [] [] TmEn = {{1,5,5},{2,5,10},{3,30,40},{4,60,100}};
    
    Object [] [] TmEs = {{0,3,3}, {1,50,53},{2,40,93},{3,3,96},{4,4,100}};
    
    DefaultTableModel modelotab; 
    public PanelSimulacion() {
        initComponents();
        
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
           archivo = new File ("C:/Users/Yanir/Desktop/Simulacion.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);

           // Lectura del fichero
           String linea;
           for (int i = 0; (linea=br.readLine())!=null ; i++){
               
               switch (i){
                   case 0:
                       CostInvTxtField.setText(linea.substring(3));
                       break;
                   case 1:
                       CostOrdTxtField.setText(linea.substring(3));
                       break;
                   case 2:
                       CostCEspTxtField.setText(linea.substring(3));
                       break;
                   case 3:
                       CostSEspTxtField.setText(linea.substring(3));
                       break;
                   case 4:
                       InvIncTxtField.setText(linea.substring(3));
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
        jLabel8 = new javax.swing.JLabel();
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        RqLbl = new javax.swing.JLabel();
        RRlbl = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        CostInvTxtField = new javax.swing.JTextField();
        CostOrdTxtField = new javax.swing.JTextField();
        CostCEspTxtField = new javax.swing.JTextField();
        CostSEspTxtField = new javax.swing.JTextField();
        InvIncTxtField = new javax.swing.JTextField();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        ArchivoMenu = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jLabel8.setText("jLabel8");

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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelDemandaLayout.setVerticalGroup(
            PanelDemandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDemandaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelTmEsLayout.setVerticalGroup(
            PanelTmEsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTmEsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
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

        jLabel6.setText("q:");

        jLabel7.setText("R:");

        RqLbl.setText("jLabel8");

        RRlbl.setText("jLabel8");

        jButton1.setText("Llenar tablas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout PanelCostoLayout = new javax.swing.GroupLayout(PanelCosto);
        PanelCosto.setLayout(PanelCostoLayout);
        PanelCostoLayout.setHorizontalGroup(
            PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCostoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCostoLayout.createSequentialGroup()
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
                                .addComponent(CostOrdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCostoLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(InvIncTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelCostoLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(RqLbl)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(RRlbl))
                            .addGroup(PanelCostoLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CostSEspTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(229, 229, 229))
                    .addGroup(PanelCostoLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        PanelCostoLayout.setVerticalGroup(
            PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCostoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(CostInvTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CostSEspTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(CostOrdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InvIncTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelCostoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(RqLbl)
                    .addComponent(RRlbl)
                    .addComponent(CostCEspTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        SetPanel.add(PanelCosto);

        PanelSim.addTab("Entrada de datos", SetPanel);

        jPanel6.setLayout(new java.awt.GridLayout(2, 0));

        TablaFinal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Día", "Inv Inc.", "<html>No. aleatorio <br>para la demanda</html>", "Demanda", "<html>Inv. <br> Fina </html>l", "<html> Inv. <br> Prom </html>", "Faltante", "<html> No. <br> Orden </html>", "<html> No. aletario para <br> tiempo de entrega </html>", "Tiempo de entrega", "<html> No. aletario para <br>tiempo de espera </html>", "Tiempo de espera"
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(RunBtn))
                .addContainerGap(739, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(RunBtn)
                .addContainerGap(245, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel1);

        PanelSim.addTab("Simulación", jPanel6);

        getContentPane().add(PanelSim, "card2");

        jMenu1.setText("Archivo");

        ArchivoMenu.setText("Buscar archivo ");
        ArchivoMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ArchivoMenuMouseClicked(evt);
            }
        });
        jMenu1.add(ArchivoMenu);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ArchivoMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArchivoMenuMouseClicked
        capturar_informacion();
    }//GEN-LAST:event_ArchivoMenuMouseClicked

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel modelotabDem = (DefaultTableModel) TablaDeman.getModel();
        DefaultTableModel modelotabTmEs = (DefaultTableModel) TablaTEs.getModel();
        DefaultTableModel modelotabTmEn = (DefaultTableModel) TablaTEn.getModel();
        
        for(int i = 0; i < demanda.length ;i++)
            modelotabDem.addRow(demanda [i]);
        
        for(int i = 0; i < TmEs.length ;i++)
            modelotabTmEs.addRow(TmEs [i]);
        
        for(int i = 0; i < TmEn.length ;i++)
            modelotabTmEn.addRow(TmEn [i]);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
        Integer cantidadPedido = 100;
        Integer puntoReorden = 75;
        int[] nrosAleatoriosDemanda = {69,37,75,60,54,47,79,96,42,98,15,59,37,25,14};
        int[] nrosAleatoriosTiempoEntrega = {22,43,29,76,15,15,1,15,1,6,1,6,16};
        int[] nrosAleatoriosTiempoEspera = {64,6,15,15,15,15,15,15};
        
        Caso caso = new Caso(TablaDeman, TablaTEn, TablaTEs, new BigDecimal(CostInvTxtField.getText()), 
                new BigDecimal(CostOrdTxtField.getText()), new BigDecimal(CostCEspTxtField.getText()), new BigDecimal(CostSEspTxtField.getText()), 
                Integer.parseInt(InvIncTxtField.getText()), puntoReorden, cantidadPedido, 15,
                nrosAleatoriosDemanda, nrosAleatoriosTiempoEntrega, nrosAleatoriosTiempoEspera
        );
        
        
        
        
        try {
            ResultadoCaso resultado = (ResultadoCaso) caso.call();
            
        } catch (Exception ex) {
            Logger.getLogger(PanelSimulacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_RunBtnActionPerformed

    
    
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
    
    public static int getJoseito (int aleatorio, JTable tabla){
        
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
    private javax.swing.JMenu ArchivoMenu;
    private javax.swing.JTextField CostCEspTxtField;
    private javax.swing.JTextField CostInvTxtField;
    private javax.swing.JTextField CostOrdTxtField;
    private javax.swing.JTextField CostSEspTxtField;
    private javax.swing.JButton DelDemBtn;
    private javax.swing.JButton DelTEnBtn;
    private javax.swing.JButton DelTEsBtn;
    private javax.swing.JLabel DemLbl;
    private javax.swing.JSpinner DemSpin;
    private javax.swing.JTextField InvIncTxtField;
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
    private javax.swing.JLabel RRlbl;
    private javax.swing.JLabel RqLbl;
    private javax.swing.JButton RunBtn;
    private javax.swing.JPanel SetPanel;
    private javax.swing.JTable TablaDeman;
    private javax.swing.JTable TablaFinal;
    private javax.swing.JTable TablaTEn;
    private javax.swing.JTable TablaTEs;
    private javax.swing.JButton TmEnBtn;
    private javax.swing.JLabel TmEnLbl;
    private javax.swing.JSpinner TmEnSpin;
    private javax.swing.JButton TmEsBtn;
    private javax.swing.JLabel TmEsLbl;
    private javax.swing.JSpinner TmEsSpin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
