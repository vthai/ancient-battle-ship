package org.vthai.game.ancientbattleship.ships;

import org.vthai.game.ancientbattleship.battlefield.objects.Occupiable;


public abstract class Ship implements Occupiable {
   
   @Override
   public boolean equals(Object obj) {
      if(!obj.getClass().equals(this.getClass())) {
         return false;
      }
      return obj.hashCode() == this.hashCode();
   }

}
