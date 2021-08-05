package main;

public class Main {
    public static void main(String[] args) {

        SIMCard sim = new SIMCard("3105658053");

        sim.recargarSaldo(50000);
        sim.comprarDatos(12);
        sim.gestionarEncendidoCelular();
        sim.llamar(120);
        sim.gestionarModoAvion();
        sim.gestionarDatos();
        sim.gestionarModoAvion();
        sim.gestionarDatos();
        sim.consumirDatos(3);
        sim.gestionarEncendidoCelular();
        System.out.println(sim);
    }
}
