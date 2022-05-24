package domain;

import java.util.*;

public class CarFactory {

    private List<String> splitInput(String inputValue) {
        return Arrays.asList(inputValue.split(","));
    }

    public List<Car> makeCar(String inputValue) {
        List<String> nameList = splitInput(inputValue);
        ArrayList<Car> carList = new ArrayList<>();
        if (isValid(nameList)) {
            for (int i = 0; i < nameList.size(); i++) {
                carList.add(new Car(nameList.get(i)));
            }
        }
        return carList;
    }

    private boolean isValid(List<String> inputValue) {
        if (isBlank(inputValue)) {
            throw new IllegalArgumentException("잘못된 입력값");
        }
        if (isOverFive(inputValue)) {
            throw new IllegalArgumentException("이름 길이 오류");
        }
        if (isDuplicate(inputValue)) {
            throw new IllegalArgumentException("이름 중복");
        }
        return true;
    }

    private boolean isBlank(List<String> stringList) {
        boolean isBlank = false;
        for (String car : stringList) {
            if (car.contains(" ") || car == null) {
                isBlank = true;
                break;
            }
        }
        return isBlank;
    }

    private boolean isOverFive(List<String> stringList) {
        boolean isUnderFive = false;
        for (String car : stringList) {
            if (car.length() > 5) {
                isUnderFive = true;
                break;
            }
        }
        return isUnderFive;
    }

    private boolean isDuplicate(List<String> stringList) {
        boolean isOverlap = false;
        Set<String> setCars = new HashSet<>(stringList);
        if (stringList.size() != setCars.size()) {
            isOverlap = true;
        }
        return isOverlap;
    }

}
