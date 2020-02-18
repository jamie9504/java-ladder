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
            int imsi = scanner.nextInt();
            scanner.nextLine();
            return imsi;
        } catch (InputMismatchException ime) {
            scanner.nextLine();
            throw new InputMismatchException("사다리 크기는 양의 정수여야 합니다.");
        }
    }

    public static String inputWhatYouWant() {
        System.out.println();
        System.out.println("다음과 같이 항목을 입력하십시오.");
        System.out.println("---------------------------------------");
        System.out.println("사다리 결과 다시 보기 - result");
        System.out.println("전체 매칭 항목 보기 - all");
        System.out.println("원하는 사람 매칭만 보기 - 사람 이름 입력 (, 구분자)");
        System.out.println("당첨항목 매칭만 보기(X 제외) - OK");
        System.out.println("종료 - finish");
        System.out.println("재시작 - restart");
        System.out.println("---------------------------------------");
        System.out.print(": ");
        return scanner.nextLine();
    }
}
