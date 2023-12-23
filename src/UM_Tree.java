

public class UM_Tree {
    private Node root ;
    private int depth = 0;
    private int traveledDepth=0;

    public UM_Tree(){
        this.root =  new Node(new UM_Alani(null, null, 5555555));
    }
    public Node getRoot() {
        return root;
    }
    public int getDepth(){
        return depth;
    }

    // Setter method to set the value of the 'root' variable
    public Node insert(Node data){
        return insert(data , this.root , null);
    }
    

    // Recursive method to insert a new UM_Alani with the given data
    private Node insert(Node data , Node currentNode  , Node opositNode) {
        if (currentNode.getData().getAlan_Adi() == null) {
            currentNode.setData(data.getData());
            currentNode.setLeft(data.getLeft());
            currentNode.setRight(data.getRight());
            depth +=1;
            
            //System.out.println(this.root.getData().toString());
            
        }
        String rootAlanName = currentNode.getData().getAlan_Adi();
        String inputAlanName = data.getData().getAlan_Adi();
        
        if (inputAlanName.compareTo(rootAlanName) < 0) {
            //System.out.println("null entered");
            if (currentNode.getLeft() == null){
                currentNode.setLeft(data);
                if (traveledDepth > depth){
                    depth = traveledDepth;
                    traveledDepth = 0;
                
                }

                
              //  System.out.println("null entered");
                
            }
            else{
                //System.out.println("left recursive");
            traveledDepth ++ ;
            return insert(data,currentNode.getLeft() , currentNode.getRight());
            
        }
        } else if (inputAlanName.compareTo(rootAlanName) > 0) {
            //System.out.println("null entered");
            
            if (currentNode.getRight() == null){
                currentNode.setRight(data);
                if (traveledDepth > depth){
                    depth = traveledDepth;
                    traveledDepth = 0;
                
                }
                    
                
                
              //  System.out.println("right null enterd");
                
            }
            else{
               // System.out.println("right recursive");
            traveledDepth ++ ;
            return insert(data,currentNode.getRight() , currentNode.getLeft());}
        }
        
        
        

        return currentNode;
    }
    public void iterate(Node root , String dir){
        if (root != null){    
            
            System.out.println(root.getData().getAlan_Adi()+dir);
            iterate(root.getLeft(), dir+"L");
            iterate(root.getRight(), dir+"R");
        }
        



    }


    
}
