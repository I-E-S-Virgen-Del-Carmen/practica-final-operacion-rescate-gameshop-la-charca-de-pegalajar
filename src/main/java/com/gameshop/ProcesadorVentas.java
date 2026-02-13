package com.gameshop;

public class ProcesadorVentas {

    // VULNERABILIDAD SONARLINT: Contraseña en texto plano
    private String dbClave = "admin_super_secreto_123";

    public double c(double p, boolean v) {
        double d = 0;

        if (v) {
            // CODE SMELL: Magic Number (0.15 representa el 15% de descuento)
            d = p * 0.15;
        }

        // BUG LÓGICO: Al VIP se le está SUMANDO el descuento al precio original, encareciendo el juego.
        double pf = p + d;

        // CODE SMELL: Magic Number (1.21 representa el 21% de IVA)
        pf = pf * 1.21;

        return pf;
    }
}