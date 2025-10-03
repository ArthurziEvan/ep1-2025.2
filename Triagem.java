package SistemaClinicoJava;

public class Triagem {
    private double altura;
    private double peso;
    private String pressao;
    private int batimentos;
    private double temperatura;

    public Triagem(double altura, double peso, String pressao, int batimentos, double temperatura) {
        this.altura = altura;
        this.peso = peso;
        this.pressao = pressao;
        this.batimentos = batimentos;
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "Altura: " + altura + "m, Peso: " + peso + "kg, Pressão: " + pressao + 
               ", Batimentos: " + batimentos + "bpm, Temp: " + temperatura + "°C";
    }
}
