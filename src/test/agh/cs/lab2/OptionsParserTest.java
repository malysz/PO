package agh.cs.lab2;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class OptionsParserTest {
    @Test
    public void parseTest(){
        String[] arg ={"forward","f","backward","b","right","l"};
        //MoveDirection[] res=OptionsParser.parse(arg);
        MoveDirection[] tab={MoveDirection.Forward,MoveDirection.Forward,MoveDirection.Backward,
                MoveDirection.Backward,MoveDirection.Right,MoveDirection.Left};
        assertArrayEquals(tab,OptionsParser.parse(arg));
    }
}