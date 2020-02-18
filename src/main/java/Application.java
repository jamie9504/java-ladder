import static util.SplitAndRefine.exceptJustBlankWithDelimiter;

import controller.LadderGame;
import domain.LadderGameResult;
import domain.LadderSize;
import domain.Participant;
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

        LadderGameResult ladderGameResult = LadderGame.start(participants, products, ladderHeight);

        afterGame(ladderGameResult);

    }
    
    private static void afterGame(LadderGameResult ladderGameResult) {
        OutputView.outputLadder(ladderGameResult);
        while (true) {
            try {
                String want = InputView.inputWhatYouWant();
                if (want.equalsIgnoreCase("all")) {
                    OutputView.outputResultAll(ladderGameResult);
                    continue;
                }
                if (want.equalsIgnoreCase("ok")) {
                    OutputView.outputResultNotDummy(ladderGameResult);
                    continue;
                }
                if (want.equalsIgnoreCase("finish")) {
                    return;
                }
                if (want.equalsIgnoreCase("result")) {
                    OutputView.outputLadder(ladderGameResult);
                    continue;
                }
                if (exceptJustBlankWithDelimiter(want).contains(",")) {
                    OutputView.outputResultByParticipants(ladderGameResult, new Participants(want));
                    continue;
                }
                OutputView.outputResultByParticipant(ladderGameResult, new Participant(want));
            } catch (Exception e) {
                OutputView.exceptionMessage(e.getMessage());
            }
        }
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
