package vista;

import java.awt.Color;
import biblioteca.LE;
import controlador.ArregloPaciente;

public class PrgPaciente {

    ArregloPaciente objArray;
    //constructor sin parametros inicializa el arreglo paciente
    public PrgPaciente() {
        objArray = new ArregloPaciente();// atributo de clase de tipo arreglo
    }
    //clase principal que ejecuta el programa
    public static void main(String arg[]) {
        PrgPaciente x = new PrgPaciente(); // creamos un paciente
        x.menu();// invocamos el metodo menu
    }
    public void menu() {
        int opc;

        String opciones1 = "************MENU PRINCIPAL ************\n"
                + "-------------------------------------\n"
                + "[1] Ingreso de Datos \n" + "[0] Finalizar \n"
                + "-------------------------------------\n"
                + "Elija opción deseada:\n";
        String opciones2 = "************MENU PRINCIPAL ************\n"
                + "-------------------------------------\n"
                + "[1] Ingreso de datos \n" + "[2] Mostrar datos \n"
                + "[3] Mostrar datos de un Paciente \n"
                + "[4] Modificar datos \n" + "[5] Eliminar datos \n"
                + "[6] Ordenar datos \n" + "[0] Finalizar \n"
                + "-------------------------------------\n"
                + "Elija opción deseada:\n";
        boolean acceso = false;
        // opciones toma primero la cadena opciones1 para mostra el primer menu
        String opciones = opciones1;
        do {// vuelve a ingresar al do con la opciones=opciones2, con el otro menu que tiene mas opciones
            opc = LE.leerInt(opciones);
            switch (opc) {
                case 1: // acceso a datos
                    ingresarDatos();// ejecuta metodo para ingresasr los datos del paciente
                    acceso = true; // si se elige ingreso de datos, se activa el acceso
                    opciones = opciones2;// cambia de valor cadena a opciones2 para q se ejecute el segundo menu principal
                    break;// sale del switch
                case 2:
                    if (acceso) { // el acceso ya esta activado
                        mostrarDatos(); // ejecuta el metod mostrar daos
                    } else {
                        LE.mostrarError("La opción ingresada no es válida");
                    }
                    break;

                case 3:
                    if (acceso) {
                        mostrarDatosPaciente();
                    } else {
                        LE.mostrarError("La opción ingresada no es válida");
                    }
                    break;
                case 4:
                    if (acceso) {
                        modificarDatos();
                    } else {
                        LE.mostrarError("La opción ingresada no es válida");
                    }
                    break;
                case 5:

                    if (acceso) {
                        eliminarDatos();
                        if (objArray.getNumPac() == 0) {
                            acceso = false;
                            opciones = opciones1;
                        }
                    } else {
                        LE.mostrarError("La opción ingresada no es válida");
                    }
                    break;
                case 6:
                    if (acceso) {
                        ordenarDatos();
                        mostrarDatos();
                    } else {
                        LE.mostrarError("La opción ingresada no es válida");
                    }
                    break;
                case 0:
                    break;
                default:
                    LE.mostrarError("La opción ingresada no es válida");
            }
        } while (opc != 0);
    }

    public void ingresarDatos() {
        // delclaramos las variables
        int rpta;
        long idPaciente;
        String apellido;
        String nombre;
        int  dni;
        String medico;
        String enfermedad;
        String fecha;

        // asignamos los valores de las variables mediante el ingreso de datos
        do {
            idPaciente = LE.leerLong("Ingrese el numero de historia clinica");
            apellido = LE.leerString("Ingrese el apellido");
            nombre = LE.leerString("Ingrese el nombre");
            dni = LE.leerInt("Ingrese el DNI del paciente");
            medico= LE.leerString("Ingrese el medico asignado");
            enfermedad = LE.leerString("Ingrese la enfermedad");
            fecha = LE.leerString("Ingrese la fecha");

            // insertando pacientes en el arreglo pacient mediante el constructor con parametros
            objArray.agregarDatos(idPaciente, apellido, nombre,dni,medico,enfermedad, fecha);
            rpta = LE.mostrarPreguntaOpcion2("Desea continuar? ");//muestra mensaje si desea continuar
        } while (rpta == 0); // 0 significa que si desea continuar
    }

    public void mostrarDatos(){
        String listaDatos = objArray.obtenerDatos();// obtiene los datos de todos los pacientes
        if (listaDatos != "") { // compara si las lista esta vacia ,si no esta vacio entonces que muestre informacion
            LE.mostrarInformacion("Datos del paciente","nroHist     Apellido     " +
                    "Nombre     DNI      Medico      Enfermedad      Fecha ",listaDatos, "Ok", Color.cyan);

        } else {
            LE.mostrarInformacion("No existen datos registrados");// sino hay datos muestra el mensaje
        }
    }


    public void mostrarDatosPaciente() {
        long codigo = LE.leerLong("Ingrese el nro historia clinica  cuyos datos deseas mostrar");

        String listaDatos = objArray.obtenerDatosPaciente(codigo);
        if (listaDatos != "") {
            LE.mostrarInformacion("Datos del paciente\n" + listaDatos);
        } else {
            LE.mostrarInformacion("Código de paciente no existe");
        }
    }


    public void modificarDatos() {
        long nroHistoriaCLinica = LE.leerLong("Ingrese historia clinica del paciente cuyos datos deseas  modificar");

        int pos = objArray.buscarCodigo(nroHistoriaCLinica);
        if (pos > -1) {
            int rpta = LE.mostrarPreguntaOpcion2("Está usted seguro que desea modificar "
                    + "los datos del siguiente paciente?\n"
                    + objArray.obtenerDatosPaciente(nroHistoriaCLinica));
            if (rpta == 0) {
                String apellido = LE.leerString("Ingrese el apellido del paciente");
                String nombre = LE.leerString("Ingrese el nombre del paciente");
                int dni = LE.leerInt("Ingrese el DNI del paciente");
                String medico = LE.leerString("Ingrese el nombre del medico");
                String enfermedad = LE.leerString("Ingrese la enfermedad");
                String fecha = LE.leerString("Ingrese la fecha para su atencion");

                //MODIFICANDO atributos del paciente mediante metodos que reciben parametros
                objArray.modificarDatos(pos, apellido,nombre,dni,medico,enfermedad,fecha );
            }
        } else {
            LE.mostrarInformacion("La historia clnica del paciente no existe");
        }
    }



    public void eliminarDatos(){


        long nroHistoriaCLinica = LE.leerLong("Ingrese el nro historia clinica del paciente cuyos datos deseas eliminar");

        int pos = objArray.buscarCodigo(nroHistoriaCLinica);
        if (pos > -1) {
            int rpta = LE.mostrarPreguntaOpcion2("Está usted seguro que desea eliminar "
                    + "los datos del siguiente Paciente?\n"
                    + objArray.obtenerDatosPaciente(nroHistoriaCLinica));
            if (rpta == 0) {
                objArray.eliminarDatos(pos);
            }

        } else {
            LE.mostrarInformacion("La historia clinica del paciente no existe");
        }
    }
    public void ordenarDatos() {
        objArray.ordenarDatos();
    }

}
