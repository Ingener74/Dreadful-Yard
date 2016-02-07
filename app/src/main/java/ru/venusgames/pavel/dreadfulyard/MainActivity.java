package ru.venusgames.pavel.dreadfulyard;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import ru.venusgames.pavel.dreadfulyard.database.Contact;
import ru.venusgames.pavel.dreadfulyard.database.ContactDao;
import ru.venusgames.pavel.dreadfulyard.database.DaoMaster;
import ru.venusgames.pavel.dreadfulyard.database.DaoSession;

import static ru.venusgames.pavel.dreadfulyard.database.DaoMaster.*;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase sqLiteDatabase;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private ContactDao contactDao;

    /*
    Полезная ссылка по GreenDao
    https://www.youtube.com/watch?v=zDdu1MlXjZw
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DevOpenHelper devOpenHelper = new DevOpenHelper(this, "YardDataBase", null);
        sqLiteDatabase = devOpenHelper.getWritableDatabase();

        daoMaster = new DaoMaster(sqLiteDatabase);
        daoSession = daoMaster.newSession();
        contactDao = daoSession.getContactDao();

        contactDao.insert(new Contact(null, "MTA1", "+79090896479", "Shnaider Pavel", 0));

        ListView listView = (ListView) findViewById(R.id.mainListView);
        String[] from = new String[]{ContactDao.Properties.ContactName.columnName, ContactDao.Properties.ContactPhoneNumber.columnName};
        int[] to = new int[]{android.R.id.text1, android.R.id.text2};
        listView.setAdapter(new android.support.v4.widget.SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, sqLiteDatabase.query(contactDao.getTablename(), contactDao.getAllColumns(), null, null, null, null, null), from, to));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_test) {

        }

        return super.onOptionsItemSelected(item);
    }
}
