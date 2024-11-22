import org.junit.jupiter.api.AssertionFailureBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.vectors.Axis;
import ru.vladislav117.vectors.Vector1D;
import ru.vladislav117.vectors.Vector3D;

public class Vector3DTests {
    public static final double zeroApprox = 1E-15;
    public static final double accuracy = Math.pow(10, 9);

    protected double round(double number) {
        return ((int) (number * accuracy)) / accuracy;
    }

    protected void assertVector(Vector3D vector, double x, double y, double z) {
        double vectorX = vector.getX();
        double vectorY = vector.getY();
        double vectorZ = vector.getZ();
        if (0 < Math.abs(vectorX) && Math.abs(vectorX) < zeroApprox) vectorX = 0;
        if (0 < Math.abs(vectorY) && Math.abs(vectorY) < zeroApprox) vectorY = 0;
        if (0 < Math.abs(vectorZ) && Math.abs(vectorZ) < zeroApprox) vectorZ = 0;
        vectorX = round(vectorX);
        vectorY = round(vectorY);
        vectorZ = round(vectorZ);
        x = round(x);
        y = round(y);
        z = round(z);
        if (vectorX != x || vectorY != y || vectorZ != z) {
            AssertionFailureBuilder.assertionFailure()
                    .message("Values of the vectors do not match")
                    .expected("(" + x + ", " + y + ", " + z + ")")
                    .actual("(" + vectorX + ", " + vectorY + ", " + vectorZ + ")")
                    .buildAndThrow();
        }
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

        vector = new Vector3D();
        Assertions.assertEquals(3, vector.getSize());

        vector = new Vector3D(1, 2, 3);
        Assertions.assertEquals(1, vector.getX());
        Assertions.assertEquals(2, vector.getY());
        Assertions.assertEquals(3, vector.getZ());

        vector = new Vector3D(1, 2, 3);
        Assertions.assertEquals(1, vector.getIndex(Axis.X_INDEX));
        Assertions.assertEquals(2, vector.getIndex(Axis.Y_INDEX));
        Assertions.assertEquals(3, vector.getIndex(Axis.Z_INDEX));

        vector = new Vector3D(1, 2, 3);
        Assertions.assertEquals(1, vector.getIndexOrZero(Axis.X_INDEX));
        Assertions.assertEquals(2, vector.getIndexOrZero(Axis.Y_INDEX));
        Assertions.assertEquals(3, vector.getIndexOrZero(Axis.Z_INDEX));
        Assertions.assertEquals(0, vector.getIndexOrZero(-1));
    }

    @Test
    public void testSetters() {
        Vector3D vector;

        vector = new Vector3D(1, 2, 3);
        vector.setX(4);
        vector.setY(5);
        vector.setZ(6);
        assertVector(vector, 4, 5, 6);

        vector = new Vector3D(1, 2, 3);
        vector.setIndex(Axis.X_INDEX, 4);
        vector.setIndex(Axis.Y_INDEX, 5);
        vector.setIndex(Axis.Z_INDEX, 6);
        assertVector(vector, 4, 5, 6);

        vector = new Vector3D(1, 2, 3);
        vector.set(4, 5, 6);
        assertVector(vector, 4, 5, 6);

        vector = new Vector3D(1, 2, 3);
        vector.set(new Vector3D(4, 5, 6));
        assertVector(vector, 4, 5, 6);
    }

    @Test
    public void testMath() {
        Vector3D vector;

        vector = new Vector3D(1, 2, 3);
        vector.addX(1);
        vector.addY(2);
        vector.addZ(3);
        assertVector(vector, 2, 4, 6);

        vector = new Vector3D(1, 2, 3);
        vector.addIndex(Axis.X_INDEX, 1);
        vector.addIndex(Axis.Y_INDEX, 2);
        vector.addIndex(Axis.Z_INDEX, 3);
        assertVector(vector, 2, 4, 6);

        vector = new Vector3D(1, 2, 3);
        vector.add(1, 2, 3);
        assertVector(vector, 2, 4, 6);

        vector = new Vector3D(1, 2, 3);
        vector.add(new Vector3D(1, 2, 3));
        assertVector(vector, 2, 4, 6);

        vector = new Vector3D(1, 2, 3);
        vector.subtractX(1);
        vector.subtractY(2);
        vector.subtractZ(3);
        assertVector(vector, 0, 0, 0);

        vector = new Vector3D(1, 2, 3);
        vector.subtractIndex(Axis.X_INDEX, 1);
        vector.subtractIndex(Axis.Y_INDEX, 2);
        vector.subtractIndex(Axis.Z_INDEX, 3);
        assertVector(vector, 0, 0, 0);

        vector = new Vector3D(1, 2, 3);
        vector.subtract(1, 2, 3);
        assertVector(vector, 0, 0, 0);

        vector = new Vector3D(1, 2, 3);
        vector.subtract(new Vector3D(1, 2, 3));
        assertVector(vector, 0, 0, 0);

        vector = new Vector3D(1, 2, 3);
        vector.multipleX(2);
        vector.multipleY(2);
        vector.multipleZ(2);
        assertVector(vector, 2, 4, 6);

        vector = new Vector3D(1, 2, 3);
        vector.multipleIndex(Axis.X_INDEX, 2);
        vector.multipleIndex(Axis.Y_INDEX, 2);
        vector.multipleIndex(Axis.Z_INDEX, 2);
        assertVector(vector, 2, 4, 6);

        vector = new Vector3D(1, 2, 3);
        vector.multiple(2);
        assertVector(vector, 2, 4, 6);

        vector = new Vector3D(1, 2, 3);
        vector.divideX(2);
        vector.divideY(2);
        vector.divideZ(2);
        assertVector(vector, 0.5, 1, 1.5);

        vector = new Vector3D(1, 2, 3);
        vector.divideIndex(Axis.X_INDEX, 2);
        vector.divideIndex(Axis.Y_INDEX, 2);
        vector.divideIndex(Axis.Z_INDEX, 2);
        assertVector(vector, 0.5, 1, 1.5);

        vector = new Vector3D(1, 2, 3);
        vector.divide(2);
        assertVector(vector,  0.5, 1, 1.5);
    }

    @Test
    public void testCalculations() {
        Vector3D vector;

        vector = new Vector3D(1, 2, 3);
        Assertions.assertEquals(Math.sqrt(14), vector.length());

        vector = new Vector3D(1, 2, 3);
        Assertions.assertEquals(Math.sqrt(14), vector.distance(new Vector3D()));
        Assertions.assertEquals(0, vector.distance(new Vector3D(1, 2, 3)));
        Assertions.assertEquals(Math.sqrt(27), vector.distance(new Vector3D(4, 5, 6)));

        Vector3D other;

        vector = new Vector3D(1, 2, 3);
        other = new Vector3D(10, 10, 10);
        Vector3D vectorTo = vector.vectorTo(other);
        assertVector(vectorTo, 9, 8, 7);

        vector = new Vector3D(1, 1, 1);
        other = new Vector3D(0, 0, 0);
        Vector3D directionTo = vector.directionTo(other);
        assertVector(directionTo, -1 / Math.sqrt(3), -1 / Math.sqrt(3), -1 / Math.sqrt(3));
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
    public void equalsTest() {
        Vector3D vector, other1, other2;
        Vector1D other1D;

        vector = new Vector3D(1, 2, 3);
        other1 = new Vector3D(1, 2, 3);
        other2 = new Vector3D(5, 4, 3);
        other1D = new Vector1D(1);

        Assertions.assertEquals(vector, other1);
        Assertions.assertNotEquals(vector, other2);
        Assertions.assertNotEquals(vector, other1D);
    }
}
