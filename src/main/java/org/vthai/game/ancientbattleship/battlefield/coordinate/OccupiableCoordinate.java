package org.vthai.game.ancientbattleship.battlefield.coordinate;

import org.vthai.game.ancientbattleship.battlefield.objects.Occupiable;

public class OccupiableCoordinate extends Coordinate {

   private Occupiable occupiable;

   public OccupiableCoordinate(int x, int y, Occupiable occupiable) {
      super(x, y);
      this.occupiable = occupiable;
   }

   public Occupiable getOccupiable() {
      return occupiable;
   }

   public void setOccupiable(Occupiable occupiable) {
      this.occupiable = occupiable;
   }

}
