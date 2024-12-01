import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Базовий клас для овочів
abstract class Vegetable {
    private String name; // Назва овочу
    private double weight; // Вага в грамах
    private double caloriesPer100g; // Калорійність на 100 грамів

    public Vegetable(String name, double weight, double caloriesPer100g) {
        if (weight <= 0 || caloriesPer100g <= 0) {
            throw new IllegalArgumentException("Вага та калорійність мають бути додатними."); // Перевірка на коректність даних
        }
        this.name = name;
        this.weight = weight;
        this.caloriesPer100g = caloriesPer100g;
    }

    public String getName() { return name; }
    public double getWeight() { return weight; }
    public double getCaloriesPer100g() { return caloriesPer100g; }

    // Розрахунок калорій на основі ваги
    public double calculateCalories() {
        return (weight / 100) * caloriesPer100g;
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f г, %.2f ккал)", name, weight, calculateCalories());
    }
}

// Клас для коренеплодів
class RootVegetable extends Vegetable {
    public RootVegetable(String name, double weight, double caloriesPer100g) {
        super(name, weight, caloriesPer100g);
    }
}

// Клас для листових овочів
class LeafVegetable extends Vegetable {
    public LeafVegetable(String name, double weight, double caloriesPer100g) {
        super(name, weight, caloriesPer100g);
    }
}

// Клас для плодів
class FruitVegetable extends Vegetable {
    public FruitVegetable(String name, double weight, double caloriesPer100g) {
        super(name, weight, caloriesPer100g);
    }
}

// Клас для салату, що складається з набору овочів
class Salad {
    private List<Vegetable> ingredients; // Список інгредієнтів салату

    public Salad() {
        this.ingredients = new ArrayList<>();
    }

    // Додає овоч до салату
    public void addIngredient(Vegetable vegetable) {
        ingredients.add(vegetable);
    }

    // Розраховує загальну калорійність салату
    public double calculateTotalCalories() {
        return ingredients.stream().mapToDouble(Vegetable::calculateCalories).sum();
    }

    // Сортує інгредієнти салату за калорійністю
    public void sortIngredientsByCalories() {
        ingredients.sort(Comparator.comparingDouble(Vegetable::calculateCalories));
    }

    // Знаходить овочі в заданому діапазоні калорійності
    public List<Vegetable> findVegetablesByCalorieRange(double minCalories, double maxCalories) {
        return ingredients.stream()
                .filter(v -> {
                    double calories = v.calculateCalories();
                    return calories >= minCalories && calories <= maxCalories;
                })
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Інгредієнти салату:\n" +
                ingredients.stream()
                        .map(Vegetable::toString)
                        .collect(Collectors.joining("\n"));
    }
}

// Головний клас з точкою входу в програму
public class Main {
    public static void main(String[] args) {
        try {
            Salad salad = new Salad(); // Створення об'єкта "Салат"

            // Додавання інгредієнтів до салату
            salad.addIngredient(new RootVegetable("Морква", 150, 41));
            salad.addIngredient(new LeafVegetable("Салат", 50, 15));
            salad.addIngredient(new FruitVegetable("Помідор", 100, 18));

            // Виведення інформації про салат
            System.out.println(salad);
            System.out.printf("Загальна калорійність: %.2f ккал\n", salad.calculateTotalCalories());

            // Сортування інгредієнтів за калорійністю
            salad.sortIngredientsByCalories();
            System.out.println("\nВідсортовані інгредієнти салату за калорійністю:");
            System.out.println(salad);

            // Пошук овочів у заданому діапазоні калорійності
            double minCalories = 10;
            double maxCalories = 30;
            List<Vegetable> found = salad.findVegetablesByCalorieRange(minCalories, maxCalories);
            System.out.printf("\nОвочі у діапазоні %.2f - %.2f ккал:\n", minCalories, maxCalories);
            found.forEach(System.out::println);

        } catch (IllegalArgumentException e) {
            // Обробка винятків
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
