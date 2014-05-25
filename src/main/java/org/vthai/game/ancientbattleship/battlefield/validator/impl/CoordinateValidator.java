package org.vthai.game.ancientbattleship.battlefield.validator.impl;

import org.vthai.game.ancientbattleship.battlefield.coordinate.OccupiableCoordinate;
import org.vthai.game.ancientbattleship.battlefield.objects.Voidness;
import org.vthai.game.ancientbattleship.battlefield.validator.GenericValidator;
import org.vthai.game.ancientbattleship.battlefield.validator.exception.ValidationArgumentException;
import org.vthai.game.ancientbattleship.message.Message;

public class CoordinateValidator extends GenericValidator<OccupiableCoordinate, String> {

   public static final String VALIDATE_EMPTY = "coordinateValidateEmpty";

   public static final String VALIDATE_NOT_EMPTY = "coordinateValidateNotEmpty";

   @Override
   public void validate(Class<? extends RuntimeException> exceptionClass, String errorMessage,
         OccupiableCoordinate value, String... arguments) {
      String flag = (String) arguments[0];

      boolean checkPass = false;
      boolean isVoid = (value.getOccupiable().getClass().equals(Voidness.class));

      if (flag.equals(VALIDATE_EMPTY)) {
         checkPass = isVoid;
      } else if (flag.equals(VALIDATE_NOT_EMPTY)) {
         checkPass = !isVoid;
      } else {
         throw new ValidationArgumentException(Message.getString("validator.invalid.argument",
               CoordinateValidator.class, "flag"));
      }

      if (!checkPass) {
         throwExpection(exceptionClass, errorMessage);
      }
   }

}
