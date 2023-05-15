import com.example.Feline;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class TestFeline {
    @Mock
    Predator predator;
    Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }


    @Test
   public void testGetKittensDefault(){
        assertEquals(1, feline.getKittens());
    }
    @Test
    public void testGetKittensWithCount() {
        assertEquals(3, feline.getKittens(3));
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> actual = feline.eatMeat();
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");

        assertEquals(expected, actual);
    }
}
