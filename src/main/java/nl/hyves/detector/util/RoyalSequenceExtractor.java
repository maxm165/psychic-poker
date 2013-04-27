package nl.hyves.detector.util;

import java.util.Map;

import nl.hyves.Card;
import nl.hyves.Rank;

/** Sequence extractor for the 'royal straight' type of A-K-Q-J-T. */
public class RoyalSequenceExtractor extends WheelSequenceExtractor {

    static class RoyalValue extends CardValue {

        RoyalValue(final Card card) {
            super(card);
        }

        @Override
        protected Map<Rank, Integer> getValueMapping() {
            final Map<Rank, Integer> valueMapping = super.getValueMapping();
            valueMapping.put(Rank.ACE, 14);
            return valueMapping;
        }
    }

    @Override
    protected CardValue wrap(final Card card) {
        return new RoyalValue(card);
    }
}
