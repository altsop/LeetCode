public class SnakeCaseTextConverter {

    private static String convertToString(String text) {
        return text
                .trim()
                .replace(" ", "_")
                .toLowerCase();
    }

    public static void main(String[] args) {
        String originalText = "Isomorphic Strings";
        String snakeCased = convertToString(originalText);
        System.out.println(snakeCased);
    }

}
