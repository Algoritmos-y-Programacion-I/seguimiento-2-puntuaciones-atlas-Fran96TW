// Análisis (completar)
// Descripción del programa:
// Entradas:
// Salidas:
// Ejemplo:


package ui; // No olvidar especificar el paquete / carpeta de nuestro programa

import java.util.Scanner; // Para poder usar Scanner, debemos importarlo

public class AtlasPuntuaciones {
	public static void main(String[] args) {

        // Declaración de variables y Scanner
        Scanner scanner = new Scanner(System.in);
        int players, rounds;

        System.out.println("<------------ ATLAS EVENTS ------------>");

        // Validación del número de jugadores
        while (true) {
            System.out.print("Please, enter the number of players (max 10): ");
            players = scanner.nextInt();

            if (players > 10) {
                System.out.println("Sorry, but the maximum number of players is 10.");
            } else if (players <= 0) {
                System.out.println("Sorry, but there must be at least one player.");
            } else {
                break; // Entrada válida
            }
        }

        // Validación del número de rondas
        while (true) {
            System.out.print("Now, enter the number of rounds (max 5): ");
            rounds = scanner.nextInt();

            if (rounds > 5) {
                System.out.println("Sorry, but the maximum number of rounds is 5.");
            } else if (rounds <= 0) {
                System.out.println("Sorry, but there must be at least one round.");
            } else {
                break; // Entrada válida
            }
        }

        // Llamar a la función para registrar puntajes
        int[] totalScores = game(scanner, players, rounds);

        // Mostrar los puntajes totales y promedios de cada jugador
        System.out.println("\n<------------ FINAL RESULTS ------------>");
        for (int i = 0; i < players; i++) {
            double average = prom(totalScores[i], rounds);
            System.out.println("Player " + (i + 1) + ": " + totalScores[i] + " points | Average: " + average);
        }

        scanner.close();
    }

    public static int[] game(Scanner scanner, int players, int rounds) {
        int[] totalScores = new int[players]; // Almacena los puntajes totales de los jugadores

        // Registrar los puntajes
        for (int i = 0; i < players; i++) {
            System.out.println("\nEntering scores for Player " + (i + 1) + ":");
            for (int j = 0; j < rounds; j++) {
                int score;
                while (true) {
                    System.out.print("  Round " + (j + 1) + " score (0-100): ");
                    score = scanner.nextInt();

                    if (score < 0 || score > 100) {
                        System.out.println("Invalid score! Must be between 0 and 100.");
                    } else {
                        break; // Entrada válida
                    }
                }
                totalScores[i] += score;
            }
        }

        return totalScores;
    }

    public static double prom(int totalScore, int rounds) {
        return (double) totalScore / rounds; // Calcula el promedio del puntaje total
    }
	
}