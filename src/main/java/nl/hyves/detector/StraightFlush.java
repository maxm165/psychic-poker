package nl.hyves.detector;

import java.util.List;

import nl.hyves.Card;
import nl.hyves.detector.util.CardUtils;

public class StraightFlush extends Straight {

    public StraightFlush() {
        super("straight-flush");
    }

    @Override
    protected List<Card> searchCombination(List<Card> cards) {
        for (List<Card> group : CardUtils.groupBySuit(cards)) {
            final List<Card> candidates = super.searchCombination(group);
            if (candidates != null) {
                return candidates;
            }
        }
        return null;
    }
}
