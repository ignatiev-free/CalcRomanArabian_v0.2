import java.util.TreeMap;

class RomanToArabic {
    static int convert(String roman) {

        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);

        int i = 0, result = 0;
        while (i < roman.length()) {
            if (i == roman.length() - 1) {
                result += map.get(roman.substring(i, i + 1));
                break;
            }
            String doubleSymbol = roman.substring(i, i + 2);
            if (map.containsKey(doubleSymbol)) {
                result += map.get(doubleSymbol);
                i += 2;
            } else {
                result += map.get(roman.substring(i, i + 1));
                i++;
            }
        }
        return result;
    }
}
