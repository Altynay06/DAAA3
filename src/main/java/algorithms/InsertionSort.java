package algorithms;

public class InsertionSort package daaa2.algorithms;

import daaa2.metrics.PerformanceTracker;
import java.util.Arrays;

public class InsertionSort implements SortingAlgorithm {

    @Override
    public void sort(int[] a) {
        sort(a, new PerformanceTracker());
    }

    @Override
    public void sort(int[] a, PerformanceTracker t) {
        if (a == null || a.length < 2) return;
        t.reset();
        t.start();
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            t.incAccesses();
            int j = i - 1;
            while (j >= 0) {
                t.incComparisons();
                if (a[j] > key) {
                    a[j + 1] = a[j];
                    t.incSwaps();
                    t.incAccesses();
                    j--;
                } else break;
            }
            a[j + 1] = key;
            t.incAccesses();
        }
        t.finish();
    }

    @Override
    public String name() {
        return "InsertionSort";
    }
}
{
}
