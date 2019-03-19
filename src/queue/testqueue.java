package queue;

public class testqueue {
    public static void main(String args[]){
        RoundQueue rq=new RoundQueue(3);
        rq.insert(1);//入队
        rq.insert(2);
        rq.insert(3);
        rq.remove();//出队
        rq.insert(4);//入队
        rq.peek();
        rq.display();
    }
}
