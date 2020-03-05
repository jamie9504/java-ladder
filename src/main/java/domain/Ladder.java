package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private static final Random random = new Random();

    private final List<List<LegProperties>> ladder;

    public Ladder(LadderSize height, LadderSize width) {
        this.ladder = makeLadderByHeight(height.getSize(), width.getSize());
    }

    private List<List<LegProperties>> makeLadderByHeight(int height, int width) {
        List<List<LegProperties>> ladder = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            ladder.add(makeLadderBySize(width));
        }
        return ladder;
    }

    private List<LegProperties> makeLadderBySize(int width) {
        List<LegProperties> ladder = new ArrayList<>(width);
        ladder.add(drawLeg(isDrawingByRandom(), LegProperties.CENTER));
        for (int i = 1; i < width - 1; i++) {
            ladder.add(drawLeg(isDrawingByRandom(), ladder.get(i - 1)));
        }
        ladder.add(drawLeg(false, ladder.get(width - 2)));
        return ladder;
    }

    private LegProperties drawLeg(boolean isDrawing, LegProperties beforeLegProperties) {
        if (beforeLegProperties.getMoving() == LegProperties.RIGHT.getMoving()) {
            return LegProperties.LEFT;
        }
        if (isDrawing == true) {
            return LegProperties.RIGHT;
        }
        return LegProperties.CENTER;
    }

    private boolean isDrawingByRandom() {
        return random.nextBoolean();
    }

    public List<List<LegProperties>> getLadder() {
        return ladder;
    }
}
