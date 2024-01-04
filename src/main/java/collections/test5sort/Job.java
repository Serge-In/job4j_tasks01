package collections.test5sort;

/**
 * 2024-01-04
 * 0. Сортировка [#10096]
 * Давайте рассмотрим модель данных Job.
 * Наша задача написать для него сортировку по возрастанию по полю priority, а так же сделать сортировку по имени по возрастанию.
 * Для этого мы в классе Job реализуем интерфейс java.util.Comparable<Job>
 */

public class Job implements Comparable<Job> {
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
