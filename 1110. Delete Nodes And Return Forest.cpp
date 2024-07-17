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
    unordered_map<int,int>mp;
    TreeNode*solve(TreeNode*root,vector<TreeNode*>&ans){
        if(root==NULL){
            return NULL;
        }
        root->left=solve(root->left,ans);
        root->right=solve(root->right,ans);
        if(mp.find(root->val)!=mp.end()){
            if(root->left!=NULL){
                ans.push_back(root->left);
            }
            if(root->right!=NULL){
                ans.push_back(root->right);
            }
            return NULL;
        }
        return root;
    }
    vector<TreeNode*> delNodes(TreeNode* root, vector<int>& to_delete) {
        vector<TreeNode*>ans;
        for(int i=0;i<to_delete.size();i++){
            mp[to_delete[i]]=1;
        }
        solve(root,ans);
        if(mp.find(root->val)==mp.end()){
             ans.push_back(root);
        }
        return ans;
    }
};
