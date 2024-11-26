package task_1_1;

public class GenericBox<T> {
    private T item;

    public void put(T item) {
        if (this.item != null) {
            throw new IllegalStateException("Коробка уже занята!");
        }
        this.item = item;
    }

    public T get() {
        T temp = this.item;
        this.item = null; // Обнуляем после извлечения
        return temp;
    }

    public boolean isEmpty() {
        return this.item == null;
    }

    @Override
    public String toString() {
        return "GenericBox содержит: " + (item == null ? "пусто" : item.toString());
    }

}
