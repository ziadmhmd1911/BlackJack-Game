/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Zeyad
 */
public class Game {
    Scanner scanner = new Scanner(System.in);
    public Player[] Players = new Player[4]; 
    public Card[] carddeck = new Card[52];
    public int high = 0;  
    

       public void mycarddeck () {
            carddeck[0] = new Card(0,0,1); // 1
            carddeck[1] = new Card(0,1,2); // 2
            carddeck[2] = new Card(0,2,3); // 3
            carddeck[3] = new Card(0,3,4); // 4
            carddeck[4] = new Card(0,4,5); // 5
            carddeck[5] = new Card(0,5,6); // 6
            carddeck[6] = new Card(0,6,7); // 7 
            carddeck[7] = new Card(0,7,8); // 8
            carddeck[8] = new Card(0,8,9); // 9 
            carddeck[9] = new Card(0,9,10); // 10
            carddeck[10] = new Card(0,10,10); // J
            carddeck[11] = new Card(0,11,10); // Q
            carddeck[12] = new Card(0,12,10); // K
            carddeck[13]= new Card(1,0,1); // 1
            carddeck[14]= new Card(1,1,2); // 2
            carddeck[15]= new Card(1,2,3); // 3
            carddeck[16]= new Card(1,3,4); // 4
            carddeck[17]= new Card(1,4,5); // 5
            carddeck[18]= new Card(1,5,6); // 6
            carddeck[19]= new Card(1,6,7); // 7
            carddeck[20]= new Card(1,7,8); // 8
            carddeck[21]= new Card(1,8,9); // 9 
            carddeck[22]= new Card(1,9,10); // 10
            carddeck[23]= new Card(1,10,10); // J
            carddeck[24]= new Card(1,11,10); // Q
            carddeck[25]= new Card(1,12,10); // K
            carddeck[26]= new Card(2,0,1); // 1
            carddeck[27]= new Card(2,1,2); // 2
            carddeck[28]= new Card(2,2,3); // 3
            carddeck[29]= new Card(2,3,4); // 4
            carddeck[30]= new Card(2,4,5); // 5
            carddeck[31]= new Card(2,5,6); // 6
            carddeck[32]= new Card(2,6,7); // 7
            carddeck[33]= new Card(2,7,8); // 8
            carddeck[34]= new Card(2,8,9); // 9
            carddeck[35]= new Card(2,9,10); // 10
            carddeck[36]= new Card(2,10,10); // J
            carddeck[37]= new Card(2,11,10); // Q
            carddeck[38]= new Card(2,12,10); // K
            carddeck[39] = new Card(3,0,1); // 1
            carddeck[40] = new Card(3,1,2); // 2
            carddeck[41] = new Card(3,2,3); // 3
            carddeck[42] = new Card(3,3,4); // 4 
            carddeck[43] = new Card(3,4,5); // 5
            carddeck[44] = new Card(3,5,6); // 6 
            carddeck[45] = new Card(3,6,7); // 7 
            carddeck[46] = new Card(3,7,8); // 8
            carddeck[47] = new Card(3,8,9); // 9
            carddeck[48] = new Card(3,9,10); // 10
            carddeck[49] = new Card(3,10,10); // J
            carddeck[50] = new Card(3,11,10); // Q
            carddeck[51] = new Card(3,12,10); // K
    } 

    
   // public void makedeck() {
    //    int cnt=0;
       //  for (int i = 0 ; i < 4 ; i++) {
         //   for (int k = 0 ; k < 13 ; k++) {
           //      int val;
             //    if (k>=10) {
               //      val = 10;
                 //}
                   //  else {
                     //        val = k+1;
                       //      }
             //    Card c = new Card (k , i , val);
              //   carddeck[cnt] = c;
                // cnt++;
  //          }
    //    }
   // }
    
    public Card drawcard() {
        Random rand = new Random();
        Card c = null;
        
        do {
            int randomchoice = rand.nextInt(52);
            c = carddeck[randomchoice];
            carddeck[randomchoice]=null;        
        }
        while ( c == null );
            
        
        
      
        return c;
    }

    public void SetInfoOfPlayers() {
        for (int i = 0 ; i < Players.length - 1 ; i++){ //all players without dealer
            Players[i] = new Player();
            Players[i].Name = ("p" + (i+1));
            Players[i].getcard(drawcard());
            Players[i].getcard(drawcard());
    }
            Players[3] = new Player();
            Players[3].Name = "dealer";
            Players[3].getcard(drawcard());
            Players[3].getcard(drawcard());
            
}
    
    
    public void UpdateMaxScore() {
        for (int i = 0 ; i < 4 ; i++) {
            if (high < Players[i].Score && Players[i].Score <= 21) {
                high = Players[i].Score;
            }
          //  high[i] = Players[i].Score <= 21 ? Players[i].Score : 0 ;
        } 
    }
    


}
