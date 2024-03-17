package monad;

import java.util.function.Function;

/**
 * 2024-03-17
 * https://ru.wikipedia.org/wiki/Монада_(программирование)
 * Мона́да — особый тип данных в функциональных языках программирования,
 * для которого возможно задать императивную последовательность выполнения некоторых операций над хранимыми значениями[1].
 * Так могла бы выглядеть монада в императивном языке Java и одна из её реализаций, контейнер Maybe:
 */
interface Monad<T> {
    <U> Monad<U> bind(Function<T, Monad<U>> f);
}

class Maybe<T> implements Monad<T> {

    private final T val;

    public Maybe(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    @Override
    public <U> Monad<U> bind(Function<T, Monad<U>> f) {
        if (val == null) {
            return new Maybe<U>(null);
        }
        return f.apply(val);
    }

    public static void main(String[] args) {
        Maybe<Integer> x = new Maybe<>(5);
        Monad<Integer> y = x
                .bind(v -> new Maybe<>(v + 1))
                .bind(v -> new Maybe<>(v * 2));
        System.out.println(((Maybe<Integer>) y).getVal());
    }
}