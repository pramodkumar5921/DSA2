//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

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

class GfG {

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
			if (i >= ip.length)
				break;

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
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends




// import java.util.*;
class Solution{
    public static int minTime(Node root, int target){
        if(root.left==null && root.right==null){
            return 0;
        }
       HashMap<Integer,ArrayList<Integer>>mp=new HashMap<>();
       Queue<Node>que=new LinkedList<>();
       que.add(root);
       while(que.size()>0){
           int x=que.size();
           while(x>0){
               Node temp=que.poll();
               if(temp.left!=null){
                  
                  mp.putIfAbsent(temp.data,new ArrayList<>());
                    mp.putIfAbsent(temp.left.data,new ArrayList<>());
                    mp.get(temp.data).add(temp.left.data);
                    mp.get(temp.left.data).add(temp.data);
                    que.add(temp.left);
               }
               if(temp.right!=null){
                   mp.putIfAbsent(temp.data,new ArrayList<>());
                   mp.putIfAbsent(temp.right.data,new ArrayList<>());
                   mp.get(temp.data).add(temp.right.data);
                   mp.get(temp.right.data).add(temp.data);
                   que.add(temp.right);
               }
               x--;
           }
       }
       Queue<Integer>q=new LinkedList<>();
       q.add(target);
       int ans=0;
       int[] vis=new int[10001];
       while(q.size()>0){
           int x=q.size();
           while(x-- > 0){
               int temp=q.poll();
            //   q.pop();
               if(vis[temp]==1){
                   continue;
               }
               vis[temp]=1;
               for(int it:mp.get(temp)){
                   if(vis[it]==0){
                       q.add(it);
                   }
               }
           }
           ans++;
       }
       return ans-1;
    }
}
