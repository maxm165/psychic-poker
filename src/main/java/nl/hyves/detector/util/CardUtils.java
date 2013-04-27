package nl.hyves.detector.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nl.hyves.Card;
import nl.hyves.Rank;

public class CardUtils {

    public static Collection<List<Card>> groupBySuit(List<Card> cards) {
        final Map<String, List<Card>> result = new HashMap<String, List<Card>>();
        for (Card card : cards) {
            getOrCreate(result, card.getSuit()).add(card);
        }
        return result.values();
    }

    public static Collection<List<Card>> groupByRank(List<Card> cards) {
        final Map<Rank, List<Card>> result = new HashMap<Rank, List<Card>>();
        for (Card card : cards) {
            getOrCreate(result, card.getRank()).add(card);
        }
        return result.values();
    }

    private static <X> List<Card> getOrCreate(final Map<X, List<Card>> result, X suit) {
        List<Card> cardList = result.get(suit);
        if (cardList == null) {
            cardList = new ArrayList<Card>();
            result.put(suit, cardList);
        }
        return cardList;
    }
}
