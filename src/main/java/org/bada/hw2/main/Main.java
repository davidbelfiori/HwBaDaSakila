package org.bada.hw2.main;

import org.bada.hw2.eccezioni.NessunCustomerTrovato;
import org.bada.hw2.model.Customer;
import org.bada.hw2.dao.CustomerDAO;
import org.bada.hw2.utility.Printer;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int scelta;

        Scanner scanner = new Scanner(System.in);
        Printer.print("scgli tra:\n 1 Clienti che hanno noleggiato almeno un film in ciascuna categoria \n 2 Clienti che hanno noleggiato più film rispetto alla media dei clienti, ordinati per numero di noleggi");

        scelta = scanner.nextInt();
        switch (scelta) {
            case 1:


                try {
                    List<Customer> customers = CustomerDAO.getAllCustomersCategories();
                    int i = 0;
                    for (Customer c : customers) {
                       Printer.print(i++ +")" +"Nome: " + c.getFristName() + "Cognome " + c.getLastName());

                    }
                } catch (Exception e) {
                    throw new NessunCustomerTrovato("non ci sono Clienti che hanno noleggiato almeno un film in ciascuna categoria");
                }
                break;

            case 2:
                try {
                    List<Customer> customers = CustomerDAO.getAllCustomerAvgRent();
                    int i = 0;
                    for (Customer c : customers) {
                        Printer.print(i++ +")" +"Nome: " + c.getFristName() + "Cognome " + c.getLastName());

                    }
                } catch (Exception e) {
                    throw new NessunCustomerTrovato("non ci sono  Clienti che hanno noleggiato più film rispetto alla media dei clienti");
                }
                break;

            default: break;
        }

    }
}
