package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGameResult {

    private final Participants participants;
    private final Products products;
    private final Ladder ladder;
    private final Map<Item, Item> result;

    public LadderGameResult(Participants participants, Products products, Ladder ladder) {
        this.participants = participants;
        this.products = products;
        this.ladder = ladder;
        this.result = calc(participants, products, ladder);
    }

    public Participants getParticipants() {
        return participants;
    }

    public Products getProducts() {
        return products;
    }

    public Ladder getLadder() {
        return ladder;
    }

    private Map<Item, Item> calc(Participants participants, Products products, Ladder ladder) {
        Map<Item, Item> names = new LinkedHashMap<>();
        int size = participants.getNames().size();
        for(int i = 0; i < size; i++) {
            int result = calcResult(0, i, ladder);
            names.put(participants.getItems().get(i), products.getItems().get(result));
        }
        return names;
    }

    private int calcResult(int heightPoint, int widthPoint, Ladder ladder) {
        List<List<LegProperties>> ladders = ladder.getLadder();
        if(ladders.size() == heightPoint) {
            return widthPoint;
        }
        List<LegProperties> ladderHeight = ladders.get(heightPoint);
        if(ladderHeight.get(widthPoint) == LegProperties.RIGHT) {
            return calcResult(++heightPoint, ++widthPoint, ladder);
        }
        if(ladderHeight.get(widthPoint) == LegProperties.CENTER) {
            return calcResult(++heightPoint, widthPoint, ladder);
        }
        if(ladderHeight.get(widthPoint) == LegProperties.LEFT) {
            return calcResult(++heightPoint, --widthPoint, ladder);
        }
        return 0;
    }

//    public Map<Item, Item> viewByParticipant(String participantName) {
//        if(participantName == "ALL") {
//            return result;
//        }
//        if(participantName.contains(",")) {
//
//        }
//
//    }
}
