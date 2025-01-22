class Solution {
    public boolean isPlace(int[][] temp,int row,int col){
        for(int i=0;i<temp.length;i++){
            if(temp[i][col]==1){
                return false;
            }
        }

        for(int j=0;j<temp.length;j++){
            if(temp[row][j]==1){
                return false;
            }
        }

        int l=row,m=col;
        while(l>=0 && m>=0){
            if(temp[l][m]==1){
                return false;
            }
            l-=1;
            m-=1;
        }

        int x=row,y=col;

        while(x>=0 && y<temp.length){
            if(temp[x][y]==1){
                return false;
            }
            x-=1;
            y+=1;
        }


        return true;
    }
    public void allCombination(int[][]temp,int row,List<List<String>>ans){
        if(row==temp.length){
            List<String>st1 = new ArrayList<>(); 
            for(int i=0;i<temp.length;i++){
                StringBuilder str = new StringBuilder();
                for(int j=0;j<temp[0].length;j++){
                    if(temp[i][j]==1){
                        str.append('Q');
                    }
                    else{
                        str.append('.');
                    }
                }
                String str1=str.toString();
                st1.add(str1);
            }
            ans.add(new ArrayList<>(st1));
            return;
        }
        for(int col=0;col<temp.length;col++){
            if(isPlace(temp,row,col)==true){
                temp[row][col]=1;
                allCombination(temp,row+1,ans);
                temp[row][col]=0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>ans = new ArrayList<>();
        int[][] temp = new int[n][n];
        allCombination(temp,0,ans);
        return ans;
    }
}
