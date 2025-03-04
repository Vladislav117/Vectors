# Vectors

Vectors - java-библиотека содержащая функционал для работы с векторами.
На данный момент присутствуют реализации 1D, 2D, 3D, 4D и 5D векторов.

## Добавление зависимости

Для добавления зависимости добавьте следующее в ваш `build.grale`:

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.Vladislav117:Vectors:v1.2.1'
}
```

> В коде выше может быть указана устаревшая версия. Сверяйте версию в коде с версией последнего релиза.

## Использование

На данный момент вы можете использовать следующие классы и интерфейсы:

- `Vector` - Основной интерфейс, используемый для реализации векторов различной размерности.
- `Vector1D` - Одномерный вектор, имеет координату по оси абсцисс (x).
- `Vector2D` - Двумерный вектор, имеет координаты по оси абсцисс (x) и оси ординат (y).
- `Vector3D` - Трёхмерный вектор, имеет координаты по оси абсцисс (x), оси ординат (y) и оси аппликат (z).
- `Vector4D` - Четырёхмерный вектор, имеет координаты по осям x, y, z, w.
- `Vector5D` - Пятимерный вектор, имеет координаты по осям x, y, z, w, v.
- `ArrayVector` - Вектор, хранящий значения по осям в массие `double[]`.
- `Axis` - Класс, хранящий индексы осей.

Каждый класс, интерфейс и их методы задокументированы. Вы можете прочитать документацию в исходном коде или подсказках
вашей IDE (если IDE предоставляет такую возможность).

## Сборка

Сборка выполняется командой `./gradlew build`
