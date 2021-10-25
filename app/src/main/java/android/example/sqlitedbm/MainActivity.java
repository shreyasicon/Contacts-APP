package android.example.sqlitedbm;

import androidx.appcompat.app.AppCompatActivity;

import android.example.sqlitedbm.dbms.MyDbHandler;
import android.example.sqlitedbm.model.Contact;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDbHandler dbHandler = new MyDbHandler(MainActivity.this);

        // Creating contacts object to the db
        Contact Sai = new Contact();
        Sai.setPhonenumber("9353829662");
        Sai.setName("Sai");

        // Adding contacts to the db
        dbHandler.addContact(Sai);

        // Creating contacts object to the db
        Contact Shreyas = new Contact();
        Shreyas.setPhonenumber("9353829410");
        Shreyas.setName("Shreyas");

        // Adding contacts to the db
        dbHandler.addContact(Shreyas);

        Log.d("dbms", "Id for Sai N Shreyas" + Sai.getId() + Shreyas.getId());

        // updating list
        //Shreyas.setId("" );
        Shreyas.setName("Changed to Arjun");
        Shreyas.setPhonenumber("1234567890");
        int affectedRows = dbHandler.updateContact(Shreyas);

        Log.d("dbms", "N0.of affected rows are: " + affectedRows);

        // Getting all the Contacts
        List<Contact> allContacts = dbHandler.getAllContacts();
        for (Contact contact: allContacts){
            Log.d("dbms", "Id: " + contact.getId() + "\n" +
                     "Name: " + contact.getName() + "\n" +
                     "Phone Number: " + contact.getPhonenumber() + "\n");
        }

    }
}
