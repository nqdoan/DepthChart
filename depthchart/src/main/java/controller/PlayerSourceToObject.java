package controller;

import model.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PlayerSourceToObject {

    String filePath = "src/main/resources/OurLadTestData.txt";
    List<Player> playerList = new ArrayList<Player>();


    public void loadPlayers() {
        BufferedReader buffReader = null;
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
        Iterator<Player> playerIterator = playerList.iterator();
        while(playerIterator.hasNext()){
            Player displayPlayer = new Player();
            displayPlayer = playerIterator.next();
            System.out.println(displayPlayer.getPosition());
            System.out.println(displayPlayer.getNumber());
            System.out.println(displayPlayer.getName());
            System.out.println(displayPlayer.getDepth());
            System.out.println(displayPlayer.getTeam());
            System.out.println(displayPlayer.getUnit());
            System.out.println(displayPlayer.getYear());
        }
    }

    public void cleanThirdCellFromPlayerName(){
        for(Player currentInstance: playerList){
            String name = currentInstance.getName();
            String[] stringSplit = name.split(" ");
            name = stringSplit[0] + " " + stringSplit[1];
            currentInstance.setName(name);


        }
    }

    public List<Player> returnPlayerList(){
        loadPlayers();
        cleanThirdCellFromPlayerName();
        displayPlayers();
        return playerList;
    }
}

