package modelo;
import java.awt.Color;
import biblioteca.LE;


public class PrgPaciente {

    Pacientes arregloDePacientes[]; // creamos el arreglo que contendra los pacientes
    int numPac;



    public static void main(String arg[]) {
        PrgPaciente x = new PrgPaciente(); // creamos un paciente
        x.menu();// invocamos el metodo menu
    }


    public PrgPaciente() {
        numPac = 0;
        arregloDePacientes = new Pacientes[5]; // inicializamos el arreglo ya creado
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
        String opciones = opciones1;
        do {
            opc = LE.leerInt(opciones);
            switch (opc) {
                case 1:
                    ingresarDatos();
                    acceso = true; // se activa el acceso al menu
                    opciones = opciones2;
                    break;
                case 2:
                    if (acceso) {
                        mostrarDatos();
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
                        if (numPac== 0) {
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
        int rpta;
        long idPaciente;
        String apellido;
        String nombre;
        int  dni;
        String medico;
        String enfermedad;
        String fecha;
        int  pos;

        do {

            if (arregloDePacientes.length == numPac) {
                aumentar();
            }

            do {
                idPaciente = LE.leerLong("Ingrese el código del paciente");
                pos = buscarCodigo(idPaciente);
                if (pos != -1) {
                    LE.mostrarInformacion("El código ingresado ya existe!.., verifique\n\n");
                }
            } while (pos != -1);


            apellido = LE.leerString("Ingrese el apellido");
            nombre = LE.leerString("Ingrese el nombre");
            dni = LE.leerInt("Ingrese el DNI del paciente");
            medico= LE.leerString("Ingrese el medico asignado");
            enfermedad = LE.leerString("Ingrese la enfermedad");
            fecha = LE.leerString("Ingrese la fecha");

            // insertando pacientes en el arreglo pacient mediante el constructor con parametros

            Pacientes objPac = new Pacientes(dni, apellido, nombre,idPaciente,medico,enfermedad,fecha);
            arregloDePacientes[numPac] = objPac;
            numPac++;
            rpta = LE.mostrarPreguntaOpcion2("Desea continuar? ");
        } while (rpta == 0);
    }

    public int buscarCodigo(long codigo) {
        for (int i = 0; i < numPac; i++) {
            if (codigo == arregloDePacientes[i].getIdPaciente()) {
                return i;
            }
        }
        return -1;
    }

    public void aumentar() {
        Pacientes datosTmp[] = new Pacientes[arregloDePacientes.length + 3];// aumentando de tamaño el arreglo en 3
        for (int i = 0; i < numPac; i++) {
            datosTmp[i] = arregloDePacientes[i];
        }
        arregloDePacientes = datosTmp;
    }

    public void mostrarDatos(){
        String listaDatos = "";
        for (int i = 0; i < numPac; i++) {
            listaDatos += arregloDePacientes[i].getIdPaciente() + " " + arregloDePacientes[i].getApellido()
                    + " " + arregloDePacientes[i].getNombre() + " " + arregloDePacientes[i].getDni() +
            " " + arregloDePacientes[i].getMedico() + " " + arregloDePacientes[i].getEnfermedad()
            + arregloDePacientes[i].getFecha() +"\n";
        }
        LE.mostrarInformacion("Datos de los Paciente",
                "idPaciente - Apellido - Nombre- DNI- Medico - Enfermedad - Fecha", listaDatos, " - Aceptar - ", Color.cyan);
    }


    public void mostrarDatosPaciente() {
        long codigo = LE
                .leerLong("Ingrese el código del Paciente cuyos datos deseas mostrar");
        int pos = buscarCodigo(codigo);
        if (pos > -1) {
            LE.mostrarInformacion(

            "\nNroHist.Clinica: " + arregloDePacientes[pos].getIdPaciente( ) + "\nNombre: "
                    + arregloDePacientes[pos].getNombre( ) + "\nApellido: " + arregloDePacientes[pos].getApellido( )+ "\nDNI: "
                    + arregloDePacientes[pos].getDni( ) + "\nMedico: "  + arregloDePacientes[pos].getMedico( ) + "\nEnfermedad: "
                    + arregloDePacientes[pos].getEnfermedad( )+ "\nFecha: "+ arregloDePacientes[pos].getFecha( )) ;
        } else {
            LE.mostrarInformacion("El código del paciente no existe");
        }
    }



    public void modificarDatos() {
        long nroHistoriaCLinica = LE.leerLong("Ingrese historia clinica del paciente cuyos datos deseas  modificar");

        int pos = buscarCodigo(nroHistoriaCLinica);
        if (pos > -1) {
            int rpta = LE.mostrarPreguntaOpcion2("Está usted seguro que desea modificar "
                    + "los datos del siguiente paciente?\n"
                    + "\nNroHist.Clinica: " + arregloDePacientes[pos].getIdPaciente( ) + "\nNombre: "
                    + arregloDePacientes[pos].getNombre( ) + "\nApellido: " + arregloDePacientes[pos].getApellido( )+ "\nDNI: "
                    + arregloDePacientes[pos].getDni( ) + "\nMedico: "  + arregloDePacientes[pos].getMedico( ) + "\nEnfermedad: "
                    + arregloDePacientes[pos].getEnfermedad( )+ "\nFecha: "+ arregloDePacientes[pos].getFecha( )) ;


            if (rpta == 0) {
                String apellido = LE.leerString("Ingrese el apellido del paciente");
                String nombre = LE.leerString("Ingrese el nombre del paciente");
                int dni = LE.leerInt("Ingrese el DNI del paciente");
                String medico = LE.leerString("Ingrese el nombre del medico");
                String enfermedad = LE.leerString("Ingrese la enfermedad");
                String fecha = LE.leerString("Ingrese la fecha para su atencion");

                arregloDePacientes[pos].setApellido(apellido);
                arregloDePacientes[pos].setNombre(nombre);
                arregloDePacientes[pos].setDni(dni);
                arregloDePacientes[pos].setMedico(medico);
                arregloDePacientes[pos].setEnfermedad(enfermedad);
                arregloDePacientes[pos].setFecha(fecha);

            }
        } else {
            LE.mostrarInformacion("La historia clnica del paciente no existe");
        }
    }



    public void eliminarDatos(){

        long nroHistoriaCLinica = LE.leerLong("Ingrese el nro historia clinica del paciente cuyos datos deseas eliminar");

        int pos = buscarCodigo(nroHistoriaCLinica);
        if (pos > -1) {
            int rpta = LE.mostrarPreguntaOpcion2("Está usted seguro que desea eliminar "
                    + "los datos del siguiente Paciente?\n"
                    + "\nNroHist.Clinica: " + arregloDePacientes[pos].getIdPaciente( ) + "\nNombre: "
                    + arregloDePacientes[pos].getNombre( ) + "\nApellido: " + arregloDePacientes[pos].getApellido( )+ "\nDNI: "
                    + arregloDePacientes[pos].getDni( ) + "\nMedico: "  + arregloDePacientes[pos].getMedico( ) + "\nEnfermedad: "
                    + arregloDePacientes[pos].getEnfermedad( )+ "\nFecha: "+ arregloDePacientes[pos].getFecha( )) ;

            if (rpta == 0) {
                for (int i = pos; i < numPac - 1; i++) {
                    arregloDePacientes[i] = arregloDePacientes[i + 1];
                }
                numPac--;
            }

        } else {
            LE.mostrarInformacion("La historia clinica del paciente no existe");
        }
    }

    public void ordenarDatos() {
        for (int i = 0; i < numPac - 1; i++) {
            for (int j = i + 1; j < numPac; j++) {
                if (arregloDePacientes[i].getIdPaciente() > arregloDePacientes[j].getIdPaciente()) {
                    Pacientes tmp = arregloDePacientes[i]; // crea temporal
                    arregloDePacientes[i] = arregloDePacientes[j]; // posicion anterior toma la posicion siguiente
                    arregloDePacientes[j] = tmp; // posicion siguiente toma la posicion anterior guardad en el temporal
                }
            }
        }
    }

}
