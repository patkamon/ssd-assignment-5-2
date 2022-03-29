package agarssd.client;

import agarssd.model.Item;
import agarssd.model.MoveCommand;
import agarssd.model.Player;
import agarssd.model.World;

import java.util.List;
import java.util.Random;


public class Strategy {

    //run away from biggest
    public MoveCommand coward(List<Player> players,Player player,int size) {
        float min = 10000;
        Player target = players.get(0);
        for (Player p: players){
            if (player.distance(p) < min && p != player){
                target = p;
                min = player.distance(p);
            }
        }
        MoveCommand command = new MoveCommand();
        command.toX = size-target.positionX;
        command.toY = size-target.positionY;
        return command;
    }


    // nerd take most item
    public MoveCommand nerd(List<Item> items,Player player) {
        float min = 10000;
        Item target = items.get(0);
        for (Item i: items){
            if (player.distance(i) < min){
                target = i;
                min = player.distance(i);
            }
        }
        MoveCommand command = new MoveCommand();
        command.toX = target.positionX;
        command.toY = target.positionY;
        return command;
    }


    // berserk run to every player
    public MoveCommand berserk(List<Player> players,Player player) {
        float min = 10000;
        Player target = players.get(0);
        for (Player p: players){
            if (player.distance(p) < min && p != player){
                target = p;
                min = player.distance(p);
            }
        }
        MoveCommand command = new MoveCommand();
        command.toX = target.positionX;
        command.toY = target.positionY;
        return command;
    }
}
