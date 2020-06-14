package com.example.navbarzzleep;

import com.example.navbarzzleep.Mine.MineViewModel;
import com.example.navbarzzleep.pokemonProfil.ProfileViewModel;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class ExampleUnitTest {

    private MineViewModel mineViewModel;
    private ProfileViewModel profileViewModel;

    @Before
    public void setup()
    {
       mineViewModel = new MineViewModel();
       profileViewModel = new ProfileViewModel(null);
    }

    @Test
    public void testSetGetTestingGoldM()
    {
        mineViewModel.setTestingGold(25);
        assertEquals(25,mineViewModel.getTestingGold());

    }

    @Test
    public void spendGoldM()
    {
        mineViewModel.setTestingGold(25);
        assertEquals(25,mineViewModel.getTestingGold());
        mineViewModel.setTestingGold(15);
        assertEquals(15,mineViewModel.getTestingGold());

    }

    @Test
    public void testSetGetTestingGoldP()
    {
        profileViewModel.setTestingGold(25);
        assertEquals(25,profileViewModel.getTestingGold());

    }

    @Test
    public void spendGoldP()
    {
        profileViewModel.setTestingGold(25);
        assertEquals(25,profileViewModel.getTestingGold());
        profileViewModel.setTestingGold(15);
        assertEquals(15,profileViewModel.getTestingGold());

    }


}