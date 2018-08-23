
class QueueArray<Item> {
  private final int initial_size = 4;
  private int size = 0;
  private Item[] arr;
  private int front;
  private int back;

  // We need this pragma to avoid warnings triggerred by
  // the unsafe cast to Item[].
  @SuppressWarnings("unchecked")
  public QueueArray() {
    arr = (Item[]) new Object[initial_size];
    front = 0;
    back = -1;
  }

  public int size() {
    return size;
  }

  public void enqueue(Item x) {
    if (size == initial_size) {
      Item[] arr2 = (Item[]) new Object[initial_size*2];
      for (int i = 0; i < size; i++) {
        arr2[i] = arr[i];
      }
      arr2[size] = x; 
      arr = arr2;
      size++;
      back++;
    }
    else {
      size++;
      arr[size-1] = x;
      back++;
    }
  }

  public void dequeue() {
    if (size == 0)
      throw new IllegalArgumentException("Queue size must be non-negative");
    front = (front + 1) % arr.length;
    size--;
    if (--size > 0 && size == arr.length / 4) {
      Item[] arr2 = (Item[]) new Object[initial_size / 2];
      for (int i = 0; i < size; i++) {
        arr2[i] = arr[i];
      }
    } 
  }

  public Item getFront() {
  //  if (size == 0)
  //    throw new IllegalArgumentException("Queue size must be non-negative");
    throw new UnsupportedOperationException();
  }

  // Represent the contents of the list as a String
  public String toString() {
    StringBuilder res = new StringBuilder("{");
    if (size > 0) {
      res.append(arr[front].toString());
      for (int i = front+1; i < front+size; ++i) {
        res.append(", ");
        res.append(arr[i].toString());
      }
    }
    res.append("}");
    return res.toString();
  }

  public static void main (String[] args) {
    QueueArray<Integer> q = new QueueArray<Integer>();
    //System.out.println(q.size());
    q.enqueue(4);
    q.enqueue(5);
    q.enqueue(6);
    q.enqueue(10);
    q.enqueue(11);

    System.out.println(q);
    //q.enqueue(5);
    //System.out.println(q.toString());
    //System.out.println(q.getFront());
    q.dequeue();
    System.out.println(q);
    //q.enqueue(2);
    //System.out.println(q.getFront());
  }
}
