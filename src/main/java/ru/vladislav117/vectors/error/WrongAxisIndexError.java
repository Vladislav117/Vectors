package ru.vladislav117.vectors.error;

import ru.vladislav117.vectors.Vector;

/**
 * Ошибка неверного индекса оси.
 * Возникает, когда вектор не имеет значения оси с указанным индексом.
 */
public class WrongAxisIndexError extends Error {
    /**
     * Создание ошибки неверного индекса оси.
     *
     * @param givenAxisIndex Указанный индекс оси
     * @param vectorSize     Размер вектора
     */
    public WrongAxisIndexError(int givenAxisIndex, int vectorSize) {
        super("Vector size is " + vectorSize + ", but axis " + givenAxisIndex + " was given");
    }

    /**
     * Создание ошибки неверного индекса оси.
     *
     * @param givenAxisIndex Указанный индекс оси
     * @param vector         Вектор
     */
    public WrongAxisIndexError(int givenAxisIndex, Vector vector) {
        this(givenAxisIndex, vector.getSize());
    }
}
