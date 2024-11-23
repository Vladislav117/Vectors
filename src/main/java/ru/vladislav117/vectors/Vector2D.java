package ru.vladislav117.vectors;

import ru.vladislav117.vectors.error.VectorIndexError;

import java.util.Objects;

/**
 * Вектор в двумерном пространстве.
 */
public class Vector2D implements Vector {
    /**
     * Размер вектора.
     */
    public static final int SIZE = 2;
    /**
     * Значение по оси абсцисс (x).
     */
    protected double x;
    /**
     * Значение по оси ординат (y).
     */
    protected double y;

    /**
     * Создание двумерного вектора.
     *
     * @param x Значение по оси абсцисс (x)
     * @param y Значение по оси ординат (y)
     */
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Создание двумерного вектора на основе другого вектора.
     * Если у векторов совпадают не все индексы значений, то значения по таким индексам будут взяты за 0.
     *
     * @param vector Вектор, значения по осям которого будут взяты
     */
    public Vector2D(Vector vector) {
        if (vector instanceof Vector2D vector2D) {
            x = vector2D.x;
            y = vector2D.y;
            return;
        }
        x = vector.getIndexOrZero(Axis.X_INDEX);
        y = vector.getIndexOrZero(Axis.Y_INDEX);
    }

    /**
     * Создание двумерного вектора с нулевыми значениями.
     */
    public Vector2D() {
        x = 0;
        y = 0;
    }

    @Override
    public Vector2D clone() {
        try {
            Vector2D cloned = (Vector2D) super.clone();
            cloned.x = x;
            cloned.y = y;
            return cloned;
        } catch (CloneNotSupportedException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public int getSize() {
        return SIZE;
    }

    @Override
    public boolean containsIndex(int index) {
        return index == Axis.X_INDEX || index == Axis.Y_INDEX;
    }

    /**
     * Получение значения по оси абсцисс (x).
     *
     * @return Значение по оси абсцисс (x).
     */
    public double getX() {
        return x;
    }

    /**
     * Получение значения по оси ординат (y).
     *
     * @return Значение по оси ординат (y).
     */
    public double getY() {
        return y;
    }

    @Override
    public double getIndex(int index) {
        return switch (index) {
            case Axis.X_INDEX -> x;
            case Axis.Y_INDEX -> y;
            default -> throw new VectorIndexError(index);
        };
    }

    @Override
    public double getIndexOrZero(int index) {
        return switch (index) {
            case Axis.X_INDEX -> x;
            case Axis.Y_INDEX -> y;
            default -> 0;
        };
    }

    /**
     * Установка значения по оси абсцисс (x).
     *
     * @param x Значение по оси абсцисс (x)
     * @return Этот же вектор.
     */
    public Vector2D setX(double x) {
        this.x = x;
        return this;
    }

    /**
     * Установка значения по оси ординат (y).
     *
     * @param y Значение по оси ординат (y)
     * @return Этот же вектор.
     */
    public Vector2D setY(double y) {
        this.y = y;
        return this;
    }

    @Override
    public Vector2D setIndex(int index, double value) {
        switch (index) {
            case Axis.X_INDEX -> x = value;
            case Axis.Y_INDEX -> y = value;
            default -> throw new VectorIndexError(index);
        }
        return this;
    }

    /**
     * Прибавление к значению по оси абсцисс (x).
     *
     * @param summand Слагаемое
     * @return Этот же вектор.
     */
    public Vector2D addX(double summand) {
        x += summand;
        return this;
    }

    /**
     * Прибавление к значению по оси ординат (y).
     *
     * @param summand Слагаемое
     * @return Этот же вектор.
     */
    public Vector2D addY(double summand) {
        y += summand;
        return this;
    }

    @Override
    public Vector2D addIndex(int index, double summand) {
        switch (index) {
            case Axis.X_INDEX -> x += summand;
            case Axis.Y_INDEX -> y += summand;
            default -> throw new VectorIndexError(index);
        }
        return this;
    }

    /**
     * Вычитание из значения по оси абсцисс (x).
     *
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     */
    public Vector2D subtractX(double subtrahend) {
        x -= subtrahend;
        return this;
    }

    /**
     * Вычитание из значения по оси ординат (y).
     *
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     */
    public Vector2D subtractY(double subtrahend) {
        y -= subtrahend;
        return this;
    }

    @Override
    public Vector2D subtractIndex(int index, double subtrahend) {
        switch (index) {
            case Axis.X_INDEX -> x -= subtrahend;
            case Axis.Y_INDEX -> y -= subtrahend;
            default -> throw new VectorIndexError(index);
        }
        return this;
    }

    /**
     * Умножение значения по оси абсцисс (x).
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    public Vector2D multipleX(double multiplier) {
        x *= multiplier;
        return this;
    }

    /**
     * Умножение значения по оси ординат (y).
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    public Vector2D multipleY(double multiplier) {
        y *= multiplier;
        return this;
    }

    @Override
    public Vector2D multipleIndex(int index, double multiplier) {
        switch (index) {
            case Axis.X_INDEX -> x *= multiplier;
            case Axis.Y_INDEX -> y *= multiplier;
            default -> throw new VectorIndexError(index);
        }
        return this;
    }

    /**
     * Деление значения по оси абсцисс (x).
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    public Vector2D divideX(double divisor) {
        x /= divisor;
        return this;
    }

    /**
     * Деление значения по оси ординат (y).
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    public Vector2D divideY(double divisor) {
        y /= divisor;
        return this;
    }

    @Override
    public Vector2D divideIndex(int index, double divisor) {
        switch (index) {
            case Axis.X_INDEX -> x /= divisor;
            case Axis.Y_INDEX -> y /= divisor;
            default -> throw new VectorIndexError(index);
        }
        return this;
    }

    /**
     * Установка значений вектора.
     *
     * @param x Значение по оси абсцисс (x)
     * @param y Значение по оси ординат (y)
     * @return Этот же вектор.
     */
    public Vector2D set(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }

    @Override
    public Vector2D set(Vector vector) {
        if (vector instanceof Vector2D vector2D) {
            x = vector2D.x;
            y = vector2D.y;
            return this;
        }
        if (vector.containsIndex(Axis.X_INDEX)) x = vector.getIndex(Axis.X_INDEX);
        if (vector.containsIndex(Axis.Y_INDEX)) y = vector.getIndex(Axis.Y_INDEX);
        return this;
    }

    /**
     * Прибавление к значениям вектора.
     *
     * @param summandX Слагаемое по оси абсцисс (x)
     * @param summandY Слагаемое по оси ординат (y)
     * @return Этот же вектор.
     */
    public Vector2D add(double summandX, double summandY) {
        x += summandX;
        y += summandY;
        return this;
    }

    @Override
    public Vector2D add(Vector summand) {
        if (summand instanceof Vector2D summand2D) {
            x += summand2D.x;
            y += summand2D.y;
            return this;
        }
        x += summand.getIndexOrZero(Axis.X_INDEX);
        y += summand.getIndexOrZero(Axis.Y_INDEX);
        return this;
    }

    /**
     * Вычитание из значений вектора.
     *
     * @param subtrahendX Вычитаемое по оси абсцисс (x)
     * @param subtrahendY Вычитаемое по оси ординат (y)
     * @return Этот же вектор.
     */
    public Vector2D subtract(double subtrahendX, double subtrahendY) {
        x -= subtrahendX;
        y -= subtrahendY;
        return this;
    }

    @Override
    public Vector2D subtract(Vector subtrahend) {
        if (subtrahend instanceof Vector2D subtrahend2D) {
            x -= subtrahend2D.x;
            y -= subtrahend2D.y;
            return this;
        }
        x -= subtrahend.getIndexOrZero(Axis.X_INDEX);
        y -= subtrahend.getIndexOrZero(Axis.Y_INDEX);
        return this;
    }

    @Override
    public Vector2D multiple(double multiplier) {
        x *= multiplier;
        y *= multiplier;
        return this;
    }

    @Override
    public Vector2D divide(double divisor) {
        x /= divisor;
        y /= divisor;
        return this;
    }

    @Override
    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public double distance(Vector vector) {
        if (vector instanceof Vector2D vector2D) {
            return Math.sqrt((x - vector2D.x) * (x - vector2D.x) + (y - vector2D.y) * (y - vector2D.y));
        }
        return Math.sqrt((x - vector.getIndexOrZero(Axis.X_INDEX)) * (x - vector.getIndexOrZero(Axis.X_INDEX)) + (y - vector.getIndexOrZero(Axis.Y_INDEX)) * (y - vector.getIndexOrZero(Axis.Y_INDEX)));
    }

    @Override
    public Vector2D normalize() {
        double length = length();
        x /= length;
        y /= length;
        return this;
    }

    @Override
    public Vector2D toNormalized() {
        double length = length();
        return new Vector2D(x / length, y / length);
    }

    @Override
    public Vector2D vectorTo(Vector vector) {
        if (vector instanceof Vector2D vector2D) {
            return new Vector2D(vector2D.x - x, vector2D.y - y);
        }
        return new Vector2D(vector.getIndexOrZero(Axis.X_INDEX) - x, vector.getIndexOrZero(Axis.Y_INDEX) - y);
    }

    @Override
    public Vector2D directionTo(Vector vector) {
        if (vector instanceof Vector2D vector2D) {
            return new Vector2D(vector2D.x - x, vector2D.y - y).normalize();
        }
        return new Vector2D(vector.getIndexOrZero(Axis.X_INDEX) - x, vector.getIndexOrZero(Axis.Y_INDEX) - y).normalize();
    }

    /**
     * Вычисление угла вектора в радианах.
     * В отличие от метода {@link Math#atan2(double, double)},
     * этот метод возвращает радианы по всей окружности, от 0 до 2π.
     *
     * @return Угол вектора в радианах.
     */
    public double angle() {
        double angle = Math.atan2(y, x);
        if (angle >= 0) return angle;
        return Math.TAU + angle;
    }

    /**
     * Вычисление угла вектора в градусах.
     * В отличие от метода {@link Math#atan2(double, double)},
     * этот метод возвращает градусы по всей окружности, от 0 до 360.
     *
     * @return Угол вектора в градусах.
     */
    public double angleDegrees() {
        return Math.toDegrees(angle());
    }

    // TODO 10.11.2024: При расчёте угла от вектора (1, 1) до вектора (100, 1) угол рассчитывается как 360°, а не 0°

    /**
     * Вычисление угла поворота до другого вектора в радианах.
     *
     * @param vector Вектор, поворот до которого будет рассчитан
     * @return Угол поворота до вектора в радианах.
     */
    public double angleTo(Vector vector) {
        Vector2D difference = clone().subtract(vector);
        return Math.PI + Math.atan2(difference.getY(), difference.getX());
    }
    
    /**
     * Вычисление угла поворота до другого вектора в градусах.
     *
     * @param vector Вектор, поворот до которого будет рассчитан
     * @return Угол поворота до вектора в градусах.
     */
    public double angleDegreesTo(Vector vector) {
        Vector2D difference = clone().subtract(vector);
        return 180 + Math.toDegrees(Math.atan2(difference.getY(), difference.getX()));
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vector vector)) return false;
        if (vector instanceof Vector2D vector2D) {
            return x == vector2D.x && y == vector2D.y;
        }
        if (vector.containsIndex(Axis.X_INDEX) && vector.containsIndex(Axis.Y_INDEX)) {
            return x == vector.getIndex(Axis.X_INDEX) && y == vector.getIndex(Axis.Y_INDEX);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
