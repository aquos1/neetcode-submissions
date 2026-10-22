class PrefixTree {
    Node root;
    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node head = root; 
        for (char ch : word.toCharArray()) {
            //ch is a char for the word. 
            int index = ch - 'a'; 
            if (head.children[index] == null) {
                // this means there is somewhere to go so we can jus move down. 
                head.children[index] = new Node();
            } 
            head = head.children[index]; 
        }
        // mark the end of word. 
        head.endOfWord = true;
    }

    public boolean search(String word) {
        Node head = root; 

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (head.children[index] == null) {
                return false; 
            }
            head = head.children[index];
        }

        return head.endOfWord;
    }

    public boolean startsWith(String prefix) {
        // starts with prefix and reutrn true even 

         Node head = root; 

        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (head.children[index] == null) {
                return false; 
            }
            head = head.children[index];
        }

        return true;
    }


    public class Node {
        Node[] children = new Node[26]; 
        boolean endOfWord = false; 
    }
}
