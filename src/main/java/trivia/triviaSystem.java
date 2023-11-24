package trivia;

import java.util.Scanner;
import java.util.Random;

public class triviaSystem {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Bienvenido a la trivia! (4. Para salir)");
        
        while (true) {
            
            System.out.println("Seleccione la categoria de preguntas que desea jugar:");
            System.out.println("1. Deportes \n2. Historia \n3. Entretenimiento");
            
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Usted ha seleccionado la categoria de preguntas de Deportes");
                    int questionId = random.nextInt(10) + 1;
                    Question question = QuestionRequests.request(1, questionId); 
                    question.printQuestion();
                    int answer = scanner.nextInt();
                    boolean isCorrect = validateAnswer(answer, question);
                    
                    if (isCorrect) {
                        System.out.println("Respuesta correcta!");
                    } else {
                        System.out.println("Respuesta incorrecta!");
                    }

                    break;
                case 2:
                    System.out.println("Usted ha seleccionado la categoria de preguntas de Historia");
                    questionId = random.nextInt(10) + 1;
                    question = QuestionRequests.request(2, questionId); 
                    question.printQuestion();
                    answer = scanner.nextInt();
                    isCorrect = validateAnswer(answer, question);
                    
                    if (isCorrect) {
                        System.out.println("Respuesta correcta!");
                    } else {
                        System.out.println("Respuesta incorrecta!");
                    }

                    break;
                case 3:
                    System.out.println("Usted ha seleccionado la categoria de preguntas de Entretenimiento");
                    questionId = random.nextInt(10) + 1;
                    question = QuestionRequests.request(3, questionId); 
                    question.printQuestion();
                    answer = scanner.nextInt();
                    isCorrect = validateAnswer(answer, question);
                    
                    if (isCorrect) {
                        System.out.println("Respuesta correcta!");
                    } else {
                        System.out.println("Respuesta incorrecta!");
                    }

                    break;
                case 4:
                    System.out.println("Gracias por jugar!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
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
