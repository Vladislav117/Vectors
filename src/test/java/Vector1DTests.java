import org.junit.jupiter.api.AssertionFailureBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.vectors.Axis;
import ru.vladislav117.vectors.Vector1D;
import ru.vladislav117.vectors.Vector5D;

public class Vector1DTests {
    public static final double zeroApprox = 1E-15;
    public static final double accuracy = Math.pow(10, 9);

    protected double round(double number) {
        return ((int) (number * accuracy)) / accuracy;
    }

    protected void assertVector(Vector1D vector, double x) {
        double vectorX = vector.getX();
        if (0 < Math.abs(vectorX) && Math.abs(vectorX) < zeroApprox) vectorX = 0;
        vectorX = round(vectorX);
        x = round(x);
        if (vectorX != x) {
            AssertionFailureBuilder.assertionFailure()
                    .message("Values of the vectors do not match")
                    .expected("(" + x + ")")
                    .actual("(" + vectorX + ")")
                    .buildAndThrow();
        }
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

        vector = new Vector1D();
        Assertions.assertEquals(1, vector.getSize());

        vector = new Vector1D(1);
        Assertions.assertEquals(1, vector.getX());

        vector = new Vector1D(1);
        Assertions.assertEquals(1, vector.getIndex(Axis.X_INDEX));

        vector = new Vector1D(1);
        Assertions.assertEquals(1, vector.getIndexOrZero(Axis.X_INDEX));
        Assertions.assertEquals(0, vector.getIndexOrZero(-1));
    }

    @Test
    public void testSetters() {
        Vector1D vector;

        vector = new Vector1D(1);
        vector.setX(2);
        assertVector(vector, 2);

        vector = new Vector1D(1);
        vector.setIndex(Axis.X_INDEX, 2);
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
        vector.addIndex(Axis.X_INDEX, 1);
        assertVector(vector, 2);

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
        vector.subtractIndex(Axis.X_INDEX, 1);
        assertVector(vector, 0);

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
        vector.multipleIndex(Axis.X_INDEX, 2);
        assertVector(vector, 2);

        vector = new Vector1D(1);
        vector.multiple(2);
        assertVector(vector, 2);

        vector = new Vector1D(1);
        vector.divideX(2);
        assertVector(vector, 0.5);

        vector = new Vector1D(1);
        vector.divideIndex(Axis.X_INDEX, 2);
        assertVector(vector, 0.5);

        vector = new Vector1D(1);
        vector.divide(2);
        assertVector(vector, 0.5);
    }

    @Test
    public void testCalculations() {
        Vector1D vector;

        vector = new Vector1D(1);
        Assertions.assertEquals(1, vector.length());

        vector = new Vector1D(1);
        Assertions.assertEquals(1, vector.distance(new Vector1D()));
        Assertions.assertEquals(0, vector.distance(new Vector1D(1)));
        Assertions.assertEquals(2, vector.distance(new Vector1D(3)));

        Vector1D other;

        vector = new Vector1D(1);
        other = new Vector1D(10);
        Vector1D vectorTo = vector.vectorTo(other);
        assertVector(vectorTo, 9);

        vector = new Vector1D(1);
        other = new Vector1D(0);
        Vector1D directionTo = vector.directionTo(other);
        assertVector(directionTo, -1);
    }

    @Test
    public void testNormalization() {
        Vector1D vector;

        vector = new Vector1D(2);
        vector.normalize();
        assertVector(vector, 1);

        vector = new Vector1D(-2);
        Vector1D normalizedVector = vector.toNormalized();
        assertVector(vector, -2);
        assertVector(normalizedVector, -1);
    }

    @Test
    public void equalsTest() {
        Vector1D vector, other1, other2;
        Vector5D other5D1, other5D2;

        vector = new Vector1D(1);
        other1 = new Vector1D(1);
        other2 = new Vector1D(5);
        other5D1 = new Vector5D(1, 2, 3, 4, 5);
        other5D2 = new Vector5D(5, 4, 3, 2, 1);

        Assertions.assertEquals(vector, other1);
        Assertions.assertNotEquals(vector, other2);
        Assertions.assertEquals(vector, other5D1);
        Assertions.assertNotEquals(vector, other5D2);
    }
}
