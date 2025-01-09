class Solution {
    public void queueFill(String word,HashSet<String>usedWord,HashSet<String>setList,Queue<String>que){
        usedWord.add(word);
        for(int i=0;i<word.length();i++){
            for(char j='a';j<='z';j++){
                char[] tempArray = word.toCharArray();
                tempArray[i]=j;
                String str = new String(tempArray);

                if(setList.contains(str)==true && usedWord.contains(str)==false){
                    que.add(str);
                }
            }
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String>setList = new HashSet<>();

        for(int i=0;i<wordList.size();i++){
            String word = wordList.get(i);
            setList.add(word);
        }

        HashSet<String>usedWord = new HashSet<>();
        Queue<String>que = new LinkedList<>();
        que.add(beginWord);

        int ans = 0;

        while(que.size()>0){
            int x = que.size();

            while(x>0){
                String word = que.poll();
                if(word.equals(endWord) ){
                    return ans+1;
                }
                queueFill(word,usedWord,setList,que);
                x=x-1;
            }
            ans=ans+1;
        }

        return 0;
    }
}
