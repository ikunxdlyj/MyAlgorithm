package class015;

public class GetMinStack {

    class MinStack {

        public static int[] dataStack=new int[30001];
        public static int[] minStack=new int[30001];
        public static int top1;
        public static int top2;

        public MinStack() {
          top1=0;
          top2=0;
        }

        public void push(int val) {
           if(top1==0){
               dataStack[top1++]=val;
               minStack[top2++]=val;
           }else{
               dataStack[top1++]=val;
               minStack[top2]=Math.min(val,minStack[top2-1]);
               top2++;
           }
        }

        public void pop() {
            top1--;
            top2--;
        }

        public int top() {
            return dataStack[top1-1];
        }

        public int getMin() {
            return minStack[top2-1];
        }
    }
}