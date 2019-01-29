package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import main.java.Player;


public class LoadPlayers {

    public void loadPlayers() {
        BufferedReader buffReader = null;
        String filePath = "TexansDepthChart/src/main/resources/OurLadTestData.txt";
        List<Player> playerList = new ArrayList();
        String position = "";
        Integer depth = 0;
        Integer number;
        String unit = "";
        int depthCounter = 1;

        try {
                buffReader = new BufferedReader(new FileReader(filePath));
                String input;
                while((input = buffReader.readLine()) != null) {
                        StringTokenizer stringTokenizer = new StringTokenizer(input, "\t");
                        while(stringTokenizer.hasMoreElements()){
                            String nextInput = stringTokenizer.nextElement().toString();
                            if(nextInput.equals("OFFENSE")){
                                unit = "OFFENSE";}
                            else if(nextInput.equals("DEFENSE")){
                                unit = "DEFENSE";}
                            else if(nextInput.equals("SPECIAL TEAMS")){
                                unit = "SPECIAL TEAMS";}
                            else if(nextInput.equals("PRACTICE SQUAD")){
                                unit = "PRACTICE SQUAD";}
                            else if(nextInput.equals("RESERVES")) {
                                unit = "RESERVES"; }
                            else if(checkUppercase(nextInput) && nextInput.length() < 5 && (isStringInt(nextInput)) == false) {
                                position = nextInput;
                                depthCounter = 1;
                            }
                            else{
                                number = Integer.parseInt(nextInput);
                                String name = stringTokenizer.nextElement().toString();
                                depthCounter++;
                                playerList.add(setPlayer(position, number, name, depthCounter, unit));
                            }
                    }
                }

        } catch (IOException e) {
            System.out.println("File not found.");
        } catch (NoSuchElementException f) {
            System.out.println("No more tokens in this tokenizers string.");
        }
    }

    public boolean isStringInt(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch(NumberFormatException e) {
            return false;
        }
    }

    public boolean checkUppercase(String input){
        if(input.equals(input.toUpperCase()))
            return true;
        else
            return false;
    }

    public Player setPlayer(String position, int number, String name, int depth, String unit){
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

    public void displayPlayers(){

    }
}

