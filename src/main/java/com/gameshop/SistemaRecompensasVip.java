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
     * @param tipoCliente El nombre del tipo de cliente a validar.
     * @return true si es "Premium", false si es nulo o diferente.
     */
    public boolean comprobarVip(String tipoCliente) {
        // BUG (NPE): Solucionado mediante comparación segura contra String literal
        return "Premium".equals(tipoCliente);
    }

    /**
     * Genera un informe visual del progreso del cliente y su nivel alcanzado.
     * @param puntos Cantidad de puntos acumulados por el cliente.
     * @return Cadena de texto con la barra de progreso y el tag de nivel.
     */
    public String generarReporte(int puntos) {
        // CODE SMELL CRÍTICO: Solucionado usando StringBuilder en lugar de concatenación '+'
        StringBuilder reporteFinal = construirBarraProgreso(puntos);

        // CODE SMELL: Complejidad Cognitiva alta. Solucionado con estructura else-if plana.
        if (puntos >= PUNTOS_NIVEL_LEYENDA) {
            reporteFinal.append(" ¡CLIENTE LEYENDA!");
        } else if (puntos >= PUNTOS_NIVEL_ORO) {
            reporteFinal.append(" ¡CLIENTE ORO!");
        }

        return reporteFinal.toString();
    }

    /**
     * Método auxiliar para construir la barra de asteriscos.
     * @param puntos Número de asteriscos a generar.
     * @return StringBuilder con la barra generada.
     */
    private static StringBuilder construirBarraProgreso(int puntos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < puntos; i++) {
            sb.append("*");
        }
        return sb;
    }
}