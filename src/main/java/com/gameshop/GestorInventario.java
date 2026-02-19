package com.gameshop;
import java.util.logging.Logger;

/**
 * Clase encargada de gestionar el inventario de la tienda de videojuegos.
 * Revisa el stock disponible de cada juego, muestra alertas cuando el
 * stock es inferior al mínimo permitido y calcula el total de unidades
 * disponibles en el almacén.
 *
 * @author Sergio
 */
public class GestorInventario {

    private static final Logger LOGGER = Logger.getLogger(GestorInventario.class.getName());
    public static final int STOCK_MINIMO = 5;
    public static final String MENSAJE_ALERTA = "¡ALERTA! Pedir más copias de ";

    /**
     * Revisa el inventario de juegos mostrando el stock disponible
     * y generando alertas cuando el stock es igual o inferior
     * al mínimo establecido.
     *
     * @param nombreJuegos Array con los nombres de los videojuegos.
     * @param stock Array con las cantidades disponibles de cada videojuego.
     */
    public void revisarInventario(String[] nombreJuegos, int[] stock) {
        int totalJuegos = 0;

        // BUG LÓGICO: El '- 1' hace que el último elemento (Halo) se ignore por completo.
        totalJuegos = imprimirStockYAlertas(nombreJuegos, stock, totalJuegos);
        mostrarTotal(totalJuegos);
    }

    /**
     * Muestra en el log el total de unidades de juegos disponibles en el almacén.
     *
     * @param totalJuegos Total de unidades disponibles.
     */
    private static void mostrarTotal(int totalJuegos) {
        LOGGER.log(java.util.logging.Level.INFO, "Total de juegos en el almacén: {0}", totalJuegos);
    }

    /**
     * Recorre los juegos y sus stocks, muestra alertas y suma el total de unidades.
     *
     * @param nombreJuegos Array con los nombres de los videojuegos.
     * @param stock Array con la cantidad disponible de cada videojuego.
     * @param totalJuegos Total acumulado hasta el momento.
     * @return Total de unidades disponibles después de revisar todos los juegos.
     */
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