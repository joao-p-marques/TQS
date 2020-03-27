
package pt.ua.jm.tqs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.NoSuchElementException;

class TqsStackTest {

  TqsStack<Integer> stack;

  @BeforeEach
  void reset_stack() {
    this.stack = new TqsStack<>();
  }

  @Test
  @DisplayName("Stack is empty on construction")
  void test_empty_construction() { 
    Assertions.assertTrue(this.stack.isEmpty());
  }

  @Test
  @DisplayName("Stack has size 0 on construction")
  void test_size_construction() { 
    Assertions.assertEquals(this.stack.size(), 0);
  }

  @Test
  @DisplayName("After n pushes to an empty stack, n > 0, the stack is not empty and its size is n")
  void test_pushes() { 
    int n = 3;
    for(int i = 0; i < n; i++) {
      this.stack.push(i);
    }
    Assertions.assertFalse(this.stack.isEmpty());
    Assertions.assertEquals(this.stack.size(), n);
  }

  @Test
  @DisplayName("If one pushes x then pops, the value popped is x")
  void test_push_pop() { 
    int n = 3;
    this.stack.push(n);
    int popped = this.stack.pop();
    Assertions.assertEquals(popped, n);
  }

  @Test
  @DisplayName("If one pushes x then peeks, the value returned is x, but the size stays the same")
  void test_push_peek() { 
    int n = 3;
    int prev_size = this.stack.size();

    this.stack.push(n);
    int peeked = this.stack.peek();

    Assertions.assertEquals(peeked, n);
    Assertions.assertEquals(prev_size, this.stack.size());
  }

  @Test
  @DisplayName("If the size is n, then after n pops, the stack is empty and has a size 0")
  void test_empty() { 
    int prev_size = this.stack.size();

    for(int i = 0; i < prev_size; i++) {
      this.stack.pop();
    }

    Assertions.assertTrue(this.stack.isEmpty());
    Assertions.assertEquals(0, this.stack.size());
  }

  @Test
  @DisplayName("Popping from an empty stack does throw a NoSuchElementException")
  void test_empty_exception() { 
    Assertions.assertThrows(NoSuchElementException.class, () -> this.stack.pop());
  }

  @Test
  @DisplayName("Peeking into an empty stack does throw a NoSuchElementException")
  void test_empty_exception_peek() { 
    Assertions.assertThrows(NoSuchElementException.class, () -> this.stack.peek());
  }

  @Test
  @DisplayName("For bounded stacks only, pushing onto a full stack does throw an IllegalStateException")
  void test_bounded_exception() { 
    this.stack = new TqsStack<Integer>(3);
    for(int i = this.stack.size(); i < 3; i++) {
      this.stack.push(i);
    }
    Assertions.assertThrows(IllegalStateException.class, () -> this.stack.push(0));
  }

}
