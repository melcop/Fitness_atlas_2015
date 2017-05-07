package Bricks;

/**
 *
 * @author Pelle
 */
public class Team {
    
    private int teamID;
    private String teamName;
    private String time;
    private String maxParticipants;
    private Instructor instructor;

    /**
     * Constructor for Team
     * @param teamID
     * @param teamName
     * @param time
     * @param maxParticipants
     * @param instructor
     */
    public Team(int teamID, String teamName, String time, String maxParticipants, Instructor instructor) {
        this.teamID = teamID;
        this.teamName = teamName;
        this.time = time;
        this.maxParticipants = maxParticipants;
        this.instructor = instructor;
    }
    
    /**
     *  This method gets teamID
     * @return an int of the teamID
     */
    public int getTeamID() {
        return teamID;
    }

    /**
     * sets teamID
     * @param teamID
     */
    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    /**
     * gets teamName
     * @return String with the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     *  sets teamName
     * @param teamName
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     *  gets time
     * @return String of time
     */
    public String getTime() {
        return time;
    }

    /**
     *  sets time
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     *  get maxparticipants
     * @return String of maxparticipants
     */
    public String getMaxParticipants() {
        return maxParticipants;
    }

    /**
     * This method sets maxparticipants
     * @param maxParticipants
     */
    public void setMaxParticipants(String maxParticipants) {
        this.maxParticipants = maxParticipants;
    }
    
    /**
     *  This method get instrutor
     * @return an object of instructor
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * sets instructor
     * @param instructor
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    
    public String toString() {
        return teamName;
        
    }

}
