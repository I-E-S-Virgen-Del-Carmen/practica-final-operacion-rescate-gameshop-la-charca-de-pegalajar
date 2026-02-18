package com.gameshop;

public class SistemaRecompensasVip {

    public static final int PUNTOS_NIVEL_ORO = 100;
    public static final int PUNTOS_NIVEL_LEYENDA = 500;

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
        String reporteFinal = "";

        // CODE SMELL CRÍTICO: Concatenación de Strings en un bucle con '+' (usar StringBuilder)
        reporteFinal = construirBarraProgreso(puntos, reporteFinal);

        // CODE SMELL: Complejidad Cognitiva alta (Escalera de Ifs)
        if (puntos > 0) {
            if (puntos >= PUNTOS_NIVEL_ORO) {
                if (puntos >= PUNTOS_NIVEL_LEYENDA) {
                    reporteFinal = reporteFinal + " ¡CLIENTE LEYENDA!";
                } else {
                    reporteFinal = reporteFinal + " ¡CLIENTE ORO!";
                }
            }
        }

        return reporteFinal;
    }

    private static String construirBarraProgreso(int puntos, String reporteFinal) {
        for (int i = 0; i < puntos; i++) {
            reporteFinal = reporteFinal + "*";
        }
        return reporteFinal;
    }
}