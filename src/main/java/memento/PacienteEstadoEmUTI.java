package memento;

public class PacienteEstadoEmUTI implements PacienteEstado {

    private PacienteEstadoEmUTI() {};
    private static PacienteEstadoEmUTI instance = new PacienteEstadoEmUTI();
    public static PacienteEstadoEmUTI getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Em UTI";
    }

}
