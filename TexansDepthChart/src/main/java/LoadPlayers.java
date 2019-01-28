/*
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

    public void loadPlayers(){
        String filePath = "TexansDepthChart/src/main/resources/OurLadTestData.txt";
        List<Player> player = new ArrayList();
        String position = "";
        String number = "";
        String name = "";
        int depth = 0;
        String unit = "";

        try(BufferedReader buffread = new BufferedReader(new FileReader(filePath))){
            String input;
            StringTokenizer st;
            int depthCounter = 1;

            while((input = buffread.readLine()) != null) {
                System.out.println(input);
                st = new StringTokenizer(input);
                */
/*System.out.println(st.toString());*//*

                while(st.hasMoreTokens()) {
                    String cursorPosition = st.nextToken();
                    if(cursorPosition.equals("OFFENSE"))
                        unit = "OFFENSE";
                    else if(checkUppercase(cursorPosition) && (cursorPosition.length() < 4))
                        position = cursorPosition;
                    else
                        number = st.nextToken();
                        name = st.nextToken();
                        depth = depthCounter;
                        depthCounter++;
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
    */
/*
                        else if(st.nextToken().equals("DEFENSE"))
                        unit = "DEFENSE";
                    else if(st.nextToken().equals("SPECIAL TEAMS"))
                        unit = "SPECIAL TEAMS";
                    else if(st.nextToken().equals("PRACTICE SQUAD"))
                        unit = "PRACTICE SQUAD";
                    else if(st.nextToken().equals("RESERVES"))
                        unit = "RESERVES";
                        *//*



}
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class ReadFile {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("c:/test.csv"));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                StringTokenizer stringTokenizer = new StringTokenizer(line, "|");
                while (stringTokenizer.hasMoreElements()) {
                    Integer id = Integer.parseInt(stringTokenizer.nextElement().toString());
                    Double price = Double.parseDouble(stringTokenizer.nextElement().toString());
                    String username = stringTokenizer.nextElement().toString();
                    StringBuilder sb = new StringBuilder();
                    sb.append("\nId : " + id); sb.append("\nPrice : " + price); sb.append("\nUsername : " + username); sb.append("\n*******************\n");
                    System.out.println(sb.toString());
                }
            }
            System.out.println("Done");
        } catch (IOException e) { e.printStackTrace();
        }
        finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) { ex.printStackTrace();
            }
        }
    }
}
