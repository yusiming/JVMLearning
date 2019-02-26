package memoryModel.javaMethodArea.constantPool;

/**
 * 测试String类的intern方法
 *
 * @Auther yusiming
 * @Date 2019/2/26 20:12
 */
public class StringInternMethodTest {
    public static void main(String[] args) {
        String s = new String(new char[]{'a', 'b', 'c'});
        // true
        System.out.println(s == s.intern());

        String s1 = new String(new char[]{'j', 'a', 'v', 'a'});
        // false 字符串java已经出现过了，返回的是常量池中的地址
        System.out.println(s1 == s1.intern());

        String s2 = new String("efg");
        // false
        System.out.println(s2 == s2.intern());
    }
}
