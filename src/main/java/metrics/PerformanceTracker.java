package daaa2.metrics;

public class PerformanceTracker {
    private long comparisons;
    private long swaps;
    private long accesses;
    private int currentDepth;
    private int maxDepth;
    private long startNs;
    private long timeNs;
    private long memoryBytes;

    public void reset() {
        comparisons = 0;
        swaps = 0;
        accesses = 0;
        currentDepth = 0;
        maxDepth = 0;
        timeNs = 0;
        memoryBytes = 0;
    }

    public void start() {
        System.gc();
        startNs = System.nanoTime();
    }

    public void finish() {
        timeNs = System.nanoTime() - startNs;
        memoryBytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public void incComparisons() { comparisons++; }
    public void incSwaps() { swaps++; }
    public void incAccesses() { accesses++; }

    public void enter() { currentDepth++; if (currentDepth > maxDepth) maxDepth = currentDepth; }
    public void exit() { currentDepth--; }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getAccesses() { return accesses; }
    public int getMaxDepth() { return maxDepth; }
    public long getTimeNs() { return timeNs; }
    public long getMemoryBytes() { return memoryBytes; }

    public String toCsvRow(String algorithm, int n) {
        return String.format("%s,%d,%d,%d,%d,%d,%d",
                algorithm, n, timeNs, comparisons, swaps, accesses, maxDepth);
    }
}
