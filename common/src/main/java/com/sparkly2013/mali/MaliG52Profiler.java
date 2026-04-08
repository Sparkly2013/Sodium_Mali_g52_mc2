package com.sparkly2013.mali;

public class MaliG52Profiler {
    private long frameStartTime, frameEndTime;
    private int drawCallCount;
    private long gpuMemoryUsed;
    private float tileUtilization;

    public void startFrameProfile() { frameStartTime = System.nanoTime(); drawCallCount = 0; }
    public void endFrameProfile() { frameEndTime = System.nanoTime(); }
    public long getFrameTime() { return (frameEndTime - frameStartTime) / 1_000_000; }
    public float getFPS() { return 1_000_000_000f / (frameEndTime - frameStartTime); }
    public void recordMemoryUsage(long memoryBytes) { gpuMemoryUsed = memoryBytes; }
    public long getGPUMemoryUsed() { return gpuMemoryUsed; }
    public void incrementDrawCallCount() { drawCallCount++; }
    public int getDrawCallCount() { return drawCallCount; }
    public void recordTileUtilization(float utilization) { tileUtilization = utilization; }
    public float getTileUtilization() { return tileUtilization; }
    public void generatePerformanceReport() {
        System.out.println("=== Mali G52 Performance Report ===");
        System.out.println("Frame Time: " + getFrameTime() + " ms");
        System.out.println("FPS: " + getFPS());
        System.out.println("Draw Calls: " + getDrawCallCount());
        System.out.println("GPU Memory: " + getGPUMemoryUsed() + " bytes");
        System.out.println("Tile Utilization: " + getTileUtilization() + "%");
    }
}
