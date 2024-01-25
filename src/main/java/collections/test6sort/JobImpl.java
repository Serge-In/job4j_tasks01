package collections.test6sort;

import java.util.Comparator;

public class JobImpl extends Job {
    public JobImpl(String name, int priority) {
        super(name, priority);
    }

    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o1.getPriority(), o2.getPriority());
    }

    @Override
    public Comparator<Job> reversed() {
        return super.reversed();
    }
}
