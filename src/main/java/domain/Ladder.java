package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private static final Random random = new Random();
    private final List<List<LegProperties>> ladder;

    public Ladder(LadderSize height, LadderSize width) {
        ladder = makeLadderByHeight(height.getSize(), width.getSize());
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
        ladder.add(drawStartLeg(isDrawingByRandom()));
        for (int i = 1; i < width - 1; i++) {
            ladder.add(drawMiddleLeg(isDrawingByRandom(), ladder.get(i - 1)));
        }
        ladder.add(drawEndLeg(ladder.get(width - 2)));
        return ladder;
    }

    private LegProperties drawStartLeg(boolean isDrawing) {
        if (isDrawing == true) {
            return LegProperties.START_RIGHT;
        }
        return LegProperties.START_CENTER;
    }

    private LegProperties drawMiddleLeg(boolean isDrawing, LegProperties beforeLegProperties) {
        if (beforeLegProperties.getMoving() == 1) {
            return LegProperties.MIDDLE_LEFT;
        }
        if (isDrawing == true) {
            return LegProperties.MIDDLE_RIGHT;
        }
        return LegProperties.MIDDLE_CENTER;
    }

    private LegProperties drawEndLeg(LegProperties beforeLegProperties) {
        if (beforeLegProperties.getMoving() == 1) {
            return LegProperties.END_LEFT;
        }
        return LegProperties.END_CENTER;

    }

    private boolean isDrawingByRandom() {
        return random.nextBoolean();
    }

    public List<List<LegProperties>> getLadder() {
        return ladder;
    }
}
