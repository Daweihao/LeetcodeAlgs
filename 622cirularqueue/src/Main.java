public class Main {
    public static void main(String[] args) {
        MyCircularQueue cq = new MyCircularQueue(5);
        boolean param1 = cq.isEmpty();
        boolean param2 = cq.enQueue(5);
        boolean param5 = cq.enQueue(4);
        boolean param6 = cq.enQueue(3);
        boolean param7 = cq.enQueue(2);
        boolean param8 = cq.enQueue(1);
        int param3 = cq.Front();
        int param4 = cq.Rear();
        System.out.println(param3);
    }
}
