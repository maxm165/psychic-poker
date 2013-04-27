package nl.hyves;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class CardFactoryTest {

    @Test
    public void testPokerFactoryCreate() {
        final CardFactory cardFactory = new CardFactory("TH JH QC QD QS QH KH AH 2S 6S");
        final List<Card> handCards = cardFactory.getHandCards();
        final List<Card> deckCards = cardFactory.getDeckCards();
        assertEquals(handCards, createCardList("TH", "JH", "QC", "QD", "QS"));
        assertEquals(deckCards, createCardList("QH", "KH", "AH", "2S", "6S"));
    }

    public static List<Card> createCardList(String... cards) {
        final List<Card> list = new ArrayList<Card>();
        for (String card : cards) {
            list.add(new Card(card));
        }
        return list;
    }

}
