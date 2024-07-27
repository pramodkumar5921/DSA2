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
    void InorderTraversal(TreeNode*root,vector<int>&vec){
        if(root==NULL){
            return ;
        }
       InorderTraversal(root->left,vec);
       vec.push_back(root->val);
       InorderTraversal(root->right,vec);
       return ;
    }
    bool isValidBST(TreeNode* root) {
      vector<int>vec;
      InorderTraversal(root,vec);
      for(int i=1;i<vec.size();i++){
        if(vec[i]<=vec[i-1]){
            return false;
        }
      }
      return true;
    }
};
