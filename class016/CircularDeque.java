package class016;

public class CircularDeque {
    class MyCircularDeque {
        public static int size, limit;
        public static int l, r;
        public static int[] deque = new int[2001];

        public MyCircularDeque(int k) {
            size = 0;
            limit = k;
            l = r = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            if(isEmpty()){
                l=r=0;
            }else{
                l=l==0?limit-1:l-1;
            }
            deque[l]=value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            if(isEmpty()){
                l=r=0;
            }else{
                r=r==limit-1?0:r+1;
            }
            deque[r]=value;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()){
                return false;
            }
            l=l==limit-1?0:l+1;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if(isEmpty()){
                return false;
            }
            r=r==0?limit-1:r-1;
            size--;
            return true;
        }

        public int getFront() {
            return isEmpty()?-1:deque[l];
        }

        public int getRear() {
            return isEmpty()?-1:deque[r];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }

}