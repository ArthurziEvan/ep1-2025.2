package SistemaClinicoJava;

public class PacienteEspecial extends Paciente {
    private PlanoSaude plano;

    public PacienteEspecial(String nome, String cpf, int idade, String telefone, PlanoSaude plano) {
        super(nome, cpf, idade, telefone);
        this.plano = plano;
    }

    @Override
    public double calcularDescontoConsulta(double valorBase) {
        return valorBase * (1 - plano.getDescontoConsulta() / 100);
    }

    @Override
    public double calcularDescontoInternacao(double valorBase) {
        return valorBase * (1 - plano.getDescontoInternacao() / 100);
    }

    public PlanoSaude getPlano() {
        return plano;
    }

    @Override
    public String toString() {
        return super.toString() + " - Plano: " + plano.getNome();
    }
}