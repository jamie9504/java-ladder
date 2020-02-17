package view;

import domain.Ladder;
import domain.LegProperties;
import domain.Participants;
import domain.Products;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private final static String MAKE_LEG_NO_SIGN = " ";
    private final static String MAKE_LEG_YES_SIGN = "-";

    public static void outputLadder(Participants participants, Ladder ladder, Products products) {
        System.out.println("사다리 게임을 실행합니다.\n");
        int nameLengthFormatCriteria = Math
            .max(participants.getMaxNameLength(), products.getMaxNameLength());
        System.out.println(formattingName(participants.getNames(), nameLengthFormatCriteria));
        System.out.print(formattingLadderHeight(ladder.getLadder(), nameLengthFormatCriteria));
        System.out.println(formattingName(products.getNames(), nameLengthFormatCriteria));
    }

    private static String formattingName(List<String> names, int nameLengthFormatCriteria) {
        StringBuilder formattingNames = new StringBuilder();
        for (String name : names) {
            formattingNames.append(String.format(" [ %-" + nameLengthFormatCriteria + "s ]", name));
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
        int betweenSignCount = (nameLengthFormatCriteria + 5) / 2;
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
}
