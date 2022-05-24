package service;

import domain.Car;
import domain.CarFactory;
import domain.RacingRule;

import java.util.*;

public class RacingService {
    private final RacingRule rule;
    private final CarFactory factory;

    public RacingService(RacingRule rule, CarFactory factory) {
        this.rule = rule;
        this.factory = factory;
    }

    public void start(String carNames, Integer tryCount) {
        List<Car> carList = factory.makeCar(carNames);
        List<Car> racingList = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            racingList = rule.play(carList);
        }
        for (Car car : rule.result(racingList)) {
            System.out.println(car.getName());
        }
    }


}
