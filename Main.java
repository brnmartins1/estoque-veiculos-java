import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {

    public static  int lerNumero(Scanner leitor, String mensagem){
        while(true){
            try{
                System.out.println(mensagem);
                String entrada = leitor.nextLine();
                return Integer.parseInt(entrada);
            }catch (NumberFormatException e) {
                System.out.println("ERRO: Digite apenas numeros inteiros");
            }
        }

    }

    public static void salvarDados(ArrayList<Veiculo> estoque) {
        try {
            FileWriter escritor = new FileWriter("banco_dados.txt");
            for (Veiculo v : estoque) {
                escritor.write(v.paraArquivo() + "\n");
            }
            escritor.close();
            System.out.println("Dados salvos com sucesso no arquivo 'banco_dados.txt'");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public static void carregarDados(ArrayList<Veiculo> estoque){
        File arquivo = new File("banco_dados.txt");
        if (!arquivo.exists()){
            System.out.println("Nenhum arquivo encontrado. Começando o estoque do 0");
        return;
        }
        try{
            Scanner leitorArquivo = new Scanner(arquivo);

            while (leitorArquivo.hasNextLine()){
                String linha = leitorArquivo.nextLine();
                String[] dados = linha.split(";");

                String tipo = dados[0];
                String modelo = dados[1];
                String cor = dados[2];
                int ano = Integer.parseInt(dados[3]);

                if(tipo.equals("CARRO")){
                    int portas = Integer.parseInt(dados[4]);
                    estoque.add(new Carro(modelo,cor , ano, portas));
                } else if (tipo.equals("MOTO")) {
                    int cc = Integer.parseInt(dados[4]);
                    estoque.add(new Moto(modelo, cor, ano, cc));
                } else if (tipo.equals("BIKE")) {
                    estoque.add(new Bicicleta(modelo, cor, ano));
                }

            }
            leitorArquivo.close();
            System.out.println(estoque.size() + " Veiculos carregados no arquivo");
        }

        catch (FileNotFoundException e){
            System.out.println("Erro ao ler o arquivo.");
        }
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ArrayList<Veiculo> estoque = new ArrayList<>();

        carregarDados(estoque);

        Boolean laco = true;
        while(laco){

            System.out.println("\n================ESTOQUE DE VEICULOS================");
            System.out.println("\nDigite 1 para adicionar um Carro, 2 para adicionar uma Moto, 3 para ver a lista de Veiculos e 4 para adicionar uma Bicicleta e 5 para Sair: ");
            String opcao = leitor.nextLine();
            switch (opcao){
                case "1":
                    System.out.println("\nVocê escolheu a opção 1, registre os dados do Carro");
                    System.out.println("Digite o modelo do carro: ");
                    String modeloDigitado = leitor.nextLine();
                    System.out.println("Digite a cor do carro: ");
                    String corDigitada = leitor.nextLine();
                    int anoDigitado= lerNumero(leitor, "Digite o ano do carro: ");
                    int qtdPortas = lerNumero(leitor, "Digite a quantidade de portas do carro: ");
                    estoque.add(new Carro(modeloDigitado, corDigitada, anoDigitado, qtdPortas));
                    break;

                case "2":
                    System.out.println("\nVocê escolheu a opção 2, registre os dados da Moto");
                    System.out.println("Digite o modelo da moto: ");
                    String modeloMoto = leitor.nextLine();
                    System.out.println("Digite a cor da moto: ");
                    String corMoto = leitor.nextLine();
                    int anoMoto = lerNumero(leitor, "Digite o ano de fabricação da moto: ");
                    int cilindradas = lerNumero(leitor, "Digite a quantidade de cilindradas da moto: ");
                    estoque.add(new Moto(modeloMoto, corMoto, anoMoto, cilindradas));
                    break;
                case "3":
                    System.out.println("================LISTA DE VEICULOS================");
                    System.out.println("Quantidade de veiculos cadastrados: " + estoque.size());
                    for(Veiculo v : estoque) {
                    System.out.println(v);
                    if (v instanceof  Motorizado){
                        Motorizado m = (Motorizado) v;
                        m.ligarMotor();
                    }
                    else {
                        System.out.println("Este veiculo não tem motor, bora pedalar");
                    }
                    System.out.println("");
                    }
                    break;
                case "4":
                    System.out.println("\nVocê escolheu a opção 2, registre os dados da Moto");
                    System.out.println("Digite o modelo da bike: ");
                    String modeloBike = leitor.nextLine();
                    System.out.println("Digite a cor da bike: ");
                    String corBike = leitor.nextLine();
                    int anoBike = lerNumero(leitor, "Digite o ano de fabricação da bike: ");
                    estoque.add(new Bicicleta(modeloBike, corBike, anoBike));
                    break;
                case "5":
                    salvarDados(estoque);
                    System.out.println("Encerrando o sistema...");
                    laco = false;
                    break;
            }
        }
    }
}













