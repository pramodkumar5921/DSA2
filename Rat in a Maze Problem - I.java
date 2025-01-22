//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends
class Solution {
      ArrayList<String>ans = new ArrayList<>();
    public void findAllPath(ArrayList<ArrayList<Integer>>mat,int row,int col,String path,int[][] vis){
        if(row<0 || col<0 || row>=mat.size() || col>=mat.get(0).size() || vis[row][col]==1 || mat.get(row).get(col)==0){
            return;
        }
        if(row==mat.size()-1 && col==mat.get(0).size()-1){
            ans.add(path);
            return;
        }
        vis[row][col]=1;
        path+='U';
        findAllPath(mat,row-1,col,path,vis);
        path=path.substring(0,path.length()-1);
        
        path+='D';
        findAllPath(mat,row+1,col,path,vis);
        path=path.substring(0,path.length()-1);
        
        path+='R';
        findAllPath(mat,row,col+1,path,vis);
        path=path.substring(0,path.length()-1);
        
        path+='L';
        findAllPath(mat,row,col-1,path,vis);
        path=path.substring(0,path.length()-1);
        
        vis[row][col]=0;
    }
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
     
       int n=mat.size();
       int m=mat.get(0).size();
       int[][] vis = new int[n][m];
       
       findAllPath(mat,0,0,"",vis);
       Collections.sort(ans);
       return ans;
    }
}
