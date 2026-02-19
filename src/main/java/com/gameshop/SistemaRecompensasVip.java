package com.gameshop;

/**
 * Gestiona el sistema de recompensas y niveles de fidelización para clientes VIP.
 * @author Jose Murciano
 */
public class SistemaRecompensasVip {

    public static final int PUNTOS_NIVEL_ORO = 100;
    public static final int PUNTOS_NIVEL_LEYENDA = 500;

    /**
     * Valida si un tipo de cliente tiene rango Premium de forma segura.
     * @param tipoCliente El nombre del tipo de cliente.
     * @return true si es "Premium", false si es otro tipo o null.
     */
    public boolean comprobarVip(String tipoCliente) {
        // BUG (NPE): Si 'tipoCliente' es null (como pasa en el Main), intentar hacer .equals() lanza un NullPointerException.
        // SOLUCIÓN SONARLINT: Escribir "Premium".equals(tipoCliente)
        return "Premium".equals(tipoCliente);
    }

    /**
     * Genera un informe visual del progreso del cliente basado en sus puntos.
     * @param puntos Cantidad de puntos acumulados.
     * @return Cadena con barra de progreso y etiqueta de nivel.
     */
    public String generarReporte(int puntos) {
        // CODE SMELL CRÍTICO: Concatenación de Strings en un bucle con '+' (usar StringBuilder)
        StringBuilder reporteFinal = construirBarraProgreso(puntos);

        // CODE SMELL: Complejidad Cognitiva alta (Escalera de Ifs)
        // Refactorizado para usar una estructura plana de else-if
        if (puntos >= PUNTOS_NIVEL_LEYENDA) {
            reporteFinal.append(" ¡CLIENTE LEYENDA!");
        } else if (puntos >= PUNTOS_NIVEL_ORO) {
            reporteFinal.append(" ¡CLIENTE ORO!");
        }

        return reporteFinal.toString();
    }

    /**
     * Crea una representación visual mediante asteriscos de los puntos.
     * @param puntos Cantidad de asteriscos a generar.
     * @return StringBuilder con la barra de progreso generada.
     */
    private static StringBuilder construirBarraProgreso(int puntos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < puntos; i++) {
            sb.append("*");
        }
        return sb;
    }
}