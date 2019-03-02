package gc;

/**
 * 长期存活的对象将进入老年代
 *
 * @Auther yusiming
 * @Date 2019/3/2 17:44
 */
public class OldObjectAllocationTest {
    private static final int BASIC_UNIT = 1024 * 1024;

    /**
     * 参数：
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:MaxTenuringThreshold=1
     * 年龄为1时晋升到老年代
     * -XX:MaxTenuringThreshold=10
     * 年龄为15时晋升到老年代
     */
    public static void main(String[] args) {
        byte[] arr1 = new byte[BASIC_UNIT / 4];
        byte[] arr2 = new byte[4 * BASIC_UNIT];
        // 分配arr3时由于剩下的空间不足将发生一次Minor GC
        // 但是由于arr1可以较小可以放入另一块Survivor区中，所以只有arr2被转移到了老年代
        // arr3GC之后就存储在Eden空间中了
        // Heap
        //  def new generation   total 9216K, used 5008K
        //   eden space 8192K,  51% used
        //   from space 1024K,  81% used
        //   to   space 1024K,   0% used
        //  tenured generation   total 10240K, used 4096K [0x05600000, 0x06000000, 0x06000000)
        //    the space 10240K,  40% used [0x05600000, 0x05a00010, 0x05a00200, 0x06000000)
        byte[] arr3 = new byte[4 * BASIC_UNIT];
        arr3 = null;
        // 这里又会发生一次GC，因为Eden空间已经无法容纳下arr4了，
        // 而由于此时arr1年龄为1，将会被转移到老年代中，而arr2由于分配担保机制，也会被转移到老年代
        // arr3会被GC 所以新生代中就只存放了arr4
        byte[] arr4 = new byte[4 * BASIC_UNIT];
        // [GC (Allocation Failure) [DefNew: 4926K->0K(9216K), 0.0015618 secs] 9022K->4923K(19456K), 0.0015951 secs]
        // [Times: user=0.00 sys=0.00, real=0.00 secs]
        // Heap
        //  def new generation   total 9216K, used 4178K
        //   eden space 8192K,  51% used
        //   from space 1024K,   0% used
        //   to   space 1024K,   0% used
        //  tenured generation   total 10240K, used 4923K
        //    the space 10240K,  48% used [0x05200000, 0x056ceda8, 0x056cee00, 0x05c00000)
    }
}
