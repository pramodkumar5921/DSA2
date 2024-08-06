//{ Driver Code Starts
//Initial Template for Java




//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
 
        inOrder(node.left);
        System.out.print(node.data + " ");
 
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
			    Solution g=new Solution();
                System.out.println(g.isSumProperty(root));
    	        
	        }
	}
}


// } Driver Code Ends

class Solution{
    public static class NodeIndex{
        Node node;
        int idx;
        NodeIndex(Node node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public static int isSumProperty(Node root){
        ArrayList<ArrayList<NodeIndex>>arr=new ArrayList<>();
        Queue<NodeIndex>que=new LinkedList<>();
        que.add(new NodeIndex(root,0));
        HashMap<Integer,Integer>mp=new HashMap<>();
        while(que.size()>0){
            ArrayList<NodeIndex>alpha=new ArrayList<>();
            int x=que.size();
            while(x>0){
                NodeIndex curr=que.poll();
                Node temp=curr.node;
                int i=curr.idx;
                mp.put(i,temp.data);
                alpha.add(new NodeIndex(temp,i));
                if(temp.left!=null){
                    que.add(new NodeIndex(temp.left,2*i+1));
                }
                if(temp.right!=null){
                    que.add(new NodeIndex(temp.right,2*i+2));
                }
                x--;
            }
            arr.add(alpha);
        }
        for(int i=0;i<arr.size()-1;i++){
            for(int j=0;j<arr.get(i).size();j++){
                NodeIndex temp=arr.get(i).get(j);
                int ele=temp.node.data;
                int val=temp.idx;
                int total=0;
                if(mp.containsKey((2*val+1))==true){
                    total+=mp.get(2*val+1);
                }
                if(mp.containsKey((2*val+2))==true){
                    total+=mp.get(2*val+2);
                }
                if(total!=ele && total!=0){
                    return 0;
                }
            }
        }
        return 1;
    }
}
