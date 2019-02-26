package assignmentFourGame;

import org.junit.Test;

import static org.junit.Assert.*;

public class HavstaTest {

    @Test
    public void isMatch(){
        assertTrue(Havsta.isMatch("abc", "ABC"));
        assertTrue(Havsta.isMatch("a", "ABC"));
        assertTrue(Havsta.isMatch("aBc", "ABC"));
        assertTrue(Havsta.isMatch("aBc", "abc"));
        assertTrue(Havsta.isMatch("ye", "yes"));
        assertTrue(Havsta.isMatch("N", "no"));

        assertFalse(Havsta.isMatch("abh", "abc"));
        assertFalse(Havsta.isMatch("abh", "abcc"));
        assertFalse(Havsta.isMatch("yip", "yes"));
        assertFalse(Havsta.isMatch("noo", "no"));


    }

    @Test
    public void moveName(){
        assertEquals("Applaro",Havsta.moveName(1));
        assertEquals("Svartrå",Havsta.moveName(2));
        assertEquals("Tunholmen",Havsta.moveName(3));
        assertEquals("Godafton",Havsta.moveName(4));

    }

    @Test
    public void userWin(){
        //Else

        //Losses
        assertFalse(Havsta.userWins(1,4));
        assertFalse(Havsta.userWins(2,4));
        assertFalse(Havsta.userWins(2,1));
        assertFalse(Havsta.userWins(3,1));
        assertFalse(Havsta.userWins(4,3));
        assertFalse(Havsta.userWins(3,2));

        //Ties (Losses)
        assertFalse(Havsta.userWins(1,1));
        assertFalse(Havsta.userWins(2,2));
        assertFalse(Havsta.userWins(3,3));
        assertFalse(Havsta.userWins(4,4));
    }

    @Test
    public void randomNum(){
        assertTrue(Havsta.randomNum()>=Havsta.MIN && Havsta.randomNum()<=Havsta.MAX);
    }

}