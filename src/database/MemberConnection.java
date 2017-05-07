package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Bricks.Member;
import Bricks.City;
import Bricks.Membership;
import Bricks.Perk;

/**
 *
 * @author Pelle
 */
public class MemberConnection {
        
	
    private final Connection connection = DBconnection.createConnection();

    /**
     * gets newest MemberID
     * @return int of newest MemberID
     */
    public int getNewestMemberID()
    {
        String sqlMemberID = "SELECT MAX(memberid) FROM `member`";
        int memberID = -1;
        Statement statement;
        try {
            statement = connection.createStatement();
        
        ResultSet memberIDResult = statement.executeQuery(sqlMemberID);
        
        while(memberIDResult.next()) {
            
            memberID = memberIDResult.getInt("MAX(memberid)");
            
        }
        statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(MemberConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return memberID;
    }
    
    /**
     * create a member
     * @param member
     * @throws SQLException
     */
    public void createMember(Member member) throws SQLException {
        
        int memberID = 0;
        String sql = "INSERT INTO member (CPR, fName, lName, streetName, streetnumber, email,"
                + " phoneNumber, FK_postalCode, balance, signupdate"
                + ", fk_membershipID, acc_reg, acc_num, picture, enddate, membershipStartDate, comments) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setString(1, member.getCPR());
        preparedStatement.setString(2, member.getfName());
        preparedStatement.setString(3, member.getlName());
        preparedStatement.setString(4, member.getStreetName());
        preparedStatement.setString(5, member.getStreetNumber());
        preparedStatement.setString(6, member.getEmail());
        preparedStatement.setString(7, member.getPhoneNumber());
        preparedStatement.setString(8, member.getCity().getPostelCode());
        preparedStatement.setDouble(9, member.getBalance());
        preparedStatement.setTimestamp(10, new java.sql.Timestamp(System.currentTimeMillis()));
        preparedStatement.setInt(11, member.getMembership().getMembershipID());
        preparedStatement.setString(12, member.getRegistration());
        preparedStatement.setString(13, member.getAccountNumber());
        preparedStatement.setString(14, member.getImg());
        preparedStatement.setString(15, member.getEndDate());
        preparedStatement.setString(16, member.getMembershipStartDate());
        preparedStatement.setString(17, member.getComment());
        //insert member
        preparedStatement.executeUpdate();
        
        //get memberid
        
        memberID = getNewestMemberID();
        //Insert perks
        String sqlSetPerks = "INSERT INTO selectedperks (fk_memberID, fk_perkID) VALUES (?,?)";
        
        PreparedStatement perkPreparedStatement = connection.prepareStatement(sqlSetPerks);
        for(int i = 0; i < member.getPerkList().size(); i++) {
            
            perkPreparedStatement.setInt(1, memberID);
            perkPreparedStatement.setInt(2, member.getPerkList().get(i).getPerkID());
            perkPreparedStatement.executeUpdate();
           
        }
        perkPreparedStatement.close();
        
        
        
        
    }
    
    /**
     * serach for memberID
     * @param memberID
     * @return Member
     */
    public Member searchMemberID(int memberID) {
        Member searchedMember = null;
        
        City city = null;
        Membership membership = null;
        Perk perk = null;
        ArrayList<Perk> perkList = new ArrayList();
        try {
        Statement statement = connection.createStatement();
        //get city from DB
        String sqlGetCity = "SELECT postalCode, cityname, municipal FROM city" 
                        + " INNER JOIN member"
                        + " ON postalCode = fk_postalCode "
                        + " WHERE memberid = " + memberID;
        
        ResultSet cityResult = statement.executeQuery(sqlGetCity);
        
        
        while(cityResult.next()) {
        
            city = new City(cityResult.getString("postalCode"), cityResult.getString("cityname"), cityResult.getString("municipal"));
        }
        //get membership
        String sqlGetMembership = "SELECT * FROM membership WHERE (SELECT fk_membershipID FROM member WHERE memberID ="
                + " '" + memberID + "')";
        
        ResultSet membershipResult = statement.executeQuery(sqlGetMembership);
        
        while(membershipResult.next()) {
        
            membership = new Membership(membershipResult.getInt("membershipID"), membershipResult.getString("membershipname"), 
            membershipResult.getDouble("price"), membershipResult.getInt("duration"));
        }

        String sqlGetPerk = "SELECT perkid, perkname, perkprice FROM perk"
                + " INNER JOIN selectedperks"
                + " ON perkid = fk_perkid WHERE fk_memberID =" + memberID;
                
        ResultSet perkResult = statement.executeQuery(sqlGetPerk);
        
        while(perkResult.next()) {
        
            perk = new Perk(perkResult.getString("perkname"), perkResult.getInt("perkprice"), perkResult.getInt("perkid"));
            perkList.add(perk);
        }
        String sql = "SELECT memberID, fName, lName, CPR, streetName, streetNumber, email, phonenumber, membershipStartDate,"
                + " balance, (SELECT membershipName FROM `membership` WHERE membershipID = '" + memberID + "') "
                + "AS membershipName, acc_reg, acc_num, comments, endDate, picture"
                + " FROM member WHERE memberID = '" + memberID + "'";
        
        ResultSet memberResult = statement.executeQuery(sql);
        
        while(memberResult.next()) {
            searchedMember = new Member(memberResult.getInt("memberID"), memberResult.getString("CPR"), memberResult.getString("fName"), memberResult.getString("lName")
            , memberResult.getString("streetName"), memberResult.getString("streetNumber"), memberResult.getString("email")
            , memberResult.getString("phonenumber"), city, memberResult.getInt("balance"), memberResult.getString("comments"),
                    memberResult.getString("membershipStartDate"), memberResult.getString("endDate"), memberResult.getString("acc_reg"),
                    memberResult.getString("acc_num"), membership, memberResult.getString("picture"),perkList ); 
                    

            
        }
        statement.close();
    
        }catch(Exception e) {
            System.err.println(e);
            
        }
        return searchedMember;
    }

    /**
     * gets membershiplist
     * @return a List of Membership
     */
    public List getMembershipList() {
    
        //List is an interface, you cannot initialize it. ArrayList implements List, so you can assign an ArrayList instance to a List variable. Det er nemere da hvis man vil ændre arraylist linkedlist er det muligt.
        List<Membership> list = new ArrayList();
        Statement statement;
       try {
           statement = connection.createStatement();

        String sql = "SELECT membershipID, membershipname, price, duration FROM membership";
                
        ResultSet result = statement.executeQuery(sql);
        
        while(result.next()) {
            
            Membership m = new Membership(result.getInt("membershipID"), result.getString("membershipname"),
            result.getDouble("price"), result.getInt("duration"));
            
             list.add(m);
        }
        statement.close();
        
       } catch (SQLException ex) {
           Logger.getLogger(MemberConnection.class.getName()).log(Level.SEVERE, null, ex);
       }
        return list;
    }
    
    /**
     * gets perk
     * @param id
     * @return a perk
     */
    public Perk getPerk(int id) {
        Perk perk = null;
        try {
            String sql = "SELECT * FROM perk WHERE perkID='"+id+"'";
            Statement statement;
            statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            
            while(rs.next()) {
                perk = new Perk(rs.getString("perkname"), rs.getDouble("perkprice"), rs.getInt("perkid"));
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(MemberConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return perk;
    }
    
    /**
     * gets city
     * @param postalcode
     * @return City
     */
    public City getCity(String postalcode) {
        City city = null;
        try {
            String sql = "SELECT * FROM city WHERE postalcode='"+postalcode+"'";
            Statement statement;
            statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()) {
                city = new City(rs.getString("postalcode"), rs.getString("cityname"), rs.getString("municipal"));
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(MemberConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return city;
    }
    
    /**
     * edit a member
     * @param member
     */
    public void editMember(Member member) {
    
                   String sql = "UPDATE member SET"
                    + " CPR = ?,"
                    + " fName = ?,"
                    + "lName = ?,"
                    + "streetName = ?,"
                    + "streetNumber = ?,"
                    + "email = ?,"
                    + "phonenumber= ?,"
                    + "acc_reg= ?, "
                    + "acc_num = ?,"
                    + "comments = ?,"
                    + "fk_postalcode = ?"
                   + "WHERE memberID = " + member.getMemberID();
                   
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, member.getCPR());
            preparedStatement.setString(2, member.getfName());
            preparedStatement.setString(3, member.getlName());
            preparedStatement.setString(4, member.getStreetName());
            preparedStatement.setString(5, member.getStreetNumber());
            preparedStatement.setString(6, member.getEmail());
            preparedStatement.setString(7, member.getPhoneNumber());
            preparedStatement.setString(8, member.getRegistration());
            preparedStatement.setString(9, member.getAccountNumber());
            preparedStatement.setString(10, member.getComment());
            preparedStatement.setString(11, member.getCity().getPostelCode());
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MemberConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
                   
    }

    /**
     * edit a membership
     * @param member
     */
    public void editMembership(Member member)
    {
        String sql = "UPDATE member SET "
                + "fk_membershipId = ?,"
                + "membershipStartDate = ?,"
                + "endDate = ?,"
                + "balance = ?"
                + "WHERE memberId = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, member.getMembership().getMembershipID());
            preparedStatement.setString(2, member.getMembershipStartDate());
            preparedStatement.setString(3, member.getEndDate());
            preparedStatement.setDouble(4, member.getBalance());
            preparedStatement.setInt(5, member.getMemberID());
            
            preparedStatement.executeUpdate();
            
           
            String sql1 = "DELETE "
                    + "FROM selectedPerks "
                    + "WHERE fk_memberID = ?";
            
            preparedStatement = connection.prepareStatement(sql1);
            
            preparedStatement.setInt(1, member.getMemberID());
            
            preparedStatement.executeUpdate();
            
            String sqlSetPerks = "INSERT INTO selectedperks (fk_memberID, fk_perkID) VALUES (?,?)";
        
        PreparedStatement perkPreparedStatement = connection.prepareStatement(sqlSetPerks);
        
        for(int i = 0; i < member.getPerkList().size(); i++) {
            
            perkPreparedStatement.setInt(1, member.getMemberID());
            perkPreparedStatement.setInt(2, member.getPerkList().get(i).getPerkID());
            perkPreparedStatement.executeUpdate();
        }
        }
        catch (SQLException ex) {
            Logger.getLogger(MemberConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method gets memberID by CPR
     * @param cpr
     * @return in of memberID
     */
    public int memberExist(String cpr) {
    
        String sql = "SELECT memberID FROM member WHERE cpr = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cpr);
            
            ResultSet result = preparedStatement.executeQuery();
            
            if(result.first()) {
                return result.getInt("memberid");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return -1;
    } 
}
