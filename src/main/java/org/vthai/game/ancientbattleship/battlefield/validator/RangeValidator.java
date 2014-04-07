package org.vthai.game.ancientbattleship.battlefield.validator;

import java.lang.reflect.InvocationTargetException;

public class RangeValidator implements Validator {

   private static final int UPPER_BOUND = 1;

   private static final int LOWER_BOUND = 0;

   @Override
   public void validate(Class<? extends RuntimeException> exceptionClass, String errorMessage, Object value, Object... range) {
      int valueToBeValidated = (int) value;
      int upperBound = (int) range[UPPER_BOUND];
      int lowerBound = (int) range[LOWER_BOUND];

      if (valueToBeValidated < lowerBound || valueToBeValidated > upperBound) {
         try {
            RuntimeException exception = (RuntimeException) exceptionClass.getConstructor(String.class).newInstance(
                  errorMessage);
            throw exception;
         }
         catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
               | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
         }
      }
   }
}
