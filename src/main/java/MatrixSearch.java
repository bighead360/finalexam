import java.util.ArrayList;
import java.util.List;

/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 6/14/16.
 */
public class MatrixSearch {


    private boolean find;

    boolean isInMatrix(char[][] matrix, String word) {
        int[] newpoint = new int[2];
        List<int[]> newpointlist = new ArrayList<int[]>();
        boolean exit = false;
            for(int My=0;My<matrix[0].length;My++){
                for(int Mx=0;Mx<matrix[0].length;Mx++)
                if (word.charAt(0)==matrix[My][Mx]){
                    exit=true;
                    newpoint[0] = Mx;
                    newpoint[1] = My;
                    newpointlist.add(newpoint);
                }
            }
        if(exit){

            SearchToEnd(matrix,newpointlist,word,1);
            if (find){
                return true;
            }
        }
        return false;
    }


    void SearchToEnd(char[][] matrix, List<int[]> nextpointlist,String word,int k) {


        if (k==word.length()){
            find = true;
            return;
        }

        if (nextpointlist.size()==0){
            find = false;
            return;
        }

        if (nextpointlist.size()>=1) {
            for (int j = 0; j < nextpointlist.size(); j++) {
                nextpointlist = findnext(matrix, nextpointlist.get(j)[0], nextpointlist.get(j)[1], word.charAt(k));

                SearchToEnd(matrix, nextpointlist, word, k + 1);}}


    }

    List<int[]> findnext(char[][] matrix, int Mx, int My, char next){
        int[] point = new int[2];
        List<int[]> newpointlist = new ArrayList<int[]>();
        for(int i=0;i<matrix.length;i++){
            if((next == matrix[My][i])&&(Math.abs(i-Mx) ==1)){
                point[0] = i;
                point[1] = My;
                newpointlist.add(point);
            }
        }

        for(int i=0;i<matrix.length;i++){
            if((next == matrix[i][Mx])&&(Math.abs(i-My) ==1)){
                point[0] = Mx;
                point[1] = i;

                newpointlist.add(point);
            }

        }


        return newpointlist;

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
        System.out.println(matrixSearch.isInMatrix(Matrix,"eli"));
        System.out.println(matrixSearch.isInMatrix(Matrix,"apple"));
        System.out.println(matrixSearch.isInMatrix(Matrix,"jpk"));



    }

}
