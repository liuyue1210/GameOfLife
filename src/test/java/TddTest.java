import org.junit.*;
import static org.junit.Assert.assertEquals;

public class TddTest {
    @Test
    public void testGame(){
        Game game=new Game();
        int[][] temp=new int[game.max][game.max];
        int[][] gol=new int[game.max][game.max];
        for (int i=0;i<game.max;i++){
            for (int j=0;j<game.max;j++){
                temp[i][j]=0;
            }
        }
        gol=game.grow(temp);
        boolean flag=true;
        for (int i=0;i<game.max;i++){
            for (int j=0;j<game.max;j++){
                if (gol[i][j]!=0){
                    flag=false;
                }
            }
        }
        assertEquals(true,flag);
    }
}
