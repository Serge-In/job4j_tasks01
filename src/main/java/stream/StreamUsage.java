package stream;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 2024-03-16
 * 1. Stream API [#58166]
 * пример из урока
 */
public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Task{"
                    + "name='" + name + '\''
                    + ", spent=" + spent
                    + '}';
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 1),
                new Task("Task #2", 2),
                new Task("Bug #3", 3),
                new Task("Bug #4", 4),
                new Task("Task #5", 5),
                new Task("Bug #6", 6)
        );
        Consumer<? super Object> prn = System.out::println;
        tasks.forEach(prn);

        Consumer<Task> prn2 = obj -> System.out.println(obj.getName());
        tasks.forEach(prn2);

        Consumer<Task> prn3 = obj -> System.out.println("streamAPI " + obj.getName());
        tasks.stream().forEach(prn3);

        Consumer<Task> prn4 = obj -> System.out.println("ParallelStreamAPI " + obj.getName());
        tasks.stream().forEach(prn4);
//
//        List<Task> bugs = tasks.stream().filter(
//                task -> task.name.contains("Bug")
//        ).collect(Collectors.toList());
//        bugs.forEach(System.out::println);
    }
}
