package nl.hyves.detector;

import org.junit.Test;

public class ThreeOfAKindTest extends DetectorTest {

    @Test
    public void testCheckTrue() {
        assertTrueHands(new ThreeOfAKind(), createTrueHands());
    }

    @Test
    public void testCheckFalse() {
        assertFalseHands(new ThreeOfAKind(), createFalseHands());
    }

    private String[] createTrueHands() {
        return new String[]{
          "KS KH KC 3C 4H TC 2C JC 2D AS",
          "KS KH 2H 3C 4H JC 2C KC 2D AS",
          "2S AS 5S KS 7D AH 6S 3S 3D 3H" };
    }

    private String[] createFalseHands() {
        return new String[]{
          "2S AS 5S KS 7D AH 6S 9H 4H 3H",
          "2H 2S 3H 3S JC QD 4D 6C 2C AD",
          "2H 3H 3S JC QD 4D 6C AD 2C 2S" };
    }
}
