package machine;

import java.util.Scanner;


public class CoffeeMachine {


    public Scanner input = new Scanner(System.in);

    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;


    public CoffeeMachine(int water, int milk, int coffeeBeans, int cups,int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }



    public  void coffeeMachineStatus() {

        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");


    }



    public  void fillMachine() {

        System.out.println("Write how many ml of water do you want to add:");
        int numOfWaterAvailableInput = input.nextInt();
        water +=numOfWaterAvailableInput;
        System.out.println("Write how many ml of milk do you want to add:");
        int numOfMilkAvailableInput = input.nextInt();
        milk += numOfMilkAvailableInput;
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int numOfCoffeeBeansAvailableInput = input.nextInt();
        coffeeBeans += numOfCoffeeBeansAvailableInput;
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int numOfCups = input.nextInt();
        cups += numOfCups;


    }

    public  void coffeeMachineChoice() {

            boolean isOff = false;

            while (!isOff) {
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                String choice = input.next();

                switch (choice) {

                    case "buy":
                        buyCoffee();
                        break;
                    case "fill":
                        fillMachine();
                        break;
                    case "take":
                        takeMoney();
                        break;
                    case "remaining":
                        coffeeMachineStatus();
                        break;
                    case "exit":
                        isOff = true;
                        break;


            }
        }


        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }




    public  void buyCoffee() {
        boolean resources = true;
        boolean back = false;
        int choice = 0;

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        if(input.hasNext() && input.equals("back")) {
            back = true;
        } else if(input.hasNextInt()) {
            choice = input.nextInt();
        }

        if(!back) {

            if (cups < 1) {
                System.out.println("Sorry, not enough cups!");
                resources = false;
            } else if (choice == 1) {
                if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                    resources = false;
                } else if (coffeeBeans < 16) {
                    System.out.println("Sorry, not enough coffeeBeans!");
                }

            } else if (choice == 2) {
                if (water < 350) {
                    System.out.println("Sorry, not enough water!");
                    resources = false;
                } else if (milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                    resources = false;
                } else if (coffeeBeans < 20) {
                    System.out.println("Sorry, not enough coffeeBeans!");
                    resources = false;
                }
            } else if (choice == 3) {
                if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                    resources = false;
                } else if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                    resources = false;
                } else if (coffeeBeans < 12) {
                    System.out.println("Sorry, not enough coffeeBeans!");
                    resources = false;
                }
            }


            if (resources) {
                switch (choice) {

                    case 1:
                        water -= 250;
                        coffeeBeans -= 16;
                        money += 4;
                        cups -= 1;
                        break;
                    case 2:
                        water -= 350;
                        milk -= 75;
                        coffeeBeans -= 20;
                        money += 7;
                        cups -= 1;
                        break;
                    case 3:
                        water -= 200;
                        milk -= 100;
                        coffeeBeans -= 12;
                        money += 6;
                        cups -= 1;
                        break;
                }
            }

        }
    }


    public void takeMoney() {

        System.out.println("I gave you " + money);
        money -= money;
    }



}

