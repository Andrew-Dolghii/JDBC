package practiseJDBC;

import java.util.Date;

public class Orders {
    private int id;
    private int client_id;
    private int item_id;
    private Date date;
    private double price;
    private int item_count;

    public Orders(int id, int client_id, int item_id, java.sql.Date date, double price, int item_count) {
        this.id = id;
        this.client_id = client_id;
        this.item_id = item_id;
        this.date = date;
        this.price = price;
        this.item_count = item_count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getItem_count() {
        return item_count;
    }

    public void setItem_count(int item_count) {
        this.item_count = item_count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", client_id=" + client_id +
                ", item_id=" + item_id +
                ", date=" + date +
                ", price=" + price +
                ", item_count=" + item_count +
                '}';
    }
}
