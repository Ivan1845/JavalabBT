import java.util.Arrays;
import java.util.Comparator;

public class Block {
    // Поля класу Block
    private int id;
    private String name;
    private double hardness;
    private String color;
    private String material;

    // Конструктор класу
    public Block(int id, String name, double hardness, String color, String material) {
        this.id = id;
        this.name = name;
        this.hardness = hardness;
        this.color = color;
        this.material = material;
    }

    // Геттери для полів
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getHardness() {
        return hardness;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    // Перевизначення методу equals для порівняння блоків
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Block block = (Block) obj;
        return id == block.id && name.equals(block.name) && Double.compare(block.hardness, hardness) == 0 &&
                color.equals(block.color) && material.equals(block.material);
    }

    // Перевизначення методу toString для виведення об'єкта
    @Override
    public String toString() {
        return "Block{id=" + id + ", name='" + name + "', hardness=" + hardness + ", color='" + color + "', material='" + material + "'}";
    }

    public static void main(String[] args) {
        // Ініціалізація масиву з об'єктів Block
        Block[] blocks = {
                new Block(1, "Stone", 1.5, "Gray", "Rock"),
                new Block(2, "Wood", 2.0, "Brown", "Wood"),
                new Block(3, "Diamond", 5.0, "Blue", "Gem"),
                new Block(4, "Iron", 4.0, "Gray", "Metal"),
                new Block(5, "Gold", 3.0, "Yellow", "Metal")
        };

        // Виведення масиву до сортування
        System.out.println("До сортування:");
        for (Block block : blocks) {
            System.out.println(block);
        }

        // Сортування масиву за полем hardness (за зростанням)
        Arrays.sort(blocks, Comparator.comparingDouble(Block::getHardness));
        System.out.println("\nПісля сортування за зростанням hardness:");
        for (Block block : blocks) {
            System.out.println(block);
        }

        // Сортування масиву за полем name (за спаданням)
        Arrays.sort(blocks, Comparator.comparing(Block::getName).reversed());
        System.out.println("\nПісля сортування за спаданням name:");
        for (Block block : blocks) {
            System.out.println(block);
        }

        // Пошук заданого об'єкта в масиві
        Block searchBlock = new Block(3, "Diamond", 5.0, "Blue", "Gem");
        boolean found = Arrays.asList(blocks).contains(searchBlock);
        System.out.println("\nЧи знайдено блок " + searchBlock + ": " + found);
    }
}
