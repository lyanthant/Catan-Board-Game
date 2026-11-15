/*
 * The Bank class manages the supply of development cards
 * available for players to draw from during the game.
 */

public class Bank {

    /*
    * Global static variable, index of the development card
    * */
    final static int KNIGHT_INDEX = 5;
    final static int ROADBUILDING_INDEX = 6;
    final static int MONOPOLY_INDEX = 7;
    final static int YEAROFPLENTY_INDEX = 8;
    final static int VICTORY_POINT_INDEX = 9;

    /*
    * Private variable
    * */
    private int knight;
    private int roadBuilding;
    private int monopoly;
    private int yearOfPlenty;
    private int victoryPoint;

    /**
     * Constructs a Bank object with default quantities of development cards.
     * - 14 Knight cards
     * - 2 Monopoly cards
     * - 2 Road Building cards
     * - 2 Year of Plenty cards
     * - 5 Victory Point cards
     */
    public Bank() {
        this.knight = 14;
        this.monopoly = 2;
        this.roadBuilding = 2;
        this.yearOfPlenty = 2;
        this.victoryPoint = 5;
    }

    /*
     * Reduces the number of Knight cards available in the bank.
     *
     * @param num Number of cards to remove.
     */
    public void SetKnight(int num) {
        this.knight = this.knight - num;
    }

    /*
     * Reduces the number of Monopoly cards available in the bank.
     *
     * @param num Number of cards to remove.
     */
    public void SetMonopoly(int num) {
        this.monopoly = this.monopoly - num;
    }

    /*
     * Reduces the number of Road Building cards available in the bank.
     *
     * @param num Number of cards to remove.
     */
    public void SetRoadBuilding(int num) {
        this.roadBuilding = this.roadBuilding - num;
    }

    /*
     * Reduces the number of Year of Plenty cards available in the bank.
     *
     * @param num Number of cards to remove.
     */
    public void SetYearOfPlenty(int num) {
        this.yearOfPlenty = this.yearOfPlenty - num;
    }

    /*
     * Reduces the number of Victory Point cards available in the bank.
     *
     * @param num Number of cards to remove.
     */
    public void SetVictoryPoint(int num) {
        this.victoryPoint = this.victoryPoint - num;
    }

    // -------------------- Getters --------------------

    /*
     * Returns the number of Knight cards remaining in the bank.
     *
     * @return Knight card count.
     */
    public int GetKnight() {
        return this.knight;
    }

    /*
     * Returns the number of Monopoly cards remaining in the bank.
     *
     * @return Monopoly card count.
     */
    public int GetMonopoly() {
        return this.monopoly;
    }

    /*
     * Returns the number of Road Building cards remaining in the bank.
     *
     * @return Road Building card count.
     */
    public int GetRoadBuilding() {
        return this.roadBuilding;
    }

    /*
     * Returns the number of Year of Plenty cards remaining in the bank.
     *
     * @return Year of Plenty card count.
     */
    public int GetYearOfPlenty() {
        return this.yearOfPlenty;
    }

    /*
     * Returns the number of Victory Point cards remaining in the bank.
     *
     * @return Victory Point card count.
     */
    public int GetVictoryPoint() {
        return this.victoryPoint;
    }

}
