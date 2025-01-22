class Solution {
    class TrieNode{
        boolean isEndOfWord;
        TrieNode[] childNode;
        String word;

        TrieNode(){
            isEndOfWord=false;
            childNode = new TrieNode[26];
            word="";
        }
    }
    public TrieNode getNode(){
        return new TrieNode();
    }

    public void insert(TrieNode root,String word){
       TrieNode crawl = root;

       for(int i=0;i<word.length();i++){
          int idx = word.charAt(i)-'a';
          if(crawl.childNode[idx]==null){
            crawl.childNode[idx]=getNode();
          }
          crawl=crawl.childNode[idx];
       }

       crawl.isEndOfWord = true;
       crawl.word = word;
    }

    public void findWord(TrieNode root,int[][] vis,int row,int col,List<String>ans,char[][] board,ArrayList<ArrayList<Integer>>dir){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col]=='$'){
            return;
        }
        int idx = board[row][col]-'a';
        if(root.childNode[idx]==null){
            return;
        }
        
        root = root.childNode[idx];

        if(root.isEndOfWord==true){
            ans.add(root.word);
            root.word="";
            root.isEndOfWord=false;
            //return;
        }

        char temp = board[row][col];
        board[row][col]='$';

        for(int i=0;i<4;i++){
            int nr = row+dir.get(i).get(0);
            int nc = col+dir.get(i).get(1);
            findWord(root,vis,nr,nc,ans,board,dir);
        }
        board[row][col]=temp;
    }
 
    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode();

        int m = board.length;
        int n = board[0].length;
       
        ArrayList<ArrayList<Integer>>dir = new ArrayList<>(Arrays.asList(
            new ArrayList<Integer>(Arrays.asList(-1,0)),
            new ArrayList<Integer>(Arrays.asList(0,1)),
            new ArrayList<Integer>(Arrays.asList(1,0)),
            new ArrayList<Integer>(Arrays.asList(0,-1))
        ));

        for(int i=0;i<words.length;i++){
            insert(root,words[i]);
        } 

        int[][] vis = new int[m][n];

        List<String>ans = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int idx = board[i][j]-'a';
                if(root.childNode[idx]!=null){
                    findWord(root,vis,i,j,ans,board,dir);
                }
            }
        } 
        return ans;     
    }
}
