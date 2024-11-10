import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.vectors.Axis;
import ru.vladislav117.vectors.Vector2D;

public class Vector2DTests {
    protected void assertVector(Vector2D vector, double x, double y) {
        Assertions.assertEquals(vector.getX(), x);
        Assertions.assertEquals(vector.getY(), y);
    }

    @Test
    public void testConstructors() {
        Vector2D vector;

        vector = new Vector2D(1, 2);
        assertVector(vector, 1, 2);

        vector = new Vector2D(new Vector2D(1, 2));
        assertVector(vector, 1, 2);

        vector = new Vector2D(1, 2).clone();
        assertVector(vector, 1, 2);

        vector = new Vector2D();
        assertVector(vector, 0, 0);
    }

    @Test
    public void testGetters() {
        Vector2D vector;

        vector = new Vector2D(1, 2);
        Assertions.assertEquals(vector.getSize(), 2);

        vector = new Vector2D(1, 2);
        Assertions.assertEquals(vector.getX(), 1);
        Assertions.assertEquals(vector.getY(), 2);

        vector = new Vector2D(1, 2);
        Assertions.assertEquals(vector.getAxis(Axis.X_INDEX), 1);
        Assertions.assertEquals(vector.getAxis(Axis.Y), 2);

        vector = new Vector2D(1, 2);
        Assertions.assertEquals(vector.getAxisOrZero(Axis.X_INDEX), 1);
        Assertions.assertEquals(vector.getAxisOrZero(Axis.Y), 2);
        Assertions.assertEquals(vector.getAxisOrZero(-1), 0);
        Assertions.assertEquals(vector.getAxisOrZero(new Axis(-1)), 0);
    }

    @Test
    public void testSetters() {
        Vector2D vector;

        vector = new Vector2D(1, 2);
        vector.setX(2);
        vector.setY(3);
        assertVector(vector, 2, 3);

        vector = new Vector2D(1, 2);
        vector.setAxis(Axis.X_INDEX, 2);
        vector.setAxis(Axis.Y, 3);
        assertVector(vector, 2, 3);

        vector = new Vector2D(1, 2);
        vector.set(2, 3);
        assertVector(vector, 2, 3);

        vector = new Vector2D(1, 2);
        vector.set(new Vector2D(2, 3));
        assertVector(vector, 2, 3);
    }

    @Test
    public void testMath() {
        Vector2D vector;

        vector = new Vector2D(1, 2);
        vector.addX(1);
        vector.addY(1);
        assertVector(vector, 2, 3);

        vector = new Vector2D(1, 2);
        vector.addAxis(Axis.X_INDEX, 1);
        vector.addAxis(Axis.Y, 1);
        assertVector(vector, 2, 3);

        vector = new Vector2D(1, 2);
        vector.add(1, 1);
        assertVector(vector, 2, 3);

        vector = new Vector2D(1, 2);
        vector.add(new Vector2D(1, 1));
        assertVector(vector, 2, 3);

        vector = new Vector2D(1, 2);
        vector.subtractX(1);
        vector.subtractY(1);
        assertVector(vector, 0, 1);

        vector = new Vector2D(1, 2);
        vector.subtractAxis(Axis.X_INDEX, 1);
        vector.subtractAxis(Axis.Y, 1);
        assertVector(vector, 0, 1);

        vector = new Vector2D(1, 2);
        vector.subtract(1, 1);
        assertVector(vector, 0, 1);

        vector = new Vector2D(1, 2);
        vector.subtract(new Vector2D(1, 1));
        assertVector(vector, 0, 1);

        vector = new Vector2D(1, 2);
        vector.multipleX(2);
        vector.multipleY(2);
        assertVector(vector, 2, 4);

        vector = new Vector2D(1, 2);
        vector.multipleAxis(Axis.X_INDEX, 2);
        vector.multipleAxis(Axis.Y, 2);
        assertVector(vector, 2, 4);

        vector = new Vector2D(1, 2);
        vector.multiple(2);
        assertVector(vector, 2, 4);

        vector = new Vector2D(1, 2);
        vector.divideX(2);
        vector.divideY(2);
        assertVector(vector, 0.5, 1);

        vector = new Vector2D(1, 2);
        vector.divideAxis(Axis.X_INDEX, 2);
        vector.divideAxis(Axis.Y, 2);
        assertVector(vector, 0.5, 1);

        vector = new Vector2D(1, 2);
        vector.divide(2);
        assertVector(vector, 0.5, 1);
    }

    @Test
    public void testNormalization() {
        Vector2D vector;

        vector = new Vector2D(1, 2);
        vector.normalize();
        assertVector(vector, 1 / Math.sqrt(5), 2 / Math.sqrt(5));

        vector = new Vector2D(1, 2);
        Vector2D normalizedVector = vector.toNormalized();
        assertVector(vector, 1, 2);
        assertVector(normalizedVector, 1 / Math.sqrt(5), 2 / Math.sqrt(5));
    }

    @Test
    public void testCalculations() {
        Vector2D vector;

        vector = new Vector2D(1, 2);
        Assertions.assertEquals(vector.length(), Math.sqrt(5));

        vector = new Vector2D(1, 2);
        Assertions.assertEquals(vector.distance(new Vector2D()), Math.sqrt(5));
        Assertions.assertEquals(vector.distance(new Vector2D(1, 2)), 0);
        Assertions.assertEquals(vector.distance(new Vector2D(3, 4)), Math.sqrt(8));
    }
}
