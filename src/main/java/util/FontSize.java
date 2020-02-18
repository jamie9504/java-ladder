package util;

public class FontSize {

    private final static String SPLIT_DELIMITER = "";
    private final static String KOREAN = "^[ㄱ-ㅎㅏ-ㅣ가-힣]*$";

    public static int getFontSize(String input) {
        String[] names = input.split(SPLIT_DELIMITER);
        int fontSize = 0;
        for (String name : names) {
            fontSize += getFontSizeByLanguage(name);
        }
        return fontSize;
    }

    private static int getFontSizeByLanguage(String name) {
        if (name.matches(KOREAN)) {
            return 2;
        }
        return 1;
    }
}
