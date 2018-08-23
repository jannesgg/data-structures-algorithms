public interface MyStack<Item> {
  boolean isEmpty();
  Item top();
  Item pop();
  void push(Item e);
  //int find();
}