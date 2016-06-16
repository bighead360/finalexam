import java.util.HashMap;
import java.util.Map;

/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 6/14/16.
 */
public class WaysToDecrypt {

    static int numberOfWaysToDecrypt(String digitsStr) {
        int length =digitsStr.length();




        return numberOfWays(digitsStr,length);
    }


    static int numberOfWays(String digitsStr,int length){

        if(length==1||length==0){
            return 1;
        }


        int count =0;


        if(digitsStr.charAt(length-2)=='0'&&digitsStr.charAt(length-3)>'2'){
            count = 0;
            return count;
        }

        if(digitsStr.charAt(length-2)=='0'&&digitsStr.charAt(length-3)<='2'){

            return count+1;
        }



        if(digitsStr.charAt(length-1)>'0'&&digitsStr.charAt(length-2)>'0') {
            count = numberOfWays(digitsStr, length - 1);

        }

        if ((digitsStr.charAt(length - 2) < '2' ||
                (digitsStr.charAt(length - 2) == '2' &&
                        digitsStr.charAt(length - 1) < '7'))
            ) {count += numberOfWays(digitsStr,length-2);}
        return count;
    }



    public static void main(String[] args) {

        Map<Integer, Character> keylist = new HashMap<Integer, Character>();
        String charlist = "abcdefghijklmnopqrstuvwxyz";
        for(int i=1; i<=26; i++){
            keylist.put(i,charlist.charAt(i-1));
        }

        String digitA = "1112";
        String digitB = "1101";
        String digitC = "210";
        int result = numberOfWaysToDecrypt(digitA);
        int resultB = numberOfWaysToDecrypt(digitB);
        int resultC = numberOfWaysToDecrypt(digitC);
        System.out.println(result);
        System.out.println(resultB);
        System.out.println(resultC);

    }
}
