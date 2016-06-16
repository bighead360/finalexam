/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 6/14/16.
 */
public class MatrixSearch {

    boolean isInMatrix(char[][] matrix, String word) {
        int locationX = 0;
        int locationY = 0;
        int[] newpoint = new int[2];
        boolean exit = false;
            for(int My=0;My<matrix[0].length;My++){
                for(int Mx=0;Mx<matrix[0].length;Mx++)
                if (word.charAt(0)==matrix[My][Mx]){
                    exit=true;
                    newpoint[0] = Mx;
                    newpoint[1] = My;
                }
            }
        if(exit){
            for(int i=1; i<word.length();i++){

                if (newpoint!=null){
                    newpoint = findnext(matrix,newpoint[0],newpoint[1],word.charAt(i));
                }else {
                    return false;
                }
            }

            if (newpoint !=null){
                return true;
            }
        }
        return false;
    }

    int[] findnext(char[][] matrix, int Mx, int My, char next){
        int[] point = new int[2];

        for(int i=0;i<matrix.length;i++){
            if((next == matrix[My][i])&&(Math.abs(i-Mx) ==1)){
                point[0] = i;
                point[1] = My;

                return point;

            }
        }

        for(int i=0;i<matrix.length;i++){
            if((next == matrix[i][Mx])&&(Math.abs(i-My) ==1)){
                point[0] = Mx;
                point[1] = i;

                return point;

            }

        }
        return null;
    }



    public static void main(String[] args) {


       char[][] Matrix= {
               {'a','b', 'e', 'l'},
               {'c','k', 'p', 'g'},
               {'o','i', 'j', 'p'},
               {'l','l', 'e', 'b'}};

        MatrixSearch matrixSearch = new MatrixSearch();
        System.out.println(matrixSearch.isInMatrix(Matrix,"ack"));
        System.out.println(matrixSearch.isInMatrix(Matrix,"jello"));
        System.out.println(matrixSearch.isInMatrix(Matrix,"apple"));
    }

}
