import java.util.TreeMap;

class ArabicToRoman {
    static String convert(int arabic) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(60, "LX");
        map.put(70, "LXX");
        map.put(80, "LXXX");
        map.put(90, "XC");
        map.put(100, "C");

        StringBuilder sb = new StringBuilder();
        while (arabic > 0) {
            int l =  map.floorKey(arabic);
            sb.append(map.get(l));
            arabic -= l;
        }
        return sb.toString();
    }
}