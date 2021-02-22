package com.company.repositories.interfaces;

import com.company.entities.Workers;
import com.company.entities.Workers;

import java.util.List;

public interface IWorkersRepository
{
    boolean createPrecious(Workers workers);

    boolean createWorkers(Workers workers);
    Workers getWorkers(int id);
    List<Workers> getAllWorkers();
}