package src.view;
import java.util.ArrayList;
import java.util.Scanner;

public class GUI {

    private Scanner leitor;

    public GUI(Scanner leitor){
        this.leitor = leitor;
    }

    public int getOptionSelection(ArrayList<String> options){

        for(int i = 0; i < options.size(); i++){
            System.out.println("Opção " + (i + 1) + ": " + options.get(i));
        }
        return getInt("Escolha uma das opções: ");
    }

    public ArrayList<Integer> criarVetor(int n){
        ArrayList<Integer> vetor = new ArrayList<>();
        System.out.println("* Criação de vetor *");
        for(int i = 0; i < n; i++){
            int num = getInt("Digite o número " + i + ": ");
            vetor.add(num);
        }
        return vetor;
    }

    public int getInt(String message){
        String numeroTxt = getString(message);
        int nInt = Integer.parseInt(numeroTxt);
        return nInt;
    }

    public String getString(String message){
        System.out.println(message);
        //leitor.next(); //Consumir o \n
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
