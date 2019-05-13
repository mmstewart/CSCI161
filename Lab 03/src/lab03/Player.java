package lab03;

/**
 *
 * @author Marcus
 * @version 9/16/16
 * * The Player class
 * * * Makes methods and a constructor for adding a player to the list.
 * * * * Methods allow the player to get created or get and set the parameters in the default constructor
 * * * * * Used in NDSUBasketball Client.
 */
public class Player {

    public String name;
    public String positionPlayed;
    public String jerseyNumber;

    /**
     *
     * @param name
     * @param positionPlayed
     * @param jerseyNumber
     */
    public Player(String name, String positionPlayed, String jerseyNumber) {
        this.name = name;
        this.positionPlayed = positionPlayed;
        this.jerseyNumber = jerseyNumber;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getPositionPlayed() {
        return positionPlayed;
    }

    /**
     *
     * @return
     */
    public String getJerseyNumber() {
        return jerseyNumber;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param positionPlayed
     */
    public void setPositionPlayed(String positionPlayed) {
        this.positionPlayed = positionPlayed;
    }

    /**
     *
     * @param jerseyNumber
     */
    public void setJerseyNumber(String jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return getClass().getName() + " : " + getName() + " : " + getPositionPlayed()
                + " : " + getJerseyNumber();
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Player)) {
            return false;
        } else {
            Player p = (Player) o;
            return name.equalsIgnoreCase(p.name) && positionPlayed.equalsIgnoreCase(p.positionPlayed) && jerseyNumber.equalsIgnoreCase(p.jerseyNumber);
        }
    }

}
