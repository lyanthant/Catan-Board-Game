/*
 * The Road class represents a road structure built by a player.
 * Roads are used to connect settlements and expand the player's reach,
 * but they do not contribute points directly.
 */
public class Road extends Buildable {

    /*
     * Constructs a Road object owned by a specific player.
     *
     * @param playerId The ID of the player building the road.
     */
    public Road(int playerId) {
        super(playerId);

    }


    /*
     * Returns the point value of the road.
     * Roads do not directly contribute victory points, so this returns 0.
     *
     * @return 0 (roads have no point value).
     */
    @Override
    public int GetPoint() {
        return 0;
    }
}
