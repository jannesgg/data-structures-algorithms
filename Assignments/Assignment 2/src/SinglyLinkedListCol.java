//import com.sun.javaws.exceptions.InvalidArgumentException;

class SinglyLinkedListCol<Item> {
  private int size;
  public Node<Item> first;
  public Node<Item> last;

  public SinglyLinkedListCol() {
    first = null;
    size = 0;
  }

  private static class Node<Item> {
    public Node<Item> next;
    public Item el;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public void clear() {
      first = null;
      last = null;
  }

  public boolean contains(Item x) {
      Iterator<Item> it = first();
      boolean found = false;
      while (it.next() != null){
          it.next();
          if (it.current.el == x){
            found = true;
          }
      }
      return found;
  }

  public boolean add(Item x) {
    Node<Item> newNode = new Node<Item>();  
    if (x == null) {
          return false;
      }
      else {
        newNode.el = x;
        last.next = newNode;
        newNode.next = null;
        return true;
      }
  }

  public boolean remove_full(Item x){
      if (x == null || contains(x) == false) {
        return false;
      }
      else {
          int counter = 0;
          Iterator<Item> it = first();
          while (it.next() != null){
            it.next();
            counter++;
            if (it.current.el == x){
              removeAt(counter-1);
              return true;
            }
        }
        return false;
      }
  }


  public static class Iterator<Item> {
    SinglyLinkedListCol list;
    Node<Item> current;
    
    public Iterator(Node<Item> start){
      current = start;
    }

    public Item next() {
      if (current.next == null)
        throw new UnsupportedOperationException("End of list reached");
      else {
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
      if (current == null) { 
        list.first = newNode;
        list.last = newNode;
        current = newNode;
      }
      else if(current == list.last){
        list.last.next = newNode;
        list.last = newNode;
        current = newNode;
      }
      else {
        newNode.next = current.next;
        current.next = newNode;
      }
      list.size++;
    }
    public void remove() {
      if (current.next == null){
        throw new UnsupportedOperationException("End of list");
      }
      else if (current.next != list.last ){
        current.next = current.next.next;
        list.size--;
      }
      else {
        current.next = null;
        list.last = current;
        list.size--;
      }
    }
  }
  
  public int size() {
    return size;
  }

  public Item get(int n) {
    if (n<0 || n > size -1){
      throw new IllegalArgumentException("Index ouf of bounds");
    }
    Node<Item> cur = first;
    for(int i=0; i<n; i++){
      cur = cur.next;
    }
    return cur.el;
  }

  // Insert element x at index n in the list
  public void insertAt(int n, Item x) {
    if (n<0 || n>size){
      throw new IllegalArgumentException("Index ouf of bounds");
    }
    Node<Item> newNode = new Node<Item>();
    newNode.el = x;

    if(n==0 && size==0){//insert into an empty list
      newNode.next = null;
      first = newNode;
      last = newNode;
    } else if(n == size){//insert at the end of the list (not empty)
      last.next = newNode;
      newNode.next = null;
      last = newNode;
    } else if (n==0 && size!=0){//insert at the beginning of a non-empty list
      newNode.next = first;
      first = newNode;
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
      cur.el = null;
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
    Node<Item> cur = first;
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
      nodePrev = cur;
      cur = temp.next;
    }
    first = nodePrev;
  }
  
  public Iterator<Item> first() {
    return new Iterator(first);
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
    SinglyLinkedListCol<Integer> l = new SinglyLinkedListCol<Integer>();
    System.out.println(l.size());
    l.insertAt(0,2);
    l.insertAt(1,5);
    Iterator<Integer> it = l.first();
    System.out.println(it.next());
  }
}
