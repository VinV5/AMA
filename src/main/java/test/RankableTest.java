package test;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Vincent on 2017-03-13.
 */
public class RankableTest {

    private int points = 0;
    private int prevpoints = 0;

    @Test
    public void testUpvote(){
        prevpoints = points;
        points++;
        assertTrue(points > prevpoints);
    }

    @Test
    public void testDownvote(){
        points = 1;
        prevpoints = points;
        points--;
        assertTrue(points < prevpoints);
    }

}
