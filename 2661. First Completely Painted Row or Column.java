class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n=mat[0].length;
        int m=mat.length;
        int[] rowVis = new int[100001];
        int[] colVis = new int[100001];

        HashMap<Integer,ArrayList<Integer>>mp = new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               int val = mat[i][j];
               if(mp.get(val)==null){
                mp.put(val,new ArrayList<>(Arrays.asList(i,j)));
               } 
            }
        }
        for(int i=0;i<arr.length;i++){
            ArrayList<Integer>temp = mp.get(arr[i]);
            int row = temp.get(0);
            int col = temp.get(1);
            rowVis[row]+=1;
            colVis[col]+=1;

            if(rowVis[row]==n){
                return i;
            }
            if(colVis[col]==m){
                return i;
            }
        }
        return -1;
    }
}
