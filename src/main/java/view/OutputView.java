package view;

import domain.Item;
import domain.Ladder;
import domain.LadderGameResult;
import domain.LegProperties;
import domain.Participant;
import domain.Participants;
import domain.Products;
import java.util.List;
import java.util.Map;

public class OutputView {

    private final static String MAKE_LEG_NO_SIGN = " ";
    private final static String MAKE_LEG_YES_SIGN = "-";
    private final static String NEW_LINE = "\n";
    private final static String BLANK = " ";
    private final static String SQUARE_BRACKETS_OPEN = "[";
    private final static String SQUARE_BRACKETS_CLOSE = "]";
    private final static String DELIMITER = ":";

    public static void outputLadder(LadderGameResult ladderGameResult) {
        Participants participants = ladderGameResult.getGameParticipants();
        Ladder ladder = ladderGameResult.getGameLadder();
        Products products = ladderGameResult.getGameProducts();

        System.out.println("\n사다리 게임을 실행합니다.\n");
        int nameLengthFormatCriteria = Math
            .max(participants.getMaxNameSize(), products.getMaxNameSize());

        System.out.println(formattingName(participants.getItems(), nameLengthFormatCriteria));
        System.out.print(formattingLadderHeight(ladder.getLadder(), nameLengthFormatCriteria));
        System.out.println(formattingName(products.getItems(), nameLengthFormatCriteria));
    }

    private static String formattingName(List<Item> items, int nameLengthFormatCriteria) {
        StringBuilder formattingNames = new StringBuilder();
        for (Item item : items) {
            int blankCount = (nameLengthFormatCriteria - item.getNameSize()) / 2 + 1;
            String blankBetween = String
                .format("%".concat(String.valueOf(blankCount)).concat("s"), BLANK);
            formattingNames.append(SQUARE_BRACKETS_OPEN)
                .append(blankBetween)
                .append(item.getName())
                .append(blankBetween)
                .append(SQUARE_BRACKETS_CLOSE)
                .append(BLANK);
        }
        return formattingNames.toString();
    }

    private static String formattingLadderHeight(List<List<LegProperties>> ladder,
        int nameLengthFormatCriteria) {
        StringBuilder formattingLadders = new StringBuilder();
        for (List<LegProperties
            > ladderWidth : ladder) {
            formattingLadders.append(formattingLadderWidth(ladderWidth, nameLengthFormatCriteria));
            formattingLadders.append(NEW_LINE);
        }
        return formattingLadders.toString();
    }

    private static String formattingLadderWidth(List<LegProperties> ladderWidth,
        int nameLengthFormatCriteria) {
        StringBuilder stringBuilder = new StringBuilder();
        for (LegProperties legProperties : ladderWidth) {
            stringBuilder
                .append(formattingLadderProperties(legProperties, nameLengthFormatCriteria));
        }
        return stringBuilder.toString();
    }

    private static String formattingLadderProperties(LegProperties legProperties,
        int nameLengthFormatCriteria) {
        int betweenSignCount = (nameLengthFormatCriteria + 4) / 2;
        String blankLeg = String
            .format("%".concat(String.valueOf(betweenSignCount)).concat("s"), MAKE_LEG_NO_SIGN);
        String hyphenLeg = blankLeg.replace(MAKE_LEG_NO_SIGN, MAKE_LEG_YES_SIGN);
        return drawALeg(legProperties, blankLeg, hyphenLeg);
    }

    private static String drawALeg(LegProperties legProperties, String blankLeg, String hyphenLeg) {
        if (legProperties == LegProperties.CENTER) {
            return blankLeg.concat(legProperties.getSign()).concat(blankLeg);
        }
        if (legProperties == LegProperties.LEFT) {
            return hyphenLeg.concat(legProperties.getSign()).concat(blankLeg);
        }
        if (legProperties == LegProperties.RIGHT) {
            return blankLeg.concat(legProperties.getSign()).concat(hyphenLeg);
        }
        throw new IllegalArgumentException();
    }

    public static void exceptionMessage(String message) {
        System.out.println(message);
    }

    public static void outputResultAll(LadderGameResult ladderGameResult) {
        Map<Item, Item> items = ladderGameResult.getResultAll();
        printMaps(items);
    }

    public static void outputResultNotDummy(LadderGameResult ladderGameResult) {
        Map<Item, Item> items = ladderGameResult.getResultNotDummy();
        printMaps(items);
    }

    private static void printMaps(Map<Item, Item> items) {
        System.out.println();
        for (Item participant : items.keySet()) {
            System.out.print(participant.getName());
            System.out.print(BLANK);
            System.out.print(DELIMITER);
            System.out.print(BLANK);
            System.out.println(items.get(participant).getName());
        }
    }

    public static void outputResultByParticipants(LadderGameResult ladderGameResult,
        Participants participants) {
        Map<Item, Item> items = ladderGameResult.getResultByParticipants(participants);
        printMaps(items);
    }

    public static void outputResultByParticipant(LadderGameResult ladderGameResult,
        Participant participant) {
        Map<Item, Item> items = ladderGameResult.getResultByParticipant(participant);
        printMaps(items);
    }
}
