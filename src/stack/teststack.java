package stack;
public class teststack {
    public static void main(String[] args) {
        // write your code here
        ArrayStack as=new ArrayStack(3);
        as.push(1);//入栈
        as.push(2);
        as.push(3);
        as.peek();//取栈顶元素
        as.pop();//出栈
        as.display();//展示栈内元素
        //System.out.println(as.display());
    }
}
