package com.gameshop;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Sistema GameShop...\n");

        GestorInventario inventario = new GestorInventario();
        ProcesadorVentas ventas = new ProcesadorVentas();
        SistemaRecompensasVip recompensas = new SistemaRecompensasVip();

        // --- PRUEBA ALUMNO 1: INVENTARIO ---
        System.out.println("--- 1. TEST DE INVENTARIO ---");
        String[] juegos = {"Cyberpunk", "Zelda", "Mario Kart", "Halo"};
        int[] stock = {10, 2, 15, 4};
        // BUG: El programa nunca avisará del stock bajo de 'Halo' ni lo sumará al total.
        inventario.revisarInventario(juegos, stock);

        // --- PRUEBA ALUMNO 2: VENTAS ---
        System.out.println("\n--- 2. TEST DE VENTAS ---");
        // Un juego de 100€ con descuento VIP debería costar menos de 100€ + IVA.
        // BUG: El cliente VIP acaba pagando MÁS que un cliente normal.
        double precioFinal = ventas.calcularPrecioFinal(100.0, true);
        System.out.println("Precio final cobrado al VIP: " + precioFinal + " EUR");

        // --- PRUEBA ALUMNO 3: RECOMPENSAS VIP ---
        System.out.println("\n--- 3. TEST DE RECOMPENSAS ---");
        System.out.println(recompensas.generarReporte(150));

        System.out.println("Comprobando cliente anónimo...");
        // BUG: Esto hará explotar el programa (NullPointerException)
        boolean esVip = recompensas.comprobarVip(null);
        System.out.println("¿Es VIP? " + esVip);
    }
}