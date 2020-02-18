package domain;

import static util.SplitAndRefine.splitExceptJustBlankWithDelimiter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Participants implements Items {

    private final static int MORE_THAN_OR_EQUAL_TO_NUMBER = 2;
    private final static String EXCEPTION_MESSAGE_FORMAT_LESS_THAN = "참가인원(%d명)은 최소 %d명 이상이어야 합니다.";

    private final List<Participant> participants;

    public Participants(String names) {
        List<String> splitNames = splitExceptJustBlankWithDelimiter(names);
        validCountMoreThanOrEqualTo(splitNames);
        validOverlapName(splitNames);
        this.participants = makeParticipantName(splitNames);
    }

    private void validOverlapName(List<String> splitNames) {
        Set noOverlapSplitNames = new HashSet<>(splitNames);
        if (splitNames.size() == noOverlapSplitNames.size()) {
            return;
        }
        for (String splitName : splitNames) {
            if (!noOverlapSplitNames.remove(splitName)) {
                throw new IllegalArgumentException("이름(" + splitName + ") 중복은 허용하지 않습니다.");
            }
        }
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

    @Override
    public int getMaxNameSize() {
        List<Integer> nameSizes = new ArrayList<>();
        for (Participant participant : participants) {
            nameSizes.add(participant.getNameSize());
        }
        return Collections.max(nameSizes);
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        for (Participant participant : participants) {
            items.add(participant);
        }
        return items;
    }
}
