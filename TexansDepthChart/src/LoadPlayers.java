import java.util.StringTokenizer;

public class LoadPlayers {

    String test = "LWR  10  Hopkins, DeAndre 13/1";

    public void loadPlayers(){

        System.out.println(test);
        StringTokenizer st = new StringTokenizer(test, "\\t");
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }

}
