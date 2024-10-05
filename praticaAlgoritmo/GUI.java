import java.util.ArrayList;
import java.util.Scanner;

/*
 *
 * Interface gráfica no terminal
 * Criada por Marcos Antônio :P
 * 
 */

public class GUI{

    Algoritmo algoritmo; //Instância para chamar os algoritmos
    Scanner leitor;      //Receber input do usuário

    public GUI(Scanner leitor){
        algoritmo = new Algoritmo();
        this.leitor = leitor;
    }

    public void OptionSelection(){
        
        ArrayList<String> options = new ArrayList<String>();
        options.add("kSelection");
        options.add("MaiorSubsequencia");
        options.add("CountingSort");
        options.add("MergeSort");

        System.out.println("Escolha uma das opcoes: ");
        for(int i = 0; i < options.size(); i++){
            System.out.println("opcao " + (i+1) + ": " + options.get(i));
        }

        //opcoes de algoritmos 
        int option = leitor.nextInt();
        if(option == 1){
            kSelectionSortGUI();
        }
        else if (option == 2){
            MaiorSubMaxGUI();
        }
        else if (option == 3){
            countingSortGUI();
        }
        else if(option == 4){
            mergeSortGUI();
        }
    
    }
    
    public void mergeSortGUI(){
        ArrayList<Integer> vet = new ArrayList<Integer>();
        vet = criarVetor(5);                //criar um vetor de tamanho 5
        System.out.println("O seu vetor: \n" + vet.toString());
        algoritmo.mergeSort(vet);             //ordenar
        System.out.println("O seu vetor ordenado: \n" + vet.toString());   //printar o vetor ordenado
    }

    public void countingSortGUI(){
        System.out.println("Digite qual o tamanho do seu vetor: ");
        int tam = leitor.nextInt();
        ArrayList<Integer> vetor = criarVetor(tam);
        System.out.println("O seu vetor original eh : " + vetor.toString());
        algoritmo.countingSort(vetor, algoritmo.retornarMaxVetor(vetor));
        System.out.println("Seu vetor ordenado: " + vetor.toString());

    }

    public void MaiorSubMaxGUI(){
      
        System.out.println("Digite o primeiro texto: ");
        String txt1 = leitor.nextLine();
        System.out.println("Digite o segundo texto: ");
        String txt2 = leitor.nextLine();
        
        System.out.println("Tamanho: " + algoritmo.MaiorSubsquenciaMax(txt1, txt2));
    }

    public void kSelectionSortGUI(){

        System.out.println("Digite quantos elementos pro seu vetor: ");
        int n = leitor.nextInt();
        ArrayList<Integer> vetor = criarVetor(n);
        System.out.println(vetor.toString());

        System.out.println("Digite o k-esimo elemento que voce quer: ");
        int k = leitor.nextInt();
        int k_pos = algoritmo.kSelection(k, vetor);
        System.out.println("Seu vetor ordenado: " + vetor.toString());
        System.out.println("O k-esimo elemento do seu vetor eh: " + k_pos);

    }
    
    public ArrayList<Integer> criarVetor(int n){
        ArrayList<Integer> vetor = new ArrayList<>();
        
        System.out.println("*Criacao de vetor*");
        int num;
        for(int i = 0; i < n; i++){
            System.out.println("Digite o numero " + i + ": ");
            num = leitor.nextInt();
            vetor.add(num);
        }
       
        return vetor;
    }
}