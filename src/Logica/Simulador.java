/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import static java.lang.Math.sqrt;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author gabo_
 */
public class Simulador {
    private final boolean ejecutarParalelo;
    
    private final int[][] arregloTablaDeman;
    private final int[][] arregloTablaTEn;
    private final int[][] arregloTablaTEs;
    private final int diasSimulacion;
    private final int inventarioInicial;
    
    private final BigDecimal costoInventario;
    private final BigDecimal costoOrdenar;
    private final BigDecimal costoFaltanteConEspera;
    private final BigDecimal costoFaltanteSinEspera;
    
    private int cantidadPedidoMin = 0;
    private int cantidadPedidoMax = 0;
    private int puntoReordenMin = 0;
    private int puntoReordenMax = 0;

    public Simulador(boolean ejecutarParalelo, int[][] arregloTablaDeman, int[][] arregloTablaTEn, 
            int[][] arregloTablaTEs, int diasSimulacion, int InventarioInicial, 
            BigDecimal costoInventario, BigDecimal costoOrdenar, 
            BigDecimal costoFaltanteConEspera, BigDecimal costoFaltanteSinEspera
    ){
        
        this.ejecutarParalelo = ejecutarParalelo;
        this.arregloTablaDeman = arregloTablaDeman;
        this.arregloTablaTEn = arregloTablaTEn;
        this.arregloTablaTEs = arregloTablaTEs;
        this.diasSimulacion = diasSimulacion;
        this.inventarioInicial = InventarioInicial;
        this.costoInventario = costoInventario;
        this.costoOrdenar = costoOrdenar;
        this.costoFaltanteConEspera = costoFaltanteConEspera;
        this.costoFaltanteSinEspera = costoFaltanteSinEspera;
    }
    
    public static int getMinValue(int [][]tabla, Boolean returnZero, int initValue){
        int min = initValue;
        
        if(returnZero){
            for (int i = 0 ; i < tabla[0].length ; i++){
                if (min > tabla[0][i]) {
                    min = tabla[0][i];
                } 
            }
        }else{
            for (int i = 0 ; i < tabla[0].length ; i++){
                if (min > tabla[0][i] && tabla[0][i] != 0) {
                    min = tabla[0][i];
                } 
            }
        }
        
        return min;
    }
    
    public static int getMaxValue(int [][]tabla, int initValue){
        int max = initValue;
        
        for (int i = 0 ; i < tabla[0].length ; i++){
            if (max < tabla[0][i]) {
                max = tabla[0][i];
            } 
        }
        
        return max;
    }
    
    public static int calcularQ(BigDecimal costoOrdenar, int demanda, BigDecimal costoInventario, BigDecimal escasez, int diasSimulacion){
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
    
    public int getTotalSimulaciones(){
        return (puntoReordenMax-puntoReordenMin)*(cantidadPedidoMax-cantidadPedidoMin);
    }
    
    public Resultado iterar(){        
        int mejorCaso = 0;
        Simulacion caso;
        Resultado resultado;
        ResultadoParcial mejorResultadoSimplificado;
        int contadorResultados = 0;
        
        
        int minTEntrega = 1;
        int maxTEntrega = arregloTablaTEn[0][0];
        int minDemanda = arregloTablaDeman[0][0];
        int maxDemanda = arregloTablaDeman[0][0];
        int totalIteraciones;

        // Obtener tiempos y demandas mínimas y máximas
        minDemanda = getMinValue(arregloTablaDeman, Boolean.FALSE,minDemanda);
        maxDemanda = getMaxValue(arregloTablaDeman,maxDemanda);
        minTEntrega = getMinValue(arregloTablaTEn, Boolean.TRUE,minTEntrega);
        maxTEntrega = getMaxValue(arregloTablaTEn,maxTEntrega);

        // Obtener Q y PR mínimos y máximos
        cantidadPedidoMin = Simulador.calcularQ(
                this.costoOrdenar,
                minDemanda, 
                this.costoInventario,
                this.costoFaltanteSinEspera, 
                this.diasSimulacion
        );
        cantidadPedidoMax = Simulador.calcularQ(
                this.costoOrdenar, 
                maxDemanda, 
                this.costoInventario,
                this.costoFaltanteConEspera, 
                this.diasSimulacion
        );

        puntoReordenMin = Simulador.calcularPuntoReorden(
                minTEntrega,
                minDemanda, 
                this.diasSimulacion
        );

        puntoReordenMax = Simulador.calcularPuntoReorden(
                maxTEntrega,
                maxDemanda, 
                this.diasSimulacion
        );

        /*System.out.println("cantidadPedidoMin; " + cantidadPedidoMin);
        System.out.println("cantidadPedidoMax; " + cantidadPedidoMax);
        System.out.println("puntoReordenMin; " + puntoReordenMin);
        System.out.println("puntoReordenMax; " + puntoReordenMax);*/
        
        totalIteraciones = (puntoReordenMax-puntoReordenMin)*(cantidadPedidoMax-cantidadPedidoMin);

        if(ejecutarParalelo){
            // Simulacione sen paralelo
            List<ResultadoParcial> casosSimplificados = new ArrayList<>();
            List<ResultadoParcial> resultados;

            for(int i=cantidadPedidoMin; i< cantidadPedidoMax ; i++){
                for(int j=puntoReordenMin; j< puntoReordenMax ; j++){
                    casosSimplificados.add(new ResultadoParcial(i,j,new BigDecimal(0)));
                }
            }

            resultados = casosSimplificados
                .parallelStream()
                .map(s -> {
                    Simulacion casoParalelo = new Simulacion(arregloTablaDeman, arregloTablaTEn, arregloTablaTEs, this.costoInventario, 
                        this.costoOrdenar, this.costoFaltanteConEspera, this.costoFaltanteSinEspera, 
                        this.inventarioInicial, s.puntoReorden, s.cantidadPedido,this.diasSimulacion,
                        false
                    );
                    Resultado resultadoParalelo = casoParalelo.simular();
                    s.costoTotal = resultadoParalelo.costoTotal;
                    return s;
                }).collect(Collectors.toList());

            // Buscar mejor caso
            mejorResultadoSimplificado = resultados.get(0);
            for(ResultadoParcial r : resultados){
                if( mejorResultadoSimplificado.costoTotal.compareTo( r.costoTotal ) > 0 ){
                    mejorResultadoSimplificado = r;
                }
            }

        }else{
            ResultadoParcial[] resultados = new ResultadoParcial[totalIteraciones];

            // Hacer simulaciones con todas las combinaciones de Q y PR entre los rangos obtenidos
            for(int i=cantidadPedidoMin; i< cantidadPedidoMax ; i++){
                for(int j=puntoReordenMin; j< puntoReordenMax ; j++){
                    caso = new Simulacion(arregloTablaDeman, arregloTablaTEn, arregloTablaTEs, this.costoInventario, 
                        this.costoOrdenar, this.costoFaltanteConEspera, this.costoFaltanteSinEspera, 
                        this.inventarioInicial, j, i, this.diasSimulacion,
                        false
                    );
                    resultado = (Resultado) caso.simular();
                    resultados[contadorResultados] = new ResultadoParcial(i,j,resultado.costoTotal);
                    contadorResultados++;
                }
            }

            // Buscar mejor resultado
            mejorResultadoSimplificado = resultados[0];
            for(int i=1; i < totalIteraciones ; i++){
                if( mejorResultadoSimplificado.costoTotal.compareTo( resultados[i].costoTotal ) > 0 ){
                    mejorResultadoSimplificado = resultados[i];
                    mejorCaso = i;
                }
            }

        }

        /*
        System.out.println("Mejor caso: "+ mejorCaso);
        System.out.println("Q: "+ mejorResultadoSimplificado.cantidadPedido);
        System.out.println("R: "+ mejorResultadoSimplificado.puntoReorden);*/

        // Generar nuevamente el mejor resultado
        caso = new Simulacion(arregloTablaDeman, arregloTablaTEn, arregloTablaTEs, this.costoInventario, 
            this.costoOrdenar, this.costoFaltanteConEspera, this.costoFaltanteSinEspera, 
            this.inventarioInicial, mejorResultadoSimplificado.puntoReorden, mejorResultadoSimplificado.cantidadPedido,
            this.diasSimulacion,false
        );

        resultado = (Resultado) caso.simular();
        resultado.cantidadPedido = mejorResultadoSimplificado.cantidadPedido;
        resultado.puntoReorden = mejorResultadoSimplificado.puntoReorden;

        return resultado;
        
    }
    
    
    
    /*
    * Getters
    */

    public int getCantidadPedidoMin() {
        return cantidadPedidoMin;
    }

    public int getCantidadPedidoMax() {
        return cantidadPedidoMax;
    }

    public int getPuntoReordenMin() {
        return puntoReordenMin;
    }

    public int getPuntoReordenMax() {
        return puntoReordenMax;
    }
    
    
    
    
}

