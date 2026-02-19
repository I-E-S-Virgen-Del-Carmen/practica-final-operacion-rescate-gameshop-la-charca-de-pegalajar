package com.gameshop;
import java.util.logging.Logger;

public class GestorInventario {

    private static final Logger LOGGER = Logger.getLogger(GestorInventario.class.getName());
    public static final int STOCK_MINIMO = 5;
    public static final String MENSAJE_ALERTA = "¡ALERTA! Pedir más copias de ";

    public void revisarInventario(String[] nombreJuegos, int[] stock) {
        int totalJuegos = 0;

        // BUG LÓGICO: El '- 1' hace que el último elemento (Halo) se ignore por completo.
        totalJuegos = imprimirStockYAlertas(nombreJuegos, stock, totalJuegos);
        mostrarTotal(totalJuegos);
    }

    private static void mostrarTotal(int totalJuegos) {
        LOGGER.log(java.util.logging.Level.INFO, "Total de juegos en el almacén: {0}", totalJuegos);
    }

    private static int imprimirStockYAlertas(String[] nombreJuegos, int[] stock, int totalJuegos) {
        for (int i = 0; i < nombreJuegos.length; i++) {
            LOGGER.log(java.util.logging.Level.INFO, "Revisando stock de: {0}", nombreJuegos[i]);


            // CODE SMELL: Magic Number (5)
            if (stock[i] <= STOCK_MINIMO) {
                LOGGER.log(java.util.logging.Level.INFO, "{0}{1}", new Object[]{MENSAJE_ALERTA, nombreJuegos[i]});
            }

            totalJuegos = totalJuegos + stock[i];
        }
        return totalJuegos;
    }
}