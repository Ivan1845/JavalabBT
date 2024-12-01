import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            // Ініціалізація матриць A та B
            byte[][] matrixA = {
                    {5, 8, 3},
                    {4, 5, 4},
                    {9, 2, 4}
            };

            byte[][] matrixB = {
                    {5, 8, 7},
                    {6, 2, 1},
                    {3, 9, 1}
            };

            // Перевірка відповідності розмірів матриць
            if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
                throw new IllegalArgumentException("Матриці A та B повинні бути однакового розміру.");
            }

            // Обчислення матриці C = A + B
            byte[][] matrixC = addMatrices(matrixA, matrixB);

            // Обчислення середнього значення елементів матриці C
            double average = calculateAverage(matrixC);

            // Виведення результатів
            System.out.println("Матриця A:");
            printMatrix(matrixA);
            System.out.println("Матриця B:");
            printMatrix(matrixB);
            System.out.println("Результуюча матриця C (A + B):");
            printMatrix(matrixC);
            System.out.println("Середнє значення елементів матриці C: " + average);
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    // Метод додавання двох матриць
    public static byte[][] addMatrices(byte[][] matrixA, byte[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        byte[][] result = new byte[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = (byte) (matrixA[i][j] + matrixB[i][j]);
            }
        }

        return result;
    }

    // Метод обчислення середнього значення елементів матриці
    public static double calculateAverage(byte[][] matrix) {
        int sum = 0;
        int count = 0;

        for (byte[] row : matrix) {
            for (byte element : row) {
                sum += element;
                count++;
            }
        }

        return (double) sum / count;
    }

    // Метод для виведення матриці
    public static void printMatrix(byte[][] matrix) {
        for (byte[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
