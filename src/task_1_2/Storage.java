package task_1_2;

public class Storage<T> {
    private final T item;

    // Конструктор хранилища
    public Storage(T item) {
        this.item = item;
    }

    // Встроенный метод для получения значения с альтернативой
    public T getOrDefault(T defaultValue) {
        return item != null ? item : defaultValue;
    }

    @Override
    public String toString() {
        return "Storage содержит: " + (item == null ? "null" : item.toString());
    }
}
