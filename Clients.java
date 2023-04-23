package practiseJDBC;

import java.util.Date;

public class Clients {
    private int id;
    private String name;
    private String address;
    private String email;
    private Date birthday;
    private int phone;

    public Clients(int id, String name, String address, String email, Date birthday, int phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.birthday = birthday;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", phone=" + phone +
                '}';
    }
}
