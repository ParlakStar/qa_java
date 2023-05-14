import com.example.Animal;
import com.example.Cat;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {
    @Mock
    Cat cat;
    Predator predator;
    Feline feline;

    @Before
    public void setUp() {
        predator = mock(Predator.class);
        feline = mock(Feline.class);
        cat = new Cat(feline);
        cat.predator = predator;
    }

    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        when(predator.eatMeat()).thenReturn(expected);
        List<String> actual = cat.getFood();
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void testGetFoodUnknownKind() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Неизвестный вид животного");
    }

    @Test(expected = Exception.class)
    public void testGetFoodNullKind() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood(null);
    }
}
