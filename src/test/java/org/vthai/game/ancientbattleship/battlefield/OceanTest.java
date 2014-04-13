package org.vthai.game.ancientbattleship.battlefield;

import static org.easymock.EasyMock.createControl;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.easymock.IMocksControl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.vthai.game.ancientbattleship.battlefield.coordinate.Coordinate;
import org.vthai.game.ancientbattleship.battlefield.coordinate.OccupiableCoordinate;
import org.vthai.game.ancientbattleship.battlefield.coordinate.OceanInvalidCoordinatesException;
import org.vthai.game.ancientbattleship.battlefield.objects.Voidness;
import org.vthai.game.ancientbattleship.battlefield.validator.Validator;
import org.vthai.game.ancientbattleship.message.Message;
import org.vthai.game.ancientbattleship.ships.DragonShip;
import org.vthai.game.ancientbattleship.ships.Ship;

public class OceanTest {

   private Random random;

   private Validator rangeValidatorMock;

   private Ocean ocean;

   private final int row = 100;

   private final int column = 50;

   @Rule
   public ExpectedException thrown = ExpectedException.none();

   @Before
   public void setUp() {
      random = new Random(System.currentTimeMillis());
      
      IMocksControl mockControl = createControl();
      rangeValidatorMock = mockControl.createMock(Validator.class);
      ocean = new Ocean(rangeValidatorMock, row, column);
   }

   @Test
   public void testOceanInit() {

      OccupiableCoordinate coordinateToBeExamined = ocean.queryCoordinate(0, 0);
      assertThat(coordinateToBeExamined.getX(), equalTo(0));
      assertThat(coordinateToBeExamined.getY(), equalTo(0));

      int randomX = random.nextInt(column);
      int randomY = random.nextInt(row);

      coordinateToBeExamined = ocean.queryCoordinate(randomX, randomY);
      assertThat(coordinateToBeExamined.getX(), equalTo(randomX));
      assertThat(coordinateToBeExamined.getY(), equalTo(randomY));

      coordinateToBeExamined = ocean.queryCoordinate(column - 1, row - 1);
      assertThat(coordinateToBeExamined.getX(), equalTo(column - 1));
      assertThat(coordinateToBeExamined.getY(), equalTo(row - 1));
   }

   @Test
   public void testOceanInitShouldThrowExceptionIfCoordinateExceedsColumn() {
      int randomX = column + random.nextInt(column);
      int randomY = random.nextInt(row);

      rangeValidatorMock.validate(eq(OceanInvalidCoordinatesException.class),
            eq(Message.getString("ocean.invalid.coordinate.x", column)), eq(randomX), eq(0), eq(column));

      rangeValidatorMock.validate(eq(OceanInvalidCoordinatesException.class),
            eq(Message.getString("ocean.invalid.coordinate.y", row)), eq(randomY), eq(0), eq(row));
      expectLastCall().andThrow(
            new OceanInvalidCoordinatesException(Message.getString("ocean.invalid.coordinate.x", column)));

      replay(rangeValidatorMock);

      thrown.expect(OceanInvalidCoordinatesException.class);
      thrown.expectMessage(Message.getString("ocean.invalid.coordinate.x", column));
      
      ocean.queryCoordinate(randomX, randomY);

      verify(rangeValidatorMock);
   }

   @Test
   public void testOceanInitShouldThrowExceptionIfCoordinateExceedsRow() {
      int randomX = random.nextInt(column);
      int randomY = row + random.nextInt(row);

      rangeValidatorMock.validate(eq(OceanInvalidCoordinatesException.class),
            eq(Message.getString("ocean.invalid.coordinate.x", column)), eq(randomX), eq(0), eq(column));

      rangeValidatorMock.validate(eq(OceanInvalidCoordinatesException.class),
            eq(Message.getString("ocean.invalid.coordinate.y", row)), eq(randomY), eq(0), eq(row));
      expectLastCall().andThrow(
            new OceanInvalidCoordinatesException(Message.getString("ocean.invalid.coordinate.y", row)));

      replay(rangeValidatorMock);

      thrown.expect(OceanInvalidCoordinatesException.class);
      thrown.expectMessage(Message.getString("ocean.invalid.coordinate.y", row));
      
      ocean.queryCoordinate(randomX, randomY);

      verify(rangeValidatorMock);
   }

   @Test
   public void testOccupyACoordinate() {
      Ship ship = new DragonShip();
      Coordinate coordinate = new Coordinate(20, 10);

      ocean.occupyAtCoordinate(coordinate, ship);

      OccupiableCoordinate occupiableCoordinate = ocean.queryCoordinate(coordinate.getX(), coordinate.getY());
      assertThat(occupiableCoordinate.getOccupiable().hashCode(), equalTo(ship.hashCode()));
   }

   @Test
   public void testOccupyACoordinateCheckSurrond() {
      Ship ship = new DragonShip();
      Coordinate coordinate = new Coordinate(20, 10);

      ocean.occupyAtCoordinate(coordinate, ship);

      OccupiableCoordinate occupiableCoordinate = ocean.queryCoordinate(coordinate.getX(), coordinate.getY());
      assertThat(occupiableCoordinate.getOccupiable().hashCode(), equalTo(ship.hashCode()));

      int randomX = random.nextInt(column);
      int randomY = random.nextInt(row);
      OccupiableCoordinate randomCoordinate = ocean.queryCoordinate(randomX, randomY);
      assertThat(randomCoordinate.getOccupiable(), instanceOf(Voidness.class));
   }
}
