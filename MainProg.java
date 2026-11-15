import java.util.Scanner;

public class MainProg {

    public static void main(String[] args) {

        boolean repeat = true;

        while (repeat) {

            Scanner input = new Scanner(System.in);
            Displayer disp = new Displayer();
            GameSystem gs = new GameSystem();

            System.out.println("1. Play a game(2 players)");
            System.out.println("2. Game Rule");
            System.out.println("3. Exit");
            System.out.print("Enter a option: ");
            int option = input.nextInt();

            while (option < 1 || option > 3) {

                System.out.println("Invalid Input!");
                System.out.print("Enter a option: ");
                option = input.nextInt();
            }

            boolean isStarted = true;

            if (option == 1) {

                boolean endGame = false;

                gs.GenerateMap();
                gs.SetCurrPlayer(0);

                // loop for the game
                while (endGame == false) {

                    // Initialization phase: each player places their first settlement and road.
                    if (isStarted == true) {

                        disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());
                        disp.PrintScore(gs.GetPlayer(0), gs.GetPlayer(1));
                        System.out.println("----------------------------------------------------------------------------");

                        System.out.println("Player 0 turn ");
                        System.out.println("Choose a place to build settlement ");

                        int row, col;

                        System.out.print("input Row: ");
                        row = input.nextInt();

                        System.out.print("input Column: ");
                        col = input.nextInt();

                        // check validity for row and column
                        while (gs.IsBuildable(1, row - 1, col - 1) != true) {

                            System.out.println("Invalid Row or Column");
                            System.out.print("input Row: ");
                            row = input.nextInt();

                            System.out.println("input Column: ");
                            col = input.nextInt();

                        }

                        int isSettlementBuilt = gs.BuildSettlement(0, row - 1, col - 1);

                        // check if settlement is built or not
                        while (isSettlementBuilt != 1) {

                            if (isSettlementBuilt == -1) {

                                System.out.println("Settlement must be built 2 column far");
                                System.out.print("input Row: ");
                                row = input.nextInt();

                                System.out.println("input Column: ");
                                col = input.nextInt();

                            } else {

                                System.out.println("Settlement is already built");
                                System.out.print("input Row: ");
                                row = input.nextInt();

                                System.out.println("input Column: ");
                                col = input.nextInt();

                            }

                            while (gs.IsBuildable(1, row - 1, col - 1) != true) {

                                System.out.println("Invalid Row or Column");
                                System.out.print("input Row: ");
                                row = input.nextInt();

                                System.out.println("input Column: ");
                                col = input.nextInt();

                            }

                            isSettlementBuilt = gs.BuildSettlement(0, row - 1, col - 1);

                        }

                        gs.SetResourceFirst(0, row - 1, col - 1);
                        disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());
                        disp.PrintScore(gs.GetPlayer(0), gs.GetPlayer(1));

                        System.out.println("Choose a place to build road ");

                        System.out.print("input Row: ");
                        row = input.nextInt();

                        System.out.print("input Column: ");
                        col = input.nextInt();


                        // check validity for row and column
                        while (gs.IsBuildable(3, row - 1, col - 1) != true) {

                            System.out.println("Invalid Row or Column");
                            System.out.print("input Row: ");
                            row = input.nextInt();

                            System.out.println("input Column: ");
                            col = input.nextInt();

                        }

                        System.out.println();

                        int isRoadBuilt = gs.BuildRoad(0, row - 1, col - 1);

                        System.out.println();

                        // check if road is built or not
                        while (isRoadBuilt != 1) {

                            if (isRoadBuilt == -1) {

                                System.out.println("Road must be built next to settlement");

                                System.out.print("input Row: ");
                                row = input.nextInt();

                                System.out.print("input Column: ");
                                col = input.nextInt();

                            } else if (isRoadBuilt == -2) {

                                System.out.println("Road cannot be built next to other player's settlement");

                                System.out.print("input Row: ");
                                row = input.nextInt();

                                System.out.print("input Column: ");
                                col = input.nextInt();

                            } else {

                                System.out.println("Road is already built");

                                System.out.print("input Row: ");
                                row = input.nextInt();

                                System.out.print("input Column: ");
                                col = input.nextInt();

                            }

                            // check validity for row and column
                            while (gs.IsBuildable(3, row - 1, col - 1) != true) {

                                System.out.println("Invalid Row or Column");
                                System.out.print("input Row: ");
                                row = input.nextInt();

                                System.out.println("input Column: ");
                                col = input.nextInt();

                            }
                            isRoadBuilt = gs.BuildRoad(0, row - 1, col - 1);
                        }

                        System.out.println();
                        disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());
                        disp.PrintScore(gs.GetPlayer(0), gs.GetPlayer(1));
                        System.out.println();

                        System.out.println("Player 1 turn ");
                        System.out.println("Choose a place to build settlement ");


                        System.out.print("input Row: ");
                        row = input.nextInt();

                        System.out.print("input Column: ");
                        col = input.nextInt();

                        // check validity for row and column
                        while (gs.IsBuildable(1, row - 1, col - 1) != true) {

                            System.out.println("Invalid Row or Column");
                            System.out.print("input Row: ");
                            row = input.nextInt();

                            System.out.println("input Column: ");
                            col = input.nextInt();

                        }
                        System.out.println();

                        isSettlementBuilt = gs.BuildSettlement(1, row - 1, col - 1);

                        System.out.println();

                        // check if settlement is built or not
                        while (isSettlementBuilt != 1) {

                            if (isSettlementBuilt == -1) {

                                System.out.println("Settlement must be built 2 column far ");
                                System.out.print("input Row: ");
                                row = input.nextInt();

                                System.out.println("input Column: ");
                                col = input.nextInt();

                            } else {

                                System.out.println("Settlement is already built");
                                System.out.print("input Row: ");
                                row = input.nextInt();

                                System.out.println("input Column: ");
                                col = input.nextInt();

                            }

                            while (gs.IsBuildable(1, row - 1, col - 1) != true) {

                                System.out.println("Invalid Row or Column");
                                System.out.print("input Row: ");
                                row = input.nextInt();

                                System.out.println("input Column: ");
                                col = input.nextInt();

                            }
                            System.out.println();

                            isSettlementBuilt = gs.BuildSettlement(1, row - 1, col - 1);

                            System.out.println();
                            disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());
                            disp.PrintScore(gs.GetPlayer(0), gs.GetPlayer(1));

                        }

                        gs.SetResourceFirst(1, row - 1, col - 1);
                        disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());

                        System.out.println("Choose a place to build road ");

                        System.out.print("input Row: ");
                        row = input.nextInt();

                        System.out.print("input Column: ");
                        col = input.nextInt();


                        while (gs.IsBuildable(3, row - 1, col - 1) != true) {

                            System.out.println("Invalid Row or Column");
                            System.out.print("input Row: ");
                            row = input.nextInt();

                            System.out.println("input Column: ");
                            col = input.nextInt();

                        }

                        isRoadBuilt = gs.BuildRoad(1, row - 1, col - 1);

                        // check if road is built or not
                        while (isRoadBuilt != 1) {

                            if (isRoadBuilt == -1) {

                                System.out.println("Road must be built next to settlement");

                                System.out.print("input Row: ");
                                row = input.nextInt();

                                System.out.print("input Column: ");
                                col = input.nextInt();

                            } else if (isRoadBuilt == -2) {

                                System.out.println("Road cannot be built next to other player's settlement");

                                System.out.print("input Row: ");
                                row = input.nextInt();

                                System.out.print("input Column: ");
                                col = input.nextInt();

                            } else {

                                System.out.println("Road is already built");

                                System.out.print("input Row: ");
                                row = input.nextInt();

                                System.out.print("input Column: ");
                                col = input.nextInt();

                            }

                            while (gs.IsBuildable(3, row - 1, col - 1) != true) {

                                System.out.println("Invalid Row or Column");
                                System.out.print("input Row: ");
                                row = input.nextInt();

                                System.out.println("input Column: ");
                                col = input.nextInt();

                            }

                            isRoadBuilt = gs.BuildRoad(1, row - 1, col - 1);

                        }

                        isStarted = false;

                        System.out.println();
                        disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());
                        disp.PrintScore(gs.GetPlayer(0), gs.GetPlayer(1));
                        System.out.println();

                        disp.PrintResource(gs.GetResource(0));
                        disp.PrintResource(gs.GetResource(1));
                        System.out.println("Press Enter to continue");
                        input.nextLine();
                        input.nextLine();

                    } else {
                        // playing phase
                        System.out.println("Player " + gs.GetCurrPlayer().GetId() + " Turn");

                        System.out.println();

                        disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());
                        disp.PrintScore(gs.GetPlayer(0), gs.GetPlayer(1));

                        System.out.println("Playing Phase");
                        System.out.println("=========================================================================================");
                        System.out.println("Player " + gs.GetCurrPlayer().GetId() + " turn");

                        int diceNum = gs.RollDice();
                        System.out.println("Dice Number is " + diceNum);

                        // Player receives resources
                        if (diceNum != 7) {

                            int result = gs.PlayGame(diceNum);

                            if (result == 1) {
                                System.out.println("Get resources");


                            // Thief is on the map
                            } else if (result == -2) {
                                System.out.println("No resources return, thief is on map");

                                // check if the player has knight card
                                if (gs.GetResource(gs.GetCurrPlayer().GetId()).GetKnight() >= 1) {

                                    System.out.println("Has " + gs.GetResource(gs.GetCurrPlayer().GetId()).GetKnight() + " Knight card available");
                                    System.out.println("Use knight Card(y/n): ");

                                    input.nextLine();

                                    String useKnightCard = input.nextLine();

                                    // check if want to use knight card
                                    if (useKnightCard.toLowerCase().equals("y")) {

                                        // remove thief from the tile
                                        int[] thiefIndex = gs.GetThiefIndex();
                                        gs.RemoveThief(thiefIndex[0], thiefIndex[1]);

                                        int row, col;

                                        System.out.println("Choose a map to place thief");

                                        System.out.print("Enter row: ");
                                        row = input.nextInt();

                                        System.out.println("Enter column: ");
                                        col = input.nextInt();

                                        while (gs.CheckMap(row - 1, col - 1) != true) {

                                            System.out.println("Warning! Invalid row or column");
                                            System.out.print("Enter row: ");
                                            row = input.nextInt();

                                            System.out.println("Enter column: ");
                                            col = input.nextInt();
                                        }

                                        // place thief on other tile
                                        gs.PlaceThief(row - 1, col - 1);
                                        gs.GetResource(gs.GetCurrPlayer().GetId()).SetKnight(-1);

                                        disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());
                                        disp.PrintScore(gs.GetPlayer(0), gs.GetPlayer(1));
                                    }
                                }


                            } else {
                                System.out.println("No player get resource, no settlement near map");

                            }

                            disp.PrintResource(gs.GetResource(0));
                            disp.PrintResource(gs.GetResource(1));

                        // dice num 7
                        } else {

                            // remove thief from the tile
                            int[] thiefIndex = gs.GetThiefIndex();
                            gs.RemoveThief(thiefIndex[0], thiefIndex[1]);


                            int row, col;

                            System.out.println("You got a thief");
                            System.out.println("Choose a map to place thief");

                            System.out.print("Enter row: ");
                            row = input.nextInt();

                            System.out.println("Enter column: ");
                            col = input.nextInt();

                            while (gs.CheckMap(row - 1, col - 1) != true) {

                                System.out.println("Warning! Invalid row or column");
                                System.out.print("Enter row: ");
                                row = input.nextInt();

                                System.out.println("Enter column: ");
                                col = input.nextInt();
                            }

                            // place thief on the tile
                            gs.PlaceThief(row - 1, col - 1);

                            disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());
                            disp.PrintScore(gs.GetPlayer(0), gs.GetPlayer(1));

                        }

                        System.out.println();

                        System.out.println("Press Enter to continue");
                        input.nextLine();
                        input.nextLine();


                        System.out.println("Playing Phase End");
                        System.out.println("=========================================================================================");

                        System.out.println();

                        System.out.println("Trade Phase");


                        int tradeOption = 4;

                        // trade phase
                        do {

                            System.out.println("1. Domestic Trade(Trading between Players)");
                            System.out.println("2. Trade with Bank");
                            System.out.println("3. Trade with Harbour");
                            System.out.println("4. skip");
                            System.out.print("Enter trade option: ");
                            tradeOption = input.nextInt();

                            // Domestic trade: prompt both players for agreement
                            if (tradeOption == 1) {

                                System.out.println();
                                disp.PrintResource(gs.GetResource(0));
                                disp.PrintResource(gs.GetResource(1));
                                System.out.println();

                                System.out.println("1. Grain");
                                System.out.println("2. Lumber");
                                System.out.println("3. Wool");
                                System.out.println("4. Ore");
                                System.out.println("5. Brick");

                                System.out.print("Choose a resource you want to trade with: ");
                                int giveResourceType = input.nextInt();
                                System.out.println("Choose Quantity");
                                int giveResourceQty = input.nextInt();

                                System.out.print("Choose a resource you want: ");
                                int returnResourceType = input.nextInt();
                                System.out.println("Choose Quantity");
                                int returnResourceQty = input.nextInt();

                                System.out.println("Other Player turn");
                                System.out.print("Do you accept the trade(y/n): ");

                                input.nextLine();
                                String isAccept = input.nextLine();

                                // check if other player accept
                                if (isAccept.toLowerCase().equals("y")) {

                                    if (gs.PlayerTrade(gs.GetCurrPlayer().GetId(), gs.GetOtherPlayer().GetId(), giveResourceType - 1, giveResourceQty, returnResourceType -1, returnResourceQty) == 1) {

                                        System.out.println("Trade Successful");
                                        disp.PrintResource(gs.GetResource(0));
                                        disp.PrintResource(gs.GetResource(1));

                                    } else {
                                        System.out.println("Trade Unsuccessful due to insufficient amount");
                                    }

                                } else {

                                    System.out.println("Trade Unsuccessful due to denial");

                                }
                                System.out.println();



                            // Trade with bank: resources and includes handling of development cards
                            } else if (tradeOption == 2) {

                                System.out.println();
                                disp.PrintResource(gs.GetResource(gs.GetCurrPlayer().GetId()));
                                System.out.println();

                                System.out.println("1. Grain");
                                System.out.println("2. Lumber");
                                System.out.println("3. Wool");
                                System.out.println("4. Ore");
                                System.out.println("5. Brick");
                                System.out.println("6. Development Card(1 wool, 1 ore, 1 grain)");

                                System.out.print("Choose a resource you want to trade with: ");
                                int giveResourceType = input.nextInt();

                                System.out.print("Choose a resource you want: ");
                                int returnResourceType = input.nextInt();

                                int bankTradeResult = gs.BankTrade(gs.GetCurrPlayer().GetId(), giveResourceType - 1, returnResourceType - 1);


                                // trade successful
                                if (bankTradeResult == 1) {

                                    System.out.println("Trade Successful");
                                    disp.PrintResource(gs.GetResource(gs.GetCurrPlayer().GetId()));

                                // receive all the card of one type from another player
                                } else if (bankTradeResult == 7) {

                                    disp.PrintResource(gs.GetResource(gs.GetOtherPlayer().GetId()));

                                    System.out.println("You got Monopoly");

                                    System.out.println("1. Grain");
                                    System.out.println("2. Lumber");
                                    System.out.println("3. Wool");
                                    System.out.println("4. Ore");
                                    System.out.println("5. Brick");

                                    System.out.print("Choose resource you want to receive from another player: ");

                                    int resourceType = input.nextInt();

                                    if ((resourceType - 1) == gs.GetResource(gs.GetCurrPlayer().GetId()).GRAIN) {

                                        returnResourceType = gs.GetResource(gs.GetOtherPlayer().GetId()).GetGrain();

                                        gs.GetResource(gs.GetOtherPlayer().GetId()).SetGrain(-returnResourceType);
                                        gs.SetResource(gs.GetCurrPlayer().GetId(), 0, returnResourceType);


                                    } else if ((resourceType - 1) == gs.GetResource(gs.GetCurrPlayer().GetId()).LUMBER) {

                                        returnResourceType = gs.GetResource(gs.GetOtherPlayer().GetId()).GetLumber();

                                        gs.GetResource(gs.GetOtherPlayer().GetId()).SetLumber(-returnResourceType);
                                        gs.SetResource(gs.GetCurrPlayer().GetId(), 1, returnResourceType);


                                    } else if ((resourceType - 1) == gs.GetResource(gs.GetCurrPlayer().GetId()).WOOL) {

                                        returnResourceType = gs.GetResource(gs.GetOtherPlayer().GetId()).GetWool();

                                        gs.GetResource(gs.GetOtherPlayer().GetId()).SetWool(-returnResourceType);
                                        gs.SetResource(gs.GetCurrPlayer().GetId(), 2, returnResourceType);


                                    } else if ((resourceType - 1) == gs.GetResource(gs.GetCurrPlayer().GetId()).ORE) {

                                        returnResourceType = gs.GetResource(gs.GetOtherPlayer().GetId()).GetOre();

                                        gs.GetResource(gs.GetOtherPlayer().GetId()).SetOre(-returnResourceType);
                                        gs.SetResource(gs.GetCurrPlayer().GetId(), 3, returnResourceType);


                                    } else {

                                        returnResourceType = gs.GetResource(gs.GetOtherPlayer().GetId()).GetBrick();

                                        gs.GetResource(gs.GetOtherPlayer().GetId()).SetBrick(-returnResourceType);
                                        gs.SetResource(gs.GetCurrPlayer().GetId(), 4, returnResourceType);


                                    }

                                    gs.SetResource(gs.GetCurrPlayer().GetId(), gs.GetResource(gs.GetCurrPlayer().GetId()).MONOPOLY , -1);

                                // get two same or different from the bank
                                } else if (bankTradeResult == 8) {

                                    System.out.println();

                                    System.out.println("You got Year of Plenty");

                                    System.out.println("1. Grain");
                                    System.out.println("2. Lumber");
                                    System.out.println("3. Wool");
                                    System.out.println("4. Ore");
                                    System.out.println("5. Brick");

                                    System.out.println("Choose 2 resource you want: ");

                                    int resource1 = input.nextInt();
                                    int resource2 = input.nextInt();

                                    gs.SetResource(gs.GetCurrPlayer().GetId(), resource1 - 1, 1);
                                    gs.SetResource(gs.GetCurrPlayer().GetId(), resource2 - 1, 1);
                                    System.out.println();

                                    gs.SetResource(gs.GetCurrPlayer().GetId(), gs.GetResource(gs.GetCurrPlayer().GetId()).YEAROFPLENTY , -1);

                                    System.out.println();
                                    disp.PrintResource(gs.GetResource(gs.GetOtherPlayer().GetId()));
                                    System.out.println();

                                } else if (bankTradeResult == 9) {

                                    System.out.println("You get a victory point card");
                                    disp.PrintScore(gs.GetPlayer(0), gs.GetPlayer(1));
                                    System.out.println();

                                    if (gs.CheckWinner(0) == true) {
                                        endGame = false;
                                        System.out.println("Player 0 win");
                                        break;

                                    } else if (gs.CheckWinner(1) == true) {
                                        endGame = false;
                                        System.out.println("Player 0 win");
                                        break;

                                    }
                                    System.out.println();

                                }else {

                                    System.out.println("Trade Unsuccessful due to insufficient amount");

                                }

                                System.out.println();

                            // trade with harbour
                            } else if (tradeOption == 3){

                                System.out.println();

                                disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());


                                System.out.println();

                                System.out.println("Specific Resource (2:1)");
                                System.out.println("Any resource (3:1)");

                                System.out.println("1. Wool");
                                System.out.println("2. Lumber");
                                System.out.println("3. Any");
                                System.out.println("4. Any");
                                System.out.println("5. Grain");
                                System.out.println("6. Brick");
                                System.out.println("7. Any");
                                System.out.println("8. Ore");

                                System.out.println("Choose Harbour Number: ");
                                input.nextLine();
                                int harbourOption = input.nextInt();

                                // check if harbour is tradable
                                if (gs.IsHarbourTradable(gs.GetCurrPlayer().GetId(), harbourOption - 1) == true) {

                                    // harbour with any resources
                                    if (harbourOption == 3 || harbourOption == 4 || harbourOption == 7) {

                                        System.out.println();
                                        disp.PrintResource(gs.GetResource(gs.GetCurrPlayer().GetId()));
                                        System.out.println();

                                        System.out.println("1. Grain");
                                        System.out.println("2. Lumber");
                                        System.out.println("3. Wool");
                                        System.out.println("4. Ore");
                                        System.out.println("5. Brick");

                                        System.out.print("Choose resource you want to trade with: ");
                                        int giveResourceType = input.nextInt();

                                        System.out.println("1. Grain");
                                        System.out.println("2. Lumber");
                                        System.out.println("3. Wool");
                                        System.out.println("4. Ore");
                                        System.out.println("5. Brick");

                                        System.out.print("Choose resource you want to receive: ");
                                        int returnResourceType = input.nextInt();

                                        if (gs.HarbourTrade(gs.GetCurrPlayer().GetId(), giveResourceType, returnResourceType - 1, harbourOption - 1) == 1) {

                                            System.out.println("Trade Successful");

                                        } else {
                                            System.out.println("Trade Unsuccessful");

                                        }

                                    // harbour with specific type
                                    } else {

                                        System.out.println("1. Grain");
                                        System.out.println("2. Lumber");
                                        System.out.println("3. Wool");
                                        System.out.println("4. Ore");
                                        System.out.println("5. Brick");

                                        System.out.print("Choose resource you want to receive: ");
                                        int returnResourceType = input.nextInt();

                                        if (gs.HarbourTrade(gs.GetCurrPlayer().GetId(), returnResourceType - 1, harbourOption - 1) == 1) {

                                            System.out.println("Trade Successful");

                                        } else {

                                            System.out.println("Trade Unsuccessful due to insufficient amount");

                                        }

                                        System.out.println();
                                        disp.PrintResource(gs.GetResource(gs.GetCurrPlayer().GetId()));
                                        System.out.println();

                                    }

                                } else {

                                    System.out.println("Trade Unsuccessful, no settlement is available");

                                }


                            }

                        } while (tradeOption != 4);


                        System.out.println("Press Enter to continue");
                        input.nextLine();
                        input.nextLine();

                        System.out.println("Trade Phase End");
                        System.out.println("=========================================================================================");

                        // build phase

                        System.out.println();
                        System.out.println("Build Phase");

                        int buildable;

                        do {

                            System.out.println("");
                            disp.PrintResource(gs.GetResource(gs.GetCurrPlayer().GetId()));
                            System.out.println("");

                            System.out.println("1. Settlement (1 lumber, 1 brick, 1 wool, 1 grain)");
                            System.out.println("2. City (2 grain, 3 ore)");
                            System.out.println("3. Road (1 lumber, 1 brick)");
                            System.out.println("4. Skip");
                            System.out.print("Choose buildable option: ");
                            buildable = input.nextInt();

                            int row, col;

                            // build settlement
                            if (buildable == 1) {

                                // check for resource
                                if (gs.IsBuildable(gs.GetCurrPlayer().GetId(), 1) == true) {


                                    disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());
                                    disp.PrintScore(gs.GetPlayer(0), gs.GetPlayer(1));

                                    System.out.print("Enter row: ");
                                    row = input.nextInt();

                                    System.out.print("Enter column: ");
                                    col = input.nextInt();

                                    // check validity for row and column
                                    while (gs.IsBuildable(1, row - 1, col - 1) != true) {

                                        System.out.println("Invalid Row or Column");
                                        System.out.print("input Row: ");
                                        row = input.nextInt();

                                        System.out.println("input Column: ");
                                        col = input.nextInt();

                                    }

                                    int isSettlementBuilt = gs.BuildSettlement(gs.GetCurrPlayer().GetId(), row - 1, col - 1);

                                    if (isSettlementBuilt == 1) {

                                        gs.SetResource(gs.GetCurrPlayer().GetId(), 0 ,-1);
                                        gs.SetResource(gs.GetCurrPlayer().GetId(), 1 ,-1);
                                        gs.SetResource(gs.GetCurrPlayer().GetId(), 2 ,-1);
                                        gs.SetResource(gs.GetCurrPlayer().GetId(), 4 ,-1);
                                        System.out.println("Successfully built");


                                    } else if (isSettlementBuilt == -1) {

                                        System.out.println("Settlement must be built 2 column far");


                                    } else {

                                        System.out.println("Settlement is already built");

                                    }


                                    disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());
                                    disp.PrintScore(gs.GetPlayer(0), gs.GetPlayer(1));
                                    disp.PrintResource(gs.GetResource(gs.GetCurrPlayer().GetId()));

                                    if (gs.CheckWinner(0) == true) {
                                        endGame = false;
                                        System.out.println("Player 0 win");
                                        break;


                                    } else if (gs.CheckWinner(1) == true) {
                                        endGame = false;
                                        System.out.println("Player 1 win");
                                        break;

                                    }


                                } else {
                                    System.out.println("Insufficient resource");

                                }


                            // build city
                            } else if (buildable == 2) {

                                // check for resource
                                if (gs.IsBuildable(gs.GetCurrPlayer().GetId(), 2) == true) {

                                    disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());
                                    disp.PrintScore(gs.GetPlayer(0), gs.GetPlayer(1));

                                    System.out.print("Enter row: ");
                                    row = input.nextInt();

                                    System.out.print("Enter column: ");
                                    col = input.nextInt();

                                    // check validity for row and column
                                    while (gs.IsBuildable(2, row - 1, col - 1) != true) {

                                        System.out.println("Invalid Row or Column");
                                        System.out.print("input Row: ");
                                        row = input.nextInt();

                                        System.out.println("input Column: ");
                                        col = input.nextInt();

                                    }

                                    int isBuildCity = gs.BuildCity(gs.GetCurrPlayer().GetId(), row, col);

                                    if (isBuildCity == 1) {

                                        gs.SetResource(gs.GetCurrPlayer().GetId(), 3, -3);
                                        gs.SetResource(gs.GetCurrPlayer().GetId(), 0, -2);
                                        System.out.println("Successfully Built");
                                        disp.PrintResource(gs.GetResource(gs.GetCurrPlayer().GetId()));

                                    } else if (isBuildCity == -1){

                                        System.out.println("There is no settlement on the place");

                                    } else if (isBuildCity == -2) {

                                        System.out.println("City is already exist.");

                                    }


                                } else {
                                    System.out.println("Insufficient resource");

                                }

                                disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());
                                disp.PrintScore(gs.GetPlayer(0), gs.GetPlayer(1));
                                disp.PrintResource(gs.GetResource(gs.GetCurrPlayer().GetId()));

                                if (gs.CheckWinner(0) == true) {
                                    endGame = false;
                                    System.out.println("Player 0 win");
                                    break;

                                } else if (gs.CheckWinner(1) == true) {
                                    endGame = false;
                                    System.out.println("Player 1 win");
                                    break;

                                }

                            // build road
                            } else {

                                // build with road building card (no resource require)
                                if (gs.GetResource(gs.GetCurrPlayer().GetId()).GetRoadBuilding() >= 1) {

                                    System.out.println("Has " + gs.GetResource(gs.GetCurrPlayer().GetId()).GetRoadBuilding() + "Road Building Card");
                                    System.out.println("Do you want to use(y/n)");
                                    input.nextLine();
                                    String roadBuilding = input.nextLine();

                                    if (roadBuilding.toLowerCase().equals("y")) {

                                        disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());
                                        disp.PrintScore(gs.GetPlayer(0), gs.GetPlayer(1));


                                        System.out.print("Enter row: ");
                                        row = input.nextInt();

                                        System.out.print("Enter column: ");
                                        col = input.nextInt();

                                        // check validity for row and column
                                        while (gs.IsBuildable(3, row - 1, col - 1) != true) {

                                            System.out.println("Invalid Row or Column");
                                            System.out.print("input Row: ");
                                            row = input.nextInt();

                                            System.out.println("input Column: ");
                                            col = input.nextInt();


                                        }


                                        int isRoadBuilt = gs.BuildRoad(gs.GetCurrPlayer().GetId(), row - 1, col - 1);


                                        if (isRoadBuilt == 1) {

                                            System.out.println("Successfully built");

                                        } else if (isRoadBuilt == -1) {

                                            System.out.println("Road must be built next to settlement");

                                        } else if (isRoadBuilt == -2){

                                            System.out.println("Road cannot be built next to other player's settlement");

                                        } else {

                                            System.out.println("Road is already built");

                                        }


                                        disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());
                                        disp.PrintScore(gs.GetPlayer(0), gs.GetPlayer(1));


                                    }


                                } else {

                                    // check for resource
                                    if (gs.IsBuildable(gs.GetCurrPlayer().GetId(), 3) == true) {


                                        disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());
                                        disp.PrintScore(gs.GetPlayer(0), gs.GetPlayer(1));


                                        System.out.print("Enter row: ");
                                        row = input.nextInt();

                                        System.out.print("Enter column: ");
                                        col = input.nextInt();

                                        // check validity for row and column
                                        while (gs.IsBuildable(3, row - 1, col - 1) != true) {

                                            System.out.println("Invalid Row or Column");

                                            System.out.print("input Row: ");
                                            row = input.nextInt();

                                            System.out.println("input Column: ");
                                            col = input.nextInt();

                                        }


                                        disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());
                                        disp.PrintScore(gs.GetPlayer(0), gs.GetPlayer(1));


                                        int isRoadBuilt = gs.BuildRoad(gs.GetCurrPlayer().GetId(), row - 1, col - 1);


                                        if (isRoadBuilt == 1) {

                                            gs.SetResource(gs.GetCurrPlayer().GetId(), 1 , -1);
                                            gs.SetResource(gs.GetCurrPlayer().GetId(), 4 , -1);
                                            disp.PrintResource(gs.GetResource(gs.GetCurrPlayer().GetId()));

                                            System.out.println("Successfully built");

                                        } else if (isRoadBuilt == -1) {

                                            System.out.println("Road must be built next to settlement");

                                        } else if (isRoadBuilt == -2){

                                            System.out.println("Road cannot be built next to other player's settlement");

                                        } else {

                                            System.out.println("Road is already built");

                                        }

                                        System.out.println();
                                        disp.PrintMap(gs.GetMap(), gs.GetSettlement(), gs.GetCity(), gs.GetRoad());
                                        disp.PrintScore(gs.GetPlayer(0), gs.GetPlayer(1));
                                        disp.PrintResource(gs.GetResource(gs.GetCurrPlayer().GetId()));
                                        System.out.println();


                                    } else {
                                        System.out.println("Insufficient resource");

                                    }

                                }


                            }

                        } while (buildable != 4);

                        System.out.println();
                        System.out.println("Build Phase End");
                        System.out.println("====================================================================================");
                        System.out.println();
                        System.out.println("Press Enter to Continue");
                        input.nextLine();
                        input.nextLine();

                        gs.SwitchPlayer();

                    }

                    if (gs.CheckWinner(0) == true) {
                        endGame = false;
                        System.out.println("Player 0 win");


                    } else if (gs.CheckWinner(1) == true) {
                        endGame = false;
                        System.out.println("Player 1 win");

                    }
                }

            } else if (option == 2) {

                System.out.println("");
                disp.PrintGameRule();
                System.out.println("");

            } else {
                repeat = false;
                System.out.println("Thank you for playing this game UwU");
            }

        }

    }

}
