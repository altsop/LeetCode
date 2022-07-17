public class SnakeCaseTextConverter {

    private static String convertToString(String text) {
        return text
                .trim()
                .replace(" ", "_")
                .toLowerCase();
    }

    public static void main(String[] args) {
        String originalText = "Letter Combinations of a Phone Number";
        String snakeCased = convertToString(originalText);
        System.out.println(snakeCased);
    }

}
