import java.util.*;

class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}

public class DeckOfCards {
    public static void main(String[] args) {
        Card[] deck = createDeck();
        Stack<Card> cardStack = new Stack<>();

        // Shuffle the deck
        shuffleDeck(deck);

        // Push 5 cards onto the stack
        for (int i = 0; i < 5; i++) {
            Card randomCard = getRandomCard(deck);
            cardStack.push(randomCard);
        }

        // Pop and reveal the values of the cards
        while (!cardStack.isEmpty()) {
            Card poppedCard = cardStack.pop();
            System.out.println("Revealed Card: " + poppedCard);
        }
    }

    private static Card[] createDeck() {
        String[] ranks = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Heart", "Spade", "Diamond", "Clubs"};

        Card[] deck = new Card[14 * 4];

        int index = 0;
        for (String rank : ranks) {
            for (String suit : suits) {
                deck[index++] = new Card(rank, suit);
            }
        }

        return deck;
    }

    private static void shuffleDeck(Card[] deck) {
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomIndex = rand.nextInt(deck.length);
            Card temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    private static Card getRandomCard(Card[] deck) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(deck.length);
        return deck[randomIndex];
    }
}

