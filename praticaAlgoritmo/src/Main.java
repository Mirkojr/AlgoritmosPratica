package src;
import java.util.Scanner;

import src.model.Algoritmo;
import src.view.GUI;
import src.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Algoritmo algoritmo = new Algoritmo();
        GUI gui = new GUI(scanner);
        Controller controller = new Controller(algoritmo, gui);
        
        controller.start();  // Inicia o programa

        scanner.close();
    }
}
