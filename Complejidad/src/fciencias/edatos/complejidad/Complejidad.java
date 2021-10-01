package fciencias.edatos.complejidad;

import java.util.Arrays;

/**
 * Practica de complejidad
 * @author Celic Aislinn Liahut Ley y Diana Laura Salgado Tirado
 */
public class Complejidad {

  /**
   * Hace la mezcla de dos arreglos ordenados desde la primera posición hasta
   * una posición límite
   * @param array1 el primer arreglo a mezlar
   * @param n el límite de mezcla del primer arreglo
   * @param array2 el segundo arreglo a mezclar
   * @param m el límite de mezcla del segundo arreglo.
   * @return un arreglo ordenado de longitud m+n con la mezcla definida.
   */
  public static int[] mergeSortedArray(
    int[] array1,
    int n,
    int[] array2,
    int m
  ) {
    if (n > array1.length || m > array2.length) throw new RuntimeException(
      "Límites no válidos"
    );

    int[] result = new int[n + m];
    int pointer;
    for (pointer = 0; pointer < n; pointer++) result[pointer] = array1[pointer];
    for (int i = 0; i < m; i++, pointer++) result[pointer] = array2[i];

    // Ordenamiento del arreglo result
    for (int j = 0; j < result.length - 1; j++) {
      for (int k = j + 1; k < result.length; k++) {
        if (result[k] < result[j]) {
          int aux = result[k];
          result[k] = result[j];
          result[j] = aux;
        }
      }
    }

    return result;
  }

  /**
   * Verifica si un tablero contiene los números desde 0 hasta n-1 en cada fila y cada columna.
   * @param board el tablero de nxn que contiene elementos dentro del rango [0, n-1].
   * @return true si el tablero contiene los números desde 0 hasta n-1 en cada fila y columna,
   * false en otro caso.
   */
  public static boolean isValidBoard(int[][] board) {
    int length = board.length;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        boolean verificador = false;
        // Verifica sobre las filas
        for (int k = 0; k < length; k++) {
          if (board[i][k] == j) {
            verificador = true;
            break;
          }
        }
        if (!verificador) {
          return false;
        }
        verificador = false;
        // Verifica sobre las columnas
        for (int k = 0; k < length; k++) {
          if (board[k][i] == j) {
            verificador = true;
            break;
          }
        }
        if (!verificador) {
          return false;
        }
      }
    }
    return true;
  }

  public static boolean isValidBoardOptimizado(int[][] board) {
    int length = board.length;
    boolean verificador = false;
    for (int i = 0; i < length; i++) {
      int[] horizontales = board[i];

      int[] verticales = new int[board.length];
      int ArrayAux[] = new int[length];

      for (int k = 0; k < length; k++) {
        //Para filas
        if (horizontales[k] >= 0 && horizontales[k] < length) {
          verificador = true;
          ArrayAux[horizontales[k]]++;
          if (ArrayAux[horizontales[k]] > 2) return false;
        }

        //Para columnas

        verticales[k] = board[k][i];
        if (horizontales[k] >= 0 && horizontales[k] < length) {
          verificador = true;
          ArrayAux[verticales[k]]++;
          if (ArrayAux[verticales[k]] > 2) return false;
        }
        //System.out.println("hola"+Arrays.toString(ArrayAux));

      }
    }
    return verificador;
  }

  /**
   * Rota position cantidad de veces los elementos de un arreglo
   * hacia el vecino izquierdo.
   * @param num el arreglo de enteros a rotar.
   * @param position la cantidad de espacios a rotar.
   */
  public static void rotateArray(int[] num, int position) {
    for (int i = 0; i < position; i++) {
      int aux = num[0];
      for (int j = 0; j < num.length - 1; j++) {
        num[j] = num[j + 1];
      }
      num[num.length - 1] = aux;
    }
  }

  public static void main(String[] args) {
    /*  String directorio1 = "Examples/ArrayExamples/";
    String directorio2 = "Examples/BoardExamples/"; */

    String directorio1 = "Tests/ArrayTests/";
    String directorio2 = "Tests/BoardTests/";

    // EJEMPLOS DE ACTIVIDAD 1
    System.out.println("\nEJEMPLOS DE ACTIVIDAD 1\n");

    ///--- Primer algoritmo
    int[] arrayA1 = ArrayReader.readArray(directorio1 + "ArrayA1.txt");
    int[] arrayA2 = ArrayReader.readArray(directorio1 + "ArrayA2.txt");
    long inicio = System.currentTimeMillis();
    int[] resultA = mergeSortedArray(arrayA1, 3, arrayA2, 5);
    long fin = System.currentTimeMillis();
    System.out.println("Resultado A: " + Arrays.toString(resultA));
    System.out.println(
      "El algoritmo 1 se tardó: " + (fin - inicio) + " milisegundos."
    );

    int[] arrayB1 = ArrayReader.readArray(directorio1 + "ArrayB1.txt");
    int[] arrayB2 = ArrayReader.readArray(directorio1 + "ArrayB2.txt");
    inicio = System.currentTimeMillis();
    int[] resultB = mergeSortedArray(arrayB1, 5, arrayB2, 5);
    fin = System.currentTimeMillis();
    System.out.println("Resultado B: " + Arrays.toString(resultB));
    System.out.println(
      "El algoritmo 1 se tardó: " + (fin - inicio) + " milisegundos."
    );

    int[] arrayC1 = ArrayReader.readArray(directorio1 + "ArrayC1.txt");
    int[] arrayC2 = ArrayReader.readArray(directorio1 + "ArrayC2.txt");
    inicio = System.currentTimeMillis();
    int[] resultC = mergeSortedArray(arrayC1, 4, arrayC2, 6);
    fin = System.currentTimeMillis();
    System.out.println("Resultado C: " + Arrays.toString(resultC));
    System.out.println(
      "El algoritmo 1 se tardó: " + (fin - inicio) + " milisegundos."
    );

    int[] arrayD1 = ArrayReader.readArray(directorio1 + "ArrayD1.txt");
    int[] arrayD2 = ArrayReader.readArray(directorio1 + "ArrayD2.txt");
    inicio = System.currentTimeMillis();
    int[] resultD = mergeSortedArray(arrayA1, 3, arrayD2, 5);
    fin = System.currentTimeMillis();
    System.out.println("Resultado D: " + Arrays.toString(resultD));
    System.out.println(
      "El algoritmo 1 se tardó: " + (fin - inicio) + " milisegundos."
    );

    int[] arrayE1 = ArrayReader.readArray(directorio1 + "ArrayE1.txt");
    int[] arrayE2 = ArrayReader.readArray(directorio1 + "ArrayE2.txt");
    inicio = System.currentTimeMillis();
    int[] resultE = mergeSortedArray(arrayB1, 5, arrayE2, 5);
    fin = System.currentTimeMillis();
    System.out.println("Resultado E: " + Arrays.toString(resultE));
    System.out.println(
      "El algoritmo 1 se tardó: " + (fin - inicio) + " milisegundos."
    );

    int[] arrayF1 = ArrayReader.readArray(directorio1 + "ArrayF1.txt");
    int[] arrayF2 = ArrayReader.readArray(directorio1 + "ArrayF2.txt");
    inicio = System.currentTimeMillis();
    int[] resultF = mergeSortedArray(arrayF1, 4, arrayF2, 6);
    fin = System.currentTimeMillis();
    System.out.println("Resultado F: " + Arrays.toString(resultF));
    System.out.println(
     "El algoritmo 1 se tardó: " + (fin - inicio) + " milisegundos."
    );

    //--- Segundo algoritmo

    inicio = System.currentTimeMillis();
    int[] resultA2 = mergeSortedArray(arrayA1, 3, arrayA2, 5);
    fin = System.currentTimeMillis();
    System.out.println("Resultado A: " + Arrays.toString(resultA2));
    System.out.println(
      "El algoritmo 2 se tardó: " + (fin - inicio) + " milisegundos."
    );

    inicio = System.currentTimeMillis();
    int[] resultB2 = mergeSortedArray(arrayB1, 5, arrayB2, 5);
    fin = System.currentTimeMillis();
    System.out.println("Resultado B: " + Arrays.toString(resultB2));
    System.out.println(
      "El algoritmo 2 se tardó: " + (fin - inicio) + " milisegundos."
    );

    inicio = System.currentTimeMillis();
    int[] resultC2 = mergeSortedArray(arrayC1, 4, arrayC2, 6);
    fin = System.currentTimeMillis();
    System.out.println("Resultado C: " + Arrays.toString(resultC2));
    System.out.println(
      "El algoritmo 2 se tardó: " + (fin - inicio) + " milisegundos."
    );

    inicio = System.currentTimeMillis();
    int[] resultD2 = mergeSortedArray(arrayA1, 3, arrayD2, 5);
    fin = System.currentTimeMillis();
    System.out.println("Resultado D: " + Arrays.toString(resultD2));
    System.out.println(
      "El algoritmo 2 se tardó: " + (fin - inicio) + " milisegundos."
    );

    inicio = System.currentTimeMillis();
    int[] resultE2 = mergeSortedArray(arrayB1, 5, arrayE2, 5);
    fin = System.currentTimeMillis();
    System.out.println("Resultado E: " + Arrays.toString(resultE2));
    System.out.println(
      "El algoritmo 2 se tardó: " + (fin - inicio) + " milisegundos."
    );

    inicio = System.currentTimeMillis();
    int[] resultF2 = mergeSortedArray(arrayF1, 4, arrayF2, 6);
    fin = System.currentTimeMillis();
    System.out.println("Resultado F: " + Arrays.toString(resultF2));
    System.out.println(
      "El algoritmo 2 se tardó: " + (fin - inicio) + " milisegundos."
    );

    // EJEMPLOS DE ACTIVIDAD 2
    System.out.println("\nEJEMPLOS DE ACTIVIDAD 2\n");

    int[][] boardA = ArrayReader.readMatrix(directorio2 + "BoardA.txt");
    inicio = System.currentTimeMillis();
    boolean boardResultA = isValidBoard(boardA);
    fin = System.currentTimeMillis();
    System.out.println("El tablero A es válido: " + boardResultA);
    System.out.println(
      "El algoritmo 1 se tardó: " + (fin - inicio) + " milisegundos."
    );

    int[][] boardB = ArrayReader.readMatrix(directorio2 + "BoardB.txt");
    inicio = System.currentTimeMillis();
    boolean boardResultB = isValidBoard(boardB);
    fin = System.currentTimeMillis();
    System.out.println("El tablero B es válido: " + boardResultB);
    System.out.println(
      "El algoritmo 1 se tardó: " + (fin - inicio) + " milisegundos."
    );

    int[][] boardC = ArrayReader.readMatrix(directorio2 + "BoardC.txt");
    inicio = System.currentTimeMillis();
    boolean boardResultC = isValidBoard(boardC);
    fin = System.currentTimeMillis();
    System.out.println("El tablero C es válido: " + boardResultC);
    System.out.println(
      "El algoritmo 1 se tardó: " + (fin - inicio) + " milisegundos."
    );

    int[][] boardD = ArrayReader.readMatrix(directorio2 + "BoardD.txt");
    inicio = System.currentTimeMillis();
    boolean boardResultD = isValidBoard(boardD);
    fin = System.currentTimeMillis();
    System.out.println("El tablero D es válido: " + boardResultD);
    System.out.println(
      "El algoritmo 1 se tardó: " + (fin - inicio) + " milisegundos."
    );

    int[][] boardE = ArrayReader.readMatrix(directorio2 + "BoardE.txt");
    inicio = System.currentTimeMillis();
    boolean boardResultE = isValidBoard(boardE);
    fin = System.currentTimeMillis();
    System.out.println("El tablero B es válido: " + boardResultE);
    System.out.println(
      "El algoritmo 1 se tardó: " + (fin - inicio) + " milisegundos."
    );

    int[][] boardF = ArrayReader.readMatrix(directorio2 + "BoardF.txt");
    inicio = System.currentTimeMillis();
    boolean boardResultF = isValidBoard(boardF);
    fin = System.currentTimeMillis();
    System.out.println("El tablero C es válido: " + boardResultF);
    System.out.println(
      "El algoritmo 1 se tardó: " + (fin - inicio) + " milisegundos."
    );

    //-- SEGUNDO ALGORITMO

    //int[][] boardA = ArrayReader.readMatrix(directorio2 + "BoardA.txt");
    inicio = System.currentTimeMillis();
    boolean boardResultA2 = isValidBoardOptimizado(boardA);
    fin = System.currentTimeMillis();
    System.out.println("El tablero A es válido: " + boardResultA2);
    System.out.println(
      "El algoritmo 2 se tardó: " + (fin - inicio) + " milisegundos."
    );

    //int[][] boardB = ArrayReader.readMatrix(directorio2 + "BoardB.txt");
    inicio = System.currentTimeMillis();
    boolean boardResultB2 = isValidBoardOptimizado(boardB);
    fin = System.currentTimeMillis();
    System.out.println("El tablero B es válido: " + boardResultB2);
    System.out.println(
      "El algoritmo 2 se tardó: " + (fin - inicio) + " milisegundos."
    );

    //int[][] boardC = ArrayReader.readMatrix(directorio2 + "BoardC.txt");
    inicio = System.currentTimeMillis();
    boolean boardResultC2 = isValidBoardOptimizado(boardC);
    fin = System.currentTimeMillis();
    System.out.println("El tablero C es válido: " + boardResultC2);
    System.out.println(
      "El algoritmo 2 se tardó: " + (fin - inicio) + " milisegundos."
    );

    //int[][] boardD = ArrayReader.readMatrix(directorio2 + "BoardD.txt");
    inicio = System.currentTimeMillis();
    boolean boardResultD2 = isValidBoardOptimizado(boardD);
    fin = System.currentTimeMillis();
    System.out.println("El tablero D es válido: " + boardResultD2);
    System.out.println(
      "El algoritmo 2 se tardó: " + (fin - inicio) + " milisegundos."
    );

    //int[][] boardC = ArrayReader.readMatrix(directorio2 + "BoardC.txt");
    inicio = System.currentTimeMillis();
    boolean boardResultE2 = isValidBoardOptimizado(boardE);
    fin = System.currentTimeMillis();
    System.out.println("El tablero C es válido: " + boardResultE2);
    System.out.println(
      "El algoritmo 2 se tardó: " + (fin - inicio) + " milisegundos."
    );

    //int[][] boardD = ArrayReader.readMatrix(directorio2 + "BoardD.txt");
    inicio = System.currentTimeMillis();
    boolean boardResultF2 = isValidBoardOptimizado(boardF);
    fin = System.currentTimeMillis();
    System.out.println("El tablero D es válido: " + boardResultF2);
    System.out.println(
      "El algoritmo 2 se tardó: " + (fin - inicio) + " milisegundos."
    );

    // EJEMPLOS DE ACTIVIDAD 3
    System.out.println("\nEJEMPLOS DE ACTIVIDAD 3\n");


    inicio = System.currentTimeMillis();
    rotateArray(arrayA1, 5);
    fin = System.currentTimeMillis();
    System.out.println(
      "Arreglo A1 rotado 5 veces: " + Arrays.toString(arrayA1)
    );
    System.out.println(
      "El algoritmo 1 se tardó: " + (fin - inicio) + " milisegundos."
    );


    inicio = System.currentTimeMillis();
    rotateArray(arrayB1, 0);
    fin = System.currentTimeMillis();
    System.out.println(
      "Arreglo B1 rotado 0 veces: " + Arrays.toString(arrayB1)
    );
    System.out.println(
      "El algoritmo 1 se tardó: " + (fin - inicio) + " milisegundos."
    );


    inicio = System.currentTimeMillis();
    rotateArray(arrayC1, 6);
    fin = System.currentTimeMillis();
    System.out.println(
      "Arreglo C1 rotado 6 veces: " + Arrays.toString(arrayC1)
    );
    System.out.println(
      "El algoritmo 1 se tardó: " + (fin - inicio) + " milisegundos."
    );


    inicio = System.currentTimeMillis();
    rotateArray(arrayD1, 5);
    fin = System.currentTimeMillis();
    System.out.println(
      "Arreglo D1 rotado 5 veces: " + Arrays.toString(arrayD1)
    );
    System.out.println(
      "El algoritmo 1 se tardó: " + (fin - inicio) + " milisegundos."
    );

    inicio = System.currentTimeMillis();
    rotateArray(arrayE1, 0);
    fin = System.currentTimeMillis();
    System.out.println(
      "Arreglo E1 rotado 0 veces: " + Arrays.toString(arrayE1)
    );
    System.out.println(
      "El algoritmo 1 se tardó: " + (fin - inicio) + " milisegundos."
    );

    inicio = System.currentTimeMillis();
    rotateArray(arrayF1, 6);
    fin = System.currentTimeMillis();
    System.out.println(
      "Arreglo F1 rotado 6 veces: " + Arrays.toString(arrayF1)
    );
    System.out.println(
      "El algoritmo 1 se tardó: " + (fin - inicio) + " milisegundos."
    );

    //Segundo algoritmo----------------------------------

    inicio = System.currentTimeMillis();
    rotateArray(arrayA1, 5);
    fin = System.currentTimeMillis();
    System.out.println(
      "Arreglo A1 rotado 5 veces: " + Arrays.toString(arrayA1)
    );
    System.out.println(
      "El algoritmo 2 se tardó: " + (fin - inicio) + " milisegundos."
    );


    inicio = System.currentTimeMillis();
    rotateArray(arrayB1, 0);
    fin = System.currentTimeMillis();
    System.out.println(
      "Arreglo B1 rotado 0 veces: " + Arrays.toString(arrayB1)
    );
    System.out.println(
      "El algoritmo 2 se tardó: " + (fin - inicio) + " milisegundos."
    );

    inicio = System.currentTimeMillis();
    rotateArray(arrayC1, 6);
    fin = System.currentTimeMillis();
    System.out.println(
      "Arreglo C1 rotado 6 veces: " + Arrays.toString(arrayC1)
    );
    System.out.println(
      "El algoritmo 2 se tardó: " + (fin - inicio) + " milisegundos."
    );

    inicio = System.currentTimeMillis();
    rotateArray(arrayD1, 5);
    fin = System.currentTimeMillis();
    System.out.println(
      "Arreglo D1 rotado 5 veces: " + Arrays.toString(arrayD1)
    );
    System.out.println(
      "El algoritmo 2 se tardó: " + (fin - inicio) + " milisegundos."
    );

    inicio = System.currentTimeMillis();
    rotateArray(arrayE1, 0);
    fin = System.currentTimeMillis();
    System.out.println(
      "Arreglo E1 rotado 0 veces: " + Arrays.toString(arrayE1)
    );

    System.out.println(
      "El algoritmo 2 se tardó: " + (fin - inicio) + " milisegundos."
    );

    inicio = System.currentTimeMillis();
    rotateArray(arrayF1, 6);
    fin = System.currentTimeMillis();
    System.out.println(
      "Arreglo F1 rotado 6 veces: " + Arrays.toString(arrayF1)
    );
    System.out.println(
      "El algoritmo 2 se tardó: " + (fin - inicio) + " milisegundos."
    );

    System.out.println("\n\nFIN DE EJEMPLOS :) \n");
  }
}
