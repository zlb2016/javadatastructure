package queue;
import java.lang.reflect.Array;
public class MinHeapPriorityQueue<T extends Comparable<T>> {
    private T[] heap;
    private int heapLength;
    //用于提供堆的操作
    private MinHeap<T> minHeap=new MinHeap<T>();
    public MinHeapPriorityQueue(T[] a,int heapLength){
        super();
        minHeap.buildHeap(a,heapLength);
        this.heap=a;
        this.heapLength=heapLength;
    }
    /**
     * 返回队列中的最小元素是很简单的，因为最小优先队列是基于小根堆实现的，
     * 所以只需要返回数组的第一个元素即可
     */
    public T heapMinimum(){
        return  this.heap[0];
    }

    /**
     * 不仅需要返回队列中最小的元素，还需要删除该元素
     * 然后把数组的最后一个元素放到数组的第一个位置，堆的长度减1，
     * 对堆的第一个元素调用小根堆的heapify方法，使第一个元素满足小根堆的性质。
     * @return
     */
    public T heapExtractMin(){
        if(this.heapLength<1){
            return null;
        }
        T min=heap[0];
        heap[0]=heap[heapLength-1];
        heapLength--;
        minHeap.heapify(this.heap,0,heapLength);
        return min;
    }

    /**
     * 把数组中下标为i的元素的值设为key，
     * key必须小于等于该处原来的值，
     * 该结点的值发生变化后可能破坏小根堆的性质，
     * 所以需要上移该处的值，保持小根堆性质。
     * @param i
     * @param key
     */
    public void heapDecreaseKey(int i,T key){
        if(key.compareTo(this.heap[i])>0){
            try{
                throw new Exception("the key is more than heap[i]");
            }catch (Exception e){
                e.printStackTrace();
                return;
            }
        }
        this.heap[i]=key;
        /**向上移动heap[i]的位置
         *移动的条件是heap[i]不是根节点，并且heap[i]比双亲结点小
         */
        while(i>0&&heap[i].compareTo(this.heap[minHeap.parent(i)])<0){
            T temp=this.heap[i];
            this.heap[i] = this.heap[minHeap.parent(i)];
            this.heap[minHeap.parent(i)]=temp;
            i=minHeap.parent(i);
        }

    }

    /**
     * 插入元素key，首先，堆的长度增加1，然后把key放在堆的最后，
     * 对这个元素调用heapDecreaseKey(int i, T key)方法，使之满足堆的性质即可
     * @param key
     */
    public void minHeapInsert(T key){
        // 如果保存堆的数组已经被填满
        if (this.heapLength == this.heap.length) {
            // 新建一个更大的数组，用于保存旧数组中的元素
            @SuppressWarnings("unchecked")
            T[] temp = (T[]) Array.newInstance(this.heap.getClass().getComponentType(),
                    2 * this.heapLength);
            // 把旧数组中的元素复制进新数组中
            for(int i = 1; i < this.heapLength; i++){
                temp[i] = this.heap[i];
            }
            this.heap = temp;
        }
        this.heap[heapLength] = key;
        this.heapDecreaseKey(heapLength, key);
        this.heapLength++;
    }

    public T[] getHeap(){
        return heap;
    }

    public void setHeap(T[] Heap){
        this.heap=heap;
    }

    public int getHeapLength() {
        return heapLength;
    }

    public void setHeapLength(int heapLength) {
        this.heapLength = heapLength;
    }

    public void printHeap() {
        for(int i = 1; i <= this.heapLength; i++){
            System.out.println(this.heap[i]);
        }
    }
}
