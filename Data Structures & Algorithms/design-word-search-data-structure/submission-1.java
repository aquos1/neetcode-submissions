class WordDictionary {

    // trie but when searching we loop thru and explore every poss option via dfs. 
    class Node {
        Node[] children; 
        boolean endOfWord;

        public Node() {
            children = new Node[26];
            endOfWord = false; 
        } 
    }

    Node root; 

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root; 
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (curr.children[index] == null) {
                // make the node add it 
                curr.children[index] = new Node();
            }

            // we can progress thru either ways tho (whether it is not null or is)
            curr = curr.children[index]; 
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        Node curr = root;
        return dfs(word, curr);
    }

    public boolean dfs (String word, Node root) {
        int j = 0; 
        if (j == word.length()) return root.endOfWord;

        for (char ch : word.toCharArray()) {
            // if it is a normal character
            if (Character.isLetter(ch)) {
                int index = ch - 'a';
                if (root.children[index] == null) {
                    // make the node add it 
                    return false;
                }
                // we can progress thru either ways tho (whether it is not null or is)
                root = root.children[index];
            } else { //wildcard (. case)
                // if it is a ., we can go thru each children and explore all. 
                String rest = word.substring(j + 1);
            for (int i = 0; i < 26; i++) {
                // fix #4: only return if this branch WORKS
                if (root.children[i] != null && dfs(rest, root.children[i])) {
                    return true;
                }
            }
            // every branch failed
            return false;
        }
        j++;
    }

    // fix #3: only check endOfWord after the whole word is used up
    return root.endOfWord;
    }
}
