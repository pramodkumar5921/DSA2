class Solution {
public:
    long long minimumCost(int m, int n, vector<int>& hCut, vector<int>& vCut) {
        sort(hCut.rbegin(),hCut.rend());
        sort(vCut.rbegin(),vCut.rend());
        int h=1,v=1;
        int i=0,j=0;
        long long cost=0;
        while(i<hCut.size() and j<vCut.size()){
            if(hCut[i]>=vCut[j]){
                cost += (long long)(h*hCut[i]);
                v++;
                i++;
            }
            else{
                cost += (long long)(v*vCut[j]);
                h++;
                j++;
            }
        }
        while(i<hCut.size()){
            cost += (long long)(h*hCut[i]);
            i++;
        }
        while(j<vCut.size()){
            cost += (long long)(v*vCut[j]);
            j++;
        }
        return cost;
    }
};
