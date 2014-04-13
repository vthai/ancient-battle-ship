package org.vthai.game.ancientbattleship.battlefield.service;

import static org.easymock.EasyMock.createControl;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.easymock.IMocksControl;
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
      IMocksControl mockControl = createControl();
      mock = mockControl.createMock(Ocean.class);
      objectToBeTest = new OceanEventServiceImpl(mock);
   }
   
   @Test
   public void testPlaceShip() {
      final Coordinate coordinate = new Coordinate(20, 7);
      Event event = new Event();
      Ship ship = new DragonShip();
      event.setEventOriginator(ship);
      event.setEventTarget(coordinate);
      event.setEventType(EventType.PLACE);
      
      mock.occupyAtCoordinate(coordinate, ship);
      
      replay(mock);
      
      objectToBeTest.processEvent(event);
      
      verify(mock);
   }
}
