package nl.hyves.detector.util;

import java.util.List;

import nl.hyves.Card;
import nl.hyves.CardFactoryTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SequenceExtractorTest {

    @Test
    public void testExtractRoyalSequence() {
        final List<Card> cardList = CardFactoryTest
          .createCardList("TH", "JH", "QC", "QD", "QS", "QH", "KH", "AH", "2S", "6S");
        final List<Card> royalSequenceResult = new RoyalSequenceExtractor().extractSequence(cardList);
        assertEquals(5, royalSequenceResult.size());
    }

    @Test
    public void testExtractWheelSequence() {
        final List<Card> cardList = CardFactoryTest
          .createCardList("TH", "JH", "QC", "QD", "QS", "QH", "KH", "AH", "2S", "9S");
        final List<Card> royalSequenceResult = new WheelSequenceExtractor().extractSequence(cardList);
        assertEquals(5, royalSequenceResult.size());
    }
}
