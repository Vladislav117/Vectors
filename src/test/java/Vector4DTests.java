import org.junit.jupiter.api.AssertionFailureBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.vectors.Axis;
import ru.vladislav117.vectors.Vector1D;
import ru.vladislav117.vectors.Vector4D;

public class Vector4DTests {
    public static final double zeroApprox = 1E-15;
    public static final double accuracy = Math.pow(10, 9);

    protected double round(double number) {
        return ((int) (number * accuracy)) / accuracy;
    }

    protected void assertVector(Vector4D vector, double x, double y, double z, double w) {
        double vectorX = vector.getX();
        double vectorY = vector.getY();
        double vectorZ = vector.getZ();
        double vectorW = vector.getW();
        if (0 < Math.abs(vectorX) && Math.abs(vectorX) < zeroApprox) vectorX = 0;
        if (0 < Math.abs(vectorY) && Math.abs(vectorY) < zeroApprox) vectorY = 0;
        if (0 < Math.abs(vectorZ) && Math.abs(vectorZ) < zeroApprox) vectorZ = 0;
        if (0 < Math.abs(vectorW) && Math.abs(vectorW) < zeroApprox) vectorW = 0;
        vectorX = round(vectorX);
        vectorY = round(vectorY);
        vectorZ = round(vectorZ);
        vectorW = round(vectorW);
        x = round(x);
        y = round(y);
        z = round(z);
        w = round(w);
        if (vectorX != x || vectorY != y || vectorZ != z || vectorW != w) {
            AssertionFailureBuilder.assertionFailure()
                    .message("Values of the vectors do not match")
                    .expected("(" + x + ", " + y + ", " + z + ", " + w + ")")
                    .actual("(" + vectorX + ", " + vectorY + ", " + vectorZ + ", " + vectorW + ")")
                    .buildAndThrow();
        }
    }

    @Test
    public void testConstructors() {
        Vector4D vector;

        vector = new Vector4D(1, 2, 3, 4);
        assertVector(vector, 1, 2, 3, 4);

        vector = new Vector4D(new Vector4D(1, 2, 3, 4));
        assertVector(vector, 1, 2, 3, 4);

        vector = new Vector4D(1, 2, 3, 4).clone();
        assertVector(vector, 1, 2, 3, 4);

        vector = new Vector4D();
        assertVector(vector, 0, 0, 0, 0);
    }

    @Test
    public void testGetters() {
        Vector4D vector;

        vector = new Vector4D();
        Assertions.assertEquals(4, vector.getSize());

        vector = new Vector4D(1, 2, 3, 4);
        Assertions.assertEquals(1, vector.getX());
        Assertions.assertEquals(2, vector.getY());
        Assertions.assertEquals(3, vector.getZ());
        Assertions.assertEquals(4, vector.getW());

        vector = new Vector4D(1, 2, 3, 4);
        Assertions.assertEquals(1, vector.getIndex(Axis.X_INDEX));
        Assertions.assertEquals(2, vector.getIndex(Axis.Y_INDEX));
        Assertions.assertEquals(3, vector.getIndex(Axis.Z_INDEX));
        Assertions.assertEquals(4, vector.getIndex(Axis.W_INDEX));

        vector = new Vector4D(1, 2, 3, 4);
        Assertions.assertEquals(1, vector.getIndexOrZero(Axis.X_INDEX));
        Assertions.assertEquals(2, vector.getIndexOrZero(Axis.Y_INDEX));
        Assertions.assertEquals(3, vector.getIndexOrZero(Axis.Z_INDEX));
        Assertions.assertEquals(4, vector.getIndexOrZero(Axis.W_INDEX));
        Assertions.assertEquals(0, vector.getIndexOrZero(-1));
    }

    @Test
    public void testSetters() {
        Vector4D vector;

        vector = new Vector4D(1, 2, 3, 4);
        vector.setX(5);
        vector.setY(6);
        vector.setZ(7);
        vector.setW(8);
        assertVector(vector, 5, 6, 7, 8);

        vector = new Vector4D(1, 2, 3, 4);
        vector.setIndex(Axis.X_INDEX, 5);
        vector.setIndex(Axis.Y_INDEX, 6);
        vector.setIndex(Axis.Z_INDEX, 7);
        vector.setIndex(Axis.W_INDEX, 8);
        assertVector(vector, 5, 6, 7, 8);

        vector = new Vector4D(1, 2, 3, 4);
        vector.set(5, 6, 7, 8);
        assertVector(vector, 5, 6, 7, 8);

        vector = new Vector4D(1, 2, 3, 4);
        vector.set(new Vector4D(5, 6, 7, 8));
        assertVector(vector, 5, 6, 7, 8);
    }

    @Test
    public void testMath() {
        Vector4D vector;

        vector = new Vector4D(1, 2, 3, 4);
        vector.addX(4);
        vector.addY(4);
        vector.addZ(4);
        vector.addW(4);
        assertVector(vector, 5, 6, 7, 8);

        vector = new Vector4D(1, 2, 3, 4);
        vector.addIndex(Axis.X_INDEX, 4);
        vector.addIndex(Axis.Y_INDEX, 4);
        vector.addIndex(Axis.Z_INDEX, 4);
        vector.addIndex(Axis.W_INDEX, 4);
        assertVector(vector, 5, 6, 7, 8);

        vector = new Vector4D(1, 2, 3, 4);
        vector.add(4, 4, 4, 4);
        assertVector(vector, 5, 6, 7, 8);

        vector = new Vector4D(1, 2, 3, 4);
        vector.add(new Vector4D(4, 4, 4, 4));
        assertVector(vector, 5, 6, 7, 8);

        vector = new Vector4D(1, 2, 3, 4);
        vector.subtractX(1);
        vector.subtractY(2);
        vector.subtractZ(3);
        vector.subtractW(4);
        assertVector(vector, 0, 0, 0, 0);

        vector = new Vector4D(1, 2, 3, 4);
        vector.subtractIndex(Axis.X_INDEX, 1);
        vector.subtractIndex(Axis.Y_INDEX, 2);
        vector.subtractIndex(Axis.Z_INDEX, 3);
        vector.subtractIndex(Axis.W_INDEX, 4);
        assertVector(vector, 0, 0, 0, 0);

        vector = new Vector4D(1, 2, 3, 4);
        vector.subtract(1, 2, 3, 4);
        assertVector(vector, 0, 0, 0, 0);

        vector = new Vector4D(1, 2, 3, 4);
        vector.subtract(new Vector4D(1, 2, 3, 4));
        assertVector(vector, 0, 0, 0, 0);

        vector = new Vector4D(1, 2, 3, 4);
        vector.multipleX(2);
        vector.multipleY(2);
        vector.multipleZ(2);
        vector.multipleW(2);
        assertVector(vector, 2, 4, 6, 8);

        vector = new Vector4D(1, 2, 3, 4);
        vector.multipleIndex(Axis.X_INDEX, 2);
        vector.multipleIndex(Axis.Y_INDEX, 2);
        vector.multipleIndex(Axis.Z_INDEX, 2);
        vector.multipleIndex(Axis.W_INDEX, 2);
        assertVector(vector, 2, 4, 6, 8);

        vector = new Vector4D(1, 2, 3, 4);
        vector.multiple(2);
        assertVector(vector, 2, 4, 6, 8);

        vector = new Vector4D(1, 2, 3, 4);
        vector.divideX(2);
        vector.divideY(2);
        vector.divideZ(2);
        vector.divideW(2);
        assertVector(vector, 0.5, 1, 1.5, 2);

        vector = new Vector4D(1, 2, 3, 4);
        vector.divideIndex(Axis.X_INDEX, 2);
        vector.divideIndex(Axis.Y_INDEX, 2);
        vector.divideIndex(Axis.Z_INDEX, 2);
        vector.divideIndex(Axis.W_INDEX, 2);
        assertVector(vector, 0.5, 1, 1.5, 2);

        vector = new Vector4D(1, 2, 3, 4);
        vector.divide(2);
        assertVector(vector, 0.5, 1, 1.5, 2);
    }

    @Test
    public void testCalculations() {
        Vector4D vector;

        vector = new Vector4D(1, 2, 3, 4);
        Assertions.assertEquals(Math.sqrt(30), vector.length());

        vector = new Vector4D(1, 2, 3, 4);
        Assertions.assertEquals(Math.sqrt(30), vector.distance(new Vector4D()));
        Assertions.assertEquals(0, vector.distance(new Vector4D(1, 2, 3, 4)));
        Assertions.assertEquals(8, vector.distance(new Vector4D(5, 6, 7, 8)));

        Vector4D other;

        vector = new Vector4D(1, 2, 3, 4);
        other = new Vector4D(8, 8, 8, 8);
        Vector4D vectorTo = vector.vectorTo(other);
        assertVector(vectorTo, 7, 6, 5, 4);

        vector = new Vector4D(1, 1, 1, 1);
        other = new Vector4D(0, 0, 0, 0);
        Vector4D directionTo = vector.directionTo(other);
        assertVector(directionTo, -1 / Math.sqrt(4), -1 / Math.sqrt(4), -1 / Math.sqrt(4), -1 / Math.sqrt(4));
    }

    @Test
    public void testNormalization() {
        Vector4D vector;

        vector = new Vector4D(1, 2, 3, 4);
        vector.normalize();
        assertVector(vector, 1 / Math.sqrt(30), 2 / Math.sqrt(30), 3 / Math.sqrt(30), 4 / Math.sqrt(30));

        vector = new Vector4D(1, 2, 3, 4);
        Vector4D normalizedVector = vector.toNormalized();
        assertVector(vector, 1, 2, 3, 4);
        assertVector(normalizedVector, 1 / Math.sqrt(30), 2 / Math.sqrt(30), 3 / Math.sqrt(30), 4 / Math.sqrt(30));
    }

    @Test
    public void equalsTest() {
        Vector4D vector, other1, other2;
        Vector1D other1D;

        vector = new Vector4D(1, 2, 3, 4);
        other1 = new Vector4D(1, 2, 3, 4);
        other2 = new Vector4D(5, 4, 3, 2);
        other1D = new Vector1D(1);

        Assertions.assertEquals(vector, other1);
        Assertions.assertNotEquals(vector, other2);
        Assertions.assertNotEquals(vector, other1D);
    }
}
