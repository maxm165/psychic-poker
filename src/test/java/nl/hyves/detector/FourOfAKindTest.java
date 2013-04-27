package nl.hyves.detector;

import org.junit.Test;

public class FourOfAKindTest extends DetectorTest {

    @Test
    public void testCheckTrue() {
        assertTrueHands(new FourOfAKind(), createTrueHands());
    }

    @Test
    public void testCheckFalse() {
        assertFalseHands(new FourOfAKind(), createFalseHands());
    }

    private String[] createTrueHands() {
        return new String[]{
          "2H 2S 3H 3S 3C 2D 3D 6C 9C TH",
          "2H 2S 2C 2D 3C TD 3D 6C 9C TH",
          "AD AH AC 9C TH 2H AS 3H 3S 3C" };
    }

    private String[] createFalseHands() {
        return new String[]{
          "2S AS 5S KS 7D AH 6S 9H 4H 3H",
          "2H 2S 3H 3S JC QD 3D 6C 2C AD",
          "2D QS 3H 3S JC QD 3D 2H 2S 2C",
          "2H 2S 3H 3S JC QD 3D 6C 2C 2D" };
    }
}
