import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestLion {

    @Mock
    private Feline feline;

    @Before
    public void setUp() throws Exception {
        when(feline.getKittens()).thenReturn(2);
        when(feline.getFood("Хищник")).thenReturn(Arrays.asList("мышь", "курица"));
    }

    @Test
    public void testDoesHaveManeMale() throws Exception {
        Lion maleLion = new Lion(feline, "Самец");

        assertEquals(true, maleLion.doesHaveMane());
    }

    @Test
    public void femaleTest() throws Exception{
        Lion femaleLion = new Lion(feline, "Самка");
        assertEquals(false, femaleLion.doesHaveMane());
    }


    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion(feline, "Самец");

        assertEquals(2, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(feline, "Самец");

        List<String> expectedFood = Arrays.asList("мышь", "курица");
        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void testConstructorThrowsException() throws Exception {
        Lion lion = new Lion(feline, "InvalidSexValue");
    }
}
