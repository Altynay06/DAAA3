package daaa2.cli;

import daaa2.algorithms.SortingAlgorithm;
import daaa2.algorithms.InsertionSort;
import daaa2.metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        SortingAlgorithm[] algs = new SortingAlgorithm[] {
                new InsertionSort() // можно добавить другие реализации
        };

        int[] sizes = new int[] {100, 1000, 5000, 10000}; // можно изменить под мощность ПК
        int repeats = 5;

        try (FileWriter fw = new FileWriter("results_assignment2.csv")) {
            fw.write("algorithm,n,timeNs,comparisons,swaps,accesses,maxDepth\n");
            Random rnd = new Random(12345);

            for (SortingAlgorithm alg : algs) {
                for (int n : sizes) {
                    long sumTime = 0, sumCmp = 0, sumSwaps = 0, sumAcc = 0, sumDepth = 0;

                    for (int r = 0; r < repeats; r++) {
                        int[] base = new int[n];
                        for (int i = 0; i < n; i++) base[i] = rnd.nextInt();

                        PerformanceTracker t = new PerformanceTracker();
                        alg.sort(base, t);

                        sumTime += t.getTimeNs();
                        sumCmp += t.getComparisons();
                        sumSwaps += t.getSwaps();
                        sumAcc += t.getAccesses();
                        sumDepth += t.getMaxDepth();
                    }

                    fw.write(alg.name() + "," + n + "," + (sumTime / repeats) + "," + (sumCmp / repeats)
                            + "," + (sumSwaps / repeats) + "," + (sumAcc / repeats) + "," + (sumDepth / repeats) + "\n");
                    fw.flush();
                    System.out.println("done " + alg.name() + " n=" + n);
                }
            }

            System.out.println("✅ Finished. File created: results_assignment2.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
