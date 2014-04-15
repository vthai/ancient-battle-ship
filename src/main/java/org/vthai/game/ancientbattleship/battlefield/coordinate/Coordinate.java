package org.vthai.game.ancientbattleship.battlefield.coordinate;


public class Coordinate {
   private int x;

   private int y;
   
   public Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
   }
   
   public int getX() {
      return x;
   }

   public int getY() {
      return y;
   }
   
   @Override
   public boolean equals(Object obj) {
      if(!obj.getClass().equals(this.getClass())) {
         return false;
      }
      Coordinate target = (Coordinate) obj;
      return target.getX() == this.getX() && target.getY() == this.getY();
   }
}
