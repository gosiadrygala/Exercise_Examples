package QueueAdapter;

public interface StringQueue {
 void enqueue(String element);
 String dequeue();
 String first();
 int size();
 boolean isEmpty();
 int indexOf(String element);
 boolean contains(String element);
}


