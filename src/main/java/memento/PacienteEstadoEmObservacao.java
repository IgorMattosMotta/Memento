package memento;

public class PacienteEstadoEmObservacao implements PacienteEstado {

    private PacienteEstadoEmObservacao() {};
    private static PacienteEstadoEmObservacao instance = new PacienteEstadoEmObservacao();
    public static PacienteEstadoEmObservacao getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Em Observação";
    }

}
