package daaa2.algorithms;

import daaa2.metrics.PerformanceTracker;

public interface SortingAlgorithm {
    void sort(int[] a);
    void sort(int[] a, PerformanceTracker tracker);
    String name();
}
