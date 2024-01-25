package collections.test6sort;

import java.util.Comparator;

/**
 * 2024-01-05
 * рефакторинг test5sort:
 * Пробую внести изменения в класс Job, добавив методы сортировки по убыванию в сам класс
 */

public abstract class Job implements Comparable<Job>, Comparator<Job> {
    private String name;

    private int priority;

    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Job{"
                + "name='" + name + '\''
                + ", priority=" + priority
                + '}';
    }

    /**
     * Нужно нажать на красную лампочку в имени класса и выбрать добавить имплементацию метода compareTo
     * В интерфейсе Comparable нужно указать обобщенный тип данных. В нашем случае это сам класс Job.
     * Здесь можно задать поле для сортировки (по приоритету)
     */
    @Override
    public int compareTo(Job another) {
        return Integer.compare(priority, another.priority);
    }
}
