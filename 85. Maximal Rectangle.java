class Solution {
    public void makeNRS(int[] NRS ,int[] mat){
        int n = mat.length;
        Stack<Integer>st = new Stack<>();
        st.add(n-1);
        NRS[n-1]=n;

        for(int i=n-2;i>=0;i--){
            while(st.size()>0){
                int topElement=st.peek();
                if(mat[topElement]>=mat[i]){
                    st.pop();
                }
                else{
                    NRS[i]=topElement;
                    break;
                }
            }
            if(st.size()==0){
                NRS[i]=n;
            }
            st.add(i);
        }
    }
      public void makeNLS(int[] NLS ,int[] mat){
        int n = mat.length;
        Stack<Integer>st = new Stack<>();
        st.add(0);
        NLS[0]=-1;

        for(int i=1;i<n;i++){
            while(st.size()>0){
                int topElement=st.peek();
                if(mat[topElement]>=mat[i]){
                    st.pop();
                }
                else{
                    NLS[i]=topElement;
                    break;
                }
            }
            if(st.size()==0){
                NLS[i]=-1;
            }
            st.add(i);
        }
    }
    public int findLargeRectangle(int[] mat){
        int n = mat.length;
        int ans = 0;

        int[] NRS = new int[n];
        int[] NLS = new int[n];
        makeNRS(NRS,mat);
        makeNLS(NLS,mat);


        for(int i=0;i<n;i++){
            ans=Math.max(ans,mat[i]*(NRS[i]-NLS[i]-1));
        }
        return ans;
    }
    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] mat = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    mat[i][j]=1;
                }
            }
        }
        // for(int j=0;j<m;j++){
        //     mat[0][j]=
        // }
        ans=Math.max(ans,findLargeRectangle(mat[0]));
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='0'){
                    mat[i][j]=0;
                }
                else{
                    mat[i][j]=mat[i-1][j]+mat[i][j];
                }
            }
            ans=Math.max(ans,findLargeRectangle(mat[i]));
        }
        return ans;
    }
}
