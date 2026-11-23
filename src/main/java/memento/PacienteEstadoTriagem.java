package memento;

public class PacienteEstadoTriagem implements PacienteEstado {

    private PacienteEstadoTriagem() {};
    private static PacienteEstadoTriagem instance = new PacienteEstadoTriagem();
    public static PacienteEstadoTriagem getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Triagem";
    }

}
