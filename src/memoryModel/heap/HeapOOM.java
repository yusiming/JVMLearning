package memoryModel.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟Java堆OutOfMemoryError异常
 * 使用的参数：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 限制堆的大小为20m，并且在发生OOMError时，Dump出当前内存堆的转储快照以便分析。
 *
 * @Auther yusiming
 * @Date 2019/2/25 22:17
 */
public class HeapOOM {
    /**
     * 运行结果：
     * java.lang.OutOfMemoryError: Java heap space
     * Dumping heap to java_pid2752.hprof ...
     * Heap dump file created [28153862 bytes in 0.488 secs]
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     */
    public static void main(String[] args) {
        List<HeapOOM> list = new ArrayList<>();
        while (true) {
            list.add(new HeapOOM());
        }
    }
}
