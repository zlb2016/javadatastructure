package stack;
public class teststack {
    public static void main(String[] args) {
        // write your code here
        ArrayStack as=new ArrayStack(3);
        as.push(1);
        as.push(2);
        as.push(3);
        as.display();
        //System.out.println(as.display());
    }
}
