/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacioninventario;

import static java.lang.Math.sqrt;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.concurrent.Callable;
import javax.swing.JTable;

/**
 *
 * @author gabo_
 */
public class Caso{
    // Constantes
    public static final int DIA = 0;
    public static final int INV_INICIAL = 1;
    public static final int NRO_ALT_DEMANDA = 2;
    public static final int DEMANDA = 3;
    public static final int INV_FINAL = 4;
    public static final int INV_PROMEDIO = 5;
    public static final int FALTANTE = 6;
    public static final int NRO_ORDEN = 7;
    public static final int NRO_ALT_T_ENTREGA = 8;
    public static final int T_ENTREGA = 9;
    public static final int NRO_ALT_T_ESPERA = 10;
    public static final int T_ESPERA = 11;
    
    // Valores fijos de la simulación
    private final JTable demandaDiaria;
    private final JTable tEntrega;
    private final JTable tEspera;
    
    private final BigDecimal costoInventario;
    private final BigDecimal costoOrdenar;
    private final BigDecimal costoFaltanteConEspera;
    private final BigDecimal costoFaltanteSinEspera;
    
    private final Integer inventarioInicial;
    
    private final int[] nrosAleatoriosDemanda;
    private int contadorDemanda = 0;
    private final int[] nrosAleatoriosTiempoEntrega;
    private int contadorTEntrega = 0;
    private final int[] nrosAleatoriosTiempoEspera;
    private int contadorTEspera = 0;
    
    // Variables de la simulación
    private final Integer puntoReorden;
    private final Integer cantidadPedido;
    private final Integer diasSimulacion;
    private final Boolean printTable;
    private final Boolean debugMode;
    
    private Integer nroOrden = 1;
    
    // Variables resultantes
    private BigDecimal costoTotalSinEspera = BigDecimal.valueOf(0.0);
    private BigDecimal costoTotalConEspera = BigDecimal.valueOf(0.0);
    private BigDecimal costoTotalInventario = BigDecimal.valueOf(0.0);
    private BigDecimal costoTotalOrden = BigDecimal.valueOf(0.0);
    private BigDecimal costoTotal = BigDecimal.valueOf(0.0);
    private BigDecimal costoDiarioInventario;

    public static int calcularQ(BigDecimal costoOrdenar, int demanda, BigDecimal costoInventario, BigDecimal escasez, int diasSimulacion){
        //System.out.println(costoOrdenar.multiply(new BigDecimal(2*demanda)));
        //System.out.println(escasez.multiply(costoInventario));
        Double sqrtResult = sqrt((costoOrdenar.multiply(new BigDecimal(2*demanda*diasSimulacion)).multiply(escasez.add(costoInventario))).divide((escasez.multiply(costoInventario)), RoundingMode.HALF_UP).doubleValue());
        if(sqrtResult % 1 != 0){
            sqrtResult += 1;
        }
        return sqrtResult.intValue();
    }
    
    public static int calcularPuntoReorden(int l,int demanda, int diasSimulacion){
        Double resultado = ((double) l/diasSimulacion)*(demanda*diasSimulacion);
        return resultado.intValue();
    }
    
    public Caso(JTable demandaDiaria, JTable tEntrega, JTable tEspera, 
            BigDecimal costoInventario, BigDecimal costoOrdenar, BigDecimal costoFaltanteConEspera, 
            BigDecimal costoFaltanteSinEspera, Integer inventarioInicial, Integer puntoReorden, 
            Integer cantidadPedido, Integer diasSimulacion, Boolean printTable) {
        
        this.demandaDiaria = demandaDiaria;
        this.tEntrega = tEntrega;
        this.tEspera = tEspera;
        this.costoInventario = costoInventario;
        this.costoOrdenar = costoOrdenar;
        this.costoFaltanteConEspera = costoFaltanteConEspera;
        this.costoFaltanteSinEspera = costoFaltanteSinEspera;
        this.inventarioInicial = inventarioInicial;
        this.puntoReorden = puntoReorden;
        this.cantidadPedido = cantidadPedido;
        this.diasSimulacion = diasSimulacion;
        this.printTable = printTable;
        
        this.nrosAleatoriosDemanda = null;
        this.nrosAleatoriosTiempoEntrega = null;
        this.nrosAleatoriosTiempoEspera = null;
        
        this.debugMode = false;
        
        this.costoDiarioInventario = this.costoInventario.divide(BigDecimal.valueOf(365), MathContext.DECIMAL128);
        
    }
    
    /*
    * Debug mode constructor. Debe enviarse los arreglos de números aleatorios necesarios para la ejecución de 15 días
    */
    public Caso(JTable demandaDiaria, JTable tEntrega, JTable tEspera, 
            BigDecimal costoInventario, BigDecimal costoOrdenar, BigDecimal costoFaltanteConEspera, 
            BigDecimal costoFaltanteSinEspera, Integer inventarioInicial, Integer puntoReorden, 
            Integer cantidadPedido, Integer diasSimulacion, int[] nrosAleatoriosDemanda,
            int[] nrosAleatoriosTiempoEntrega, int[] nrosAleatoriosTiempoEspera) {
        
        this.demandaDiaria = demandaDiaria;
        this.tEntrega = tEntrega;
        this.tEspera = tEspera;
        this.costoInventario = costoInventario;
        this.costoOrdenar = costoOrdenar;
        this.costoFaltanteConEspera = costoFaltanteConEspera;
        this.costoFaltanteSinEspera = costoFaltanteSinEspera;
        this.inventarioInicial = inventarioInicial;
        this.puntoReorden = puntoReorden;
        this.cantidadPedido = cantidadPedido;
        this.diasSimulacion = diasSimulacion;
        this.printTable = true;
        
        this.nrosAleatoriosDemanda = nrosAleatoriosDemanda;
        this.nrosAleatoriosTiempoEntrega = nrosAleatoriosTiempoEntrega;
        this.nrosAleatoriosTiempoEspera = nrosAleatoriosTiempoEspera;
        
        this.debugMode = true;
        
        this.costoDiarioInventario = this.costoInventario.divide(BigDecimal.valueOf(365), MathContext.DECIMAL128);
        
        //System.out.println("costoDiarioInventario " + this.costoDiarioInventario);
    }
    
    public ResultadoCaso simular() {
        Integer[][] tablaEventos = new Integer[12][this.diasSimulacion];
        int dia = 0;
        int diaEntregaPedido = 0;
        LinkedList<clienteEspera> clientesEspera = new LinkedList<>();
        int resto;
        Random randomGenerator = new Random();
        
        tablaEventos[DIA][dia] = dia+1;
        //tablaEventos[INV_INICIAL][dia] = this.inventarioInicial;
        
        if(this.printTable){
            System.out.println("DIA\t|INV_INICIAL\t|NRO_ALT_DEMANDA|DEMANDA\t| INV_FINAL\t| INV_PROMEDIO\t| FALTANTE\t| NRO_ORDEN\t| NRO_ALT_T_ENTREGA\t| T_ENTREGA\t| NRO_ALT_T_ESPERA\t| T_ESPERA ");
        }
        
        for( ; dia<this.diasSimulacion ; dia++){
            // Inicializar variables
            tablaEventos[DIA][dia] = 0;
            tablaEventos[INV_INICIAL][dia] = 0;
            tablaEventos[NRO_ALT_DEMANDA][dia] = 0;
            tablaEventos[INV_FINAL][dia] = 0;
            tablaEventos[DEMANDA][dia] = 0;
            tablaEventos[INV_PROMEDIO][dia] = 0;
            tablaEventos[FALTANTE][dia] = 0;
            tablaEventos[NRO_ORDEN][dia] = 0;
            tablaEventos[NRO_ALT_T_ENTREGA][dia] = 0;
            tablaEventos[T_ENTREGA][dia] = 0;
            tablaEventos[NRO_ALT_T_ESPERA][dia] = 0;
            tablaEventos[T_ESPERA][dia] = 0;
            
            if(dia>0){
                tablaEventos[INV_INICIAL][dia] = tablaEventos[INV_FINAL][dia-1];
            }else{
                tablaEventos[INV_INICIAL][dia] = this.inventarioInicial;
            }
            
            
            // Llegó un pedido?
            if( dia == diaEntregaPedido && dia>0){
                tablaEventos[INV_INICIAL][dia] += this.cantidadPedido;
            }
            
            // Si hay clientes en espera e inventario suficiente, atenderlos
            ListIterator<clienteEspera> iterator = clientesEspera.listIterator();
            while(iterator.hasNext()){
                clienteEspera cliente = iterator.next();
                // Si tiempo de espera del cliente está vencido, se pierde el cliente
                if ( cliente.diaEspera > dia+1 ){
                    this.costoTotalSinEspera = this.costoTotalSinEspera.add(this.costoFaltanteSinEspera.multiply(BigDecimal.valueOf(cliente.faltante)));
                    iterator.remove();
                    break;
                }
                
                
                
                // Si no está vencido y hay inventario, añadir costos
                if(tablaEventos[INV_INICIAL][dia] > 0 ){
                    
                    // Hay suficiente inventario suplirlo completamente y quitar el cliente de la cola, sino suplir lo que se pueda
                    if( tablaEventos[INV_INICIAL][dia] >= cliente.faltante ){
                        tablaEventos[INV_INICIAL][dia] -= cliente.faltante;
                        this.costoTotalConEspera = this.costoTotalConEspera.add(this.costoFaltanteConEspera.multiply(BigDecimal.valueOf(cliente.faltante)));
                        iterator.remove();
                    }else{
                        resto = cliente.faltante - tablaEventos[INV_INICIAL][dia];
                        cliente.faltante -= tablaEventos[INV_INICIAL][dia];
                        tablaEventos[INV_INICIAL][dia] = 0;
                        this.costoTotalConEspera = this.costoTotalConEspera.add(this.costoFaltanteConEspera.multiply(BigDecimal.valueOf(resto)));
                    }
                }else{
                    break;
                }
            }
            
            // Generar número aleatorio de demanda
            if(debugMode){
                tablaEventos[NRO_ALT_DEMANDA][dia] = this.nrosAleatoriosDemanda[this.contadorDemanda];
                this.contadorDemanda++;
            }else{
                tablaEventos[NRO_ALT_DEMANDA][dia] = randomGenerator.nextInt(100);
            }
            
            // Obtener demanda de la tabla de probabilidad
            tablaEventos[DEMANDA][dia] = PanelSimulacion.getAltNumber(tablaEventos[NRO_ALT_DEMANDA][dia], this.demandaDiaria);

            
            // Si la demanda es menor que el inventario disponible satisfacer la demanda, si no coloca al cliente en espera
            if ( tablaEventos[DEMANDA][dia] <= tablaEventos[INV_INICIAL][dia] ) {
                tablaEventos[INV_FINAL][dia] = tablaEventos[INV_INICIAL][dia] - tablaEventos[DEMANDA][dia];
            }else{
                tablaEventos[FALTANTE][dia] = tablaEventos[DEMANDA][dia] - tablaEventos[INV_INICIAL][dia];
                tablaEventos[INV_FINAL][dia] = 0;
                
                // Generar número aleatorio de tiempo de espera
                if(debugMode){
                    tablaEventos[NRO_ALT_T_ESPERA][dia] = this.nrosAleatoriosTiempoEspera[this.contadorTEspera];
                    this.contadorTEspera++;
                }else{
                    tablaEventos[NRO_ALT_T_ESPERA][dia] = randomGenerator.nextInt(100);
                }
                // Obtener tiempo de entrega de la tabla de probabilidad
                tablaEventos[T_ESPERA][dia] = PanelSimulacion.getAltNumber(tablaEventos[NRO_ALT_T_ESPERA][dia], this.tEspera);
                
                // Añadir cliente a la lista de espera
                if(tablaEventos[T_ESPERA][dia] > 0){
                    clienteEspera clienteNuevo = new clienteEspera(dia + tablaEventos[T_ESPERA][dia], tablaEventos[FALTANTE][dia]);
                    clientesEspera.add(clienteNuevo);
                }else{
                    this.costoTotalSinEspera = this.costoTotalSinEspera.add(this.costoFaltanteSinEspera.multiply(BigDecimal.valueOf(tablaEventos[FALTANTE][dia])));
                }
            }
            
            // Calcular inventario promedio y sumar costos de inventario del día
            
            tablaEventos[INV_PROMEDIO][dia] = (int) Math.ceil(((tablaEventos[INV_INICIAL][dia] + (float )tablaEventos[INV_FINAL][dia])/2));
            //this.costoTotalInventario = this.costoTotalInventario.add(this.costoInventario.multiply(BigDecimal.valueOf(tablaEventos[INV_PROMEDIO][dia])));
            this.costoTotalInventario = this.costoTotalInventario.add(this.costoDiarioInventario.multiply(BigDecimal.valueOf(tablaEventos[INV_PROMEDIO][dia])));
            
            // Si el inventario al final del día alcanza el punto de reorden y no hay ordenes pendientes hacer pedido
            if ( tablaEventos[INV_FINAL][dia] <= this.puntoReorden && diaEntregaPedido <= dia ){
                this.costoTotalOrden = this.costoTotalOrden.add(this.costoOrdenar);
                
                // Generar número aleatorio de entrega
                if(debugMode){
                    tablaEventos[NRO_ALT_T_ENTREGA][dia] = this.nrosAleatoriosTiempoEntrega[this.contadorTEntrega];
                    this.contadorTEntrega++;
                }else{
                    tablaEventos[NRO_ALT_T_ENTREGA][dia] = randomGenerator.nextInt(100);
                }
                // Obtener demanda de la tabla de probabilidad
                tablaEventos[T_ENTREGA][dia] = PanelSimulacion.getAltNumber(tablaEventos[NRO_ALT_T_ENTREGA][dia], this.tEntrega);
                
                diaEntregaPedido = dia + tablaEventos[T_ENTREGA][dia] + 1;
                
                tablaEventos[NRO_ORDEN][dia] = nroOrden++;
            }
            
            tablaEventos[DIA][dia] = dia + 1 ;
            
            if(this.printTable){
                System.out.println(
                        tablaEventos[DIA][dia] + "\t|" +
                        tablaEventos[INV_INICIAL][dia]+ "\t\t|" +
                        tablaEventos[NRO_ALT_DEMANDA][dia]+ "\t\t|" +
                        tablaEventos[DEMANDA][dia]+ "\t\t|" +
                        tablaEventos[INV_FINAL][dia]+ "\t\t|" +
                        tablaEventos[INV_PROMEDIO][dia]+ "\t\t|" +
                        tablaEventos[FALTANTE][dia]+ "\t\t|" +
                        tablaEventos[NRO_ORDEN][dia]+ "\t\t|" +
                        tablaEventos[NRO_ALT_T_ENTREGA][dia]+ "\t\t\t|" +
                        tablaEventos[T_ENTREGA][dia]+ "\t\t|" +
                        tablaEventos[NRO_ALT_T_ESPERA][dia]+ "\t\t\t|" +
                        tablaEventos[T_ESPERA][dia]
                    );
            }
        }
        
        this.costoTotal = this.costoTotal.add(this.costoTotalSinEspera);
        this.costoTotal = this.costoTotal.add(this.costoTotalConEspera);
        this.costoTotal = this.costoTotal.add(this.costoTotalInventario);
        this.costoTotal = this.costoTotal.add(this.costoTotalOrden);
        
        ResultadoCaso resultado = new ResultadoCaso(tablaEventos,this.costoTotalSinEspera, this.costoTotalConEspera, this.costoTotalInventario, this.costoTotalOrden, this.costoTotal);
        
        return resultado;
    }
}
