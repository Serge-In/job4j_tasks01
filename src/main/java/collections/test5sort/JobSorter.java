package collections.test5sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        System.out.println(jobs); //[Job{name='Fix bugs', priority=4}, Job{name='Impl task', priority=2}, Job{name='Reboot server', priority=1}]
        Collections.sort(jobs);
        System.out.println(jobs); //[Job{name='Reboot server', priority=1}, Job{name='Impl task', priority=2}, Job{name='Fix bugs', priority=4}]
        Collections.sort(jobs, Collections.reverseOrder());
        System.out.println(jobs); //[Job{name='Fix bugs', priority=4}, Job{name='Impl task', priority=2}, Job{name='Reboot server', priority=1}]
    }
}