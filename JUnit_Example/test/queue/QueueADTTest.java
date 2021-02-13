package queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueADTTest {

  private QueueADT<Integer> integerQueue;

  @BeforeEach
  public void setUp(){
    integerQueue = new BoundedArrayQueueA<>(4);
  }

  /*
  Test method for checking if the element can be added to the queue
  and if it is actually in the queue.
   */
  @Test
  public void addElementToTheQueue(){
    //act
    integerQueue.enqueue(1);
    //assert
    assertTrue(integerQueue.contains(1));
  }


  /*
  Test method for checking if multiple elements can be added to the queue
  and if they are actually in the queue.
   */
  @Test
  public void addMultipleElementsToTheQueue(){
    //act
    integerQueue.enqueue(1);
    integerQueue.enqueue(2);
    integerQueue.enqueue(3);

    //assert
    assertTrue(integerQueue.contains(1));
    assertTrue(integerQueue.contains(2));
    assertTrue(integerQueue.contains(3));
  }


  /*
  Test method checking whether if the null is inserted, the method will
  return IllegalArgumentException.
   */
  @Test
  public void addingNullToTheQueue(){
    assertThrows(IllegalArgumentException.class, () -> integerQueue.enqueue(null));
  }

  /*
  Test method checking whether if capacity of the queue is reached the method will
  throw IllegalStateException.
   */
  @Test
  public void addingTheElementToTheFullQueue(){
    //act
    integerQueue.enqueue(1);
    integerQueue.enqueue(2);
    integerQueue.enqueue(3);
    integerQueue.enqueue(4);
    //assert
    assertThrows(IllegalStateException.class, ()-> integerQueue.enqueue(5));
  }

  /*
  Test method to check whether the element is added at the end
  of the queue.
   */
  @Test
  public void addingTheElementAtTheEndOfTheQueue(){
    //act
    integerQueue.enqueue(1);
    integerQueue.enqueue(2);
    integerQueue.enqueue(3);
    integerQueue.enqueue(4);
    //assert
   assertEquals(3, integerQueue.indexOf(4));
  }

  /*
  Test method for checking whether the method will return true if the element
  is in the queue.
   */
  @Test
  public void containsTheElementThatWasAddedToTheQueue(){
    //act
    integerQueue.enqueue(4);
    //assert
    assertTrue(integerQueue.contains(4));
  }

  /*
  Test method for checking whether the method will return false if the element
  is not in the queue.
   */
  @Test
  public void containsTheElementThatIsNotInTheQueue(){
    //act
    integerQueue.enqueue(4);
    //assert
    assertFalse(integerQueue.contains(3));
  }

  /*
  Test method for checking whether the method will return false if the element
  provided is null.
   */
  @Test
  public void containsTheNullElement(){
    //assert
    assertFalse(integerQueue.contains(null));
  }
}