/*
 * The Resource class manages both basic resource types and development cards
 * for a player in the game. Each resource and development card is tracked
 * individually with methods for getting and adding quantities.
 */
public class Resource {

    /*
    * private variable
    */
    // resources
    private int wool;
    private int ore;
    private int brick;
    private int grain;
    private int lumber;

    // development card
    private int knight;
    private int roadBuilding;
    private int monopoly;
    private int yearOfPlenty;

    /*
    * Global Variables
    * */

    final static int GRAIN = 0;
    final static int LUMBER = 1;
    final static int WOOL = 2;
    final static int ORE = 3;
    final static int BRICK = 4;

    // development card
    final static int KNIGHT = 5;
    final static int ROADBUILDING = 6;
    final static int MONOPOLY = 7;
    final static int YEAROFPLENTY = 8;

    private int id;

    /*
     * Constructs a Resource object with an associated player ID.
     * Initializes all resource and development card quantities to zero.
     *
     * @param id The ID of the player who owns these resources.
     */
    Resource(int id) {
        this.id = id;
        this.wool = 0;
        this.ore = 0;
        this.brick = 0;
        this.grain = 0;
        this.lumber = 0;
        this.knight = 0;
        this.roadBuilding = 0;
        this.monopoly = 0;
        this.yearOfPlenty = 0;

    }

    /*
     * Returns the ID of the resource owner.
     *
     * @return The player ID.
     */
    public int GetId() {
        return this.id;
    }

    /*
     * Adds to the player's wool total.
     * @param num Amount to add (can be negative to subtract).
     */

    public void SetWool(int num) {
        this.wool += num;
    }

    /*
     * Returns the current wool quantity.
     * @return Wool count.
     */
    public int GetWool() {
        return this.wool;
    }

    /*
     * Adds to the player's ore total.
     * @param num Amount to add (can be negative to subtract).
     */
    public void SetOre(int num) {
        this.ore += num;
    }

    /*
     * Returns the current ore quantity.
     * @return Ore count.
     */
    public int GetOre() {
        return this.ore;
    }

    /*
     * Adds to the player's brick total.
     * @param num Amount to add (can be negative to subtract).
     */
    public void SetBrick(int num) {
        this.brick += num;
    }

    /*
     * Returns the current brick quantity.
     * @return Brick count.
     */
    public int GetBrick() {
        return this.brick;
    }

    /*
     * Adds to the player's grain total.
     * @param num Amount to add (can be negative to subtract).
     */
    public void SetGrain(int num) {
        this.grain += num;
    }

    /*
     * Returns the current grain quantity.
     * @return Grain count.
     */
    public int GetGrain() {
        return this.grain;
    }

    /*
     * Adds to the player's lumber total.
     * @param num Amount to add (can be negative to subtract).
     */
    public void SetLumber(int num) {
        this.lumber += num;
    }

    /*
     * Returns the current lumber quantity.
     * @return Lumber count.
     */
    public int GetLumber() {
        return this.lumber;
    }

    /*
     * Adds to the player's knight card total.
     * @param knight Amount to add.
     */
    public void SetKnight(int knight) {
        this.knight += knight;
    }

    /*
     * Returns the current knight card quantity.
     * @return Knight card count.
     */
    public int GetKnight() {
        return this.knight;
    }

    /*
     * Adds to the player's road building card total.
     * @param roadBuilding Amount to add.
     */
    public void SetRoadBuilding(int roadBuilding) {
        this.roadBuilding += roadBuilding;
    }

    /*
     * Returns the current road building card quantity.
     * @return Road building card count.
     */
    public int GetRoadBuilding() {
        return this.roadBuilding;
    }

    /*
     * Adds to the player's monopoly card total.
     * @param monopoly Amount to add.
     */
    public void SetMonopoly(int monopoly) {
        this.monopoly += monopoly;
    }

    /*
     * Returns the current monopoly card quantity.
     * @return Monopoly card count.
     */
    public int GetMonopoly() {
        return this.monopoly;
    }

    /*
     * Adds to the player's year of plenty card total.
     * @param yearOfPlenty Amount to add.
     */
    public void SetYearOfPlenty(int yearOfPlenty) {
        this.yearOfPlenty += yearOfPlenty;
    }

    /*
     * Returns the current year of plenty card quantity.
     * @return Year of plenty card count.
     */
    public int GetYearOfPlenty() {
        return this.yearOfPlenty;
    }

}
