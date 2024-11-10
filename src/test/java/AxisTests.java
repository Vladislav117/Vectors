import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.vectors.Axis;

public class AxisTests {
    @Test
    public void test() {
        Axis axis;

        axis = new Axis(0);
        Assertions.assertEquals(axis.getIndex(), 0);
    }
}
