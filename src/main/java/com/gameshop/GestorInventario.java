package com.gameshop;

public class GestorInventario {

    public void p(String[] n, int[] c) {
        int t = 0;

        // BUG LÓGICO: El '- 1' hace que el último elemento (Halo) se ignore por completo.
        for (int i = 0; i < n.length; i++) {
            System.out.println("Revisando stock de: " + n[i]);

            // CODE SMELL: Magic Number (5)
            if (c[i] <= 5) {
                System.out.println("¡ALERTA! Pedir más copias de " + n[i]);
            }

            t = t + c[i];
        }
        System.out.println("Total de juegos en el almacén: " + t);
    }
}