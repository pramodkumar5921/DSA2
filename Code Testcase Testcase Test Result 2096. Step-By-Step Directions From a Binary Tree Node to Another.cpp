/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool Path(TreeNode*root,int target,string &str){
        if(root==NULL){
            return false;
        }
        if(root->val==target){
            return true;
        }
        str+='L';
        if(Path(root->left,target,str)==true){
            return true;
        }
        // if(str.size()>0){
            str.pop_back();
        // }
          str+='R';
        if(Path(root->right,target,str)==true){
            return true;
        }
        // if(str.size()>0){
            str.pop_back();
        // }
        return false;
    }
    string getDirections(TreeNode* root, int startValue, int destValue) {
        string RootToSrc;
        string RootToTarget;
        Path(root,startValue,RootToSrc);
        Path(root,destValue,RootToTarget);
        string ans;
        // return ans;
        int i=0;
        while(i<RootToSrc.size() and i<RootToTarget.size()){
            if(RootToTarget[i]==RootToSrc[i]){
                i++;
            }
            else{
                break;
            }
        }
        for(int k=i;k<RootToSrc.size();k++){
            ans+='U';
        }
        int j=i;
        while(j<RootToTarget.size()){
            ans+=RootToTarget[j];
            j++;
        }
        return ans;
    }
};
