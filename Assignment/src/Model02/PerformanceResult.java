package Model02;

public class PerformanceResult {
    public final String algorithm;
    public final int n;
    public final double timeMs;

    public PerformanceResult(String algorithm, int n, double timeMs) {
        this.algorithm = algorithm;
        this.n = n;
        this.timeMs = timeMs;
    }
}
