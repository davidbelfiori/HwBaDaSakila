package model.dao;

import model.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public  static  List<Customer> getAllCustomerAvgRent() throws  Exception{
        Statement stmt= null;
        Connection conn=null;
        List<Customer> listOfCustomer = new ArrayList<>();

        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs= stmt.executeQuery("""
                    select count(rental_id) as num, c.first_name,c.last_name,c.customer_id
                    from rental join sakila.customer c on c.customer_id = rental.customer_id
                    group by c.customer_id
                    having num >= (
                    select avg(num_noleggi)
                    from (
                        select count(rental_id) as num_noleggi
                          from rental
                          group by rental.customer_id
                    ) as noleggi_per_cliente);""");

            if (!rs.first()) {
                throw new Exception("Non esiste alcun cliente che ha noleggiato almeno un film di ogni categoria ");
            }

            rs.first();

            do {
                int customentId=rs.getInt("customer_id");
                String fristName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                listOfCustomer.add(new Customer(customentId,fristName,lastName));
            }while (rs.next());

        }finally {
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        }

        return listOfCustomer;
    }




    public static List<Customer> getAllCustomersCategories() throws Exception{
        Statement stmt= null;
        Connection conn=null;
        List<Customer> listOfCustomer = new ArrayList<>();

        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs= stmt.executeQuery("""
                    SELECT customer.customer_id, customer.first_name, customer.last_name
                    FROM customer
                             JOIN rental ON customer.customer_id = rental.customer_id
                             JOIN inventory ON rental.inventory_id = inventory.inventory_id
                             JOIN film ON inventory.film_id = film.film_id
                             JOIN film_category ON film.film_id = film_category.film_id
                             JOIN category ON film_category.category_id = category.category_id
                    GROUP BY  customer.first_name, customer.last_name
                    HAVING COUNT(DISTINCT category.category_id) = (SELECT COUNT(*) FROM category);""");

            if (!rs.first()) {
                throw new Exception("Non esiste alcun cliente che ha noleggiato almeno un film di ogni categoria ");
            }

            rs.first();

            do {
                int customentId=rs.getInt("customer_id");
                String fristName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                listOfCustomer.add(new Customer(customentId,fristName,lastName));
            }while (rs.next());

        }finally {
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        }

        return listOfCustomer;
    }

}
