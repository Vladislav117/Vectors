import org.junit.jupiter.api.AssertionFailureBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.vectors.Axis;
import ru.vladislav117.vectors.Vector1D;
import ru.vladislav117.vectors.Vector2D;

public class Vector2DTests {
    public static final double zeroApprox = 1E-15;
    public static final double accuracy = Math.pow(10, 9);

    protected double round(double number) {
        return ((int) (number * accuracy)) / accuracy;
    }

    protected void assertVector(Vector2D vector, double x, double y) {
        double vectorX = vector.getX();
        double vectorY = vector.getY();
        if (0 < Math.abs(vectorX) && Math.abs(vectorX) < zeroApprox) vectorX = 0;
        if (0 < Math.abs(vectorY) && Math.abs(vectorY) < zeroApprox) vectorY = 0;
        vectorX = round(vectorX);
        vectorY = round(vectorY);
        x = round(x);
        y = round(y);
        if (vectorX != x || vectorY != y) {
            AssertionFailureBuilder.assertionFailure()
                    .message("Values of the vectors do not match")
                    .expected("(" + x + ", " + y + ")")
                    .actual("(" + vectorX + ", " + vectorY + ")")
                    .buildAndThrow();
        }
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

        vector = new Vector2D();
        Assertions.assertEquals(2, vector.getSize());

        vector = new Vector2D(1, 2);
        Assertions.assertEquals(1, vector.getX());
        Assertions.assertEquals(2, vector.getY());

        vector = new Vector2D(1, 2);
        Assertions.assertEquals(1, vector.getIndex(Axis.X_INDEX));
        Assertions.assertEquals(2, vector.getIndex(Axis.Y_INDEX));

        vector = new Vector2D(1, 2);
        Assertions.assertEquals(1, vector.getIndexOrZero(Axis.X_INDEX));
        Assertions.assertEquals(2, vector.getIndexOrZero(Axis.Y_INDEX));
        Assertions.assertEquals(0, vector.getIndexOrZero(-1));
    }

    @Test
    public void testSetters() {
        Vector2D vector;

        vector = new Vector2D(1, 2);
        vector.setX(3);
        vector.setY(4);
        assertVector(vector, 3, 4);

        vector = new Vector2D(1, 2);
        vector.setIndex(Axis.X_INDEX, 3);
        vector.setIndex(Axis.Y_INDEX, 4);
        assertVector(vector, 3, 4);

        vector = new Vector2D(1, 2);
        vector.set(3, 4);
        assertVector(vector, 3, 4);

        vector = new Vector2D(1, 2);
        vector.set(new Vector2D(3, 4));
        assertVector(vector, 3, 4);
    }

    @Test
    public void testMath() {
        Vector2D vector;

        vector = new Vector2D(1, 2);
        vector.addX(1);
        vector.addY(2);
        assertVector(vector, 2, 4);

        vector = new Vector2D(1, 2);
        vector.addIndex(Axis.X_INDEX, 1);
        vector.addIndex(Axis.Y_INDEX, 2);
        assertVector(vector, 2, 4);

        vector = new Vector2D(1, 2);
        vector.add(1, 2);
        assertVector(vector, 2, 4);

        vector = new Vector2D(1, 2);
        vector.add(new Vector2D(1, 2));
        assertVector(vector, 2, 4);

        vector = new Vector2D(1, 2);
        vector.subtractX(1);
        vector.subtractY(2);
        assertVector(vector, 0, 0);

        vector = new Vector2D(1, 2);
        vector.subtractIndex(Axis.X_INDEX, 1);
        vector.subtractIndex(Axis.Y_INDEX, 2);
        assertVector(vector, 0, 0);

        vector = new Vector2D(1, 2);
        vector.subtract(1, 2);
        assertVector(vector, 0, 0);

        vector = new Vector2D(1, 2);
        vector.subtract(new Vector2D(1, 2));
        assertVector(vector, 0, 0);

        vector = new Vector2D(1, 2);
        vector.multipleX(2);
        vector.multipleY(2);
        assertVector(vector, 2, 4);

        vector = new Vector2D(1, 2);
        vector.multipleIndex(Axis.X_INDEX, 2);
        vector.multipleIndex(Axis.Y_INDEX, 2);
        assertVector(vector, 2, 4);

        vector = new Vector2D(1, 2);
        vector.multiple(2);
        assertVector(vector, 2, 4);

        vector = new Vector2D(1, 2);
        vector.divideX(2);
        vector.divideY(2);
        assertVector(vector, 0.5, 1);

        vector = new Vector2D(1, 2);
        vector.divideIndex(Axis.X_INDEX, 2);
        vector.divideIndex(Axis.Y_INDEX, 2);
        assertVector(vector, 0.5, 1);

        vector = new Vector2D(1, 2);
        vector.divide(2);
        assertVector(vector, 0.5, 1);
    }

    @Test
    public void testCalculations() {
        Vector2D vector;

        vector = new Vector2D(1, 2);
        Assertions.assertEquals(Math.sqrt(5), vector.length());

        vector = new Vector2D(1, 2);
        Assertions.assertEquals(Math.sqrt(5), vector.distance(new Vector2D()));
        Assertions.assertEquals(0, vector.distance(new Vector2D(1, 2)));
        Assertions.assertEquals(Math.sqrt(8), vector.distance(new Vector2D(3, 4)));

        Vector2D other;

        vector = new Vector2D(1, 2);
        other = new Vector2D(10, 10);
        Vector2D vectorTo = vector.vectorTo(other);
        assertVector(vectorTo, 9, 8);

        vector = new Vector2D(1, 1);
        other = new Vector2D(0, 0);
        Vector2D directionTo = vector.directionTo(other);
        assertVector(directionTo, -1 / Math.sqrt(2), -1 / Math.sqrt(2));
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
    public void equalsTest() {
        Vector2D vector, other1, other2;
        Vector1D other1D;

        vector = new Vector2D(1, 2);
        other1 = new Vector2D(1, 2);
        other2 = new Vector2D(5, 4);
        other1D = new Vector1D(1);

        Assertions.assertEquals(vector, other1);
        Assertions.assertNotEquals(vector, other2);
        Assertions.assertNotEquals(vector, other1D);
    }
}
