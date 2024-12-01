public class Main {
    public static void main(String[] args) {
        try {
            // Ініціалізація тексту
            String text = "В кокжномку слосві заздазного рерчерннря, видвалвивтив всві нанстнупні вховджевннвя першпопї літлерли цьоцго слсовса.";

            // Викликаємо метод для обробки тексту
            String processedText = processText(text);

            // Виведення результату
            System.out.println("Оброблений текст: ");
            System.out.println(processedText);
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    // Метод для обробки тексту
    public static String processText(String text) {
        // Перевірка на порожній текст
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Текст не може бути порожнім.");
        }

        String[] words = text.split(" "); // Розділяємо текст на слова
        StringBuilder result = new StringBuilder(); // Будуємо новий текст

        for (String word : words) {
            String firstLetter = word.substring(0, 1); // Перша літера слова
            StringBuilder processedWord = new StringBuilder(word.substring(0, 1)); // Початок обробленого слова

            // Додаємо до processedWord тільки ті літери, що не є першою літерою
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) != firstLetter.charAt(0)) {
                    processedWord.append(word.charAt(i));
                }
            }

            // Додаємо оброблене слово до результату
            result.append(processedWord.toString()).append(" ");
        }

        // Повертаємо результат без зайвого пробілу в кінці
        return result.toString().trim();
    }
}
