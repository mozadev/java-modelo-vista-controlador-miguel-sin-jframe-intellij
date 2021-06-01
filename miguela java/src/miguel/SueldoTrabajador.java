package miguel;

import biblioteca.LE;

public class SueldoTrabajador {

    double tarifaHoras, sueldoBasico, sueldoBruto;
    double sueldoNeto;
    int numeroHoras;

    public static void main(String args[]) {
        int opc;
        SueldoTrabajador objx = new SueldoTrabajador();// creacion del objeto

        String texto = "------- Menu de opciones calculo Sueldo --------\n"
                + "[1] Ingresar horas trab. y tarifa\n"
                + "[2] Mostrar sueldos\n"
                + "[9] Finalizar\n"
                + "--------------------------------------\n"
                + "Ingrese la opción\n";

        do {
            opc = LE.leerInt(texto);

            switch (opc) {
                case 1:
                    // Ingresar datos
                    do {
                        objx.ingresarDatos();// invocacion del metodo ingresar datos recibe parametro contador
                        if(objx.numeroHoras < 0 || objx.tarifaHoras < 0)
                            LE.mostrarInformacion("ingresar cantidades >=0");

                    } while (objx.numeroHoras < 0 || objx.tarifaHoras < 0);// si es que numeros de horas y tarifa son negativos

                    break;
                case 2:
                    // Mostrar datos
                    objx.calculaSuedoBasico();
                    objx.calculaSueldoBruto();
                    objx.calculaSueldoNeto();
                    objx.mostrarDatos();
                    break;

                case 9:
                    break;
                default:
                    LE.mostrarAdvertencia("Opcion no valida...reintente");
            }

        } while (opc != 9);
    }

    // Metodo constructor
    SueldoTrabajador() {
        sueldoBasico = 0; // inicializacion de variables
        sueldoBruto = 0;
        sueldoNeto = 0;
    }

    // Metodos de instancia
    void ingresarDatos() {
        numeroHoras = LE.leerInt("Ingresa cantidad de horas: ");
        tarifaHoras = LE.leerDouble("Ingresa la tarifa por hora: ");
    }

    void calculaSuedoBasico() {
        sueldoBasico = tarifaHoras * numeroHoras;
    }

    void calculaSueldoBruto() {
        double bonificacion = sueldoBasico * 0.35;
        sueldoBruto = sueldoBasico + bonificacion;
    }

    void calculaSueldoNeto() {
        double descuento = sueldoBasico * 0.12;
        sueldoNeto = sueldoBasico - descuento;
    }

    void mostrarDatos() {
        LE.mostrarInformacion("sueldo basico : " + sueldoBasico);
        LE.mostrarInformacion("sueldo bruto : " + sueldoBruto);
        LE.mostrarInformacion("sueldo neto: " + sueldoNeto);
    }
}
