package ru.vladislav117.vectors;

/**
 * Абстрактный вектор.
 * Экземпляры реализаций этого интерфейса должны иметь конкретную длину и значения осей.
 */
public interface Vector extends Cloneable {
    /**
     * Создание копии вектора.
     *
     * @return Копия этого вектора.
     */
    Vector clone();

    /**
     * Получение размера вектора.
     *
     * @return Размер вектора.
     */
    int getSize();

    /**
     * Получение значения оси вектора.
     *
     * @param axis Индекс оси вектора
     * @return Значение оси вектора.
     * @see Vector#getAxis(Axis)
     */
    double getAxis(int axis);

    /**
     * Получение значения оси вектора.
     *
     * @param axis Ось вектора
     * @return Значение оси вектора.
     * @see Vector#getAxis(int)
     */
    double getAxis(Axis axis);

    /**
     * Получение значения оси вектора.
     * Если у вектора нет оси с указанным индексом, будет возвращён 0.
     *
     * @param axis Индекс оси вектора
     * @return Значение оси вектора.
     * @see Vector#getAxisOrZero(Axis)
     */
    double getAxisOrZero(int axis);

    /**
     * Получение значения оси вектора.
     * Если у вектора нет указанной оси, будет возвращён 0.
     *
     * @param axis Ось вектора
     * @return Значение оси вектора.
     * @see Vector#getAxisOrZero(int)
     */
    double getAxisOrZero(Axis axis);

    /**
     * Установка значения оси вектора.
     *
     * @param axis  Индекс оси вектора
     * @param value Значение оси вектора
     * @return Этот же вектор.
     * @see Vector#setAxis(Axis, double)
     */
    Vector setAxis(int axis, double value);

    /**
     * Установка значения оси вектора.
     *
     * @param axis  Ось вектора
     * @param value Значение оси вектора
     * @return Этот же вектор.
     * @see Vector#setAxis(int, double)
     */
    Vector setAxis(Axis axis, double value);

    /**
     * Прибавление к значению оси вектора.
     *
     * @param axis    Индекс оси вектора
     * @param summand Слагаемое
     * @return Этот же вектор.
     * @see Vector#addAxis(Axis, double)
     */
    Vector addAxis(int axis, double summand);

    /**
     * Прибавление к значению оси вектора.
     *
     * @param axis    Ось вектора
     * @param summand Слагаемое
     * @return Этот же вектор.
     * @see Vector#addAxis(int, double)
     */
    Vector addAxis(Axis axis, double summand);

    /**
     * Вычитание из значения оси вектора.
     *
     * @param axis       Индекс оси вектора
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     * @see Vector#subtractAxis(Axis, double)
     */
    Vector subtractAxis(int axis, double subtrahend);

    /**
     * Вычитание из значения оси вектора.
     *
     * @param axis       Ось вектора
     * @param subtrahend Вычитаемое
     * @return Этот же вектор.
     * @see Vector#subtractAxis(int, double)
     */
    Vector subtractAxis(Axis axis, double subtrahend);

    /**
     * Умножение значения оси вектора.
     *
     * @param axis       Индекс оси вектора
     * @param multiplier Множитель
     * @return Этот же вектор.
     * @see Vector#multipleAxis(Axis, double)
     */
    Vector multipleAxis(int axis, double multiplier);

    /**
     * Умножение значения оси вектора.
     *
     * @param axis       Ось вектора
     * @param multiplier Множитель
     * @return Этот же вектор.
     * @see Vector#multipleAxis(int, double)
     */
    Vector multipleAxis(Axis axis, double multiplier);

    /**
     * Деление значения оси вектора.
     *
     * @param axis    Индекс оси вектора
     * @param divisor Делитель
     * @return Этот же вектор.
     * @see Vector#divideAxis(Axis, double)
     */
    Vector divideAxis(int axis, double divisor);

    /**
     * Деление значения оси вектора.
     *
     * @param axis    Ось вектора
     * @param divisor Делитель
     * @return Этот же вектор.
     * @see Vector#divideAxis(int, double)
     */
    Vector divideAxis(Axis axis, double divisor);

    /**
     * Установка значений осей вектора соответственно другому вектору.
     * Если вектора разной длины, значения осей будут взяты по возможности.
     *
     * @param vector Вектор, значения осей которого будут взяты
     * @return Этот же вектор.
     */
    Vector set(Vector vector);

    /**
     * Прибавление значений осей вектора соответственно другому вектору.
     * Если вектора разной длины, значения осей будут взяты по возможности.
     *
     * @param summand Вектор, значения осей которого будут взяты как слагаемые
     * @return Этот же вектор.
     */
    Vector add(Vector summand);

    /**
     * Вычитание значений осей вектора соответственно другому вектору.
     * Если вектора разной длины, значения осей будут взяты по возможности.
     *
     * @param subtrahend Вектор, значения осей которого будут взяты как вычитаемые
     * @return Этот же вектор.
     */
    Vector subtract(Vector subtrahend);

    /**
     * Умножение значений всех осей вектора.
     *
     * @param multiplier Множитель
     * @return Этот же вектор.
     */
    Vector multiple(double multiplier);

    /**
     * Деление значений всех осей вектора.
     *
     * @param divisor Делитель
     * @return Этот же вектор.
     */
    Vector divide(double divisor);

    /**
     * Приведение вектора к нормальной форме. Изменяется этот же вектор.
     *
     * @return Этот же вектор.
     * @see Vector#toNormalized()
     */
    Vector normalize();

    /**
     * Приведение копии вектора к нормальной форме. Этот вектор не изменяется.
     *
     * @return Копия этого вектора в нормальной форме.
     * @see Vector#normalize()
     */
    Vector toNormalized();

    /**
     * Вычисление длины вектора.
     *
     * @return Длина вектора.
     */
    double length();

    /**
     * Вычисление расстояния до другого вектора.
     * Если вектора разной длины, произойдет ошибка.
     *
     * @param vector Вектор, расстояние до которого будет вычислено
     * @return Расстояние до вектора.
     */
    double distance(Vector vector);
}
