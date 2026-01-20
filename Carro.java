import java.time.LocalDate;

public class Carro extends Veiculo implements Motorizado{

    int numerodePortas;

    public Carro(String modelo, String cor, int ano, int numerodePortas){
    super(modelo, cor, ano);
    this.numerodePortas = numerodePortas;
    }

    @Override
    public String paraArquivo(){
        return "CARRO;" + this.getModelo() + ";" + this.getCor() + ";" + this.getAno() + ";" + this.getNumerodePortas();
    }

    public int getNumerodePortas() {
        return numerodePortas;
    }

    public void setNumerodePortas(int numerodePortas) {
        this.numerodePortas = numerodePortas;
    }

    @Override
    public void ligarMotor(){
        System.out.println("Vruuuuum! O motor do carro "+ this.getModelo() + " ligou.");
    }

    @Override
    public String toString(){

        return "-------------------FICHA DO CARRO-------------------\n"+
                super.toString() +
                "\nPortas: " + this.numerodePortas;
    }

    void buzinar(){
        System.out.println("Biiiiiiiii bi");

    }

}
