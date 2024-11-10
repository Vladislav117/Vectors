import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.vectors.Axis;
import ru.vladislav117.vectors.Vector1D;

public class Vector1DTests {
    protected void assertVector(Vector1D vector, double x) {
        Assertions.assertEquals(vector.getX(), x);
    }

    @Test
    public void testConstructors() {
        Vector1D vector;

        vector = new Vector1D(1);
        assertVector(vector, 1);

        vector = new Vector1D(new Vector1D(1));
        assertVector(vector, 1);

        vector = new Vector1D(1).clone();
        assertVector(vector, 1);

        vector = new Vector1D();
        assertVector(vector, 0);
    }

    @Test
    public void testGetters() {
        Vector1D vector;

        vector = new Vector1D(1);
        Assertions.assertEquals(vector.getSize(), 1);

        vector = new Vector1D(1);
        Assertions.assertEquals(vector.getX(), 1);

        vector = new Vector1D(1);
        Assertions.assertEquals(vector.getAxis(Axis.X_INDEX), 1);
        Assertions.assertEquals(vector.getAxis(Axis.X), 1);

        vector = new Vector1D(1);
        Assertions.assertEquals(vector.getAxisOrZero(Axis.X_INDEX), 1);
        Assertions.assertEquals(vector.getAxisOrZero(Axis.X), 1);
        Assertions.assertEquals(vector.getAxisOrZero(-1), 0);
        Assertions.assertEquals(vector.getAxisOrZero(new Axis(-1)), 0);
    }

    @Test
    public void testSetters() {
        Vector1D vector;

        vector = new Vector1D(1);
        vector.setX(2);
        assertVector(vector, 2);

        vector = new Vector1D(1);
        vector.setAxis(Axis.X_INDEX, 2);
        assertVector(vector, 2);
        vector.setAxis(Axis.X, 2);
        assertVector(vector, 2);

        vector = new Vector1D(1);
        vector.set(2);
        assertVector(vector, 2);

        vector = new Vector1D(1);
        vector.set(new Vector1D(2));
        assertVector(vector, 2);
    }

    @Test
    public void testMath() {
        Vector1D vector;

        vector = new Vector1D(1);
        vector.addX(1);
        assertVector(vector, 2);

        vector = new Vector1D(1);
        vector.addAxis(Axis.X_INDEX, 1);
        assertVector(vector, 2);
        vector.addAxis(Axis.X, 1);
        assertVector(vector, 3);

        vector = new Vector1D(1);
        vector.add(1);
        assertVector(vector, 2);

        vector = new Vector1D(1);
        vector.add(new Vector1D(1));
        assertVector(vector, 2);

        vector = new Vector1D(1);
        vector.subtractX(1);
        assertVector(vector, 0);

        vector = new Vector1D(1);
        vector.subtractAxis(Axis.X_INDEX, 1);
        assertVector(vector, 0);
        vector.subtractAxis(Axis.X, 1);
        assertVector(vector, -1);

        vector = new Vector1D(1);
        vector.subtract(1);
        assertVector(vector, 0);

        vector = new Vector1D(1);
        vector.subtract(new Vector1D(1));
        assertVector(vector, 0);

        vector = new Vector1D(1);
        vector.multipleX(2);
        assertVector(vector, 2);

        vector = new Vector1D(1);
        vector.multipleAxis(Axis.X_INDEX, 2);
        assertVector(vector, 2);
        vector.multipleAxis(Axis.X, 2);
        assertVector(vector, 4);

        vector = new Vector1D(1);
        vector.multiple(2);
        assertVector(vector, 2);

        vector = new Vector1D(1);
        vector.divideX(2);
        assertVector(vector, 0.5);

        vector = new Vector1D(1);
        vector.divideAxis(Axis.X_INDEX, 2);
        assertVector(vector, 0.5);
        vector.divideAxis(Axis.X, 2);
        assertVector(vector, 0.25);

        vector = new Vector1D(1);
        vector.divide(2);
        assertVector(vector, 0.5);
    }

    @Test
    public void testNormalization() {
        Vector1D vector;

        vector = new Vector1D(1);
        vector.normalize();
        assertVector(vector, 1);

        vector = new Vector1D(1);
        Vector1D normalizedVector = vector.toNormalized();
        assertVector(vector, 1);
        assertVector(normalizedVector, 1);
    }

    @Test
    public void testCalculations() {
        Vector1D vector;

        vector = new Vector1D(1);
        Assertions.assertEquals(vector.length(), 1);

        vector = new Vector1D(1);
        Assertions.assertEquals(vector.distance(new Vector1D()), 1);
        Assertions.assertEquals(vector.distance(new Vector1D(1)), 0);
        Assertions.assertEquals(vector.distance(new Vector1D(2)), 1);
    }
}
