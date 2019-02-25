package memoryModel;

/**
 * 模拟JVM栈溢出错误，使用如下方法只会抛出StackOverFlowError
 * 使用的运行参数：-Xss128k  限制java虚拟机栈的大小为128k，以便更快抛出异常
 *
 * @Auther yusiming
 * @Date 2019/2/25 21:25
 */
public class JVMStackOOM {
    private int length = 1;

    private void fun() {
        length++;
        fun();
    }

    /**
     * 运行结果：
     * Exception in thread "main" java.lang.StackOverflowError
     */
    public static void main(String[] args) {
        JVMStackOOM jvmStackOOM = new JVMStackOOM();
        jvmStackOOM.fun();
    }
}
