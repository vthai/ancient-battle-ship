package org.vthai.game.ancientbattleship.battlefield.coordinate;

import org.vthai.game.ancientbattleship.battlefield.objects.Occupiable;

public class Coordinate {

   private int x;

   private int y;

   private Occupiable occupiable;

   public Coordinate(int x, int y, Occupiable occupiable) {
      this.x = x;
      this.y = y;
      this.occupiable = occupiable;
   }

   public int getX() {
      return x;
   }

   public int getY() {
      return y;
   }

   public Occupiable getOccupiable() {
      return occupiable;
   }

   public void setOccupiable(Occupiable occupiable) {
      this.occupiable = occupiable;
   }

}
