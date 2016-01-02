/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.math.BigDecimal;
import java.util.Arrays;
import junit.framework.TestCase;

/**
 *
 * @author gabo_
 */
public class SimulacionTest extends TestCase {
    private int[][] arregloTablaDeman;
    private int[][] arregloTablaTEn;
    private int[][] arregloTablaTEs;
    private int[] nrosAleatoriosDemanda;
    private int[] nrosAleatoriosTiempoEntrega;
    private int[] nrosAleatoriosTiempoEspera;
    
    private BigDecimal costoInventario;
    private BigDecimal costoOrdenar;
    private BigDecimal costoFaltanteConEspera;
    private BigDecimal costoFaltanteSinEspera;
    
    private Integer inventarioInicial;
    
    private Integer puntoReorden;
    private Integer cantidadPedido;
    private Integer diasSimulacion;
    
    private Integer[][] expectedTable;
    
    public SimulacionTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        arregloTablaDeman = new int[][]{ 
            {25,26,27,28,29,30,31,35,33,34},
            //{2,4,6,12,20,24,15,10,5,2},
            {2,6,12,24,44,68,83,93,98,100}
        };
        
        arregloTablaTEn = new int[][]{ 
            {1,2,3,4},
            //{5,5,30,60},
            {5,10,40,100}
        };
                
        arregloTablaTEs = new int[][]{
            {0,1,2,3,4},
            //{3,50,40,3,4},
            {3,53,93,96,100}
        };
        
        
        nrosAleatoriosDemanda = new int[]{98,57,62,19,64,46,20,86,90,24,11,16,93,6,14};
        nrosAleatoriosTiempoEntrega = new int[]{44,91,73};
        nrosAleatoriosTiempoEspera = new int[]{2,27,74,35,94,60,33,72,15,25,80,22,51};
        

        costoInventario = new BigDecimal(52);
        costoOrdenar = new BigDecimal(100);
        costoFaltanteConEspera = new BigDecimal(20);
        costoFaltanteSinEspera = new BigDecimal(50);
        
        inventarioInicial = 50;
        puntoReorden = 75;
        cantidadPedido = 100;
        diasSimulacion = 365;
        
        expectedTable =  new Integer[][]{
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
            {50, 16, 0, 0, 0, 42, 12, 0, 0, 0, 0, 0, 0, 0, 0},
            {98, 57, 62, 19, 64, 46, 20, 86, 90, 24, 11, 16, 93, 6, 14},
            {34, 30, 30, 28, 30, 30, 28, 35, 35, 29, 27, 28, 33, 27, 28},
            {16, 0, 0, 0, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {33, 8, 0, 0, 0, 27, 6, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 14, 30, 28, 30, 0, 16, 35, 35, 29, 27, 28, 33, 27, 28},
            {1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 3, 0, 0, 0, 0},
            {44, 0, 0, 0, 0, 91, 0, 0, 0, 0, 73, 0, 0, 0, 0},
            {4, 0, 0, 0, 0, 4, 0, 0, 0, 0, 4, 0, 0, 0, 0},
            {0, 2, 27, 74, 35, 0, 94, 60, 33, 72, 15, 25, 80, 22, 51},
            {0, 0, 1, 2, 1, 0, 3, 2, 1, 2, 1, 1, 2, 1, 1},
        };
        
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of calcularQ method, of class SimulacionTest.
     */
    public void testCalcularQ() {
        System.out.println("testCalcularQ");
        
        int minDemanda = arregloTablaDeman[0][0];
        int maxDemanda = arregloTablaDeman[0][0];

        // Obtener tiempos y demandas mínimas y máximas
        minDemanda = Simulador.getMinValue(arregloTablaDeman, Boolean.FALSE,minDemanda);
        maxDemanda = Simulador.getMaxValue(arregloTablaDeman,maxDemanda);
        
        int min = Simulador.calcularQ(costoOrdenar, minDemanda, costoInventario, costoFaltanteSinEspera, diasSimulacion);
        int max = Simulador.calcularQ(costoOrdenar, maxDemanda, costoInventario, costoFaltanteConEspera, diasSimulacion);
        assertEquals(268, min);
        assertEquals(421, max);
    }

    /**
     * Test of calcularPuntoReorden method, of class SimulacionTest.
     */
    public void testCalcularPuntoReorden() {
        System.out.println("testCalcularPuntoReorden");
        
        int minTEntrega = 1;
        int maxTEntrega = arregloTablaTEn[0][0];
        int minDemanda = arregloTablaDeman[0][0];
        int maxDemanda = arregloTablaDeman[0][0];

        // Obtener tiempos y demandas mínimas y máximas
        minDemanda = Simulador.getMinValue(arregloTablaDeman, Boolean.FALSE,minDemanda);
        maxDemanda = Simulador.getMaxValue(arregloTablaDeman,maxDemanda);
        minTEntrega = Simulador.getMinValue(arregloTablaTEn, Boolean.TRUE,minTEntrega);
        maxTEntrega = Simulador.getMaxValue(arregloTablaTEn,maxTEntrega);
        
        
        int min = Simulador.calcularPuntoReorden(minTEntrega,minDemanda,diasSimulacion);
        int max = Simulador.calcularPuntoReorden(maxTEntrega,maxDemanda,diasSimulacion);
        assertEquals(25, min);
        assertEquals(140, max);
    }

    /**
     * Test of simular method, of class SimulacionTest.
     */
    public void testSimular() {
        System.out.println("testSimular");

        Simulacion caso = new Simulacion( this.arregloTablaDeman, this.arregloTablaTEn, this.arregloTablaTEs, this.costoInventario, 
                    this.costoOrdenar, this.costoFaltanteConEspera, this.costoFaltanteSinEspera, 
                   this.inventarioInicial, puntoReorden, cantidadPedido, 15,
                    nrosAleatoriosDemanda, nrosAleatoriosTiempoEntrega, nrosAleatoriosTiempoEspera, false
            );
        
        Resultado resultado = caso.simular();

        assertEquals("8880.0", resultado.costoTotalConEspera.add(resultado.costoTotalSinEspera).toString());
        assertEquals("300.0", resultado.costoTotalOrden.toString());
        assertEquals("10.5424657534246575342465753424657516", resultado.costoTotalInventario.toString());
        assertEquals("9190.5424657534246575342465753424657516", resultado.costoTotal.toString());
        
        for(int i=0; i<expectedTable.length ;i++){
            assertTrue(Arrays.equals(expectedTable[i] , resultado.tablaEventos[i]));
        }
    }
}
