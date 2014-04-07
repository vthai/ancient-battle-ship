package org.vthai.game.ancientbattleship.battlefield.service;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;

import org.junit.Before;
import org.junit.Test;
import org.vthai.game.ancientbattleship.battlefield.Ocean;
import org.vthai.game.ancientbattleship.battlefield.coordinate.Coordinate;
import org.vthai.game.ancientbattleship.battlefield.event.Event;
import org.vthai.game.ancientbattleship.battlefield.event.EventType;
import org.vthai.game.ancientbattleship.ships.DragonShip;
import org.vthai.game.ancientbattleship.ships.Ship;


public class OceanServiceTest {
   private OceanEventService objectToBeTest;
   
   private Ocean mock;
   
   @Before
   public void setUp() {
      mock = createMock(Ocean.class);
      objectToBeTest = new OceanEventServiceImpl(mock);
   }
   
   @Test
   public void testPlaceShip() {
      
      replay(mock);
      
      Event event = new Event();
      Ship ship = new DragonShip();
      event.setEventOriginator(ship);
      event.setEventTarget(new Coordinate(20, 7));
      event.setEventType(EventType.PLACE);
      
      objectToBeTest.processEvent(event);
   }
}
