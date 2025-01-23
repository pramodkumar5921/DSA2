class Solution {
    public void allWord(List<String>ans,String digits,int idx,String word,HashMap<Integer,String>mp){
        if(idx>=digits.length()){
            ans.add(word);
            return;
        }
        String temp = mp.get((int)(digits.charAt(idx)-'0'));

        for(int i=0;i<temp.length();i++){
            word+=temp.charAt(i);
            allWord(ans,digits,idx+1,word,mp);
            word=word.substring(0,word.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String>mp=new HashMap<>();
        mp.put(2,"abc");
        mp.put(3,"def");
        mp.put(4,"ghi");
        mp.put(5,"jkl");
        mp.put(6,"mno");
        mp.put(7,"pqrs");
        mp.put(8,"tuv");
        mp.put(9,"wxyz");

        List<String>ans = new ArrayList<>();
        allWord(ans,digits,0,"",mp);
        if(digits.length()==0){
            return new ArrayList<>();
        }
        return ans;
    }
}
