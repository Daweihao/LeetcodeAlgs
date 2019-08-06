 class MyCircularQueue {

     int[] queue;
     int tail;
     int head;
     int size;
     /** Initialize your data structure here. Set the size of the queue to be k. */
     public MyCircularQueue(int k) {
         int[] queue = new int[k];
         int head = -1;
         int tail = -1;
         int size = 0;
     }

     /** Insert an element into the circular queue. Return true if the operation is successful. */
     public boolean enQueue(int value) {
         if (size == queue.length)
             return false;
         tail = (tail + 1) % queue.length;
         if(size == 0)
             head = tail;
         queue[tail] = value;
         size++;
         return true;
     }

     /** Delete an element from the circular queue. Return true if the operation is successful. */
     public boolean deQueue() {
         if (size == 0)
             return false;
         head = (head + 1) % queue.length;
         size--;
         return true;

     }

     /** Get the front item from the queue. */
     public int Front() {
         if(size == 0)
             return -1;
         return queue[head];
     }

     /** Get the last item from the queue. */
     public int Rear() {
         if(size == 0){
             return -1;
         }
         return queue[tail];
     }

     /** Checks whether the circular queue is empty or not. */
     public boolean isEmpty() {
         return size == 0;
     }

     /** Checks whether the circular queue is full or not. */
     public boolean isFull() {
         return size == this.queue.length;
     }
 }

