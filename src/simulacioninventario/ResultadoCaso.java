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
public class ResultadoCaso {
    Integer[][] tablaEventos;
    BigDecimal costoTotalSinEspera;
    BigDecimal costoTotalConEspera;
    BigDecimal costoTotalInventario;
    BigDecimal costoTotalOrden;
    BigDecimal costoTotal; 

    public ResultadoCaso(Integer[][] tablaEventos, BigDecimal costoTotalSinEspera, BigDecimal costoTotalConEspera, BigDecimal costoTotalInventario, BigDecimal costoTotalOrden, BigDecimal costoTotal) {
        this.tablaEventos = tablaEventos;
        this.costoTotalSinEspera = costoTotalSinEspera;
        this.costoTotalConEspera = costoTotalConEspera;
        this.costoTotalInventario = costoTotalInventario;
        this.costoTotalOrden = costoTotalOrden;
        this.costoTotal = costoTotal;
    }    
    
}
