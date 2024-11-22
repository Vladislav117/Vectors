import org.junit.jupiter.api.AssertionFailureBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.vectors.Axis;
import ru.vladislav117.vectors.Vector1D;
import ru.vladislav117.vectors.Vector5D;

public class Vector5DTests {
    public static final double zeroApprox = 1E-15;
    public static final double accuracy = Math.pow(10, 9);

    protected double round(double number) {
        return ((int) (number * accuracy)) / accuracy;
    }

    protected void assertVector(Vector5D vector, double x, double y, double z, double w, double v) {
        double vectorX = vector.getX();
        double vectorY = vector.getY();
        double vectorZ = vector.getZ();
        double vectorW = vector.getW();
        double vectorV = vector.getV();
        if (0 < Math.abs(vectorX) && Math.abs(vectorX) < zeroApprox) vectorX = 0;
        if (0 < Math.abs(vectorY) && Math.abs(vectorY) < zeroApprox) vectorY = 0;
        if (0 < Math.abs(vectorZ) && Math.abs(vectorZ) < zeroApprox) vectorZ = 0;
        if (0 < Math.abs(vectorW) && Math.abs(vectorW) < zeroApprox) vectorW = 0;
        if (0 < Math.abs(vectorV) && Math.abs(vectorV) < zeroApprox) vectorV = 0;
        vectorX = round(vectorX);
        vectorY = round(vectorY);
        vectorZ = round(vectorZ);
        vectorW = round(vectorW);
        vectorV = round(vectorV);
        x = round(x);
        y = round(y);
        z = round(z);
        w = round(w);
        v = round(v);
        if (vectorX != x || vectorY != y || vectorZ != z || vectorW != w || vectorV != v) {
            AssertionFailureBuilder.assertionFailure()
                    .message("Values of the vectors do not match")
                    .expected("(" + x + ", " + y + ", " + z + ", " + w + ", " + v + ")")
                    .actual("(" + vectorX + ", " + vectorY + ", " + vectorZ + ", " + vectorW + ", " + vectorV + ")")
                    .buildAndThrow();
        }
    }

    @Test
    public void testConstructors() {
        Vector5D vector;

        vector = new Vector5D(1, 2, 3, 4, 5);
        assertVector(vector, 1, 2, 3, 4, 5);

        vector = new Vector5D(new Vector5D(1, 2, 3, 4, 5));
        assertVector(vector, 1, 2, 3, 4, 5);

        vector = new Vector5D(1, 2, 3, 4, 5).clone();
        assertVector(vector, 1, 2, 3, 4, 5);

        vector = new Vector5D();
        assertVector(vector, 0, 0, 0, 0, 0);
    }

    @Test
    public void testGetters() {
        Vector5D vector;

        vector = new Vector5D();
        Assertions.assertEquals(5, vector.getSize());

        vector = new Vector5D(1, 2, 3, 4, 5);
        Assertions.assertEquals(1, vector.getX());
        Assertions.assertEquals(2, vector.getY());
        Assertions.assertEquals(3, vector.getZ());
        Assertions.assertEquals(4, vector.getW());
        Assertions.assertEquals(5, vector.getV());

        vector = new Vector5D(1, 2, 3, 4, 5);
        Assertions.assertEquals(1, vector.getIndex(Axis.X_INDEX));
        Assertions.assertEquals(2, vector.getIndex(Axis.Y_INDEX));
        Assertions.assertEquals(3, vector.getIndex(Axis.Z_INDEX));
        Assertions.assertEquals(4, vector.getIndex(Axis.W_INDEX));
        Assertions.assertEquals(5, vector.getIndex(Axis.V_INDEX));

        vector = new Vector5D(1, 2, 3, 4, 5);
        Assertions.assertEquals(1, vector.getIndexOrZero(Axis.X_INDEX));
        Assertions.assertEquals(2, vector.getIndexOrZero(Axis.Y_INDEX));
        Assertions.assertEquals(3, vector.getIndexOrZero(Axis.Z_INDEX));
        Assertions.assertEquals(4, vector.getIndexOrZero(Axis.W_INDEX));
        Assertions.assertEquals(5, vector.getIndexOrZero(Axis.V_INDEX));
        Assertions.assertEquals(0, vector.getIndexOrZero(-1));
    }

    @Test
    public void testSetters() {
        Vector5D vector;

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.setX(6);
        vector.setY(7);
        vector.setZ(8);
        vector.setW(9);
        vector.setV(10);
        assertVector(vector, 6, 7, 8, 9, 10);

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.setIndex(Axis.X_INDEX, 6);
        vector.setIndex(Axis.Y_INDEX, 7);
        vector.setIndex(Axis.Z_INDEX, 8);
        vector.setIndex(Axis.W_INDEX, 9);
        vector.setIndex(Axis.V_INDEX, 10);
        assertVector(vector, 6, 7, 8, 9, 10);

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.set(6, 7, 8, 9, 10);
        assertVector(vector, 6, 7, 8, 9, 10);

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.set(new Vector5D(6, 7, 8, 9, 10));
        assertVector(vector, 6, 7, 8, 9, 10);
    }

    @Test
    public void testMath() {
        Vector5D vector;

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.addX(5);
        vector.addY(5);
        vector.addZ(5);
        vector.addW(5);
        vector.addV(5);
        assertVector(vector, 6, 7, 8, 9, 10);

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.addIndex(Axis.X_INDEX, 5);
        vector.addIndex(Axis.Y_INDEX, 5);
        vector.addIndex(Axis.Z_INDEX, 5);
        vector.addIndex(Axis.W_INDEX, 5);
        vector.addIndex(Axis.V_INDEX, 5);
        assertVector(vector, 6, 7, 8, 9, 10);

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.add(5, 5, 5, 5, 5);
        assertVector(vector, 6, 7, 8, 9, 10);

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.add(new Vector5D(5, 5, 5, 5, 5));
        assertVector(vector, 6, 7, 8, 9, 10);

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.subtractX(1);
        vector.subtractY(2);
        vector.subtractZ(3);
        vector.subtractW(4);
        vector.subtractV(5);
        assertVector(vector, 0, 0, 0, 0, 0);

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.subtractIndex(Axis.X_INDEX, 1);
        vector.subtractIndex(Axis.Y_INDEX, 2);
        vector.subtractIndex(Axis.Z_INDEX, 3);
        vector.subtractIndex(Axis.W_INDEX, 4);
        vector.subtractIndex(Axis.V_INDEX, 5);
        assertVector(vector, 0, 0, 0, 0, 0);

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.subtract(1, 2, 3, 4, 5);
        assertVector(vector, 0, 0, 0, 0, 0);

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.subtract(new Vector5D(1, 2, 3, 4, 5));
        assertVector(vector, 0, 0, 0, 0, 0);

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.multipleX(2);
        vector.multipleY(2);
        vector.multipleZ(2);
        vector.multipleW(2);
        vector.multipleV(2);
        assertVector(vector, 2, 4, 6, 8, 10);

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.multipleIndex(Axis.X_INDEX, 2);
        vector.multipleIndex(Axis.Y_INDEX, 2);
        vector.multipleIndex(Axis.Z_INDEX, 2);
        vector.multipleIndex(Axis.W_INDEX, 2);
        vector.multipleIndex(Axis.V_INDEX, 2);
        assertVector(vector, 2, 4, 6, 8, 10);

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.multiple(2);
        assertVector(vector, 2, 4, 6, 8, 10);

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.divideX(2);
        vector.divideY(2);
        vector.divideZ(2);
        vector.divideW(2);
        vector.divideV(2);
        assertVector(vector, 0.5, 1, 1.5, 2, 2.5);

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.divideIndex(Axis.X_INDEX, 2);
        vector.divideIndex(Axis.Y_INDEX, 2);
        vector.divideIndex(Axis.Z_INDEX, 2);
        vector.divideIndex(Axis.W_INDEX, 2);
        vector.divideIndex(Axis.V_INDEX, 2);
        assertVector(vector, 0.5, 1, 1.5, 2, 2.5);

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.divide(2);
        assertVector(vector, 0.5, 1, 1.5, 2, 2.5);
    }

    @Test
    public void testCalculations() {
        Vector5D vector;

        vector = new Vector5D(1, 2, 3, 4, 5);
        Assertions.assertEquals(Math.sqrt(55), vector.length());

        vector = new Vector5D(1, 2, 3, 4, 5);
        Assertions.assertEquals(Math.sqrt(55), vector.distance(new Vector5D()));
        Assertions.assertEquals(0, vector.distance(new Vector5D(1, 2, 3, 4, 5)));
        Assertions.assertEquals(Math.sqrt(125), vector.distance(new Vector5D(6, 7, 8, 9, 10)));

        Vector5D other;

        vector = new Vector5D(1, 2, 3, 4, 5);
        other = new Vector5D(10, 10, 10, 10, 10);
        Vector5D vectorTo = vector.vectorTo(other);
        assertVector(vectorTo, 9, 8, 7, 6, 5);

        vector = new Vector5D(1, 1, 1, 1, 1);
        other = new Vector5D(0, 0, 0, 0, 0);
        Vector5D directionTo = vector.directionTo(other);
        assertVector(directionTo, -1 / Math.sqrt(5), -1 / Math.sqrt(5), -1 / Math.sqrt(5), -1 / Math.sqrt(5), -1 / Math.sqrt(5));
    }

    @Test
    public void testNormalization() {
        Vector5D vector;

        vector = new Vector5D(1, 2, 3, 4, 5);
        vector.normalize();
        assertVector(vector, 1 / Math.sqrt(55), 2 / Math.sqrt(55), 3 / Math.sqrt(55), 4 / Math.sqrt(55), 5 / Math.sqrt(55));

        vector = new Vector5D(1, 2, 3, 4, 5);
        Vector5D normalizedVector = vector.toNormalized();
        assertVector(vector, 1, 2, 3, 4, 5);
        assertVector(normalizedVector, 1 / Math.sqrt(55), 2 / Math.sqrt(55), 3 / Math.sqrt(55), 4 / Math.sqrt(55), 5 / Math.sqrt(55));
    }

    @Test
    public void equalsTest() {
        Vector5D vector, other1, other2;
        Vector1D other1D;

        vector = new Vector5D(1, 2, 3, 4, 5);
        other1 = new Vector5D(1, 2, 3, 4, 5);
        other2 = new Vector5D(5, 4, 3, 2, 1);
        other1D = new Vector1D(1);

        Assertions.assertEquals(vector, other1);
        Assertions.assertNotEquals(vector, other2);
        Assertions.assertNotEquals(vector, other1D);
    }
}
