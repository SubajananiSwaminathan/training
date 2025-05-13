import org.example.SquareNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareNumberTest {
    @Test
    public void testSquare() {
        SquareNumber number = new SquareNumber();

        assertEquals(25, number.square(5));
        assertEquals(0, number.square(0));
        assertEquals(100, number.square(10));
    }
}
