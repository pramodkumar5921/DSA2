class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String>ans = new ArrayList<>();
        int[]freq2 = new int[26];

        for(int i=0;i<words2.length;i++){

             int[]freq1 = new int[26];

             String str = words2[i];

             for(int j=0;j<str.length();j++){
                int idx = (int)str.charAt(j)-'a';
                freq1[idx]+=1;
            }

           for(int j=0;j<freq2.length;j++){
              freq2[j]=Math.max(freq2[j],freq1[j]);
           }

        }

        // for(int i=0;i<freq2.length;i++){
        //     System.out.print(freq2[i]+" ");
        // }

        for(int i=0;i<words1.length;i++){
            int[]freq1 = new int[26];

            String str = words1[i];

            for(int j=0;j<str.length();j++){
                int idx = (int)str.charAt(j)-'a';
                freq1[idx]+=1;
            }
            boolean flag = false;
            for(int j=0;j<freq2.length;j++){
                if(freq2[j]!=0){
                    if(freq2[j]>freq1[j]){
                        flag=true;
                        break;
                    }
                }
            }
            if(flag==false){
                ans.add(words1[i]);
            }
        }
        return ans;
    }
}
