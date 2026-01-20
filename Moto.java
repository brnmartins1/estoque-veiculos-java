import java.time.LocalDate;

public class Moto extends Veiculo implements Motorizado{

    int cilindradas;


    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public Moto(String modelo, String cor, int ano, int cilindradas){
        super(modelo, cor, ano);
        this.cilindradas = cilindradas;
    }

    @Override
    public void ligarMotor(){
        System.out.println("Vruuuuum! O motor da moto "+ this.getModelo() + " ligou. Vamos dar grau");
    }
    @Override
    public String toString(){

        return "-------------------FICHA DA MOTO-------------------\n"+
                super.toString() +
                "\nCilindradas: " + this.cilindradas;
    }
    @Override
    public String paraArquivo(){
        return "MOTO;" + this.getModelo() + ";" + this.getCor() + ";" + this.getAno() + ";" +this.getCilindradas();
    }


    void empinar(){
        System.out.println("Biiiiiiiii bi");

    }

}
