import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestParameterizedLion {

    private final String sex;
    private final boolean expectedHasMane;

    public TestParameterizedLion(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "Lion has mane - {1}. Test data: sex = {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Самец", true },
                { "Самка", false },
                { "InvalidSex", false }
        });
    }

    @Test
    public void testConstructor() {
        try {
            Lion lion = new Lion(sex);
            assertEquals(expectedHasMane, lion.doesHaveMane());
        } catch (Exception e) {
            assertEquals(false, expectedHasMane);
        }
    }
}