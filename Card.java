/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package blackjack;

/**
 *
 * @author Zeyad
 */
public class Card {

    private final int suit; //represtent the suit of card (0>> club , 1>> diamond , 2>> heart , 3>> spade).
    private final int rank; //represnt rank of card in array
    private final int value; // represnt the value of the card

    // Normal Paramtilzed Constractour
    public Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    // Copy Constractour
    public Card(Card c) {
        this.suit = c.suit;
        this.rank = c.rank;
        this.value = c.value;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
    
}
