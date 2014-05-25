package org.vthai.game.ancientbattleship.battlefield.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.vthai.game.ancientbattleship.battlefield.Ocean;
import org.vthai.game.ancientbattleship.battlefield.coordinate.Coordinate;
import org.vthai.game.ancientbattleship.battlefield.coordinate.OccupiableCoordinate;
import org.vthai.game.ancientbattleship.battlefield.event.Event;
import org.vthai.game.ancientbattleship.battlefield.event.EventType;
import org.vthai.game.ancientbattleship.battlefield.validator.Validator;
import org.vthai.game.ancientbattleship.battlefield.validator.impl.CoordinateValidator;
import org.vthai.game.ancientbattleship.di.ValidatorModule;
import org.vthai.game.ancientbattleship.message.Message;

public class OceanEventServiceImpl implements OceanEventService {

   private Ocean ocean;

   private Validator<OccupiableCoordinate, String> coordinateValidator;

   @Inject
   public OceanEventServiceImpl(
         @Named(ValidatorModule.oceanCoordinateValidatorId) Validator<OccupiableCoordinate, String> coordinateValidator,
         Ocean ocean) {
      this.ocean = ocean;
      this.coordinateValidator = coordinateValidator;
   }

   @Override
   public void processEvent(Event event) {
      EventType eventType = event.getEventType();
      Coordinate coordinate = event.getEventTarget();

      switch (eventType) {
         case PLACE:
            OccupiableCoordinate targetCoordinate = ocean.queryCoordinate(coordinate.getX(), coordinate.getY());
            String errorMessage = Message.getString("ocean.place.ship.error", coordinate.getX(), coordinate.getY());
            
            coordinateValidator.validate(OceanCannotBePlaceOccupiableException.class, errorMessage, targetCoordinate,
                  CoordinateValidator.VALIDATE_EMPTY);
            ocean.occupyAtCoordinate(coordinate, event.getEventOriginator());
            break;
         case MOVE:
            ocean.removeAtCoordinate(coordinate, event.getEventOriginator());
            ocean.occupyAtCoordinate(coordinate, event.getEventOriginator());
            break;
         case ATTACK:
         case REPAIR:
            OccupiableCoordinate occupiableCoordinate = ocean.queryCoordinate(coordinate.getX(), coordinate.getY());
            occupiableCoordinate.getOccupiable().absorbEvent(event);
            break;
      }
   }

}
