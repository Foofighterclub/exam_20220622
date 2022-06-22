import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
  Given a string as standard input parse the string into a matrix

  args[0]: "{{1,2,3},{1,2,3},{1,2,3}}"

  RESULT: {
    {1, 2, 3},
    {1, 2, 3},
    {1, 2, 3}
  }
 */
public class ReadMatrix {

  public static void main(String[] args) {

    String inputValue = args[0];

    // Utilizzato array di dimensione fissa, non creata dinamicamente
    int[][] arrayResult = new int[3][3];

    Pattern arrayValuePattern = Pattern.compile(
        "\\{(\\{(\\d+)(\\,\\d+\\,\\d\\})*)(\\,\\{(\\d+)(\\,\\d+,\\d)*\\})*\\}");

    Matcher arrayMatcher = arrayValuePattern.matcher(inputValue);

    if (arrayMatcher.matches()) {

      printArray(populateArrayFromRegex(arrayResult, inputValue));

    } else {
      System.out.println("Invalid input format");
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

