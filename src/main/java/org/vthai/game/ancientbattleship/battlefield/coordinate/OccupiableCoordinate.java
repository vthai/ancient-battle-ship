package org.vthai.game.ancientbattleship.battlefield.coordinate;

import org.vthai.game.ancientbattleship.battlefield.objects.Occupiable;
import org.vthai.game.ancientbattleship.message.Message;

public class OccupiableCoordinate extends Coordinate {

   private Occupiable occupiable;

   public OccupiableCoordinate(int x, int y, Occupiable occupiable) {
      super(x, y);
      if(occupiable == null) {
         throw new OceanInvalidOccupiableCoordinateException(Message.getString("ocean.invalid.occupiable.in.coordinate"));
      }
      this.occupiable = occupiable;
   }

   public Occupiable getOccupiable() {
      return occupiable;
   }

   public void setOccupiable(Occupiable occupiable) {
      this.occupiable = occupiable;
   }

   @Override
   public boolean equals(Object obj) {
      if (!obj.getClass().equals(getClass())) {
         return false;
      }
      OccupiableCoordinate target = (OccupiableCoordinate) obj;
      int targetX = target.getX();
      int targetY = target.getY();
      int targetOccupiableId = target.getOccupiable().hashCode();

      return targetX == this.getX() && targetY == this.getY() && targetOccupiableId == this.getOccupiable().hashCode();
   }

}
