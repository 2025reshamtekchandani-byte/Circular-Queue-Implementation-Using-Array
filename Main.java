
import java.util.Scanner;

class Node {
    int playerId;
    String playerName;
    Node next;

    Node(int id, String name) {
        playerId = id;
        playerName = name;
        next = null;
    }
}

public class Main {

    static Node head = null;
    static Node current = null;

    // Insert a new player
    static void insert(int id, String name) {
        Node newNode = new Node(id, name);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
        } else {
            Node temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
        }

        System.out.println("Player added successfully!");
    }

    // Delete a player
    static void delete(int id) {
        if (head == null) {
            System.out.println("Circle is empty!");
            return;
        }

        Node temp = head;
        Node prev = null;

        do {
            if (temp.playerId == id) {

                if (temp == head && temp.next == head) {
                    head = null;
                    current = null;
                } else {
                    if (temp == head) {
                        Node last = head;

                        while (last.next != head) {
                            last = last.next;
                        }

                        head = head.next;
                        last.next = head;
                    } else {
                        prev.next = temp.next;
                    }

                    if (current == temp) {
                        current = temp.next;
                    }
                }

                System.out.println("Player deleted successfully!");
                return;
            }

            prev = temp;
            temp = temp.next;

        } while (temp != head);

        System.out.println("Player not found!");
    }

    // Display all players
    static void display() {
        if (head == null) {
            System.out.println("No players available!");
            return;
        }

        Node temp = head;

        System.out.println("\nPlayers in the Circle:");

        do {
            System.out.println("Player ID: " + temp.playerId);
            System.out.println("Player Name: " + temp.playerName);
            System.out.println("-------------------");

            temp = temp.next;

        } while (temp != head);
    }

    // Move to next player's turn
    static void nextTurn() {
        if (current == null) {
            System.out.println("No players available!");
            return;
        }

        System.out.println("Current Player: " +
                           current.playerName);

        current = current.next;

        System.out.println("Next Player: " +
                           current.playerName);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice, id;
        String name;

        do {
            System.out.println("\n--- Player Turn Management ---");
            System.out.println("1. Insert Player");
            System.out.println("2. Delete Player");
            System.out.println("3. Display Players");
            System.out.println("4. Next Turn");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Player ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Player Name: ");
                    name = sc.nextLine();

                    insert(id, name);
                    break;

                case 2:
                    System.out.print("Enter Player ID to delete: ");
                    id = sc.nextInt();

                    delete(id);
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    nextTurn();
                    break;

                case 5:
                    System.out.println("Exiting Game...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
