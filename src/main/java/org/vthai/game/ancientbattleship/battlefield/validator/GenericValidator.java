package org.vthai.game.ancientbattleship.battlefield.validator;

import java.lang.reflect.InvocationTargetException;

public abstract class GenericValidator implements Validator {

   protected void throwExpection(Class<? extends RuntimeException> exceptionClass, String errorMessage) {
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
