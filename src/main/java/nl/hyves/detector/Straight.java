package nl.hyves.detector;

import java.util.List;

import nl.hyves.Card;
import nl.hyves.detector.util.RoyalSequenceExtractor;
import nl.hyves.detector.util.WheelSequenceExtractor;

public class Straight extends AbstractHandDetector {

    private WheelSequenceExtractor extractor;

    public Straight() {
        super("straight");
    }

    Straight(String name) {
        super(name);
    }

    @Override
    protected List<Card> searchCombination(List<Card> cards) {
        return this.extractor.extractSequence(cards);
    }

    @Override
    public boolean check(final List<Card> handCards, final List<Card> deckCards) {
        setExtractor(new RoyalSequenceExtractor());
        if (super.check(handCards, deckCards)) {
            return true;
        } else {
            setExtractor(new WheelSequenceExtractor());
            return super.check(handCards, deckCards);
        }
    }

    private void setExtractor(final WheelSequenceExtractor extractor) {
        this.extractor = extractor;
    }
}
