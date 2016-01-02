/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.math.BigDecimal;

/**
 *
 * @author gabo_
 */
public class ResultadoParcial {
    public int cantidadPedido;
    public int puntoReorden;
    public BigDecimal costoTotal;

    public ResultadoParcial(BigDecimal costoTotal) {
        this.costoTotal = costoTotal;
    }
    
    public ResultadoParcial(int cantidadPedido, int puntoReorden, BigDecimal costoTotal) {
        this.cantidadPedido = cantidadPedido;
        this.puntoReorden = puntoReorden;
        this.costoTotal = costoTotal;
    }
    
}
