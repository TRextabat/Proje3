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
    
    
}
