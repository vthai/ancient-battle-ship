package org.vthai.game.ancientbattleship.battlefield.queue;

import java.util.LinkedList;
import java.util.Queue;

public class BattleQueue<T extends Queuable> {
   private String[] nameOfTwoFleets;

   private String currentFleetInAction;

   private Queue<T> queue;

   public BattleQueue(String[] nameOfTwoFleets) {
      this.nameOfTwoFleets = nameOfTwoFleets;
      queue = new LinkedList<T>();
      currentFleetInAction = nameOfTwoFleets[0];
   }

   public void push(T queuable) {
      if (!queuable.originateFrom().equals(currentFleetInAction)) {
         throw new IllegalArgumentException("Wait for your turn please");
      }

      queue.add(queuable);

      if (queuable.isFinalCommand()) {
         switchTurn();
      }
   }

   public T pop() {
      return queue.poll();
   }

   private void switchTurn() {
      if (currentFleetInAction.equals(nameOfTwoFleets[0])) {
         currentFleetInAction = nameOfTwoFleets[1];
      } else {
         currentFleetInAction = nameOfTwoFleets[0];
      }
   }
}
