package modelo;

public class Pacientes extends Persona  {

    // atributos
    private long idPaciente;
    private String medico;
    private String enfermedad;
    private String fecha;



    public Pacientes(int dni, String nombre, String apellido, long idPaciente, String medico, String enfermedad, String fecha) {
        super(dni, nombre, apellido);
        this.idPaciente = idPaciente;
        this.medico = medico;
        this.enfermedad = enfermedad;
        this.fecha = fecha;
    }

    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


}
