package org.vthai.game.ancientbattleship.battlefield.command;

import org.vthai.game.ancientbattleship.battlefield.coordinate.Coordinate;
import org.vthai.game.ancientbattleship.battlefield.coordinate.OccupiableCoordinate;
import org.vthai.game.ancientbattleship.battlefield.queue.Queuable;
import org.vthai.game.ancientbattleship.ships.Ship;

public class Command implements Queuable {

   private Ship eventOriginator;

   private Coordinate eventOriginatedLocation;

   private Coordinate eventTarget;

   private CommandType commandType;

   public static class Builder {
      private Ship eventOriginator;

      private Coordinate eventOriginatedLocation;

      private Coordinate eventTarget;

      private CommandType commandType;

      public Builder eventOriginator(Ship eventOriginator) {
         this.eventOriginator = eventOriginator;
         return this;
      }

      public Builder eventOriginatedLocation(Coordinate eventOriginatedLocation) {
         this.eventOriginatedLocation = eventOriginatedLocation;
         return this;
      }

      public Builder eventTarget(Coordinate eventTarget) {
         this.eventTarget = eventTarget;
         return this;
      }

      public Builder commandType(CommandType commandType) {
         this.commandType = commandType;
         return this;
      }

      public Command build() {
         return new Command(this);
      }
   }

   private Command(Builder builder) {
      this.eventOriginator = builder.eventOriginator;
      this.eventOriginatedLocation = builder.eventOriginatedLocation;
      this.eventTarget = builder.eventTarget;
      this.commandType = builder.commandType;
   }

   public Ship getEventOriginator() {
      return eventOriginator;
   }

   public Coordinate getEventOriginatedLocation() {
      return eventOriginatedLocation;
   }

   public Coordinate getEventTarget() {
      return eventTarget;
   }

   public CommandType getCommandType() {
      return commandType;
   }

   @Override
   public String originateFrom() {
      return eventOriginator.getFleet().getName();
   }

   @Override
   public boolean isFinalCommand() {
      return commandType.equals(CommandType.ACTION);
   }

}
