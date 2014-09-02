package org.vthai.game.ancientbattleship.battlefield.event;

import java.util.Map;

import org.vthai.game.ancientbattleship.battlefield.coordinate.Coordinate;
import org.vthai.game.ancientbattleship.battlefield.objects.Spendable;

public class Event {
   private Coordinate eventCooridinate;

   private Phenomenon phenomenon;

   private Map<Spendable, Integer> spent;

}
