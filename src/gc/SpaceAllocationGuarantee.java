package gc;

/**
 * 空间分配担保机制
 *
 * @Auther yusiming
 * @Date 2019/3/2 18:42
 */
public class SpaceAllocationGuarantee {
    private static final int BASIC_UNIT = 1024 * 1024;

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:-HandlePromotionFailure
     * <p>
     * [GC (Allocation Failure) [DefNew: 7308K->574K(9216K), 0.0049152 secs] 7308K->4670K(19456K), 0.0049789 secs]
     * [Times: user=0.00 sys=0.01, real=0.00 secs]
     * [GC (Allocation Failure) [DefNew: 6878K->0K(9216K), 0.0012564 secs] 10974K->4667K(19456K), 0.0012858 secs]
     * [Times: user=0.00 sys=0.00, real=0.00 secs]
     * Heap
     * def new generation   total 9216K, used 2212K
     * eden space 8192K,  27% used
     * from space 1024K,   0% used
     * to   space 1024K,   0% used
     * tenured generation   total 10240K, used 4667K
     * the space 10240K,  45% used
     */
    public static void main(String[] args) {
        byte[] arr1 = new byte[2 * BASIC_UNIT];
        byte[] arr2 = new byte[2 * BASIC_UNIT];
        byte[] arr3 = new byte[2 * BASIC_UNIT];
        arr1 = null;
        byte[] arr4 = new byte[2 * BASIC_UNIT];
        byte[] arr5 = new byte[2 * BASIC_UNIT];
        byte[] arr6 = new byte[2 * BASIC_UNIT];
        arr4 = null;
        arr5 = null;
        arr6 = null;
        byte[] arr7 = new byte[4 * BASIC_UNIT];
    }
}
