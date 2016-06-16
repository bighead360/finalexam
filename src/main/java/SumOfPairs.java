/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 6/14/16.
 */
public class SumOfPairs {
    static int getSumOfPairs(int[] arr1, int[] arr2) {
        int result = 0;
        for(int i =0; i<arr1.length; i++){
            if(arr1[i]!=0 || arr2[i]!=0){
                result += arr1[i]*arr2[i];

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 0, 0, 3, 5, 0};
        int[] arr2 = {0, 5, 6, 7, 8, 9, 3};

        int result = getSumOfPairs(arr1,arr2);
        System.out.println(result);

    }
}
