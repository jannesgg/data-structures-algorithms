public class Splice {

    public static int findSplice(int[] arr, int low, int hi){
        // Base case
        if (low == hi){
            return arr[low];
        }
        int mid = (low+hi)/2;
        return Math.min(findSplice(arr, low, mid), findSplice(arr, mid+1, hi));
    }

    public static void main(String[] args){

        int[] array = {1,2,3,4};
        System.out.println(findSplice(array, 0, array.length-1));

    }

}
