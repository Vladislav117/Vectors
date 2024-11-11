import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.vectors.Axis;
import ru.vladislav117.vectors.Vector2D;

public class Vector2DTests {
    public static final double zeroApprox = 1E-15;
    public static final double accuracy = Math.pow(10, 9);

    protected double round(double number) {
        return ((int) number * accuracy) / accuracy;
    }

    protected void assertVector(Vector2D vector, double x, double y) {
        if (0 < vector.getX() && vector.getX() < zeroApprox) vector.setX(0);
        if (0 < vector.getY() && vector.getY() < zeroApprox) vector.setY(0);
        vector.setX(round(vector.getX()));
        vector.setY(round(vector.getY()));
        x = round(x);
        y = round(y);
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

        vector = Vector2D.fromAngle(Math.PI / 2, 2);
        assertVector(vector, 0, 2);

        vector = Vector2D.fromAngle(Math.PI);
        assertVector(vector, -1, 0);

        vector = Vector2D.fromAngleDegrees(45, 2);
        assertVector(vector, Math.sqrt(2), Math.sqrt(2));

        vector = Vector2D.fromAngleDegrees(-90);
        assertVector(vector, 0, -1);
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

        vector = new Vector2D(1, 1);
        Assertions.assertEquals(vector.angle(), Math.PI / 4);
        Assertions.assertEquals(vector.angleDegrees(), 45);

        vector = new Vector2D(-1, 1);
        Assertions.assertEquals(vector.angle(), 3 * Math.PI / 4);
        Assertions.assertEquals(vector.angleDegrees(), 135);

        vector = new Vector2D(-1, -1);
        Assertions.assertEquals(vector.angle(), 5 * Math.PI / 4);
        Assertions.assertEquals(vector.angleDegrees(), 225);

        vector = new Vector2D(1, -1);
        Assertions.assertEquals(vector.angle(), 7 * Math.PI / 4);
        Assertions.assertEquals(vector.angleDegrees(), 315);

        vector = new Vector2D(0, 0);
        Assertions.assertEquals(vector.angle(), 0);
        Assertions.assertEquals(vector.angleDegrees(), 0);

        vector = new Vector2D(0, 1);
        Assertions.assertEquals(vector.angle(), Math.PI / 2);
        Assertions.assertEquals(vector.angleDegrees(), 90);

        vector = new Vector2D(0, -1);
        Assertions.assertEquals(vector.angle(), 3 * Math.PI / 2);
        Assertions.assertEquals(vector.angleDegrees(), 270);

        Vector2D other;

        vector = new Vector2D(1, 1);
        other = new Vector2D(2, 2);
        Assertions.assertEquals(vector.angleTo(other), Math.PI / 4);
        Assertions.assertEquals(vector.angleDegreesTo(other), 45);

        vector = new Vector2D(1, 1);
        other = new Vector2D(-2, -2);
        Assertions.assertEquals(vector.angleTo(other), 5 * Math.PI / 4);
        Assertions.assertEquals(vector.angleDegreesTo(other), 225);

        vector = new Vector2D(1, 1);
        other = new Vector2D(1, 100);
        Assertions.assertEquals(vector.angleTo(other), Math.PI / 2);
        Assertions.assertEquals(vector.angleDegreesTo(other), 90);

        vector = new Vector2D(1, 1);
        other = new Vector2D(1, -100);
        Assertions.assertEquals(vector.angleTo(other), 3 * Math.PI / 2);
        Assertions.assertEquals(vector.angleDegreesTo(other), 270);

        vector = new Vector2D(1, 1);
        other = new Vector2D(1, 1);
        Assertions.assertEquals(vector.angleTo(other), Math.PI);
        Assertions.assertEquals(vector.angleDegreesTo(other), 180);

        vector = new Vector2D(1, 1);
        other = new Vector2D(-100, 1);
        Assertions.assertEquals(vector.angleTo(other), Math.PI);
        Assertions.assertEquals(vector.angleDegreesTo(other), 180);

        vector = new Vector2D(1, 1);
        other = new Vector2D(100, 1);
        Assertions.assertEquals(vector.angleTo(other), Math.PI * 2);
        Assertions.assertEquals(vector.angleDegreesTo(other), 360);

        vector = new Vector2D(1, 1);
        other = new Vector2D(2, 2);
        Assertions.assertEquals(vector.directionTo(other).getX(), 1 / Math.sqrt(2));
        Assertions.assertEquals(vector.directionTo(other).getY(), 1 / Math.sqrt(2));

        vector = new Vector2D(1, 1);
        other = new Vector2D(1, 2);
        Assertions.assertEquals(vector.directionTo(other).getX(), 0);
        Assertions.assertEquals(vector.directionTo(other).getY(), 1);

        vector = new Vector2D(1, 1);
        other = new Vector2D(3, 1);
        Assertions.assertEquals(vector.vectorTo(other).getX(), 2);
        Assertions.assertEquals(vector.vectorTo(other).getY(), 0);
    }
}
