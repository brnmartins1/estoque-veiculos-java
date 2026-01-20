import java.time.LocalDate;

public abstract class Veiculo {
    private String modelo;
    private String cor;
    private int ano;

    public abstract String paraArquivo();

    public Veiculo(String modelo, String cor, int ano){
        this.setModelo(modelo);
        this.setCor(cor);
        this.setAno(ano);
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public int getAno() {
        return ano;
    }


    @Override
    public  String toString(){
        return "Modelo: " + this.modelo +
                "\nCor: " + this.cor +
                "\nAno: " + this.ano;
    }

    public void setAno(int ano) {
        if (ano >= 1886) {
            this.ano = ano;
        } else {
            System.out.println("Ano invalido. O primeiro carro foi criado em 1886");
        }

    }
    public int calcularIdade(){
        int anoAtual = LocalDate.now().getYear();
        return anoAtual - this.ano;
    }

}

