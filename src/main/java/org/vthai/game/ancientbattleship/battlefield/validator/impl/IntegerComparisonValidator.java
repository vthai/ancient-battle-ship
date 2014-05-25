package org.vthai.game.ancientbattleship.battlefield.validator.impl;

public class IntegerComparisonValidator extends ComparisonValidatorImpl<Integer> {

   public void validate(Class<? extends RuntimeException> exceptionClass, String errorMessage, int value,
         int lowerBound, int upperBound) {
      super.validate(exceptionClass, errorMessage, (Integer) value, (Integer) lowerBound, (Integer) upperBound);
   }
}
