import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите выражение для вычисления");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        System.out.println(calc(expression));
    }
    public static String calc(String input){
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
                System.out.println("throws Exception 4");
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
                    System.out.println("throws Exception 3");//Не верный знак операции
                }
                if (aIsRoman && bIsRoman) {
                    if (c > 0){
                        result = intToRome(c);
                    } else {
                        System.out.println("throws Exception 2");//отрицательное Римское число
                    }
                } else {
                    result = String.valueOf(c);
                }
            }
        } catch(Exception ex) {
            System.out.println("throws Exception 1");
        }
        return result;
    }
    public static String intToRome(int num) {
        String romeNumber = "";
        for (RomanNumeral roman : RomanNumeral.values()){
            if (roman.getValue() == num) {
                romeNumber = roman.getKey();
            }
        }
        return romeNumber;
    }
}