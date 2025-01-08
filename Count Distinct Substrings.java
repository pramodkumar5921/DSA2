
import java.util.ArrayList;

public class Solution {

	public static class TrieNode{
		TrieNode[] childNode;
		boolean isEndOfWord;

		TrieNode(){
			childNode = new TrieNode[26];
			isEndOfWord = false;
		}
	}

	public static TrieNode getNode(){
			return new TrieNode();
	}

	public static void insert(TrieNode root,String word){

		TrieNode crawl = root;

		for(int i=0;i<word.length();i++){
			int idx = word.charAt(i)-'a';

			if(crawl.childNode[idx]==null){
				crawl.childNode[idx] = getNode();
			}
			crawl = crawl.childNode[idx];
		}

		crawl.isEndOfWord = true;
	}

	public static boolean isPresent(TrieNode root,String word){

		TrieNode crawl = root;

		for(int i=0;i<word.length();i++){

			int idx = word.charAt(i)-'a';

			if(crawl.childNode[idx]==null){
				return false;
			}

			crawl=crawl.childNode[idx];
		}

		if(crawl!=null && crawl.isEndOfWord == true){
			return true;
		}

		return false;
	}
	public static int countDistinctSubstrings(String s) {
		TrieNode root = new TrieNode();

		int ans=0;

		for(int i=0;i<s.length();i++){

			StringBuilder str = new StringBuilder();

			for(int j=i;j<s.length();j++){
				str.append(s.charAt(j));

				if(isPresent(root,str.toString())==true){
					continue;
				}
				else{
					ans++;
					insert(root,str.toString());
				}
			}
		}
		return ans+1;
	}
}
