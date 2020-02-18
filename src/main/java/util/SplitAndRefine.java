package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitAndRefine {

    private final static String SPLIT_DELIMITER = ",";
    private final static String REPLACE_REGEX_BLANK = ("  *");
    private final static String REPLACE_REGEX_MANY_SPLIT_DELIMITER =
        String.format("%s+", SPLIT_DELIMITER);
    private final static String REPLACE_REGEX_START_OR_END_SPLIT_DELIMITER =
        String.format("^ *%s|%s *$", SPLIT_DELIMITER, SPLIT_DELIMITER);
    private final static String BLANK = "";

    public static List<String> splitExceptJustBlankWithDelimiter(String names) {
        List<String> result = new ArrayList<>();
        String refineNames = exceptJustBlankWithDelimiter(names);
        result.addAll(Arrays.asList(refineNames.split(SPLIT_DELIMITER)));
        return result;
    }

    public static String exceptJustBlankWithDelimiter(String names) {
        String noBlankNames = names.replaceAll(REPLACE_REGEX_BLANK, BLANK);
        String noManySplitDelimiter = noBlankNames
            .replaceAll(REPLACE_REGEX_MANY_SPLIT_DELIMITER, SPLIT_DELIMITER);
        String noStartOrEndSplitDelimiter = noManySplitDelimiter
            .replaceAll(REPLACE_REGEX_START_OR_END_SPLIT_DELIMITER, BLANK);
        return noStartOrEndSplitDelimiter;
    }
}
