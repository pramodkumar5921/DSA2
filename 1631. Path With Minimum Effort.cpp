class Solution {
public:
    vector<int>dr={-1,0,1,0};
    vector<int>dc={0,1,0,-1};
    typedef pair<int,pair<int,int>>P;
    int minimumEffortPath(vector<vector<int>>& heights) {
        int n=heights.size();
        int m=heights[0].size();
        vector<vector<int>>dist(n,vector<int>(m,1e9));
        dist[0][0]=0;
        priority_queue<P,vector<P>,greater<P>>pq;
        pq.push({0,{0,0}});
        while(pq.size()>0){
            int dis=pq.top().first;
            int row=pq.top().second.first;
            int col=pq.top().second.second;
            pq.pop();
            for(int i=0;i<4;i++){
                int nr=row+dr[i];
                int nc=col+dc[i];
                if(nr<n and nr>=0 and nc>=0 and nc<m){
                    int diff=abs(heights[row][col]-heights[nr][nc]);
                    diff=max(diff,dis);
                    if(diff<dist[nr][nc]){
                        dist[nr][nc]=diff;
                        pq.push({diff,{nr,nc}});
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
};
