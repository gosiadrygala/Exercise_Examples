package QueueAdapter;

import java.util.ArrayList;

public class Queue implements StringQueue
{
  private ArrayList<String> queue;
  private int capacity;

  public Queue(int cap){
    queue = new ArrayList<>();
    capacity = cap;
  }

  @Override public void enqueue(String element){
    if(queue.size() == capacity){
      throw new IllegalStateException();
    }
    else if(element == null){
      throw new IllegalArgumentException();
    }
    queue.add(element);
  }

  @Override public String dequeue(){
    if(queue.size() == 0){
      throw new IllegalStateException();
    }
    return queue.remove(0);
  }

  @Override public String first(){
    if(queue.size() == 0){
      throw new IllegalStateException();
    }
    return queue.get(0);
  }

  @Override public int size() {
    return queue.size();
  }

  @Override public boolean isEmpty() {
    return queue.isEmpty();
  }

  @Override public int indexOf(String element){
    if(element == null){
      return -1;
    }
    for(String arrayElement : queue){
      if(arrayElement.equals(element)){
        return queue.indexOf(arrayElement);
      }
    }
    return -1;
  }

  @Override public boolean contains(String element){
    return queue.contains(element);
  }

  @Override public String toString(){
    String s = "{";
    for(String arrayElement : queue){
      if(!(queue.indexOf(arrayElement) == queue.size() - 1))
      {
        s += arrayElement + ", ";
      }
      else
      s += arrayElement;
    }
    s += "}";
    return s;
  }
}
