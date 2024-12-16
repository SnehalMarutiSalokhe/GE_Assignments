package objectOrientedPrograms;

import java.util.Random;

class Card {
    String suit;
    String rank;

    Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + "_of_" + suit;
    }
}

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}

class Queue<T> {
    private LinkedListNode<T> front;
    private LinkedListNode<T> rear;

    public void enqueue(T data) {
        LinkedListNode<T> newNode = new LinkedListNode<>(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T dequeue() {
        if (front == null) {
            return null;
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return front != null;
    }
}

class Player {
    String name;
    Queue<Card> cardQueue;

    Player(String name) {
        this.name = name;
        this.cardQueue = new Queue<>();
    }

    public void addCard(Card card) {
        cardQueue.enqueue(card);
    }

    public void sortCards() {
        Card[] cards = new Card[9];
        int index = 0;
        while (cardQueue.isEmpty()) {
            cards[index++] = cardQueue.dequeue();
        }


        String[] rankOrder = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (int i = 0; i < cards.length - 1; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                if (getRankIndex(cards[i].rank, rankOrder) > getRankIndex(cards[j].rank, rankOrder)) {
                    Card temp = cards[i];
                    cards[i] = cards[j];
                    cards[j] = temp;
                }
            }
        }


        for (Card card : cards) {
            cardQueue.enqueue(card);
        }
    }

    private int getRankIndex(String rank, String[] rankOrder) {
        for (int i = 0; i < rankOrder.length; i++) {
            if (rank.equals(rankOrder[i])) {
                return i;
            }
        }
        return -1;
    }

    public void printCards() {
        System.out.println(name + "'s cards:");
        while (cardQueue.isEmpty()) {
            System.out.println(cardQueue.dequeue());
        }
        System.out.println();
    }
}

public class DeckExtend {
    public static void main(String[] args) {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        Card[] deck = new Card[52];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = new Card(rank, suit);
            }
        }


        shuffleDeck(deck);


        Queue<Player> playerQueue = new Queue<>();
        for (int i = 1; i <= 4; i++) {
            playerQueue.enqueue(new Player("Player " + i));
        }

        index = 0;
        for (int i = 0; i < 4; i++) {
            Player player = playerQueue.dequeue();
            for (int j = 0; j < 9; j++) {
                player.addCard(deck[index++]);
            }
            player.sortCards();
            playerQueue.enqueue(player);
        }


        while (playerQueue.isEmpty()) {
            Player player = playerQueue.dequeue();
            player.printCards();
        }
    }

    private static void shuffleDeck(Card[] deck) {
        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            int index = random.nextInt(52);
            Card temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }
    }
}
