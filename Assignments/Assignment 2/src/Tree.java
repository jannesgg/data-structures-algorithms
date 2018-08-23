// import java.util.ArrayDeque;
// import java.util.Stack;
// import java.util.Iterator;
// import java.util.ArrayList;
import java.util.*;

class Tree<Item extends Comparable<Item>> {
  // If the tree is empty, root is a null reference.
  protected Node<Item> root;

  // A node of a tree contains a label, and optionally
  // references to the roots of its left and right subtrees,
  // which might be null if the subtrees are empty.
  protected static class Node<Item> {
    public Node<Item> left;
    public Node<Item> right;
    public Item el;
  }

  public int size() {
    throw new UnsupportedOperationException();
  }

  // // This method constructs the following
  // // example tree with 5 in the root:
  // //
  // //      __5__
  // //     /     \
  // //    /       \
  // //   1         8
  // //    \       / \
  // //     2     1   3
  // //          / \
  // //          5 7
  // public static Tree<Integer> exampleTree() {
  //   Node<Integer> t = new Node<Integer> ();
  //   t.el = 5;
  //   Node<Integer> t1 = new Node<Integer> ();
  //   t.left = t1;
  //   t1.el = 1;
  //   Node<Integer> t2 = new Node<Integer> ();
  //   t.right = t2;
  //   t2.el = 8;
  //   Node<Integer> t12 = new Node<Integer> ();
  //   t1.right = t12;
  //   t12.el = 2;
  //   Node<Integer> t21 = new Node<Integer> ();
  //   t2.left = t21;
  //   t21.el = 1;
  //   Node<Integer> t22 = new Node<Integer> ();
  //   t2.right = t22;
  //   t22.el = 3;
  //   Node<Integer> t211 = new Node<Integer> ();
  //   t21.left = t211;
  //   t211.el = 5;
  //   Node<Integer> t212 = new Node<Integer> ();
  //   t21.right = t212;
  //   t212.el = 7;
  //
  //   Tree<Integer> res = new Tree<Integer>();
  //   res.root = t;
  //   return res;
  // }



  // This method constructs the following
  // example tree with 5 in the root:
  //
  //      __5__
  //     /     \
  //    /       \
  //   1         9
  //    \       / \
  //     2     7   11
  //          / \
  //          6 8
  public static Tree<Integer> exampleTree() {
    Node<Integer> t = new Node<Integer> ();
    t.el = 5;
    Node<Integer> t1 = new Node<Integer> ();
    t.left = t1;
    t1.el = 1;
    Node<Integer> t2 = new Node<Integer> ();
    t.right = t2;
    t2.el = 9;
    Node<Integer> t12 = new Node<Integer> ();
    t1.right = t12;
    t12.el = 2;
    Node<Integer> t21 = new Node<Integer> ();
    t2.left = t21;
    t21.el = 7;
    Node<Integer> t22 = new Node<Integer> ();
    t2.right = t22;
    t22.el = 11;
    Node<Integer> t211 = new Node<Integer> ();
    t21.left = t211;
    t211.el = 6;
    Node<Integer> t212 = new Node<Integer> ();
    t21.right = t212;
    t212.el = 8;

    Tree<Integer> res = new Tree<Integer>();
    res.root = t;
    return res;
  }

  // Return the height of the tree
  public int height() {
    throw new UnsupportedOperationException();
  }

  // Return the label of the leftmost node of a tree
  public Item leftMost() {
    throw new UnsupportedOperationException();
  }

  // Replace the tree with its mirror image
  public void mirror() {
    throw new UnsupportedOperationException();
  }

  // Print the nodes of the tree in depth-first order

  public void printDFS(Node<Item> curr_node) {

      if (curr_node == null)
          return;

      // Node value
      System.out.println(curr_node.el);

      // Recurse on left sub-tree
      printDFS(curr_node.left);

      // Recurse on the right sub-tree
      printDFS(curr_node.right);

  }


  public void printDFS() {
    printDFS(root);
  }



  // Here is how to create a generic static method
  //private static <Item> int doSomething(Node<Item> n) {
  //}

  // Print the nodes of the tree in breadth-first order
  public void printBFS() {

    ArrayDeque<Node<Item>> q = new ArrayDeque<Node<Item>>();
    Node<Item> curr = root;
    q.add(root);
    while (!q.isEmpty()) {
      curr = q.removeFirst();
      System.out.println(curr.el);
      if (curr.left != null)
        q.add(curr.left);
      if (curr.right != null)
        q.add(curr.right);
    }
  }

  // //Build a  BStree our of an array in depth-first order
  // public static <Item extends Comparable<Item>> Tree<Item> BuildDFS(Iterable<Item> preOder) {
  //   Node<Item> root = null;
  //   Iterator itr = preOder.iterator();
  //   Stack<Node<Item>> container = new Stack<Node<Item>>();
  //
  //   // first element of preOrder array is the root
  //   root.el = itr.next();
  //   // push the root in the stack
  //   container.push(root);
  //
  //   // loop for the rest
  //   while (itr.hasNext()){
  //     Item newVal = itr.next();
  //     //Item top = container.peek().el;
  //     //create the new node
  //     Node<Item> newNode = new Node<Item>();
  //     newNode.el = newVal;
  //
  //     Node<Item> temp = null;
  //     //keep popping if top < new
  //     while(container.peek()!=null && newVal.compareTo(container.peek().el) > 0){
  //       temp = container.pop();
  //     }
  //
  //     if (temp!= null){ // temp is no longer null, newNode value is bigger than original top of stack
  //       temp.right = newNode;
  //       container.push(newNode);
  //     } else{// temp is null, newNode smaller than top of Stack
  //       container.peek().left = newNode;
  //       container.push(newNode);
  //     }
  //
  //   }
  //
  //   Tree<Item> aTree = new Tree<Item>();
  //   aTree.root = root;
  //   return aTree;
  // }


  //Build a BStree out of an array in depth-first order
  public static <Item extends Comparable<Item>> Tree<Item> BuildDFS(ArrayList<Item> preOrder) {

    Tree<Item> aTree = new Tree<Item>();
    Node<Item> rootNode = new Node<Item>();
    
    Node<Item> current = new Node<Item>();
    aTree.root = rootNode;
    Stack<Node<Item>> container = new Stack<Node<Item>>();

    // first element of preOrder array is the root
    rootNode.el = preOrder.get(0);
    // push the root in the stack
    container.push(rootNode);

    // loop for the rest
    
    for (int i = 1; i<preOrder.size(); i++){
      Item newVal = preOrder.get(i);
      //Item top = container.peek().el;
      //create the new node
      Node<Item> newNode = new Node<Item>();
      newNode.el = newVal;

      Node<Item> temp = null;
      Node<Item> parent = rootNode;

      //keep popping if top < new
      while(!container.empty() && newVal.compareTo(container.peek().el) > 0){
        temp = container.pop();
      }
      
      if (temp!= null){ 
        if (parent.left == null){
          parent.left = newNode;
          container.push(newNode);
        }
        else if (parent.left != null && preOrder.get(i+1).compareTo(newVal) > 0) {
          parent = temp;
          parent.right = newNode;
          container.push(newNode);
        }
      }
      else {
        parent.right = newNode;
        container.push(newNode);
      }
  }
    return aTree;
  }

  // Return the n-th element in DFS order.
  // Throw an exception if index out of range.
  public Item nthDFS(int n) {
      Stack<Node<Item>> st = new Stack<Node<Item>>();
      Node<Item> curr_node = root;
      int c = 1;
      st.push(root);
      while (!st.isEmpty()){
        if (c <= n) {
          curr_node = st.pop();
          c++;
          if (curr_node.right != null)
            st.push(curr_node.right);
          if (curr_node.left != null)
            st.push(curr_node.left);
          continue;
        }
        else {
          return curr_node.el;
        }
      }
      throw new IndexOutOfBoundsException();
   }

  // Check if the tree is a binary search tree
  public boolean isBST() {
    throw new UnsupportedOperationException();
  }

  // Check if item i exists in the binary search tree
  public boolean findBST(Item i) {
    throw new UnsupportedOperationException();
  }

  // Remove i from a binary search tree
  public void removeBST(Item i) {
    root = remove(i, root);
  }

  public Node<Item> remove(Item i, Node<Item> tree){
    if (tree == null){
      throw new IllegalArgumentException("Tree is empty");
    }

    if (tree.el.compareTo(i) < 0){
      tree.right = remove(i, tree.right);
    } else if(tree.el.compareTo(i) > 0){
      tree.left = remove(i, tree.left);
    } else{//find the element
      if(tree.right == null && tree.left == null){
        tree = null;
      } else if(tree.right == null && tree.left != null){
        tree = tree.left;
      } else if(tree.right != null && tree.left == null){
        tree = tree.right;
      } else {//two children
        Item replace = findMin(tree.right).el;
        tree.el = replace;
        tree.right = removeMin(tree.right);
      }
    }
    return tree;
  }

  public void removeMin(){
    root = removeMin(root);
  }

  public Node<Item> removeMin(Node<Item> tree){
    //
    if (tree == null){
      throw new IllegalArgumentException("no item in the tree");
    } else if(tree.left != null){
      tree.left = removeMin(tree.left);
      //return tree;
    } else {
      tree = tree.right;
      //return tree;
    }
    return tree;
  }

  public Item findMin(){
    return findMin(root).el;
  }
  public Node<Item> findMin(Node<Item> node){
    if (node.left == null){
      return node;
    }
    return findMin(node.left);
  }



  // Insert i into a binary search tree
  public void insertBST(Item i) {
    insert(i,root);
  }

  public Node<Item> insert(Item i, Node<Item> tree){
    Node<Item> newNode = new Node<Item>();
    newNode.el = i;

    if (tree == null){
      tree = newNode;
    } else if (tree.el.compareTo(i) < 0){//go on the right sub tree
      tree.right = insert(i,tree.right);
    } else if (tree.el.compareTo(i) >= 0){//go on the left sub tree
                                          //take care of repeating element also
      tree.left = insert(i,tree.left);
    }

    return tree;
  }


  public static void main(String[] args) {
    Tree<Integer> t = exampleTree();
    //t.printBFS();
    //t.printDFS();
    //System.out.println(t.nthDFS(7));
    //System.out.println(t.size());
    ArrayList<Integer> preOrder = new ArrayList<>();
    preOrder.add(1);
    preOrder.add(2);
    preOrder.add(4);
    preOrder.add(5);
    preOrder.add(3);
    // Iterator itr = preOrder.iterator();
    // while(itr.hasNext()){
    //   System.out.println(itr.next());
    // }
    Tree<Integer> tree = BuildDFS(preOrder);
    System.out.println(tree.root.el);
    System.out.println(tree.root.left.el);
    System.out.println(tree.root.left.left.el);
    System.out.println(tree.root.right.el);
    System.out.println(tree.root.left.right.el);
    // tree.printDFS();
    // tree.printBFS();

    //Tree<Integer> aBT = exampleTree();
    //System.out.println(aBT.root.el);

    // System.out.println("Test insert()");
    // aBT.insertBST(5);
    // System.out.println(aBT.root.left.right.right.el);
    // aBT.insertBST(10);
    // System.out.println(aBT.root.right.right.left.el);
    //
    //System.out.println("Test remove()");
    // original tree
    //      __5__
    //     /     \
    //    /       \
    //   1         9
    //    \       / \
    //     2     7   11
    //          / \
    //          6 8

    //no children
    //System.out.println(aBT.root.left.right.el);
    //aBT.removeBST(2);
    //System.out.println(aBT.root.left.right);

    // original tree removed 2
    //      __5__
    //     /     \
    //    /       \
    //   1         9
    //           / \
    //          7   11
    //          / \
    //          6 8

    //two children
    // System.out.println(aBT.root.el);
    // aBT.removeBST(5);
    // System.out.println(aBT.root.el);
    // System.out.println(aBT.root.right.left.left);

    // original removed 2 and 5
    //      __6__
    //     /     \
    //    /       \
    //   1         9
    //    \       / \
    //          7   11
    //          / \
    //            8
    //1 children
    // System.out.println(aBT.root.right.left.el);
    // aBT.removeBST(7);
    // System.out.println(aBT.root.right.left.el);






  }

}
