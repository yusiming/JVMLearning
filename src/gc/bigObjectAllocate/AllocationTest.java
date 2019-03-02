package gc.bigObjectAllocate;

/**
 * 大对象直接进入老年代
 *
 * @Auther yusiming
 * @Date 2019/3/2 17:22
 */
public class AllocationTest {
    private static final int BASIC_UNIT = 1024 * 1024;

    /**
     * 参数：
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     * <p>
     * 大于3M的对象直接到老年代分配空间
     * <p>
     * Heap
     * def new generation   total 9216K, used 1328K [0x04a00000, 0x05400000, 0x05400000)
     * eden space 8192K,  16% used [0x04a00000, 0x04b4c0f0, 0x05200000)
     * from space 1024K,   0% used [0x05200000, 0x05200000, 0x05300000)
     * to   space 1024K,   0% used [0x05300000, 0x05300000, 0x05400000)
     * tenured generation   total 10240K, used 4096K [0x05400000, 0x05e00000, 0x05e00000)
     * the space 10240K,  40% used [0x05400000, 0x05800010, 0x05800200, 0x05e00000)
     * Metaspace       used 125K, capacity 2280K, committed 2368K, reserved 4480K
     */
    public static void main(String[] args) {
        byte[] arr = new byte[BASIC_UNIT * 4];
    }
}
