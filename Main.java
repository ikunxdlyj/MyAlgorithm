import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        char[] chars = {'a','b','c','d','e'};
        List<List<Character>> ans = generate(chars);
        System.out.println("所有可能的出栈顺序，共 " + ans.size() + " 种：");
        for(int i = 0; i < ans.size(); i++) {
            System.out.println((i+1) + "\t: " + ans.get(i).toString());
        }
    }

    public static List<List<Character>> generate(char[] chars) {
        List<List<Character>> ans = new ArrayList<>();
        generateSequences(0, new Stack<Character>(), new ArrayList<Character>(), ans, chars);
        return ans;
    }

    /**
     * 生成所有可能的出栈顺序
     * @param index 当前要处理的字符索引
     * @param stack 模拟栈
     * @param list 当前出栈序列
     * @param res 所有结果的集合
     * @param chars 输入字符数组
     */
    public static void generateSequences(int index, Stack<Character> stack,
                                         List<Character> list,
                                         List<List<Character>> res,
                                         char[] chars) {
        // 所有字符都已处理且栈为空，得到一个完整的出栈序列
        if (index == chars.length && stack.isEmpty()) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 选择1：如果栈不为空，可以出栈
        if (!stack.isEmpty()) {
            char popped = stack.pop();
            list.add(popped);
            generateSequences(index, stack, list, res, chars);
            // 回溯
            list.removeLast();
            stack.push(popped);
        }

        // 选择2：如果还有字符未入栈，可以入栈
        if (index < chars.length) {
            stack.push(chars[index]);
            generateSequences(index + 1, stack, list, res, chars);
            // 回溯
            stack.pop();
        }
    }
}