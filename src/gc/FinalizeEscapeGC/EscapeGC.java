package gc.FinalizeEscapeGC;

/**
 * 模拟对象的“自救”
 *
 * @Auther yusiming
 * @Date 2019/2/27 20:20
 */
public class EscapeGC {
    private static EscapeGC SAVE_HOOK = null;

    /**
     * 运行结果：
     * 拯救成功
     * 死透了！
     */
    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new EscapeGC();
        SAVE_HOOK = null;
        // 手动开启垃圾回收
        System.gc();
        // 等一会finalize方法
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            System.out.println("拯救成功");
        } else {
            System.out.println("死透了！");
        }

        System.gc();
        Thread.sleep(500);
        SAVE_HOOK = null;
        if (SAVE_HOOK != null) {
            System.out.println("拯救成功");
        } else {
            System.out.println("死透了！");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        SAVE_HOOK = this;
    }
}
