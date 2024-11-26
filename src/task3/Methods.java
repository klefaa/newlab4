package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Methods {

    public <T, P> List<P> applyFunction(List<T> input, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : input) {
            result.add(function.apply(item));
        }
        return result;
    }

    public <T> List<T> filterList(List<T> input, Predicate<T> condition) {
        List<T> result = new ArrayList<>();
        for (T item : input) {
            if (condition.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    // Метод для сокращения списка с ограничением параметра типа
    public <T> T reduceList(List<T> input, BinaryOperator<T> accumulator, T identity) {
        if (input == null || input.isEmpty()) {
            return identity; // Возвращаем identity, если список пуст
        }
        T result = identity;
        for (T item : input) {
            result = accumulator.apply(result, item);
        }
        return result;
    }

    // Универсальный метод для коллекционирования
    public static <T, P> P collect(
            List<T> input,
            Function<List<T>, P> collectorFunction
    ) {
        return collectorFunction.apply(input);
    }
}
