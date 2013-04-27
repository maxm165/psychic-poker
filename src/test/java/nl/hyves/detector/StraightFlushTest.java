package nl.hyves.detector;

import org.junit.Test;

public class StraightFlushTest extends DetectorTest {

    @Test
    public void testCheckTrue() {
        assertTrueHands(new StraightFlush(), createTrueHands());
    }

    @Test
    public void testCheckFalse() {
        assertFalseHands(new StraightFlush(), createFalseHands());
    }

    private String[] createTrueHands() {
        return new String[]{
          //royal straight-flush
          "TH JH QC QD QS QH KH AH 2S 6S",
          //wheel straight-flush
          "AH 2H 3H QD QS 4H 5H JH TS TS",
          "JH TS TS QD QS 4H AH 2H 3H 5H"};
    }

    private String[] createFalseHands() {
        return new String[]{
          "9H JH QC QD QS QH KH AH 2S 6S",
          "TD JH QC QD QS QH KH AH 2S 6S",
          "JH TS TS QD QS 4H AH 2H 3H 6H",
          "JH TS TS QD QS 4H AH 6H 3H 5D"};
    }
}
