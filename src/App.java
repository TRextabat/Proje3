import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        UM_Tree tree = new UM_Tree();
        String filePath = "Proje3/src/data.txt";
        ReadFile file = new ReadFile(filePath);
        List<List<UM_Alani>> result = file.getMiras();
        UM_Alani temp = new UM_Alani("", null, 0, null);

        Node root = new Node(temp);
        List<UM_Alani> sortedAlanNameList = new ArrayList<>();
        // hashtable
        Hashtable<String, UM_Alani> umAlanTable = new Hashtable<>();
        // Create a PriorityQueue with a comparator for UM_Alani objects
        PriorityQueue<UM_Alani> minHeap = new PriorityQueue<>(Comparator.comparing(UM_Alani::getAlan_Adi));

        for (List<UM_Alani> item : result) {
            for (UM_Alani item2 : item) {

                Node newTreeNode = new Node(item2);
                tree.insert(newTreeNode).getData().toString();

                temp = item2;
                root = tree.getRoot();
                sortedAlanNameList.add(item2);

                // add to hashtable
                addToHashtable(umAlanTable, item2);
                minHeap.add(item2);

            }

            System.out.println("******************************");

        }

        
        tree.iterate();
        Collections.sort(sortedAlanNameList, Comparator.comparing(UM_Alani::getAlan_Adi));
        UM_Alani[] sortedAlanNameArray = sortedAlanNameList.toArray(new UM_Alani[0]);
        UM_Tree newTree = new UM_Tree();
        UtilityBox.iterateSortedArray(sortedAlanNameArray, newTree);

        System.out.println(tree.findDepth());
        System.out.println(String.format("%s %d", "the tree depth is :", tree.findDepth()));
        System.out.println(String.format("%s %d", "number of nodes is  :", tree.getNodeCount()));
        System.out.println(String.format("%s %s", "root name is  :", tree.getRoot().getData().getAlan_Adi()));
        System.out.println(String.format("%s %d", "theoretical tree depth when balanced :", tree.depthWhenBalanced()));
        tree.iterateAlphabeticLimited();
        newTree.iterate();
        System.out.println(String.format("%s %d", "balanced tree depth is :", newTree.findDepth()));
        // Poll the first 3 elements from the min heap and display their information
        int count = 0;
        while (!minHeap.isEmpty() && count < 3) {
            UM_Alani umAlan = minHeap.poll();
            System.out.println("UM Alan Adı: " + umAlan.getAlan_Adi() +
                    ", İl Adları: " + umAlan.getIl_Adlari() +
                    ", İlan Yılı: " + umAlan.getIlan_Yili());
            count++;
        }
    

        updateName(umAlanTable);

    }

    private static void addToHashtable(Hashtable<String, UM_Alani> hashtable, UM_Alani umAlan) {
        hashtable.put(umAlan.getAlan_Adi().trim(), umAlan);
    }

    private static void updateName(Hashtable<String, UM_Alani> hashtable) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("Original Hashtable:");
            for (String key : hashtable.keySet()) {
                UM_Alani value = hashtable.get(key);
                System.out.println(key + ":" + value);
            }
            System.out.print("Enter the current name (Alan_Adi) of the UM_Alani object (leave empty to skip): ");
            String currentName = scanner.nextLine().trim();

            if (!currentName.isEmpty()) {
                System.out.print("Enter the new name for the UM_Alani object: ");
                String newName = scanner.nextLine();

                UM_Alani umAlan = hashtable.remove(currentName);
                umAlan.setAlan_Adi(newName);
                hashtable.put(umAlan.getAlan_Adi(), umAlan);

                System.out.println("Name updated successfully!");
                for (String key : hashtable.keySet()) {
                    UM_Alani value = hashtable.get(key);
                    System.out.println(key + ":" + value);
                }

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
