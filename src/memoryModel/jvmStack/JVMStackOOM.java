package memoryModel.jvmStack;

/**
 * 模拟虚拟机栈OutOfMemoryError异常
 * 使用递归函数的形式是无法造成OOM异常的，
 * 但是我们可以通过不断创建线程调用方法来产生OOM异常
 * 使用的JVM参数：-Xss2M
 *
 * @Auther yusiming
 * @Date 2019/2/25 21:44
 */
public class JVMStackOOM {
    /**
     * 给这个函数一个死循环来保证线程不会自动销毁
     */
    private static void dontStop() {
        while (true) {

        }
    }

    /**
     * 注意：
     * 下面这段程序是比较危险的，有可能会造成系统假死。
     * 因为java的线程是直接映射到操作系统的内核线程上的。
     * <p>
     * 运行结果：
     * Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
     */
    public static void main(String[] args) {
        while (true) {
            Thread thread = new Thread(JVMStackOOM::dontStop);
            // 被忘了这里调用start方法
            thread.start();
        }
    }
}
