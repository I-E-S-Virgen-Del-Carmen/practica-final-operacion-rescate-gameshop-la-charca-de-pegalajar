package com.gameshop;

public class GestorInventario {

    public static final int stockMinimo = 5;
    public static final String mensajeAlerta = "¡ALERTA! Pedir más copias de ";

    public void revisarInventario(String[] nombreJuegos, int[] stock) {
        int totalJuegos = 0;

        // BUG LÓGICO: El '- 1' hace que el último elemento (Halo) se ignore por completo.
        totalJuegos = imprimirStockYAlertas(nombreJuegos, stock, totalJuegos);
        mostrarTotal(totalJuegos);
    }

    private static void mostrarTotal(int totalJuegos) {
        System.out.println("Total de juegos en el almacén: " + totalJuegos);
    }

    private static int imprimirStockYAlertas(String[] nombreJuegos, int[] stock, int totalJuegos) {
        for (int i = 0; i < nombreJuegos.length; i++) {
            System.out.println("Revisando stock de: " + nombreJuegos[i]);

            // CODE SMELL: Magic Number (5)
            if (stock[i] <= stockMinimo) {
                System.out.println(mensajeAlerta + nombreJuegos[i]);
            }

            totalJuegos = totalJuegos + stock[i];
        }
        return totalJuegos;
    }
}