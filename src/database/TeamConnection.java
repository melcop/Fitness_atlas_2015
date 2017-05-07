package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Bricks.Instructor;
import Bricks.Member;
import Bricks.Team;

/**
 *
 * @author Pelle & Charlie
 */
public class TeamConnection {
    
    private final Connection connection = DBconnection.createConnection();
    
    /**
     * save  information from TeamGUI to DB
     * @param team
     */
    public void saveTeamToDB(Team team) {
    
        String sql = "INSERT INTO team (teamName, time, maxParticipants, fk_instructorID) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, team.getTeamName());
            preparedStatement.setString(2, team.getTime());
            preparedStatement.setString(3, team.getMaxParticipants());
            preparedStatement.setInt(4, team.getInstructor().getInstructorID());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InstructorConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    /**
     * gets teamlist
     * @return List of team
     */
    public List getTeamList() {
        
            List<Team> teamList = new ArrayList();
            Team team;
            Instructor instructor;
            String sql = "SELECT teamID, teamName, time, maxParticipants, fk_instructorID, "
                    + " (SELECT fName FROM instructor WHERE instructorID = fk_instructorID) AS fName,"
                    + " (SELECT lName FROM instructor WHERE instructorID = fk_instructorID) AS lName FROM team";
            
        try {
            Statement statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()) {
            
                instructor = new Instructor(null ,result.getString("fName"),result.getString("lName"),null, null, null, null, null, result.getInt("fk_instructorID"),null);
                team = new Team(result.getInt("teamID"), result.getString("teamName"), result.getString("time"), result.getString("maxParticipants"), instructor);
                teamList.add(team);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TeamConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teamList;
            
        }

    /**
     * gets participants
     * @param team
     * @return List of participants
     */
    public List getParticipants(Team team) {
        
            List<Member> participantList = new ArrayList();
            Member member;
            
            String sql = "SELECT memberID, fname, lName FROM member\n" +
"                           INNER JOIN selectedteams\n" +
"                           ON member.memberid = selectedteams.fk_memberid\n" +
"                           WHERE fk_teamid =" + team.getTeamID();
            
            try {
            Statement statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()) {
            
                member = new Member(result.getInt("memberID"), null, result.getString("fName"), result.getString("lName"),
                        null, null, null, null, null, 0, null, null, null, null, null, null, null, null);
                participantList.add(member);
            }
            } catch (SQLException ex) {
            Logger.getLogger(TeamConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
            return participantList;
        }
        
    /**
     * add participants to Team
     * @param memberID
     * @param teamID
     */
    public void addParticipantToTeam(int memberID, int teamID) {
           
            
            String sql ="INSERT INTO selectedteams (fk_memberID, fk_teamID) VALUES (?, ?)";
            
            try{
            
                PreparedStatement preparedstament = connection.prepareStatement(sql);
                preparedstament.setInt(1, memberID);
                preparedstament.setInt(2, teamID);
                
                preparedstament.executeUpdate();
                
            
            } catch (SQLException ex) {
            Logger.getLogger(TeamConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    /**
     * remove participant from team
     * @param teamID
     * @param memberID
     */
    public void removeParticipantFromTeam(int teamID, int memberID) {
        
            String sql = "DELETE FROM selectedteams WHERE fk_teamID = ? AND fk_memberID = ?";
            try {
            PreparedStatement preparedstament = connection.prepareStatement(sql);
            
            preparedstament.setInt(1, teamID);
            preparedstament.setInt(2, memberID);
            
            preparedstament.executeUpdate();
            
            } catch (SQLException ex) {
            Logger.getLogger(TeamConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    /**
     * remove team
     * @param teamID
     */
    public void removeTeam(int teamID) {
        
            String sql = "DELETE FROM team WHERE teamid = ?";
            
            try {
            PreparedStatement preparedstament = connection.prepareStatement(sql);
            
            preparedstament.setInt(1, teamID);
            
            preparedstament.executeUpdate();
            
            } catch (SQLException ex) {
            Logger.getLogger(TeamConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    /**
     * edit team data
     * @param team
     */
    public void editTeam(Team team) {
        
            String sql = "UPDATE team SET"
                    + " teamName = ?,"
                    + "time = ?,"
                    + "maxparticipants = ?,"
                    + "fk_instructorID = ? "
                    + "WHERE teamID = ?";
            
           
            try {
            PreparedStatement preparedstament = connection.prepareStatement(sql);
            
            preparedstament.setString(1, team.getTeamName());
            preparedstament.setString(2, team.getTime());
            preparedstament.setString(3, team.getMaxParticipants());
            preparedstament.setInt(4, team.getInstructor().getInstructorID());
            preparedstament.setInt(5, team.getTeamID());
            preparedstament.executeUpdate();
            
            } catch (SQLException ex) {
            Logger.getLogger(TeamConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    /**
     * gets the member of a team
     * @param memberID
     * @return List of Team object
     */
    public List<Team> getMemberTeamList(int memberID)
        {
            List<Team> list = new ArrayList();
            
            
            String sql = "SELECT teamID, teamName, time, maxParticipants FROM team "
                    + "INNER JOIN selectedTeams "
                    + "ON teamID = fk_teamID "
                    + "WHERE fk_memberID = ?";
            
        try {          
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            
            preparedStatement.setInt(1, memberID);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
                
                Team team = new Team(resultSet.getInt("teamID"), resultSet.getString("teamName"), resultSet.getString("time"), resultSet.getString("maxParticipants"), null);
                list.add(team);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeamConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return list;
        }
        
}
