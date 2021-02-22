package com.company;

import com.company.data.interfaces.IDB;
import com.company.entities.Workers;
import com.company.repositories.WorkersRepository;
import com.company.repositories.interfaces.IWorkersRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        IDB db = new com.company.PostgreDB();
        IWorkersRepository WorkersRepository = new WorkersRepository(db) {
            @Override
            public boolean createPrecious(Workers workers) {
                return false;
            }

            @Override
            public List<Workers> getAllWorkers() {
                return null;
            }
        };
        FrontEnd app = new FrontEnd(WorkersRepository);
        app.start();
    }
}

