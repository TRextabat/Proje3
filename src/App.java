import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.plaf.synth.SynthDesktopIconUI;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        UM_Tree tree = new UM_Tree();
        String filePath = "data.txt";
        ReadFile file = new ReadFile(filePath);
        List<List<UM_Alani>> result = file.getMiras();
    UM_Alani temp = new UM_Alani("", null, 0);
    Node Node = new Node(new UM_Alani(filePath, null, 0));
    Node root = new Node(temp) ;

    for (List<UM_Alani> item : result)
        {
            for(UM_Alani item2 : item)
            {
                //System.out.println(temp.getAlan_Adi().compareTo(item2.getAlan_Adi()));

                Node newTreeNode = new Node(item2); 
                tree.insert(newTreeNode).getData().toString();
                //System.out.println(newTreeNode.getData().toString());
                //
                //System.out.println(tree.getDepth());
                temp = item2;
                root = tree.getRoot();
                //System.out.println(root.getData().toString());
                
                
                
                //if(root != null){
                //System.out.println(root.getLeft().getData().toString());
                //System.out.println(root.getRight().getData().toString());}
                //else{System.out.println("HUH?!?!?");}
                //tree.iterate(root, "");
                
                

            }
            
            System.out.println("******************************");
            
        }
        tree.iterate(root, "----H");
        System.out.println(tree.getDepth());
        UM_Tree testTree = new UM_Tree();
        String[] alphabetArray = new String[] {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
        };

        // Convert the array to a list for easy shuffling
        List<String> alphabetList = Arrays.asList(alphabetArray);

        // Shuffle the list
        Collections.shuffle(alphabetList);
        for (int i = 0 ; i < alphabetList.size() ; i++){
            Node newNode = new Node(new UM_Alani(alphabetList.get(i), null, i));
            testTree.insert(newNode);

        }
        testTree.iterate(testTree.getRoot(), "----H");
        System.out.println(testTree.getDepth());
    }
}
