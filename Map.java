/**
 * The Map class represents a single hex tile on the Catan board.
 * Each tile has a specific type (e.g., forest, hill), a dice number
 * for production, and may contain the thief.
 */
public class Map {

    /*
    * Global static variable
    * */
    final static int FIELD = 0; // grain
    final static int FOREST = 1; // lumber
    final static int PASTURE = 2; // wool
    final static int MOUNTAIN= 3; // ore
    final static int HILL = 4; // brick
    final static int DESERT = 5; // no resource

    /*
    * private variable
    * */
    private int type;
    private int diceNum;
    private int thief;

    /*
     * Constructs a new Map tile with a given type.
     * Initializes dice number to 0 and thief to -1 (not present).
     *
     * @param type The resource type of the tile (use constants).
     */
    Map(int type) {

        this.type = type;
        this.diceNum = 0;
        this.thief = -1;
    }

    /*
     * Returns the resource type of the tile.
     *
     * @return An integer representing the type (e.g., FIELD, FOREST).
     */
    public int GetType() {
        return this.type;
    }

    /*
     * Sets the dice number associated with this tile.
     * The number determines which dice roll activates the tile.
     *
     * @param num The dice number to assign (2–12, excluding 7 typically).
     */
    public void SetDiceNum(int num) {
        this.diceNum = num;
    }

    /*
     * Returns the dice number assigned to this tile.
     *
     * @return The dice number (0 if unset).
     */
    public int GetDiceNum() {
        return this.diceNum;
    }

    /*
     * Returns the ID of the player who currently has the thief on this tile.
     * -1 indicates no thief is present.
     *
     * @return The ID of the player with the thief, or -1 if none.
     */
    public int GetThief() {
        return this.thief;
    }


    /*
     * Sets the ID of the player placing the thief on this tile.
     *
     * @param num The player ID, or -1 to remove the thief.
     */
    public void SetThief(int num) {
        this.thief = num;
    }


}
