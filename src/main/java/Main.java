import model.Customer;
import model.dao.CustomerDAO;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int scelta;

        Scanner scanner = new Scanner(System.in);

        System.out.println("scgli tra:\n 1 Clienti che hanno noleggiato almeno un film in ciascuna categoria \n 2 Clienti che hanno noleggiato più film rispetto alla media dei clienti, ordinati per numero di noleggi");
        scelta = scanner.nextInt();
        switch (scelta) {
            case 1:


                try {
                    List<Customer> customers = CustomerDAO.getAllCustomersCategories();
                    int i = 0;
                    for (Customer c : customers) {
                        System.out.println(i++ +")" +"Nome: " + c.getFristName() + "Cognome " + c.getLastName());

                    }
                } catch (Exception e) {
                    e.printStackTrace(); //stampo lo stack delle chiamate
                }
                break;

            case 2:
                try {
                    List<Customer> customers = CustomerDAO.getAllCustomerAvgRent();
                    int i = 0;
                    for (Customer c : customers) {
                        System.out.println(i++ +")" +"Nome: " + c.getFristName() + "Cognome " + c.getLastName());

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            default: break;
        }

    }
}
