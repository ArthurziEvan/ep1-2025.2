package SistemaClinicoJava;

import java.util.List;

public class Relatorio {

    public static void gerarRelatorios(List<Paciente> pacientes, List<Medico> medicos,
                                       List<Consulta> consultas, List<Internacao> internacoes) {
        System.out.println("\n=== RELATÓRIOS ===");

        System.out.println("\nPacientes:");
        pacientes.forEach(p -> System.out.println("- " + p));

        System.out.println("\nMédicos:");
        medicos.forEach(m -> System.out.println("- " + m));

        System.out.println("\nConsultas:");
        consultas.forEach(c -> System.out.println("- " + c));

        System.out.println("\nInternações:");
        internacoes.forEach(i -> System.out.println("- " + i));
    }
}
