package controller;

import model.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerObjectToDatabase {

    public Connection getConnection() {
        String username = "nqdoan";
        String password = "Sparta123!";
        String url = "jdbc:mysql://nqdoandb.celtpg05ihar.us-east-1.rds.amazonaws.com:3306/";

        // Connect to MySQL
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.out.println("Connection Failed!" + e.getMessage());
        }
        if (connection != null) {
            System.out.println("You are connected.");
        } else {
            System.out.println("Failed to make connection.");
        }

        return connection;
    }


    public void loadPlayers(){
        PlayerSourceToObject psto = new PlayerSourceToObject();
        List<Player> playerList = new ArrayList<Player>();
        playerList = psto.returnPlayerList();

        Iterator<Player> playerIterator = playerList.iterator();
        while(playerIterator.hasNext()){
            Player currentPlayer = new Player();
            currentPlayer = playerIterator.next();
            insert(currentPlayer.getPosition(),   currentPlayer.getNumber(),  currentPlayer.getName(),  currentPlayer.getDepth(), currentPlayer.getTeam(),  currentPlayer.getUnit(),  currentPlayer.getYear());
        }




        }


    public void insert(String position, int number, String name, int depth, String team, String unit, int year) {

        String sql = "INSERT INTO player(position, number, name, depth, team, unit, year) VALUES (?,?,?,?,?,?,?)";
        String useDatabase = "USE depthchart";
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, position);
            pstmt.setInt(2, number);
            pstmt.setString(3, name);
            pstmt.setInt(4, depth);
            pstmt.setString(5, team);
            pstmt.setString(6, unit);
            pstmt.setInt(7, year);
            pstmt.execute(useDatabase);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }
}






