package gc.EdenSpaceTest;

/**
 * 在大多数情况下，对象优先分配在Eden空间中
 *
 * @Auther yusiming
 * @Date 2019/3/2 16:44
 */
public class AllocationTest {
    private static final int BASIC_UNIT = 1024 * 1024;

    /**
     * 参数：
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * 限制堆大小为20M，新生代10M（Eden:Survivor = 8:1），老年代10M，收集GC日志参数，
     * <p>
     * [GC (Allocation Failure) [DefNew: 7308K->574K(9216K), 0.0063755 secs] 7308K->6718K(19456K), 0.0064438 secs]
     * [Times: user=0.00 sys=0.02, real=0.02 secs]
     * Heap
     * def new generation   total 9216K, used 4753K [0x05400000, 0x05e00000, 0x05e00000)
     * eden space 8192K,  51% used [0x05400000, 0x05814938, 0x05c00000)
     * from space 1024K,  56% used [0x05d00000, 0x05d8faf0, 0x05e00000)
     * to   space 1024K,   0% used [0x05c00000, 0x05c00000, 0x05d00000)
     * tenured generation   total 10240K, used 6144K [0x05e00000, 0x06800000, 0x06800000)
     * the space 10240K,  60% used [0x05e00000, 0x06400030, 0x06400200, 0x06800000)
     * Metaspace       used 126K, capacity 2280K, committed 2368K, reserved 4480K
     * <p>
     * 可以看出：
     * 新生代中Eden空间被使用了4M
     * 老年代由于分配担保使用6M
     */
    public static void main(String[] args) {
        byte[] arr1 = new byte[BASIC_UNIT * 2];
        byte[] arr2 = new byte[BASIC_UNIT * 2];
        byte[] arr3 = new byte[BASIC_UNIT * 2];
        // 当分配arr4空间时，Eden空间已经不够用了，就会发起一次Minor GC
        // 同时由于所有的对象都是存活的，Survivor已经放不下了
        // 此时通过分配担保机制直接将对象分转移到老年代中
        // 然后再到Eden中分配arr4就成功了
        byte[] arr4 = new byte[BASIC_UNIT * 4];
    }
}
