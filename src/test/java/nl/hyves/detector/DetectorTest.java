package nl.hyves.detector;

import java.util.List;

import nl.hyves.Card;
import nl.hyves.CardFactory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DetectorTest {

    void assertTrueHands(final AbstractHandDetector detector, final String[] trueHands) {
        for (String trueHand : trueHands) {
            final CardFactory cardFactory = new CardFactory(trueHand);
            final List<Card> handCards = cardFactory.getHandCards();
            final List<Card> deckCards = cardFactory.getDeckCards();
            assertTrue("hand: " + trueHand + " " + detector.getName() + " was not detected. ",
              detector.check(handCards, deckCards));
        }
    }

    void assertFalseHands(final AbstractHandDetector detector, final String[] falseHands) {
        for (String falseHand : falseHands) {
            final CardFactory cardFactory = new CardFactory(falseHand);
            final List<Card> handCards = cardFactory.getHandCards();
            final List<Card> deckCards = cardFactory.getDeckCards();
            assertFalse("hand: " + falseHand + " " + detector.getName() + " must not be detected. ",
              detector.check(handCards, deckCards));
        }
    }
}
