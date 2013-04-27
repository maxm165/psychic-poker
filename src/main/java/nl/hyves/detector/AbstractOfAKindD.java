package nl.hyves.detector;

import java.util.List;

import nl.hyves.Card;
import nl.hyves.detector.util.CardUtils;

public class AbstractOfAKindD extends AbstractHandDetector {

    private final int numberOfKind;

    AbstractOfAKindD(final String name, final int numberOfKind) {
        super(name);
        this.numberOfKind = numberOfKind;
    }

    @Override
    protected List<Card> searchCombination(List<Card> cards) {
        for (List<Card> group : CardUtils.groupByRank(cards)) {
            if (group.size() == numberOfKind) {
                return group;
            }
        }
        return null;
    }
}
