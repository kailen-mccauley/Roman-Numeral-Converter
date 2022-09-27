import java.util.Scanner;
public class RomanNumeral {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello welcome to Roman Numeral Converter!");
        System.out.print("Enter a roman numeral you want to covert: ");
        String romanNumeral = scanner.next().trim().toUpperCase();
        int number = convert(romanNumeral);
        if (number == -1) {
            System.out.println("The Roman Numeral you entered does not exist!");
        } else {
            System.out.println("The numeral you entered equals: " + number);
        }
    }
    public static int convert(String romanNumeral) {
        int sum = 0;
        String helper = romanNumeral;
        String[][] numerals =
            {{"MMM", "MM", "M"},
            {"CM", "DCCC", "DCC", "DC", "D", "CD", "CCC", "CC", "C"},
            {"XC", "LXXX", "LXX", "LX", "L", "XL", "XXX", "XX", "X"},
            {"IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"}};
        int[][] decimals =
            {{3000, 2000, 1000},
            {900, 800, 700, 600, 500, 400, 300, 200, 100},
            {90, 80, 70, 60, 50, 40, 30, 20, 10},
            {9, 8, 7, 6, 5, 4, 3, 2, 1}};
        String[] values = loopThrough(numerals[0], decimals[0], helper);
        sum += Integer.parseInt(values[0]);
        helper = values[1];
        values = loopThrough(numerals[1], decimals[1], helper);
        sum += Integer.parseInt(values[0]);
        helper = values[1];
        values = loopThrough(numerals[2], decimals[2], helper);
        sum += Integer.parseInt(values[0]);
        helper = values[1];
        values = loopThrough(numerals[3], decimals[3], helper);
        sum += Integer.parseInt(values[0]);
        helper = values[1];
        if (helper.length() > 0) {
            sum = -1;
        }
        return sum;
    }
    public static String[] loopThrough(String[] roman, int[] decimal, String romanNumeral) {
        int sum = 0;
        String helper = romanNumeral;
        for (int i = 0; i < roman.length; i++) {
            if (helper.indexOf(roman[i]) == 0) {
                sum += decimal[i];
                helper = helper.substring(roman[i].length());
            }
        }
        String[] returnValues = {String.valueOf(sum), helper};
        return returnValues;
    }
}
