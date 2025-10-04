
import java.util.ArrayList;
import java.util.List; 

public class Agenda {
    
    private String data;
    private List<Paciente> pacientes;
    private Medico medico; 

    public Agenda(Medico medico) { 
        pacientes = new ArrayList<>();
        this.data = "";
        this.medico = medico; 
    }

    public void adicionar(Paciente p) { 
        pacientes.add(p);
    }
    public void remover(String cpf) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getCpf().equals(cpf)) {
                System.out.println(pacientes.get(i).getNome() + " foi removido com sucesso da agenda");
                pacientes.remove(i);
                return;
            }
        }
        System.out.println("Paciente com CPF " + cpf + " não encontrado na agenda");   
    }

    public void pesquisar(String cpf) {
        for (Paciente p : pacientes) { 
            if (p.getCpf().equals(cpf)) {
                System.out.println("--- Paciente Encontrado ---");
                System.out.println("Nome: " + p.getNome());
                System.out.println("Telefone: " + p.getTelefone());
                System.out.println("Idade: " + p.getIdade());
                return;
            }
        }
        System.out.println("Paciente não encontrado");
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }


    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public Medico getMedico() { 
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}