package org.vthai.game.ancientbattleship.di;

import org.vthai.game.ancientbattleship.battlefield.validator.RangeValidator;
import org.vthai.game.ancientbattleship.battlefield.validator.Validator;

import se.jbee.inject.bind.BinderModule;


public class OceanBindings extends BinderModule {

   @Override
   protected void declare() {
      bind(Validator.class).to(RangeValidator.class);
   }

}
