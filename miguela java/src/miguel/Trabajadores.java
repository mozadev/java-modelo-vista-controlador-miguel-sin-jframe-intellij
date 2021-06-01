package miguel;

import biblioteca.LE;

import java.awt.*;

public class Trabajadores {
    int numCol;
    long codigos[];
    String nombres[];
    double datos[][];
    double sueldo[];


    public Trabajadores() {
        numCol = 3;
        codigos = new long[10000];
        nombres = new String[10000];
        sueldo = new double[numCol];
        datos = new double[numCol][numCol];
    }

    public void ingresar() {
        int rpta;

        for (int i = 0; i < numCol; i++) {
            codigos[i] = LE.leerLong("Ingresa el codigo del trabajador[" + (i + 1) + "]");
            nombres[i] = LE.leerString("ingrese el nombre del trabajador [" + (i + 1) + "]");
        }

        for (int i = 0; i < numCol; i++) {

            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    datos[i][j] = LE.leerDouble("ingrese tarifa  " + "del trabajador( " + (nombres[1] + 1) + ")");
                }
                if (j == 1) {
                    datos[i][j] = LE.leerDouble("ingrese horas trabajadas  " + "del trabajador(" + (nombres[i] + 1) + ")");
                }

            }
        }

    }

    public void mostrar() {
        String datos = "";
        for (int i = 0; i < numCol; i++) {
            datos = datos + codigos[i] + "\t" + nombres[i] + "\n";
        }

        LE.mostrarInformacion("info", "Codigo - Nombre ", datos, "ok", Color.cyan);
    }

    public void calcularSueldo() {

        double sueldox = 0;

        for (int i = 0; i < numCol; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0)
                    sueldox = datos[i][j];
                if (j == 1)
                    sueldox = sueldox * datos[i][j];
            }

            sueldo[i] = sueldox;
        }
    }

    public void mostrarSueldo() {
        String datos = "";
        for (int i = 0; i < numCol; i++) {
            datos = datos + codigos[i] + "\t" + nombres[i] + "\t" + sueldo[i] + "\n";
        }
        LE.mostrarInformacion("info", "Codigo - Nombre - sueldo", datos, "ok", Color.cyan);
    }


    public void ordenarNombres() {
        long auxcodigo;
        String auxNombre;
        double auxSueldo;

        for (int i = 0; i < numCol - 1; i++) {
            for (int j = i + 1; j < numCol; j++) {
                if (nombres[i].compareToIgnoreCase(nombres[j]) > 0) {
                    auxcodigo = codigos[j];
                    codigos[j] = codigos[i];
                    codigos[i] = auxcodigo;

                    auxNombre = nombres[j];
                    nombres[j] = nombres[i];
                    nombres[i] = auxNombre;

                    auxSueldo = sueldo[j];
                    sueldo[j] = sueldo[i];
                    sueldo[i] = auxSueldo;
                }
            }
        }
    }


    public void buscar(long code) {
        String datos = "";
        int posicion = 0;
        for (int i = 0; i < numCol; i++) {
            if (code == codigos[i]) {
                datos = datos + "- " + nombres[i] + "\n";
                posicion = i;
                // contador
            }
        }
        LE.mostrarInformacion("trabajador con codigo " + codigos[posicion], "Nombres", datos, +sueldo[posicion] + "ok", Color.yellow);
    }

    void menu() {
        int opc;
        long codigos = 0;
        double p = 0, n;
        String texto = "1. Ingresar \n2. Mostrar\n3.calcular y mostrar sueldo\n4.ordenar nombres  \n5. mostrar datos de un trabajador \n6. finalizar";
        do {
            opc = LE.leerInt(texto);

            switch (opc) {
                case 1:
                    ingresar();
                    break;
                case 2:

                    mostrar();
                    break;
                case 3:
                    calcularSueldo();
                    mostrarSueldo();
                    break;
                case 4:
                    ordenarNombres();
                case 5:
                    buscar(2);

                    break;
                case 9:
                    break;
                default:

            }

        } while (opc != 9);
    }


}
