package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static String inputParticipants() {
        System.out.println();
        System.out.println("사다리타기에 참가할 사람들을 모두 적어주세요.(구분자 : ,(쉼표))");
        System.out.print(": ");
        return scanner.nextLine();
    }

    public static String inputProducts() {
        System.out.println();
        System.out.println("사다리타기 당첨 항목들을 모두 적어주세요.(구분자 : ,(쉼표))");
        System.out.print(": ");
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println();
        System.out.println("사다리의 높이를 지정해주세요.");
        System.out.print(": ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ime) {
            scanner.nextLine();
            throw new InputMismatchException("사다리 크기는 양의 정수여야 합니다.");
        }
    }
}
