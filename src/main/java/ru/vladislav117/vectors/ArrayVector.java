package ru.vladislav117.vectors;

import ru.vladislav117.vectors.error.VectorIndexError;

import java.util.Arrays;
import java.util.Objects;

/**
 * Вектор-массив. Имеет такую размерность, которая равна длине массива.
 */
public class ArrayVector implements Vector {
    /**
     * Массив значений осей.
     */
    protected double[] array;

    /**
     * Создание вектора-массива. Массив значений осей будет скопирован.
     *
     * @param array Массив значений осей
     */
    public ArrayVector(double[] array) {
        this.array = new double[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
    }

    /**
     * Создание вектора-массива с нулевыми значениями осей.
     *
     * @param size Размер вектора
     */
    public ArrayVector(int size) {
        array = new double[size];
        Arrays.fill(array, 0);
    }

    @Override
    public ArrayVector clone() {
        try {
            ArrayVector cloned = (ArrayVector) super.clone();
            cloned.array = new double[array.length];
            System.arraycopy(array, 0, cloned.array, 0, array.length);
            return cloned;
        } catch (CloneNotSupportedException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public int getSize() {
        return array.length;
    }

    @Override
    public boolean containsIndex(int index) {
        return 0 <= index && index < array.length;
    }

    @Override
    public double getIndex(int index) {
        if (0 <= index && index < array.length) return array[index];
        throw new VectorIndexError(index);
    }

    @Override
    public double getIndexOrZero(int index) {
        if (0 <= index && index < array.length) return array[index];
        return 0;
    }

    @Override
    public ArrayVector setIndex(int index, double value) {
        if (0 <= index && index < array.length) {
            array[index] = value;
            return this;
        }
        throw new VectorIndexError(index);
    }

    @Override
    public ArrayVector addIndex(int index, double summand) {
        if (0 <= index && index < array.length) {
            array[index] += summand;
            return this;
        }
        throw new VectorIndexError(index);
    }

    @Override
    public ArrayVector subtractIndex(int index, double subtrahend) {
        if (0 <= index && index < array.length) {
            array[index] -= subtrahend;
            return this;
        }
        throw new VectorIndexError(index);
    }

    @Override
    public ArrayVector multipleIndex(int index, double multiplier) {
        if (0 <= index && index < array.length) {
            array[index] *= multiplier;
            return this;
        }
        throw new VectorIndexError(index);
    }

    @Override
    public ArrayVector divideIndex(int index, double divisor) {
        if (0 <= index && index < array.length) {
            array[index] /= divisor;
            return this;
        }
        throw new VectorIndexError(index);
    }

    @Override
    public ArrayVector set(Vector vector) {
        for (int axis = 0; axis < array.length; axis++) {
            if (vector.containsIndex(axis)) array[axis] = vector.getIndex(axis);
        }
        return this;
    }

    @Override
    public ArrayVector add(Vector summand) {
        for (int axis = 0; axis < array.length; axis++) {
            array[axis] += summand.getIndexOrZero(axis);
        }
        return this;
    }

    @Override
    public ArrayVector subtract(Vector subtrahend) {
        for (int axis = 0; axis < array.length; axis++) {
            array[axis] -= subtrahend.getIndexOrZero(axis);
        }
        return this;
    }

    @Override
    public ArrayVector multiple(double multiplier) {
        for (int axis = 0; axis < array.length; axis++) {
            array[axis] *= multiplier;
        }
        return this;
    }

    @Override
    public ArrayVector divide(double divisor) {
        for (int axis = 0; axis < array.length; axis++) {
            array[axis] /= divisor;
        }
        return this;
    }

    @Override
    public double length() {
        double sumOfSquares = 0;
        for (double axisValue : array) sumOfSquares += axisValue * axisValue;
        return Math.sqrt(sumOfSquares);
    }

    @Override
    public double distance(Vector vector) {
        double sumOfSquaresOfDifferences = 0;
        for (int axis = 0; axis < array.length; axis++) {
            sumOfSquaresOfDifferences += (array[axis] - vector.getIndexOrZero(axis)) * (array[axis] - vector.getIndexOrZero(axis));
        }
        return Math.sqrt(sumOfSquaresOfDifferences);
    }

    @Override
    public ArrayVector normalize() {
        double length = length();
        for (int axis = 0; axis < array.length; axis++) array[axis] = array[axis] / length;
        return this;
    }

    @Override
    public ArrayVector toNormalized() {
        double length = length();
        double[] normalizedArray = new double[array.length];
        for (int axis = 0; axis < array.length; axis++) normalizedArray[axis] = array[axis] / length;
        return new ArrayVector(normalizedArray);
    }

    @Override
    public ArrayVector vectorTo(Vector vector) {
        ArrayVector vectorTo = new ArrayVector(array.length);
        for (int axis = 0; axis < array.length; axis++) {
            vectorTo.array[axis] = vector.getIndexOrZero(axis) - array[axis];
        }
        return vectorTo;
    }

    @Override
    public ArrayVector directionTo(Vector vector) {
        ArrayVector vectorTo = new ArrayVector(array.length);
        for (int axis = 0; axis < array.length; axis++) {
            vectorTo.array[axis] = vector.getIndexOrZero(axis) - array[axis];
        }
        return vectorTo.normalize();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vector vector)) return false;
        for (int axis = 0; axis < array.length; axis++) {
            if (!vector.containsIndex(axis)) return false;
            if (vector.getIndex(axis) != array[axis]) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}
