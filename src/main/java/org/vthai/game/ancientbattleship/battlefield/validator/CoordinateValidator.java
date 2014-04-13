package org.vthai.game.ancientbattleship.battlefield.validator;

import org.vthai.game.ancientbattleship.battlefield.coordinate.OccupiableCoordinate;
import org.vthai.game.ancientbattleship.battlefield.objects.Voidness;
import org.vthai.game.ancientbattleship.message.Message;

public class CoordinateValidator extends GenericValidator {

   public static final String VALIDATE_EMPTY = "coordinateValidateEmpty";

   public static final String VALIDATE_NOT_EMPTY = "coordinateValidateNotEmpty";

   @Override
   public void validate(Class<? extends RuntimeException> exceptionClass, String errorMessage, Object value,
         Object... arguments) {
      OccupiableCoordinate coordinateToBeExamined = (OccupiableCoordinate) value;
      String flag = (String) arguments[0];

      boolean checkPass = false;
      boolean isVoid = (coordinateToBeExamined.getOccupiable().getClass().equals(Voidness.class));

      if (flag.equals(VALIDATE_EMPTY)) {
         checkPass = isVoid;
      }
      else if (flag.equals(VALIDATE_NOT_EMPTY)) {
         checkPass = !isVoid;
      }
      else {
         throw new ValidationArgumentException(Message.getString("validator.invalid.argument",
               CoordinateValidator.class, "flag"));
      }

      if (!checkPass) {
         throwExpection(exceptionClass, errorMessage);
      }
   }

}
