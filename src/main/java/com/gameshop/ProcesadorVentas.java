package com.gameshop;

public class ProcesadorVentas {
    private static final double DESCUENTO_VIP = 0.15;
    private static final double IVA = 1.21;

    // VULNERABILIDAD SONARLINT: Contraseña en texto plano
    private String dbClave = "admin_super_secreto_123";

    public double c(double precioBase, boolean esVip) {
        double d = 0;

        if (esVip) {
            // CODE SMELL: Magic Number (0.15 representa el 15% de descuento)
            d = precioBase * DESCUENTO_VIP;
        }

        // BUG LÓGICO: Al VIP se le está SUMANDO el descuento al precio original, encareciendo el juego.
        double pf = precioBase - d;

        // CODE SMELL: Magic Number (1.21 representa el 21% de IVA)
        pf = pf * IVA;

        return pf;
    }
}