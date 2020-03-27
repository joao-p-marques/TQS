
package pt.ua.jm.tqs;

import java.util.ArrayList;

class TqsStack<T> {

    ArrayList<T> stack;
    int size_limit;

    public TqsStack(int size_limit) {
      this.size_limit = size_limit;
    }

    public TqsStack() {
      this(0);
    }

    public void push(T x) {
      return;
    }

    public T pop() {
      return null;
    } 

    public T peek() {
      return null;
    }

    public int size() {
      return 0;
    }

    public boolean isEmpty() {
      return true;
    }
}
