package nl.hyves.detector.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nl.hyves.Card;
import nl.hyves.Rank;

/** Sequence extractor for the 'wheel straight' type of A-2-3-4-5. */
public class WheelSequenceExtractor {

    static class CardValue {

        private final Card card;

        CardValue(final Card card) {
            this.card = card;
        }

        Card getCard() {
            return card;
        }

        Integer getValue() {
            return getValueMapping().get(this.card.getRank());
        }

        protected Map<Rank, Integer> getValueMapping() {
            final HashMap<Rank, Integer> values = new HashMap<Rank, Integer>();
            values.put(Rank.ACE, 1);
            values.put(Rank.RANK2, 2);
            values.put(Rank.RANK3, 3);
            values.put(Rank.RANK4, 4);
            values.put(Rank.RANK5, 5);
            values.put(Rank.RANK6, 6);
            values.put(Rank.RANK7, 7);
            values.put(Rank.RANK8, 8);
            values.put(Rank.RANK9, 9);
            values.put(Rank.TEN, 10);
            values.put(Rank.JACK, 11);
            values.put(Rank.QUEEN, 12);
            values.put(Rank.KING, 13);
            return values;
        }
    }

    public List<Card> extractSequence(final List<Card> cards) {
        final List<Card> result = new ArrayList<Card>();
        for (Card card : createSpotArray(cards)) {
            if (card == null) {
                result.clear();
            } else {
                result.add(card);
            }
            if (result.size() == 5) {
                return result;
            }
        }
        return null;
    }

    private Card[] createSpotArray(final List<Card> cards) {
        final Card[] cardArray = new Card[14];
        for (CardValue value : wrapList(cards)) {
            cardArray[value.getValue() - 1] = value.getCard();
        }
        return cardArray;
    }

    private List<CardValue> wrapList(final List<Card> cards) {
        final List<CardValue> cardValues = new ArrayList<CardValue>();
        for (Card card : cards) {
            cardValues.add(wrap(card));
        }
        return cardValues;
    }

    protected CardValue wrap(final Card card) {
        return new CardValue(card);
    }
}
