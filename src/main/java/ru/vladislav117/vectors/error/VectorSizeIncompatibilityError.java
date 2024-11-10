package ru.vladislav117.vectors.error;

import ru.vladislav117.vectors.Vector;

/**
 * Ошибка несовместимости размера векторов.
 * Возникает, когда над первым вектором проводится операция со вторым вектором, но их размерность не позволяет провести операцию.
 */
public class VectorSizeIncompatibilityError extends Error {
    /**
     * Создание ошибки несовместимости размера векторов.
     *
     * @param firstSize  Размер первого вектора
     * @param secondSize Размер второго вектора
     */
    public VectorSizeIncompatibilityError(int firstSize, int secondSize) {
        super("Vector size is " + firstSize + ", but vector with size " + secondSize + " was given");
    }

    /**
     * Создание ошибки несовместимости размера векторов.
     *
     * @param firstVector  Первый вектор
     * @param secondVector Второй вектор
     */
    public VectorSizeIncompatibilityError(Vector firstVector, Vector secondVector) {
        this(firstVector.getSize(), secondVector.getSize());
    }
}
