package src;
public class Internacao {
    private Paciente paciente;
    private Medico medico;
    private String dataEntrada;
    private String dataSaida;
    private int quarto;
    private double custo;
    private boolean ativa = true;

    public Internacao(Paciente paciente, Medico medico, String dataEntrada, int quarto, double custo) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataEntrada = dataEntrada;
        this.quarto = quarto;
        this.custo = custo;
    }

    public boolean isAtiva() { return ativa; }
    public int getQuarto() { return quarto; }

    public void darAlta(String dataSaida) {
        this.dataSaida = dataSaida;
        this.ativa = false;
    }

    public double getValorFinal() {
        return paciente.calcularDescontoInternacao(custo);
    }

    @Override
    public String toString() {
        return "Internação de " + paciente.getNome() + " no quarto " + quarto + 
               " (" + (ativa ? "Ativa" : "Finalizada") + ") - Custo: R$" + getValorFinal();
    }
}