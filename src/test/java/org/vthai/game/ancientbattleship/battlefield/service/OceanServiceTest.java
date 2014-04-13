package org.vthai.game.ancientbattleship.battlefield.service;

import static org.easymock.EasyMock.createStrictControl;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.easymock.IMocksControl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.vthai.game.ancientbattleship.battlefield.Ocean;
import org.vthai.game.ancientbattleship.battlefield.coordinate.Coordinate;
import org.vthai.game.ancientbattleship.battlefield.coordinate.OccupiableCoordinate;
import org.vthai.game.ancientbattleship.battlefield.event.Event;
import org.vthai.game.ancientbattleship.battlefield.event.EventType;
import org.vthai.game.ancientbattleship.battlefield.objects.Voidness;
import org.vthai.game.ancientbattleship.battlefield.validator.CoordinateValidator;
import org.vthai.game.ancientbattleship.message.Message;
import org.vthai.game.ancientbattleship.ships.DragonShip;
import org.vthai.game.ancientbattleship.ships.Ship;

public class OceanServiceTest {

   private OceanEventService objectToBeTest;

   private Ocean oceanMock;

   private CoordinateValidator coordinateValidatorMock;
   
   private IMocksControl mockControl;
   
   @Rule
   public ExpectedException thrown = ExpectedException.none();

   @Before
   public void setUp() {
      mockControl = createStrictControl();
      oceanMock = mockControl.createMock(Ocean.class);
      coordinateValidatorMock = mockControl.createMock(CoordinateValidator.class);

      objectToBeTest = new OceanEventServiceImpl(coordinateValidatorMock, oceanMock);
   }

   @Test
   public void testPlaceShip() {
      final Coordinate coordinate = new Coordinate(20, 7);
      Event event = new Event();
      Ship ship = new DragonShip();
      event.setEventOriginator(ship);
      event.setEventTarget(coordinate);
      event.setEventType(EventType.PLACE);
      
      OccupiableCoordinate occupiableCoordinateReturnedByOcean = new OccupiableCoordinate(coordinate.getX(),
            coordinate.getY(), new Voidness());
      expect(oceanMock.queryCoordinate(eq(coordinate.getX()), eq(coordinate.getY()))).andReturn(
            occupiableCoordinateReturnedByOcean);
      coordinateValidatorMock.validate(eq(OceanCannotBePlaceOccupiableException.class),
            eq(Message.getString("ocean.place.ship.error", coordinate.getX(), coordinate.getY())),
            eq(occupiableCoordinateReturnedByOcean), eq(CoordinateValidator.VALIDATE_EMPTY));
      
      //replay(coordinateValidatorMock);
      
      oceanMock.occupyAtCoordinate(coordinate, ship);
      //oceanMock.occupyAtCoordinate(coordinate, ship);

      mockControl.replay();

      objectToBeTest.processEvent(event);

      mockControl.verify();
   }

   @Test
   public void testPlaceShipAlreadyOccupied() {
      final Coordinate theCoordinate = new Coordinate(20, 7);
      Event firstEvent = new Event();
      Ship firstShip = new DragonShip();
      firstEvent.setEventOriginator(firstShip);
      firstEvent.setEventTarget(theCoordinate);
      firstEvent.setEventType(EventType.PLACE);

      Event secondEvent = new Event();
      Ship secondShip = new DragonShip();
      secondEvent.setEventOriginator(secondShip);
      secondEvent.setEventTarget(theCoordinate);
      secondEvent.setEventType(EventType.PLACE);

      // first validation in oceaneventserviceimpl
      OccupiableCoordinate occupiableCoordinateReturnedByOcean = new OccupiableCoordinate(theCoordinate.getX(),
            theCoordinate.getY(), new Voidness());
      expect(oceanMock.queryCoordinate(eq(theCoordinate.getX()), eq(theCoordinate.getY()))).andReturn(
            occupiableCoordinateReturnedByOcean);
      coordinateValidatorMock.validate(eq(OceanCannotBePlaceOccupiableException.class),
            eq(Message.getString("ocean.place.ship.error", theCoordinate.getX(), theCoordinate.getY())),
            eq(occupiableCoordinateReturnedByOcean), eq(CoordinateValidator.VALIDATE_EMPTY));
      oceanMock.occupyAtCoordinate(theCoordinate, firstShip);
      
      // second validation in oceaneventserviceimpl
      occupiableCoordinateReturnedByOcean = new OccupiableCoordinate(theCoordinate.getX(),
            theCoordinate.getY(), firstShip);
      expect(oceanMock.queryCoordinate(eq(theCoordinate.getX()), eq(theCoordinate.getY()))).andReturn(
            occupiableCoordinateReturnedByOcean);
      coordinateValidatorMock.validate(eq(OceanCannotBePlaceOccupiableException.class),
            eq(Message.getString("ocean.place.ship.error", theCoordinate.getX(), theCoordinate.getY())),
            eq(occupiableCoordinateReturnedByOcean), eq(CoordinateValidator.VALIDATE_EMPTY));

      replay(oceanMock);

      thrown.expect(OceanCannotBePlaceOccupiableException.class);
      thrown.expectMessage(Message.getString("ocean.place.ship.error", theCoordinate.getX(), theCoordinate.getY()));

      objectToBeTest.processEvent(firstEvent);
      objectToBeTest.processEvent(secondEvent);

      verify(oceanMock);
   }
}
