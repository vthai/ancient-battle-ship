package org.vthai.game.inttest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.vthai.game.ancientbattleship.AncientBattleShipApp;
import org.vthai.game.ancientbattleship.battlefield.coordinate.Coordinate;
import org.vthai.game.ancientbattleship.battlefield.event.Event;
import org.vthai.game.ancientbattleship.battlefield.event.EventType;
import org.vthai.game.ancientbattleship.battlefield.service.OceanEventService;
import org.vthai.game.ancientbattleship.di.DependencyModule;
import org.vthai.game.ancientbattleship.ships.DragonShip;
import org.vthai.game.ancientbattleship.ships.Ship;

import dagger.ObjectGraph;

public class AncientBattleShipAppInttest {

   private static OceanEventService oceanEventService;

   @BeforeClass
   public static void setupSilkDi() {
      ObjectGraph objectGraph = ObjectGraph.create(new DependencyModule());
      AncientBattleShipApp ancientBattleShipApp = objectGraph.get(AncientBattleShipApp.class);
      oceanEventService = ancientBattleShipApp.getOceanEventService();
   }

   @Test
   public void testOceanInit() {
      Event event = new Event();
      Ship ship = new DragonShip();
      event.setEventOriginator(ship);
      event.setEventTarget(new Coordinate(20, 7));
      event.setEventType(EventType.PLACE);
      
      oceanEventService.processEvent(event);
   }
}
