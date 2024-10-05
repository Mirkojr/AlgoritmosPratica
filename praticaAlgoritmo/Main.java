import java.util.Scanner;

/*
 * 
 * Arquivo principal onde é chamado a interface gráfica 
 * Criado por Marcos Antônio :P
 * 
 */

class Main{
    public static void main(String[] args) {
         
        Scanner leitor = new Scanner(System.in);
        GUI gui = new GUI(leitor);
        gui.OptionSelection();     
        leitor.close();
        
    }
}