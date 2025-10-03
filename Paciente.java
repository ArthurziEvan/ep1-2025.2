package SistemaClinicoJava;

public class Paciente {
    private String nome;
    private String cpf;
    private int idade;
    private String telefone;

    public Paciente(String nome, String cpf, int idade, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public int getIdade() { return idade; }
    public String getTelefone() { return telefone; }

    public double calcularDescontoConsulta(double valorBase) {
        return valorBase;
    }

    public double calcularDescontoInternacao(double valorBase) {
        return valorBase;
    }

    @Override
    public String toString() {
        return nome + " (CPF: " + cpf + ")";
    }
}