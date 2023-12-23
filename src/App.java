import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Hashtable;

public class App {
    public static void main(String[] args) throws Exception {
        UM_Tree tree = new UM_Tree();
        String filePath = "data.txt";
        ReadFile file = new ReadFile(filePath);
        List<List<UM_Alani>> result = file.getMiras();
        UM_Alani temp = new UM_Alani("", null, 0);
        Node Node = new Node(new UM_Alani(filePath, null, 0));
        Node root = new Node(temp);
        // hashtable
        Hashtable<String, UM_Alani> umAlanTable = new Hashtable<>();

        for (List<UM_Alani> item : result) {
            for (UM_Alani item2 : item) {
                // System.out.println(temp.getAlan_Adi().compareTo(item2.getAlan_Adi()));

                Node newTreeNode = new Node(item2);
                tree.insert(newTreeNode).getData().toString();
                // System.out.println(newTreeNode.getData().toString());
                //
                // System.out.println(tree.getDepth());
                temp = item2;
                root = tree.getRoot();
                // System.out.println(root.getData().toString());

                // if(root != null){
                // System.out.println(root.getLeft().getData().toString());
                // System.out.println(root.getRight().getData().toString());}
                // else{System.out.println("HUH?!?!?");}
                // tree.iterate(root, "");

                // add to hashtable
                addToHashtable(umAlanTable, item2);
                updateName(umAlanTable);

            }

            System.out.println("******************************");

        }
        tree.iterate(root, "----H");
        System.out.println(tree.getDepth());
        UM_Tree testTree = new UM_Tree();

        String[] alphabetArray = new String[] {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y", "Z"
        };

        // Convert the array to a list for easy shuffling
        List<String> alphabetList = Arrays.asList(alphabetArray);

        // Shuffle the list
        Collections.shuffle(alphabetList);
        for (int i = 0; i < alphabetList.size(); i++) {
            Node newNode = new Node(new UM_Alani(alphabetList.get(i), null, i));
            testTree.insert(newNode);

        }
        testTree.iterate(testTree.getRoot(), "----H");
        System.out.println(testTree.getDepth());
    }

    private static void addToHashtable(Hashtable<String, UM_Alani> hashtable, UM_Alani umAlan) {
        hashtable.put(umAlan.getAlan_Adi(), umAlan);
    }

   

    private static void updateName(Hashtable<String, UM_Alani> hashtable) {
        Scanner scanner = new Scanner(System.in);
    
        try {
            System.out.print("Enter the current name (Alan_Adi) of the UM_Alani object (leave empty to skip): ");
            String currentName = scanner.nextLine().trim();
    
            if (!currentName.isEmpty() && hashtable.containsKey(currentName)) {
                System.out.print("Enter the new name for the UM_Alani object: ");
                String newName = scanner.nextLine();
    
                UM_Alani umAlan = hashtable.remove(currentName);
                umAlan.setAlan_Adi(newName);
                hashtable.put(newName, umAlan);
    
                System.out.println("Name updated successfully!");
            } else if (currentName.isEmpty()) {
                System.out.println("Update skipped as the current name is empty.");
            } else {
                System.out.println("No UM_Alani found with the specified name: " + currentName);
            }
        } finally {
            scanner.close();
        }
    }

}
