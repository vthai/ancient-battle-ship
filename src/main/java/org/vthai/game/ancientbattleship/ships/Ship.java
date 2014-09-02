package org.vthai.game.ancientbattleship.ships;

import org.vthai.game.ancientbattleship.battlefield.objects.Occupiable;

public abstract class Ship implements Occupiable {
   private final Fleet fleet;
   
   private final int maxSpeed;
   
   private final int viewRange;
   
   private int sustainability;

   @SuppressWarnings("rawtypes")
   protected Ship(Builder builder) {
      this.fleet = builder.fleet;
      this.maxSpeed = builder.maxSpeed;
      this.viewRange = builder.viewRange;
      this.sustainability = builder.sustainability;
   }

   public Fleet getFleet() {
      return fleet;
   }
   
   public int getMaxSpeed() {
      return maxSpeed;
   }
   
   public int getViewRange() {
      return viewRange;
   }
   
   public int getSustainability() {
      return sustainability;
   }
   
   @SuppressWarnings("rawtypes")
   public static class Builder<T extends Builder> {
      private Fleet fleet;
      
      private int maxSpeed;
      
      private int viewRange;
      
      private int sustainability;
      
      @SuppressWarnings("unchecked")
      public T fleet(Fleet fleet) { 
         this.fleet = fleet;
         return (T) this; 
      }
      
      @SuppressWarnings("unchecked")
      public T maxSpeed(int maxSpeed) {
         this.maxSpeed = maxSpeed;
         return (T) this;
      }
      
      @SuppressWarnings("unchecked")
      public T viewRange(int viewRange) {
         this.viewRange = viewRange;
         return (T) this;
      }
      
      @SuppressWarnings("unchecked")
      public T sustainability(int sustainability) {
         this.sustainability = sustainability;
         return (T) this;
      }
  }

   @Override
   public boolean equals(Object obj) {
      if (!obj.getClass().equals(this.getClass())) {
         return false;
      }
      return obj.hashCode() == this.hashCode();
   }

}
