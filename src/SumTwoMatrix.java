import java.util.Arrays;

/*
  Given two matrix of ints prints on standard output the sum of both matrix
  A: {
    {1, 2, 3},
    {1, 2, 3},
    {1, 2, 3}
  }

  B: {
    {1, 2, 3},
    {1, 2, 3},
    {1, 2, 3}
  }

  RESULT:
  {
    {2, 4, 6},
    {2, 4, 6},
    {2, 4, 6}
  }

  Result matrix must be printed and formatted as previously shown
 */
public class SumTwoMatrix {

  public static void main(String[] args) {

    int[][] firstInputMatrix = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
    int[][] secondInputMatrix = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};

    int[][] arrayResult = doCombineMatrixSum(firstInputMatrix, secondInputMatrix);

    printArray(arrayResult);
  }

  private static int[][] doCombineMatrixSum(int[][] firstMatrix, int[][] secondMatrix) {

    //Creo un nuovo array di risultato, con le stesse dimensioni del primo array, dando come presupposto che i due array in input abbiano le stesse
    //dimensioni.
    int[][] arrayResult = new int[firstMatrix.length][firstMatrix[0].length];

    for (int i = 0; i < arrayResult.length; i++) {
      for (int j = 0; j < arrayResult[i].length; j++) {
        arrayResult[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
      }
    }

    return arrayResult;
  }

  private static void printArray(int[][] inputArray) {

    System.out.println("{");

    for (int i = 0; i < inputArray.length; i++) {
      System.out.printf("{");
      for (int j = 0; j < inputArray[i].length - 1; j++) {
        System.out.printf("%s, ", inputArray[i][j]);
      }
      System.out.printf("%s", inputArray[i][inputArray[i].length - 1]);
      System.out.printf("},");
      System.out.println("");
    }
    System.out.println("}");

  }

}