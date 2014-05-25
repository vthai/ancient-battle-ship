package org.vthai.game.ancientbattleship.battlefield.validator.impl;

public class FloatComparisonValidator extends ComparisonValidatorImpl<Float> {

   public void validate(Class<? extends RuntimeException> exceptionClass, String errorMessage, float value,
         float lowerBound, float upperBound) {
      super.validate(exceptionClass, errorMessage, (Float) value, (Float) lowerBound, (Float) upperBound);
   }
}
