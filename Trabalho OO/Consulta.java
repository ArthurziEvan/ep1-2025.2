package src;
public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private String data;
    private Triagem triagem;
    private double valorBase = 200.0;

    public Consulta(Paciente paciente, Medico medico, String data, Triagem triagem) {
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
        this.triagem = triagem;
    }

    public Paciente getPaciente() { return paciente; }
    public Medico getMedico() { return medico; }
    public String getData() { return data; }

    public double getValorFinal() {
        return paciente.calcularDescontoConsulta(valorBase);
    }

    @Override
    public String toString() {
        return "Consulta de " + paciente.getNome() + " com " + medico.getNome() + 
               " em " + data + " | Valor: R$" + getValorFinal();
    }
}