package ru.vladislav117.vectors;

import ru.vladislav117.vectors.error.VectorIndexError;

import java.util.Objects;

/**
 * Вектор в трёхмерном пространстве.
 */
public class Vector3D implements Vector {
    /**
     * Размер вектора.
     */
    public static final int SIZE = 3;
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
     * Создание трёхмерного вектора.
     *
     * @param x Значение по оси абсцисс (x)
     * @param y Значение по оси ординат (y)
     * @param z Значение по оси аппликат (z)
     */
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Создание трёхмерного вектора на основе другого вектора.
     * Если у векторов совпадают не все индексы значений, то значения по таким индексам будут взяты за 0.
     *
     * @param vector Вектор, значения по осям которого будут взяты
     */
    public Vector3D(Vector vector) {
        if (vector instanceof Vector3D vector3D) {
            x = vector3D.x;
            y = vector3D.y;
            z = vector3D.z;
            return;
        }
        x = vector.getIndexOrZero(Axis.X_INDEX);
        y = vector.getIndexOrZero(Axis.Y_INDEX);
        z = vector.getIndexOrZero(Axis.Z_INDEX);
    }

    /**
     * Создание трёхмерного вектора с нулевыми значениями.
     */
    public Vector3D() {
        x = 0;
        y = 0;
        z = 0;
    }

    @Override
    public Vector3D clone() {
        try {
            Vector3D cloned = (Vector3D) super.clone();
            cloned.x = x;
            cloned.y = y;
            cloned.z = z;
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
        return index == Axis.X_INDEX || index == Axis.Y_INDEX || index == Axis.Z_INDEX;
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

    @Override
    public double getIndex(int index) {
        return switch (index) {
            case Axis.X_INDEX -> x;
            case Axis.Y_INDEX -> y;
            case Axis.Z_INDEX -> z;
            default -> throw new VectorIndexError(index);
        };
    }

    @Override
    public double getIndexOrZero(int index) {
        return switch (index) {
            case Axis.X_INDEX -> x;
            case Axis.Y_INDEX -> y;
            case Axis.Z_INDEX -> z;
            default -> 0;
        };
    }

    /**
     * Установка значения по оси абсцисс (x).
     *
     * @param x Значение по оси абсцисс (x)
     * @return Этот же вектор.
     */
    public Vector3D setX(double x) {
        this.x = x;
        return this;
    }

    /**
     * Установка значения по оси ординат (y).
     *
     * @param y Значение по оси ординат (y)
     * @return Этот же вектор.
     */
    public Vector3D setY(double y) {
        this.y = y;
        return this;
    }

    /**
     * Установка значения по оси аппликат (z).
     *
     * @param z Значение по оси аппликат (z)
     * @return Этот же вектор.
     */
    public Vector3D setZ(double z) {
        this.z = z;
        return this;
    }

    @Override
    public Vector3D setIndex(int index, double value) {
        switch (index) {
            case Axis.X_INDEX -> x = value;
            case Axis.Y_INDEX -> y = value;
            case Axis.Z_INDEX -> z = value;
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
    public Vector3D addX(double summand) {
        x += summand;
        return this;
    }

    /**
     * Прибавление к значению по оси ординат (y).
     *
     * @param summand Слагаемое
     * @return Этот же вектор.
     */
    public Vector3D addY(double summand) {
        y += summand;
        return this;
    }

    /**
     * Прибавление к значению по оси аппликат (z).
     *
     * @param summand Слагаемое
     * @return Этот же вектор.
     */
    public Vector3D addZ(double summand) {
        z += summand;
        return this;
    }

    @Override
    public Vector3D addIndex(int index, double summand) {
        switch (index) {
            case Axis.X_INDEX -> x += summand;
            case Axis.Y_INDEX -> y += summand;
            case Axis.Z_INDEX -> z += summand;
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
    public Vector3D subtractX(double subtrahend) {
        x -= subtrahend;
        return this;
    }

    /**
     * Вычитание из значения по оси ординат (y).
     *
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     */
    public Vector3D subtractY(double subtrahend) {
        y -= subtrahend;
        return this;
    }

    /**
     * Вычитание из значения по оси аппликат (z).
     *
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     */
    public Vector3D subtractZ(double subtrahend) {
        z -= subtrahend;
        return this;
    }

    @Override
    public Vector3D subtractIndex(int index, double subtrahend) {
        switch (index) {
            case Axis.X_INDEX -> x -= subtrahend;
            case Axis.Y_INDEX -> y -= subtrahend;
            case Axis.Z_INDEX -> z -= subtrahend;
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
    public Vector3D multipleX(double multiplier) {
        x *= multiplier;
        return this;
    }

    /**
     * Умножение значения по оси ординат (y).
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    public Vector3D multipleY(double multiplier) {
        y *= multiplier;
        return this;
    }

    /**
     * Умножение значения по оси аппликат (z).
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    public Vector3D multipleZ(double multiplier) {
        z *= multiplier;
        return this;
    }

    @Override
    public Vector3D multipleIndex(int index, double multiplier) {
        switch (index) {
            case Axis.X_INDEX -> x *= multiplier;
            case Axis.Y_INDEX -> y *= multiplier;
            case Axis.Z_INDEX -> z *= multiplier;
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
    public Vector3D divideX(double divisor) {
        x /= divisor;
        return this;
    }

    /**
     * Деление значения по оси ординат (y).
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    public Vector3D divideY(double divisor) {
        y /= divisor;
        return this;
    }

    /**
     * Деление значения по оси аппликат (z).
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    public Vector3D divideZ(double divisor) {
        z /= divisor;
        return this;
    }

    @Override
    public Vector3D divideIndex(int index, double divisor) {
        switch (index) {
            case Axis.X_INDEX -> x /= divisor;
            case Axis.Y_INDEX -> y /= divisor;
            case Axis.Z_INDEX -> z /= divisor;
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
     * @return Этот же вектор.
     */
    public Vector3D set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    @Override
    public Vector3D set(Vector vector) {
        if (vector instanceof Vector3D vector3D) {
            x = vector3D.x;
            y = vector3D.y;
            z = vector3D.z;
            return this;
        }
        if (vector.containsIndex(Axis.X_INDEX)) x = vector.getIndex(Axis.X_INDEX);
        if (vector.containsIndex(Axis.Y_INDEX)) y = vector.getIndex(Axis.Y_INDEX);
        if (vector.containsIndex(Axis.Z_INDEX)) z = vector.getIndex(Axis.Z_INDEX);
        return this;
    }

    /**
     * Прибавление к значениям вектора.
     *
     * @param summandX Слагаемое по оси абсцисс (x)
     * @param summandY Слагаемое по оси ординат (y)
     * @param summandZ Слагаемое по оси аппликат (z)
     * @return Этот же вектор.
     */
    public Vector3D add(double summandX, double summandY, double summandZ) {
        x += summandX;
        y += summandY;
        z += summandZ;
        return this;
    }

    @Override
    public Vector3D add(Vector summand) {
        if (summand instanceof Vector3D summand3D) {
            x += summand3D.x;
            y += summand3D.y;
            z += summand3D.z;
            return this;
        }
        x += summand.getIndexOrZero(Axis.X_INDEX);
        y += summand.getIndexOrZero(Axis.Y_INDEX);
        z += summand.getIndexOrZero(Axis.Z_INDEX);
        return this;
    }

    /**
     * Вычитание из значений вектора.
     *
     * @param subtrahendX Вычитаемое по оси абсцисс (x)
     * @param subtrahendY Вычитаемое по оси ординат (y)
     * @param subtrahendZ Вычитаемое по оси аппликат (z)
     * @return Этот же вектор.
     */
    public Vector3D subtract(double subtrahendX, double subtrahendY, double subtrahendZ) {
        x -= subtrahendX;
        y -= subtrahendY;
        z -= subtrahendZ;
        return this;
    }

    @Override
    public Vector3D subtract(Vector subtrahend) {
        if (subtrahend instanceof Vector3D subtrahend3D) {
            x -= subtrahend3D.x;
            y -= subtrahend3D.y;
            z -= subtrahend3D.z;
            return this;
        }
        x -= subtrahend.getIndexOrZero(Axis.X_INDEX);
        y -= subtrahend.getIndexOrZero(Axis.Y_INDEX);
        z -= subtrahend.getIndexOrZero(Axis.Z_INDEX);
        return this;
    }

    @Override
    public Vector3D multiple(double multiplier) {
        x *= multiplier;
        y *= multiplier;
        z *= multiplier;
        return this;
    }

    @Override
    public Vector3D divide(double divisor) {
        x /= divisor;
        y /= divisor;
        z /= divisor;
        return this;
    }

    @Override
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public double distance(Vector vector) {
        if (vector instanceof Vector3D vector3D) {
            return Math.sqrt((x - vector3D.x) * (x - vector3D.x) + (y - vector3D.y) * (y - vector3D.y) + (z - vector3D.z) * (z - vector3D.z));
        }
        return Math.sqrt((x - vector.getIndexOrZero(Axis.X_INDEX)) * (x - vector.getIndexOrZero(Axis.X_INDEX)) + (y - vector.getIndexOrZero(Axis.Y_INDEX)) * (y - vector.getIndexOrZero(Axis.Y_INDEX)) + (z - vector.getIndexOrZero(Axis.Z_INDEX)) * (z - vector.getIndexOrZero(Axis.Z_INDEX)));
    }

    @Override
    public Vector3D normalize() {
        double length = length();
        x /= length;
        y /= length;
        z /= length;
        return this;
    }

    @Override
    public Vector3D toNormalized() {
        double length = length();
        return new Vector3D(x / length, y / length, z / length);
    }

    @Override
    public Vector3D vectorTo(Vector vector) {
        if (vector instanceof Vector3D vector3D) {
            return new Vector3D(vector3D.x - x, vector3D.y - y, vector3D.z - z);
        }
        return new Vector3D(vector.getIndexOrZero(Axis.X_INDEX) - x, vector.getIndexOrZero(Axis.Y_INDEX) - y, vector.getIndexOrZero(Axis.Z_INDEX) - z);
    }

    @Override
    public Vector3D directionTo(Vector vector) {
        if (vector instanceof Vector3D vector3D) {
            return new Vector3D(vector3D.x - x, vector3D.y - y, vector3D.z - z).normalize();
        }
        return new Vector3D(vector.getIndexOrZero(Axis.X_INDEX) - x, vector.getIndexOrZero(Axis.Y_INDEX) - y, vector.getIndexOrZero(Axis.Z_INDEX) - z).normalize();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vector vector)) return false;
        if (vector instanceof Vector3D vector3D) {
            return x == vector3D.x && y == vector3D.y && z == vector3D.z;
        }
        if (vector.containsIndex(Axis.X_INDEX) && vector.containsIndex(Axis.Y_INDEX) && vector.containsIndex(Axis.Z_INDEX)) {
            return x == vector.getIndex(Axis.X_INDEX) && y == vector.getIndex(Axis.Y_INDEX) && z == vector.getIndex(Axis.Z_INDEX);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
