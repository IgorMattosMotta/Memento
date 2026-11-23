package memento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    void deveArmazenarEstados() {
        Paciente paciente = new Paciente();
        paciente.setEstado(PacienteEstadoTriagem.getInstance());
        paciente.setEstado(PacienteEstadoEmAtendimento.getInstance());
        assertEquals(2, paciente.getEstados().size());
    }

    @Test
    void deveRetornarEstadoInicial() {
        Paciente paciente = new Paciente();
        paciente.setEstado(PacienteEstadoTriagem.getInstance());
        paciente.setEstado(PacienteEstadoEmAtendimento.getInstance());
        paciente.restauraEstado(0);
        assertEquals(PacienteEstadoTriagem.getInstance(), paciente.getEstado());
    }

    @Test
    void deveRetornarEstadoAnterior() {
        Paciente paciente = new Paciente();
        paciente.setEstado(PacienteEstadoTriagem.getInstance());
        paciente.setEstado(PacienteEstadoEmAtendimento.getInstance());
        paciente.setEstado(PacienteEstadoInternado.getInstance());
        paciente.setEstado(PacienteEstadoEmUTI.getInstance());
        paciente.setEstado(PacienteEstadoInternado.getInstance());
        paciente.setEstado(PacienteEstadoAlta.getInstance());
        paciente.restauraEstado(3);
        assertEquals(PacienteEstadoEmUTI.getInstance(), paciente.getEstado());
    }

    @Test
    void deveManterHistoricoAoRestaurarEstado() {
        Paciente paciente = new Paciente();
        paciente.setEstado(PacienteEstadoTriagem.getInstance());
        paciente.setEstado(PacienteEstadoEmObservacao.getInstance());
        paciente.setEstado(PacienteEstadoAlta.getInstance());
        paciente.restauraEstado(1);
        assertEquals(3, paciente.getEstados().size());
        assertEquals("Em Observação", paciente.getEstado().getNomeEstado());
    }

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            Paciente paciente = new Paciente();
            paciente.restauraEstado(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoIndiceNegativo() {
        Paciente paciente = new Paciente();
        paciente.setEstado(PacienteEstadoTriagem.getInstance());
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> paciente.restauraEstado(-1));
        assertEquals("Índice inválido", e.getMessage());
    }

}
