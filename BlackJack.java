
package blackjack;
import java.util.Scanner;

public class BlackJack {
    static Game game = new Game();
    static int sum = 0;
    static int counter = 0;
    public static void main(String[] args) {
              
        GUI gui = new GUI();

        game.mycarddeck();
        //game.makedeck();
        game.SetInfoOfPlayers();
        gui.runGUI( game.carddeck
               , game.Players[0].getHand()
                , game.Players[1].getHand()
                , game.Players[2].getHand()
                , game.Players[3].getHand() );
         
         playerturn(gui);
         game.UpdateMaxScore();
         dealersturn(gui);
         //game.UpdateMaxScore();
         checkWIN();  
    }
        
        public static void playerturn (GUI gui) {
        Scanner scanner = new Scanner (System.in); 
           for (int i = 0 ; i < 3 ; i++) {
               while(game.Players[i].Score < 21) {
               System.out.println("Player Num" + (i+1) + " { Hit / Stand } ");
               String input="";
               input = scanner.next();
               //while (!input.toLowerCase().equals("stand"))
               if(input.toLowerCase().equals("hit")) {
               IncreaseCardToPlayer(gui ,i);
           }
               else if (input.toLowerCase().equals("stand")) {
                       break;
                       }
           }
               if (game.Players[i].Score > 21) {
                   System.out.println("Player Num" + (i+1) + "Is Busted");
               } 
               else if (game.Players[i].Score == 21) {
                   //System.out.println("Player Num" + (i+1) + "Is BlackJack");
                   game.Players[i].blackjack = true;
               }
               
           }
        }
        public static void IncreaseCardToPlayer(GUI gui , int index) {
            Card c = game.drawcard();
            game.Players[index].getcard(c);
            gui.updatePlayerHand(c , index);
            //playerturn(gui);
        }
//        public static void dealersturn (GUI gui) {
//            boolean dealerwin = true;
//            int highscore = 0;
//            while (true) {
// //            if (dealerwin=false) {
//                gui.updateDealerHand(game.Players[3].Hand[1] , game.carddeck);
//                IncreaseCardToDealer(gui , highscore);
//            } else {
//                return;
//            }
//         }
//         }
        
        public static void dealersturn (GUI gui) {
            boolean dealerwin = true;
            //int highscore = 0; 
            //int cnt=0;
            game.UpdateMaxScore();
             
                //game.UpdateMaxScore();
                if(game.high != game.Players[3].Score) {
                    
                    dealerwin=false;
                }
                if (game.high == game.Players[3].Score) {
                    //highscore = game.high[i];
                    dealerwin = true;
                }
            
            if (dealerwin == false) {
                System.out.println("It is Dealer Turn");
  
                while(true) {
                    if ((game.Players[3].Score < 21 && game.Players[3].Score == game.high || game.Players[3].Score == 21)) {
                        dealerwin = true;
                        System.out.println("dealer is winner");
                        break;
                    }
                    else {        
                        IncreaseCardToDealer(gui, game.high);
                        game.UpdateMaxScore();
                        if (game.Players[3].Score > 21) {
                            System.out.println("Dealer Is Busted");
                            checkWIN(); 
                            break;
                        }
                            else if (game.Players[3].Score == 21) {
                                    System.out.println("Dealer Is blackJack");
                                    game.Players[3].blackjack = true;
                            break;
                                    }
                        }
                    }
                }
            

            
            
        }
        public static void IncreaseCardToDealer(GUI gui , int highscore) {
            
            while(game.Players[3].Score < highscore) {
               Card c = game.drawcard();
               game.Players[3].getcard(c);
               gui.updateDealerHand(c , game.carddeck);
            }
        }
//        public static void checkPUSH () {
//            if (game.Players[0].Score == game.Players[1].Score
//                 || game.Players[0].Score == game.Players[2].Score
//                    || game.Players[0].Score == game.Players[3].Score
//                 || game.Players[1].Score == game.Players[2].Score
//                    || game.Players[1].Score == game.Players[3].Score
//                    || game.Players[2].Score == game.Players[3].Score) {
//                System.out.println("THAT IS PUSH");
//            }
//        }
        public static void checkWIN() {
            int highscore = 0;
            int winner = -1;
            for (int i = 0 ; i < game.Players.length ; i++) {
               if (game.Players[i].blackjack == true) {
                   System.out.println("Player Num" + (i+1) + "Is BlackJack");
                   counter++;
              }
                if(game.Players[i].Score == game.high) {
                //highscore = game.high[i];
                winner = i;
                sum++;
               }
                
            }
            if (counter == 1) {
                for (int i = 0 ; i < game.Players.length ; i++) {
                    if (game.Players[i].blackjack == true) {               
                System.out.println("Player Num" + (i+1) + "Is Winner");
            }
                }
            }
            else if (winner>=0 && sum == 1) {
                System.out.println("Winner Is" + " " + game.Players[winner].Name + "Scored : " + game.Players[winner].Score);
            }
            else {
                        System.out.println("PUSH");
                        }
       
        }
}
    
        
