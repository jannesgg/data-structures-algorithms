import java.lang.reflect.Array;
import java.math.BigInteger;

class Array2 {
    private final int max_elements = 200;
    private int size = 0;
    private int[] arr;

    public Array2(int n) {
        if (n < 0 || n > max_elements)
            throw new IllegalArgumentException("Array size must be non-negative");
        arr = new int[max_elements];
        size = n;
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

    // Reverse the array
    public void reverse() {
        for (int i = 0; i < size()/2; i++){
            int temp = get(i);
            set(i, get(size-i-1));
            set((size-i-1),temp);
        }
    }


    // Find the maximum odd number in the array. Return -1
    // if there are no odd numbers.
    public int maxOdd() {
        int num_odds = 0;
        int index=0;
        for (int j = 0; j < size(); j++) {
            if (get(j) % 2 != 0) {
                num_odds++;
                index = j;
                break;
            }}
        if (num_odds==0) {
            return 0;
        }
        else {
            int largest_odd = get(index);
            for (int k = index + 1; k < size(); k++) {
                if ((get(k) % 2 != 0) && (get(k) > largest_odd)) {
                    largest_odd = get(k); }}
            return largest_odd;
        }
    }


    // Remove the element of index i from the array.
    public void remove(int i) {
        for (int j =i;i < size;i++){set(i,get(i+1));}
        size--;
    }


    // Remove the element of index i from the array.
    // This method may change the order of the other
    // elements of the array.
    public void remove2(int i) {
        set(i, get(size()-1));
        size--;
    }


    // Return the index of the first occurrence of x in the array,
    // or -1 if x does not occur.
    public int find(int x) {
        for (int i = 0;i < size();i++){
            if (x == get(i)){
                System.out.print("\n" + "Item found at position ");
                return i;
            }
        }System.out.print("Could not find item");
        return -1;
    }


    // Find the length of the longest palindrome that is
    // a contiguous subsequence of the array. A palindrome
    // is a word of the form ABCBA (length 5) or ABCCBA
    // (length 6).
    public int maxPalindrome() {
        int longest = 0;
        boolean flag = false;
        //outer 2 loops to create all sub-arrays
        for (int i = 0; i < size(); i++) {
            for (int m = 0; m < size(); m++) {
                int start;

                //inner loop to test whether the array that starts form i till m is a Palindrome
                //they should meet in the center, so (i + m) / 2
                for (start = i; start <= (i + m) /2; start++) {
                    if (get(start) == get(m-start+i)) {
                        flag = true;
                    } else {
                        flag = false;
                        break;

                    }
                }

                if (flag == true && longest < (m - i + 1)) {
                    longest = m - i + 1;
                }
            }
        }

        return longest;
    }






    // Return the maximum sum of all contiguous subarrays of the array.

    public static int auxmeth(int [] array){

        int mid = (array.length) / 2;
        int hi = array.length-1;
        int lo = 0;
        int maxiLeft = 0;
        int sum = 0;
        int maxiRight = 0;

        for (int i =mid; i >= lo ;i--){
            sum += array[i];
            if (sum > maxiLeft) {
                maxiLeft = sum;
            }
            sum = 0;
            for (int j =mid+1; j <= hi ;j++){
                sum += array[j];
                if (sum > maxiRight) {
                    maxiRight = sum;
                }
            }

        }return (maxiLeft + maxiRight);}



    public static int maxInterval (int[] array,int lo, int hi) {
        if (hi - lo == 1) return array[lo]; // if length of array is  1  stop
        int mid = (hi +1) / 2;

        System.out.println(lo);
        System.out.println(mid);
        System.out.println(hi);

        int loRes = maxInterval (array, lo, mid);
        int hiRes = maxInterval (array, mid +1 , hi);
        int maxBorder = auxmeth(array);



        return Math.max(loRes, Math.max(hiRes, maxBorder));
    }


    // Return the index of the lowest element of the array,
    // assuming that the array contains a cyclic shift of
    // a non-decreasing sequence.






 public int findSplice(){

     return findSplice(0,size - 1);
  }
 
   public int findSplice(int low, int hi) {
       int mid = (low + hi) / 2;

       if (low == hi) {
           return 0;
       }

       if (get(mid) > get(mid + 1)) {
           return mid + 1;
       } else {
           if (get(mid) > get(hi)) {
               return findSplice(mid + 1, hi);
           } else {

               return findSplice(low, mid);
           }
       }
   }



    // Return the median value of an array.
    public int median() {
        int med = (0 + size - 1) / 2;
        return median(0, size - 1, med);
    }
    public int median(int begin, int end,int med){


        int split;
        int left;
        if (begin == end) {
            return get(begin);
        }
        split = partition(arr, begin, end);

        //position of the pivot after partition
        left = split - begin;

        if (left == med){//pivot is the answer
            return get(split);
        } else if (left < med) {//look on the right side
            return median(split + 1, end, med - left - 1);
        }   else {
            return median(begin,split-1, med);
        }
    }



    public static BigInteger fib(int n) {
        if (n <= 1) return BigInteger.ONE;
        return fib(n-1).add(fib(n-2));
    }

    private static int partition(int[] array, int begin, int end) {
        // array[begin] will be the pivot element
        int pivot = array[begin];
        int lookingAt;
        int boundary = begin + 1;//among what we've looked at, the boundary between bigger/smaller

        for (lookingAt = begin + 1; lookingAt <= end;lookingAt++){
            if(array[lookingAt]<pivot){
                swap(array, lookingAt,boundary);
                boundary++;
            }
        }

        swap(array,begin,boundary-1);
        return boundary-1;
    }

    private static void swap(int[] array, int i, int j) {
        int x = array[i];
        array[i] = array[j];
        array[j] = x;
    }

    public static void main(String[] args){
        Array2 a = new Array2(3);
        a.set(0, 1);
        a.set(1, 0);
        a.set(2, 0);
        System.out.println(a.findSplice());
    }

}
