package ru.vladislav117.vectors;

/**
 * Ось.
 */
public class Axis {
    /**
     * Индекс оси абсцисс (X).
     */
    public static final int X_INDEX = 0;
    /**
     * Индекс оси ординат (Y).
     */
    public static final int Y_INDEX = 1;
    /**
     * Индекс оси аппликат (Z).
     */
    public static final int Z_INDEX = 2;
    /**
     * Ось абсцисс (X).
     */
    public static Axis X = new Axis(X_INDEX);
    /**
     * Ось ординат (Y).
     */
    public static Axis Y = new Axis(Y_INDEX);
    /**
     * Ось аппликат (Z).
     */
    public static Axis Z = new Axis(Z_INDEX);

    /**
     * Индекс оси.
     */
    protected final int index;

    /**
     * Создание оси.
     *
     * @param index Индекс оси
     */
    public Axis(int index) {
        this.index = index;
    }

    /**
     * Получение индекса оси.
     *
     * @return Индекс оси.
     */
    public int getIndex() {
        return index;
    }
}
