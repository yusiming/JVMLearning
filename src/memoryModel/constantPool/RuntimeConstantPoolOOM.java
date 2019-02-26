package memoryModel.constantPool;

import java.util.ArrayList;

/**
 * 模拟方法区内存溢出
 *
 * @Auther yusiming
 * @Date 2019/2/26 19:57
 */
public class RuntimeConstantPoolOOM {
    /**
     * 在jdk1.7之前，下面这段代码会产生常量池溢出
     * java -XX:PermSize=10M -XX:MaxPermSize=10M RuntimeConstantPoolOOM
     * 在jck1.8 时上面的参数已经被废弃了，
     * 如果我们限制了堆的大小，反而会抛出java.lang.OutOfMemoryError: Java heap space
     */
    public static void main(String[] args) {
        int i = 0;
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            list.add(String.valueOf(1).intern());
        }
    }
}
