package com.company;

import com.company.entities.Workers;
import com.company.repositories.interfaces.IWorkersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FrontEnd
{
    private final com.company.controllers.WorkersControler controller;
    private final Scanner scanner;

    public FrontEnd(IWorkersRepository workersRepository){
        controller = new com.company.controllers.WorkersControler(workersRepository);
        scanner = new Scanner(System.in);
    }
    /**
     * Method, which start of my company and the information about worker
     *
     */

    public void start()
    {
        while (true)
        {
            System.out.println();
            System.out.println("Welcome to My Company");
            System.out.println("Select the option:");
            System.out.println("1. Get all Workers");
            System.out.println("2. Get Workers by id");
            System.out.println("3. Add Workers");
            System.out.println("4. Create your team");
            System.out.println("0. Exit");
            System.out.println();

            try {
                System.out.print("Enter option (1-6): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllPreciousMenu();
                }else if(option == 2){
                    getPreciousByIdMenu();
                }else if(option == 3){
                    createPreciousMenu();
                }else if (option == 4){
                    createNecklaceMenu();
                }
                else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }

    }

    public void getAllPreciousMenu() {
        String response = controller.getAllWorkers();
        System.out.println(response);
    }

    public void getPreciousByIdMenu() {
        System.out.println("Please enter your id");

        int id = scanner.nextInt();
        Workers workers = controller.getWorkers(id);
        System.out.println((workers == null ? "This worker was not found!" : workers.toString()));
    }

    public void createPreciousMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter cost");
        int cost = scanner.nextInt();
        System.out.println("Is it experienced?");
        boolean precious = scanner.nextBoolean();

        String response = controller.createPrecious(name, cost, precious);
        System.out.println(response);
    }

    public void createNecklaceMenu() {
        List<Workers> stones = new ArrayList<>();
        while (true){
            System.out.println();
            System.out.println("Welcome to creation of team");
            System.out.println("Select the option:");
            System.out.println("1. Add Worker to the Team");
            System.out.println("2. Go back");
            System.out.println("3. Start again");
            System.out.println("4. My Teams");
            System.out.println("0. Finish");
            System.out.println();

            try {
                System.out.print("Enter option (1-6): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    addStoneToNecklaceMenu(stones);
                } else if (option == 2) {
                    stones.remove(stones.size()-1);
                    System.out.println("Successfully removed last Worker!");
                } else if(option == 3){
                    stones.clear();
                    System.out.println("Successfully removed Team");
                } else if(option == 4){
                    myNecklace(stones);
                }

                else {
                    System.out.println(controller.calculateNecklace(stones));
                    myNecklace(stones);
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");
        }
    }

    public void addStoneToNecklaceMenu(List<Workers> stones){
        getAllPreciousMenu();
        System.out.println("Choose id of Worker from the list: ");

        int choice = scanner.nextInt();
        stones.add(controller.getWorkers(choice));
    }


    public void myNecklace(List<Workers> stones){
        System.out.println("Your Team consist of: ");
        for(int i=0;i<stones.size();i++){
            System.out.println(stones.get(i).getName() + ", ");
        }
    }
}
