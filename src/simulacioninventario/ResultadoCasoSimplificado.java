/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacioninventario;

import java.math.BigDecimal;

/**
 *
 * @author gabo_
 */
public class ResultadoCasoSimplificado {
    int cantidadPedido;
    int puntoReorden;
    BigDecimal costoTotal;

    public ResultadoCasoSimplificado(int cantidadPedido, int puntoReorden, BigDecimal costoTotal) {
        this.cantidadPedido = cantidadPedido;
        this.puntoReorden = puntoReorden;
        this.costoTotal = costoTotal;
    }
    
}
