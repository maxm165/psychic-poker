package nl.hyves.detector;

import java.util.List;

import nl.hyves.Card;
import nl.hyves.detector.util.CardUtils;

public class OnePair extends AbstractHandDetector {

    public OnePair() {
        super("one-pair");
    }

    @Override
    protected List<Card> searchCombination(final List<Card> cards) {

        for (List<Card> group : CardUtils.groupByRank(cards)) {
            if (group.size() == 2) {
                return group;
            }
        }
        return null;
    }
}
