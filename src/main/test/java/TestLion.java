import com.example.FelineMetod;
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
    private FelineMetod felineMetod;

    @Before
    public void setUp() throws Exception {
        when(felineMetod.getKittens()).thenReturn(2);
        when(felineMetod.getFood("Хищник")).thenReturn(Arrays.asList("мышь", "курица"));
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion maleLion = new Lion("Самец");
        Lion femaleLion = new Lion("Самка");

        assertEquals(true, maleLion.doesHaveMane());
        assertEquals(false, femaleLion.doesHaveMane());
    }

    @Test
    public void testGetKittens() {
        Lion lion = new Lion(felineMetod);

        assertEquals(2, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(felineMetod);

        List<String> expectedFood = Arrays.asList("мышь", "курица");
        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void testConstructorThrowsException() throws Exception {
        Lion lion = new Lion("InvalidSexValue");
    }
}
