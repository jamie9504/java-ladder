import domain.Ladder;
import domain.LadderSize;
import domain.Participants;
import domain.Products;
import java.util.InputMismatchException;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        Participants participants = makeParticipants();
        Products products = makeProducts(participants);
        LadderSize ladderHeight = makeLadderHeight();
        LadderSize ladderWidth = new LadderSize(participants.getCount());
        Ladder ladder = new Ladder(ladderHeight, ladderWidth);
    }

    private static Participants makeParticipants() {
        while (true) {
            try {
                String participantsName = InputView.inputParticipants();
                return new Participants(participantsName);
            } catch (IllegalArgumentException iae) {
                OutputView.exceptionMessage(iae.getMessage());
            }
        }
    }

    private static Products makeProducts(Participants participants) {
        while (true) {
            try {
                String productsName = InputView.inputProducts();
                return new Products(productsName, participants);
            } catch (IllegalArgumentException | InputMismatchException e) {
                OutputView.exceptionMessage(e.getMessage());
            }
        }
    }

    private static LadderSize makeLadderHeight() {
        while (true) {
            try {
                int height = InputView.inputLadderHeight();
                return new LadderSize(height);
            } catch (IllegalArgumentException | InputMismatchException e) {
                OutputView.exceptionMessage(e.getMessage());
            }
        }
    }
}
