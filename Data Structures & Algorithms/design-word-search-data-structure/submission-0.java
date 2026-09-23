class WordDictionary {
    Node root; 
    public WordDictionary() {
        root = new Node(); 
    }

    public void addWord(String word) {
        Node curr = root; 

        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; 
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];  
        }
        curr.endOfWord = true; 
    }

    public boolean search(String word) {
       return dfs(word, root, 0); 
    }

    public boolean dfs(String word, Node root, int index) {
        Node curr = root; 
        for (int i = index; i < word.length(); i++) {
            if (word.charAt(i) == '.') { // search thru every possible key and try all 
                for (Node neigh : curr.children) {
                    if (neigh != null && dfs(word, neigh, i + 1)) {
                        return true; 
                    }
                }
                return false; 
            } else {
                //case where the char is a character and NOT a wildcard
                int j = word.charAt(i) - 'a';

                if (curr.children[j] == null) {
                    return false; 
                }
                curr = curr.children[j]; 
            }
        }
        return curr.endOfWord; 
    }


    public class Node {
        boolean endOfWord = false; 
        Node[] children = new Node[26]; 
    }
}
