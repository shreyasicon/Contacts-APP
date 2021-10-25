package android.example.sqlitedbm.model;

public class Contact {

    private int id;
    private String name;
    private String phonenumber;

    public Contact(String phonenumber, String name) {
        this.name = name;
        this.phonenumber = phonenumber;
    }

    // Constructor overloading
    public Contact(int id, String name, String phonenumber) {
        this.id = id;
        this.name = name;
        this.phonenumber = phonenumber;
    }

    public Contact() {

    };

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhonenumber(String phonenumber){
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

}
