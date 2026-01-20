public class Bicicleta extends Veiculo {

    public Bicicleta(String modelo, String cor, int ano){
        super(modelo, cor, ano);
    }
    @Override
    public String paraArquivo() {
        return "BIKE;" + this.getModelo() + ";" + this.getCor() + ";" + this.getAno();
    }

    @Override
    public String toString(){
     return "-------------------FICHA DA BIKE-------------------\n"+ super.toString();

    }

}
