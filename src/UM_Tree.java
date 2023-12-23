import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UM_Tree {
    private Node root ;
    private int nodeCount = 0;

    public UM_Tree(){
        this.root =  new Node(new UM_Alani(null, null, 5555555 , null));
    }
    public Node getRoot() {
        return root;
    }
    
    public int getNodeCount(){
        return nodeCount;
    }


    public Node insert(Node data){
        nodeCount ++;
        return insert(data , this.root , null);
    }
    

    // Recursive method to insert a new UM_Alani with the given data
    private Node insert(Node data , Node currentNode  , Node opositNode) {
        if (currentNode.getData().getAlan_Adi() == null) {
            currentNode.setData(data.getData());
            currentNode.setLeft(data.getLeft());
            currentNode.setRight(data.getRight());

            
        }
        String rootAlanName = currentNode.getData().getAlan_Adi();
        String inputAlanName = data.getData().getAlan_Adi();
        
        if (inputAlanName.compareTo(rootAlanName) < 0) {
    
            if (currentNode.getLeft() == null){
                currentNode.setLeft(data);

            }
            else{
             
            
            return insert(data,currentNode.getLeft() , currentNode.getRight());
            
        }
        } else if (inputAlanName.compareTo(rootAlanName) > 0) {
            
            
            if (currentNode.getRight() == null){
                currentNode.setRight(data);
                
            }
            else{
               
           
            return insert(data,currentNode.getRight() , currentNode.getLeft());}
        }

        return currentNode;
    }
    public void iterate(){iterate(root,"-----(root)");}
    public void iterate(Node root , String dir){
        if (root != null){    
            
            System.out.println(root.getData().getAlan_Adi()+dir);
            iterate(root.getLeft(), dir+"L");
            iterate(root.getRight(), dir+"R");
        }

    }
    public void iterateAlphabeticLimited(Node root , String dir , char[] excludedLetters){
        if (root != null){    
            String nodeName = root.getData().getAlan_Adi();
            if(!UtilityBox.contains(excludedLetters,nodeName.charAt(0)))System.out.println(root.getData().getAlan_Adi()+dir);
            iterateAlphabeticLimited(root.getLeft(), dir+"L" , excludedLetters);
            iterateAlphabeticLimited(root.getRight(), dir+"R" ,excludedLetters);
        }

    }
    public void iterateAlphabeticLimited(){
        List<Character> excludedCharacters = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the characters you want to get excluded: ");
        String excludedString = scanner.nextLine();
        for (int i = 0 ; i < excludedString.length() ; i++){
            excludedCharacters.add(excludedString.charAt(i));
        } 
        iterateAlphabeticLimited(root, "-----(root)" , UtilityBox.convertListToArray(excludedCharacters));
    }
    public int depthWhenBalanced(){
        int balancedDepth = 0;
        int nodes = 0;
        for(int i = 1 ; nodes < nodeCount ; i*=2 ){
            balancedDepth ++;
            nodes += i;
            
        }
        return balancedDepth;
        
    }
    public int findDepth() {
        return findDepth(root);
    }

    private int findDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = findDepth(node.getLeft());
            int rightDepth = findDepth(node.getRight());

            // Return the maximum depth of the left and right subtrees, plus 1 for the current node
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }



    
}
