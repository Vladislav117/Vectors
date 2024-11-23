import org.junit.jupiter.api.AssertionFailureBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.vectors.Axis;
import ru.vladislav117.vectors.Vector1D;
import ru.vladislav117.vectors.ArrayVector;

public class ArrayVectorTests {
    public static final double zeroApprox = 1E-15;
    public static final double accuracy = Math.pow(10, 9);

    protected double round(double number) {
        return ((int) (number * accuracy)) / accuracy;
    }

    protected void assertVector(ArrayVector vector, double x, double y, double z) {
        double vectorX = vector.getIndex(0);
        double vectorY = vector.getIndex(1);
        double vectorZ = vector.getIndex(2);
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
        ArrayVector vector;

        vector = new ArrayVector(new double[]{1, 2, 3});
        assertVector(vector, 1, 2, 3);

        vector = new ArrayVector(3);
        assertVector(vector, 0, 0, 0);

        vector = new ArrayVector(new double[]{1, 2, 3}).clone();
        assertVector(vector, 1, 2, 3);
    }

    @Test
    public void testGetters() {
        ArrayVector vector;

        vector = new ArrayVector(3);
        Assertions.assertEquals(3, vector.getSize());

        vector = new ArrayVector(new double[]{1, 2, 3});
        Assertions.assertEquals(1, vector.getIndex(Axis.X_INDEX));
        Assertions.assertEquals(2, vector.getIndex(Axis.Y_INDEX));
        Assertions.assertEquals(3, vector.getIndex(Axis.Z_INDEX));

        vector = new ArrayVector(new double[]{1, 2, 3});
        Assertions.assertEquals(1, vector.getIndexOrZero(Axis.X_INDEX));
        Assertions.assertEquals(2, vector.getIndexOrZero(Axis.Y_INDEX));
        Assertions.assertEquals(3, vector.getIndexOrZero(Axis.Z_INDEX));
        Assertions.assertEquals(0, vector.getIndexOrZero(-1));
    }

    @Test
    public void testSetters() {
        ArrayVector vector;

        vector = new ArrayVector(new double[]{1, 2, 3});
        vector.setIndex(Axis.X_INDEX, 4);
        vector.setIndex(Axis.Y_INDEX, 5);
        vector.setIndex(Axis.Z_INDEX, 6);
        assertVector(vector, 4, 5, 6);

        vector = new ArrayVector(new double[]{1, 2, 3});
        vector.set(new ArrayVector(new double[]{4, 5, 6}));
        assertVector(vector, 4, 5, 6);
    }

    @Test
    public void testMath() {
        ArrayVector vector;

        vector = new ArrayVector(new double[]{1, 2, 3});
        vector.addIndex(Axis.X_INDEX, 1);
        vector.addIndex(Axis.Y_INDEX, 2);
        vector.addIndex(Axis.Z_INDEX, 3);
        assertVector(vector, 2, 4, 6);

        vector = new ArrayVector(new double[]{1, 2, 3});
        vector.add(new ArrayVector(new double[]{1, 2, 3}));
        assertVector(vector, 2, 4, 6);

        vector = new ArrayVector(new double[]{1, 2, 3});
        vector.subtractIndex(Axis.X_INDEX, 1);
        vector.subtractIndex(Axis.Y_INDEX, 2);
        vector.subtractIndex(Axis.Z_INDEX, 3);
        assertVector(vector, 0, 0, 0);

        vector = new ArrayVector(new double[]{1, 2, 3});
        vector.subtract(new ArrayVector(new double[]{1, 2, 3}));
        assertVector(vector, 0, 0, 0);

        vector = new ArrayVector(new double[]{1, 2, 3});
        vector.multipleIndex(Axis.X_INDEX, 2);
        vector.multipleIndex(Axis.Y_INDEX, 2);
        vector.multipleIndex(Axis.Z_INDEX, 2);
        assertVector(vector, 2, 4, 6);

        vector = new ArrayVector(new double[]{1, 2, 3});
        vector.multiple(2);
        assertVector(vector, 2, 4, 6);

        vector = new ArrayVector(new double[]{1, 2, 3});
        vector.divideIndex(Axis.X_INDEX, 2);
        vector.divideIndex(Axis.Y_INDEX, 2);
        vector.divideIndex(Axis.Z_INDEX, 2);
        assertVector(vector, 0.5, 1, 1.5);

        vector = new ArrayVector(new double[]{1, 2, 3});
        vector.divide(2);
        assertVector(vector, 0.5, 1, 1.5);
    }

    @Test
    public void testCalculations() {
        ArrayVector vector;

        vector = new ArrayVector(new double[]{1, 2, 3});
        Assertions.assertEquals(Math.sqrt(14), vector.length());

        vector = new ArrayVector(new double[]{1, 2, 3});
        Assertions.assertEquals(Math.sqrt(14), vector.distance(new ArrayVector(3)));
        Assertions.assertEquals(0, vector.distance(new ArrayVector(new double[]{1, 2, 3})));
        Assertions.assertEquals(Math.sqrt(27), vector.distance(new ArrayVector(new double[]{4, 5, 6})));

        ArrayVector other;

        vector = new ArrayVector(new double[]{1, 2, 3});
        other = new ArrayVector(new double[]{10, 10, 10});
        ArrayVector vectorTo = vector.vectorTo(other);
        assertVector(vectorTo, 9, 8, 7);

        vector = new ArrayVector(new double[]{1, 1, 1});
        other = new ArrayVector(new double[]{0, 0, 0});
        ArrayVector directionTo = vector.directionTo(other);
        assertVector(directionTo, -1 / Math.sqrt(3), -1 / Math.sqrt(3), -1 / Math.sqrt(3));
    }

    @Test
    public void testNormalization() {
        ArrayVector vector;

        vector = new ArrayVector(new double[]{1, 2, 3});
        vector.normalize();
        assertVector(vector, 1 / Math.sqrt(14), 2 / Math.sqrt(14), 3 / Math.sqrt(14));

        vector = new ArrayVector(new double[]{1, 2, 3});
        ArrayVector normalizedVector = vector.toNormalized();
        assertVector(vector, 1, 2, 3);
        assertVector(normalizedVector, 1 / Math.sqrt(14), 2 / Math.sqrt(14), 3 / Math.sqrt(14));
    }

    @Test
    public void equalsTest() {
        ArrayVector vector, other1, other2;
        Vector1D other1D;

        vector = new ArrayVector(new double[]{1, 2, 3});
        other1 = new ArrayVector(new double[]{1, 2, 3});
        other2 = new ArrayVector(new double[]{5, 4, 3});
        other1D = new Vector1D(1);

        Assertions.assertEquals(vector, other1);
        Assertions.assertNotEquals(vector, other2);
        Assertions.assertNotEquals(vector, other1D);
    }
}
