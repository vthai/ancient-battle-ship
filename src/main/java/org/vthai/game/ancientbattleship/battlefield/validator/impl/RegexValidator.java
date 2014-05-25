package org.vthai.game.ancientbattleship.battlefield.validator.impl;

import org.vthai.game.ancientbattleship.battlefield.validator.GenericValidator;

public class RegexValidator extends GenericValidator<String, String> {

   @Override
   public void validate(Class<? extends RuntimeException> exceptionClass, String errorMessage, String value,
         String... arguments) {
      String regex = arguments[0];
      if (!value.matches(regex)) {
         throwExpection(exceptionClass, errorMessage);
      }
   }
}
