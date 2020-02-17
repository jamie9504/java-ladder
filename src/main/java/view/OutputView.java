package view;

import domain.Ladder;
import domain.LegProperties;
import domain.Participants;
import domain.Products;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public static void outputLadder(Participants participants, Ladder ladder, Products products) {
        System.out.println("사다리 게임을 실행합니다.\n");
        System.out.println(String.join("", formattingName(participants.getNames())));
        List<String> formattingLadders = formattingLadderHeight(ladder.getLadder());
        for (String formattingLadder : formattingLadders) {
            System.out.println(formattingLadder);
        }
        System.out.println(String.join("", formattingName(products.getNames())));
    }

    private static List<String> formattingName(List<String> names) {
        List<String> formattingNames = new ArrayList<>();
        for (String name : names) {
            formattingNames.add(String.format("%s%s%s", " [ ", name, " ] "));
        }
        return formattingNames;
    }

    private static List<String> formattingLadderHeight(List<List<LegProperties>> ladder) {
        List<String> formattingLadders = new ArrayList<>();
        for (List<LegProperties> ladderWidth : ladder) {
            formattingLadders.add(formattingLadderWidth(ladderWidth));
        }
        return formattingLadders;
    }

    private static String formattingLadderWidth(List<LegProperties> ladderWidth) {
        StringBuilder stringBuilder = new StringBuilder();
        for (LegProperties legProperties : ladderWidth) {
            stringBuilder.append(" ");
            stringBuilder.append(legProperties.getSign());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static void exceptionMessage(String message) {
        System.out.println(message);
    }
}
