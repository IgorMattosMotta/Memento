package memento;

public class PacienteEstadoAlta implements PacienteEstado {

    private PacienteEstadoAlta() {};
    private static PacienteEstadoAlta instance = new PacienteEstadoAlta();
    public static PacienteEstadoAlta getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Alta";
    }

}
