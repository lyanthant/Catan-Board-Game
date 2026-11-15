/*
 * The Buildable class is an abstract base class for all
 * buildable structures in the game, such as roads, settlements,
 * and cities.
 */
public abstract class Buildable {

    /*
    * private variable
    * */
    private int playerId;

    /*
     * Constructs a Buildable object assigned to a player.
     *
     * @param playerId The ID of the player who owns the structure.
     */
    public Buildable(int playerId) {
        this.playerId = playerId;

    }

    /*
     * Returns the player ID that owns this buildable object.
     *
     * @return Player ID.
     */
    public int GetPlayerId() {
        return this.playerId;

    }

    /*
     * Abstract method to return the point value of the structure.
     *
     * @return Point value contributed by this structure.
     */
    public abstract int GetPoint();
}
