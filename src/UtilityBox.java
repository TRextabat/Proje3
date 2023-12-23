import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UtilityBox 
{

    private UtilityBox(){}
    public static void printList(List<String> list) {
        for (String element : list) {
            System.out.println(element);
        }
    }
    public static String ListToString(List<String> list) {
        String result = "";
        for (String element : list) {
            result += " " + element;
        }
        return result;
    }

    public static void printStringArray(String[] array) 
    {
        for (String str : array) {
            System.out.println(str);
        }
    }
    public static void printStringArray(String[][] array , String[] rowID) 
    {
        int i = 1;
        for (String[] s  : array) {
            System.out.printf("%d\t%s " , i , rowID[i-1]);
            for (String ss : s){
                System.out.print(ss);
                System.out.print(" ");
            }
            System.out.println("\n\n");
            i++;
        }
    }
    

    public static boolean contains(String[] arr , String target)
    {
        for (int i = 0 ; i < arr.length ; i ++)
        {
            if (arr[i] == null)
            {
                continue;
            }
            if (arr[i].equals(target))
            {
                return true;
            }
            
        }
        return false;
    }
    public static char[] convertListToArray(List<Character> charList) {
        // Check for null or empty list
        if (charList == null || charList.isEmpty()) {
            return new char[0]; // Return an empty array
        }

        // Convert List<Character> to char[]
        char[] charArray = new char[charList.size()];
        for (int i = 0; i < charList.size(); i++) {
            charArray[i] =Character.toUpperCase(charList.get(i));
        }

        return charArray;
    }
    public static boolean contains(char[] arr , char target)
    {
        for (int i = 0 ; i < arr.length ; i ++)
        {
            
            if (arr[i] == target)
            {
                return true;
            }
            
        }
        return false;
    }
    public static int getLengthWithoutRepetition(String[] array) 
    {
        // Use a HashSet to keep track of unique elements
        Set<String> uniqueElements = new HashSet<>();

        // Add each element of the array to the HashSet
        for (String element : array) 
        {
            uniqueElements.add(element);
        }

        // Return the size of the HashSet, which represents the length without repetition
        return uniqueElements.size();
    }
    public static <T> int getLengthWithoutRepetition(List<T> list) 
     {
        // Use a HashSet to keep track of unique elements
        Set<T> uniqueElements = new HashSet<>(list);

        // Return the size of the HashSet, which represents the length without repetition
        return uniqueElements.size();
    }
    public static String removePrefix(String input) {
        // Assuming the prefix ends with a space
        int spaceIndex = input.indexOf(' ');
        
        if (spaceIndex != -1) {
            return input.substring(spaceIndex + 1);
        } else {
            return input; // If there is no space, return the original string
        }
    }
    public static void iterateSortedArray(UM_Alani[] array , UM_Tree tree) {
        iterateSortedArray(array, 0, array.length - 1 , tree);
    }

    private static void iterateSortedArray(UM_Alani[] array, int start, int end , UM_Tree tree) {
        if (start <= end) {
            int middle = (start + end) / 2;
            Node node = new Node(array[middle]);
            tree.insert(node);
            

            iterateSortedArray(array, start, middle - 1,tree); // Left half
            iterateSortedArray(array, middle + 1, end,tree);   // Right half
        }
    }
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    
    
    
}
