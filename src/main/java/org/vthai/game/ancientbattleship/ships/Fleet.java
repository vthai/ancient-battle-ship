package org.vthai.game.ancientbattleship.ships;

public class Fleet {
   private Ship[] ships;

   private final String name;
   
   public Fleet(String name) {
      this.name = name;
   }

   public Ship[] getShips() {
      return ships;
   }

   public void setShips(Ship[] ships) {
      this.ships = ships;
   }

   public String getName() {
      return name;
   }

}
