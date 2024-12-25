class Solution {
    public void buildTree(int i,int l,int r,int[] segmentTree,int[] heights){
        if(l==r){
            segmentTree[i]=l;
            return;
        }
        int mid=l+(r-l)/2;

        buildTree(2*i+1,l,mid,segmentTree,heights);
        buildTree(2*i+2,mid+1,r,segmentTree,heights);

        int leftIdx  = segmentTree[2*i+1];
        int rightIdx = segmentTree[2*i+2];

        if(heights[leftIdx]>=heights[rightIdx]){
            segmentTree[i]=leftIdx;
        }
        else{
            segmentTree[i]=rightIdx;
        }
    }
    public int queryTree(int start,int end,int i,int l,int r,int[] segmentTree,int[] heights){
        if(l>end || r<start){
            return -1;
        }
        if(l>=start && r<=end){
            return segmentTree[i];
        }
        int mid = l+(r-l)/2;

        int leftMaxIdx  = queryTree(start,end,2*i+1,l,mid,segmentTree,heights);
        int rightMaxIdx = queryTree(start,end,2*i+2,mid+1,r,segmentTree,heights);

        if(leftMaxIdx==-1){
            return rightMaxIdx;
        }

        if(rightMaxIdx==-1){
            return leftMaxIdx;
        }

        if(heights[leftMaxIdx]>=heights[rightMaxIdx]){
            return leftMaxIdx;
        }
        else{
            return rightMaxIdx;
        }
    }
    int[] check(int start,int end,int u,int v,int[] segmentTree,int[] heights){
        int n=heights.length;
         int idxele = queryTree(start,end,0,0,n-1,segmentTree,heights);
         int[] ans=new int[2];
         if(heights[idxele]>heights[u] && heights[idxele]>heights[v]){
            ans[0]=1;
            ans[1]=idxele;
         }
         return ans;
    }
    int BinarySearchTree(int u,int v,int l,int r,int[] segmentTree,int[] heights){
        int n=heights.length;
        int ans=-1;
        int x=l,y=r;
        while(x<=y){
            int mid = x+(y-x)/2;
            int[] arr=check(x,mid,u,v,segmentTree,heights);
            if(arr[0]==1){
                ans=Math.min(arr[1],mid);
                y=mid-1;
            }
            else{
                x=mid+1;
            }
        }
        return ans;
    }
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n=heights.length;
        int[] segmentTree = new int[4*n+1];
        buildTree(0,0,n-1,segmentTree,heights);
        int m=queries.length;
        int[] ans=new int[m];
        for(int i=0;i<queries.length;i++){
            int u=queries[i][0];
            int v=queries[i][1];
            if(v==u){
                ans[i]=v;
                continue;
            }
            if(u>v){
                int temp=v;
                v=u;
                u=temp;
            }
            if(heights[v]>heights[u]){
                ans[i]=v;
                continue;
            }
            int temp=BinarySearchTree(u,v,v,n-1,segmentTree,heights);
            ans[i]=temp;
        }
        return ans;
    }
}
