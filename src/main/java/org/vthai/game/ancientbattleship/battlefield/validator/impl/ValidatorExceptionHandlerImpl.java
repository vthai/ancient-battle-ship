package org.vthai.game.ancientbattleship.battlefield.validator.impl;

import java.lang.reflect.InvocationTargetException;

import org.vthai.game.ancientbattleship.battlefield.validator.ValidatorExceptionHandler;

public abstract class ValidatorExceptionHandlerImpl implements ValidatorExceptionHandler {

   public void throwExpection(Class<? extends RuntimeException> exceptionClass, String errorMessage) {
      try {
         RuntimeException exception = (RuntimeException) exceptionClass.getConstructor(String.class).newInstance(
               errorMessage);
         throw exception;
      } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
            | NoSuchMethodException | SecurityException e) {
         e.printStackTrace();
      }
   }
}
