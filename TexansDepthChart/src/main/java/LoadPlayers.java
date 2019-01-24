package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class LoadPlayers {

    public void loadPlayers(){
        String filePath = "src/main/resources/OurLadTestData.txt";
        List<Player> player = new ArrayList();
        String position = "";
        String number = "";
        String name = "";
        int depth = 0;
        String unit = "";
  

        try(BufferedReader buffread = new BufferedReader(new FileReader(filePath))){
            String input;
            int depthCounter = 1;
            while((input = buffread.readLine()) != null){
                StringTokenizer st = new StringTokenizer(input, "\t");
                while(st.hasMoreTokens() == true){
                    if(st.nextToken().equals("OFFENSE"))
                        unit = "OFFENSE";
                    else if(st.nextToken().equals("DEFENSE"))
                        unit = "DEFENSE";
                    else if(st.nextToken().equals("SPECIAL TEAMS"))
                        unit = "SPECIAL TEAMS";
                    else if(st.nextToken().equals("PRACTICE SQUAD"))
                        unit = "PRACTICE SQUAD";
                    else if(st.nextToken().equals("RESERVES"))
                        unit = "RESERVES";
                    else if(checkUppercase(st.nextToken()) == true && (st.nextToken().length() < 5))
                        position = st.nextToken();
                    else
                        number = st.nextToken();
                        name = st.nextToken();
                        depth = depthCounter;
                        depthCounter++;
                    System.out.println(st.nextToken());
                }
                player.add(setPlayer(position, number, name, depth, unit));
                depthCounter = 1;
            }
        } catch(IOException e){
            System.out.println("File not found.");
        } catch(NoSuchElementException f)
        {
            System.out.println("No more tokens in this tokenizers string.");
        }
    }


    public boolean checkUppercase(String input){
        if(input.equals(input.toUpperCase()))
            return true;
        else
            return false;
    }

    public Player setPlayer(String position, String number, String name, int depth, String unit){
        Player player = new Player();

        player.setPosition(position);
        player.setNumber(number);
        player.setName(name);
        player.setDepth(depth);
        player.setTeam("Texans");
        player.setUnit(unit);
        player.setYear(2017);

        return player;
    }

}
