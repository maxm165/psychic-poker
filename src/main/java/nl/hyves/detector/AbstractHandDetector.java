package nl.hyves.detector;

import nl.hyves.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHandDetector {

    private final String name;

    /**
     * This method called with different sets of cards (from 0 to 10 cards)
     * to search a possible hand combination amongst them.
     * @param cards set of cards
     * @return collection of card with possible hand combination or null if there is no such
     */
    abstract protected List<Card> searchCombination(List<Card> cards);

    AbstractHandDetector(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean check(final List<Card> handCards, final List<Card> deckCards) {
        for (int n = 0; n <= 5; n++) {
            final List<Card> takenFromDeck = deckCards.subList(0, n);
            if (checkInner(handCards, takenFromDeck)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkInner(final List<Card> handCards, final List<Card> takenFromDeck) {
        for (int n = 0; n <= 5; n++) {
            final List<Card> handCardSubList = handCards.subList(0, n);
            final List<Card> union = union(handCardSubList, takenFromDeck);
            final List<Card> combination = searchCombination(union);
            if (isValid(combination, takenFromDeck)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ensures if the hand combination is valid.
     * Sum of cards taken from the deck and the hand cards that are used in the combination,
     * must be not more then 5.
     * @param combination   collection of the hand combination cards
     * @param takenFromDeck collection of cards taken from the deck
     * @return true if the combination is valid otherwise - false
     */
    private boolean isValid(final List<Card> combination, final List<Card> takenFromDeck) {
        if (combination == null) {
            return false;
        }
        final List<Card> copy = new ArrayList<Card>(combination);
        copy.removeAll(takenFromDeck);
        //compute how many cards from the hand cards where involved in the combination
        final int size = copy.size();
        return size + takenFromDeck.size() <= 5;
    }

    private List<Card> union(final List<Card> list1, final List<Card> list2) {
        final List<Card> cards = new ArrayList<Card>(list1);
        cards.addAll(list2);
        return cards;
    }
}
