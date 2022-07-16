public class SnakeCaseTextConverter {

    private static String convertToString(String text) {
        return text
                .trim()
                .replace(" ", "_")
                .toLowerCase();
    }

    public static void main(String[] args) {
        String originalText = "  Merge Sorted Array\n" +
                "\n";
        String snakeCased = convertToString(originalText);
        System.out.println(snakeCased);
    }

}
