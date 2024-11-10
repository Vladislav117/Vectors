import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.vectors.Axis;
import ru.vladislav117.vectors.Vector3D;

public class Vector3DTests {
    protected void assertVector(Vector3D vector, double x, double y, double z) {
        Assertions.assertEquals(vector.getX(), x);
        Assertions.assertEquals(vector.getY(), y);
        Assertions.assertEquals(vector.getZ(), z);
    }

    @Test
    public void testConstructors() {
        Vector3D vector;

        vector = new Vector3D(1, 2, 3);
        assertVector(vector, 1, 2, 3);

        vector = new Vector3D(new Vector3D(1, 2, 3));
        assertVector(vector, 1, 2, 3);

        vector = new Vector3D(1, 2, 3).clone();
        assertVector(vector, 1, 2, 3);

        vector = new Vector3D();
        assertVector(vector, 0, 0, 0);
    }

    @Test
    public void testGetters() {
        Vector3D vector;

        vector = new Vector3D(1, 2, 3);
        Assertions.assertEquals(vector.getSize(), 3);

        vector = new Vector3D(1, 2, 3);
        Assertions.assertEquals(vector.getX(), 1);
        Assertions.assertEquals(vector.getY(), 2);
        Assertions.assertEquals(vector.getZ(), 3);

        vector = new Vector3D(1, 2, 3);
        Assertions.assertEquals(vector.getAxis(Axis.X_INDEX), 1);
        Assertions.assertEquals(vector.getAxis(Axis.Y), 2);

        vector = new Vector3D(1, 2, 3);
        Assertions.assertEquals(vector.getAxisOrZero(Axis.X_INDEX), 1);
        Assertions.assertEquals(vector.getAxisOrZero(Axis.Y), 2);
        Assertions.assertEquals(vector.getAxisOrZero(-1), 0);
        Assertions.assertEquals(vector.getAxisOrZero(new Axis(-1)), 0);
    }

    @Test
    public void testSetters() {
        Vector3D vector;

        vector = new Vector3D(1, 2, 3);
        vector.setX(2);
        vector.setY(3);
        vector.setZ(4);
        assertVector(vector, 2, 3, 4);

        vector = new Vector3D(1, 2, 3);
        vector.setAxis(Axis.X_INDEX, 2);
        vector.setAxis(Axis.Y, 3);
        assertVector(vector, 2, 3, 3);

        vector = new Vector3D(1, 2, 3);
        vector.set(2, 3, 4);
        assertVector(vector, 2, 3, 4);

        vector = new Vector3D(1, 2, 3);
        vector.set(new Vector3D(2, 3, 4));
        assertVector(vector, 2, 3, 4);
    }

    @Test
    public void testMath() {
        Vector3D vector;

        vector = new Vector3D(1, 2, 3);
        vector.addX(1);
        vector.addY(1);
        vector.addZ(1);
        assertVector(vector, 2, 3, 4);

        vector = new Vector3D(1, 2, 3);
        vector.addAxis(Axis.X_INDEX, 1);
        vector.addAxis(Axis.Y, 1);
        assertVector(vector, 2, 3, 3);

        vector = new Vector3D(1, 2, 3);
        vector.add(1, 1, 1);
        assertVector(vector, 2, 3, 4);

        vector = new Vector3D(1, 2, 3);
        vector.add(new Vector3D(1, 1, 1));
        assertVector(vector, 2, 3, 4);

        vector = new Vector3D(1, 2, 3);
        vector.subtractX(1);
        vector.subtractY(1);
        vector.subtractZ(1);
        assertVector(vector, 0, 1, 2);

        vector = new Vector3D(1, 2, 3);
        vector.subtractAxis(Axis.X_INDEX, 1);
        vector.subtractAxis(Axis.Y, 1);
        assertVector(vector, 0, 1, 3);

        vector = new Vector3D(1, 2, 3);
        vector.subtract(1, 1, 1);
        assertVector(vector, 0, 1, 2);

        vector = new Vector3D(1, 2, 3);
        vector.subtract(new Vector3D(1, 1, 1));
        assertVector(vector, 0, 1, 2);

        vector = new Vector3D(1, 2, 3);
        vector.multipleX(2);
        vector.multipleY(2);
        vector.multipleZ(2);
        assertVector(vector, 2, 4, 6);

        vector = new Vector3D(1, 2, 3);
        vector.multipleAxis(Axis.X_INDEX, 2);
        vector.multipleAxis(Axis.Y, 2);
        assertVector(vector, 2, 4, 3);

        vector = new Vector3D(1, 2, 3);
        vector.multiple(2);
        assertVector(vector, 2, 4, 6);

        vector = new Vector3D(1, 2, 3);
        vector.divideX(2);
        vector.divideY(2);
        vector.divideZ(2);
        assertVector(vector, 0.5, 1, 1.5);

        vector = new Vector3D(1, 2, 3);
        vector.divideAxis(Axis.X_INDEX, 2);
        vector.divideAxis(Axis.Y, 2);
        assertVector(vector, 0.5, 1, 3);

        vector = new Vector3D(1, 2, 3);
        vector.divide(2);
        assertVector(vector, 0.5, 1, 1.5);
    }

    @Test
    public void testNormalization() {
        Vector3D vector;

        vector = new Vector3D(1, 2, 3);
        vector.normalize();
        assertVector(vector, 1 / Math.sqrt(14), 2 / Math.sqrt(14), 3 / Math.sqrt(14));

        vector = new Vector3D(1, 2, 3);
        Vector3D normalizedVector = vector.toNormalized();
        assertVector(vector, 1, 2, 3);
        assertVector(normalizedVector, 1 / Math.sqrt(14), 2 / Math.sqrt(14), 3 / Math.sqrt(14));
    }

    @Test
    public void testCalculations() {
        Vector3D vector;

        vector = new Vector3D(1, 2, 3);
        Assertions.assertEquals(vector.length(), Math.sqrt(14));

        vector = new Vector3D(1, 2, 3);
        Assertions.assertEquals(vector.distance(new Vector3D()), Math.sqrt(14));
        Assertions.assertEquals(vector.distance(new Vector3D(1, 2, 3)), 0);
        Assertions.assertEquals(vector.distance(new Vector3D(4, 5, 6)), Math.sqrt(27));
    }
}
