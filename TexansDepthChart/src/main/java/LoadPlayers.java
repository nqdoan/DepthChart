import java.util.StringTokenizer;

public class LoadPlayers {

    String test = "DeAndre Hopkins";

    public void loadPlayers(){

        FileReader file = new FileReader("OfficialWebsiteTestData.txt")

        System.out.println(test);
        StringTokenizer st = new StringTokenizer(test, "\\t");
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }

}
