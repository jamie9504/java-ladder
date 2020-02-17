package controller;

import domain.Ladder;
import domain.LadderGameResult;
import domain.LadderSize;
import domain.Participants;
import domain.Products;

public class LadderGame {

    public static LadderGameResult start(Participants participants, Products products,
        LadderSize ladderHeight) {
        LadderSize ladderWidth = new LadderSize(participants.getCount());
        Ladder ladder = new Ladder(ladderHeight, ladderWidth);
        LadderGameResult ladderGameResult = new LadderGameResult(participants, products, ladder);
        return ladderGameResult;
    }
}
