import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

class ModError {
  public static void main(String[] args) {
    List<Integer> numbers = new LinkedList<Integer>();
    for(int i = 0; i < 100; ++i) numbers.add(i);
    Iterator<Integer> iter = numbers.iterator();
    while (iter.hasNext()){
      Integer num = iter.next();
      if (num % 10 == 0)
        iter.remove();
    }
    System.out.println(numbers.toString());
  }
}
