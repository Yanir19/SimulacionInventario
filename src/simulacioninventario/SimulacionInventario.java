/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacioninventario;

import static java.lang.Math.sqrt;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Yanir
 */
public class SimulacionInventario {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Variables necesarias
        /*
        JTable demandaDiaria = null;
        JTable tEntrega = null;
        JTable tEspera = null;
        BigDecimal costoInventario = BigDecimal.valueOf(52.0);
        BigDecimal costoOrdenar = BigDecimal.valueOf(100.0);
        BigDecimal costoFaltanteConEspera = BigDecimal.valueOf(20.0);
        BigDecimal costoFaltanteSinEspera = BigDecimal.valueOf(50.0);
        Integer inventarioInicial = 50;
        Integer puntoReorden = 75;
        Integer cantidadPedido = 100;
        Integer diasSimulacion = 15;
        ResultadoCaso resultado;
        int[] nrosAleatoriosDemanda = {69,37,75,60,99,47,79,96,42,98,15,56,37,25,14};
        int[] nrosAleatoriosTiempoEntrega = {22,38,83,26};
        int[] nrosAleatoriosTiempoEspera = {64,06,43,29,42,1,33,12};
        */
        
        
        
        // Crear caso real, último flag significa imprimir los resultados.
        /*
        Caso caso = new Caso(demandaDiaria, tEntrega, tEspera, costoInventario, 
                costoOrdenar, costoFaltanteConEspera, costoFaltanteSinEspera, 
                inventarioInicial, puntoReorden, cantidadPedido, diasSimulacion,
                true
        );
        */
        
        // Crear caso de prueba, requiere los arreglos de números aleatorios
        /*
        Caso caso = new Caso(demandaDiaria, tEntrega, tEspera, costoInventario, 
                costoOrdenar, costoFaltanteConEspera, costoFaltanteSinEspera, 
                inventarioInicial, puntoReorden, cantidadPedido, diasSimulacion,
                nrosAleatoriosDemanda, nrosAleatoriosTiempoEntrega, nrosAleatoriosTiempoEspera
        );
        */
        
        // Obtener resultado
        // resultado = (ResultadoCaso) caso.call();
        
        try {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
           } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
               Logger.getLogger(SimulacionInventario.class.getName()).log(Level.SEVERE, null, ex);
           }
          
          
        PanelSimulacion ventana = new PanelSimulacion();
        ventana.setVisible(true);
        
    }
    
}
