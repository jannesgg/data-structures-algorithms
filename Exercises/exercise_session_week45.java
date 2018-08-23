public void RemoveAt(int n) {
    if (n<0 || n > size) {
        throw new IllegalArgumentException;
    }
    if (n=0) {
        first = first.next;
        first.prev = null;
    }
    else {
        node<Item> current = first;
        for (int i = 0; i < n - 1; i++) {
            if (n == size -1) {last = current}
            current = current.next;
            current.next = current.next.next;
            current.next.prev = current; 
            size--;
        }
    }
}





public static class Iterator<Item>{
    DoublyLinkedList list;
    node<item> current = list.first;
    boolean prevcalled;
    boolean endPassed;

    public Iterator(DoublyLinkedList<Item> c){
        list = c; 
    }

    public item next() {
        if(current.next = null) {endPassed = true};
        else {
            current = current.next;}
        prevcalled = False;
        return current.el;
        }
    
    public boolean hasNext(){
        return current != null && current.next != null;
    }

    public Item prev(){
        if(endPassed){endPassed = False}
        else {
            current = current.prev;
        }
        prevcalled = True:
        return current.el;
    }
    
    public boolean hasPrev() {
        return current != null && current.prev != null;
    }

    public void insert(Item e){
        node<Item> newNode = new Node<Item>;
        newNode.el = e; 
        if (current = null){
            list.first = newNode;
            list.last = newNode;
            current = newNode;
        }
        else if(endPassed){
            list.last.next = newNode;
            newNode.prev = list.last;
            list.last = newNode;
            current = newNode
        }
        else {
            Node<Item> prev = current.prev;
            if (prev != null) {
                prev.next = newNode;
            }
            else {
                list.first = newNode;
            }
            newNode.prev = prev; 
            newNode.next = current; 
            current.prev = newNode;
        }
        size++;
    }

    public void remove() {
        Node<Item> toRemove;
        if (endPassed) {
            list.last = list.last.prev;
            if (list.last == null) {list.first = null;}
            else {list.last.next = null;}
                current = list.last;
        }
        else {if (prevcalled){
            toRemove = current;
            else {toRemove = current.prev;}
        }
        if (toRemove.prev = null) {
            list.first = toRemove.next;
        }
        else {
            toRemove.prev.next = toRemove.next;}
        if (toRemove.next = null){
            list.last = toRemove.prev;
            endPassed = True;
            current = list.last;
            toRemove.next.prev = toRemove.prev;
            current = toRemove.next;
        }
        size--;
    }


}