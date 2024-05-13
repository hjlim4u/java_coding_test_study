import java.util.*;
class Solution {
    class TrieNode {
        boolean word;
        HashMap<Character, TrieNode> children;
        
        public TrieNode() {
            this.word = false;
            this.children = new HashMap<>();
        }
    }
    class Trie {
        TrieNode root;
        
        public Trie () {
            root = new TrieNode();
        }
        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                cur.children.putIfAbsent(c, new TrieNode());
                cur = cur.children.get(c);
            }
            cur.word = true;
        }
        public boolean pronounce(String babble) {
            TrieNode cur = root;
            for (char b : babble.toCharArray()) {
                if (!cur.children.containsKey(b)) {
                    return false;
                }
                cur = cur.children.get(b).word ? root : cur.children.get(b);
            }
            return cur==root;
        }
    }
    public int solution(String[] babbling) {
        int answer = 0;
        Trie t = new Trie();
        String[] strs = new String[] {"aya", "ye", "woo", "ma"};
        for(String s : strs) {
            t.insert(s);
        }
        for (String babble : babbling) {
            answer += t.pronounce(babble) ? 1 : 0;
        }
        return answer;
    }
}