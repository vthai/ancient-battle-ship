package org.vthai.game.ancientbattleship.ships;

import org.vthai.game.ancientbattleship.battlefield.command.Command;


public class WolfShip extends Ship {
   private WolfShip(Builder builder) {
      super(builder);
      
   }

   public static class Builder extends Ship.Builder<Builder> {
//      private boolean hasGMO = false;
//
//      public Builder weapon(boolean val) {
//         hasGMO = val;
//         return this;
//      }

      public WolfShip build() {
         return new WolfShip(this);
      }
   }

   @Override
   public void absorbEvent(Command event) {
      // TODO Auto-generated method stub
      
   }

}
