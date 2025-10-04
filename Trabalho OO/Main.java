package src;
import java.util.*;
import java.io.File;

public class Main {

    static List<Paciente> pacientes = new ArrayList<>();
    static List<Consulta> consultas = new ArrayList<>();
    static List<Internacao> internacoes = new ArrayList<>();
    static List<Medico> medicos = new ArrayList<>();
    static List<PlanoSaude> planos = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new File("data").mkdirs();
        carregarDados();
        menuPrincipal();
        salvarDados();
    }

    static void menuPrincipal() {
        int op;
        do {
            System.out.println("\n=== SISTEMA CLÍNICO ===");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Cadastrar médico");
            System.out.println("3 - Cadastrar plano de Saúde");
            System.out.println("4 - Marcar consulta");
            System.out.println("5 - Registrar internação");
            System.out.println("6 - Relatórios");
            System.out.println("7 - Salvar e sair");
            System.out.print("Marque uma opção ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> cadastrarPaciente();
                case 2 -> cadastrarMedico();
                case 3 -> cadastrarPlano();
                case 4 -> marcarConsulta();
                case 5 -> registrarInternacao();
                case 6 -> Relatorio.gerarRelatorios(pacientes, medicos, consultas, internacoes);
                case 7 -> System.out.println("Salvando dados e saindo...");
                default -> System.out.println("Opção não existe");
            }

        } while (op != 7);
    }

    static void cadastrarPaciente() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Possui plano de saúde? (s/n): ");
        String resp = sc.nextLine().trim().toUpperCase();
        if (resp.equals("S")) {
            System.out.println("Selecione o plano:");
            for (int i = 0; i < planos.size(); i++) {
                System.out.println((i + 1) + " - " + planos.get(i).getNome());
            }
            int escolha = sc.nextInt();
            sc.nextLine();
            PlanoSaude plano = planos.get(escolha - 1);
            pacientes.add(new PacienteEspecial(nome, cpf, idade, telefone, plano));
        } else {
            pacientes.add(new Paciente(nome, cpf, idade, telefone));
        }
        System.out.println("Paciente cadastrado");
    }

    static void cadastrarMedico() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CRM/CNM: ");
        String crm = sc.nextLine();
        System.out.print("Especialidade: ");
        String esp = sc.nextLine();
        medicos.add(new Medico(nome, crm, esp));
        System.out.println("Médico cadastrado");
    }

    static void cadastrarPlano() {
        System.out.print("Nome do plano: ");
        String nome = sc.nextLine();
        System.out.print("Desconto consulta (%): ");
        double dCons = sc.nextDouble();
        System.out.print("Desconto internação (%): ");
        double dInt = sc.nextDouble();
        sc.nextLine();
        planos.add(new PlanoSaude(nome, dCons, dInt));
        System.out.println("Plano cadastrado");
    }

    static void marcarConsulta() {
        if (pacientes.isEmpty() || medicos.isEmpty()) {
            System.out.println("Cadastre pacientes e médicos");
            return;
        }
        System.out.print("CPF do paciente: ");
        String cpf = sc.nextLine();
        Paciente p = buscarPaciente(cpf);
        if (p == null) {
            System.out.println("Paciente não encontrado");
            return;
        }
        System.out.println("Médicos disponíveis:");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println((i + 1) + " - " + medicos.get(i).getNome() + " (" + medicos.get(i).getEspecialidade() + ")");
        }
        int escolha = sc.nextInt();
        sc.nextLine();
        Medico m = medicos.get(escolha - 1);
        System.out.print("Data (dia/mês/ano): ");
        String data = sc.nextLine();

        if (consultas.stream().anyMatch(c -> c.getMedico().equals(m) && c.getData().equals(data))) {
            System.out.println("Já existe uma consulta com esse médico nesta data");
            return;
        }
        System.out.println("\n=== TRIAGEM ===");
        System.out.print("Altura (cm): ");
        double altura = sc.nextDouble();
        System.out.print("Peso (kg): ");
        double peso = sc.nextDouble();
        sc.nextLine();
        System.out.print("Pressão arterial (ex: 120/80): ");
        String pressao = sc.nextLine();
        System.out.print("Batimentos (bpm): ");
        int batimentos = sc.nextInt();
        System.out.print("Temperatura (°C): ");
        double temperatura = sc.nextDouble();
        sc.nextLine();

        Triagem t = new Triagem(altura, peso, pressao, batimentos, temperatura);
        Consulta c = new Consulta(p, m, data, t);
        consultas.add(c);
        System.out.println("Consulta agendada com sucesso!");
    }

    static void registrarInternacao() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado");
            return;
        }
        System.out.print("CPF do paciente: ");
        String cpf = sc.nextLine();
        Paciente p = buscarPaciente(cpf);
        if (p == null) {
            System.out.println("Paciente não encontrado");
            return;
        }
        System.out.print("Quarto: ");
        int quarto = sc.nextInt();
        sc.nextLine();

        if (internacoes.stream().anyMatch(i -> i.isAtiva() && i.getQuarto() == quarto)) {
            System.out.println("Este quarto está ocupado");
            return;
        }

        System.out.println("Médicos disponíveis:");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println((i + 1) + " - " + medicos.get(i).getNome());
        }
        int escolha = sc.nextInt();
        sc.nextLine();
        Medico m = medicos.get(escolha - 1);

        System.out.print("Data de entrada: ");
        String data = sc.nextLine();
        System.out.print("Custo estimado: ");
        double custo = sc.nextDouble();
        sc.nextLine();

        Internacao i = new Internacao(p, m, data, quarto, custo);
        internacoes.add(i);
        System.out.println("Internação registrada");
    }

    static Paciente buscarPaciente(String cpf) {
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf)) return p;
        }
        return null;
    }

    static void carregarDados() {
        pacientes = Persistencia.lerPacientes("data/pacientes.txt");
        medicos = Persistencia.lerMedicos("data/medicos.txt");
        planos = Persistencia.lerPlanos("data/planos.txt");
    }

    static void salvarDados() {
        Persistencia.salvarPacientes("data/pacientes.txt", pacientes);
        Persistencia.salvarMedicos("data/medicos.txt", medicos);
        Persistencia.salvarPlanos("data/planos.txt", planos);
    }
}