class PrefixTree {
    Node root; 
    public PrefixTree() {
        root = new Node(); 
    }

    public void insert(String word) {
        Node current = root; 
        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; 
            if (current.children[index] == null) {
                current.children[index] = new Node(); 
            }
            current = current.children[index]; 
        }
        current.endOfWord = true; 
    }

    public boolean search(String word) {
        Node current = root; 
        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; 
            if (current.children[index] != null) {
                current = current.children[index]; 
            } else {
                return false; 
            }
        }

        if (current.endOfWord == true) return true; 

        return false; 
    }

    public boolean startsWith(String prefix) {
        int count = 0; 
        Node current = root; 
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a'; 
            count++; 
            if (current.children[index] != null) {
                current = current.children[index]; 
            } else {
                return false; 
            }
        }
        return true; 
    }

    public class Node {
        boolean endOfWord; 
        Node[] children = new Node[26]; 
    }
}
