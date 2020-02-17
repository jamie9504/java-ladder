package view;

import domain.Item;
import domain.Ladder;
import domain.LadderGameResult;
import domain.LegProperties;
import domain.Participants;
import domain.Products;
import java.util.List;

public class OutputView {

    private final static String MAKE_LEG_NO_SIGN = " ";
    private final static String MAKE_LEG_YES_SIGN = "-";

    public static void outputLadder(LadderGameResult ladderGameResult) {
        Participants participants = ladderGameResult.getParticipants();
        Ladder ladder = ladderGameResult.getLadder();
        Products products = ladderGameResult.getProducts();

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
            String justBlank = String.format("%" + blankCount + "s", " ");
            formattingNames.append("[" + justBlank + item.getName() + justBlank + "] ");
        }
        return formattingNames.toString();
    }

    private static String formattingLadderHeight(List<List<LegProperties>> ladder,
        int nameLengthFormatCriteria) {
        StringBuilder formattingLadders = new StringBuilder();
        for (List<LegProperties> ladderWidth : ladder) {
            formattingLadders.append(formattingLadderWidth(ladderWidth, nameLengthFormatCriteria));
            formattingLadders.append("\n");
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
        String justBlank = String.format("%" + betweenSignCount + "s", MAKE_LEG_NO_SIGN);
        String justHyphen = justBlank.replace(MAKE_LEG_NO_SIGN, MAKE_LEG_YES_SIGN);
        return makeALeg(legProperties, justBlank, justHyphen);
    }

    private static String makeALeg(LegProperties legProperties, String justBlank,
        String justHyphen) {
        if (legProperties == LegProperties.CENTER) {
            return justBlank + legProperties.getSign() + justBlank;
        }
        if (legProperties == LegProperties.LEFT) {
            return justHyphen + legProperties.getSign() + justBlank;
        }
        if (legProperties == LegProperties.RIGHT) {
            return justBlank + legProperties.getSign() + justHyphen;
        }
        throw new IllegalArgumentException("갑자기?");
    }

    public static void exceptionMessage(String message) {
        System.out.println(message);
    }

    public static void viewAllByParticipant(LadderGameResult ladderGameResult) {

    }
}
