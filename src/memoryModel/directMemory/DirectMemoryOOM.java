package memoryModel.directMemory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 模拟直接内存溢出
 *
 * @Auther yusiming
 * @Date 2019/2/26 20:33
 */
public class DirectMemoryOOM {
    private static int BASIC_UNIT = 1024 * 1024;

    /**
     * -Xmx20M -XX:MaxDirectMemorySize=10M
     */
    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(BASIC_UNIT);
        }
    }
}
