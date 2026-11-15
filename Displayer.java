
/*
 * The Displayer class handles all console output related to the game,
 * including printing the map, player scores, resources, and game rules.
 * This class does not manage any game logic or state; it is solely for UI.
 */
public class Displayer {


    /*
     * Constructs a Displayer object.
     */
    public Displayer() {

    }

    /*
     * Prints the current map layout, including tiles, dice numbers, roads, settlements,
     * cities, and the thief if present.
     *
     * @param map        - The 2D array of Map objects representing resource tiles.
     * @param settlement - The 2D array of settlements placed by players.
     * @param city       - The 2D array of cities placed by players.
     * @param road       - The 2D array of roads placed by players.
     */
    public void PrintMap(Map[][] map, Buildable[][] settlement, Buildable[][] city, Buildable[][] road) {


        System.out.printf("%20s%28s\n", "D3","D4");
        System.out.println();
        System.out.print("   ");
        for (int i = 0; i < settlement[0].length; i++) {

            String temp = "  ";
            String strRoad = "  ";

            if (i != settlement[0].length - 1) {

                if (road[0][i] != null) {
                    strRoad = "r" + String.valueOf(road[0][i].GetPlayerId());
                }

                if (city[0][i] != null) {
                    temp = "c" + String.valueOf(city[0][i].GetPlayerId());

                } else if (settlement[0][i] != null) {
                    temp = "s" + String.valueOf(settlement[0][i].GetPlayerId());

                }

                System.out.print(temp + "     " + strRoad +  "     ");

            } else {

                if (city[0][i] != null) {
                    temp = "c" + String.valueOf(city[0][i].GetPlayerId());

                } else if (settlement[0][i] != null) {
                    temp = "s" + String.valueOf(settlement[0][i].GetPlayerId());
                }
                System.out.print(temp + "            ");

            }

        }
        System.out.println();
        System.out.println("      -----------   -----------   -----------   -----------");
        for (int i = 0; i < map.length; i++) {

            if (i == 1) {

                System.out.print("D2  ");

            } else if (i == 3) {
                System.out.print("D1  ");

            } else  {
                System.out.print("    ");
            }

            String strRoad = "";
            String thief = "";

            for (int j = 0; j < map[i].length; j++) {

                thief = "";
                strRoad = " ";


                if (road[(i * 2) + 1][j] != null) {
                    strRoad = String.valueOf(road[(i * 2) + 1][j].GetPlayerId());
                }

                if (map[i][j].GetThief() == 1) {
                    thief = "T";
                }

                if (map[i][j].GetType() == map[i][j].FIELD ) {
                    System.out.printf("%1s |%2s%3d%3s%1s| ", strRoad , "G", map[i][j].GetDiceNum() , thief , "");

                } else if (map[i][j].GetType() == map[i][j].FOREST) {
                    System.out.printf("%1s |%2s%3d%3s%1s| ", strRoad , "L", map[i][j].GetDiceNum() , thief , "");

                } else if (map[i][j].GetType() == map[i][j].PASTURE) {
                    System.out.printf("%1s |%2s%3d%3s%1s| ", strRoad , "W", map[i][j].GetDiceNum() , thief ,"");

                } else if (map[i][j].GetType() == map[i][j].MOUNTAIN) {
                    System.out.printf("%1s |%2s%3d%3s%1s| ", strRoad , "O", map[i][j].GetDiceNum() , thief , "");

                } else if (map[i][j].GetType() == map[i][j].HILL) {
                    System.out.printf("%1s |%2s%3d%3s%1s| ", strRoad , "B", map[i][j].GetDiceNum() , thief  , "");

                }else {
                    System.out.printf("%1s |%2s%3d%3s%1s| ", strRoad , "D", map[i][j].GetDiceNum() , thief , "");

                }

            }

            if (road[(i * 2) + 1][4] != null) {
                strRoad = String.valueOf(road[(i * 2) + 1][4].GetPlayerId());

            }

            System.out.print(strRoad + "  ");

            if (i == 1) {

                System.out.print("D5");

            } else if(i == 3) {
                System.out.print("D6");

            } else {
                System.out.print("    ");
            }

            if (i != map.length - 1) {
                System.out.println();
                System.out.println("      -----------   -----------   -----------   -----------");
            }

            System.out.print("   ");

            if (i != 4) {
                for (int k = 0; k < settlement[i + 1].length; k++) {

                    String temp = "  ";
                    strRoad = "  ";

                    if (k != settlement[0].length - 1) {

                        if (road[(i + 1) * 2][k] != null) {
                            strRoad = "r" + String.valueOf(road[((i + 1) * 2)][k].GetPlayerId());

                        }
                        if (city[i + 1][k] != null) {
                            temp = "c" + String.valueOf(city[i + 1][k].GetPlayerId());

                        } else if (settlement[i + 1][k] != null) {
                            temp = "s" + String.valueOf(settlement[i + 1][k].GetPlayerId());

                        }
                        System.out.print(temp + "     " + strRoad + "     ");

                    } else {

                        if (city[i + 1][i] != null) {
                            temp = "c" + String.valueOf(city[i + 1][k].GetPlayerId());

                        } else if (settlement[i + 1][k] != null) {
                            temp = "s" + String.valueOf(settlement[i + 1][k].GetPlayerId());

                        }
                        System.out.print(temp + "            ");

                    }
                }

            }


            System.out.println();
            System.out.println("      -----------   -----------   -----------   -----------");

        }

        System.out.print("   ");

        for (int i = 0; i < settlement[0].length; i++) {

            String temp = "  ";
            String strRoad = "  ";

            if (i != settlement[0].length - 1) {

                if (road[10][i] != null) {
                    strRoad =  "r" + String.valueOf(road[10][i].GetPlayerId());
                }

                if (city[settlement.length - 1][i] != null) {
                    temp = "c" + String.valueOf(city[city.length - 1][i].GetPlayerId());

                } else if (settlement[settlement.length - 1][i] != null) {
                    temp = "s" + String.valueOf(settlement[settlement.length - 1][i].GetPlayerId());
                }
                System.out.print(temp + "     " + strRoad +  "     ");

            } else {

                if (city[settlement.length - 1][i] != null) {
                    temp = "c" + String.valueOf(city[city.length - 1][i].GetPlayerId());

                } else if (settlement[settlement.length - 1][i] != null) {
                    temp = "s" + String.valueOf(settlement[settlement.length - 1][i].GetPlayerId());
                }
                System.out.print(temp + "            ");

            }
        }
        System.out.println();
        System.out.println();

        System.out.printf("%20s%28s\n", "D8","D7");

    }

    /*
     * Displays the game rules and instructions for players, including
     * how to build, gain points, and win.
     */
    public void PrintGameRule() {
        System.out.println("Game Rule\n" +
                "Max player: 2\n" +
                "Objective: Be the first player to earn 10 victory points (VP) by building settlement, cities, road, and acquiring development cards or special bonuses.\n" +
                "\n" +
                "Setup,\n" +
                "•    Order: Players place their first settlement     and adjacent road in normal order (1st -> 2nd) and start the game.\n" +
                "•    Board Assembly: Randomly arrange hexagonal terrain tiles (e.g., forest, hills, pastures) in a square shape, with numbered tokens (2-12) on each tile (except for the desert).\n" +
                "•    Harbors: Harbors are fixed to the map. So, for every new game, the harbors and their trades do not change.\n" +
                "•    Starting Settlement:\n" +
                "   o    Players take turns placing 1 settlement and 1 road\n" +
                "   o    Collect resources from hexes adjacent to the settlement that you place.\n" +
                "\n" +
                "Gameplay,\n" +
                "•    Resource Production\n" +
                "   o    If the total matches a number of a hex, all players with settlements/cities adjacent to that hex gain resources:\n" +
                "       *   Settlement: 1 resource per hex.\n" +
                "       *   City: 2 resources per hex.\n" +
                "   o    Exception: If a 7 is rolled:\n" +
                "       *   Robber Activation: Move the robber to a new hex, blocking its resource production.\n" +
                "•    Building & Trading\n" +
                "   o    Spend Resources to build on your turn:\n" +
                "       *   Road (1 lumber + 1 brick): Expands your network.\n" +
                "       *   Settlement (1 lumber + 1 brick + 1 grain + 1 wool): 1 VP.\n" +
                "       *   City (2 grain + 3 ore): Upgrades a settlement. 2 VP.\n" +
                "       *   Development Card (1 sheep + 1 wheat + 1 ore): Grants knights, VP, or special abilities.\n" +
                "\n" +
                "   o    Trading:\n" +
                "       *    Dosmestic: Trade with players (any ratio, negotiated).\n" +
                "       *    Maritime: Trade with bank at 4:1 (default), or better rates with harbors (e.g., 2:1 for wool)\n" +
                "•    Development Cards\n" +
                "   o    Playable only on your turn (except Victory Points, which are secret until winning):\n" +
                "       *    Knight: Move the robber.\n" +
                "       *    Progress: Year of Plenty, Roading Building, or Monopoly.\n" +
                "       *    Victory Points: Counts toward 10 VP (hidden until game end).\n" +
                "Winning the Game,\n" +
                "•    The first player to reach 10 VP on their turn wins.\n" +
                "•    Points come from:\n" +
                "   o    Settlement (1 VP)\n" +
                "   o    Cities (2 VP)\n" +
                "   o    Victory Point cards (1 VP each)");
    }

    /*
     * Prints the current score of both players.
     *
     * @param p1 Player 1 object
     * @param p2 Player 2 object
     */
    public void PrintScore(Player p1, Player p2) {

        System.out.println("================SCORES==================");
        System.out.printf("|%-8s:%8d | %-8s:%8d |\n", "Player 0", p1.GetScore() , "Player 1", p2.GetScore());
        System.out.println("========================================");

    }

    /*
     * Displays the resources and development cards of a single player.
     * Organized in a table-like format.
     *
     * @param resource The Resource object for a specific player.
     */
    public void PrintResource(Resource resource) {

        System.out.println("======================================");
        System.out.println("|              Player "   + resource.GetId() + "              |");
        System.out.println("======================================");

        System.out.println("================== ================== ================== ================== ================== ================== ================== ================== ==================");
        for (int i = 0; i <= 4; i++)  {

            if ( i == 0 ) {
                for (int j = 0; j <= 8; j++) {

                    String temp = "";

                    if (j == resource.GRAIN) {
                        temp = "Grain    ";

                    } else if (j == resource.LUMBER) {
                        temp = "Lumber    ";

                    }  else if (j == resource.WOOL) {
                        temp = "Wool     ";

                    }  else if (j == resource.ORE) {
                        temp = "Ore     ";

                    }  else if (j == resource.BRICK) {
                        temp = "Brick    ";

                    }  else if (j == resource.KNIGHT) {
                        temp = "Knight    ";

                    }  else if (j == resource.ROADBUILDING) {
                        temp = "Road Building ";

                    }  else if (j == resource.MONOPOLY) {
                        temp = "Monopoly   ";

                    }  else if (j == resource.YEAROFPLENTY) {
                        temp = "Year Of Plenty";

                    }

                    System.out.printf("|%15s%1s| ", temp ,"");
                }

            } else if (i == 1) {
                for (int j = 0; j <= 8; j++) {

                    System.out.print("|----------------| ");
                }


            } else if (i == 3) {

                for (int j = 0; j <= 8; j++) {
                    String temp = "";

                    if (j == resource.GRAIN) {
                        temp = String.valueOf(resource.GetGrain());

                    } else if (j == resource.LUMBER) {
                        temp = String.valueOf(resource.GetLumber());

                    }  else if (j == resource.WOOL) {
                        temp = String.valueOf(resource.GetWool());

                    }  else if (j == resource.ORE) {
                        temp = String.valueOf(resource.GetOre());

                    }  else if (j == resource.BRICK) {
                        temp = String.valueOf(resource.GetBrick());

                    }  else if (j == resource.KNIGHT) {
                        temp = String.valueOf(resource.GetKnight());

                    }  else if (j == resource.ROADBUILDING) {
                        temp = String.valueOf(resource.GetRoadBuilding());

                    }  else if (j == resource.MONOPOLY) {
                        temp = String.valueOf(resource.GetMonopoly());

                    }  else if (j == resource.YEAROFPLENTY) {
                        temp = String.valueOf(resource.GetYearOfPlenty());

                    }

                    System.out.printf("|%9s%7s| ", temp ,"" );
                }

            } else {
                for (int j = 0; j <= 8; j++) {

                    System.out.print("|                | ");
                }

            }
            System.out.println();
        }
        System.out.println("================== ================== ================== ================== ================== ================== ================== ================== ==================");

    }

}
