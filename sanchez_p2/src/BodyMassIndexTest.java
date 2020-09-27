import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BodyMassIndexTest {
    @Test
    public void testCalculateBmiPositiveValues() {
        BodyMassIndex calculator = new BodyMassIndex(67, 163);

        double answer = calculator.calculateBmi(67, 163);

        assertEquals(25.526620628202274, answer);
    }
    @Test
    public void testCalculateBmiOneNegativeValue() {
        BodyMassIndex calculator = new BodyMassIndex(-67, -163);

        double answer = calculator.calculateBmi(-67, -163);

        assertEquals(0, answer);
    }
    @Test
    public void testCalculateBmiTwoNegativeValue() {
        BodyMassIndex calculator = new BodyMassIndex(-67, -163);

        double answer = calculator.calculateBmi(-67, -163);

        assertEquals(0, answer);
    }
    @Test
    public void testBmiCategoryUnderweight() {
        BodyMassIndex calculator = new BodyMassIndex(67, 100);

        String answer = calculator.bmiCategory(15.7);

        assertEquals("Underweight", answer);
    }
    @Test
    public void testBmiCategoryNormalWeight() {
        BodyMassIndex calculator = new BodyMassIndex(69, 163);

        String answer = calculator.bmiCategory(24.1);

        assertEquals("Normal weight", answer);
    }
    @Test
    public void testBmiCategoryOverweight() {
        BodyMassIndex calculator = new BodyMassIndex(67, 163);

        String answer = calculator.bmiCategory(25.5);

        assertEquals("Overweight", answer);
    }
    @Test
    public void testBmiCategoryObese() {
        BodyMassIndex calculator = new BodyMassIndex(67, 200);

        String answer = calculator.bmiCategory(31.3);

        assertEquals("Obese", answer);
    }
}
