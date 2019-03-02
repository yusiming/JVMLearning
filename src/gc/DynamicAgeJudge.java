package gc;

/**
 * 动态对象年龄判断
 *
 * @Auther yusiming
 * @Date 2019/3/2 18:22
 */
public class DynamicAgeJudge {
    private static final int BASIC_UNIT = 1024 * 1024;

    /**
     * 参数：
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * <p>
     * [GC (Allocation Failure) [DefNew: 5772K->1024K(9216K), 0.0056033 secs] 5772K->5182K(19456K), 0.0056641 secs]
     * [Times: user=0.01 sys=0.00, real=0.02 secs]
     * [GC (Allocation Failure) [DefNew: 5120K->0K(9216K), 0.0011697 secs] 9278K->5182K(19456K), 0.0012001 secs]
     * [Times: user=0.00 sys=0.00, real=0.00 secs]
     * Heap
     * def new generation   total 9216K, used 4178K
     * eden space 8192K,  51% used
     * from space 1024K,   0% used
     * to   space 1024K,   0% used
     * tenured generation   total 10240K, used 5182K
     * the space 10240K,  50% used
     * <p>
     * arr1和arr2被转移到老年代了
     */
    public static void main(String[] args) {
        byte[] arr1 = new byte[BASIC_UNIT / 4];
        byte[] arr2 = new byte[BASIC_UNIT / 4];
        byte[] arr3 = new byte[4 * BASIC_UNIT];
        byte[] arr4 = new byte[4 * BASIC_UNIT];
        arr4 = null;
        byte[] arr5 = new byte[4 * BASIC_UNIT];
    }
}
