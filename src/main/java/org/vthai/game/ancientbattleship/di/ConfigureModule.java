package org.vthai.game.ancientbattleship.di;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module(library = true)
public class ConfigureModule {

   @Provides
   @Named("oceanRow")
   public int provideRow() {
      return 100;
   }

   @Provides
   @Named("oceanColumn")
   public int provideColumn() {
      return 50;
   }
}
