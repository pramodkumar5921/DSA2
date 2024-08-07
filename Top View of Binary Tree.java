//{ Driver Code Starts
// Initial Template for JAVA

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;


// } Driver Code Ends

class Solution {
    public static class NodeIndex{
        Node node;
        int idx;
        NodeIndex(Node node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    static ArrayList<Integer> topView(Node root) {
        // if(root)
        ArrayList<Integer>arr=new ArrayList<>();
        Queue<NodeIndex>que=new LinkedList<>();
        que.add(new NodeIndex(root,0));
        TreeMap<Integer,Integer>mp=new TreeMap<>();
        while(que.size()>0){
            int x=que.size();
            while(x-- > 0){
                NodeIndex curr=que.poll();
                Node temp=curr.node;
                int i=curr.idx;
                if(mp.containsKey(i)==false){
                    mp.put(i,temp.data);
                }
                if(temp.left!=null){
                    que.add(new NodeIndex(temp.left,i-1));
                }
                if(temp.right!=null){
                    que.add(new NodeIndex(temp.right,i+1));
                }
            }
        }
        for(Map.Entry<Integer,Integer>it:mp.entrySet()){
            int ele=it.getValue();
            arr.add(ele);
        }
        return arr;
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Tree {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();

            ArrayList<Integer> vec = ob.topView(root);
            for (int x : vec) System.out.print(x + " ");
            System.out.println();

            t--;
        }
    }
}
// } Driver Code Ends
