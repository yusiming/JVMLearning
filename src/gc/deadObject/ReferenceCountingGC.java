package gc.deadObject;

/**
 * 下面这段代码表示了使用“引用计数算法”来判断对象是否存活的一个严重的问题：
 * 对象之间循环引用
 *
 * @Auther yusiming
 * @Date 2019/2/27 19:36
 */
public class ReferenceCountingGC {
    private Object instance = null;

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        // objB的引用计数加1
        objA.instance = objB;
        // objA的引用计数加1
        objB.instance = objA;
        // 但是将它们赋予null值之后，就再也无法使用了,GC会收回这两个对象
        objA = null;
        objB = null;
    }
}
