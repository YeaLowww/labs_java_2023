public class Main {
    public static void main(String [] args){
        int C5 = 1107%5;
        System.out.println(C5);
        int C7 = 1107%7;
        System.out.println(C7);
        int C11 = 1107%11;
        System.out.println(C11);


        int rows = 3;
        int columns = 3;

        byte[][] matrixA = {
                {1, 2, 3},
                {4, 2, 6},
                {7, 2, 2}
        };
        byte[][] matrixB = {
                {9, 1, 7},
                {6, 5, 3},
                {0, 4, 1}
        };

        System.out.println("matrix A: ");
        for(int i = 0; i < matrixA.length; i++){
            for(int j = 0; j < matrixA[i].length; j++){
                System.out.print(matrixA[i][j] + " \t ");
            }
            System.out.println();

        }
        System.out.println("matrix B: ");
        for(int i = 0; i < matrixB.length; i++){
            for(int j = 0; j < matrixB[i].length; j++){
                System.out.print(matrixB[i][j] + " \t ");
            }
            System.out.println();

        }
// Матриця для зберігання суми
        int[][] resultMatrix = new int[rows][columns];

        // Додавання матриць
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        // Виведення результату
        System.out.println("Результат додавання матриць:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------------:");
        int sumMaxOddColumns = 0;
        int sumMinEvenColumns = 0;

        // Знаходимо мінімальні та максимальні значення в стовпцях
        for (int j = 0; j < columns; j++) {
            int min = resultMatrix[0][j];
            int max = resultMatrix[0][j];

            for (int i = 0; i < rows; i++) {
                if ((j+1) % 2 == 0) { // Якщо стовпець парний
                    if (resultMatrix[i][j] < min) {
                        min = resultMatrix[i][j];
                    }
                } else { // Якщо стовпець непарний
                    if (resultMatrix[i][j] > max) {
                        max = resultMatrix[i][j];
                    }
                }
            }

            // Додаємо знайдені мінімальні та максимальні значення до сум
            if ((j+1) % 2 == 0) { // Парний стовпець
                sumMinEvenColumns += min;
            } else { // Непарний стовпець
                sumMaxOddColumns += max;
            }
        }

        // Виводимо результат
        System.out.println("Сума найбільших елементів у непарних стовпцях: " + sumMaxOddColumns);
        System.out.println("Сума найменших елементів у парних стовпцях: " + sumMinEvenColumns);
    }


}
