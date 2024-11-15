# Vectors

Vectors - java-библиотека содержащая функционал для работы с векторами.
На данный момент присутствуют реализации 1D, 2D и 3D векторов, а так же вектор-массив.

## Добавление зависимости

Для добавления зависимости добавьте следующее в ваш `build.grale`:

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.Vladislav117:Vectors:v1.0.4'
}
```

> В коде выше может быть указана устаревшая версия. Сверяйте версию в коде с версией последнего релиза.

## Использование

На данный момент вы можете использовать следующие классы и интерфейсы:

- `Vector` - Основной интерфейс, используемый для реализации векторов различной размерности.
- `Vector1D` - Одномерный вектор, имеет координату по оси абсцисс (X).
- `Vector2D` - Двумерный вектор, имеет координаты по оси абсцисс (X) и оси ординат (Y).
- `Vector3D` - Трёхмерный вектор, имеет координаты по оси абсцисс (X), оси ординат (Y) и оси аппликат (Z).
- `VectorArray` - Вектор, значения осей которого хранятся в `double[]` массиве.
- `Axis` - Класс, представляющий собой ось. Для обычного использования векторов излишний,
  но может потребоваться для реализации нестандартного функционала.

Каждый класс, интерфейс и их методы задокументированы. Вы можете прочитать документацию в исходном коде или подсказках
вашей IDE (если IDE предоставляет такую возможность).

## Сборка

Сборка выполняется командой `./gradlew build`
