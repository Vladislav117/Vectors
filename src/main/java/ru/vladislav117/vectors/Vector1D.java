package ru.vladislav117.vectors;

import ru.vladislav117.vectors.error.VectorIndexError;

import java.util.Objects;

/**
 * Вектор в одномерном пространстве.
 */
public class Vector1D implements Vector {
    /**
     * Размер вектора.
     */
    public static final int SIZE = 1;
    /**
     * Значение по оси абсцисс (x).
     */
    protected double x;

    /**
     * Создание одномерного вектора.
     *
     * @param x Значение по оси абсцисс (x)
     */
    public Vector1D(double x) {
        this.x = x;
    }

    /**
     * Создание одномерного вектора на основе другого вектора.
     * Если у векторов совпадают не все индексы значений, то значения по таким индексам будут взяты за 0.
     *
     * @param vector Вектор, значения по осям которого будут взяты
     */
    public Vector1D(Vector vector) {
        if (vector instanceof Vector1D vector1D) {
            x = vector1D.x;
            return;
        }
        x = vector.getIndexOrZero(Axis.X_INDEX);
    }

    /**
     * Создание одномерного вектора с нулевыми значениями.
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

    @Override
    public boolean containsIndex(int index) {
        return index == Axis.X_INDEX;
    }

    /**
     * Получение значения по оси абсцисс (x).
     *
     * @return Значение по оси абсцисс (x).
     */
    public double getX() {
        return x;
    }

    @Override
    public double getIndex(int index) {
        if (index == Axis.X_INDEX) return x;
        throw new VectorIndexError(index);
    }

    @Override
    public double getIndexOrZero(int index) {
        if (index == Axis.X_INDEX) return x;
        return 0;
    }

    /**
     * Установка значения по оси абсцисс (x).
     *
     * @param x Значение по оси абсцисс (x)
     * @return Этот же вектор.
     */
    public Vector1D setX(double x) {
        this.x = x;
        return this;
    }

    @Override
    public Vector1D setIndex(int index, double value) {
        if (index == Axis.X_INDEX) {
            x = value;
            return this;
        }
        throw new VectorIndexError(index);
    }

    /**
     * Прибавление к значению по оси абсцисс (x).
     *
     * @param summand Слагаемое
     * @return Этот же вектор.
     */
    public Vector1D addX(double summand) {
        x += summand;
        return this;
    }

    @Override
    public Vector1D addIndex(int index, double summand) {
        if (index == Axis.X_INDEX) {
            x += summand;
            return this;
        }
        throw new VectorIndexError(index);
    }

    /**
     * Вычитание из значения по оси абсцисс (x).
     *
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     */
    public Vector1D subtractX(double subtrahend) {
        x -= subtrahend;
        return this;
    }

    @Override
    public Vector1D subtractIndex(int index, double subtrahend) {
        if (index == Axis.X_INDEX) {
            x -= subtrahend;
            return this;
        }
        throw new VectorIndexError(index);
    }

    /**
     * Умножение значения по оси абсцисс (x).
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    public Vector1D multipleX(double multiplier) {
        x *= multiplier;
        return this;
    }

    @Override
    public Vector1D multipleIndex(int index, double multiplier) {
        if (index == Axis.X_INDEX) {
            x *= multiplier;
            return this;
        }
        throw new VectorIndexError(index);
    }

    /**
     * Деление значения по оси абсцисс (x).
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    public Vector1D divideX(double divisor) {
        x /= divisor;
        return this;
    }

    @Override
    public Vector1D divideIndex(int index, double divisor) {
        if (index == Axis.X_INDEX) {
            x /= divisor;
            return this;
        }
        throw new VectorIndexError(index);
    }

    /**
     * Установка значений вектора.
     *
     * @param x Значение по оси абсцисс (x)
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
        if (vector.containsIndex(Axis.X_INDEX)) x = vector.getIndex(Axis.X_INDEX);
        return this;
    }

    /**
     * Прибавление к значениям вектора.
     *
     * @param summandX Слагаемое по оси абсцисс (x)
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
        x += summand.getIndexOrZero(Axis.X_INDEX);
        return this;
    }

    /**
     * Вычитание из значений вектора.
     *
     * @param subtrahendX Вычитаемое по оси абсцисс (x)
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
        x -= subtrahend.getIndexOrZero(Axis.X_INDEX);
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
    public double length() {
        return Math.abs(x);
    }

    @Override
    public double distance(Vector vector) {
        if (vector instanceof Vector1D vector1D) {
            return Math.abs(x - vector1D.x);
        }
        return Math.abs(x - vector.getIndexOrZero(Axis.X_INDEX));
    }

    @Override
    public Vector1D normalize() {
        x = Math.signum(x);
        return this;
    }

    @Override
    public Vector1D toNormalized() {
        return new Vector1D(Math.signum(x));
    }

    @Override
    public Vector1D vectorTo(Vector vector) {
        if (vector instanceof Vector1D vector1D) {
            return new Vector1D(vector1D.x - x);
        }
        return new Vector1D(vector.getIndexOrZero(Axis.X_INDEX) - x);
    }

    @Override
    public Vector1D directionTo(Vector vector) {
        if (vector instanceof Vector1D vector1D) {
            return new Vector1D(vector1D.x - x).normalize();
        }
        return new Vector1D(vector.getIndexOrZero(Axis.X_INDEX) - x).normalize();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vector vector)) return false;
        if (vector instanceof Vector1D vector1D) {
            return x == vector1D.x;
        }
        if (vector.containsIndex(Axis.X_INDEX)) {
            return x == vector.getIndex(Axis.X_INDEX);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }
}
