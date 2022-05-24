package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingRule {
    private static final String CAR_SHAPE= "🚗";
    private static final int MOVEABLE_CONDITION= 3;
    private final Random random = new Random(10);

    public List<Car> play(List<Car> carList) {
        List<Car> racingList = new ArrayList<>();
        for (Car car : carList) {
            if (canMove()) {
                car.move();
                racingList.add(car);
            }
            System.out.println(getCurrentPosition(car));
        }
        System.out.println("-----------------------");
        return racingList;
    }
    public List<Car> result(List<Car> racingList) {
        List<Integer> positionList = racingList.stream().map(Car::getPosition).toList();
        Integer maxPosition = Collections.max(positionList);
        List<Car> winnerList = racingList.stream().filter(i -> i.getPosition() == maxPosition).collect(Collectors.toList());

        System.out.println("WINNER : ");
        return winnerList;
    }

    private String getCurrentPosition(Car car) {
        StringBuilder current = new StringBuilder();
        current.append(car.getName()).append(" : ");
        for (int i = 0; i < car.getPosition(); i++) {
            current.append(CAR_SHAPE);
        }
        return current.toString();
    }
    private boolean canMove() {
        return MOVEABLE_CONDITION< random.nextInt();
    }
}
