## Опис
Це програма для управління списком овочів. Вона 
дозволяє додавати, переглядати, шукати та 
видаляти овочі з списку, використовуючи однозв'язний список. 

## Функціональність

Програма підтримує наступні функції:

- **Додавання овоча** до списку з вибором типу овочу (коренеплід, листовий або плід).
- **Показ всіх овочів** в списку з виведенням інформації про назву, вагу та калорійність.
- **Пошук овочу** за іменем (з підтримкою регістронезалежного пошуку).
- **Видалення овочу** за його ім'ям.

## Опис класів

### 1. `Vegetable`
Абстрактний клас, який представляє овоч. Він містить такі поля:
- `name` — назва овочу.
- `weight` — вага овочу (в грамах).
- `caloriesPer100g` — калорійність на 100 г.

Методи класу:
- `getName()` — отримує назву овочу.
- `getWeight()` — отримує вагу овочу.
- `getCaloriesPer100g()` — отримує калорійність овочу на 100 г.
- `calculateCalories()` — обчислює калорійність овочу на основі його ваги.
- `toString()` — повертає рядкове представлення овочу.

### 2. `RootVegetable`, `LeafVegetable`, `FruitVegetable`
Ці класи наслідуються від `Vegetable` і представляють конкретні типи овочів:
- `RootVegetable` — коренеплоди (наприклад, морква).
- `LeafVegetable` — листові овочі (наприклад, шпинат).
- `FruitVegetable` — плодові овочі (наприклад, помідори).

### 3. `CustomList<T>`
Клас для реалізації однозв'язного списку. Він містить:
- Метод `add(T element)` — додає елемент в список.
- Метод `getByName(String name)` — шукає елемент за іменем.
- Метод `remove(Object o)` — видаляє елемент зі списку.
- Метод `size()` — повертає кількість елементів у списку.
- Метод `toString()` — повертає рядкове представлення списку.

### 4. `Main`
Головний клас, який керує взаємодією з користувачем:
- Запускає меню, яке дозволяє вибирати функції програми.
- Приймає ввід користувача для додавання, пошуку та видалення овочів.
- Виводить список овочів або результат пошуку за іменем.
## Як запустити програму

### Вимоги
1. **JDK** (Java Development Kit) версії 8 або вище.
2. **Середовище розробки:**
    - IntelliJ IDEA
    - Eclipse
    - Або можливість запуску через термінал.

### Результат виконання

**Приклад виведення:**

1. Показати всі овочі
2. Отримати овоч за ім'ям
3. Додати овоч
4. Видалити овоч
5. Вихід
   
   Виберіть опцію: 1

   Інгредієнти салату:

   Морква (200,00 г, 82,00 ккал)

   Шпинат (150,00 г, 34,50 ккал)
 
   Помідор (100,00 г, 18,00 ккал)


---

1. Показати всі овочі
2. Отримати овоч за ім'ям
3. Додати овоч
4. Видалити овоч
5. Вихід
 
   Виберіть опцію: 4

   Введіть назву овочу для видалення: Морква
 
   Овоч видалено!

### Кроки запуску
1. Відкрийте термінал або командний рядок.
2. Склонуйте репозиторій:
   ```bash
   git clone https://github.com/Ivan1845/lab6.git
   cd lab6
3. Відкрийте проєкт у IntelliJ IDEA або Eclipse:
    - У меню IDE виберіть File → Open.
    - Вкажіть шлях до папки lab6 і натисніть OK

4. Запустіть програму:
    - Відкрийте файл Main.java (він знаходиться в папці src/).
    - Натисніть кнопку "Run" (зелений трикутник) у середовищі розробки.