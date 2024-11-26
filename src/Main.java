import task3.Methods;
import task_1_1.GenericBox;
import task_1_2.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задачу:");
        System.out.println("1 -> Задача 1.1: Обобщенная коробка");
        System.out.println("2 -> Задача 1.2: Хранилище без null");
        System.out.println("3 -> Задача 2.3: Начало отсчета");
        System.out.println("4 -> Задача 3.1: Функция");
        System.out.println("5 -> Задача 3.2: Фильтр");
        System.out.println("6 -> Задача 3.3: Сокращение");
        System.out.print("Введите номер задачи: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> task1();
            case 2 -> task2();
            case 3 -> task2();
            case 4 -> task4();
            case 5 -> task5();
            case 6 -> task6();
            default -> System.out.println("Неверный выбор!");
        }

        scanner.close();
    }

    public static void task1() {
        GenericBox<Integer> box = new GenericBox<>();
        box.put(3); // поместили 3
        System.out.println(box); // передали методу println
        Integer value = box.get(); // извлечение
        System.out.println("Извлеченное значение: " + value);
    }

    public static void task2() {
        //значение null, альтернатива 0
        Storage<Integer> storage1 = new Storage<>(null);
        System.out.println(storage1);
        Integer result1 = storage1.getOrDefault(0);
        System.out.println("Хранилище чисел (null): " + result1); // Ожидаем 0

        //значение 99, альтернатива -1
        Storage<Integer> storage2 = new Storage<>(99);
        System.out.println(storage2);
        Integer result2 = storage2.getOrDefault( -1);
        System.out.println("Хранилище чисел (99): " + result2); // Ожидаем 99

        //значение null, альтернатива "default"
        Storage<String> storage3 = new Storage<>(null);
        System.out.println(storage3);
        String result3 = storage3.getOrDefault( "default");
        System.out.println("Хранилище строк (null): " + result3); // Ожидаем "default"

        //значение "hello", альтернатива "world"
        Storage<String> storage4 = new Storage<>("hello");
        System.out.println(storage4);
        String result4 = storage4.getOrDefault( " nello world");
        System.out.println("Хранилище строк (hello): " + result4); // Ожидаем "hello"
    }

    public static void task3() {

    }

    public static void task4() {
        Methods methods = new Methods();
        System.out.println("Пример 1: Преобразовать строки в их длины");
        List<String> strings = List.of("qwerty", "asdfg", "zx");
        List<Integer> lengths = methods.applyFunction(strings, String::length);
        System.out.println("Длины строк: " + lengths);

        System.out.println("Пример 2: Преобразовать отрицательные числа в положительные");
        List<Integer> numbers = List.of(1, -3, 7);
        List<Integer> absoluteValues = methods.applyFunction(numbers, Math::abs);
        System.out.println("Модули чисел: " + absoluteValues);

        System.out.println("Пример 3: Найти максимальные значения в массивах");

        List<List<Integer>> nestedLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(-1, -2, -3)
        );

        List<Integer> maxValues = methods.applyFunction(
                nestedLists,
                list -> list.stream().max(Integer::compareTo).orElse(null) // Находим максимум в каждом подсписке
        );
        System.out.println("Максимальные значения: " + maxValues);
    }

    public static void task5() {
        Methods methods = new Methods();
        // 1. Фильтрация строк, оставляем строки длиной >= 3 символов
        List<String> strings = List.of("qwerty", "asdfg", "zx");
        List<String> longStrings = methods.filterList(strings, s -> s.length() >= 3);
        System.out.println("Строки с длиной >= 3: " + longStrings);

        // 2. Фильтрация чисел, оставляем только отрицательные
        List<Integer> numbers = List.of(1, -3, 7);
        List<Integer> negativeNumbers = methods.filterList(numbers, n -> n < 0);
        System.out.println("Отрицательные числа: " + negativeNumbers);

        // 3. Фильтрация списков целых чисел, оставляем только списки без положительных чисел
        List<List<Integer>> nestedLists = List.of(
                List.of(-1, -2, -3),
                List.of(4, -5, 6),
                List.of(-7, -8, -9)
        );
        List<List<Integer>> listsWithoutPositives = methods.filterList(
                nestedLists,
                list -> list.stream().allMatch(n -> n <= 0) // Проверяем, что нет положительных чисел
        );
        System.out.println("Списки без положительных чисел: " + listsWithoutPositives);
    }



    public static void task6() {
        Methods methods = new Methods();
        // Пример 1: Формирование одной строки
        List<String> strings = List.of("qwerty", "asdfg", "zx");
        String concatenated = methods.reduceList(strings, String::concat, "");
        System.out.println("Результат конкатенации строк: " + concatenated);

        // Пример 2: Сумма всех чисел
        List<Integer> numbers = List.of(1, -3, 7);
        Integer sum = methods.reduceList(numbers, Integer::sum, 0);
        System.out.println("Сумма чисел: " + sum);

        // Пример 3: Общее количество элементов в списках
        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(List.of(1, 2, 3));
        listOfLists.add(List.of(4, 5));
        listOfLists.add(List.of(6));

        // Используем reduceList для подсчета общего количества элементов
        // метод объединяет массив в конце берем size
        int totalCount = methods.reduceList(
                listOfLists,
                (list1, list2) -> {
                    List<Integer> combined = new ArrayList<>(list1);
                    combined.addAll(list2);
                    return combined;
                },
                new ArrayList<>()
        ).size();

        System.out.println("Общее количество элементов: " + totalCount);

    }


}

