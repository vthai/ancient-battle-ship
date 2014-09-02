package org.vthai.game.ancientbattleship.battlefield.queue;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.vthai.game.ancientbattleship.battlefield.command.Command;
import org.vthai.game.ancientbattleship.battlefield.command.CommandType;
import org.vthai.game.ancientbattleship.battlefield.coordinate.Coordinate;
import org.vthai.game.ancientbattleship.ships.Fleet;
import org.vthai.game.ancientbattleship.ships.Ship;
import org.vthai.game.ancientbattleship.ships.TigerShip;

public class BattleQueueTest {
   private final String blueFleetName = "Tiago";

   private final String redFleetName = "Mimosa";

   private final String[] fleetNames = new String[] { blueFleetName, redFleetName };

   private BattleQueue<Command> battleQueue = new BattleQueue<Command>(fleetNames);

   @Test
   public void testPush() {
      Fleet fleet = new Fleet(blueFleetName);

      Ship ship = new TigerShip.Builder().fleet(fleet).maxSpeed(4).sustainability(70).viewRange(10).build();

      Command queuable = new Command.Builder().commandType(CommandType.PLACE)
            .eventOriginatedLocation(new Coordinate(0, 1))
            .eventOriginator(ship)
            .eventTarget(new Coordinate(10, 12))
            .build();

      battleQueue.push(queuable);

      Command command = battleQueue.pop();
      assertNotNull(command);
      assertThat(command.originateFrom(), equalTo(fleet.getName()));
      assertThat(command.getEventOriginator(), equalTo(ship));
      assertThat(command.getEventOriginatedLocation(), equalTo(ship));
   }

}
