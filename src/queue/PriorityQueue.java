package queue;

public class PriorityQueue {
    private long[] a;
    private int size;
    private int nItems;//元素个数

    public PriorityQueue(int maxsize){
        size=maxsize;
        nItems=0;
        a=new long[maxsize];
    }

    public void insert(long value){
        if(isFull()){
            System.out.println("队列已满！");
            return ;
        }
        int j;
        if(nItems==0){//如果队列为空
            a[nItems++]=value;
        }else{//将数组中的数字依照下标按照从大到小排列
            for(j=nItems-1;j>=0;j--){
                if (value>a[j]){
                    a[j+1]=a[j];
                }else{
                    break;
                }
            }
            a[j+1]=value;
            nItems++;
        }
    }

    public long remove(){
        if (isEmpty()){
            System.out.println("队列为空！");
            return 0;
        }
        return a[--nItems];
    }

    public long peekMin(){
        return a[nItems-1];
    }

    public boolean isFull(){
        return (nItems==size);
    }

    public boolean isEmpty(){
        return (nItems==0);
    }

    public int size(){
        return nItems;
    }

    public void display(){
        for(int i=nItems-1;i>=0;i--){
            System.out.println(a[i]+"");
        }
        System.out.println("");
    }
}
