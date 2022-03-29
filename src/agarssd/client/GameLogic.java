package agarssd.client;

import agarssd.model.Item;
import agarssd.model.MoveCommand;
import agarssd.model.Player;
import agarssd.model.World;

import java.util.List;
import java.util.Random;

public class GameLogic {

    private Random random = new Random();
    private long lastCommand;
    private Strategy strategy = new Strategy();

    public MoveCommand getNextMoveCommand(World world, Player myPlayer) {
        if(world == null) {
            return null;
        }
        long diff = System.currentTimeMillis() - lastCommand;
        if(diff < 5000) {
            return null;
        }
        // only 1 :nerd
        if (world.players.size()==1){
            return strategy.nerd(world.items, myPlayer);
        }
        for (Player p: world.players){
            // not biggest :coward
            if (myPlayer.size < p.size ){
                return strategy.nerd(world.items, myPlayer);
            }
        }
        // biggest :berserk
        System.out.println(myPlayer + "berserk");
        return strategy.berserk(world.players,myPlayer);
    }
}
