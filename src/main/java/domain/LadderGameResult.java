package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGameResult {

    private final Participants gameParticipants;
    private final Products gameProducts;
    private final Ladder gameLadder;
    private final Map<Item, Item> gameResult;

    public LadderGameResult(Participants gameParticipants, Products gameProducts, Ladder gameLadder) {
        this.gameParticipants = gameParticipants;
        this.gameProducts = gameProducts;
        this.gameLadder = gameLadder;
        this.gameResult = calc(gameParticipants, gameProducts, gameLadder);
    }

    public Participants getGameParticipants() {
        return gameParticipants;
    }

    public Products getGameProducts() {
        return gameProducts;
    }

    public Ladder getGameLadder() {
        return gameLadder;
    }

    private Map<Item, Item> calc(Participants participants, Products products, Ladder ladder) {
        Map<Item, Item> names = new LinkedHashMap<>();
        int size = participants.getNames().size();
        for (int i = 0; i < size; i++) {
            int result = calcResult(0, i, ladder);
            names.put(participants.getItems().get(i), products.getItems().get(result));
        }
        return names;
    }

    private int calcResult(int heightPoint, int widthPoint, Ladder ladder) {
        List<List<LegProperties>> ladders = ladder.getLadder();
        if (ladders.size() == heightPoint) {
            return widthPoint;
        }
        List<LegProperties> ladderHeight = ladders.get(heightPoint);
        if (ladderHeight.get(widthPoint) == LegProperties.RIGHT) {
            return calcResult(++heightPoint, ++widthPoint, ladder);
        }
        if (ladderHeight.get(widthPoint) == LegProperties.CENTER) {
            return calcResult(++heightPoint, widthPoint, ladder);
        }
        if (ladderHeight.get(widthPoint) == LegProperties.LEFT) {
            return calcResult(++heightPoint, --widthPoint, ladder);
        }
        return 0;
    }

    public Map<Item, Item> getResultAll() {
        return gameResult;
    }

    public Map<Item, Item> getResultByParticipants(Participants participants) {
        List<Item> itemSources = participants.getItems();
        Map<Item, Item> result = new LinkedHashMap<>();
        for (Item item : itemSources) {
            result.putAll(getResultByParticipant((Participant) item));
        }
        return result;
    }

    public Map<Item, Item> getResultNotDummy() {
        Map<Item, Item> result = new LinkedHashMap<>();
        for(Item item : gameResult.keySet()) {
            if(!this.gameResult.get(item).getName().equals("X")) {
                result.put(item, gameResult.get(item));
                System.out.println(item.getName());
            }
        }
        return result;
    }

    public Map<Item, Item> getResultByParticipant(Participant participant) {
        List<Item> items = gameParticipants.getItems();
        Map<Item, Item> result = new LinkedHashMap<>();
        if (!items.contains(participant)) {
            throw new IllegalArgumentException("없잖아!!!");
        }
        for(Item item : gameParticipants.getItems()) {
            if(participant.equals(item)) {
                result.put(item, gameResult.get(item));
            }
        }
        return result;
    }
}
