package miguel;

import biblioteca.LE;

import java.awt.Color;

public class Salon {

    long codigos[];
    String nombres[];
    double notas[];
    int numAlu;

    public Salon() {
        numAlu = 0;
        codigos = new long[10000];
        nombres = new String[10000];
        notas = new double[10000];
    }

    public void ingresarDatos() {
        int rpta;
        do {
            codigos[numAlu] = LE.leerLong("Ingrese codigo");
            nombres[numAlu] = LE.leerString("Nombre");
            notas[numAlu] = LE.leerDouble("Nota");
            numAlu++;

            rpta = LE.mostrarPreguntaOpcion2("Deseas continuar?");
        } while (rpta == 0);

    }

    public double calcularPromedio() {
        double suma = 0, prom;

        for (int i = 0; i < numAlu; i++) {
            suma = suma + notas[i];
        }
        prom = suma / numAlu;
        return prom;
    }

    public void mostrarDatos(double prom) {
        String datos = "";
        for (int i = 0; i < numAlu; i++) {
            datos = datos + codigos[i] + "\t" + nombres[i] + "\t" + notas[i] + "\n";
        }
        datos = datos + "\nElpromedio general es: " + prom;
        LE.mostrarInformacion("Salón", "Codigo - Nombre - Nota", datos, "ok", Color.cyan);
    }

    public void ordenarNombres() {
        long codi;
        String nom;
        double nota;
        for (int i = 0; i < numAlu - 1; i++) {
            for (int j = i+1; j < numAlu; j++) {
                if (nombres[i].compareToIgnoreCase(nombres[j]) > 0) {
                    codi       = codigos[j];
                    codigos[j] = codigos[i];
                    codigos[i] = codi;

                    nom        = nombres[j];
                    nombres[j] = nombres[i];
                    nombres[i] = nom;

                    nota       = notas[j];
                    notas[j]   = notas[i];
                    notas[i]   = nota;
                }
            }
        }
    }

    void menu() {
        int opc;
        double p = 0, n;
        String texto = "1. Ingresar \n2. Mostrar\n3.Mostrar alumnos\n4.Mejores alumnos  \n9. Finalizar";
        do {
            opc = LE.leerInt(texto);

            switch (opc) {
                case 1:
                    ingresarDatos();
                    break;
                case 2:
                    p = calcularPromedio();
                    ordenarNombres();
                    mostrarDatos(p);
                    break;
                case 3:
                    n = ingresarNota();
                    buscarAlumnosNota(n);
                    break;
                case 4:
                    n = buscarMayor();
                    buscarAlumnosNota(n);
                    break;

                case 9:
                    break;
                default:

            }

        } while (opc != 9);
    }

    public double ingresarNota() {
        //double nota = LE.leerDouble("Ingresa nota a buscar: ");
        //return nota;

        return LE.leerDouble("Ingresa nota a buscar: ");
    }

    public double buscarMayor(){
        double mayor=0;
        for (int i = 0; i < numAlu; i++) {
            if (mayor < notas[i] ){
                mayor = notas[i];
            }
        }
        return mayor;
    }

    public void buscarAlumnosNota(double nota) {
        String datos="";
        for (int i = 0; i < numAlu; i++) {
            if (nota == notas[i]) {
                datos = datos + "- " + nombres[i] + "\n";
                // contador
            }
        }
        LE.mostrarInformacion("Alumnos con nota " + nota, "Nombres", datos, "ok", Color.yellow);
    }

/*    public void buscarMostrarAlumno () {
        double nota = LE.leerDouble("Ingresa nota a buscar: ");
        String datos="";
        for (int i = 0; i < numAlu; i++) {
            if (nota == notas[i]) {
                datos = datos + "- " + nombres[i] + "\n";
                // contador
            }
        }
        LE.mostrarInformacion("Alumnos con nota " + nota, "Nombres", datos, "ok", Color.yellow);
    }
  */
}