enum RomanNumeral2 {
    I(1), V(5), X(10), L(50), C(100);

    private int value;

    RomanNumeral2(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static int romanToArabic(String str) {
        char[] ch = str.toCharArray();
        int result = 0;
        if (ch.length >= 1) {
            result = convert(ch[ch.length - 1]);
            byte minusCount = 0;
            byte duplicateCount = 0;
            boolean blockD = true;
            boolean blockM = true;
            for (int i = ch.length - 1; i > 0; i--) {
                if (ch[i-1] == ch[i] && duplicateCount < 3 && blockD && // d
                        ch[i-1] != RomanNumeral2.V.toString().charAt(0) &&
                        ch[i-1] != RomanNumeral2.L.toString().charAt(0)) {
                    blockM = false;
                    duplicateCount++;
                    result += convert(ch[i-1]);
                } else if(convert(ch[i-1]) > convert(ch[i])) { // +
                    blockD = true;
                    blockM = true;
                    duplicateCount = 0;
                    minusCount = 0;
                    result += convert(ch[i-1]);
                } else if (convert(ch[i-1]) < convert(ch[i]) && minusCount < 2 && blockM &&
                        (((String.valueOf(ch[i]).equals("V") || String.valueOf(ch[i]).equals("X")) && (String.valueOf(ch[i-1]).equals("I"))) ||
                        ((String.valueOf(ch[i]).equals("C") || String.valueOf(ch[i]).equals("L")) && (String.valueOf(ch[i-1]).equals("X"))))) { // -
                    blockD = false;
                    minusCount++;
                    result -= convert(ch[i-1]);
                } else {
                    System.out.println("Ошибка ввода символов");
                }
            }
        }
        else {
            System.out.println("нет символов");
        }
        return result;
    }

    public static int convert(char ch) {
        int result = 0;
        for (int i = 0; i < RomanNumeral2.values().length; i++) {
            if (RomanNumeral2.values()[i].toString().equals(String.valueOf(ch))){
                result = RomanNumeral2.values()[i].getValue();
                break;
            }
        }
        return result;
    }

    public static String arabicToRoman(int num) {
        int len = String.valueOf(num).length();
        char[] ch = String.valueOf(num).toCharArray();
        int str;
        String stringResult = "";
        for (int i = 1; i <= len; i++) {
            str = Integer.parseInt(String.valueOf(ch[len - i]));
            switch (str) {
                case 0: ;
                    break;
                case 1:
                    if (i == 1) {
                        stringResult = RomanNumeral2.I.toString() + stringResult;
                    } else if(i == 2) {
                        stringResult = RomanNumeral2.X.toString() + stringResult;
                    } else if (i == 3) {
                        stringResult = RomanNumeral2.C.toString() + stringResult;
                    };
                    break;
                case 2:
                    if (i == 1) {
                        stringResult = RomanNumeral2.I.toString().repeat(2) + stringResult;
                    } else if(i == 2) {
                        stringResult = RomanNumeral2.X.toString().repeat(2) + stringResult;
                    } else if (i == 3) {
                        stringResult = RomanNumeral2.C.toString().repeat(2) + stringResult;
                    };
                    break;
                case 3:
                    if (i == 1) {
                        stringResult = RomanNumeral2.I.toString().repeat(3) + stringResult;
                    } else if(i == 2) {
                        stringResult = RomanNumeral2.X.toString().repeat(3) + stringResult;
                    } else if (i == 3) {
                        stringResult = RomanNumeral2.C.toString().repeat(3) + stringResult;
                    };
                    break;
                case 4:
                    if (i == 1) {
                        stringResult = RomanNumeral2.I.toString() + RomanNumeral2.V.toString() + stringResult;
                    } else if(i == 2) {
                        stringResult = RomanNumeral2.X.toString() + RomanNumeral2.L.toString() + stringResult;
                    };
                    break;
                case 5:
                    if (i == 1) {
                        stringResult = RomanNumeral2.V.toString() + stringResult;
                    } else if(i == 2) {
                        stringResult = RomanNumeral2.L.toString() + stringResult;
                    };
                    break;
                case 6:
                    if (i == 1) {
                        stringResult = RomanNumeral2.V.toString() + RomanNumeral2.I.toString() + stringResult;
                    } else if(i == 2) {
                        stringResult = RomanNumeral2.L.toString() + RomanNumeral2.X.toString() + stringResult;
                    };
                    break;
                case 7:
                    if (i == 1) {
                        stringResult = RomanNumeral2.V.toString() + RomanNumeral2.I.toString().repeat(2) + stringResult;
                    } else if(i == 2) {
                        stringResult = RomanNumeral2.L.toString() + RomanNumeral2.X.toString().repeat(2) + stringResult;
                    };
                    break;
                case 8:
                    if (i == 1) {
                        stringResult = RomanNumeral2.V.toString() + RomanNumeral2.I.toString().repeat(3) + stringResult;
                    } else if(i == 2) {
                        stringResult = RomanNumeral2.L.toString() + RomanNumeral2.X.toString().repeat(3) + stringResult;
                    };
                    break;
                case 9:
                    if (i == 1) {
                        stringResult = RomanNumeral2.I.toString() + RomanNumeral2.X.toString() + stringResult;
                    } else if(i == 2) {
                        stringResult = RomanNumeral2.X.toString() + RomanNumeral2.C.toString() + stringResult;
                    };
                    break;
            }
        }
        return stringResult;
    }
}


