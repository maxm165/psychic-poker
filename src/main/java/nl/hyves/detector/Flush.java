package nl.hyves.detector;

import java.util.List;

import nl.hyves.Card;
import nl.hyves.detector.util.CardUtils;

public class Flush extends AbstractHandDetector {

    public Flush() {
        super("flush");
    }

    @Override
    protected List<Card> searchCombination(List<Card> cards) {
        for (List<Card> group : CardUtils.groupBySuit(cards)) {
            if (group.size() == 5) {
                return group;
            }
        }
        return null;
    }
}
