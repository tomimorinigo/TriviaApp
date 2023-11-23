package trivia;

import java.util.Scanner;

public class triviaSystem {

    public void start() {
        System.out.println("Bienvenido a la trivia!");
        System.out.println("Seleccione la categoria de preguntas que desea jugar:");
        System.out.println("1. Deportes \n2. Historia \n3. Entretenimiento");

        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Usted ha seleccionado la categoria de preguntas de Deportes");
                break;
            case 2:
                System.out.println("Usted ha seleccionado la categoria de preguntas de Historia");
                break;
            case 3:
                System.out.println("Usted ha seleccionado la categoria de preguntas de Entretenimiento");
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }

        scanner.close();
    }
}
