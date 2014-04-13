package org.vthai.game.ancientbattleship.di;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module(library = true)
public class ConfigureModule {

   public static final String oceanRowId = "oceanRow";

   public static final String oceanColumnId = "oceanColumn";

   @Provides
   @Named(ConfigureModule.oceanRowId)
   public int provideRow() {
      return 100;
   }

   @Provides
   @Named(ConfigureModule.oceanColumnId)
   public int provideColumn() {
      return 50;
   }
}
