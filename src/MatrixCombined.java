import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
  Given two string as standard input parse them as matrix,
  Then sum both matrix
  And pretty print on stdout the result matrix
  Then print the sum of matrix result values
 */
public class MatrixCombined {

  public static void main(String[] args) {

    Pattern arrayValuePattern = Pattern.compile(
        "\\{(\\{(\\d+)(\\,\\d+\\,\\d\\})*)(\\,\\{(\\d+)(\\,\\d+,\\d)*\\})*\\}");

    if (args.length == 2) {
      if (arrayValuePattern.matcher(args[0]).matches() && arrayValuePattern.matcher(args[1])
          .matches()) {

        // Utilizzato array di dimensione fissa, non creata dinamicamente
        int[][] emptyArray = new int[3][3];

        int[][] firstArray = populateArrayFromRegex(emptyArray, args[0]);

        //Azzero l'array emptyArray;
        emptyArray = new int[3][3];

        int[][] secondArray = populateArrayFromRegex(emptyArray, args[1]);

        int[][] arrayResult = doCombineMatrixSum(firstArray, secondArray);

        printArray(arrayResult);


      } else {
        System.out.println(
            "Una delle due stringhe in input non rispetta la corretta formattazione per la creazione array");
      }

    } else {
      System.out.println("Input string not valid");
    }

  }

  private static int[][] populateArrayFromRegex(int[][] inputArray, String inputString) {

    Pattern rowPattern = Pattern.compile("((\\d+)(\\,\\d+\\,\\d)*)");
    Matcher rowMatcher = rowPattern.matcher(inputString);

    int rowIndex = 0;

    while (rowMatcher.find()) {
      String row = rowMatcher.group(1);
      String[] rowValue = row.split(",");
      for (int i = 0; i < inputArray[rowIndex].length; i++) {
        inputArray[rowIndex][i] = Integer.parseInt(rowValue[i]);
      }
      rowIndex += 1;
    }

    return inputArray;
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
      System.out.printf("   {");
      for (int j = 0; j < inputArray[i].length - 1; j++) {
        System.out.printf("%s, ", inputArray[i][j]);
      }
      System.out.printf("%s", inputArray[i][inputArray[i].length - 1]);
      System.out.printf("}%s", i != inputArray.length - 1 ? "," : "");
      System.out.println("");
    }
    System.out.println("}");

  }

}