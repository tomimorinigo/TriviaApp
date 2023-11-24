package trivia;

import java.util.Scanner;
import java.util.Random;

public class triviaSystem {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Bienvenido a la trivia!");
        System.out.println("Ingrese su nombre de usuario: ");
        String userName = scanner.nextLine();
        User user = new User(userName, 0);
        
        while (true) {
            
            System.out.println("\nSeleccione la categoria de preguntas que desea jugar:");
            System.out.println("1. Deportes \n2. Historia \n3. Entretenimiento \n4. Salir");
            
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("\nCategoria de preguntas de Deportes");
                    handleQuestion(1, user, scanner, random);
                    break;

                case 2:
                    System.out.println("\nCategoria de preguntas de Historia");
                    handleQuestion(2, user, scanner, random);
                    break;

                case 3:
                    System.out.println("\nCategoria de preguntas de Entretenimiento");
                    handleQuestion(3, user, scanner, random);
                    break;

                case 4:
                    System.out.println("Gracias por jugar!");
                    user.printUser();
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }
    }

    public void handleQuestion(int category, User user, Scanner scanner, Random random) {
        int questionId = random.nextInt(10) + 1;
        Question question = QuestionRequests.request(category, questionId); 
        question.printQuestion();
        int answer = scanner.nextInt();
        boolean isCorrect = validateAnswer(answer, question);
        
        if (isCorrect) {
            System.out.println("Respuesta correcta! Suma un punto!");
            user.setScore(user.getScore() + 1);
        } else {
            System.out.println("Respuesta incorrecta!");
        }
    }

    public static boolean validateAnswer(int answer, Question question) {
        if (answer == 1) {
            if (question.getOptions().get(0).equals(question.getAnswer())) {
                return true;
            }
        } else if (answer == 2) {
            if (question.getOptions().get(1).equals(question.getAnswer())) {
                return true;
            }
        } else if (answer == 3) {
            if (question.getOptions().get(2).equals(question.getAnswer())) {
                return true;
            }
        } else if (answer == 4) {
            if (question.getOptions().get(3).equals(question.getAnswer())) {
                return true;
            }
        }
        return false;
    }
}
