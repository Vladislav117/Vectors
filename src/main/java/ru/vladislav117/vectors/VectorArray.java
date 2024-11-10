package ru.vladislav117.vectors;

import ru.vladislav117.vectors.error.VectorSizeIncompatibilityError;
import ru.vladislav117.vectors.error.WrongAxisIndexError;

import java.util.Arrays;

/**
 * Вектор-массив. Имеет такую размерность, которая равна длине массива.
 */
public class VectorArray implements Vector {
    /**
     * Массив значений осей.
     */
    protected double[] array;

    /**
     * Создание вектора-массива. Массив значений осей будет скопирован.
     *
     * @param array Массив значений осей
     */
    public VectorArray(double[] array) {
        this.array = new double[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
    }

    /**
     * Создание вектора-массива на основе другого вектора.
     * Массив будет размерностью с копируемый вектор.
     *
     * @param vector Вектор, размерность и значения осей которого будут взяты
     */
    public VectorArray(Vector vector) {
        array = new double[vector.getSize()];
        for (int axis = 0; axis < vector.getSize(); axis++) array[axis] = vector.getAxis(axis);
    }

    /**
     * Создание вектора-массива с нулевыми значениями осей.
     *
     * @param size Размер вектора
     */
    public VectorArray(int size) {
        array = new double[size];
        Arrays.fill(array, 0);
    }

    @Override
    public VectorArray clone() {
        try {
            VectorArray cloned = (VectorArray) super.clone();
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
    public double getAxis(int axis) {
        if (0 <= axis && axis < array.length) return array[axis];
        throw new WrongAxisIndexError(axis, this);
    }

    @Override
    public double getAxis(Axis axis) {
        return getAxis(axis.getIndex());
    }

    @Override
    public double getAxisOrZero(int axis) {
        if (0 <= axis && axis < array.length) return array[axis];
        return 0;
    }

    @Override
    public double getAxisOrZero(Axis axis) {
        return getAxisOrZero(axis.getIndex());
    }

    @Override
    public VectorArray setAxis(int axis, double value) {
        if (0 <= axis && axis < array.length) {
            array[axis] = value;
            return this;
        }
        throw new WrongAxisIndexError(axis, this);
    }

    @Override
    public VectorArray setAxis(Axis axis, double value) {
        return setAxis(axis.getIndex(), value);
    }

    @Override
    public VectorArray addAxis(int axis, double summand) {
        if (0 <= axis && axis < array.length) {
            array[axis] += summand;
            return this;
        }
        throw new WrongAxisIndexError(axis, this);
    }

    @Override
    public VectorArray addAxis(Axis axis, double summand) {
        return addAxis(axis.getIndex(), summand);
    }

    @Override
    public VectorArray subtractAxis(int axis, double subtrahend) {
        if (0 <= axis && axis < array.length) {
            array[axis] -= subtrahend;
            return this;
        }
        throw new WrongAxisIndexError(axis, this);
    }

    @Override
    public VectorArray subtractAxis(Axis axis, double subtrahend) {
        return subtractAxis(axis.getIndex(), subtrahend);
    }

    @Override
    public VectorArray multipleAxis(int axis, double multiplier) {
        if (0 <= axis && axis < array.length) {
            array[axis] *= multiplier;
            return this;
        }
        throw new WrongAxisIndexError(axis, this);
    }

    @Override
    public VectorArray multipleAxis(Axis axis, double multiplier) {
        return multipleAxis(axis.getIndex(), multiplier);
    }

    @Override
    public VectorArray divideAxis(int axis, double divisor) {
        if (0 <= axis && axis < array.length) {
            array[axis] /= divisor;
            return this;
        }
        throw new WrongAxisIndexError(axis, this);
    }

    @Override
    public VectorArray divideAxis(Axis axis, double divisor) {
        return divideAxis(axis.getIndex(), divisor);
    }

    @Override
    public VectorArray set(Vector vector) {
        for (int axis = 0; axis < array.length; axis++) array[axis] = vector.getAxisOrZero(axis);
        return this;
    }

    @Override
    public VectorArray add(Vector summand) {
        for (int axis = 0; axis < array.length; axis++) array[axis] += summand.getAxisOrZero(axis);
        return this;
    }

    @Override
    public VectorArray subtract(Vector subtrahend) {
        for (int axis = 0; axis < array.length; axis++) array[axis] -= subtrahend.getAxisOrZero(axis);
        return this;
    }

    @Override
    public VectorArray multiple(double multiplier) {
        for (int axis = 0; axis < array.length; axis++) array[axis] *= multiplier;
        return this;
    }

    @Override
    public VectorArray divide(double divisor) {
        for (int axis = 0; axis < array.length; axis++) array[axis] /= divisor;
        return this;
    }

    @Override
    public VectorArray normalize() {
        double length = length();
        for (int axis = 0; axis < array.length; axis++) array[axis] = array[axis] / length;
        return this;
    }

    @Override
    public VectorArray toNormalized() {
        double length = length();
        double[] normalizedArray = new double[array.length];
        for (int axis = 0; axis < array.length; axis++) normalizedArray[axis] = array[axis] / length;
        return new VectorArray(normalizedArray);
    }

    @Override
    public double length() {
        double sumOfSquares = 0;
        for (double axisValue : array) sumOfSquares += axisValue * axisValue;
        return Math.sqrt(sumOfSquares);
    }

    @Override
    public double distance(Vector vector) {
        if (vector.getSize() == array.length) {
            double sumOfSquaresOfDifferences = 0;
            for (int axis = 0; axis < array.length; axis++) {
                sumOfSquaresOfDifferences += (array[axis] - vector.getAxis(axis)) * (array[axis] - vector.getAxis(axis));
            }
            return Math.sqrt(sumOfSquaresOfDifferences);
        }
        throw new VectorSizeIncompatibilityError(this, vector);
    }
}
