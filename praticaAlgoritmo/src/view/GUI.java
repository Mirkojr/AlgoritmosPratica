package src.view;
import java.util.ArrayList;
import java.util.Scanner;

public class GUI {

    private Scanner leitor;

    public GUI(Scanner leitor){
        this.leitor = leitor;
    }

    public int getOptionSelection(ArrayList<String> options){
        printMessage("Escolha uma das opções: ");
        for(int i = 0; i < options.size(); i++){
            System.out.println("Opção " + (i + 1) + ": " + options.get(i));
        }
        return getInt();
    }

    public ArrayList<Integer> criarVetor(int n){ //retornar um vetor de tamanho n preenchido com entrada
        ArrayList<Integer> vetor = new ArrayList<>();
        printMessage("* Criação de vetor *");
        for(int i = 0; i < n; i++){
            int num = getInt("Digite o número " + i + ": ");
            vetor.add(num);
        }
        return vetor;
    }

    public int getInt(String message){ //getInt com mensagem
        String numeroTxt = getString(message);
        int nInt = Integer.parseInt(numeroTxt);
        return nInt;
    }
    public int getInt(){ //getInt sem mensagem
        String numeroTxt = leitor.nextLine();
        int nInt = Integer.parseInt(numeroTxt);
        return nInt;
    }


    public String getString(String message){
        System.out.println(message);
        String texto = leitor.nextLine();
        return texto;
    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printArray(ArrayList<Integer> array){
        System.out.println(array.toString());
    }
}
