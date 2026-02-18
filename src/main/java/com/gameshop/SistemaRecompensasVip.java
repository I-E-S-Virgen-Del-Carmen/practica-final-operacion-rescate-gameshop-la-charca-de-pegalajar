package com.gameshop;

public class SistemaRecompensasVip {

    public boolean comprobarVip(String tipoCliente) {
        // BUG (NPE): Si 'tipoCliente' es null (como pasa en el Main), intentar hacer .equals() lanza un NullPointerException.
        // SOLUCIÓN SONARLINT: Escribir "Premium".equals(tipoCliente)
        if ("Premium".equals(tipoCliente)) {
            return true;
        } else {
            return false;
        }
    }

    public String generarReporte(int puntos) {
        String r = "";

        // CODE SMELL CRÍTICO: Concatenación de Strings en un bucle con '+' (usar StringBuilder)
        for (int i = 0; i < puntos; i++) {
            r = r + "*";
        }

        // CODE SMELL: Complejidad Cognitiva alta (Escalera de Ifs)
        if (puntos > 0) {
            if (puntos >= 100) {
                if (puntos >= 500) {
                    r = r + " ¡CLIENTE LEYENDA!";
                } else {
                    r = r + " ¡CLIENTE ORO!";
                }
            }
        }

        return r;
    }
}