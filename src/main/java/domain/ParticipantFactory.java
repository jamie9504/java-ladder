package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParticipantFactory implements ItemFactory {

    private final static String SPLIT_DELIMITER = ",";
    private final static int MORE_THAN_OR_EQUAL_TO_NUMBER = 2;
    private final static String EXCEPTION_MESSAGE_FORMAT_LESS_THAN = "참가인원(%d명)은 최소 %d명 이상이어야 합니다.";

    private final List<Participant> participants;

    public ParticipantFactory(String names) {
        List<String> splitNames = split(names);
        validCountMoreThanOrEqualTo(splitNames);
        this.participants = makeParticipantName(splitNames);
    }

    private List<String> split(String names) {
        return Arrays.asList(names.split(SPLIT_DELIMITER));
    }


    private List<Participant> makeParticipantName(List<String> splitNames) {
        List<Participant> participants = new ArrayList<>();
        for (String splitName : splitNames) {
            participants.add(new Participant(splitName));
        }
        return participants;
    }

    private void validCountMoreThanOrEqualTo(List<String> splitNames) {
        if (splitNames.size() < MORE_THAN_OR_EQUAL_TO_NUMBER) {
            throw new IllegalArgumentException(String
                .format(EXCEPTION_MESSAGE_FORMAT_LESS_THAN, splitNames.size(),
                    MORE_THAN_OR_EQUAL_TO_NUMBER));
        }
    }

    @Override
    public List<String> getNames() {
        List<String> participantNames = new ArrayList<>();
        for (Participant participant : participants) {
            participantNames.add(participant.getName());
        }
        return participantNames;
    }

    @Override
    public int getCount() {
        return participants.size();
    }
}
