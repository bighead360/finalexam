/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 6/14/16.
 */
public class ExcludeRange{
    private int[] arr;
    ExcludeRange(int[] arr) {
        this.arr = arr;
    }

    public static int[] preprocessPrefix(int[] arr){
        int[] prefix = new int[arr.length];
        if (arr.length>0){
            prefix[0] = arr[0];
        }
        for (int i = 1; i<prefix.length; i++){
            prefix[i] = prefix[i-1] + arr[i];
            //    System.out.println(prefix[i]);
        }

        return prefix;
    }



    int getSumExcludingRange(int startIndex, int endIndex) {

        int[] prefixSum = preprocessPrefix(arr);
        return prefixSum[arr.length-1]-prefixSum[endIndex] + arr[endIndex]
                +prefixSum[startIndex]-arr[startIndex];

    }

    public static void main(String[] args) {
        int[] sample = {1, 3, 2, 4, 5, 6};
        ExcludeRange excludeRange = new ExcludeRange(sample);
        System.out.println(excludeRange.getSumExcludingRange(2,4));

    }
}
