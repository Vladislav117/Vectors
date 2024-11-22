package ru.vladislav117.vectors.error;

/**
 * Ошибка несуществующего индекса вектора.
 * Возникает, когда вектор не имеет значения по указанному индексу.
 */
public class VectorIndexError extends Error {
    /**
     * Создание ошибки несуществующего индекса вектора.
     *
     * @param index Указанный индекс
     */
    public VectorIndexError(int index) {
        super("Vector has no value at index " + index);
    }
}
