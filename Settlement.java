/*
 * The Settlement class represents a basic structure built by a player
 * in the game. Settlements provide resources from adjacent tiles
 * and contribute points toward victory.
 */
public class Settlement extends Buildable{

    /*
     * Constructs a Settlement object for the specified player.
     *
     * @param playerId The ID of the player who owns the settlement.
     */
    public Settlement(int playerId) {
        super(playerId);

    }

    /*
     * Returns the point value of a settlement.
     * Settlements are worth 1 point.
     *
     * @return 1 (point value of a settlement).
     */
    @Override
    public int GetPoint() {
        return 1;
    }


}
