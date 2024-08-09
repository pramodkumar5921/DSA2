class Solution {
    public boolean check(int Srow,int Erow,int Scol,int Ecol,int[][] grid){
        // for(int i=Srow;i<=Erow;i++){
        //     for(int j=Scol;j<=Ecol;j++){
        //         System.out.print(grid[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=Srow;i<=Erow;i++){
            for(int j=Scol;j<=Ecol;j++){
                if(grid[i][j]>9 || grid[i][j]<1){
                    return false;
                }
                mp.put(grid[i][j],1);
            }
        }
        if(mp.size()!=9){
            return false;
        }
        int totalR=0;
        int totalC=0;
        for(int i=Scol;i<=Ecol;i++){
            totalR+=grid[Srow][i];
        }
        for(int i=Srow;i<=Erow;i++){
            totalC+=grid[i][Scol];
        }
        if(totalR!=totalC){
            return false;
        }
        for(int i=Srow+1;i<=Erow;i++){
            int sumR=0;
            for(int j=Scol;j<=Ecol;j++){
                sumR+=grid[i][j];
            }
            if(sumR!=totalR){
                return false;
            }
        }

        for(int i=Scol+1;i<=Ecol;i++){
            int sumC=0;
            for(int j=Srow;j<=Erow;j++){
                sumC+=grid[j][i];
            }
            if(totalC!=sumC){
                return false;
            }
        }
        int DiaR=0;
        int DiaL=0;
        for(int i=0;i<3;i++){
            DiaR+=grid[Srow+i][Scol+i];
            DiaL+=grid[Srow+i][Scol+2-i];
        }
        if(DiaR!=totalR || DiaL!=totalR){
            return false;
        }
        return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
      int lenrow=grid.length;
      int lencol=grid[0].length;
      int ans=0;
      for(int row=0;row<=lenrow-3;row++){
        for(int col=0;col<=lencol-3;col++){
            int startR=row+0;
            int endR=row+2;
            int startC=col+0;
            int endC=col+2;
            if(check(startR,endR,startC,endC,grid)==true){
                ans++;
            }
        }
      } 
      return ans; 
    }
}
