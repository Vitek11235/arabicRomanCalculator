import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение для вычисления");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        System.out.println(calc(expression));
        scanner.close();
//        System.out.println(RomanNumeral2.romanToArabic("IC"));
    }
    public static String calc(String input) throws Exception {
        int a = 0;
        int b = 0;
        int c = 0;
        String result = "";
        boolean aIsRoman = false;
        boolean bIsRoman = false;
        String[] array = new String[0];
        try{
            array = input.split(" ");
            for (RomanNumeral roman : RomanNumeral.values()){
                if (array[0].equals(roman.toString())) {
                    a = roman.getValue();
                    aIsRoman = true;
                }
                if (array[2].equals(roman.toString())) {
                    b = roman.getValue();
                    bIsRoman = true;
                }
            }
            if (!aIsRoman  && !bIsRoman){
                a = Integer.parseInt(array[0]);
                b = Integer.parseInt(array[2]);
            }
            if((aIsRoman && !bIsRoman) || (!aIsRoman  && bIsRoman) || a > 10 || b > 10 || a < 1 || b < 1 || array.length > 3) {
                throw new Exception("throws Exception 4");
            } else {
                if (array[1].equals("+")){
                    c = a + b;
                } else if(array[1].equals("-")){
                    c = a - b;
                } else if(array[1].equals("*")){
                    c = a * b;
                } else if(array[1].equals("/")){
                    c = a / b;
                } else {
                    throw new Exception("throws Exception 3");//Не верный знак операции
                }
                if (aIsRoman && bIsRoman) {
                    if (c > 0){
                        result = RomanNumeral.intToRome(c);
                    } else {
                        throw new Exception("throws Exception 2");//отрицательное Римское число
                    }
                } else {
                    result = String.valueOf(c);
                }
            }
        } catch(Exception ex) {
            throw new Exception("throws Exception 1");
        }
        return result;
    }
}