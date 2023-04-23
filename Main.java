package practiseJDBC;

import newFolder.Movies;
import newFolder.SQL_Connection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void fillOrders(List<Orders> orders){
        newFolder.SQL_Connection db = new SQL_Connection();

        try (PreparedStatement statement = db.getConnection().prepareStatement("INSERT INTO Orders VALUES(?, ?, ?, ?, ?, ?);")){
            for (Orders order : orders) {
                statement.setInt(1, order.getId());
                statement.setInt(2, order.getClient_id());
                statement.setInt(3, order.getItem_id());
                statement.setDate(4, (Date) order.getDate());
                statement.setDouble(5, order.getPrice());
                statement.setInt(6, order.getItem_count());

                statement.addBatch();
            }

            statement.executeBatch();

            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillItems(List<Items> items){
        newFolder.SQL_Connection db = new SQL_Connection();

        try (PreparedStatement statement = db.getConnection().prepareStatement("INSERT INTO Items VALUES(?, ?, ?);")){
            for (Items item : items) {
                statement.setInt(1, item.getId());
                statement.setString(2, item.getName());
                statement.setDouble(3, item.getPrice());

                statement.addBatch();
            }

            statement.executeBatch();

            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillClients(List<Clients> clients){
        newFolder.SQL_Connection db = new SQL_Connection();

        try (PreparedStatement statement = db.getConnection().prepareStatement("INSERT INTO Clients VALUES(?, ?, ?, ?, ?, ?);")){
            for (Clients client : clients) {
                statement.setInt(1, client.getId());
                statement.setString(2, client.getName());
                statement.setString(3, client.getAddress());
                statement.setString(4, client.getEmail());
                statement.setDate(5, (Date) client.getBirthday());
                statement.setInt(6, client.getPhone());

                statement.addBatch();
            }

            statement.executeBatch();

            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addToOrders(Orders order){
        newFolder.SQL_Connection db = new SQL_Connection();

        try (PreparedStatement statement = db.getConnection().prepareStatement("INSERT INTO Orders VALUES(?, ?, ?, ?, ?, ?);")){
            statement.setInt(1, order.getId());
            statement.setInt(2, order.getClient_id());
            statement.setInt(3, order.getItem_id());
            statement.setDate(4, (Date) order.getDate());
            statement.setDouble(5, order.getPrice());
            statement.setInt(6, order.getItem_count());

            statement.execute();

            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addToItems(Items item){
        newFolder.SQL_Connection db = new SQL_Connection();

        try (PreparedStatement statement = db.getConnection().prepareStatement("INSERT INTO Items VALUES(?, ?, ?);")){
            statement.setInt(1, item.getId());
            statement.setString(2, item.getName());
            statement.setDouble(3, item.getPrice());

            statement.execute();

            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addToClients(Clients client){
        newFolder.SQL_Connection db = new SQL_Connection();

        try (PreparedStatement statement = db.getConnection().prepareStatement("INSERT INTO Clients VALUES(?, ?, ?, ?, ?, ?);")){
            statement.setInt(1, client.getId());
            statement.setString(2, client.getName());
            statement.setString(3, client.getAddress());
            statement.setString(4, client.getEmail());
            statement.setDate(5, (Date) client.getBirthday());
            statement.setInt(6, client.getPhone());

            statement.execute();

            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateOrders(Orders order){
        newFolder.SQL_Connection db = new SQL_Connection();

        int id = order.getId();

        try (PreparedStatement statement = db.getConnection().prepareStatement("UPDATE Orders SET item_count=item_count+1 WHERE id=?;")){
            statement.setInt(1, id);
            statement.execute();

            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteOrders(Orders order){
        newFolder.SQL_Connection db = new SQL_Connection();

        int id = order.getId();

        try (PreparedStatement statement = db.getConnection().prepareStatement("DELETE FROM Orders WHERE id=?;")){
            statement.setInt(1, id);
            statement.execute();

            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateItems(Items item){
        newFolder.SQL_Connection db = new SQL_Connection();

        int id = item.getId();

        try (PreparedStatement statement = db.getConnection().prepareStatement("UPDATE Items SET price=price+1 WHERE id=?;" +
                "UPDATE Items SET name='newItem' WHERE id=?;")){
            statement.setInt(1, id);
            statement.setInt(2, id);
            statement.execute();

            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteItems(Items item){
        newFolder.SQL_Connection db = new SQL_Connection();

        int id = item.getId();

        try (PreparedStatement statement = db.getConnection().prepareStatement("DELETE FROM Items WHERE id=?;")){
            statement.setInt(1, id);
            statement.execute();

            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateClients(Clients client){
        newFolder.SQL_Connection db = new SQL_Connection();

        int id = client.getId();

        try (PreparedStatement statement = db.getConnection().prepareStatement("UPDATE Clients SET phone=phone+1 WHERE id=?;")){
            statement.setInt(1, id);
            statement.execute();

            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteClients(Clients client){
        newFolder.SQL_Connection db = new SQL_Connection();

        int id = client.getId();

        try (PreparedStatement statement = db.getConnection().prepareStatement("DELETE FROM Clients WHERE id=?;")){
            statement.setInt(1, id);
            statement.execute();

            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getAllOrders(){
        newFolder.SQL_Connection db = new SQL_Connection();

        StringBuilder s = new StringBuilder();

        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Orders;");

            while(rs.next()){
                s.append(rs.getString("price")).append(", ");
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(s);
    }

    public static void getAllItems(){
        newFolder.SQL_Connection db = new SQL_Connection();

        StringBuilder s = new StringBuilder();

        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Items;");

            while(rs.next()){
                s.append(rs.getString("name")).append(", ");
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(s);
    }

    public static void getAllClients(){
        newFolder.SQL_Connection db = new SQL_Connection();

        StringBuilder s = new StringBuilder();

        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Clients;");

            while(rs.next()){
                s.append(rs.getString("name")).append(", ");
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(s);
    }

    public static void main(String[] args) {
        List<Orders> orders = new ArrayList<>();

        orders.add(new Orders(123, 7695, 80, 	Date.valueOf("1988-09-29"), 400, 15));
        orders.add(new Orders(695, 3923, 70, Date.valueOf("1998-09-29"), 300, 10));
        orders.add(new Orders(903, 5994, 60, Date.valueOf("2008-09-29"), 200, 5));

        List<Items> items = new ArrayList<>();

        items.add(new Items(563, "Bike", 400));
        items.add(new Items(929, "TV", 1200));
        items.add(new Items(804, "Pencil", 2));

        List<Clients> clients = new ArrayList<>();

        clients.add(new Clients(487, "clientA", "A street", "A@gmail.com", Date.valueOf("2000-01-20"), 987));
        clients.add(new Clients(832, "clientB", "B street", "B@gmail.com", Date.valueOf("2005-01-20"), 654));
        clients.add(new Clients(332, "clientC", "C street", "C@gmail.com", Date.valueOf("2010-01-20"), 321));

        fillOrders(orders);
        fillItems(items);
        fillClients(clients);

        addToOrders(new Orders(232, 5993, 50, Date.valueOf("2018-09-29"), 100, 1));
        addToItems(new Items(821, "Skates", 100));
        addToClients(new Clients(934, "clientD", "D street", "D@gmail.com", Date.valueOf("2015-01-20"), -123));

        updateOrders(new Orders(232, 5993, 50, Date.valueOf("2018-09-29"), 100, 1));
        deleteOrders(new Orders(232, 5993, 50, Date.valueOf("2018-09-29"), 100, 2));

        updateItems(new Items(821, "Skates", 100));
        deleteItems(new Items(821, "newItem", 101));

        updateClients(new Clients(934, "clientD", "D street", "D@gmail.com", Date.valueOf("2015-01-20"), -123));
        deleteClients(new Clients(934, "clientD", "D street", "D@gmail.com", Date.valueOf("2015-01-20"), -122));

        getAllOrders();
        getAllItems();
        getAllClients();

    }
}
