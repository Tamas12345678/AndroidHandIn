package com.example.navbarzzleep;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.navbarzzleep.local_database.LocalDatabase;
import com.example.navbarzzleep.local_database.PocketDAO;
import com.example.navbarzzleep.local_database.entity.Pocket;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LocalDatabaseTest {



    private PocketDAO pocketDAO;
    private LocalDatabase localDatabase;

    private Pocket pocket;

    @Before
    public void createDataBase()
    {
        Context context = ApplicationProvider.getApplicationContext();
        localDatabase = Room.inMemoryDatabaseBuilder(context, LocalDatabase.class).build();
        pocketDAO = localDatabase.pocketDAO();
    }

    @After
    public void exitDatabase() throws IOException
    {
        localDatabase.close();
    }



     @Test
    public void writeandreadToDoTEST() throws IOException {


        pocket = new Pocket("hehe");


        pocketDAO.addText(pocket);
         pocketDAO.addText(pocket);
         pocketDAO.addText(pocket);
         pocketDAO.addText(pocket);


         //since it is LiveData it gives me a null pointer exeption when I want to get the size
        assertThat(pocketDAO.getAllText().getValue().size(),equalTo(1));

    }


}
