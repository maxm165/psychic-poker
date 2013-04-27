package nl.hyves;

import nl.hyves.detector.AbstractHandDetector;
import nl.hyves.detector.Flush;
import nl.hyves.detector.FourOfAKind;
import nl.hyves.detector.FullHouse;
import nl.hyves.detector.HighestCard;
import nl.hyves.detector.OnePair;
import nl.hyves.detector.Straight;
import nl.hyves.detector.StraightFlush;
import nl.hyves.detector.ThreeOfAKind;
import nl.hyves.detector.TwoPairs;

import java.util.List;

public class PokerAdviser {

    private final static AbstractHandDetector[] DETECTORS = new AbstractHandDetector[]{
            new StraightFlush(),
            new FourOfAKind(),
            new FullHouse(),
            new Flush(),
            new Straight(),
            new ThreeOfAKind(),
            new TwoPairs(),
            new OnePair(),
            new HighestCard()};

    public static String advice(final String source) {
        final CardFactory cardFactory = new CardFactory(source);
        final List<Card> handCards = cardFactory.getHandCards();
        final List<Card> deckCards = cardFactory.getDeckCards();

        for (AbstractHandDetector detector : DETECTORS) {
            if (detector.check(handCards, deckCards)) {
                return buildAdviceString(detector, handCards, deckCards);
            }
        }
        //this should never happen
        return null;
    }

    /**
     * Constructs the result string for a combination of cards.
     *
     * @param detector  hand detector
     * @param handCards hand cards
     * @param deckCards deck cards
     * @return advise string
     */
    private static String buildAdviceString(final AbstractHandDetector detector, final List<Card> handCards,
                                            final List<Card> deckCards) {
        final StringBuilder builder = new StringBuilder("Hand: ");
        getCardsString(builder, handCards);
        builder.append("Deck: ");
        getCardsString(builder, deckCards);
        builder.append("Best hand: ").append(detector.getName());
        return builder.toString();
    }

    /**
     * Construct a string representation for a list of cards
     *
     * @param builder   string builder
     * @param handCards list of cards to be represented in string
     */
    private static void getCardsString(final StringBuilder builder, final List<Card> handCards) {
        for (Card card : handCards) {
            builder.append(card).append(" ");
        }
    }
}
