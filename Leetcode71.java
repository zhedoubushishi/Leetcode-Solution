import java.util.Stack;

public class Leetcode71 {

    // pay attention to the use of String.split()
    // 字符串最尾部出现的分隔符可以看成不存在，不影响字符串的分隔
    // e. String = "home/usr/"  -> "home", "usr"
    // 字符串最前端出现的分隔符将分隔出一个空字符串以及剩下的部分的正常分隔
    // e. String = "/home/usr"  -> "", "home", "usr"

    public static String simplifyPath(String path) {

        if (path == null || path.length() == 0) {
            return "";
        }

        String[] splits = path.split("/+");
        Stack<String> stack = new Stack<String>();

        for (String str : splits) {

            if(!str.equals("..") && !str.equals(".") && !str.equals("")){
                stack.push(str);
            }
            if(str.equals("..") && !stack.isEmpty()){
                stack.pop();
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
            res.insert(0, '/');
        }

        if (res.length() == 0) {
            return "/";
        }

        return res.toString();

    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/.c"));
    }
}
