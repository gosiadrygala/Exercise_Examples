package QueueAdapter;

public class TestQueue {

  public static void main(String[] args) {
    StringQueue stringQueue = new Queue(20);
    stringQueue.enqueue("Element to delete");
    System.out.println(stringQueue.contains("Element to delete")); //expected true
    stringQueue.enqueue("This is a test");
    stringQueue.enqueue("Hey");

    System.out.println(stringQueue.dequeue()); // expected Element to delete
    System.out.println(stringQueue.indexOf("Element to delete")); //expected -1

    System.out.println(stringQueue.size()); //expected 2
    System.out.println(stringQueue);
  }
}



