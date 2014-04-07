package org.vthai.game.ancientbattleship.battlefield;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.vthai.game.ancientbattleship.battlefield.coordinate.Coordinate;
import org.vthai.game.ancientbattleship.battlefield.coordinate.OccupiableCoordinate;
import org.vthai.game.ancientbattleship.battlefield.coordinate.OceanInvalidCoordinatesException;
import org.vthai.game.ancientbattleship.battlefield.objects.Voidness;
import org.vthai.game.ancientbattleship.message.Message;
import org.vthai.game.ancientbattleship.ships.DragonShip;
import org.vthai.game.ancientbattleship.ships.Ship;

public class OceanTest {

   private Random random;

   @Rule
   public ExpectedException thrown = ExpectedException.none();

   @Before
   public void setUp() {
      random = new Random(System.currentTimeMillis());
   }

   @Test
   public void testOceanInit() {
      final int row = 100;
      final int column = 50;

      Ocean ocean = new Ocean(row, column);

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
      final int row = 100;
      final int column = 50;

      Ocean ocean = new Ocean(row, column);

      int randomX = column + random.nextInt(column);
      int randomY = random.nextInt(row);

      thrown.expect(OceanInvalidCoordinatesException.class);
      thrown.expectMessage(Message.getString("ocean.invalid.coordinate.x", column));

      ocean.queryCoordinate(randomX, randomY);
   }

   @Test
   public void testOceanInitShouldThrowExceptionIfCoordinateExceedsRow() {
      final int row = 100;
      final int column = 50;

      Ocean ocean = new Ocean(row, column);

      int randomX = random.nextInt(column);
      int randomY = row + random.nextInt(row);

      thrown.expect(OceanInvalidCoordinatesException.class);
      thrown.expectMessage(Message.getString("ocean.invalid.coordinate.y", row));

      ocean.queryCoordinate(randomX, randomY);
   }

   @Test
   public void testOccupyACoordinate() {
      final int row = 100;
      final int column = 50;

      Ocean ocean = new Ocean(row, column);

      Ship ship = new DragonShip();
      Coordinate coordinate = new Coordinate(20, 10);

      ocean.occupyAtCoordinate(coordinate, ship);

      OccupiableCoordinate occupiableCoordinate = ocean.queryCoordinate(coordinate.getX(), coordinate.getY());
      assertThat(occupiableCoordinate.getOccupiable().hashCode(), equalTo(ship.hashCode()));
   }
   
   @Test
   public void testOccupyACoordinateCheckSurrond() {
      final int row = 100;
      final int column = 50;

      Ocean ocean = new Ocean(row, column);

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
