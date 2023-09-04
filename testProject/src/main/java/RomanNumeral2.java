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
            }
        }
        return result;
    }
}


