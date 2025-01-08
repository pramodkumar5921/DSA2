class Solution {
    class TrieNode{
        TrieNode[] childNode;
        boolean isEndOfWord;

        TrieNode(){
            childNode = new TrieNode[26];
            isEndOfWord=false;
        }
    }

    public TrieNode getNode(){
        return new TrieNode();
    }

    public void insertPrefix(String word,TrieNode root){
        TrieNode crawl = root;

        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';

            if(crawl.childNode[idx]==null){
                crawl.childNode[idx]= getNode();
            }
            crawl=crawl.childNode[idx];
        }

        crawl.isEndOfWord = true;
    }

    public void insertSuffix(String word,TrieNode root){
        TrieNode crawl = root;

        for(int i=word.length()-1;i>=0;i--){
            int idx = word.charAt(i)-'a';

            if(crawl.childNode[idx]==null){
                crawl.childNode[idx]=getNode();
            }

            crawl = crawl.childNode[idx];
        }

        crawl.isEndOfWord  = true;
    }

    public boolean searchPrefix(String word,TrieNode root){
        TrieNode crawl = root;

        int i;
        for(i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';

            if(crawl.childNode[idx]==null){
                return false;
            }
            crawl=crawl.childNode[idx];
        }

         if(i==word.length()){
            return true;
         }
         return false;
    }

    public boolean searchSuffix(String word,TrieNode root){
        TrieNode crawl = root;

        int cnt=0;

        for(int i=word.length()-1;i>=0;i--){
            int idx = word.charAt(i)-'a';

            if(crawl.childNode[idx]==null){
                return false;
            }
            crawl=crawl.childNode[idx];
            cnt++;
        }

        if(cnt==word.length()){
            return true;
        }

        return false;
    }

    public boolean isTrue(String word1,String word2){

        TrieNode root1 = new TrieNode();
        TrieNode root2 = new TrieNode();

        if(word1.length() > word2.length()){
            return false;
        }
        insertPrefix(word2,root1);
       boolean ans1=searchPrefix(word1,root1);

        insertSuffix(word2,root2);
        boolean ans2=searchSuffix(word1,root2);

        if(ans1==true && ans2==true){
            return true;
        }
        return false;
    }
    public int countPrefixSuffixPairs(String[] words) {


        int ans=0;

        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(isTrue(words[i],words[j])==true){
                    ans++;
                }
            }
        }
        return ans;
    }
}
