# Опис
Проєкт на мові програмування Java демонструє роботу з об'єктно-орієнтованим підходом через створення класу `Block`. Основне завдання програми:
- Ініціалізація масиву об'єктів `Block` із заданими полями.
- Сортування масиву за різними критеріями (за зростанням або спаданням).
- Пошук конкретного об'єкта в масиві.

## Основні етапи виконання програми
1. Ініціалізація масиву об'єктів `Block`.
2. Сортування масиву:
   - За зростанням значення поля `hardness`.
   - За спаданням значення поля `name`.
3. Пошук заданого блоку в масиві.
4. Обробка можливих виключень у разі помилкових даних або некоректного вхідного значення.

---

## Функціонал
- **Сортування масиву:**
   - За значенням твердості (`hardness`) у порядку зростання.
   - За назвою (`name`) у порядку спадання.
- **Пошук об'єкта:** Метод `equals` використовується для перевірки наявності заданого блоку в масиві.
- **Виведення результатів:** Кожен етап роботи програми супроводжується зрозумілим виведенням у консоль.

---

## Як запустити програму

### Вимоги
1. **JDK** (Java Development Kit) версії 8 або вище.
2. **Середовище розробки:**
   - IntelliJ IDEA
   - Eclipse
   - Або можливість запуску через термінал.

---
## Результат виконання
Після запуску програма виведе наступні дані:

1. Список блоків до сортування.
2. Масив, відсортований за зростанням поля `hardness`.
3. Масив, відсортований за спаданням по алфавітному порядку поля  `name`.
4. Результат пошуку заданого блоку.

**Приклад виведення:**

**До сортування:**

Block{id=1, name='Stone', hardness=1.5, color='Gray', material='Rock'}

Block{id=2, name='Wood', hardness=2.0, color='Brown', material='Wood'}

Block{id=3, name='Diamond', hardness=5.0, color='Blue', material='Gem'}

Block{id=4, name='Iron', hardness=4.0, color='Gray', material='Metal'}

Block{id=5, name='Gold', hardness=3.0, color='Yellow', material='Metal'}

**Після сортування за зростанням hardness:**

Block{id=1, name='Stone', hardness=1.5, color='Gray', material='Rock'}

Block{id=2, name='Wood', hardness=2.0, color='Brown', material='Wood'}

Block{id=5, name='Gold', hardness=3.0, color='Yellow', material='Metal'}

Block{id=4, name='Iron', hardness=4.0, color='Gray', material='Metal'}

Block{id=3, name='Diamond', hardness=5.0, color='Blue', material='Gem'}


**Після сортування за спаданням name:**

Block{id=2, name='Wood', hardness=2.0, color='Brown', material='Wood'}

Block{id=1, name='Stone', hardness=1.5, color='Gray', material='Rock'}

Block{id=4, name='Iron', hardness=4.0, color='Gray', material='Metal'}

Block{id=5, name='Gold', hardness=3.0, color='Yellow', material='Metal'}

Block{id=3, name='Diamond', hardness=5.0, color='Blue', material='Gem'}

*Чи знайдено блок Block{id=3, name='Diamond', hardness=5.0, color='Blue', material='Gem'}: true*

### Кроки запуску
1. Відкрийте термінал або командний рядок.
2. Склонуйте репозиторій:
   ```bash
   git clone https://github.com/Ivan1845/lab3.git
   cd lab3
3. Відкрийте проєкт у IntelliJ IDEA або Eclipse:
    - У меню IDE виберіть File → Open.
    - Вкажіть шлях до папки lab3 і натисніть OK

4. Запустіть програму:
    - Відкрийте файл Main.java (він знаходиться в папці src/).
    - Натисніть кнопку "Run" (зелений трикутник) у середовищі розробк