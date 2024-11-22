package ru.vladislav117.vectors;

import ru.vladislav117.vectors.error.VectorIndexError;

import java.util.Objects;

/**
 * Вектор в четырёхмерном пространстве.
 */
public class Vector4D implements Vector {
    /**
     * Размер вектора.
     */
    public static final int SIZE = 4;
    /**
     * Значение по оси абсцисс (x).
     */
    protected double x;
    /**
     * Значение по оси ординат (y).
     */
    protected double y;
    /**
     * Значение по оси аппликат (z).
     */
    protected double z;
    /**
     * Значение по оси w.
     */
    protected double w;

    /**
     * Создание четырёхмерного вектора.
     *
     * @param x Значение по оси абсцисс (x)
     * @param y Значение по оси ординат (y)
     * @param z Значение по оси аппликат (z)
     * @param w Значение по оси w
     */
    public Vector4D(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Создание четырёхмерного вектора на основе другого вектора.
     * Если у векторов совпадают не все индексы значений, то значения по таким индексам будут взяты за 0.
     *
     * @param vector Вектор, значения по осям которого будут взяты
     */
    public Vector4D(Vector vector) {
        if (vector instanceof Vector4D vector4D) {
            x = vector4D.x;
            y = vector4D.y;
            z = vector4D.z;
            w = vector4D.w;
            return;
        }
        x = vector.getIndexOrZero(Axis.X_INDEX);
        y = vector.getIndexOrZero(Axis.Y_INDEX);
        z = vector.getIndexOrZero(Axis.Z_INDEX);
        w = vector.getIndexOrZero(Axis.W_INDEX);
    }

    /**
     * Создание четырёхмерного вектора с нулевыми значениями.
     */
    public Vector4D() {
        x = 0;
        y = 0;
        z = 0;
        w = 0;
    }

    @Override
    public Vector4D clone() {
        try {
            Vector4D cloned = (Vector4D) super.clone();
            cloned.x = x;
            cloned.y = y;
            cloned.z = z;
            cloned.w = w;
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
        return index == Axis.X_INDEX || index == Axis.Y_INDEX || index == Axis.Z_INDEX || index == Axis.W_INDEX;
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

    /**
     * Получение значения по оси аппликат (z).
     *
     * @return Значение по оси аппликат (z).
     */
    public double getZ() {
        return z;
    }

    /**
     * Получение значения по оси w.
     *
     * @return Значение по оси w.
     */
    public double getW() {
        return w;
    }

    @Override
    public double getIndex(int index) {
        return switch (index) {
            case Axis.X_INDEX -> x;
            case Axis.Y_INDEX -> y;
            case Axis.Z_INDEX -> z;
            case Axis.W_INDEX -> w;
            default -> throw new VectorIndexError(index);
        };
    }

    @Override
    public double getIndexOrZero(int index) {
        return switch (index) {
            case Axis.X_INDEX -> x;
            case Axis.Y_INDEX -> y;
            case Axis.Z_INDEX -> z;
            case Axis.W_INDEX -> w;
            default -> 0;
        };
    }

    /**
     * Установка значения по оси абсцисс (x).
     *
     * @param x Значение по оси абсцисс (x)
     * @return Этот же вектор.
     */
    public Vector4D setX(double x) {
        this.x = x;
        return this;
    }

    /**
     * Установка значения по оси ординат (y).
     *
     * @param y Значение по оси ординат (y)
     * @return Этот же вектор.
     */
    public Vector4D setY(double y) {
        this.y = y;
        return this;
    }

    /**
     * Установка значения по оси аппликат (z).
     *
     * @param z Значение по оси аппликат (z)
     * @return Этот же вектор.
     */
    public Vector4D setZ(double z) {
        this.z = z;
        return this;
    }

    /**
     * Установка значения по оси w.
     *
     * @param w Значение по оси w
     * @return Этот же вектор.
     */
    public Vector4D setW(double w) {
        this.w = w;
        return this;
    }

    @Override
    public Vector4D setIndex(int index, double value) {
        switch (index) {
            case Axis.X_INDEX -> x = value;
            case Axis.Y_INDEX -> y = value;
            case Axis.Z_INDEX -> z = value;
            case Axis.W_INDEX -> w = value;
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
    public Vector4D addX(double summand) {
        x += summand;
        return this;
    }

    /**
     * Прибавление к значению по оси ординат (y).
     *
     * @param summand Слагаемое
     * @return Этот же вектор.
     */
    public Vector4D addY(double summand) {
        y += summand;
        return this;
    }

    /**
     * Прибавление к значению по оси аппликат (z).
     *
     * @param summand Слагаемое
     * @return Этот же вектор.
     */
    public Vector4D addZ(double summand) {
        z += summand;
        return this;
    }

    /**
     * Прибавление к значению по оси w.
     *
     * @param summand Слагаемое
     * @return Этот же вектор.
     */
    public Vector4D addW(double summand) {
        w += summand;
        return this;
    }

    @Override
    public Vector4D addIndex(int index, double summand) {
        switch (index) {
            case Axis.X_INDEX -> x += summand;
            case Axis.Y_INDEX -> y += summand;
            case Axis.Z_INDEX -> z += summand;
            case Axis.W_INDEX -> w += summand;
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
    public Vector4D subtractX(double subtrahend) {
        x -= subtrahend;
        return this;
    }

    /**
     * Вычитание из значения по оси ординат (y).
     *
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     */
    public Vector4D subtractY(double subtrahend) {
        y -= subtrahend;
        return this;
    }

    /**
     * Вычитание из значения по оси аппликат (z).
     *
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     */
    public Vector4D subtractZ(double subtrahend) {
        z -= subtrahend;
        return this;
    }

    /**
     * Вычитание из значения по оси w.
     *
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     */
    public Vector4D subtractW(double subtrahend) {
        w -= subtrahend;
        return this;
    }

    @Override
    public Vector4D subtractIndex(int index, double subtrahend) {
        switch (index) {
            case Axis.X_INDEX -> x -= subtrahend;
            case Axis.Y_INDEX -> y -= subtrahend;
            case Axis.Z_INDEX -> z -= subtrahend;
            case Axis.W_INDEX -> w -= subtrahend;
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
    public Vector4D multipleX(double multiplier) {
        x *= multiplier;
        return this;
    }

    /**
     * Умножение значения по оси ординат (y).
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    public Vector4D multipleY(double multiplier) {
        y *= multiplier;
        return this;
    }

    /**
     * Умножение значения по оси аппликат (z).
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    public Vector4D multipleZ(double multiplier) {
        z *= multiplier;
        return this;
    }

    /**
     * Умножение значения по оси w.
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    public Vector4D multipleW(double multiplier) {
        w *= multiplier;
        return this;
    }

    @Override
    public Vector4D multipleIndex(int index, double multiplier) {
        switch (index) {
            case Axis.X_INDEX -> x *= multiplier;
            case Axis.Y_INDEX -> y *= multiplier;
            case Axis.Z_INDEX -> z *= multiplier;
            case Axis.W_INDEX -> w *= multiplier;
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
    public Vector4D divideX(double divisor) {
        x /= divisor;
        return this;
    }

    /**
     * Деление значения по оси ординат (y).
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    public Vector4D divideY(double divisor) {
        y /= divisor;
        return this;
    }

    /**
     * Деление значения по оси аппликат (z).
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    public Vector4D divideZ(double divisor) {
        z /= divisor;
        return this;
    }

    /**
     * Деление значения по оси w.
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    public Vector4D divideW(double divisor) {
        w /= divisor;
        return this;
    }

    @Override
    public Vector4D divideIndex(int index, double divisor) {
        switch (index) {
            case Axis.X_INDEX -> x /= divisor;
            case Axis.Y_INDEX -> y /= divisor;
            case Axis.Z_INDEX -> z /= divisor;
            case Axis.W_INDEX -> w /= divisor;
            default -> throw new VectorIndexError(index);
        }
        return this;
    }

    /**
     * Установка значений вектора.
     *
     * @param x Значение по оси абсцисс (x)
     * @param y Значение по оси ординат (y)
     * @param z Значение по оси аппликат (z)
     * @param w Значение по оси w
     * @return Этот же вектор.
     */
    public Vector4D set(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        return this;
    }

    @Override
    public Vector4D set(Vector vector) {
        if (vector instanceof Vector4D vector4D) {
            x = vector4D.x;
            y = vector4D.y;
            z = vector4D.z;
            w = vector4D.w;
            return this;
        }
        if (vector.containsIndex(Axis.X_INDEX)) x = vector.getIndex(Axis.X_INDEX);
        if (vector.containsIndex(Axis.Y_INDEX)) y = vector.getIndex(Axis.Y_INDEX);
        if (vector.containsIndex(Axis.Z_INDEX)) z = vector.getIndex(Axis.Z_INDEX);
        if (vector.containsIndex(Axis.W_INDEX)) w = vector.getIndex(Axis.W_INDEX);
        return this;
    }

    /**
     * Прибавление к значениям вектора.
     *
     * @param summandX Слагаемое по оси абсцисс (x)
     * @param summandY Слагаемое по оси ординат (y)
     * @param summandZ Слагаемое по оси аппликат (z)
     * @param summandW Слагаемое по оси w
     * @return Этот же вектор.
     */
    public Vector4D add(double summandX, double summandY, double summandZ, double summandW) {
        x += summandX;
        y += summandY;
        z += summandZ;
        w += summandW;
        return this;
    }

    @Override
    public Vector4D add(Vector summand) {
        if (summand instanceof Vector4D summand4D) {
            x += summand4D.x;
            y += summand4D.y;
            z += summand4D.z;
            w += summand4D.w;
            return this;
        }
        x += summand.getIndexOrZero(Axis.X_INDEX);
        y += summand.getIndexOrZero(Axis.Y_INDEX);
        z += summand.getIndexOrZero(Axis.Z_INDEX);
        w += summand.getIndexOrZero(Axis.W_INDEX);
        return this;
    }

    /**
     * Вычитание из значений вектора.
     *
     * @param subtrahendX Вычитаемое по оси абсцисс (x)
     * @param subtrahendY Вычитаемое по оси ординат (y)
     * @param subtrahendZ Вычитаемое по оси аппликат (z)
     * @param subtrahendW Вычитаемое по оси w
     * @return Этот же вектор.
     */
    public Vector4D subtract(double subtrahendX, double subtrahendY, double subtrahendZ, double subtrahendW) {
        x -= subtrahendX;
        y -= subtrahendY;
        z -= subtrahendZ;
        w -= subtrahendW;
        return this;
    }

    @Override
    public Vector4D subtract(Vector subtrahend) {
        if (subtrahend instanceof Vector4D subtrahend4D) {
            x -= subtrahend4D.x;
            y -= subtrahend4D.y;
            z -= subtrahend4D.z;
            w -= subtrahend4D.w;
            return this;
        }
        x -= subtrahend.getIndexOrZero(Axis.X_INDEX);
        y -= subtrahend.getIndexOrZero(Axis.Y_INDEX);
        z -= subtrahend.getIndexOrZero(Axis.Z_INDEX);
        w -= subtrahend.getIndexOrZero(Axis.W_INDEX);
        return this;
    }

    @Override
    public Vector4D multiple(double multiplier) {
        x *= multiplier;
        y *= multiplier;
        z *= multiplier;
        w *= multiplier;
        return this;
    }

    @Override
    public Vector4D divide(double divisor) {
        x /= divisor;
        y /= divisor;
        z /= divisor;
        w /= divisor;
        return this;
    }

    @Override
    public double length() {
        return Math.sqrt(x * x + y * y + z * z + w * w);
    }

    @Override
    public double distance(Vector vector) {
        if (vector instanceof Vector4D vector4D) {
            return Math.sqrt((x - vector4D.x) * (x - vector4D.x) + (y - vector4D.y) * (y - vector4D.y) + (z - vector4D.z) * (z - vector4D.z) + (w - vector4D.w) * (w - vector4D.w));
        }
        return Math.sqrt((x - vector.getIndexOrZero(Axis.X_INDEX)) * (x - vector.getIndexOrZero(Axis.X_INDEX)) + (y - vector.getIndexOrZero(Axis.Y_INDEX)) * (y - vector.getIndexOrZero(Axis.Y_INDEX)) + (z - vector.getIndexOrZero(Axis.Z_INDEX)) * (z - vector.getIndexOrZero(Axis.Z_INDEX)) + (w - vector.getIndexOrZero(Axis.W_INDEX)) * (w - vector.getIndexOrZero(Axis.W_INDEX)));
    }

    @Override
    public Vector4D normalize() {
        double length = length();
        x /= length;
        y /= length;
        z /= length;
        w /= length;
        return this;
    }

    @Override
    public Vector4D toNormalized() {
        double length = length();
        return new Vector4D(x / length, y / length, z / length, w / length);
    }

    @Override
    public Vector4D vectorTo(Vector vector) {
        if (vector instanceof Vector4D vector4D) {
            return new Vector4D(vector4D.x - x, vector4D.y - y, vector4D.z - z, vector4D.w - w);
        }
        return new Vector4D(vector.getIndexOrZero(Axis.X_INDEX) - x, vector.getIndexOrZero(Axis.Y_INDEX) - y, vector.getIndexOrZero(Axis.Z_INDEX) - z, vector.getIndexOrZero(Axis.W_INDEX) - w);
    }

    @Override
    public Vector4D directionTo(Vector vector) {
        if (vector instanceof Vector4D vector4D) {
            return new Vector4D(vector4D.x - x, vector4D.y - y, vector4D.z - z, vector4D.w - w).normalize();
        }
        return new Vector4D(vector.getIndexOrZero(Axis.X_INDEX) - x, vector.getIndexOrZero(Axis.Y_INDEX) - y, vector.getIndexOrZero(Axis.Z_INDEX) - z, vector.getIndexOrZero(Axis.W_INDEX) - w).normalize();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vector vector)) return false;
        if (vector instanceof Vector4D vector4D) {
            return x == vector4D.x && y == vector4D.y && z == vector4D.z && w == vector4D.w;
        }
        if (vector.containsIndex(Axis.X_INDEX) && vector.containsIndex(Axis.Y_INDEX) && vector.containsIndex(Axis.Z_INDEX) && vector.containsIndex(Axis.W_INDEX)) {
            return x == vector.getIndex(Axis.X_INDEX) && y == vector.getIndex(Axis.Y_INDEX) && z == vector.getIndex(Axis.Z_INDEX) && w == vector.getIndex(Axis.W_INDEX);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, w);
    }
}
