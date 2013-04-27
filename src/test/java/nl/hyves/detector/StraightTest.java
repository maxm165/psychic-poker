package nl.hyves.detector;

import org.junit.Test;

public class StraightTest extends DetectorTest {

    @Test
    public void testCheckTrue() {
        assertTrueHands(new Straight(), createTrueHands());
    }

    @Test
    public void testCheckFalse() {
        assertFalseHands(new Straight(), createFalseHands());
    }

    private String[] createTrueHands() {
        return new String[]{
          //royal straights
          "TH JH QC QD QS QH KH AH 2S 6S",
          "TD JH QC QD QS QH KH AH 2S 6S",
          //wheel straights
          "2D 3H 4C 5D QS AH KH JH 2S 6S",
          "AH QS KH JH 2S 6S 2D 3H 4C 5D"};
    }

    private String[] createFalseHands() {
        return new String[]{
          "9H JH QC QD QS QH KH AH 2S 6S",
          "2D 3H 4C 5D QS QH KH JH 2S AS" };
    }
}
