package com.company.controllers;

import com.company.entities.Workers;
import com.company.repositories.WorkersRepository;
import com.company.repositories.interfaces.IWorkersRepository;

import java.util.ArrayList;
import java.util.List;

public class WorkersControler
{
    private final IWorkersRepository workersRepository;

    public WorkersControler(IWorkersRepository workersRepository){
        this.workersRepository = workersRepository;
    }

    public String createPrecious(String name, int cost, boolean experienced)
    {
        Workers stone = new Workers(name, cost, experienced);

        boolean created = workersRepository.createWorkers(stone);

        return (created ? "Workers was created!" : "Workers creation was failed!");
    }

    public Workers getWorkers(int id) {
        Workers workers = workersRepository.getWorkers(id);

        return workers;
    }

    public String getAllWorkers() {
        List<Workers> workers = workersRepository.getAllWorkers();

        return workers.toString();
    }

    public String calculateNecklace(List<Workers> stones){

        Integer cost = 0;
        for(int i=0;i<stones.size();i++){

            cost = cost + stones.get(i).getCost();
        }

        return " total cost: " + cost.toString();
    }
}
