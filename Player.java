/*
 * It stores the player's unique ID and their current victory point score.
 */
public class Player {

    /*
    * Private variable
    * */
    private int playerId;
    private int score;

    /*
     * Constructs object with the specified ID.
     * The player's score is initialized to zero.
     *
     * @param id The unique identifier for the player.
     */
    public Player(int id) {
        this.playerId = id;
        this.score = 0;
    }

    /*
     * Returns the player's ID.
     */
    public int GetId() {
        return this.playerId;
    }

    /*
     * Increases the player's score by the given amount.
     *
     * @param score The number of points to add to the player's score.
     */
    public void SetScore(int score) {
        this.score += score;
    }

    /*
     * Returns the player's current score (victory points).
     *
     * @return The current score.
     */
    public int GetScore() {
        return this.score;
    }


}
