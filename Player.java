/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author Zeyad
 */
public class Player {
    public String Name;
    public int Score = 0;
    public Card[] Hand = new Card[11];
    public int cardcnt=0;
    boolean blackjack = false;
    Game game = new Game();
    public void getcard(Card c) {
          game.mycarddeck();
        //  game.makedeck();
        if (cardcnt < 11) {
            Hand[cardcnt] = c;
            cardcnt++;
            Score += c.getValue();
        }
    }

    
    

    public Card[] getHand() {
        return this.Hand;
    }
    
}
