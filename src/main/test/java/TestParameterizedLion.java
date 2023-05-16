import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class TestParameterizedLion {
    private final Feline feline;

    private final String sex;
    private final boolean expectedHasMane;

    public TestParameterizedLion(Feline feline, String sex, boolean expectedHasMane) {
        this.feline = feline;
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "Lion has mane - {2}. Test data: sex = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Feline(), "Самец", true},
                {new Feline(), "Самка", false}
        });
    }


    @Test
    public void testConstructor() {
        Lion lion = new Lion(feline, sex);

        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @RunWith(MockitoJUnitRunner.class)
    public static class ExceptionTestCase {
        @Test
        public void illegalStateTest() {
            assertThrows(IllegalStateException.class, () -> {
                new Lion(new Feline(), "");
            });
        }
    }
}