package nl.hyves.detector;

import java.util.ArrayList;
import java.util.List;

import nl.hyves.Card;
import nl.hyves.detector.util.CardUtils;

public class TwoPairs extends AbstractHandDetector {

    public TwoPairs() {
        super("two-pairs");
    }

    @Override
    protected List<Card> searchCombination(final List<Card> cards) {

        final List<Card> result = new ArrayList<Card>();

        for (List<Card> group : CardUtils.groupByRank(cards)) {
            if (group.size() == 2) {
                result.addAll(group);
            }
            if (result.size() == 4) {
                return result;
            }
        }
        return null;
    }
}
