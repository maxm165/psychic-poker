package nl.hyves;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PokerAdviserTest {

    @Test
    public void testAdvice() {
        final List<String> advices = new ArrayList<String>();
        for (String source : getSources()) {
            advices.add(PokerAdviser.advice(source));
        }

        assertEquals(Arrays.asList(getExpected()), advices);
    }

    private String[] getSources() {
        return new String[]{
              "TH JH QC QD QS QH KH AH 2S 6S",
              "2H 2S 3H 3S 3C 2D 3D 6C 9C TH",
              "2H 2S 3H 3S 3C 2D 9C 3D 6C TH",
              "2H AD 5H AC 7H AH 6H 9H 4H 3C",
              "AC 2D 9C 3S KD 5S 4D KS AS 4C",
              "KS AH 2H 3C 4H KC 2C TC 2D AS",
              "AH 2C 9S AD 3C QH KS JS JD KD",
              "6C 9C 8C 2D 7C 2H TC 4C 9S AH",
              "3D 5S 2H QD TD 6S KH 9H AD QH"
            };
    }

    private String[] getExpected() {
        return new String[]{
              "Hand: TH JH QC QD QS Deck: QH KH AH 2S 6S Best hand: straight-flush",
              "Hand: 2H 2S 3H 3S 3C Deck: 2D 3D 6C 9C TH Best hand: four-of-a-kind",
              "Hand: 2H 2S 3H 3S 3C Deck: 2D 9C 3D 6C TH Best hand: full-house",
              "Hand: 2H AD 5H AC 7H Deck: AH 6H 9H 4H 3C Best hand: flush",
              "Hand: AC 2D 9C 3S KD Deck: 5S 4D KS AS 4C Best hand: straight",
              "Hand: KS AH 2H 3C 4H Deck: KC 2C TC 2D AS Best hand: three-of-a-kind",
              "Hand: AH 2C 9S AD 3C Deck: QH KS JS JD KD Best hand: two-pairs",
              "Hand: 6C 9C 8C 2D 7C Deck: 2H TC 4C 9S AH Best hand: one-pair",
              "Hand: 3D 5S 2H QD TD Deck: 6S KH 9H AD QH Best hand: highest-card"
            };
    }
}
