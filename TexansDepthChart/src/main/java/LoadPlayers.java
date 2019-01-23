package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LoadPlayers {

    public void loadPlayers(){
        String filePath = "src/main/resources/OurLadTestData.txt";
        Player player = new Player();
        String position = "";
        int number = 0;
        String name = "";
        int depth = 0;
        String team = "";
        String unit = "";
        int year = 0;


        try(BufferedReader buffread = new BufferedReader(new FileReader(filePath))){
            String input;
            while((input = buffread.readLine()) != null){
                StringTokenizer st = new StringTokenizer(input, "\t");
                while(st.hasMoreTokens()){
                    if(st.nextToken().equals("OFFENSE"))
                        unit = "OFFENSE";
                    else if(checkUppercase(st.nextToken()) == true)
                        position = st.nextToken();

                    player = setPlayer(position, number, name, depth, team, unit, year);
                    System.out.println(st.nextToken());
                }
            }
        } catch(IOException e){
            System.out.println("File not found.");
        }
    }


    public boolean checkUppercase(String input){
        if(input.equals(input.toUpperCase()))
            return true;
        else
            return false;
    }

    public Player setPlayer(String position, int number, String name, int depth, String team, String unit, int year){
        Player player = new Player();

        player.setPosition(position);
        player.setNumber(number);
        player.setName(name);
        player.setDepth(depth);
        player.setTeam(team);
        player.setUnit(unit);
        player.setYear(year);

        return player;
    }

}
