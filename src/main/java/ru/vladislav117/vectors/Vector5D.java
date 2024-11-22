package ru.vladislav117.vectors;

import ru.vladislav117.vectors.error.VectorIndexError;

import java.util.Objects;

/**
 * Вектор в пятимерном пространстве.
 */
public class Vector5D implements Vector {
    /**
     * Размер вектора.
     */
    public static final int SIZE = 5;
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
     * Значение по оси v.
     */
    protected double v;

    /**
     * Создание пятимерного вектора.
     *
     * @param x Значение по оси абсцисс (x)
     * @param y Значение по оси ординат (y)
     * @param z Значение по оси аппликат (z)
     * @param w Значение по оси w
     * @param v Значение по оси v
     */
    public Vector5D(double x, double y, double z, double w, double v) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.v = v;
    }

    /**
     * Создание пятимерного вектора на основе другого вектора.
     * Если у векторов совпадают не все индексы значений, то значения по таким индексам будут взяты за 0.
     *
     * @param vector Вектор, значения по осям которого будут взяты
     */
    public Vector5D(Vector vector) {
        if (vector instanceof Vector5D vector5D) {
            x = vector5D.x;
            y = vector5D.y;
            z = vector5D.z;
            w = vector5D.w;
            v = vector5D.v;
            return;
        }
        x = vector.getIndexOrZero(Axis.X_INDEX);
        y = vector.getIndexOrZero(Axis.Y_INDEX);
        z = vector.getIndexOrZero(Axis.Z_INDEX);
        w = vector.getIndexOrZero(Axis.W_INDEX);
        v = vector.getIndexOrZero(Axis.V_INDEX);
    }

    /**
     * Создание пятимерного вектора с нулевыми значениями.
     */
    public Vector5D() {
        x = 0;
        y = 0;
        z = 0;
        w = 0;
        v = 0;
    }

    @Override
    public Vector5D clone() {
        try {
            Vector5D cloned = (Vector5D) super.clone();
            cloned.x = x;
            cloned.y = y;
            cloned.z = z;
            cloned.w = w;
            cloned.v = v;
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
        return index == Axis.X_INDEX || index == Axis.Y_INDEX || index == Axis.Z_INDEX || index == Axis.W_INDEX || index == Axis.V_INDEX;
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

    /**
     * Получение значения по оси v.
     *
     * @return Значение по оси v.
     */
    public double getV() {
        return v;
    }

    @Override
    public double getIndex(int index) {
        return switch (index) {
            case Axis.X_INDEX -> x;
            case Axis.Y_INDEX -> y;
            case Axis.Z_INDEX -> z;
            case Axis.W_INDEX -> w;
            case Axis.V_INDEX -> v;
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
            case Axis.V_INDEX -> v;
            default -> 0;
        };
    }

    /**
     * Установка значения по оси абсцисс (x).
     *
     * @param x Значение по оси абсцисс (x)
     * @return Этот же вектор.
     */
    public Vector5D setX(double x) {
        this.x = x;
        return this;
    }

    /**
     * Установка значения по оси ординат (y).
     *
     * @param y Значение по оси ординат (y)
     * @return Этот же вектор.
     */
    public Vector5D setY(double y) {
        this.y = y;
        return this;
    }

    /**
     * Установка значения по оси аппликат (z).
     *
     * @param z Значение по оси аппликат (z)
     * @return Этот же вектор.
     */
    public Vector5D setZ(double z) {
        this.z = z;
        return this;
    }

    /**
     * Установка значения по оси w.
     *
     * @param w Значение по оси w
     * @return Этот же вектор.
     */
    public Vector5D setW(double w) {
        this.w = w;
        return this;
    }

    /**
     * Установка значения по оси v.
     *
     * @param v Значение по оси v
     * @return Этот же вектор.
     */
    public Vector5D setV(double v) {
        this.v = v;
        return this;
    }

    @Override
    public Vector5D setIndex(int index, double value) {
        switch (index) {
            case Axis.X_INDEX -> x = value;
            case Axis.Y_INDEX -> y = value;
            case Axis.Z_INDEX -> z = value;
            case Axis.W_INDEX -> w = value;
            case Axis.V_INDEX -> v = value;
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
    public Vector5D addX(double summand) {
        x += summand;
        return this;
    }

    /**
     * Прибавление к значению по оси ординат (y).
     *
     * @param summand Слагаемое
     * @return Этот же вектор.
     */
    public Vector5D addY(double summand) {
        y += summand;
        return this;
    }

    /**
     * Прибавление к значению по оси аппликат (z).
     *
     * @param summand Слагаемое
     * @return Этот же вектор.
     */
    public Vector5D addZ(double summand) {
        z += summand;
        return this;
    }

    /**
     * Прибавление к значению по оси w.
     *
     * @param summand Слагаемое
     * @return Этот же вектор.
     */
    public Vector5D addW(double summand) {
        w += summand;
        return this;
    }

    /**
     * Прибавление к значению по оси v.
     *
     * @param summand Слагаемое
     * @return Этот же вектор.
     */
    public Vector5D addV(double summand) {
        v += summand;
        return this;
    }

    @Override
    public Vector5D addIndex(int index, double summand) {
        switch (index) {
            case Axis.X_INDEX -> x += summand;
            case Axis.Y_INDEX -> y += summand;
            case Axis.Z_INDEX -> z += summand;
            case Axis.W_INDEX -> w += summand;
            case Axis.V_INDEX -> v += summand;
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
    public Vector5D subtractX(double subtrahend) {
        x -= subtrahend;
        return this;
    }

    /**
     * Вычитание из значения по оси ординат (y).
     *
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     */
    public Vector5D subtractY(double subtrahend) {
        y -= subtrahend;
        return this;
    }

    /**
     * Вычитание из значения по оси аппликат (z).
     *
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     */
    public Vector5D subtractZ(double subtrahend) {
        z -= subtrahend;
        return this;
    }

    /**
     * Вычитание из значения по оси w.
     *
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     */
    public Vector5D subtractW(double subtrahend) {
        w -= subtrahend;
        return this;
    }

    /**
     * Вычитание из значения по оси v.
     *
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     */
    public Vector5D subtractV(double subtrahend) {
        v -= subtrahend;
        return this;
    }

    @Override
    public Vector5D subtractIndex(int index, double subtrahend) {
        switch (index) {
            case Axis.X_INDEX -> x -= subtrahend;
            case Axis.Y_INDEX -> y -= subtrahend;
            case Axis.Z_INDEX -> z -= subtrahend;
            case Axis.W_INDEX -> w -= subtrahend;
            case Axis.V_INDEX -> v -= subtrahend;
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
    public Vector5D multipleX(double multiplier) {
        x *= multiplier;
        return this;
    }

    /**
     * Умножение значения по оси ординат (y).
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    public Vector5D multipleY(double multiplier) {
        y *= multiplier;
        return this;
    }

    /**
     * Умножение значения по оси аппликат (z).
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    public Vector5D multipleZ(double multiplier) {
        z *= multiplier;
        return this;
    }

    /**
     * Умножение значения по оси w.
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    public Vector5D multipleW(double multiplier) {
        w *= multiplier;
        return this;
    }

    /**
     * Умножение значения по оси v.
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    public Vector5D multipleV(double multiplier) {
        v *= multiplier;
        return this;
    }

    @Override
    public Vector5D multipleIndex(int index, double multiplier) {
        switch (index) {
            case Axis.X_INDEX -> x *= multiplier;
            case Axis.Y_INDEX -> y *= multiplier;
            case Axis.Z_INDEX -> z *= multiplier;
            case Axis.W_INDEX -> w *= multiplier;
            case Axis.V_INDEX -> v *= multiplier;
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
    public Vector5D divideX(double divisor) {
        x /= divisor;
        return this;
    }

    /**
     * Деление значения по оси ординат (y).
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    public Vector5D divideY(double divisor) {
        y /= divisor;
        return this;
    }

    /**
     * Деление значения по оси аппликат (z).
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    public Vector5D divideZ(double divisor) {
        z /= divisor;
        return this;
    }

    /**
     * Деление значения по оси w.
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    public Vector5D divideW(double divisor) {
        w /= divisor;
        return this;
    }

    /**
     * Деление значения по оси v.
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    public Vector5D divideV(double divisor) {
        v /= divisor;
        return this;
    }

    @Override
    public Vector5D divideIndex(int index, double divisor) {
        switch (index) {
            case Axis.X_INDEX -> x /= divisor;
            case Axis.Y_INDEX -> y /= divisor;
            case Axis.Z_INDEX -> z /= divisor;
            case Axis.W_INDEX -> w /= divisor;
            case Axis.V_INDEX -> v /= divisor;
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
     * @param v Значение по оси v
     * @return Этот же вектор.
     */
    public Vector5D set(double x, double y, double z, double w, double v) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.v = v;
        return this;
    }

    @Override
    public Vector5D set(Vector vector) {
        if (vector instanceof Vector5D vector5D) {
            x = vector5D.x;
            y = vector5D.y;
            z = vector5D.z;
            w = vector5D.w;
            v = vector5D.v;
            return this;
        }
        if (vector.containsIndex(Axis.X_INDEX)) x = vector.getIndex(Axis.X_INDEX);
        if (vector.containsIndex(Axis.Y_INDEX)) y = vector.getIndex(Axis.Y_INDEX);
        if (vector.containsIndex(Axis.Z_INDEX)) z = vector.getIndex(Axis.Z_INDEX);
        if (vector.containsIndex(Axis.W_INDEX)) w = vector.getIndex(Axis.W_INDEX);
        if (vector.containsIndex(Axis.V_INDEX)) v = vector.getIndex(Axis.V_INDEX);
        return this;
    }

    /**
     * Прибавление к значениям вектора.
     *
     * @param summandX Слагаемое по оси абсцисс (x)
     * @param summandY Слагаемое по оси ординат (y)
     * @param summandZ Слагаемое по оси аппликат (z)
     * @param summandW Слагаемое по оси w
     * @param summandV Слагаемое по оси v
     * @return Этот же вектор.
     */
    public Vector5D add(double summandX, double summandY, double summandZ, double summandW, double summandV) {
        x += summandX;
        y += summandY;
        z += summandZ;
        w += summandW;
        v += summandV;
        return this;
    }

    @Override
    public Vector5D add(Vector summand) {
        if (summand instanceof Vector5D summand5D) {
            x += summand5D.x;
            y += summand5D.y;
            z += summand5D.z;
            w += summand5D.w;
            v += summand5D.v;
            return this;
        }
        x += summand.getIndexOrZero(Axis.X_INDEX);
        y += summand.getIndexOrZero(Axis.Y_INDEX);
        z += summand.getIndexOrZero(Axis.Z_INDEX);
        w += summand.getIndexOrZero(Axis.W_INDEX);
        v += summand.getIndexOrZero(Axis.V_INDEX);
        return this;
    }

    /**
     * Вычитание из значений вектора.
     *
     * @param subtrahendX Вычитаемое по оси абсцисс (x)
     * @param subtrahendY Вычитаемое по оси ординат (y)
     * @param subtrahendZ Вычитаемое по оси аппликат (z)
     * @param subtrahendW Вычитаемое по оси w
     * @param subtrahendV Вычитаемое по оси v
     * @return Этот же вектор.
     */
    public Vector5D subtract(double subtrahendX, double subtrahendY, double subtrahendZ, double subtrahendW, double subtrahendV) {
        x -= subtrahendX;
        y -= subtrahendY;
        z -= subtrahendZ;
        w -= subtrahendW;
        v -= subtrahendV;
        return this;
    }

    @Override
    public Vector5D subtract(Vector subtrahend) {
        if (subtrahend instanceof Vector5D subtrahend5D) {
            x -= subtrahend5D.x;
            y -= subtrahend5D.y;
            z -= subtrahend5D.z;
            w -= subtrahend5D.w;
            v -= subtrahend5D.v;
            return this;
        }
        x -= subtrahend.getIndexOrZero(Axis.X_INDEX);
        y -= subtrahend.getIndexOrZero(Axis.Y_INDEX);
        z -= subtrahend.getIndexOrZero(Axis.Z_INDEX);
        w -= subtrahend.getIndexOrZero(Axis.W_INDEX);
        v -= subtrahend.getIndexOrZero(Axis.V_INDEX);
        return this;
    }

    @Override
    public Vector5D multiple(double multiplier) {
        x *= multiplier;
        y *= multiplier;
        z *= multiplier;
        w *= multiplier;
        v *= multiplier;
        return this;
    }

    @Override
    public Vector5D divide(double divisor) {
        x /= divisor;
        y /= divisor;
        z /= divisor;
        w /= divisor;
        v /= divisor;
        return this;
    }

    @Override
    public double length() {
        return Math.sqrt(x * x + y * y + z * z + w * w + v * v);
    }

    @Override
    public double distance(Vector vector) {
        if (vector instanceof Vector5D vector5D) {
            return Math.sqrt((x - vector5D.x) * (x - vector5D.x) + (y - vector5D.y) * (y - vector5D.y) + (z - vector5D.z) * (z - vector5D.z) + (w - vector5D.w) * (w - vector5D.w) + (v - vector5D.v) * (v - vector5D.v));
        }
        return Math.sqrt((x - vector.getIndexOrZero(Axis.X_INDEX)) * (x - vector.getIndexOrZero(Axis.X_INDEX)) + (y - vector.getIndexOrZero(Axis.Y_INDEX)) * (y - vector.getIndexOrZero(Axis.Y_INDEX)) + (z - vector.getIndexOrZero(Axis.Z_INDEX)) * (z - vector.getIndexOrZero(Axis.Z_INDEX)) + (w - vector.getIndexOrZero(Axis.W_INDEX)) * (w - vector.getIndexOrZero(Axis.W_INDEX)) + (v - vector.getIndexOrZero(Axis.V_INDEX)) * (v - vector.getIndexOrZero(Axis.V_INDEX)));
    }

    @Override
    public Vector5D normalize() {
        double length = length();
        x /= length;
        y /= length;
        z /= length;
        w /= length;
        v /= length;
        return this;
    }

    @Override
    public Vector5D toNormalized() {
        double length = length();
        return new Vector5D(x / length, y / length, z / length, w / length, v / length);
    }

    @Override
    public Vector5D vectorTo(Vector vector) {
        if (vector instanceof Vector5D vector5D) {
            return new Vector5D(vector5D.x - x, vector5D.y - y, vector5D.z - z, vector5D.w - w, vector5D.v - v);
        }
        return new Vector5D(vector.getIndexOrZero(Axis.X_INDEX) - x, vector.getIndexOrZero(Axis.Y_INDEX) - y, vector.getIndexOrZero(Axis.Z_INDEX) - z, vector.getIndexOrZero(Axis.W_INDEX) - w, vector.getIndexOrZero(Axis.V_INDEX) - v);
    }

    @Override
    public Vector5D directionTo(Vector vector) {
        if (vector instanceof Vector5D vector5D) {
            return new Vector5D(vector5D.x - x, vector5D.y - y, vector5D.z - z, vector5D.w - w, vector5D.v - v).normalize();
        }
        return new Vector5D(vector.getIndexOrZero(Axis.X_INDEX) - x, vector.getIndexOrZero(Axis.Y_INDEX) - y, vector.getIndexOrZero(Axis.Z_INDEX) - z, vector.getIndexOrZero(Axis.W_INDEX) - w, vector.getIndexOrZero(Axis.V_INDEX) - v).normalize();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vector vector)) return false;
        if (vector instanceof Vector5D vector5D) {
            return x == vector5D.x && y == vector5D.y && z == vector5D.z && w == vector5D.w && v == vector5D.v;
        }
        if (vector.containsIndex(Axis.X_INDEX) && vector.containsIndex(Axis.Y_INDEX) && vector.containsIndex(Axis.Z_INDEX) && vector.containsIndex(Axis.W_INDEX) && vector.containsIndex(Axis.V_INDEX)) {
            return x == vector.getIndex(Axis.X_INDEX) && y == vector.getIndex(Axis.Y_INDEX) && z == vector.getIndex(Axis.Z_INDEX) && w == vector.getIndex(Axis.W_INDEX) && v == vector.getIndex(Axis.V_INDEX);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, w, v);
    }
}
