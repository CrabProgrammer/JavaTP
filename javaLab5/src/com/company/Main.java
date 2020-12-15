package com.company;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player("Artem");
        Enemy enemy = new Enemy("TP");
        while (player.getHealth() > 0 && enemy.getHealth() > 0)
        {
            System.out.println("Enter number from " + Integer.toString(Person.min) +
                    " to " + Integer.toString(Person.max) + ":");
            int number = scanner.nextInt();
            byte playerRes = player.Attack(enemy, number);
            switch (playerRes)
            {
                case 1:
                    System.out.println("Miss. Number is bigger");
                    break;
                case -1:
                    System.out.println("Miss. Number is lower");
                    break;
                default:
                    int enemyHealth = enemy.getHealth();
                    if (enemyHealth > 0)
                        System.out.printf("You are correct. Now %s have %d hp!\n", enemy.getName(), enemyHealth);
                    else
                        System.out.printf("You killed %s!\n", enemy.getName());
            }

            if (enemy.attack(player))
            {
                int playerHealth = player.getHealth();
                if (playerHealth > 0)
                    System.out.printf("Enemy hit you! %s have %d hp.\n", player.getName(), playerHealth);
                else
                    System.out.println("You are dead!");
            }
            else
                System.out.println("Enemy is missing.");
        }
        scanner.close();
    }
}