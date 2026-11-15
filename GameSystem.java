/* Manages the game and all of its attributes */
public class GameSystem {

    /*
    * Private variable
    * */
    private Map[][] map;
    private Player[] allPlayers;
    private Resource[] resources;

    private Buildable[][] road;
    private Buildable[][] settlement;
    private Buildable[][] city;

    private Player currPlayer;
    private Resource currResource;
    private Bank bank;


    /*
    * Constructing GameSystem Object
    * */
    public GameSystem(){

        road = new Buildable[11][];

        for (int i = 0; i < road.length; i++) {

            if ((i % 2) == 0) {
                road[i] = new Buildable[4];

            } else {
                road[i] = new Buildable[5];
            }

        }

        settlement = new Buildable[6][5];
        city = new Buildable[6][5];
        resources = new Resource[2];
        resources[0] = new Resource(0);
        resources[1] = new Resource(1);
        map = new Map[5][4];
        bank = new Bank();
        allPlayers  = new Player[2];
        allPlayers[0] = new Player(0);
        allPlayers[1] = new Player(1);

    }


    /*
     * Helper Method
     * */

    /* Trading between player

   @param playerId - player ID
   @param playerTradeRes - player's trading resource,
   @param playerTradeNum - num of resources that are trading,
   @return - Returns 1 if trade is successful,
   Returns -2 if trade is unsuccessful,
   */
    private int playerTrade(int playerId, int playerTradeRes, int playerTradeNum) {

        if(ReturnResource(playerId, playerTradeRes) >= playerTradeNum) {
            return 1;
        } else {
            return -2;
        }

    }


    private int getDevCard(int id) {

        int devCard = (int)(((Math.random() * bank.KNIGHT_INDEX) + 5));

        if (devCard == bank.KNIGHT_INDEX) {

            if (bank.GetKnight() >= 1) {

                bank.SetKnight(1);
                resources[id].SetKnight(1);

                return 1;

            } else {
                return -1;
            }

        } else if (devCard == bank.ROADBUILDING_INDEX) {

            if (bank.GetRoadBuilding() >= 1) {

                bank.SetRoadBuilding(1);
                resources[id].SetRoadBuilding(1);

                return 1;

            } else {
                return -1;
            }

        }  else if (devCard == bank.MONOPOLY_INDEX) {

            if (bank.GetMonopoly() >= 1) {

                bank.SetMonopoly(1);
                resources[id].SetMonopoly(1);

                return devCard;

            } else {
                return -1;
            }

        }  else if (devCard == bank.YEAROFPLENTY_INDEX) {

            if (bank.GetYearOfPlenty() >= 1) {

                bank.SetYearOfPlenty(1);
                resources[id].SetYearOfPlenty(1);

                return devCard;

            } else {
                return -1;
            }

        }  else {

            if (bank.GetVictoryPoint() >= 1) {

                bank.SetVictoryPoint(1);
                allPlayers[id].SetScore(1);

                return devCard;

            } else {
                return -1;
            }

        }

    }


    /* Return the resource
       @param id   - player ID
       @param type - resource type
       @return     - resource type
     */
    public int ReturnResource(int id, int type) {

        if (type == resources[id].WOOL) {
            return resources[id].GetWool();

        } else if (type == resources[id].BRICK) {
            return resources[id].GetBrick();

        } else if (type == resources[id].GRAIN) {
            return resources[id].GetGrain();

        } else if (type == resources[id].LUMBER) {
            return resources[id].GetLumber();

        } else if (type == resources[id].ORE) {
            return resources[id].GetOre();

        } else if (type == resources[id].KNIGHT) {
            return resources[id].GetKnight();

        } else if (type == resources[id].MONOPOLY) {
            return resources[id].GetMonopoly();

        }  else if (type == resources[id].YEAROFPLENTY) {
            return resources[id].GetYearOfPlenty();

        } else if (type == resources[id].ROADBUILDING) {
            return resources[id].GetRoadBuilding();

        } else {
            return -1;
        }

    }

    /* Setting the resource to the player
       @param id - player ID
       @param type - resource type
       @param num - num of resources
     */
    public void SetResource(int id, int type, int num) {

        if (type == resources[id].WOOL) {
            resources[id].SetWool(num);

        } else if (type == resources[id].BRICK) {
            resources[id].SetBrick(num);

        } else if (type == resources[id].GRAIN) {
            resources[id].SetGrain(num);

        } else if (type == resources[id].LUMBER) {
            resources[id].SetLumber(num);

        } else if (type == resources[id].ORE) {
            resources[id].SetOre(num);

        }  else if (type == resources[id].KNIGHT) {
            resources[id].SetKnight(num);

        } else if (type == resources[id].MONOPOLY) {
            resources[id].SetMonopoly(num);

        }  else if (type == resources[id].YEAROFPLENTY) {
            resources[id].SetYearOfPlenty(num);

        } else if (type == resources[id].ROADBUILDING) {
            resources[id].SetRoadBuilding(num);

        }

    }


    /* Checking for existing player

    @param id - player ID
    @return   - Returns true if player exists,
    Returns false if player does not exist,
    */
    public boolean IsPlayerExist(int id) {

        boolean isExist = false;
        for (int i = 0; i < allPlayers.length; i++) {

            if (allPlayers[i].GetId() == id) {
                isExist = true;
                return isExist;
            }

        }
        return isExist;
    }


    // Generate each region and give the number to each region
    public void GenerateMap() {

        int randRow;
        int randCol;

        for (int i = 0; i <= 5; i++) {

            int count = 0;

            // get random row and column of the map assign the resource type of the tile
            // for ore
            if (i == 3) {

                // ore will be maximum of 3 tile
                while (count < 3) {

                    randRow = (int)(Math.random() * map.length);
                    randCol = (int)(Math.random() * map[randRow].length);

                    if (map[randRow][randCol] == null) {
                        map[randRow][randCol] = new Map(i);

                        count++;

                    }
                }

                // assign desert
            } else if (i == 5) {
                while (count < 1) {


                    randRow = (int) (Math.random() * map.length);
                    randCol = (int) (Math.random() * map[randRow].length);

                    if (map[randRow][randCol] == null) {

                        map[randRow][randCol] = new Map(i);
                        map[randRow][randCol].SetDiceNum(7);
                        map[randRow][randCol].SetThief(1);

                        count++;

                    }
                }

            } else{

                // other resource except ore will be maximum of 4 tile
                while (count < 4) {


                    randRow = (int) (Math.random() * map.length);
                    randCol = (int) (Math.random() * map[randRow].length);

                    if (map[randRow][randCol] == null) {
                        map[randRow][randCol] = new Map(i);

                        count++;

                    }
                }

            }


        }

        int[] diceNum = { 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 8, 8, 9, 9, 10, 10, 11, 11, 12};

        // assigning dice num
        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map[i].length; j++) {

                int randDice = (int) (Math.random() * diceNum.length);

                if (map[i][j].GetDiceNum() != 7) {

                    map[i][j].SetDiceNum(diceNum[randDice]);

                    if (diceNum.length > 1) {
                        int[] temp = new int[diceNum.length - 1];

                        int counter = 0;
                        for (int k = 0; k < diceNum.length; k++) {

                            if (k != randDice) {

                                temp[counter] = diceNum[k];
                                counter++;

                            }

                        }

                        diceNum = temp;
                    }
                }
            }
        }

    }

    /* Getting the current player
      @return - Returns the current player ID
     */
    public void SetCurrPlayer(int playerId) {
        this.currPlayer = allPlayers[playerId];
    }

    /* Setting the current player
       @param playerId - player ID
    */
    public Player GetCurrPlayer() {
        return this.currPlayer;
    }

    /* Getting the player's information
      @param id - player ID
      @return   - Returns all the player's information
     */
    public Player GetPlayer(int id) {
        return this.allPlayers[id];

    }

    /*
    * Get map
    * */
    public Map[][] GetMap() {
        return this.map;
    }

    /*
     * Get road
     * */
    public Buildable[][] GetRoad() {
        return this.road;
    }

    /*
     * Get settlement
     * */
    public Buildable[][] GetSettlement() {
        return this.settlement;
    }

    /*
     * Return city
     * */
    public Buildable[][] GetCity() {
        return this.city;
    }


    /* Generating the dice number
       @return - Returns the roll value
    */
    public int RollDice() {
        int dice1 = (int)(((Math.random()) * 6) + 1);
        int dice2 = (int)(((Math.random()) * 6) + 1);

        return dice1 + dice2;
    }

    /*
    * Switching the player
    */
    public void SwitchPlayer()  {

        if (currPlayer.GetId() == 0) {
            currPlayer = allPlayers[1];

        } else {
            currPlayer = allPlayers[0];

        }

    }


    /*
    * Get another player, opposite of current player
    * */
    public Player GetOtherPlayer() {

        if (currPlayer.GetId() == 0) {
            return this.allPlayers[1];

        } else {
            return this.allPlayers[0];
        }
    }

    // Setting the current resource
    public void SetCurrResource() {
        this.currResource = resources[this.currPlayer.GetId()];
    }

    /* Getting the current resource
      @return - Returns the current resource
     */
    public Resource GetCurrResource() {
        return this.currResource;
    }

    /*
    * Returning resource of the given player id
    * @param id - id of the player
    * */
    public Resource GetResource(int id) {
        return this.resources[id];

    }


    /* Trading player to player
       @param player1         - player1 ID
       @param player2         - player2 ID
       @param player1TradeRes - player1's choice for traded resource
       @param player1TradeNum - player1's choice for how many resources he wants to trade
       @param player2TradeRes - player2's choice for traded resource
       @param player2TradeNum - player2's choice for how many resources he wants to trade
       @return                - Returns 1 if the trade is successful

       Returns -2 if the trade is unsuccessful
       Returns -1 if the player does not exist
     */
    public int PlayerTrade(int player1, int player2, int player1TradeRes, int player1TradeNum, int player2TradeRes, int player2TradeNum  ) {

         if (IsPlayerExist(player1) == true && IsPlayerExist(player2) == true) {

             if (playerTrade(player1, player1TradeRes, player1TradeNum) == 1 && playerTrade(player2, player2TradeRes, player2TradeNum) == 1) {

                 SetResource(player1, player1TradeRes, -player1TradeNum);
                 SetResource(player1, player2TradeRes, player2TradeNum);

                 SetResource(player2, player1TradeRes, player1TradeNum);
                 SetResource(player2, player2TradeRes, -player2TradeNum);

                 return 1;

             } else {

                 return -2;
             }


         } else {
             return -1;
         }

    }

    /* Trading with bank
       @param playerId - player ID
       @param tradeRes - player's choice for traded resource
       @param returnRes - player's choice for wanted resource
       @return          - Returns 1 if the trade is successful

       Returns -2 if the trade is unsuccessful
       Returns -1 if the player does not exist
     */

    public int BankTrade(int playerId, int tradeRes, int returnRes) {

        if ( IsPlayerExist(playerId) ) {

            // trading the resource card from the bank
            if (returnRes < 5) {

                if (ReturnResource(playerId, tradeRes) >= 4) {

                    SetResource(playerId, tradeRes, -4);
                    SetResource(playerId, returnRes, 1);
                    return 1;

                } else {
                    return -2;

                }

            // trading development card
            } else {

                if (GetResource(playerId).GetWool() >= 1 && GetResource(playerId).GetGrain() >= 1 && GetResource(playerId).GetOre() >= 1) {


                    SetResource(playerId, resources[playerId].GRAIN , -1);
                    SetResource(playerId, resources[playerId].WOOL , -1);
                    SetResource(playerId, resources[playerId].ORE , -1);



                    return getDevCard(playerId);

                } else {
                    return -2;

                }

            }

        } else {
            return -1;

        }
    }

    /* Trade with harbour
       @param playerId  - The Player ID (0, 1)
       @param tradeRes  - The Player's choice of traded resource
       @param returnRes - The Player's choice of wanted resource
       @param pos       - dummy partner just for overloading purpose
       @return          - Returns 1 if the trade is successful

     */

    public int HarbourTrade(int playerId, int tradeRes, int returnRes, int pos) {

        if (IsPlayerExist(playerId)) {

            if ( ReturnResource(playerId, tradeRes) >= 3 ) {
                SetResource(playerId, tradeRes, -3);
                SetResource(playerId, returnRes, 1);
                return 1;

            } else {
                return -2;

            }


        } else {
            return -1;

        }

    }

    /* Trade with harbour
       @param playerId  - The Player ID (0, 1)
       @param returnRes - The Player's choice of wanted resource
       @param pos       - The position of the harbour
       @return          - Returns 1 if the trade is successful

     */
    public int HarbourTrade(int playerId, int returnRes, int pos) {

        if (IsPlayerExist(playerId)) {

            if (pos == 0) {
                if ( resources[playerId].GetWool() >= 2 ) {
                    SetResource(playerId, Resource.WOOL, -2);
                    SetResource(playerId, returnRes, 1);
                    return 1;

                } else {
                    return -2;

                }

            } else if (pos == 1) {
                if ( resources[playerId].GetLumber() >= 2 ) {
                    SetResource(playerId, Resource.LUMBER, -2);
                    SetResource(playerId, returnRes, 1);
                    return 1;

                } else {
                    return -2;

                }

            } else if (pos == 4) {
                if ( resources[playerId].GetGrain() >= 2 ) {
                    SetResource(playerId, Resource.GRAIN, -2);
                    SetResource(playerId, returnRes, 1);
                    return 1;

                } else {
                    return -2;

                }

            } else if (pos == 5) {
                if ( resources[playerId].GetBrick() >= 2 ) {
                    SetResource(playerId, Resource.BRICK, -2);
                    SetResource(playerId, returnRes, 1);
                    return 1;

                } else {
                    return -2;

                }

            } else {
                if ( resources[playerId].GetOre() >= 2 ) {
                    SetResource(playerId, Resource.ORE, -2);
                    SetResource(playerId, returnRes, 1);
                    return 1;

                } else {
                    return -2;

                }

            }

        } else {
            return -1;

        }

    }

    /*
    * Build settlement
    * @ param id  - player ID
    * @ param row - the row of the settlement to be built
    * @ param col - the col of the settlement to be built
    * @ return    - Return 1 if successfully built
    *             - Return -1 if not
    *             - Return -2 if already built
    */

    public int BuildSettlement(int id, int row, int col) {

        if (settlement[row][col] == null) {

            // checking the settlement except the corner and end
            if ((row + 1) <= settlement.length - 1 && (row - 1) >= 0 && (col - 1) >= 0 && (col + 1) <= settlement[0].length - 1) {

                if (settlement[row][col + 1] == null && settlement[row][col - 1] == null && settlement[row + 1][col] == null & settlement[row - 1][col] == null) {

                    settlement[row][col] = new Settlement(id);

                    GetPlayer(id).SetScore(settlement[row][col].GetPoint());

                    return 1;

                } else {
                    return -1;
                }

            // checking the corner end
            } else if ((row - 1) < 0 && (col - 1) < 0) {

                if (settlement[row + 1][col] == null && settlement[row][col + 1] == null) {

                    settlement[row][col] = new Settlement(id);

                    GetPlayer(id).SetScore(settlement[row][col].GetPoint());

                    return 1;

                } else {
                    return -1;
                }

            // checking the corner end
            } else if ((row + 1) >= settlement.length && (col - 1) < 0) {

                if (settlement[row - 1][col] == null && settlement[row][col + 1] == null) {

                    settlement[row][col] = new Settlement(id);

                    GetPlayer(id).SetScore(settlement[row][col].GetPoint());

                    return 1;

                } else {
                    return -1;
                }

            // checking the corner end
            } else if ((row - 1) < 0 && (col + 1) >= settlement[0].length) {
                if (settlement[row + 1][col] == null && settlement[row][col - 1] == null) {

                    settlement[row][col] = new Settlement(id);

                    GetPlayer(id).SetScore(settlement[row][col].GetPoint());

                    return 1;

                } else {
                    return -1;
                }

            // checking the corner end
            } else if ((row + 1) >= settlement.length && (col + 1) >= settlement[0].length) {
                if (settlement[row - 1][col] == null && settlement[row][col - 1] == null) {

                    settlement[row][col] = new Settlement(id);

                    GetPlayer(id).SetScore(settlement[row][col].GetPoint());

                    return 1;

                } else {
                    return -1;
                }

            // checking first row
            } else if ((row - 1) < 0) {
                if (settlement[row + 1][col] == null && settlement[row][col - 1] == null && settlement[row][col + 1] == null) {

                    settlement[row][col] = new Settlement(id);

                    GetPlayer(id).SetScore(settlement[row][col].GetPoint());

                    return 1;

                } else {
                    return -1;
                }

            // checking first column
            } else if ((col - 1) < 0) {
                if (settlement[row + 1][col] == null && settlement[row - 1][col] == null && settlement[row][col + 1] == null) {

                    settlement[row][col] = new Settlement(id);

                    GetPlayer(id).SetScore(settlement[row][col].GetPoint());

                    return 1;

                } else {
                    return -1;
                }

            // checking the last row
            } else if ((row + 1) >= settlement.length) {
                if (settlement[row - 1][col] == null && settlement[row][col - 1] == null && settlement[row][col + 1] == null) {

                    settlement[row][col] = new Settlement(id);

                    GetPlayer(id).SetScore(settlement[row][col].GetPoint());

                    return 1;

                } else {
                    return -1;
                }

            // checking the last column
            } else {
                if (settlement[row + 1][col] == null && settlement[row][col - 1] == null && settlement[row - 1][col] == null) {

                    settlement[row][col] = new Settlement(id);

                    GetPlayer(id).SetScore(settlement[row][col].GetPoint());

                    return 1;

                } else {
                    return -1;
                }
            }
        } else {
            return -2;
        }
    }

    /*
     * Build settlement
     * @ param id  - player ID
     * @ param row - the row of the road to be built
     * @ param col - the col of the road to be built
     * @ return    - Return 1 if successfully built
     *             - Return -1 if not
     *             - Return -2 if already built
     */
    public int BuildRoad(int id, int row, int col) {

        if (road[row][col] != null) {

            return -3;

        } else {

            // check for adjacent settlement for given row and column
            if ((row % 2) == 0) {

                row = (row / 2);

                if (settlement[row][col] != null) {

                    if (settlement[row][col].GetPlayerId() == id) {

                        row = row * 2;
                        road[row][col] = new Road(id);
                        return 1;

                    } else {
                        return -2;
                    }

                } else if (settlement[row][col + 1] != null) {

                    if (settlement[row][col + 1].GetPlayerId() == id) {

                        row = row * 2;

                        road[row][col] = new Road(id);

                        return 1;

                    } else {
                        return -2;
                    }

                } else {
                    return -1;
                }

            } else {

                row = (row / 2);

                if (settlement[row][col] != null) {

                    if (settlement[row][col].GetPlayerId() == id) {

                        row = (row * 2) + 1;
                        road[row][col] = new Road(id);
                        return 1;

                    } else {
                        return -2;
                    }

                } else if (settlement[row + 1][col] != null) {

                    if (settlement[row + 1][col].GetPlayerId() == id) {

                        row = (row * 2) + 1;
                        road[row][col] = new Road(id);

                        return 1;

                    } else {
                        return -2;
                    }

                } else {
                    return -1;
                }

            }
        }
    }

    /*
    * check if the given row and column has settlement on it
    * @ return 1 if there is settlement on it
    * @ return -1 if not
    * */
    public int BuildCity(int id, int row, int col) {

        // check if the already exist or not
        if (city[row][col] != null) {

            return -2;

        // check if the settlement is on the following row and column
        } else if (settlement[row][col] != null) {

            if (settlement[row][col].GetPlayerId() == id) {

                city[row][col] = new City(id);

                GetCurrPlayer().SetScore(city[row][col].GetPoint());
                return 1;

            } else {
                return -1;

            }

        } else {
            return -1;
        }

    }

    /*
    * play game, check the dice number and match with the map and get resource of the map
    * @param diceNum - dice number
    * return true if any player get resource
    * return false if not
    * */
    public int PlayGame(int diceNum){

        int returnValue = -1;

        // roll dice and return resource from the settlement adjacent to the dice num
        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map[i].length; j++) {

                if (map[i][j].GetDiceNum() == diceNum) {

                    if (map[i][j].GetThief() != 1) {

                        if (city[i][j] != null) {

                            SetResource(city[i][j].GetPlayerId(), map[i][j].GetType(), 2);

                            returnValue = 1;

                        } else {

                            if (settlement[i][j] != null) {

                                SetResource(settlement[i][j].GetPlayerId(), map[i][j].GetType(), 1);

                                returnValue = 1;

                            }

                        }



                        if (city[i][j + 1] != null) {

                            SetResource(city[i][j + 1].GetPlayerId(), map[i][j].GetType(), 2);

                            returnValue = 1;

                        } else {


                            if (settlement[i][j + 1] != null) {

                                SetResource(settlement[i][j + 1].GetPlayerId(), map[i][j].GetType(), 1);

                                returnValue = 1;

                            }

                        }

                        if (city[i + 1][j] != null) {

                            SetResource(city[i + 1][j].GetPlayerId(), map[i][j].GetType(), 2);

                            returnValue = 1;

                        } else {

                            if (settlement[i + 1][j] != null) {

                                SetResource(settlement[i + 1][j].GetPlayerId(), map[i][j].GetType(), 1);

                                returnValue = 1;

                            }

                        }

                        if (city[i + 1][j + 1] != null) {

                            SetResource(city[i + 1][j + 1].GetPlayerId(), map[i][j].GetType(), 2);

                            returnValue = 1;

                        } else {

                            if (settlement[i + 1][j + 1] != null) {

                                SetResource(settlement[i + 1][j + 1].GetPlayerId(), map[i + 1][j + 1].GetType(), 1);

                                returnValue = 1;

                            }

                        }

                    } else {
                        returnValue = -2;

                    }
                }
            }
        }

        return returnValue;
    }

    /*
    * Check the winner by score, if a player's score reach 10 the player win
    * @ param id - id of the player
    * return true if the player is win
    * return false if not
    */
    public boolean CheckWinner(int id) {

        if (allPlayers[id].GetScore() >= 10) {
            return true;
        }
        else {
            return false;
        }
    }

    /*
     * check if the row and column of buildable is within its range or not
     * @ param type - type of buildable
     * @ param row - row of the buildable
     * @ param id  - column of the buildable
     * return true if buildable is within the range
     * return false if not
     */
    public boolean IsBuildable(int type, int row, int col) {

        if (type == 1) {

            if (row < settlement.length && col < settlement[0].length) {
                return true;

            } else {
                return false;

            }


        } else if (type == 2) {

            if (row < city.length && col < city[0].length) {
                return true;

            } else {
                return false;

            }

        } else {

            if ((row % 2) == 0) {

                if (row < road.length && col < road[0].length) {
                    return true;

                } else {
                    return false;

                }

            } else {

                if (row < road.length && col < road[1].length) {
                    return true;

                } else {
                    return false;

                }

            }

        }

    }

    /*
    * overloading method
    * Check if given buildable has sufficient resource enough to build
    * @ param id - id of the player
    * @ param type - type of buildable
    * return true if there is sufficient resource
    * return false if not
    * */
    public boolean IsBuildable(int id, int type) {

        if (type == 1) {

            if (GetResource(id).GetLumber() >= 1 && GetResource(id).GetBrick() >= 1 && GetResource(id).GetGrain() >= 1 && GetResource(id).GetWool() >= 1) {
                return true;

            } else {
                return false;

            }

        } else if (type == 2) {

            if (GetResource(id).GetOre() >= 3 && GetResource(id).GetGrain() >= 2) {
                return true;

            } else {
                return false;

            }

        } else {

            if (GetResource(id).GetBrick() >= 1 && GetResource(id).GetLumber() >= 1) {
                return true;

            } else {
                return false;

            }



            }

    }

    /*
    * @ param pos - position of the harbour
    * @ param id  - id of the player
    * return true if harbour is tradable
    * return false if not
    */
    public boolean IsHarbourTradable(int id, int pos) {

        if (pos == 0) {

            if (settlement[4][0] != null) {

                if (settlement[4][0].GetPlayerId() == id) {
                    return true;

                } else {
                    return false;

                }

            } else if (settlement[3][0] != null) {

                if (settlement[3][0].GetPlayerId() == id) {
                    return true;

                } else {
                    return false;

                }

            } else {
                return false;

            }

        } else if (pos == 1) {

            if (settlement[1][0] != null) {

                if (settlement[1][0].GetPlayerId() == id) {
                    return true;

                } else {
                    return false;

                }

            } else if ( settlement[2][0] != null){

                if (settlement[2][0].GetPlayerId() == id) {
                    return true;

                } else {
                    return false;

                }


            }else {
                return false;

            }

        } else if (pos == 2) {

            if (settlement[0][1] != null) {

                if (settlement[0][1].GetPlayerId() == id) {
                    return true;

                } else {
                    return false;

                }

            } else {
                return false;

            }

        } else if (pos == 3) {

            if (settlement[0][3] != null) {

                if (settlement[0][3].GetPlayerId() == id) {
                    return true;

                } else {
                    return false;

                }

            } else {
                return false;

            }

        } else if (pos == 4) {

            if (settlement[1][4] != null) {

                if (settlement[1][4].GetPlayerId() == id) {
                    return true;

                } else {
                    return false;

                }

            } else if (settlement[2][4] != null) {

                if (settlement[2][4].GetPlayerId() == id) {
                    return true;

                } else {
                    return false;

                }

            }

            else {
                return false;

            }

        } else if (pos == 5) {

            if (settlement[4][4] != null) {

                if (settlement[4][4].GetPlayerId() == id) {
                    return true;

                } else {
                    return false;

                }

            } else if (settlement[3][4] != null) {

                if (settlement[3][4].GetPlayerId() == id) {
                    return true;

                } else {
                    return false;

                }

            } else {
                return false;

            }

        } else if (pos == 6){

            if (settlement[5][3] != null) {

                if (settlement[5][3].GetPlayerId() == id || settlement[5][3].GetPlayerId() == id) {
                    return true;

                } else {
                    return false;

                }

            } else {
                return false;

            }

        } else {

            if (settlement[5][1] != null || settlement[5][1] != null) {

                if (settlement[5][1].GetPlayerId() == id || settlement[5][1].GetPlayerId() == id) {
                    return true;

                } else {
                    return false;

                }

            } else {
                return false;

            }

        }

    }

    /*
    * Check if given row and col of map is within the range
    * @param row - row of the map
    * @param col - column of the map
    * @ return true if row and column are within the range
    * @ return false if not
    */
    public boolean CheckMap(int row, int col) {

        if (row < map.length && col < map[row].length) {
            return true;

        } else {
            return false;
        }
    }


    /*
    * Place Thief on the map to block player from receiving resource
    * @ param row - row of the map
    * @ param col - column of the map
    * */
    public void PlaceThief(int row, int col) {
        map[row][col].SetThief(1);

    }

    /*
     * Remove Thief from the map
     * @ param row - row of the map
     * @ param col - column of the map
     * */
    public void RemoveThief(int row, int col) {
        map[row][col].SetThief(-1);
    }

    public int[] GetThiefIndex() {

        int[] index = new int[2];

        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map[i].length; j++) {

                if(map[i][j].GetThief() == 1) {

                    index[0] = i;
                    index[1] = j;
                    return index;

                }


            }

        }
        return index;

    }

    /*
     * Player receive resource for the first time after building settlement
     * @ param row - row of the settlement
     * @ param col - column of the settlement
     * */
    public void SetResourceFirst(int id, int row, int col) {

        // check row and column as from the build settlement method
        if ((row + 1) <= settlement.length - 1 && (row - 1) >= 0 && (col - 1) >= 0 && (col + 1) <= settlement[0].length - 1) {

            if (map[row - 1][col - 1].GetType() != 5) {
                SetResource(id, map[row - 1][col - 1].GetType(), 1);
            }

            if (map[row][col - 1].GetType() != 5) {
                SetResource(id, map[row][col - 1].GetType(), 1);
            }

            if (map[row][col].GetType() != 5) {
                SetResource(id, map[row][col].GetType(), 1);
            }

            if (map[row - 1][col].GetType() != 5) {
                SetResource(id, map[row - 1][col].GetType(), 1);
            }



        } else if ((row - 1) < 0 && (col - 1) < 0) {

            if (map[row][col].GetType() != 5) {
                SetResource(id, map[row][col].GetType(), 1);
            }

        } else if ((row + 1) >= settlement.length && (col - 1) < 0) {

            if (map[row - 1][col].GetType() != 5) {
                SetResource(id, map[row - 1][col].GetType(), 1);
            }

        } else if ((row - 1) < 0 && (col + 1) >= settlement[0].length) {

            if (map[row][col - 1].GetType() != 5) {
                SetResource(id, map[row][col - 1].GetType(), 1);
            }

        } else if ((row + 1) >= settlement.length && (col + 1) >= settlement[0].length) {

            if (map[row - 1][col - 1].GetType() != 5) {
                SetResource(id, map[row - 1][col - 1].GetType(), 1);
            }

        } else if ((row - 1) < 0) {

            if (map[row][col - 1].GetType() != 5) {

                SetResource(id, map[row][col - 1].GetType(), 1);

            }

            if (map[row][col].GetType() != 5) {

                SetResource(id, map[row][col].GetType(), 1);

            }

        } else if ((col - 1) < 0) {

            if (map[row - 1][col].GetType() != 5) {
                SetResource(id, map[row - 1][col].GetType(), 1);
            }

            if (map[row][col].GetType() != 5) {
                SetResource(id, map[row][col].GetType(), 1);
            }

        } else if ((row + 1) >= settlement.length) {

            if (map[row - 1][col].GetType() != 5) {
                SetResource(id, map[row - 1][col].GetType(), 1);
            }

            if (map[row - 1][col - 1].GetType() != 5) {
                SetResource(id, map[row - 1][col - 1].GetType(), 1);
            }
        } else {

            if (map[row][col - 1].GetType() != 5) {
                SetResource(id, map[row][col - 1].GetType(), 1);
            }

            if (map[row - 1][col - 1].GetType() != 5) {
                SetResource(id, map[row - 1][col - 1].GetType(), 1);
            }
        }

    }
}

