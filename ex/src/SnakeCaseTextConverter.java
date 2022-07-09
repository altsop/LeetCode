public class SnakeCaseTextConverter {

    private static String convertToString(String text) {
        return text.replace(" ", "_").toLowerCase();
    }

    public static void main(String[] args) {
        String originalText = "Number of Steps to Reduce a Number to Zero";
        String snakeCased = convertToString(originalText);
        System.out.println(snakeCased);
    }

}
