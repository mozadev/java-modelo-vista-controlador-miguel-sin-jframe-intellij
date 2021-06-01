package miguel;

public class PrgSalonA {
    public static void main(String arg[]) {

        Salon salon101 = new Salon();

        salon101.ingresarDatos();
        double p = salon101.calcularPromedio();
        salon101.mostrarDatos(p);
        salon101.ordenarNombres();
        salon101.mostrarDatos(p);
        salon101.buscarAlumnosNota(11);
    }
}