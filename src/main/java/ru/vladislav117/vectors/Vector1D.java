package ru.vladislav117.vectors;

import ru.vladislav117.vectors.error.VectorSizeIncompatibilityError;
import ru.vladislav117.vectors.error.WrongAxisIndexError;

/**
 * Вектор в одномерном пространстве.
 */
public class Vector1D implements Vector {
    /**
     * Размер вектора.
     */
    public static final int SIZE = 1;
    /**
     * Значение оси абсцисс (X).
     */
    protected double x;

    /**
     * Создание вектора.
     *
     * @param x Значение оси абсцисс (X)
     */
    public Vector1D(double x) {
        this.x = x;
    }

    /**
     * Создание вектора на основе другого вектора.
     * Значения осей будут взяты по возможности.
     *
     * @param vector Вектор, значения осей которого будут взяты
     */
    public Vector1D(Vector vector) {
        if (vector instanceof Vector1D vector1D) {
            x = vector1D.x;
            return;
        }
        x = vector.getAxisOrZero(Axis.X_INDEX);
    }

    /**
     * Создание вектора с нулевыми значениями осей.
     */
    public Vector1D() {
        x = 0;
    }

    @Override
    public Vector1D clone() {
        try {
            Vector1D cloned = (Vector1D) super.clone();
            cloned.x = x;
            return cloned;
        } catch (CloneNotSupportedException exception) {
            throw new RuntimeException(exception);
        }
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

    @Override
    public double getAxis(int axis) {
        if (axis == Axis.X_INDEX) return x;
        throw new WrongAxisIndexError(axis, this);
    }

    @Override
    public double getAxis(Axis axis) {
        return getAxis(axis.getIndex());
    }

    @Override
    public double getAxisOrZero(int axis) {
        if (axis == Axis.X_INDEX) return x;
        return 0;
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
    public Vector1D setX(double x) {
        this.x = x;
        return this;
    }

    @Override
    public Vector1D setAxis(int axis, double value) {
        if (axis == Axis.X_INDEX) {
            x = value;
            return this;
        }
        throw new WrongAxisIndexError(axis, this);
    }

    @Override
    public Vector1D setAxis(Axis axis, double value) {
        return setAxis(axis.getIndex(), value);
    }

    /**
     * Прибавление к значению оси абсцисс (X).
     *
     * @param summand Слагаемое
     * @return Этот же вектор.
     */
    public Vector1D addX(double summand) {
        x += summand;
        return this;
    }

    @Override
    public Vector1D addAxis(int axis, double summand) {
        if (axis == Axis.X_INDEX) {
            x += summand;
            return this;
        }
        throw new WrongAxisIndexError(axis, this);
    }

    @Override
    public Vector1D addAxis(Axis axis, double summand) {
        return addAxis(axis.getIndex(), summand);
    }

    /**
     * Вычитание из значения оси абсцисс (X).
     *
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     */
    public Vector1D subtractX(double subtrahend) {
        x -= subtrahend;
        return this;
    }

    @Override
    public Vector1D subtractAxis(int axis, double subtrahend) {
        if (axis == Axis.X_INDEX) {
            x -= subtrahend;
            return this;
        }
        throw new WrongAxisIndexError(axis, this);
    }

    @Override
    public Vector1D subtractAxis(Axis axis, double subtrahend) {
        return subtractAxis(axis.getIndex(), subtrahend);
    }

    /**
     * Умножение значения оси абсцисс (X).
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    public Vector1D multipleX(double multiplier) {
        x *= multiplier;
        return this;
    }

    @Override
    public Vector1D multipleAxis(int axis, double multiplier) {
        if (axis == Axis.X_INDEX) {
            x *= multiplier;
            return this;
        }
        throw new WrongAxisIndexError(axis, this);
    }

    @Override
    public Vector1D multipleAxis(Axis axis, double multiplier) {
        return multipleAxis(axis.getIndex(), multiplier);
    }

    /**
     * Деление значения оси абсцисс (X).
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    public Vector1D divideX(double divisor) {
        x /= divisor;
        return this;
    }

    @Override
    public Vector1D divideAxis(int axis, double divisor) {
        if (axis == Axis.X_INDEX) {
            x /= divisor;
            return this;
        }
        throw new WrongAxisIndexError(axis, this);
    }

    @Override
    public Vector1D divideAxis(Axis axis, double divisor) {
        return divideAxis(axis.getIndex(), divisor);
    }

    /**
     * Установка значений осей вектора.
     *
     * @param x Значение оси абсцисс (X)
     * @return Этот же вектор.
     */
    public Vector1D set(double x) {
        this.x = x;
        return this;
    }

    @Override
    public Vector1D set(Vector vector) {
        if (vector instanceof Vector1D vector1D) {
            x = vector1D.x;
            return this;
        }
        x = vector.getAxisOrZero(Axis.X_INDEX);
        return this;
    }

    /**
     * Прибавление к значениям осей вектора.
     *
     * @param summandX Слагаемое оси абсцисс (X)
     * @return Этот же вектор.
     */
    public Vector1D add(double summandX) {
        x += summandX;
        return this;
    }

    @Override
    public Vector1D add(Vector summand) {
        if (summand instanceof Vector1D summand1D) {
            x += summand1D.x;
            return this;
        }
        x += summand.getAxisOrZero(Axis.X_INDEX);
        return this;
    }

    /**
     * Вычитание из значений осей вектора.
     *
     * @param subtrahendX Вычитаемое оси абсцисс (X)
     * @return Этот же вектор.
     */
    public Vector1D subtract(double subtrahendX) {
        x -= subtrahendX;
        return this;
    }

    @Override
    public Vector1D subtract(Vector subtrahend) {
        if (subtrahend instanceof Vector1D subtrahend1D) {
            x -= subtrahend1D.x;
            return this;
        }
        x -= subtrahend.getAxisOrZero(Axis.X_INDEX);
        return this;
    }

    @Override
    public Vector1D multiple(double multiplier) {
        x *= multiplier;
        return this;
    }

    @Override
    public Vector1D divide(double divisor) {
        x /= divisor;
        return this;
    }

    @Override
    public Vector1D normalize() {
        return this;
    }

    @Override
    public Vector1D toNormalized() {
        return new Vector1D(x);
    }

    @Override
    public double length() {
        return x;
    }

    @Override
    public double distance(Vector vector) {
        if (vector instanceof Vector1D vector1D) {
            return Math.abs(x - vector1D.x);
        }
        if (vector.getSize() == SIZE) {
            return Math.abs(x - vector.getAxis(Axis.X_INDEX));
        }
        throw new VectorSizeIncompatibilityError(this, vector);
    }
}
