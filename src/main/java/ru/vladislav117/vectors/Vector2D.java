package ru.vladislav117.vectors;

import ru.vladislav117.vectors.error.VectorSizeIncompatibilityError;
import ru.vladislav117.vectors.error.WrongAxisIndexError;

/**
 * Вектор в двумерном пространстве.
 */
public class Vector2D implements Vector {
    /**
     * Размер вектора.
     */
    public static final int SIZE = 2;
    /**
     * Значение оси абсцисс (X).
     */
    protected double x;
    /**
     * Значение оси ординат (Y).
     */
    protected double y;

    /**
     * Создание вектора.
     *
     * @param x Значение оси абсцисс (X)
     * @param y Значение оси ординат (Y)
     */
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Создание вектора на основе другого вектора.
     * Значения осей будут взяты по возможности.
     *
     * @param vector Вектор, значения осей которого будут взяты
     */
    public Vector2D(Vector vector) {
        if (vector instanceof Vector2D vector2D) {
            x = vector2D.x;
            y = vector2D.y;
            return;
        }
        x = vector.getAxisOrZero(Axis.X_INDEX);
        y = vector.getAxisOrZero(Axis.Y_INDEX);
    }

    /**
     * Создание вектора с нулевыми значениями осей.
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

    /**
     * Создание вектора из угла и длины.
     *
     * @param angle  Угол в радианах
     * @param length Длина
     * @return Созданный вектор.
     */
    public static Vector2D fromAngle(double angle, double length) {
        return new Vector2D(Math.cos(angle) * length, Math.sin(angle) * length);
    }

    /**
     * Создание вектора из угла с единичной длиной.
     *
     * @param angle Угол в радианах
     * @return Созданный вектор.
     */
    public static Vector2D fromAngle(double angle) {
        return new Vector2D(Math.cos(angle), Math.sin(angle));
    }

    /**
     * Создание вектора из угла и длины.
     *
     * @param angle  Угол в градусах
     * @param length Длина
     * @return Созданный вектор.
     */
    public static Vector2D fromAngleDegrees(double angle, double length) {
        angle = Math.toRadians(angle);
        return new Vector2D(Math.cos(angle) * length, Math.sin(angle) * length);
    }

    /**
     * Создание вектора из угла с единичной длиной.
     *
     * @param angle Угол в градусах
     * @return Созданный вектор.
     */
    public static Vector2D fromAngleDegrees(double angle) {
        angle = Math.toRadians(angle);
        return new Vector2D(Math.cos(angle), Math.sin(angle));
    }

    @Override
    public int getSize() {
        return SIZE;
    }

    /**
     * Получение значения оси абсцисс (X).
     *
     * @return Значение оси абсцисс (X).
     */
    public double getX() {
        return x;
    }

    /**
     * Получение значения оси ординат (Y).
     *
     * @return Значение оси ординат (Y).
     */
    public double getY() {
        return y;
    }

    @Override
    public double getAxis(int axis) {
        return switch (axis) {
            case Axis.X_INDEX -> x;
            case Axis.Y_INDEX -> y;
            default -> throw new WrongAxisIndexError(axis, this);
        };
    }

    @Override
    public double getAxis(Axis axis) {
        return getAxis(axis.getIndex());
    }

    @Override
    public double getAxisOrZero(int axis) {
        return switch (axis) {
            case Axis.X_INDEX -> x;
            case Axis.Y_INDEX -> y;
            default -> 0;
        };
    }

    @Override
    public double getAxisOrZero(Axis axis) {
        return getAxisOrZero(axis.getIndex());
    }

    /**
     * Установка значения оси абсцисс (X).
     *
     * @param x Значение оси абсцисс (X)
     * @return Этот же вектор.
     */
    public Vector2D setX(double x) {
        this.x = x;
        return this;
    }

    /**
     * Установка значения оси ординат (Y).
     *
     * @param y Значение оси ординат (Y)
     * @return Этот же вектор.
     */
    public Vector2D setY(double y) {
        this.y = y;
        return this;
    }

    @Override
    public Vector2D setAxis(int axis, double value) {
        switch (axis) {
            case Axis.X_INDEX -> x = value;
            case Axis.Y_INDEX -> y = value;
            default -> throw new WrongAxisIndexError(axis, this);
        }
        return this;
    }

    @Override
    public Vector2D setAxis(Axis axis, double value) {
        return setAxis(axis.getIndex(), value);
    }

    /**
     * Прибавление к значению оси абсцисс (X).
     *
     * @param summand Слагаемое
     * @return Этот же вектор.
     */
    public Vector2D addX(double summand) {
        x += summand;
        return this;
    }

    /**
     * Прибавление к значению оси ординат (Y).
     *
     * @param summand Слагаемое
     * @return Этот же вектор.
     */
    public Vector2D addY(double summand) {
        y += summand;
        return this;
    }

    @Override
    public Vector2D addAxis(int axis, double summand) {
        switch (axis) {
            case Axis.X_INDEX -> x += summand;
            case Axis.Y_INDEX -> y += summand;
            default -> throw new WrongAxisIndexError(axis, this);
        }
        return this;
    }

    @Override
    public Vector2D addAxis(Axis axis, double summand) {
        return addAxis(axis.getIndex(), summand);
    }

    /**
     * Вычитание из значения оси абсцисс (X).
     *
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     */
    public Vector2D subtractX(double subtrahend) {
        x -= subtrahend;
        return this;
    }

    /**
     * Вычитание из значения оси ординат (Y).
     *
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     */
    public Vector2D subtractY(double subtrahend) {
        y -= subtrahend;
        return this;
    }

    @Override
    public Vector2D subtractAxis(int axis, double subtrahend) {
        switch (axis) {
            case Axis.X_INDEX -> x -= subtrahend;
            case Axis.Y_INDEX -> y -= subtrahend;
            default -> throw new WrongAxisIndexError(axis, this);
        }
        return this;
    }

    @Override
    public Vector2D subtractAxis(Axis axis, double subtrahend) {
        return subtractAxis(axis.getIndex(), subtrahend);
    }

    /**
     * Умножение значения оси абсцисс (X).
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    public Vector2D multipleX(double multiplier) {
        x *= multiplier;
        return this;
    }

    /**
     * Умножение значения оси ординат (Y).
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    public Vector2D multipleY(double multiplier) {
        y *= multiplier;
        return this;
    }

    @Override
    public Vector2D multipleAxis(int axis, double multiplier) {
        switch (axis) {
            case Axis.X_INDEX -> x *= multiplier;
            case Axis.Y_INDEX -> y *= multiplier;
            default -> throw new WrongAxisIndexError(axis, this);
        }
        return this;
    }

    @Override
    public Vector2D multipleAxis(Axis axis, double multiplier) {
        return multipleAxis(axis.getIndex(), multiplier);
    }

    /**
     * Деление значения оси абсцисс (X).
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    public Vector2D divideX(double divisor) {
        x /= divisor;
        return this;
    }

    /**
     * Деление значения оси ординат (Y).
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    public Vector2D divideY(double divisor) {
        y /= divisor;
        return this;
    }

    @Override
    public Vector2D divideAxis(int axis, double divisor) {
        switch (axis) {
            case Axis.X_INDEX -> x /= divisor;
            case Axis.Y_INDEX -> y /= divisor;
            default -> throw new WrongAxisIndexError(axis, this);
        }
        return this;
    }

    @Override
    public Vector2D divideAxis(Axis axis, double divisor) {
        return divideAxis(axis.getIndex(), divisor);
    }

    /**
     * Установка значений осей вектора.
     *
     * @param x Значение оси абсцисс (X)
     * @param y Значение оси ординат (Y)
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
        x = vector.getAxisOrZero(Axis.X_INDEX);
        y = vector.getAxisOrZero(Axis.Y_INDEX);
        return this;
    }

    /**
     * Прибавление к значениям осей вектора.
     *
     * @param summandX Слагаемое оси абсцисс (X)
     * @param summandY Слагаемое оси ординат (Y)
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
        x += summand.getAxisOrZero(Axis.X_INDEX);
        y += summand.getAxisOrZero(Axis.Y_INDEX);
        return this;
    }

    /**
     * Вычитание из значений осей вектора.
     *
     * @param subtrahendX Вычитаемое оси абсцисс (X)
     * @param subtrahendY Вычитаемое оси ординат (Y)
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
        x -= subtrahend.getAxisOrZero(Axis.X_INDEX);
        y -= subtrahend.getAxisOrZero(Axis.Y_INDEX);
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
    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public double distance(Vector vector) {
        if (vector instanceof Vector2D vector2D) {
            return Math.sqrt((x - vector2D.x) * (x - vector2D.x) + (y - vector2D.y) * (y - vector2D.y));
        }
        if (vector.getSize() == SIZE) {
            return Math.sqrt((x - vector.getAxis(Axis.X_INDEX)) * (x - vector.getAxis(Axis.X_INDEX)) + (y - vector.getAxis(Axis.Y_INDEX)) * (y - vector.getAxis(Axis.Y_INDEX)));
        }
        throw new VectorSizeIncompatibilityError(this, vector);
    }

    /**
     * Вычисление угла вектора в радианах.
     * В отличие от метода {@link Math#atan2(double, double)},
     * этот метод возвращает радианы по всей окружности, от 0 до 2π.
     *
     * @return Угол вектора в радианах.
     * @see Vector2D#angleDegrees()
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
     * @see Vector2D#angle()
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
     * @see Vector2D#angleDegreesTo(Vector)
     */
    public double angleTo(Vector vector) {
        if (vector.getSize() == SIZE) {
            Vector2D difference = clone().subtract(vector);
            return Math.PI + Math.atan2(difference.getY(), difference.getX());
        }
        throw new VectorSizeIncompatibilityError(this, vector);
    }

    /**
     * Вычисление угла поворота до другого вектора в градусах.
     *
     * @param vector Вектор, поворот до которого будет рассчитан
     * @return Угол поворота до вектора в градусах.
     * @see Vector2D#angleTo(Vector)
     */
    public double angleDegreesTo(Vector vector) {
        if (vector.getSize() == SIZE) {
            Vector2D difference = clone().subtract(vector);
            return 180 + Math.toDegrees(Math.atan2(difference.getY(), difference.getX()));
        }
        throw new VectorSizeIncompatibilityError(this, vector);
    }

    /**
     * Вычисление направления до вектора.
     * Представляет собой следующий алгоритм: из целевого вектора вычитается текущий,
     * затем результат нормализуется.
     *
     * @param vector Целевой вектор
     * @return Направление до вектора.
     */
    public Vector2D directionTo(Vector vector) {
        if (vector.getSize() == SIZE) {
            return new Vector2D(vector.getAxis(Axis.X_INDEX) - x, vector.getAxis(Axis.Y_INDEX) - y).normalize();
        }
        throw new VectorSizeIncompatibilityError(this, vector);
    }

    /**
     * Вычисление вектора до целевого вектора.
     * Представляет собой следующий алгоритм: из целевого вектора вычитается текущий.
     *
     * @param vector Целевой вектор.
     * @return Вектор до целевого вектора.
     */
    public Vector2D vectorTo(Vector vector) {
        if (vector.getSize() == SIZE) {
            return new Vector2D(vector.getAxis(Axis.X_INDEX) - x, vector.getAxis(Axis.Y_INDEX) - y);
        }
        throw new VectorSizeIncompatibilityError(this, vector);
    }
}
