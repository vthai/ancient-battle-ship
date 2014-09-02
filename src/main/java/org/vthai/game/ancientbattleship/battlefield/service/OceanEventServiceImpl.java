package org.vthai.game.ancientbattleship.battlefield.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.vthai.game.ancientbattleship.battlefield.Ocean;
import org.vthai.game.ancientbattleship.battlefield.command.Command;
import org.vthai.game.ancientbattleship.battlefield.command.CommandType;
import org.vthai.game.ancientbattleship.battlefield.coordinate.Coordinate;
import org.vthai.game.ancientbattleship.battlefield.coordinate.OccupiableCoordinate;
import org.vthai.game.ancientbattleship.battlefield.queue.BattleQueue;
import org.vthai.game.ancientbattleship.battlefield.validator.CoordinateValidator;
import org.vthai.game.ancientbattleship.battlefield.validator.Validator;
import org.vthai.game.ancientbattleship.di.ValidatorModule;
import org.vthai.game.ancientbattleship.message.Message;
import org.vthai.game.ancientbattleship.ships.Fleet;

public class OceanEventServiceImpl implements OceanEventService {

   private Ocean ocean;

   private Validator coordinateValidator;
   
   private Fleet blueFleet;
   
   private Fleet redFleet;
   
   private BattleQueue commandEventQueue;

   @Inject
   public OceanEventServiceImpl(@Named(ValidatorModule.oceanCoordinateValidatorId) Validator coordinateValidator,
         Ocean ocean) {
      this.ocean = ocean;
      this.coordinateValidator = coordinateValidator;
   }

   @Override
   public void recieveCommand(Command command) {
	   
   }
   
   private void processCommand(Command command) {
      CommandType eventType = command.getCommandType();
      Coordinate coordinate = command.getEventTarget();

      switch (eventType) {
         case PLACE:
            OccupiableCoordinate targetCoordinate = ocean.queryCoordinate(coordinate.getX(), coordinate.getY());
            coordinateValidator.validate(OceanCannotBePlaceOccupiableException.class,
                  Message.getString("ocean.place.ship.error", coordinate.getX(), coordinate.getY()), targetCoordinate,
                  CoordinateValidator.VALIDATE_EMPTY);
            ocean.occupyAtCoordinate(coordinate, command.getEventOriginator());
            break;
         case MOVE:
            ocean.removeAtCoordinate(coordinate, command.getEventOriginator());
            ocean.occupyAtCoordinate(coordinate, command.getEventOriginator());
            break;
         case ATTACK:
         case REPAIR:
            OccupiableCoordinate occupiableCoordinate = ocean.queryCoordinate(coordinate.getX(), coordinate.getY());
            occupiableCoordinate.getOccupiable().absorbEvent(command);
            break;
      }
   }

}
