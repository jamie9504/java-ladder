package view;

import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static String inputParticipants() {
        System.out.println("사다리타기에 참가할 인원을 적어주세요.(구분자 : ,(쉼표))");
        System.out.print(": ");
        return scanner.nextLine();
    }

    public static String inputProducts() {
        System.out.println("사다리타기 당첨 항목을 적어주세요.(구분자 : ,(쉼표))");
        System.out.print(": ");
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println("사다리의 높이를 지정해주세요.");
        System.out.print(": ");
        return scanner.nextInt();
    }
}
