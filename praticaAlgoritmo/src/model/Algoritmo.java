package src.model;
import java.util.ArrayList;
/* 
 * 
 * Lista de algoritmos para testar
 * Criado por Marcos Antônio :P
 * 
 */
public class Algoritmo {
    
    public int max(int x, int y){
        if(x > y) return x;
        if(y > x) return y;
        return x;
    }

    public int MaiorSubsquenciaMax(String str1, String str2){
        //Definir variaveis
        int m = str1.length();
        int n = str2.length();
        char[] txt1 = str1.toCharArray();
        char[] txt2 = str2.toCharArray();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();    

        //Inicializar
        for(int i = 0; i < m+1; i++){
            ArrayList<Integer> linha = new ArrayList<>();
            for(int j = 0; j < n+1; j++){
                linha.add(0);
            }
            dp.add(linha);
        }
        int MaxLength = 0;
        //Lógica da maior subSequencia Contígua
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                //caso letras iguais, soma 1 + a diagonal 
                if(txt1[i] == txt2[j]){
                    dp.get(i).set(j, 1 + dp.get(i+1).get(j+1));
                    MaxLength = max(MaxLength, dp.get(i).get(j));
                }
                //caso contrario acabou a subsequencia nessa pos


                else{
                    //dp.get(i).set(j, max(dp.get(i+1).get(j), dp.get(i).get(j+1))); caso não fosse contigua
                    dp.get(i).set(j, 0);
                }
            }
        }

      /*printar o vetor final
        for(int i = 0; i < m+1; i++){
            for(int j = 0; j < n+1; j++){
                System.out.print(dp.get(i).get(j));
            }
            System.out.println("");
        }
      */

        return MaxLength;
    }
    public int kSelection(int k, ArrayList<Integer> vetor){
        int menor;
        int aux;
        for(int i = 0; i <= k; i++){
            menor = i;
            for(int j = i+1; j < vetor.size(); j++){
                if(vetor.get(menor) > vetor.get(j)){
                    menor = j; 
                }
            }
            //troca o menor elemento para a pos i
            aux = vetor.get(i);
            vetor.set(i, vetor.get(menor));
            vetor.set(menor, aux);
        }
        return vetor.get(k);
    }

    public void countingSort(ArrayList<Integer> vetor, int k){
        k++; // k + 1 pos, por causa da pos 0;

        //inicializar o vetor contagem
        ArrayList<Integer> contagem = new ArrayList<Integer>(k);
        for(int i = 0; i < k; i++){
            contagem.add(0);
        }

        //contar os numeros
        for(int i = 0; i < vetor.size(); i++){
            contagem.set(vetor.get(i), 1 + contagem.get(vetor.get(i)));
        }
        
        int j = 0;
        for(int i = 0; i < vetor.size(); i++){
            while(contagem.get(j) == 0){
                j++;
            }
            vetor.set(i, j);
            contagem.set(j, contagem.get(j) - 1);
        }
    }

    public int retornarMaxVetor(ArrayList<Integer> vetor){ // Retorna o maior elemento do vetor
        int maior = vetor.get(0);
        for(int i = 1; i < vetor.size(); i++){
            if(vetor.get(i) > maior){
                maior = vetor.get(i);
            }
        }
        return maior;
    }

    public void intercala(ArrayList<Integer> vet1, ArrayList<Integer> vet2, ArrayList<Integer> vetor){
        int x = 0;
        int y = 0;
        int k = 0;
        
        //realizar a intercalacao ate pelo menos um dos vetores acabar
        while((x < vet1.size()) && (y < vet2.size())){
            if(vet1.get(x) <= vet2.get(y)){
                vetor.set(k, vet1.get(x));
                x++;
                k++;
            }
            else{
                vetor.set(k, vet2.get(y));
                y++;
                k++;
            }
        }
        //por elementos restantes do vetor 1 se tiver sobrado
        while (x < vet1.size()) {
            vetor.set(k, vet1.get(x));
            k++; x++;
        }
        //por elementos restantes do vetor 2 se tiver sobrado
        while (y < vet2.size()) {
            vetor.set(k, vet2.get(y));
            y++; k++;
        }


    }

    public void mergeSort(ArrayList<Integer> vetor){
        //conferir existencia do vetor, ou se possui algum elemento
        if((vetor.size() <= 1) || (vetor == null)){
            return;
        }
        //dividindo o vetor em 2 vetores menores
        ArrayList<Integer> vet1 = new ArrayList<Integer>();
        ArrayList<Integer> vet2 = new ArrayList<Integer>();
        int meio = (vetor.size())/2;
        for(int i = 0; i < meio; i++){
            vet1.add(vetor.get(i));
        }
        for(int i = meio; i < vetor.size(); i++){
            vet2.add(vetor.get(i));
        }
        
         mergeSort(vet1); //ordenar o vetor da esquerda
         mergeSort(vet2); //ordenar o vetor da direita
         intercala(vet1, vet2, vetor); //intercalar os vetores ordenados
        
    }
    
}
