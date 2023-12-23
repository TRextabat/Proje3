import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {

    private String[] region = { "Akdeniz", "Doğu Anadolu", "Ege", "Güneydoğu Anadolu", "İç Anadolu", "Karadeniz", "Marmara" };
    private String[][] ils = {{"Antalya", "Burdur", "Isparta", "Mersin", "Adana", "Hatay", "Osmaniye", "Kahramanmaraş"},{
        "Malatya", "Erzincan", "Elazığ", "Tunceli", "Bingöl", "Erzurum", 
        "Muş", "Bitlis", "Şırnak", "Kars", "Ağrı", "Ardahan", "Van", "Iğdır", "Hakkari"
    },{"İzmir", "Aydın", "Muğla", "Manisa", "Denizli", "Uşak", "Kütahya", "Afyon"},{"Gaziantep", "Kilis", "Adıyaman", "Şanlıurfa", "Diyarbakır", "Mardin", "Batman", "Siirt"},{"Eskişehir", "Konya", "Ankara", "Çankırı", "Aksaray", 
    "Kırıkkale", "Kırşehir", "Yozgat", "Niğde", "Nevşehir", 
    "Kayseri", "Karaman", "Sivas"},{
        "Bolu", "Düzce", "Zonguldak", "Karabük", "Bartın", "Kastamonu", "Çorum", "Sinop",
        "Samsun", "Amasya", "Tokat", "Ordu", "Giresun", "Gümüşhane", "Trabzon", "Bayburt",
        "Rize", "Artvin"},{ "Çanakkale", "Balıkesir", "Edirne", "Tekirdağ", "Kırklareli",
        "İstanbul", "Bursa", "Yalova", "Kocaeli", "Bilecik", "Sakarya"
    }};
    private List<List<UM_Alani>> miras = new ArrayList<>();
    

    
    public ReadFile(String filePath)
    {
        try 
        {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] element;
            UM_Alani mirasInfo;
            for (int x = 0; x < 7; x++) {
                    List<UM_Alani> innerList = new ArrayList<>();
        

                    miras.add(innerList);
                    }
            while(true)//TODO change
            {
                line = bufferedReader.readLine();
                
                if (line == null)break;
                line = line.replace("(", "@");
                line = line.replace(")", "@");
                element = line.split("@");
                

                mirasInfo = new UM_Alani(UtilityBox.removePrefix(element[0]), Arrays.asList(element[1].split("\\,")), Integer.parseInt(element[2].trim()));
                List<UM_Alani> changedlist;
                String ilName;
                UM_Alani newMiras;
                
                
                for (String item : mirasInfo.getIl_Adlari())
                {
                    
                    String[] itemArray = item.split("\\-");
                    ilName = itemArray[0].trim();
                    
                    for(int i = 0 ; i < region.length ; i++)
                    {
                        for(int j = 0 ; j < ils[i].length ; j++)
                        {
                            if (ils[i][j].equals(ilName))
                            {
                                
                                List<String> newIl = new ArrayList<>();
                                newIl.add(ilName);
                                try{
                                    newMiras = new UM_Alani(itemArray[1], newIl, mirasInfo.getIlan_Yili());
                                }
                                catch(IndexOutOfBoundsException e){
                                    newMiras = mirasInfo;
                                }
                                
                                changedlist = miras.get(i);
                                changedlist.add(newMiras);
                                miras.set(i ,changedlist);
                            }
                        }
                    }
                }
                
            }
            
            
        } catch (IOException e) 
        {
            e.printStackTrace();
        }

    }
    public List<List<UM_Alani>> getMiras()
    {
        return miras;

    }
    public static void printStringArray(String[] array) 
    {
        for (String str : array) {
            System.out.println(str);
        }
    }
    
}
