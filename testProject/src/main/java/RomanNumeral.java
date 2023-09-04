enum RomanNumeral {
    I("I",1), II("II",2), III("III",3), IV("IV",4), V("V",5),
    VI("VI",6), VII("VII",7), VIII("VIII",8), IX("IX",9), X("X",10),
    XI("XI",11), XII("XII",12), XIII("XIII",13), XIV("XIV",14), XV("XV",15),
    XVI("XVI",16), XVII("XVII",17), XVIII("XVIII",18), XIX("XIX",19), XX("XX",20),
    XXI("XXI",21), XXII("XXII",22), XXIII("XXIII",23), XXIV("XXIV",24), XXV("XXV",25),
    XXVI("XXVI",26), XXVII("XXVII",27), XXVIII("XXVIII",28), XXIX("IX",29), XXX("X",30),
    XXXI("XXXI",31), XXXII("XXXII",32), XXXIII("XXXIII",33), XXXIV("XXXIV",34), XXXV("XXXV",35),
    XXXVI("XXXVI",36), XXXVII("XXXVII",37), XXXVIII("XXXVIII",38), XXXIX("XXXIX",39), XL("XL",40),
    XLI("XLI",41), XLII("XLII",42), XLIII("XLIII",43), XLIV("XLIV",44), XLV("XLV",45),
    XLVI("XLVI",46), XLVII("XLVII",47), XLVIII("XLVIII",48), XLIX("XLIX",49), L("L",50),
    LI("LI",51), LII("LII",52), LIII("LIII",53), LIV("LIV",54), LV("LV",55),
    LVI("LVI",56), LVII("LVII",57), LVIII("LVIII",58), LIX("LIX",59), LX("LX",60),
    LXI("LXI",61), LXII("LXII",62), LXIII("LXIII",63), LXIV("LXIV",64), LXV("LXV",65),
    LXVI("LXVI",66), LXVII("LXVII",67), LXVIII("LXVIII",68), LXIX("LXIX",69), LXX("LXX",70),
    LXXI("XI",71), LXXII("XII",72), LXXIII("XIII",73), LXXIV("XIV",74), LXXV("XV",75),
    LXXVI("XVI",76), LXXVII("XVII",77), LXXVIII("XVIII",78), LXXIX("XIX",79), LXXX("XX",80),
    LXXXI("LXXXI",81), LXXXII("LXXXII",82), LXXXIII("LXXXIII",83), LXXXIV("LXXXIV",84), LXXXV("LXXXV",85),
    LXXXVI("LXXXVI",86), LXXXVII("LXXXVII",87), LXXXVIII("LXXXVIII",88), LXXXIX("LXXXIX",89), XC("XC",90),
    XCI("XCI",91), XCII("XCII",92), XCIII("XCIII",93), XCIV("XCIV",94), XCV("XCV",95),
    XCVI("XCVI",96), XCVII("XCVII",97), XCVIII("XCVIII",98), XCIX("XCIX",99), C("С",100);

    private int value;
    private String key;

    RomanNumeral(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getKey() {
        return key;
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
