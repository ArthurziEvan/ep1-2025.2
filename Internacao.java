package SistemaClinicoJava;

public class Internacao {
    private Paciente paciente;
    private Medico medico;
    private String dataEntrada;
    private int quarto;
    private double custoEstimado; // Valor base ANTES do desconto
    private boolean ativa = true;

    public Internacao(Paciente paciente, Medico medico, String dataEntrada, int quarto, double custoEstimado) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataEntrada = dataEntrada;
        this.quarto = quarto;
        this.custoEstimado = custoEstimado;
    }

    public Paciente getPaciente() { return paciente; }
    public Medico getMedico() { return medico; }
    public int getQuarto() { return quarto; }
    public boolean isAtiva() { return ativa; }
    public void encerrar() { ativa = false; }
    
    // Método para calcular o custo final (aplica o desconto se houver plano)
    public double getCustoEstimadoFinal() {
        return paciente.calcularDescontoInternacao(custoEstimado);
    }

    @Override
    public String toString() {
        String custoFormatado = String.format("%.2f", getCustoEstimadoFinal());
        
        return "Internação de " + paciente.getNome() + " em quarto " + quarto +
               " | Médico: " + medico.getNome() +
               " | Data entrada: " + dataEntrada +
               " | Custo final: R$" + custoFormatado +
               " | Status: " + (ativa ? "Ativa" : "Finalizada");
    }
}