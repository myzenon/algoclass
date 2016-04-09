public class StringMatching {

    public static int stringMatching(String original, String match) {
        for (int i = 0; i < original.length() - match.length(); i++) {
            int j = 0;
            while(j < match.length() && original.charAt(i + j) == match.charAt(j)) {
                j++;
            }
            if(j == match.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String original = "ACESABCADE";
        String match = "ABC";
        System.out.println("Find " + match + " in " + original);
        System.out.println("The first character of " + match + " in " + original + " Start At " + (stringMatching(original, match) + 1));
    }

}
