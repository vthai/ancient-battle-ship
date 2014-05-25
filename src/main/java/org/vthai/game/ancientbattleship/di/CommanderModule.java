package org.vthai.game.ancientbattleship.di;

import javax.inject.Named;
import javax.inject.Singleton;

import org.vthai.game.ancientbattleship.battlefield.Commander;

import dagger.Module;
import dagger.Provides;

@Module(library = true)
public class CommanderModule {
   public static final String commanderPartyA = "commanderA";
   public static final String commanderPartyB = "commanderB";

   @Provides
   @Singleton
   @Named(CommanderModule.commanderPartyA)
   public Commander providesCommanderA() {
      return new Commander();
   }
   
   @Provides
   @Singleton
   @Named(CommanderModule.commanderPartyB)
   public Commander providesCommanderB() {
      return new Commander();
   }
}
