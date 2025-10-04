

public class PlanoSaude {
    private String nome;
    private double descontoConsulta;
    private double descontoInternacao;

    public PlanoSaude(String nome, double descontoConsulta, double descontoInternacao) {
        this.nome = nome;
        this.descontoConsulta = descontoConsulta;
        this.descontoInternacao = descontoInternacao;
    }

    public String getNome() { return nome; }
    public double getDescontoConsulta() { return descontoConsulta; }
    public double getDescontoInternacao() { return descontoInternacao; }

    @Override
    public String toString() {
        return nome + " (Descontos: " + descontoConsulta + "% consulta, " + descontoInternacao + "% internação)";
    }
}