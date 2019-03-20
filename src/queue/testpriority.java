package queue;

public class testpriority {
    public static void main(String args[]){
        PriorityQueue pq=new PriorityQueue(3);
        pq.insert(4);//入队列
        pq.insert(3);
        pq.insert(5);
        //pq.insert(1);
        pq.display();
        pq.peekMin();
        pq.remove();//出队列
        pq.remove();
        pq.remove();
        pq.insert(1);
        pq.display();
    }
}
