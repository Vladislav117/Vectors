import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.vectors.Axis;
import ru.vladislav117.vectors.VectorArray;

public class VectorArrayTests {
    protected void assertVector3(VectorArray vector, double x, double y, double z) {
        Assertions.assertEquals(vector.getAxis(Axis.X_INDEX), x);
        Assertions.assertEquals(vector.getAxis(Axis.Y_INDEX), y);
        Assertions.assertEquals(vector.getAxis(Axis.Z_INDEX), z);
    }

    @Test
    public void testConstructors() {
        VectorArray vector;

        vector = new VectorArray(new double[]{1, 2, 3});
        assertVector3(vector, 1, 2, 3);

        vector = new VectorArray(new VectorArray(new double[]{1, 2, 3}));
        assertVector3(vector, 1, 2, 3);

        vector = new VectorArray(new double[]{1, 2, 3}).clone();
        assertVector3(vector, 1, 2, 3);

        vector = new VectorArray(3);
        assertVector3(vector, 0, 0, 0);
    }

    @Test
    public void testGetters() {
        VectorArray vector;

        vector = new VectorArray(new double[]{1, 2, 3});
        Assertions.assertEquals(vector.getSize(), 3);

        vector = new VectorArray(new double[]{1, 2, 3});
        Assertions.assertEquals(vector.getAxis(Axis.X_INDEX), 1);
        Assertions.assertEquals(vector.getAxis(Axis.Y), 2);

        vector = new VectorArray(new double[]{1, 2, 3});
        Assertions.assertEquals(vector.getAxisOrZero(Axis.X_INDEX), 1);
        Assertions.assertEquals(vector.getAxisOrZero(Axis.Y), 2);
        Assertions.assertEquals(vector.getAxisOrZero(-1), 0);
        Assertions.assertEquals(vector.getAxisOrZero(new Axis(-1)), 0);
    }

    @Test
    public void testSetters() {
        VectorArray vector;

        vector = new VectorArray(new double[]{1, 2, 3});
        vector.setAxis(Axis.X_INDEX, 2);
        vector.setAxis(Axis.Y, 3);
        assertVector3(vector, 2, 3, 3);

        vector = new VectorArray(new double[]{1, 2, 3});
        vector.set(new VectorArray(new double[]{2, 3, 4}));
        assertVector3(vector, 2, 3, 4);
    }

    @Test
    public void testMath() {
        VectorArray vector;

        vector = new VectorArray(new double[]{1, 2, 3});
        vector.addAxis(Axis.X_INDEX, 1);
        vector.addAxis(Axis.Y, 1);
        assertVector3(vector, 2, 3, 3);

        vector = new VectorArray(new double[]{1, 2, 3});
        vector.add(new VectorArray(new double[]{1, 1, 1}));
        assertVector3(vector, 2, 3, 4);

        vector = new VectorArray(new double[]{1, 2, 3});
        vector.subtractAxis(Axis.X_INDEX, 1);
        vector.subtractAxis(Axis.Y, 1);
        assertVector3(vector, 0, 1, 3);

        vector = new VectorArray(new double[]{1, 2, 3});
        vector.subtract(new VectorArray(new double[]{1, 1, 1}));
        assertVector3(vector, 0, 1, 2);

        vector = new VectorArray(new double[]{1, 2, 3});
        vector.multipleAxis(Axis.X_INDEX, 2);
        vector.multipleAxis(Axis.Y, 2);
        assertVector3(vector, 2, 4, 3);

        vector = new VectorArray(new double[]{1, 2, 3});
        vector.multiple(2);
        assertVector3(vector, 2, 4, 6);

        vector = new VectorArray(new double[]{1, 2, 3});
        vector.divideAxis(Axis.X_INDEX, 2);
        vector.divideAxis(Axis.Y, 2);
        assertVector3(vector, 0.5, 1, 3);

        vector = new VectorArray(new double[]{1, 2, 3});
        vector.divide(2);
        assertVector3(vector, 0.5, 1, 1.5);
    }

    @Test
    public void testNormalization() {
        VectorArray vector;

        vector = new VectorArray(new double[]{1, 2, 3});
        vector.normalize();
        assertVector3(vector, 1 / Math.sqrt(14), 2 / Math.sqrt(14), 3 / Math.sqrt(14));

        vector = new VectorArray(new double[]{1, 2, 3});
        VectorArray normalizedVector = vector.toNormalized();
        assertVector3(vector, 1, 2, 3);
        assertVector3(normalizedVector, 1 / Math.sqrt(14), 2 / Math.sqrt(14), 3 / Math.sqrt(14));
    }

    @Test
    public void testCalculations() {
        VectorArray vector;

        vector = new VectorArray(new double[]{1, 2, 3});
        Assertions.assertEquals(vector.length(), Math.sqrt(14));

        vector = new VectorArray(new double[]{1, 2, 3});
        Assertions.assertEquals(vector.distance(new VectorArray(3)), Math.sqrt(14));
        Assertions.assertEquals(vector.distance(new VectorArray(new double[]{1, 2, 3})), 0);
        Assertions.assertEquals(vector.distance(new VectorArray(new double[]{4, 5, 6})), Math.sqrt(27));
    }
}
