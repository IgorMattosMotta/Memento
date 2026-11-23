package memento;

public class PacienteEstadoEmAtendimento implements PacienteEstado {

    private PacienteEstadoEmAtendimento() {};
    private static PacienteEstadoEmAtendimento instance = new PacienteEstadoEmAtendimento();
    public static PacienteEstadoEmAtendimento getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Em Atendimento";
    }

}
