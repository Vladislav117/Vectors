package ru.vladislav117.vectors;

import ru.vladislav117.vectors.error.VectorSizeIncompatibilityError;
import ru.vladislav117.vectors.error.WrongAxisIndexError;

/**
 * Вектор в трёхмерном пространстве.
 */
public class Vector3D implements Vector {
    /**
     * Размер вектора.
     */
    public static final int SIZE = 3;
    /**
     * Значение оси абсцисс (X).
     */
    protected double x;
    /**
     * Значение оси ординат (Y).
     */
    protected double y;
    /**
     * Значение оси аппликат (Z).
     */
    protected double z;

    /**
     * Создание вектора.
     *
     * @param x Значение оси абсцисс (X)
     * @param y Значение оси ординат (Y)
     * @param z Значение оси аппликат (Z)
     */
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Создание вектора на основе другого вектора.
     * Значения осей будут взяты по возможности.
     *
     * @param vector Вектор, значения осей которого будут взяты
     */
    public Vector3D(Vector vector) {
        if (vector instanceof Vector3D vector3D) {
            x = vector3D.x;
            y = vector3D.y;
            z = vector3D.z;
            return;
        }
        x = vector.getAxisOrZero(Axis.X_INDEX);
        y = vector.getAxisOrZero(Axis.Y_INDEX);
        z = vector.getAxisOrZero(Axis.Z_INDEX);
    }

    /**
     * Создание вектора с нулевыми значениями осей.
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

    /**
     * Получение значения оси аппликат (Z).
     *
     * @return Значение оси аппликат (Z).
     */
    public double getZ() {
        return z;
    }

    @Override
    public double getAxis(int axis) {
        return switch (axis) {
            case Axis.X_INDEX -> x;
            case Axis.Y_INDEX -> y;
            case Axis.Z_INDEX -> z;
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
            case Axis.Z_INDEX -> z;
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
    public Vector3D setX(double x) {
        this.x = x;
        return this;
    }

    /**
     * Установка значения оси ординат (Y).
     *
     * @param y Значение оси ординат (Y)
     * @return Этот же вектор.
     */
    public Vector3D setY(double y) {
        this.y = y;
        return this;
    }

    /**
     * Установка значения оси аппликат (Z).
     *
     * @param z Значение оси аппликат (Z)
     * @return Этот же вектор.
     */
    public Vector3D setZ(double z) {
        this.z = z;
        return this;
    }

    @Override
    public Vector3D setAxis(int axis, double value) {
        switch (axis) {
            case Axis.X_INDEX -> x = value;
            case Axis.Y_INDEX -> y = value;
            case Axis.Z_INDEX -> z = value;
            default -> throw new WrongAxisIndexError(axis, this);
        }
        return this;
    }

    @Override
    public Vector3D setAxis(Axis axis, double value) {
        return setAxis(axis.getIndex(), value);
    }

    /**
     * Прибавление к значению оси абсцисс (X).
     *
     * @param summand Слагаемое
     * @return Этот же вектор.
     */
    public Vector3D addX(double summand) {
        x += summand;
        return this;
    }

    /**
     * Прибавление к значению оси ординат (Y).
     *
     * @param summand Слагаемое
     * @return Этот же вектор.
     */
    public Vector3D addY(double summand) {
        y += summand;
        return this;
    }

    /**
     * Прибавление к значению оси аппликат (Z).
     *
     * @param summand Слагаемое
     * @return Этот же вектор.
     */
    public Vector3D addZ(double summand) {
        z += summand;
        return this;
    }

    @Override
    public Vector3D addAxis(int axis, double summand) {
        switch (axis) {
            case Axis.X_INDEX -> x += summand;
            case Axis.Y_INDEX -> y += summand;
            case Axis.Z_INDEX -> z += summand;
            default -> throw new WrongAxisIndexError(axis, this);
        }
        return this;
    }

    @Override
    public Vector3D addAxis(Axis axis, double summand) {
        return addAxis(axis.getIndex(), summand);
    }

    /**
     * Вычитание из значения оси абсцисс (X).
     *
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     */
    public Vector3D subtractX(double subtrahend) {
        x -= subtrahend;
        return this;
    }

    /**
     * Вычитание из значения оси ординат (Y).
     *
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     */
    public Vector3D subtractY(double subtrahend) {
        y -= subtrahend;
        return this;
    }

    /**
     * Вычитание из значения оси аппликат (Z).
     *
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     */
    public Vector3D subtractZ(double subtrahend) {
        z -= subtrahend;
        return this;
    }

    @Override
    public Vector3D subtractAxis(int axis, double subtrahend) {
        switch (axis) {
            case Axis.X_INDEX -> x -= subtrahend;
            case Axis.Y_INDEX -> y -= subtrahend;
            case Axis.Z_INDEX -> z -= subtrahend;
            default -> throw new WrongAxisIndexError(axis, this);
        }
        return this;
    }

    @Override
    public Vector3D subtractAxis(Axis axis, double subtrahend) {
        return subtractAxis(axis.getIndex(), subtrahend);
    }

    /**
     * Умножение значения оси абсцисс (X).
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    public Vector3D multipleX(double multiplier) {
        x *= multiplier;
        return this;
    }

    /**
     * Умножение значения оси ординат (Y).
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    public Vector3D multipleY(double multiplier) {
        y *= multiplier;
        return this;
    }

    /**
     * Умножение значения оси аппликат (Z).
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    public Vector3D multipleZ(double multiplier) {
        z *= multiplier;
        return this;
    }

    @Override
    public Vector3D multipleAxis(int axis, double multiplier) {
        switch (axis) {
            case Axis.X_INDEX -> x *= multiplier;
            case Axis.Y_INDEX -> y *= multiplier;
            case Axis.Z_INDEX -> z *= multiplier;
            default -> throw new WrongAxisIndexError(axis, this);
        }
        return this;
    }

    @Override
    public Vector3D multipleAxis(Axis axis, double multiplier) {
        return multipleAxis(axis.getIndex(), multiplier);
    }

    /**
     * Деление значения оси абсцисс (X).
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    public Vector3D divideX(double divisor) {
        x /= divisor;
        return this;
    }

    /**
     * Деление значения оси ординат (Y).
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    public Vector3D divideY(double divisor) {
        y /= divisor;
        return this;
    }

    /**
     * Деление значения оси аппликат (Z).
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    public Vector3D divideZ(double divisor) {
        z /= divisor;
        return this;
    }

    @Override
    public Vector3D divideAxis(int axis, double divisor) {
        switch (axis) {
            case Axis.X_INDEX -> x /= divisor;
            case Axis.Y_INDEX -> y /= divisor;
            case Axis.Z_INDEX -> z /= divisor;
            default -> throw new WrongAxisIndexError(axis, this);
        }
        return this;
    }

    @Override
    public Vector3D divideAxis(Axis axis, double divisor) {
        return divideAxis(axis.getIndex(), divisor);
    }

    /**
     * Установка значений осей вектора.
     *
     * @param x Значение оси абсцисс (X)
     * @param y Значение оси ординат (Y)
     * @param z Значение оси аппликат (Z)
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
        x = vector.getAxisOrZero(Axis.X_INDEX);
        y = vector.getAxisOrZero(Axis.Y_INDEX);
        z = vector.getAxisOrZero(Axis.Z_INDEX);
        return this;
    }

    /**
     * Прибавление к значениям осей вектора.
     *
     * @param summandX Слагаемое оси абсцисс (X)
     * @param summandY Слагаемое оси ординат (Y)
     * @param summandZ Слагаемое оси аппликат (Z)
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
        x += summand.getAxisOrZero(Axis.X_INDEX);
        y += summand.getAxisOrZero(Axis.Y_INDEX);
        z += summand.getAxisOrZero(Axis.Z_INDEX);
        return this;
    }

    /**
     * Вычитание из значений осей вектора.
     *
     * @param subtrahendX Вычитаемое оси абсцисс (X)
     * @param subtrahendY Вычитаемое оси ординат (Y)
     * @param subtrahendZ Вычитаемое оси аппликат (Z)
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
        x -= subtrahend.getAxisOrZero(Axis.X_INDEX);
        y -= subtrahend.getAxisOrZero(Axis.Y_INDEX);
        z -= subtrahend.getAxisOrZero(Axis.Z_INDEX);
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
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public double distance(Vector vector) {
        if (vector instanceof Vector3D vector3D) {
            return Math.sqrt((x - vector3D.x) * (x - vector3D.x) + (y - vector3D.y) * (y - vector3D.y) + (z - vector3D.z) * (z - vector3D.z));
        }
        if (vector.getSize() == SIZE) {
            return Math.sqrt((x - vector.getAxis(Axis.X_INDEX)) * (x - vector.getAxis(Axis.X_INDEX)) + (y - vector.getAxis(Axis.Y_INDEX)) * (y - vector.getAxis(Axis.Y_INDEX)) + (z - vector.getAxis(Axis.Z_INDEX)) * (z - vector.getAxis(Axis.Z_INDEX)));
        }
        throw new VectorSizeIncompatibilityError(this, vector);
    }
}
