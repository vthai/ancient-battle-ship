package org.vthai.game.ancientbattleship.queue;

import org.vthai.game.ancientbattleship.battlefield.event.Event;


public interface OceanEventQueue {
   
   public void putEvent(Event event);
   
   public void registerListener(EventListener listener);
   
   public Event getEventResult();

}
