class Trie {

   class TrieNode{
        TrieNode[] children;
        boolean endOfWord;

        TrieNode(){
            children = new TrieNode[26];
            endOfWord=false;
        }
    }

    private TrieNode root;
    public Trie() {
        root=new TrieNode();
    }

    private TrieNode getNode(){
        return new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode crawl = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(crawl.children[idx]==null){
                crawl.children[idx]= getNode();
            }
           crawl=crawl.children[idx];
        }
        crawl.endOfWord=true;
    }
    
    public boolean search(String word) {
        TrieNode crawl = root;

        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';

            if(crawl.children[idx]==null){
                return false;
            }
            crawl=crawl.children[idx];
        }

        if(crawl!=null && crawl.endOfWord==true){
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode crawl = root;
        int i;
        for(i=0;i<prefix.length();i++){
            int idx = prefix.charAt(i)-'a';

            if(crawl.children[idx]==null){
                return false;
            }
            crawl=crawl.children[idx];
        }

        if(i==prefix.length()){
            return true;
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
