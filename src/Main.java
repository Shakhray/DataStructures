import sh.ExpandedStack;
import sh.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<String>  stack1 = new Stack<>();
        println(stack1.size());
        Stack<String>  stack2 = new Stack<>();

        Stack<String>  stack3 = new Stack<>();
        Stack<Float>   stack4 = new Stack<>();
        Stack<Integer> stack5 = new Stack<>();
        Stack<Integer> stack6 = null;// = new sh.Stack<>();
        ExpandedStack<Integer> stack7 = new ExpandedStack<>();// = new sh.Stack<>();
//        println(stack1.isEmpty());
//        println(stack1.toString());

        stack1.push("1");
        stack1.push("2");
        stack1.push("3");
        stack1.push("4");
        stack1.push("5");
        stack1.push("6");

        stack2.push("1");
        stack2.push("3");
        stack2.push("3");
        stack2.push("4");
        stack2.push("5");
        stack2.push("6");

        stack3.push("1");
        stack3.push("3");
        stack3.push("3");
        stack3.push("4");
        stack3.push("5");
        stack3.push("6");

        stack4.push(1f);
        stack4.push(3f);
        stack4.push(3f);
        stack4.push(4f);
        stack4.push(5f);
        stack4.push(6f);

        stack5.push(1);
        stack5.push(3);
        stack5.push(3);
        stack5.push(4);
        stack5.push(5);
        stack5.push(6);

        stack7.push(null);
        stack7.push(null);
        stack7.push(3);
        stack7.push(null);
        stack7.push(null);
        stack7.push(null);

        println("stack1 == stack2 : " + (stack1.equals(stack2)));
        println("stack2 == stack3 : " + (stack2.equals(stack3)));
        println("stack3 == stack4 : " + (stack3.equals(stack4)));
        println("stack4 == stack5 : " + (stack4.equals(stack5)));

        try {
            stack6 = stack5.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        println("stack5 == stack6 : " + (stack5.equals(stack6)));
        println(stack1.toString());
        println(stack1.isEmpty());
        for(String str : stack1) {
            if (str != null)
            println(str);
            else println("!!!");
        }
        println(stack1.isEmpty());
        println(stack1.size());
        println(stack1.peek());
        println(stack1.size());
        println(stack1.pop());
        println(stack1.size());
        println("------------------------------------------------");
        println(stack1.size());
        println("------------------------------------------------");
        println(stack7.get(0));
        println(stack7.get(5));
        println("------------------------------------------------");
        println(stack7.contains(3));
        println(stack7.contains(null));
        println("------------------------------------------------");
        println(stack7.indexOf(null));
        println(stack7.indexOf(3));
        println(stack7.indexOf(5));

        Object[] arr = stack7.toArray();
        for (Object anArr : arr) {
            print(anArr + " ");
        }

        println(stack7.toArray());
//        println(stack7.get(-1));
//        println(stack7.get(6));
//        for(int i = 0; i < 6; i++) {
//            println(stack1.pop());
//        }
    }

    private static void println(Object value) {
        System.out.println(value == null ? null : value.toString());
    }

    private static void print(Object value) {
        System.out.print(value == null ? null : value.toString());
    }
}
