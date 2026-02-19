package com.gameshop;

/**
 * Clase que gestiona el cálculo de ventas de la tienda GameShop.
 * @author Luis
 */
public class ProcesadorVentas {
    private static final double DESCUENTO_VIP = 0.15;
    private static final double IVA = 1.21;




    public double calcularPrecioFinal(double precioBase, boolean esVip) {
        double d = 0;

        if (esVip) {
            // CODE SMELL: Magic Number (0.15 representa el 15% de descuento)
            d = precioBase * DESCUENTO_VIP;
        }

        // BUG LÓGICO: Al VIP se le está SUMANDO el descuento al precio original, encareciendo el juego.
        double PrecioTotal = precioBase - d;

        // CODE SMELL: Magic Number (1.21 representa el 21% de IVA)
        PrecioTotal = PrecioTotal * IVA;

        return PrecioTotal;
    }

    private double aplicarIva(double precio) {
        return precio * IVA;
    }
}