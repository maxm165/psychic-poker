package nl.hyves.detector;

import java.util.List;

import nl.hyves.Card;

public class HighestCard extends AbstractHandDetector {

    public HighestCard() {
        super("highest-card");
    }

    @Override
    protected List<Card> searchCombination(final List<Card> cards) {
        return cards;
    }

}
