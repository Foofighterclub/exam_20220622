
/*
  Given a single matrix of ints prints on standard output the sum of all int contained in the matrix
  A: {
    {2, 4, 6},
    {2, 4, 6},
    {2, 4, 6}
  }

  RESULT: 36
 */
public class SumMatrixValues {

  public static void main(String[] args) {

    int[][] inputMatrix = new int[][]{{2, 4, 6}, {2, 4, 6}, {2, 4, 6}};

    int result = 0;

    for (int i = 0; i < inputMatrix.length; i++) {
      for (int j = 0; j < inputMatrix[i].length; j++) {
        result += inputMatrix[i][j];
      }
    }

    System.out.printf("RESULT: %s", result);

  }
}