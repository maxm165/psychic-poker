package nl.hyves;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardFactory {

    private final String source;

    public CardFactory(String source) {
        this.source = source;
    }

    public List<Card> getHandCards() {
        return createCardList(0, 5);
    }

    public List<Card> getDeckCards() {
        return createCardList(5, 10);
    }

    private List<Card> createCardList(int fromIndex, int toIndex) {
        final String[] cards = source.split(" ");
        final List<String> handCards = Arrays.asList(cards).subList(fromIndex, toIndex);
        final List<Card> handList = new ArrayList<Card>();
        for (String handCard : handCards) {
            handList.add(new Card(handCard));
        }
        return handList;
    }
}
