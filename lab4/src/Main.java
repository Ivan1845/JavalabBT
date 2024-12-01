import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє літеру тексту.
 */
class Letter {
    private char value; // Літера

    public Letter(char value) {
        this.value = value; // Ініціалізація літери
    }

    public char getValue() {
        return value; // Повертає значення літери
    }

    @Override
    public String toString() {
        return String.valueOf(value); // Перетворює літеру в рядок
    }
}

/**
 * Клас, що представляє розділовий знак.
 */
class PunctuationMark {
    private char value; // Розділовий знак

    public PunctuationMark(char value) {
        this.value = value; // Ініціалізація розділового знаку
    }

    public char getValue() {
        return value; // Повертає значення розділового знаку
    }

    @Override
    public String toString() {
        return String.valueOf(value); // Перетворює знак на рядок
    }
}

/**
 * Клас, що представляє слово.
 */
class Word {
    private List<Letter> letters; // Літери слова

    public Word(String word) {
        letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(new Letter(c)); // Перетворює кожну букву на об'єкт Letter
        }
    }

    public Word process() {
        if (letters.isEmpty()) {
            return this; // Якщо слово порожнє, нічого не змінюємо
        }
        char firstLetter = letters.get(0).getValue(); // Перша літера
        List<Letter> processedLetters = new ArrayList<>();
        processedLetters.add(new Letter(firstLetter)); // Додаємо першу літеру

        // Додаємо інші літери, якщо вони не рівні першій
        for (int i = 1; i < letters.size(); i++) {
            if (letters.get(i).getValue() != firstLetter) {
                processedLetters.add(letters.get(i));
            }
        }

        this.letters = processedLetters; // Оновлюємо список літер
        return this;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Letter letter : letters) {
            result.append(letter); // Об'єднуємо всі літери в рядок
        }
        return result.toString();
    }
}

/**
 * Клас, що представляє речення.
 */
class Sentence {
    private List<Object> elements; // Слова і розділові знаки

    public Sentence(String sentence) {
        elements = new ArrayList<>();
        String[] tokens = sentence.split("(?=[,.!?])|\\s+"); // Розділяємо на слова і знаки
        for (String token : tokens) {
            if (token.matches("[,.!?]")) {
                elements.add(new PunctuationMark(token.charAt(0))); // Розділовий знак
            } else {
                elements.add(new Word(token)); // Слово
            }
        }
    }

    public Sentence process() {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) instanceof Word) {
                elements.set(i, ((Word) elements.get(i)).process()); // Обробка слова
            }
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object element : elements) {
            result.append(element.toString()); // Додаємо елементи речення
            if (element instanceof Word) {
                result.append(" "); // Пропуск між словами
            }
        }
        return result.toString().trim(); // Повертаємо готове речення
    }
}

/**
 * Клас, що представляє текст.
 */
class Text {
    private List<Sentence> sentences; // Речення в тексті

    public Text(String text) {
        sentences = new ArrayList<>();
        String[] sentenceArray = text.split("(?<=[.!?])\\s*"); // Розділяємо текст на речення
        for (String sentence : sentenceArray) {
            sentences.add(new Sentence(sentence)); // Додаємо кожне речення
        }
    }

    public Text process() {
        for (int i = 0; i < sentences.size(); i++) {
            sentences.set(i, sentences.get(i).process()); // Обробляємо кожне речення
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : sentences) {
            result.append(sentence.toString()).append(" "); // Додаємо всі речення
        }
        return result.toString().trim(); // Повертаємо текст
    }
}

/**
 * Головний клас для виконання програми.
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Ініціалізація тексту
            String text = "В кокжномку слосві заздазного рерчерннря, видвалвивтив всві нанстнупні вховджевннвя першпопї літлерли цьоцго слсовса.";

            // Обробка тексту
            Text processedText = new Text(text).process();

            // Виведення результату
            System.out.println("Оброблений текст:");
            System.out.println(processedText);
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage()); // Обробка помилок
        }
    }
}
