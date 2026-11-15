/*
 * The City class represents an upgraded settlement in the game.
 * Cities provide more resources and additional points compared to settlements.
 * This class extends the Settlement class.
 */
public class City extends Settlement {

    /*
     * Constructs a City object for the specified player.
     *
     * @param playerId The ID of the player who owns the city.
     */
    public City(int playerId) {
        super(playerId);

    }

    /*
     * Returns the point value of a city.
     * Cities are worth 1 point in this implementation.
     *
     * @return 1 (point value of a city).
     */
    @Override
    public int GetPoint() {
        return 1;
    }

}
