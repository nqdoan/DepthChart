package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LoadPlayers {

    public void loadPlayers(){
        System.out.println("We're in LoadPlayers");
        try(BufferedReader buffread = new BufferedReader(new FileReader("OfficialWebsiteTestData.txt"))){
            String input = buffread.readLine();
            System.out.println(input);
            System.out.println("we're in the file");

            while((input = buffread.readLine()) != null){

            }
        } catch(IOException e){

        }
        /*
        StringTokenizer st = new StringTokenizer(test, "\\t");
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
        */
    }

}
