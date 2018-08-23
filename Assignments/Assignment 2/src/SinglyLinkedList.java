//import com.sun.javaws.exceptions.InvalidArgumentException;
public class SinglyLinkedList<Item> implements MyStack<Item>{

  public static int size;
  private Node<Item> first;
  private Node<Item> last;
  private Node<Item> head;

  public SinglyLinkedList() {
    first = null;
    head = null;
    last = null;
    size = 0;
  }

  public Iterator<Item> first() {
    return new Iterator(head);
  }

  public boolean isEmpty() {
    return (size == 0);
  }

  public Item top() {
		if (isEmpty())
			throw new UnsupportedOperationException("Underflow Exception");
		return first.el;
	}

  public Item pop() {
    Item item = first.el;
    first = first.next;
    size--;
    return item;
  }

  public void push(Item e)
  {
    Node<Item> oldFirst = first;
    first = new Node<Item>();
    first.el = e;
    first.next = oldFirst;
    size++;
  }
/**
 * @return the getFirsNode
 */
public Node<Item> getFirst() {
  return first;
}
public Node<Item> getLast() {
  return last;
}

  private static class Node<Item> {
    public Node<Item> next;
    public Item el;
  }

  public static class Iterator<Item> {
    SinglyLinkedList list;
    Node<Item> current;
    Node<Item> prev;

    public Iterator(Node<Item> start) {
      current = start;
      prev = null;
    }

    // public Iterator(Node<Item> start){
    //   current = start;
    // }

    public Item next() {
      if (current.next == null)
        throw new UnsupportedOperationException("End of list reached");
      else {
        prev = current;
        current = current.next;
        return current.el;
      }
    }
    public boolean hasNext() {
      return current != null && current.next != null;
    }
    public void insert(Item e) {
      Node<Item> newNode = new Node<Item>();
      newNode.el = e;
      newNode.next = current.next;
      current.next = newNode;
      size++;
    }

    public void remove() {
      if (current.next == null){
        current = prev;
      }
      else if (current.next.next == null){
        prev.next = current.next;
        current.next = null;
        size--;
      }
    }
  }

  public Item get(int n) {
    if (n<0 || n > size-1){
      throw new IllegalArgumentException("Index ouf of bounds");
    }
    Node<Item> cur = new Node<Item>();
    cur = head.next;
    for(int i=0; i<n; i++){
      cur = cur.next;
    }
    return cur.el;
  }

  public int size() {
    return size;
  }

  // Insert element x at index n in the list
  public void insertAt(int n, Item x) {
    if (n<0 || n>size){
      throw new IllegalArgumentException("Index ouf of bounds");
    }
    Node<Item> newNode = new Node<Item>();
    Node<Item> phantom = new Node<Item>();
    newNode.el = x;

    if(n==0 && size==0){//insert into an empty list
      newNode.next = null;
      first = newNode;
      last = newNode;
      head = phantom;
      head.next = first;
    } else if(n == size){//insert at the end of the list (not empty)
      last.next = newNode;
      newNode.next = null;
      last = newNode;
    } else if (n==0 && size!=0){//insert at the beginning of a non-empty list
      newNode.next = first;
      first = newNode;
      head.next = first;

    } else{//insert in the middle
      Node<Item> cur = first;
      for(int i=0; i<n-1; i++){
        cur = cur.next;
      }
      Node<Item> temp = cur.next;
      cur.next = newNode;
      newNode.next = temp;

    }
    size++;
  }

  // Remove the element at index n from the list
  public void removeAt(int n) {
    if (n<0 || n>=size){
      throw new IllegalArgumentException("Index ouf of bounds");
    }
    Node<Item> cur = first;
    if (n==0){//delete at the begining
      first = first.next;
      head.next = first;
    } else if(n==size-1){//delete at the end
      for(int i=0; i<n-1; i++){
        cur = cur.next;
      }
      cur.next = null;
      last = cur;
    } else{//delete in the middle
      for(int i =0; i<n-1; i++){
        cur = cur.next;
      }
      Node<Item> nodeN = cur.next;
      cur.next = nodeN.next;
      nodeN.el = null;
    }
    size--;
  }

  // Reverse the list
  public void reverse() {
    if (size<=1){
      throw new IllegalArgumentException("Single element array!");
    }
    Node<Item> cur = head.next;
    //Node<Item> nodeNext = null;
    Node<Item> temp = new Node<Item>();
    Node<Item> nodePrev = null;
    while(cur != null){
      // nodeNext = cur.next;
      // cur.next = nodePrev;
      // nodePrev = cur;
      // cur = nodeNext;
      temp.next = cur.next;
      temp.el = cur.el;
      cur.next = nodePrev;
      if (nodePrev == null){
        last = cur;
      }
      nodePrev = cur;
      cur = temp.next;
    }
    first = nodePrev;
    head.next = first;
  }
  


  // Represent the contents of the list as a String
  /*
  public String toString() {
    StringBuilder res = new StringBuilder("{");
    if (size > 0) {
      res.append(firstEl.toString());
      for (int i = 1; i < size; ++i) {
        res.append(", ");
        res.append(el.toString());
      }
    }
    res.append("}");
    return res.toString();
  }*/


  public static void main (String[] args) {
    SinglyLinkedList<Integer> l = new SinglyLinkedList<Integer>();
    //System.out.println(l.size());
    l.insertAt(0,2);
    l.insertAt(1,5);
    //System.out.println(l.size());
    Iterator<Integer> it = l.first();
    //System.out.println(l.size());
    it.next();
    //System.out.println(l.size());
    it.remove();
    System.out.println(l.size());
    //System.out.println(l.get(0));
    //it.insert(3);
    //System.out.println(it.next());



  }
}
