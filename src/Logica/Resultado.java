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
public class Resultado extends ResultadoParcial{
    public Integer[][] tablaEventos;
    public BigDecimal costoTotalSinEspera;
    public BigDecimal costoTotalConEspera;
    public BigDecimal costoTotalInventario;
    public BigDecimal costoTotalOrden;

    public Resultado(Integer[][] tablaEventos, BigDecimal costoTotalSinEspera, BigDecimal costoTotalConEspera, BigDecimal costoTotalInventario, BigDecimal costoTotalOrden, BigDecimal costoTotal) {
        super(costoTotal);
        
        this.tablaEventos = tablaEventos;
        this.costoTotalSinEspera = costoTotalSinEspera;
        this.costoTotalConEspera = costoTotalConEspera;
        this.costoTotalInventario = costoTotalInventario;
        this.costoTotalOrden = costoTotalOrden;
    }

    public Resultado(Integer[][] tablaEventos, BigDecimal costoTotalSinEspera, BigDecimal costoTotalConEspera, BigDecimal costoTotalInventario, BigDecimal costoTotalOrden, int cantidadPedido, int puntoReorden, BigDecimal costoTotal) {
        super(cantidadPedido, puntoReorden, costoTotal);
        this.tablaEventos = tablaEventos;
        this.costoTotalSinEspera = costoTotalSinEspera;
        this.costoTotalConEspera = costoTotalConEspera;
        this.costoTotalInventario = costoTotalInventario;
        this.costoTotalOrden = costoTotalOrden;
    }
}
