package nl.hyves.detector;

import org.junit.Test;

public class OnePairTest extends DetectorTest {

    @Test
    public void testCheckTrue() {
        assertTrueHands(new OnePair(), createTrueHands());
    }

    @Test
    public void testCheckFalse() {
        assertFalseHands(new OnePair(), createFalseHands());
    }

    private String[] createTrueHands() {
        return new String[]{
          "AH 2C 9S TD 3C QH KS 4S JD JD",
          "KS KH JC TS 4H 9C 2C 3C AD QS",
          "QS JC TS 4H 9C 2C 3C AD KS KH",
          "KS JC TS 4H 9C 2C 3C AD KH QS",
          "KS JC TS 4H 9C KH 2C 3C AD QS"};
    }

    private String[] createFalseHands() {
        return new String[]{
          "KS JC TS 4H 9C 2C 3C AD QS KH",
          "KS JC TS 4D 9C 2C 3C AD QS 4H"
        };
    }
}
