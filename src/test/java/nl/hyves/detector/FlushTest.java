package nl.hyves.detector;

import org.junit.Test;

public class FlushTest extends DetectorTest {

    @Test
    public void testCheckTrue() {
        assertTrueHands(new Flush(), createTrueHands());
    }

    @Test
    public void testCheckFalse() {
        assertFalseHands(new Flush(), createFalseHands());
    }

    private String[] createTrueHands() {
        return new String[]{
          "2S AD 5S AC 7C AH 6H 9H 4H 3H",
          "AH 6H 9H 4H 3H 2S AS 5S KS 7S",
          "2H AD 5H AC 7H AH 6H 9H 4H 3C" };
    }

    private String[] createFalseHands() {
        return new String[]{
          "2S AS 5S KS 7D AH 6S 9H 4H 3H",
          "2H AD 5C AC 3C TD AH 6H 9H 4H" };
    }
}
