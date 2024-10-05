package src.controller;
import java.util.ArrayList;

import src.view.GUI;
import src.model.Algoritmo;

/* 
 * 
 * Controller
 * Criado por Marcos Antônio :P
 * 
 */

public class Controller {

    private Algoritmo algoritmo;
    private GUI gui;

    public Controller(Algoritmo algoritmo, GUI gui){
        this.algoritmo = algoritmo;
        this.gui = gui;
    }

    public void start(){
        ArrayList<String> options = new ArrayList<>();
        options.add("kSelection");
        options.add("MaiorSubsequencia");
        options.add("CountingSort");
        options.add("MergeSort");

        int option = gui.getOptionSelection(options);

        switch (option) {
            case 1:
                kSelectionSort();
                break;
            case 2:
                maiorSubMax();
                break;
            case 3:
                countingSort();
                break;
            case 4:
                mergeSort();
                break;
            default:
                gui.printMessage("Opção inválida!");
        }
    }

    private void mergeSort(){
        ArrayList<Integer> vetor = gui.criarVetor(5);
        gui.printMessage("O seu vetor: \n" + vetor.toString());
        algoritmo.mergeSort(vetor);
        gui.printMessage("O seu vetor ordenado: \n" + vetor.toString());
    }

    private void countingSort(){
        int tam = gui.getInt("Digite o tamanho do seu vetor:");
        ArrayList<Integer> vetor = gui.criarVetor(tam);
        gui.printMessage("O seu vetor original é: " + vetor.toString());
        algoritmo.countingSort(vetor, algoritmo.retornarMaxVetor(vetor));
        gui.printMessage("Seu vetor ordenado: " + vetor.toString());
    }

    private void maiorSubMax(){
        String txt1 = gui.getString("Digite o primeiro texto:");
        String txt2 = gui.getString("Digite o segundo texto:");
        int maxLength = algoritmo.MaiorSubsquenciaMax(txt1, txt2);
        gui.printMessage("Tamanho da maior subsequência: " + maxLength);
    }

    private void kSelectionSort(){
        int n = gui.getInt("Digite quantos elementos no seu vetor:");
        ArrayList<Integer> vetor = gui.criarVetor(n);
        gui.printMessage("Vetor: " + vetor.toString());
        int k = gui.getInt("Digite o k-ésimo elemento que você quer (partindo da pos 0):");
        int kElement = algoritmo.kSelection(k, vetor);
        gui.printMessage("Seu vetor ordenado: " + vetor.toString());
        gui.printMessage("O k-ésimo elemento é: " + kElement);
    }
}
