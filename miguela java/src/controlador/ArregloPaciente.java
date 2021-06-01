package controlador;

import modelo.Pacientes;

public class ArregloPaciente {
    Pacientes arregloDePacientes[]; // creamos el arreglo que contendra los pacientes
    int numPac;

    //constructor sin parametro, inicializa las variables
    public ArregloPaciente() {
        numPac = 0;
        arregloDePacientes = new Pacientes[5]; // inicializamos el arreglo ya creado con 5 elementos para empezar
    }
    // constructor con parametros
    public int agregarDatos(long idpaciente, String apelldio, String nombre, int dni, String medico,
                            String enfemedad, String fecha) {
        // verifica si el id paciente esta ya creado si no esta entonces procede a agregarlo
        int pos = buscarCodigo(idpaciente);//
        if (pos != -1) { // si no lo encuentro que retorne -1
            return -1;
        } else {
            if (numPac == arregloDePacientes.length) {
                aumentar(); // si llega al limite de tamaño del arrelgo entonces que ejecute metodo aumentar el arreglo
            }
            Pacientes objPac = new Pacientes(dni, apelldio, nombre,idpaciente,medico,enfemedad,fecha);// creas el objeto con el contructor
            arregloDePacientes[numPac] = objPac;// llenamos el objeto en el arreglo en la posicio indicada.
            numPac++;// aumenta el numero de pacientes en una unidad
            return 0;
        }
    }

    public String obtenerDatos ( ) {
        String listaDatos = "" ;// acumulador de cadenas para mostrar el mensaje
        for ( int i = 0 ; i < numPac ; i++ ) {
            // obtiene los mensajes mediante los metodos get
            listaDatos = listaDatos + arregloDePacientes[i].getIdPaciente( ) + "     "
                    + arregloDePacientes[i].getApellido( ) + "    " + arregloDePacientes[i].getNombre( ) + "       "
                    + arregloDePacientes[i].getDni( ) + "     " + arregloDePacientes[i].getMedico( ) + "       "
                    + arregloDePacientes[i].getEnfermedad( ) + "       " + arregloDePacientes[i].getFecha( ) + "\n" ;

        }
        return listaDatos ;
    }


// obtener los datos de un paciente en particular mediante su idpaciente
    public String obtenerDatosPaciente(long idpaciente ) {
        String listaDatos = "" ;
        for ( int i = 0 ; i < numPac ; i++ ) { // recorriendo el arreglo y encontrando la coincidencia y extrayendo datos
            if ( idpaciente == arregloDePacientes[i].getIdPaciente( ) ) {
                listaDatos = "\nNroHist.Clinica: " + arregloDePacientes[i].getIdPaciente( ) + "\nNombre: "
                        + arregloDePacientes[i].getNombre( ) + "\nApellido: " + arregloDePacientes[i].getApellido( )+ "\nDNI: "
                        + arregloDePacientes[i].getDni( ) + "\nMedico: "  + arregloDePacientes[i].getMedico( ) + "\nEnfermedad: "
                        + arregloDePacientes[i].getEnfermedad( )+ "\nFecha: "+ arregloDePacientes[i].getFecha( ) ;

            }
        }
        return listaDatos ;
    }

// resetea los atributos
    public void modificarDatos(int pos, String apellido, String nombre, int dni,  String medico, String enfemedad, String fecha) {
        arregloDePacientes[pos].setApellido(apellido);
        arregloDePacientes[pos].setNombre(nombre);
        arregloDePacientes[pos].setDni(dni);
        arregloDePacientes[pos].setMedico(medico);
        arregloDePacientes[pos].setEnfermedad(enfemedad);
        arregloDePacientes[pos].setFecha(fecha);


    }
    // si la posicion existe asigna el valor de la posicion siguiente en la posicion que desea eliminar y al final reduce el tamaño del arreglo
    public void eliminarDatos(int posicion) {
        if (posicion > -1) {
            for (int i = posicion; i < numPac - 1; i++) {
                arregloDePacientes[i] = arregloDePacientes[i + 1];
            }
            numPac--;
        }
    }
// ordenamiento segun el id que en un long, se crea objetos pacientes temporales para el intercambion de posicion
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


    public int buscarCodigo(long idpaciente) {
        for (int i = 0; i < numPac; i++) {
            if (idpaciente == arregloDePacientes[i].getIdPaciente()) {
                return i; // retornanado la posicion del valor encontrodo
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
    public int getNumPac() {
        return numPac;
    }
}



