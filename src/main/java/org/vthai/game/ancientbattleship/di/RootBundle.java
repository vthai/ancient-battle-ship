package org.vthai.game.ancientbattleship.di;

import se.jbee.inject.bootstrap.BootstrapperBundle;


public class RootBundle extends BootstrapperBundle {

   @Override
   protected void bootstrap() {
      install(OceanModule.class);
   }

}
