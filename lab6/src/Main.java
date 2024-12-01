import java.util.Scanner;

// Клас для овочів (як і в попередньому коді)
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

class RootVegetable extends Vegetable {
    public RootVegetable(String name, double weight, double caloriesPer100g) {
        super(name, weight, caloriesPer100g);
    }
}

class LeafVegetable extends Vegetable {
    public LeafVegetable(String name, double weight, double caloriesPer100g) {
        super(name, weight, caloriesPer100g);
    }
}

class FruitVegetable extends Vegetable {
    public FruitVegetable(String name, double weight, double caloriesPer100g) {
        super(name, weight, caloriesPer100g);
    }
}

// Клас для однозв'язного списку
class CustomList<T> {
    private Node<T> head;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public CustomList() {
        head = null;
        size = 0;
    }

    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    public T getByName(String name) {
        Node<T> current = head;
        while (current != null) {
            if (((Vegetable) current.data).getName().equalsIgnoreCase(name)) {
                return current.data;
            }
            current = current.next;
        }
        return null; // Якщо не знайдено овоча з таким ім'ям
    }

    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }

        if (head.data.equals(o)) {
            head = head.next;
            size--;
            return true;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(o)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data).append("\n");
            current = current.next;
        }
        return sb.toString();
    }
}

// Головний клас для взаємодії з користувачем
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<Vegetable> saladIngredients = new CustomList<>();

        // Додаємо стандартні інгредієнти
        saladIngredients.add(new RootVegetable("Морква", 200, 41));
        saladIngredients.add(new LeafVegetable("Шпинат", 150, 23));
        saladIngredients.add(new FruitVegetable("Помідор", 100, 18));

        while (true) {
            // Виведення меню
            System.out.println("\n1. Показати всі овочі");
            System.out.println("2. Отримати овоч за ім'ям");
            System.out.println("3. Додати овоч");
            System.out.println("4. Видалити овоч");
            System.out.println("5. Вихід");
            System.out.print("Виберіть опцію: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Для обробки нового рядка

            switch (choice) {
                case 3: // Додати овоч
                    System.out.print("Введіть тип овочу (1 - Коренеплід, 2 - Листовий, 3 - Плід): ");
                    int type = scanner.nextInt();
                    scanner.nextLine(); // Для обробки нового рядка

                    System.out.print("Введіть назву овочу: ");
                    String name = scanner.nextLine();
                    double weight = getValidInput(scanner, "Введіть вагу овочу (в грамах, більше 0): ");
                    double calories = getValidInput(scanner, "Введіть калорійність на 100 г (більше 0): ");

                    // Створення об'єкта овочу відповідно до типу
                    Vegetable vegetable = null;
                    switch (type) {
                        case 1:
                            vegetable = new RootVegetable(name, weight, calories);
                            break;
                        case 2:
                            vegetable = new LeafVegetable(name, weight, calories);
                            break;
                        case 3:
                            vegetable = new FruitVegetable(name, weight, calories);
                            break;
                        default:
                            System.out.println("Невірний тип овочу.");
                            continue;
                    }

                    // Додавання овочу до списку
                    saladIngredients.add(vegetable);
                    System.out.println("Овоч додано!");
                    break;

                case 1: // Показати всі овочі
                    System.out.println("Інгредієнти салату:");
                    System.out.println(saladIngredients);
                    break;

                case 2: // Отримати овоч за ім'ям
                    System.out.print("Введіть назву овочу: ");
                    String vegName = scanner.nextLine();
                    Vegetable veg = (Vegetable) saladIngredients.getByName(vegName);
                    if (veg != null) {
                        System.out.println("Овоч знайдено: " + veg);
                    } else {
                        System.out.println("Овоч з таким ім'ям не знайдений.");
                    }
                    break;

                case 4: // Видалити овоч
                    System.out.print("Введіть назву овочу для видалення: ");
                    String nameToRemove = scanner.nextLine();
                    Vegetable vegetableToRemove = (Vegetable) saladIngredients.getByName(nameToRemove);
                    if (vegetableToRemove != null) {
                        saladIngredients.remove(vegetableToRemove);
                        System.out.println("Овоч видалено!");
                    } else {
                        System.out.println("Овоч не знайдено.");
                    }
                    break;

                case 5: // Вихід
                    System.out.println("До побачення!");
                    return;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    // Метод для перевірки вводу додатних чисел
    private static double getValidInput(Scanner scanner, String message) {
        double value;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                scanner.nextLine(); // Очистка буфера
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Помилка: значення має бути більше 0. Спробуйте ще раз.");
                }
            } else {
                System.out.println("Помилка: введіть числове значення. Спробуйте ще раз.");
                scanner.nextLine(); // Очистка буфера
            }
        }
    }
}
