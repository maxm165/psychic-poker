package nl.hyves.detector;

import java.util.ArrayList;
import java.util.List;

import nl.hyves.Card;
import nl.hyves.detector.util.CardUtils;

public class FullHouse extends AbstractHandDetector {

    public FullHouse() {
        super("full-house");
    }

    @Override
    protected List<Card> searchCombination(final List<Card> cards) {

        final List<Card> result = new ArrayList<Card>();

        for (List<Card> group : CardUtils.groupByRank(cards)) {
            if (group.size() == 3) {
                result.addAll(group);
            } else if (group.size() == 2) {
                result.addAll(group);
            }
            if (result.size() == 5) {
                return result;
            }
        }
        return null;
    }
}
