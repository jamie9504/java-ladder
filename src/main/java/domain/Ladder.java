package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private final List<byte[]> ladder;

    public Ladder(LadderHeight height, int size) {
        ladder = makeLadderByHeight(height.getHeight(), size);
    }

    private List<byte[]> makeLadderByHeight(int height, int size) {
        List<byte[]> ladder = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            ladder.add(makeLadderBySize(size));
            System.out.print(i + " : " );
            for(Byte byte2 : ladder.get(i)) {
                System.out.print(byte2 + ", ");
            }
            System.out.println();
        }
        return ladder;
    }

    private byte[] makeLadderBySize(int size) {
        byte[] ladder = new byte[size];
        byte a = 0;
        for (int i = 0; i < size - 1; i++) {
            if(a == 0) {
                ladder[i] = randoms();
                a = ladder[i];
                continue;
            }
            ladder[i] = -1;
            a = 0;
        }
        if(a==1) {
            ladder[size - 1] = -1;
        }
        if(a==0) {
            ladder[size - 1] = 0;
        }
        return ladder;
    }

    private byte randoms() {
        Random random = new Random();
        int randomNo = random.nextInt(2);
        if(randomNo == 0) {
            return 0;
        }
        if(randomNo == 1) {
            return 1;
        }
        return 2;
    }

    public List<byte[]> getLadder() {
        return ladder;
    }
}
