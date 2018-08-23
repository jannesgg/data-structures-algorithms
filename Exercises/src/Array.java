class Array {
  private final int max_elements = 20;
  private int size = 0;
  private int[] arr;

  public Array(int n) {
    if (n < 0 || n > max_elements)
      throw new IllegalArgumentException("Array size must be non-negative");
    arr = new int[max_elements];
  }

  public int size() {
    return size;
  }

  // Set the i-th element to x
  // We are not checking whether the index is
  // in bounds, because dereferencing the array
  // element does it for us.
  public void set(int i, int x) {
    arr[i] = x;
  }

  // Get the i-th element
  // Again, we are not checking if the index
  // is in bounds.
  public int get(int i) {
    return arr[i];
  }

  // Insert x at position i increasing the size
  // of the array by one. If the position is
  // 0, the element is inserted as the first one. If it is
  // equal to size(), then the element is inserted as the
  // last one.
  public void insert(int i, int x) {
    if (i < 0 || i > size())
      throw new IllegalArgumentException("Invalid index");
    if (size() == max_elements)
      throw new IllegalArgumentException("Cannot grow array");
    // Increase the size and insert the element

    if (i == size()) {
        size++;
        set(i, x);
    }
    else if (i < size()) {
        size++;
        int j = 0;
        for (j = size(); j > i; j--) {
            set(j, get(j-1));
        }
        set(i, x);
    }

  }

  /*
  The time complexity is around O(n) since in the worst case, we need to move all of the elements by 1
  to insert an element in the beginning.
   */

  // Return true if the array is sorted, and false otherwise.
  public boolean isSorted() {
    int j = 0;
    for (j = 0; j < size(); j++) {
        if (get(j) < get(j+1)) {
            return false;
        }
    }
    return true;
  }

  // Return the index of the first occurrence of x in the array,
  // or -1 if x does not occur.
  public int find(int x) {
    int j = 0;
    for (j=0; j<=size(); j++) {
        if (get(j) == x) {
            return j;

        }
    }
    return -1;
  }

  // Find the length of the longest non-decreasing
  // continuous subsequence of the array.
  public int maxNonDecreasing() {
      int longest_run = 0;
      int run = 1;
      int index = 0;
      do {
          for (int j = index; j<size();j++) {
              if (get(j) <= get(j+1)) {
                  run++;
                  index++;
              }
              else {
                  run = 1;
              }
              if (run > longest_run) {
                  longest_run = run;
              }
          }
          return longest_run;
      } while (index < size());
  }

  // Find the index of the first subarray
  // of the array that is equal to array b.
  // If such a subarray does not exist, return -1.
  public int subArrayIndex(Array b) {
      if (find(b.get(0)) == -1) {
          return -1;
      } else {
          int count = 0;
          for (int j = find(b.get(0)); j < b.size()+find(b.get(0)); j++) {
              if (get(j) == b.get(j)) {
                  count++;
              } else {
                  return -1;
              }
          }
          if (count == b.size()) {
              return find(b.get(0));
          }
          else {
              return -1;
          }
      }
  }

  public static void main(String[] args)
  {
      Array ar = new Array(10);
        ar.insert(0,2);
        ar.insert(1,5);
        ar.insert(2,4);
        ar.insert(3,6);
        ar.insert(4, 7);
        ar.insert(5, 10);
        ar.insert(6, 9);
        ar.insert(7, 9);
        ar.insert(8,9);
        ar.insert(9,9);
        Array b = new Array(2);
        b.insert(0,2);
        b.insert(1,5);
        b.insert(2,4);
        //System.out.println(b.size());
        //System.out.println(ar.maxNonDecreasing());
        System.out.println(ar.subArrayIndex(b));

      }
}




