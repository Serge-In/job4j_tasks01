package collections.test5sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 1),
                new Job("Fix bugs", 3),
                new Job("Reboot server", 2)
        );
        System.out.println(jobs); //[Job{name='Impl task', priority=1}, Job{name='Fix bugs', priority=3}, Job{name='Reboot server', priority=2}]

        //сортировка по убыванию по полю приоритет
        Collections.sort(jobs, Collections.reverseOrder());
        System.out.println(jobs); //[Job{name='Fix bugs', priority=3}, Job{name='Reboot server', priority=2}, Job{name='Impl task', priority=1}]
        //сортировка по возрастанию по полю приоритет
        Collections.sort(jobs);
        System.out.println(jobs); //[Job{name='Impl task', priority=1}, Job{name='Reboot server', priority=2}, Job{name='Fix bugs', priority=3}]

        /**
         * Теперь давайте создадим класс ru.job4j.collection.SortByNameJob, который будет реализовывать интерфейс java.util.Comparator.
         * Теперь можно добавить сортировку по имени через компаратор.
         */
        //сортировка по возрастанию по полю название
        Collections.sort(jobs, new SortByNameJob());
        System.out.println(jobs); //[Job{name='Fix bugs', priority=3}, Job{name='Impl task', priority=1}, Job{name='Reboot server', priority=2}]

        //сортировка по убыванию по полю название
        Collections.sort(jobs, new SortDescByNameJob());
        System.out.println(jobs); //[Job{name='Reboot server', priority=2}, Job{name='Impl task', priority=1}, Job{name='Fix bugs', priority=3}]
    }
}