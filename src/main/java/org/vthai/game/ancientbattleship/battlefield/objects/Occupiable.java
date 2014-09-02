package org.vthai.game.ancientbattleship.battlefield.objects;

import org.vthai.game.ancientbattleship.battlefield.command.Command;


public interface Occupiable {
   public void absorbEvent(Command event);
}
