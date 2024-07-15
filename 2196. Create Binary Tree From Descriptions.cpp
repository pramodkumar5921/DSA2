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
    unordered_map<int,vector<pair<int,int>>>graph;
    void solve(TreeNode*root){
        if(graph.find(root->val)==graph.end()){
            return;
        }
        else{
            int left=0,right=0;
            for(auto temp:graph[root->val]){
                if(temp.first==1){
                    left=temp.second;
                }
                if(temp.first==0){
                    right=temp.second;
                }
            }
            if(right!=0){
                root->right=new TreeNode(right);
                solve(root->right);
            }
            if(left!=0){
                root->left=new TreeNode(left);
                solve(root->left);
            }
        }
        return;
    }
    TreeNode* createBinaryTree(vector<vector<int>>& desc) {
        unordered_map<int,int>mp;
        for(vector<int>&vec:desc){
            int u=vec[0];
            int v=vec[1];
            mp[u]=1;
        }
        for(vector<int>&vec:desc){
            int v=vec[1];
            if(mp.find(v)!=mp.end()){
                mp.erase(v);
            }
        }
        int rootVal=0;
        for(auto it:mp){
            rootVal=it.first;
        }
        for(vector<int>&vec:desc){
            int u=vec[0];
            int v=vec[1];
            int dir=vec[2];
            graph[u].push_back({dir,v});
        }
        TreeNode*root=new TreeNode(rootVal);
        solve(root);
        return root;
    }
};
